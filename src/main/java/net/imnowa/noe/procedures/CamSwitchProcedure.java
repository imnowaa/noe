package net.imnowa.noe.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.Property;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.block.BlockState;

import net.imnowa.noe.init.NoeModBlocks;

import java.util.Map;

public class CamSwitchProcedure {
	public static void execute(IWorld world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayerEntity) {
					return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
				} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId()) != null
							&& Minecraft.getInstance().getConnection().getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId()).getGameType() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity)) == true) {
			if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == NoeModBlocks.CAM_OFF.get()) {
				{
					BlockPos _bp = new BlockPos(x, y, z);
					BlockState _bs = NoeModBlocks.CAM_ON.get().getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
						if (_property != null && _bs.get(_property) != null)
							try {
								_bs = _bs.with(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlockState(_bp, _bs, 3);
				}
			} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == NoeModBlocks.CAM_ON.get()) {
				{
					BlockPos _bp = new BlockPos(x, y, z);
					BlockState _bs = NoeModBlocks.CAM_OFF.get().getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
						if (_property != null && _bs.get(_property) != null)
							try {
								_bs = _bs.with(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlockState(_bp, _bs, 3);
				}
			}
		}
	}
}
