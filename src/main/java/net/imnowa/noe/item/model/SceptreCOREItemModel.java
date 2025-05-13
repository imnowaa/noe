package net.imnowa.noe.item.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.util.ResourceLocation;

import net.imnowa.noe.item.SceptreCOREItem;

public class SceptreCOREItemModel extends AnimatedGeoModel<SceptreCOREItem> {
	@Override
	public ResourceLocation getAnimationFileLocation(SceptreCOREItem animatable) {
		return new ResourceLocation("noe:animations/sceptre_core.animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(SceptreCOREItem animatable) {
		return new ResourceLocation("noe:geo/sceptre_core.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(SceptreCOREItem animatable) {
		return new ResourceLocation("noe:textures/item/sceptre.png");
	}
}
