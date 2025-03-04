
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.imnowa.noe.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.Block;

import net.imnowa.noe.NoeMod;

public class NoeModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, NoeMod.MODID);
	public static final RegistryObject<Item> PIANO = block(NoeModBlocks.PIANO, NoeModTabs.TAB_NOE_AUTRES);
	public static final RegistryObject<Item> LANTERNEVOLANTE_SPAWN_EGG = REGISTRY.register("lanternevolante_spawn_egg",
			() -> new ForgeSpawnEggItem(NoeModEntities.LANTERNEVOLANTE, -3342388, -1, new Item.Properties().group(NoeModTabs.TAB_NOE_AUTRES)));
	public static final RegistryObject<Item> DEERFOXADO_SPAWN_EGG = REGISTRY.register("deerfoxado_spawn_egg", () -> new ForgeSpawnEggItem(NoeModEntities.DEERFOXADO, -1, -1, new Item.Properties().group(NoeModTabs.TAB_NOE_AUTRES)));

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block, ItemGroup tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().group(tab)));
	}
}
