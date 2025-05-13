package net.imnowa.noe.procedures;

import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.imnowa.noe.init.NoeModItems;

public class TablettePhotoRCProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		String notes = "";
		if ((entity instanceof LivingEntity ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == NoeModItems.TABLETTE_PHOTO.get()) {
			notes = (entity instanceof LivingEntity ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag().getString("Notes");
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(NoeModItems.TABLETTE.get()).copy();
				_setstack.setCount(1);
				((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).inventory.markDirty();
			}
			(entity instanceof LivingEntity ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag().putString("Notes", notes);
		} else if ((entity instanceof LivingEntity ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem() == NoeModItems.TABLETTE_PHOTO.get()) {
			notes = (entity instanceof LivingEntity ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getOrCreateTag().getString("Notes");
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(NoeModItems.TABLETTE.get()).copy();
				_setstack.setCount(1);
				((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).inventory.markDirty();
			}
			(entity instanceof LivingEntity ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getOrCreateTag().putString("Notes", notes);
		}
	}
}
