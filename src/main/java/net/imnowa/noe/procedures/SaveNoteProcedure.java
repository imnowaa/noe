package net.imnowa.noe.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.widget.TextFieldWidget;

import net.imnowa.noe.init.NoeModItems;

import java.util.HashMap;

public class SaveNoteProcedure {
	public static void execute(IWorld world, double x, double y, double z, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if ((entity instanceof LivingEntity ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == NoeModItems.TABLETTE.get()) {
			(entity instanceof LivingEntity ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag().putString("Notes", (guistate.containsKey("text:Notes") ? ((TextFieldWidget) guistate.get("text:Notes")).getText() : ""));
		} else if ((entity instanceof LivingEntity ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem() == NoeModItems.TABLETTE.get()) {
			(entity instanceof LivingEntity ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getOrCreateTag().putString("Notes", (guistate.containsKey("text:Notes") ? ((TextFieldWidget) guistate.get("text:Notes")).getText() : ""));
		}
		if (world instanceof World) {
			if (!((World) world).isRemote()) {
				((World) world).playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("noe:typing")), SoundCategory.NEUTRAL, (float) 0.2, 1);
			} else {
				((World) world).playSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("noe:typing")), SoundCategory.NEUTRAL, (float) 0.2, 1, false);
			}
		}
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).closeScreen();
	}
}
