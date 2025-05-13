
package net.imnowa.noe.block;

import net.minecraftforge.common.ToolType;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import net.minecraft.util.Direction;
import net.minecraft.state.StateContainer;
import net.minecraft.state.DirectionProperty;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.imnowa.noe.init.NoeModBlocks;

public class BancAbdoBlock extends Block {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

	public BancAbdoBlock() {
		super(Block.Properties.create((new Material.Builder(MaterialColor.AIR)).build()).sound(SoundType.METAL).hardnessAndResistance(2f, 10f).harvestLevel(1).harvestTool(ToolType.PICKAXE).notSolid().setOpaque((bs, br, bp) -> false));
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}

	@OnlyIn(Dist.CLIENT)
	public static void registerRenderLayer() {
		RenderTypeLookup.setRenderLayer(NoeModBlocks.BANC_ABDO.get(), RenderType.getCutout());
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
				return VoxelShapes.or(makeCuboidShape(17, 0, -10, 19, 32, -8), makeCuboidShape(0, 8, -14, 16, 10, 25), makeCuboidShape(3, 0, 13, 13, 8, 18.5), makeCuboidShape(-3, 0, -10, -1, 32, -8),
						makeCuboidShape(-2.75, 25.25, -14, -1.25, 26.75, -10), makeCuboidShape(17.25, 25.25, -14, 18.75, 26.75, -10));
			case NORTH :
				return VoxelShapes.or(makeCuboidShape(-3, 0, 24, -1, 32, 26), makeCuboidShape(0, 8, -9, 16, 10, 30), makeCuboidShape(3, 0, -2.5, 13, 8, 3), makeCuboidShape(17, 0, 24, 19, 32, 26), makeCuboidShape(17.25, 25.25, 26, 18.75, 26.75, 30),
						makeCuboidShape(-2.75, 25.25, 26, -1.25, 26.75, 30));
			case EAST :
				return VoxelShapes.or(makeCuboidShape(-10, 0, -3, -8, 32, -1), makeCuboidShape(-14, 8, 0, 25, 10, 16), makeCuboidShape(13, 0, 3, 18.5, 8, 13), makeCuboidShape(-10, 0, 17, -8, 32, 19),
						makeCuboidShape(-14, 25.25, 17.25, -10, 26.75, 18.75), makeCuboidShape(-14, 25.25, -2.75, -10, 26.75, -1.25));
			default :
				return VoxelShapes.or(makeCuboidShape(24, 0, 17, 26, 32, 19), makeCuboidShape(-9, 8, 0, 30, 10, 16), makeCuboidShape(-2.5, 0, 3, 3, 8, 13), makeCuboidShape(24, 0, -3, 26, 32, -1), makeCuboidShape(26, 25.25, -2.75, 30, 26.75, -1.25),
						makeCuboidShape(26, 25.25, 17.25, 30, 26.75, 18.75));
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
