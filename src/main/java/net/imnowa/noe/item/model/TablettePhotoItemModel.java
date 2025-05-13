package net.imnowa.noe.item.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.util.ResourceLocation;

import net.imnowa.noe.item.TablettePhotoItem;

public class TablettePhotoItemModel extends AnimatedGeoModel<TablettePhotoItem> {
	@Override
	public ResourceLocation getAnimationFileLocation(TablettePhotoItem animatable) {
		return new ResourceLocation("noe:animations/tablette_photo.animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(TablettePhotoItem animatable) {
		return new ResourceLocation("noe:geo/tablette_photo.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(TablettePhotoItem animatable) {
		return new ResourceLocation("noe:textures/item/tabletteon.png");
	}
}
