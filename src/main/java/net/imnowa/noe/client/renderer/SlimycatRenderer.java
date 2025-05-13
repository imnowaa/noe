package net.imnowa.noe.client.renderer;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;

import net.imnowa.noe.entity.SlimycatEntity;
import net.imnowa.noe.client.model.Modelslimycat;

@OnlyIn(Dist.CLIENT)
public class SlimycatRenderer extends MobRenderer<SlimycatEntity, Modelslimycat<SlimycatEntity>> {
	public SlimycatRenderer(EntityRendererManager context) {
		super(context, new Modelslimycat<SlimycatEntity>(), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(SlimycatEntity entity) {
		return new ResourceLocation("noe:textures/entities/texture_smillycat.png");
	}
}
