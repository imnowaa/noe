package net.imnowa.noe.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.imnowa.noe.world.inventory.TabletteGUIMenu;
import net.imnowa.noe.init.NoeModItems;

import io.netty.buffer.Unpooled;

public class TabOffToOnProcedure {
	public static void execute(IWorld world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String photo = "";
		if ((entity instanceof LivingEntity ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == NoeModItems.TABLETTE_OFF.get()) {
			photo = (entity instanceof LivingEntity ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag().getString("Notes");
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(NoeModItems.TABLETTE.get()).copy();
				_setstack.setCount(1);
				((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).inventory.markDirty();
			}
			(entity instanceof LivingEntity ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag().putString("Notes", photo);
			if (entity instanceof ServerPlayerEntity) {
				BlockPos _bpos = new BlockPos(x, y, z);
				NetworkHooks.openGui((ServerPlayerEntity) entity, new INamedContainerProvider() {
					@Override
					public ITextComponent getDisplayName() {
						return new StringTextComponent("TabletteGUI");
					}

					@Override
					public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
						return new TabletteGUIMenu(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
			if (world instanceof World) {
				if (!((World) world).isRemote()) {
					((World) world).playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("noe:powerup")), SoundCategory.NEUTRAL, (float) 0.1, 1);
				} else {
					((World) world).playSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("noe:powerup")), SoundCategory.NEUTRAL, (float) 0.1, 1, false);
				}
			}
		} else if ((entity instanceof LivingEntity ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem() == NoeModItems.TABLETTE_OFF.get()) {
			photo = (entity instanceof LivingEntity ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getOrCreateTag().getString("Notes");
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(NoeModItems.TABLETTE.get()).copy();
				_setstack.setCount(1);
				((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).inventory.markDirty();
			}
			(entity instanceof LivingEntity ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getOrCreateTag().putString("Notes", photo);
			if (entity instanceof ServerPlayerEntity) {
				BlockPos _bpos = new BlockPos(x, y, z);
				NetworkHooks.openGui((ServerPlayerEntity) entity, new INamedContainerProvider() {
					@Override
					public ITextComponent getDisplayName() {
						return new StringTextComponent("TabletteGUI");
					}

					@Override
					public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
						return new TabletteGUIMenu(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
			if (world instanceof World) {
				if (!((World) world).isRemote()) {
					((World) world).playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("noe:powerup")), SoundCategory.NEUTRAL, (float) 0.1, 1);
				} else {
					((World) world).playSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("noe:powerup")), SoundCategory.NEUTRAL, (float) 0.1, 1, false);
				}
			}
		}
	}
}
