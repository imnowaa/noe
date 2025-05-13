package net.imnowa.noe.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.util.ResourceLocation;

import net.imnowa.noe.entity.LanternevolanteEntity;

public class LanternevolanteModel extends AnimatedGeoModel<LanternevolanteEntity> {
	@Override
	public ResourceLocation getAnimationFileLocation(LanternevolanteEntity entity) {
		return new ResourceLocation("noe", "animations/lanterne_volante.animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(LanternevolanteEntity entity) {
		return new ResourceLocation("noe", "geo/lanterne_volante.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(LanternevolanteEntity entity) {
		return new ResourceLocation("noe", "textures/entities/" + entity.getTexture() + ".png");
	}

}
