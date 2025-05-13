package net.imnowa.noe.procedures;

import net.minecraft.entity.Entity;

public class NbtLanterneProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putString("tagName", "lanterne");
	}
}
