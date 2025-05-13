package net.imnowa.noe.utils;

import software.bernie.geckolib3.geo.render.built.GeoBone;

import net.minecraft.client.renderer.model.ModelRenderer;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

public class AnimUtils {
	public static void renderPartOverBone(ModelRenderer model, GeoBone bone, MatrixStack stack, IVertexBuilder buffer, int packedLightIn, int packedOverlayIn) {
		setupModelFromBone(model, bone);
		model.render(stack, buffer, packedLightIn, packedOverlayIn);
	}

	public static void setupModelFromBone(ModelRenderer model, GeoBone bone) {
		model.setRotationPoint(bone.getPivotX(), bone.getPivotY(), bone.getPivotZ());
		model.rotateAngleX = 0.0f;
		model.rotateAngleY = 0.0f;
		model.rotateAngleZ = 0.0f;
	}
}
