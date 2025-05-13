package net.imnowa.noe.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.imnowa.noe.init.NoeModItems;

public class TabOnToOffProcedure {
	public static void execute(IWorld world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String notes = "";
		if ((entity instanceof LivingEntity ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == NoeModItems.TABLETTE.get()) {
			notes = (entity instanceof LivingEntity ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag().getString("Notes");
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(NoeModItems.TABLETTE_OFF.get()).copy();
				_setstack.setCount(1);
				((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).inventory.markDirty();
			}
			(entity instanceof LivingEntity ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag().putString("Notes", notes);
			if (world instanceof World) {
				if (!((World) world).isRemote()) {
					((World) world).playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("noe:powerup")), SoundCategory.NEUTRAL, (float) 0.1, 1);
				} else {
					((World) world).playSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("noe:powerup")), SoundCategory.NEUTRAL, (float) 0.1, 1, false);
				}
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).closeScreen();
		} else if ((entity instanceof LivingEntity ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem() == NoeModItems.TABLETTE.get()) {
			notes = (entity instanceof LivingEntity ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getOrCreateTag().getString("Notes");
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(NoeModItems.TABLETTE_OFF.get()).copy();
				_setstack.setCount(1);
				((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).inventory.markDirty();
			}
			(entity instanceof LivingEntity ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getOrCreateTag().putString("Notes", notes);
			if (world instanceof World) {
				if (!((World) world).isRemote()) {
					((World) world).playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("noe:powerup")), SoundCategory.NEUTRAL, (float) 0.1, 1);
				} else {
					((World) world).playSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("noe:powerup")), SoundCategory.NEUTRAL, (float) 0.1, 1, false);
				}
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).closeScreen();
		}
	}
}
