
package net.imnowa.noe.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import software.bernie.geckolib3.geo.render.built.GeoModel;

import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import net.imnowa.noe.entity.model.DeerfoxadoModel;
import net.imnowa.noe.entity.DeerfoxadoEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

public class DeerfoxadoRenderer extends GeoEntityRenderer<DeerfoxadoEntity> {
	@Override
	public ResourceLocation getEntityTexture(DeerfoxadoEntity entity) {
	    return getTextureLocation(entity);
	}
	
	@Override
	public ResourceLocation getTextureLocation(DeerfoxadoEntity entity) {
	    return new ResourceLocation("noe", "textures/entities/texture_deerfox.png");
	}



	public DeerfoxadoRenderer(EntityRendererManager renderManager) {
		super(renderManager, new DeerfoxadoModel());
		this.shadowSize = 0.7f;
	}

	@Override
	public RenderType getRenderType(DeerfoxadoEntity animatable, float partialTicks, MatrixStack poseStack, IRenderTypeBuffer bufferSource, IVertexBuilder buffer, int packedLight, ResourceLocation texture) {
		return RenderType.getEntityCutoutNoCull(getTextureLocation(animatable));
	}

	@Override
	public void render(GeoModel model, DeerfoxadoEntity entity, float partialTick, RenderType type, MatrixStack poseStack, IRenderTypeBuffer bufferSource, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
			float alpha) {
		float scale = 1f;
		this.widthScale = scale;
		this.heightScale = scale;
		super.render(model, entity, partialTick, type, poseStack, bufferSource, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
