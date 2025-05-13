
package net.imnowa.noe.block;

import net.minecraftforge.common.ToolType;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.util.ActionResultType;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.state.StateContainer;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.HorizontalFaceBlock;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.imnowa.noe.procedures.CamSwitchProcedure;
import net.imnowa.noe.init.NoeModBlocks;

public class CamOnBlock extends Block {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	public static final EnumProperty<AttachFace> FACE = HorizontalFaceBlock.FACE;

	public CamOnBlock() {
		super(Block.Properties.create((new Material.Builder(MaterialColor.AIR)).build()).sound(SoundType.METAL).hardnessAndResistance(3f, 10f).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).doesNotBlockMovement().notSolid()
				.setOpaque((bs, br, bp) -> false));
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(FACE, AttachFace.WALL));
	}

	@OnlyIn(Dist.CLIENT)
	public static void registerRenderLayer() {
		RenderTypeLookup.setRenderLayer(NoeModBlocks.CAM_ON.get(), RenderType.getCutout());
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
				switch ((AttachFace) state.get(FACE)) {
					case FLOOR :
						return makeCuboidShape(6, 0, 6, 10, 2.5, 10);
					case WALL :
						return makeCuboidShape(6, 6, 0, 10, 10, 2.5);
					default :
						return makeCuboidShape(6, 13.5, 6, 10, 16, 10);
				}
			case NORTH :
				switch ((AttachFace) state.get(FACE)) {
					case FLOOR :
						return makeCuboidShape(6, 0, 6, 10, 2.5, 10);
					case WALL :
						return makeCuboidShape(6, 6, 13.5, 10, 10, 16);
					default :
						return makeCuboidShape(6, 13.5, 6, 10, 16, 10);
				}
			case EAST :
				switch ((AttachFace) state.get(FACE)) {
					case FLOOR :
						return makeCuboidShape(6, 0, 6, 10, 2.5, 10);
					case WALL :
						return makeCuboidShape(0, 6, 6, 2.5, 10, 10);
					default :
						return makeCuboidShape(6, 13.5, 6, 10, 16, 10);
				}
			default :
				switch ((AttachFace) state.get(FACE)) {
					case FLOOR :
						return makeCuboidShape(6, 0, 6, 10, 2.5, 10);
					case WALL :
						return makeCuboidShape(13.5, 6, 6, 16, 10, 10);
					default :
						return makeCuboidShape(6, 13.5, 6, 10, 16, 10);
				}
		}
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(FACING, FACE);
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		if (context.getFace().getAxis() == Direction.Axis.Y)
			return super.getStateForPlacement(context).with(FACE, context.getFace().getOpposite() == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR).with(FACING, context.getPlacementHorizontalFacing());
		return super.getStateForPlacement(context).with(FACE, AttachFace.WALL).with(FACING, context.getFace());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}

	@Override
	public ActionResultType onBlockActivated(BlockState blockstate, World world, BlockPos pos, PlayerEntity entity, Hand hand, BlockRayTraceResult hit) {
		super.onBlockActivated(blockstate, world, pos, entity, hand, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getHitVec().x;
		double hitY = hit.getHitVec().y;
		double hitZ = hit.getHitVec().z;
		Direction direction = hit.getFace();
		CamSwitchProcedure.execute(world, x, y, z, entity);
		return ActionResultType.SUCCESS;
	}
}
