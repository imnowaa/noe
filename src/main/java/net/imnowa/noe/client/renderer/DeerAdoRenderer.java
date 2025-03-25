package net.imnowa.noe.client.renderer;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;

import net.imnowa.noe.entity.DeerAdoEntity;
import net.imnowa.noe.client.model.Modeldeerfox_ado;

@OnlyIn(Dist.CLIENT)
public class DeerAdoRenderer extends MobRenderer<DeerAdoEntity, Modeldeerfox_ado<DeerAdoEntity>> {
	public DeerAdoRenderer(EntityRendererManager context) {
		super(context, new Modeldeerfox_ado<DeerAdoEntity>(), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(DeerAdoEntity entity) {
		return new ResourceLocation("noe:textures/entities/texture_deerfox.png");
	}
}
