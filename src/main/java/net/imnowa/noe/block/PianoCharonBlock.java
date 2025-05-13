
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
import net.minecraft.block.FallingBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.imnowa.noe.init.NoeModBlocks;

public class PianoCharonBlock extends FallingBlock {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

	public PianoCharonBlock() {
		super(Block.Properties.create((new Material.Builder(MaterialColor.AIR)).build()).sound(SoundType.WOOD).hardnessAndResistance(1f, 10f).harvestLevel(0).harvestTool(ToolType.AXE).notSolid().setOpaque((bs, br, bp) -> false));
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}

	@OnlyIn(Dist.CLIENT)
	public static void registerRenderLayer() {
		RenderTypeLookup.setRenderLayer(NoeModBlocks.PIANO_CHARON.get(), RenderType.getCutout());
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
				return VoxelShapes.or(makeCuboidShape(-6, 0, 0, 22, 16, 16), makeCuboidShape(-6, 16, 0, 22, 32, 8));
			case NORTH :
				return VoxelShapes.or(makeCuboidShape(-6, 0, 0, 22, 16, 16), makeCuboidShape(-6, 16, 8, 22, 32, 16));
			case EAST :
				return VoxelShapes.or(makeCuboidShape(0, 0, -6, 16, 16, 22), makeCuboidShape(0, 16, -6, 8, 32, 22));
			default :
				return VoxelShapes.or(makeCuboidShape(0, 0, -6, 16, 16, 22), makeCuboidShape(8, 16, -6, 16, 32, 22));
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
