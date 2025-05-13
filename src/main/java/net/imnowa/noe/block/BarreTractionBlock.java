
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

public class BarreTractionBlock extends Block {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

	public BarreTractionBlock() {
		super(Block.Properties.create((new Material.Builder(MaterialColor.AIR)).build()).sound(SoundType.METAL).hardnessAndResistance(2f, 10f).harvestLevel(1).harvestTool(ToolType.PICKAXE).notSolid().setOpaque((bs, br, bp) -> false));
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}

	@OnlyIn(Dist.CLIENT)
	public static void registerRenderLayer() {
		RenderTypeLookup.setRenderLayer(NoeModBlocks.BARRE_TRACTION.get(), RenderType.getCutout());
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
				return VoxelShapes.or(makeCuboidShape(17, -16, -0.25, 19, -14, 16.25), makeCuboidShape(17, -14, 7, 19, 26, 9), makeCuboidShape(-3, -14, 7, -1, 26, 9), makeCuboidShape(-4, 22.25, 7.25, 20, 23.75, 8.75),
						makeCuboidShape(-3, -16, -0.25, -1, -14, 16.25));
			case NORTH :
				return VoxelShapes.or(makeCuboidShape(-3, -16, -0.25, -1, -14, 16.25), makeCuboidShape(-3, -14, 7, -1, 26, 9), makeCuboidShape(17, -14, 7, 19, 26, 9), makeCuboidShape(-4, 22.25, 7.25, 20, 23.75, 8.75),
						makeCuboidShape(17, -16, -0.25, 19, -14, 16.25));
			case EAST :
				return VoxelShapes.or(makeCuboidShape(-0.25, -16, -3, 16.25, -14, -1), makeCuboidShape(7, -14, -3, 9, 26, -1), makeCuboidShape(7, -14, 17, 9, 26, 19), makeCuboidShape(7.25, 22.25, -4, 8.75, 23.75, 20),
						makeCuboidShape(-0.25, -16, 17, 16.25, -14, 19));
			default :
				return VoxelShapes.or(makeCuboidShape(-0.25, -16, 17, 16.25, -14, 19), makeCuboidShape(7, -14, 17, 9, 26, 19), makeCuboidShape(7, -14, -3, 9, 26, -1), makeCuboidShape(7.25, 22.25, -4, 8.75, 23.75, 20),
						makeCuboidShape(-0.25, -16, -3, 16.25, -14, -1));
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
