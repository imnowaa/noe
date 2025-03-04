/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.imnowa.noe.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.imnowa.noe.client.renderer.LanternevolanteRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class NoeModEntityRenderers {
	@SubscribeEvent
	public static void render(FMLClientSetupEvent event) {
		NoeModEntityRenderers.renders();
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void registerModels(ModelRegistryEvent event) {
		NoeModEntityRenderers.renders();
	}

	private static void renders() {
		RenderingRegistry.registerEntityRenderingHandler(NoeModEntities.LANTERNEVOLANTE.get(), LanternevolanteRenderer::new);
	}
}
