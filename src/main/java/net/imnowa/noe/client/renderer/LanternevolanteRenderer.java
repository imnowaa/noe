
package net.imnowa.noe.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import software.bernie.geckolib3.geo.render.built.GeoModel;

import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import net.imnowa.noe.entity.model.LanternevolanteModel;
import net.imnowa.noe.entity.LanternevolanteEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

public class LanternevolanteRenderer extends GeoEntityRenderer<LanternevolanteEntity> {
	@Override
	public ResourceLocation getEntityTexture(LanternevolanteEntity entity) {
		return new ResourceLocation("noe:textures/entities/texture_lanterne.png");
	}

	public LanternevolanteRenderer(EntityRendererManager renderManager) {
		super(renderManager, new LanternevolanteModel());
		this.shadowSize = 0.5f;
	}

	@Override
	public RenderType getRenderType(LanternevolanteEntity animatable, float partialTicks, MatrixStack poseStack, IRenderTypeBuffer bufferSource, IVertexBuilder buffer, int packedLight, ResourceLocation texture) {
		return RenderType.getEntityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void render(GeoModel model, LanternevolanteEntity entity, float partialTick, RenderType type, MatrixStack poseStack, IRenderTypeBuffer bufferSource, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1.4f;
		this.widthScale = scale;
		this.heightScale = scale;
		super.render(model, entity, partialTick, type, poseStack, bufferSource, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
