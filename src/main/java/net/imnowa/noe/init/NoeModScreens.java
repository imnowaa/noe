/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.imnowa.noe.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.ScreenManager;

import net.imnowa.noe.client.gui.TabletteOffGUIScreen;
import net.imnowa.noe.client.gui.TabletteGUIScreen;
import net.imnowa.noe.client.gui.TabNoteGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class NoeModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ScreenManager.registerFactory(NoeModMenus.TABLETTE_GUI.get(), TabletteGUIScreen::new);
			ScreenManager.registerFactory(NoeModMenus.TAB_NOTE_GUI.get(), TabNoteGUIScreen::new);
			ScreenManager.registerFactory(NoeModMenus.TABLETTE_OFF_GUI.get(), TabletteOffGUIScreen::new);
		});
	}
}
