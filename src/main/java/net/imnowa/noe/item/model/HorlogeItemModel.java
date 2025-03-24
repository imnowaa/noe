package net.imnowa.noe.item.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.util.ResourceLocation;

import net.imnowa.noe.item.HorlogeItem;

public class HorlogeItemModel extends AnimatedGeoModel<HorlogeItem> {
	@Override
	public ResourceLocation getAnimationFileLocation(HorlogeItem animatable) {
		return new ResourceLocation("noe:animations/horloge.animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(HorlogeItem animatable) {
		return new ResourceLocation("noe:geo/horloge.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(HorlogeItem animatable) {
		return new ResourceLocation("noe:textures/item/horloge.png");
	}
}
