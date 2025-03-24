/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.imnowa.noe.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.common.extensions.IForgeContainerType;

import net.minecraft.inventory.container.ContainerType;

import net.imnowa.noe.world.inventory.TabletteGUIMenu;
import net.imnowa.noe.NoeMod;

public class NoeModMenus {
	public static final DeferredRegister<ContainerType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.CONTAINERS, NoeMod.MODID);
	public static final RegistryObject<ContainerType<TabletteGUIMenu>> TABLETTE_GUI = REGISTRY.register("tablette_gui", () -> IForgeContainerType.create(TabletteGUIMenu::new));
}
