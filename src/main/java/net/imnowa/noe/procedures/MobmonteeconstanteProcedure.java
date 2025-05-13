package net.imnowa.noe.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.imnowa.noe.NoeMod;

public class MobmonteeconstanteProcedure {
	public static void execute(IWorld world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPosY() < 255) {
			entity.addVelocity((Math.cos(entity.rotationYaw) * 0.005), 0.005, (Math.sin(entity.rotationYaw) * 0.005));
		} else {
			NoeMod.queueServerWork(200, () -> {
				entity.attackEntityFrom(DamageSource.GENERIC, 500);
			});
		}
	}
}
