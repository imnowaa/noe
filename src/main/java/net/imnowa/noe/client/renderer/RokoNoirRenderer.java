package net.imnowa.noe.client.renderer;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;

import net.imnowa.noe.entity.RokoNoirEntity;
import net.imnowa.noe.client.model.ModelRoko_noir;

@OnlyIn(Dist.CLIENT)
public class RokoNoirRenderer extends MobRenderer<RokoNoirEntity, ModelRoko_noir<RokoNoirEntity>> {
	public RokoNoirRenderer(EntityRendererManager context) {
		super(context, new ModelRoko_noir<RokoNoirEntity>(), 1f);
	}

	@Override
	public ResourceLocation getEntityTexture(RokoNoirEntity entity) {
		return new ResourceLocation("noe:textures/entities/testroko2.png");
	}
}
