
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

import net.imnowa.noe.item.TablettePhotoItem;
import net.imnowa.noe.item.TabletteOffItem;
import net.imnowa.noe.item.TabletteItem;
import net.imnowa.noe.item.SceptreCOREItem;
import net.imnowa.noe.item.HorlogeItem;
import net.imnowa.noe.NoeMod;

public class NoeModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, NoeMod.MODID);
	public static final RegistryObject<Item> PIANO = block(NoeModBlocks.PIANO, NoeModTabs.TAB_NOE_AUTRES);
	public static final RegistryObject<Item> LANTERNEVOLANTE_SPAWN_EGG = REGISTRY.register("lanternevolante_spawn_egg",
			() -> new ForgeSpawnEggItem(NoeModEntities.LANTERNEVOLANTE, -3342388, -1, new Item.Properties().group(NoeModTabs.TAB_NOE_AUTRES)));
	public static final RegistryObject<Item> SCEPTRE_CORE = REGISTRY.register("sceptre_core", () -> new SceptreCOREItem());
	public static final RegistryObject<Item> HORLOGE = REGISTRY.register("horloge", () -> new HorlogeItem());
	public static final RegistryObject<Item> TABLETTE = REGISTRY.register("tablette", () -> new TabletteItem());
	public static final RegistryObject<Item> TABLETTE_PHOTO = REGISTRY.register("tablette_photo", () -> new TablettePhotoItem());
	public static final RegistryObject<Item> DEER_ADO_SPAWN_EGG = REGISTRY.register("deer_ado_spawn_egg", () -> new ForgeSpawnEggItem(NoeModEntities.DEER_ADO, -1, -1, new Item.Properties().group(NoeModTabs.TAB_NOE_AUTRES)));
	public static final RegistryObject<Item> SLIMYCAT_SPAWN_EGG = REGISTRY.register("slimycat_spawn_egg", () -> new ForgeSpawnEggItem(NoeModEntities.SLIMYCAT, -16777216, -1, new Item.Properties().group(NoeModTabs.TAB_NOE_AUTRES)));
	public static final RegistryObject<Item> ROKO_MARRON_SPAWN_EGG = REGISTRY.register("roko_marron_spawn_egg", () -> new ForgeSpawnEggItem(NoeModEntities.ROKO_MARRON, -13421824, -13108, new Item.Properties().group(NoeModTabs.TAB_NOE_AUTRES)));
	public static final RegistryObject<Item> ROKO_NOIR_SPAWN_EGG = REGISTRY.register("roko_noir_spawn_egg", () -> new ForgeSpawnEggItem(NoeModEntities.ROKO_NOIR, -13421773, -52, new Item.Properties().group(NoeModTabs.TAB_NOE_AUTRES)));
	public static final RegistryObject<Item> TABLETTE_OFF = REGISTRY.register("tablette_off", () -> new TabletteOffItem());
	public static final RegistryObject<Item> BOITE_BIJOUX = block(NoeModBlocks.BOITE_BIJOUX, NoeModTabs.TAB_NOE_AUTRES);
	public static final RegistryObject<Item> COUSSIN = block(NoeModBlocks.COUSSIN, NoeModTabs.TAB_NOE_AUTRES);
	public static final RegistryObject<Item> THEIERE = block(NoeModBlocks.THEIERE, NoeModTabs.TAB_NOE_AUTRES);
	public static final RegistryObject<Item> GOUVERNAIL = block(NoeModBlocks.GOUVERNAIL, NoeModTabs.TAB_NOE_AUTRES);
	public static final RegistryObject<Item> MACHINEAECRIRE = block(NoeModBlocks.MACHINEAECRIRE, NoeModTabs.TAB_NOE_AUTRES);
	public static final RegistryObject<Item> PIANO_CHARON = block(NoeModBlocks.PIANO_CHARON, NoeModTabs.TAB_NOE_AUTRES);
	public static final RegistryObject<Item> SACDE_FRAPPE = block(NoeModBlocks.SACDE_FRAPPE, NoeModTabs.TAB_NOE_AUTRES);
	public static final RegistryObject<Item> SAC_DE_FRAPPE_FUTUR = block(NoeModBlocks.SAC_DE_FRAPPE_FUTUR, NoeModTabs.TAB_NOE_AUTRES);
	public static final RegistryObject<Item> BARRE_TRACTION = block(NoeModBlocks.BARRE_TRACTION, NoeModTabs.TAB_NOE_AUTRES);
	public static final RegistryObject<Item> BANC_ABDO = block(NoeModBlocks.BANC_ABDO, NoeModTabs.TAB_NOE_AUTRES);
	public static final RegistryObject<Item> CAM_OFF = block(NoeModBlocks.CAM_OFF, NoeModTabs.TAB_NOE_AUTRES);
	public static final RegistryObject<Item> CAM_ON = block(NoeModBlocks.CAM_ON, NoeModTabs.TAB_NOE_AUTRES);

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block, ItemGroup tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().group(tab)));
	}
}
