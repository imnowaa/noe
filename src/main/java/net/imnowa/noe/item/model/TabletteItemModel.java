package net.imnowa.noe.item.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.util.ResourceLocation;

import net.imnowa.noe.item.TabletteItem;

public class TabletteItemModel extends AnimatedGeoModel<TabletteItem> {
	@Override
	public ResourceLocation getAnimationFileLocation(TabletteItem animatable) {
		return new ResourceLocation("noe:animations/tablette.animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(TabletteItem animatable) {
		return new ResourceLocation("noe:geo/tablette.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(TabletteItem animatable) {
		return new ResourceLocation("noe:textures/item/tabletteon.png");
	}
}
