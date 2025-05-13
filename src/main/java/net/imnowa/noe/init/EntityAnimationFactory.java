package net.imnowa.noe.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.imnowa.noe.entity.LanternevolanteEntity;

@Mod.EventBusSubscriber
public class EntityAnimationFactory {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingUpdateEvent event) {
		if (event != null && event.getEntity() != null) {
			if (event.getEntity() instanceof LanternevolanteEntity) {
				LanternevolanteEntity syncable = (LanternevolanteEntity) event.getEntity();
				String animation = syncable.getSyncedAnimation();
				if (!animation.equals("undefined")) {
					syncable.setAnimation("undefined");
					syncable.animationprocedure = animation;
				}
			}
		}
	}
}
