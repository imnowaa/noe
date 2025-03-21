package net.imnowa.noe.init;

import software.bernie.geckolib3.core.IAnimatable;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.item.ItemStack;

import net.imnowa.noe.item.SceptreCOREItem;

@Mod.EventBusSubscriber
public class ItemAnimationFactory {
	@SubscribeEvent
	public static void animatedItems(TickEvent.PlayerTickEvent event) {
		String animation = "";
		ItemStack mainhandItem = event.player.getHeldItemMainhand().copy();
		ItemStack offhandItem = event.player.getHeldItemOffhand().copy();
		if (event.phase == TickEvent.Phase.START && (mainhandItem.getItem() instanceof IAnimatable || offhandItem.getItem() instanceof IAnimatable)) {
			if (mainhandItem.getItem() instanceof SceptreCOREItem) {
				animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
				if (!animation.isEmpty()) {
					event.player.getHeldItemMainhand().getOrCreateTag().putString("geckoAnim", "");
					if (event.player.world.isRemote()) {
						((SceptreCOREItem) event.player.getHeldItemMainhand().getItem()).animationprocedure = animation;
					}
				}
			}
			if (offhandItem.getItem() instanceof SceptreCOREItem) {
				animation = offhandItem.getOrCreateTag().getString("geckoAnim");
				if (!animation.isEmpty()) {
					event.player.getHeldItemOffhand().getOrCreateTag().putString("geckoAnim", "");
					if (event.player.world.isRemote()) {
						((SceptreCOREItem) event.player.getHeldItemOffhand().getItem()).animationprocedure = animation;
					}
				}
			}
		}
	}
}
