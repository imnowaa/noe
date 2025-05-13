package net.imnowa.noe.client.renderer;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;

import net.imnowa.noe.entity.RokoMarronEntity;
import net.imnowa.noe.client.model.ModelRoko_marron;

@OnlyIn(Dist.CLIENT)
public class RokoMarronRenderer extends MobRenderer<RokoMarronEntity, ModelRoko_marron<RokoMarronEntity>> {
	public RokoMarronRenderer(EntityRendererManager context) {
		super(context, new ModelRoko_marron<RokoMarronEntity>(), 1f);
	}

	@Override
	public ResourceLocation getEntityTexture(RokoMarronEntity entity) {
		return new ResourceLocation("noe:textures/entities/testroko.png");
	}
}
