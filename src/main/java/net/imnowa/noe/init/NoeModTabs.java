/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.imnowa.noe.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

public class NoeModTabs {
	public static ItemGroup TAB_NOE_AUTRES;

	public static void load() {
		TAB_NOE_AUTRES = new ItemGroup("noe.noe_autres") {
			@Override
			@OnlyIn(Dist.CLIENT)
			public ItemStack createIcon() {
				return new ItemStack(NoeModItems.LANTERNEVOLANTE_SPAWN_EGG.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
