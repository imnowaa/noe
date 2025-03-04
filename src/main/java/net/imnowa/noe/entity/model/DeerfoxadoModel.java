package net.imnowa.noe.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.util.ResourceLocation;

import net.imnowa.noe.entity.DeerfoxadoEntity;

public class DeerfoxadoModel extends AnimatedGeoModel<DeerfoxadoEntity> {
	@Override
	public ResourceLocation getAnimationFileLocation(DeerfoxadoEntity entity) {
		return new ResourceLocation("noe", "animations/model.deerfox_ado.animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(DeerfoxadoEntity entity) {
		return new ResourceLocation("noe", "geo/model.deerfox_ado.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(DeerfoxadoEntity entity) {
		return new ResourceLocation("noe", "textures/entities/" + entity.getTexture() + ".png");
	}

}
