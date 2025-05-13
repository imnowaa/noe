
package net.imnowa.noe.block;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.util.Direction;
import net.minecraft.state.StateContainer;
import net.minecraft.state.DirectionProperty;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.imnowa.noe.init.NoeModBlocks;

public class SacdeFrappeBlock extends Block {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

	public SacdeFrappeBlock() {
		super(Block.Properties.create((new Material.Builder(MaterialColor.AIR)).build())
				.sound(new ForgeSoundType(1.0f, 1.0f, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wool.break")), () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wool.step")),
						() -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wool.place")), () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("noe:punchbag")),
						() -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wool.fall"))))
				.hardnessAndResistance(1f, 10f).notSolid().setOpaque((bs, br, bp) -> false));
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}

	@OnlyIn(Dist.CLIENT)
	public static void registerRenderLayer() {
		RenderTypeLookup.setRenderLayer(NoeModBlocks.SACDE_FRAPPE.get(), RenderType.getCutout());
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getRaytraceShape(BlockState state, IBlockReader world, BlockPos pos) {
		return VoxelShapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
		switch ((Direction) state.get(FACING)) {
			case SOUTH :
				return VoxelShapes.or(makeCuboidShape(2.75, -11.5, 5.75, 13.25, 23, 16.25), makeCuboidShape(2.75, 23, 0, 13.25, 29, 14));
			case NORTH :
				return VoxelShapes.or(makeCuboidShape(2.75, -11.5, -0.25, 13.25, 23, 10.25), makeCuboidShape(2.75, 23, 2, 13.25, 29, 16));
			case EAST :
				return VoxelShapes.or(makeCuboidShape(5.75, -11.5, 2.75, 16.25, 23, 13.25), makeCuboidShape(0, 23, 2.75, 14, 29, 13.25));
			default :
				return VoxelShapes.or(makeCuboidShape(-0.25, -11.5, 2.75, 10.25, 23, 13.25), makeCuboidShape(2, 23, 2.75, 16, 29, 13.25));
		}
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return super.getStateForPlacement(context).with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}
}
