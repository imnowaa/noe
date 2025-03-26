package net.imnowa.noe.client.model;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
// Made with Blockbench 4.12.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports
public class Modelslimycat<T extends Entity> extends EntityModel<T> {
	public final ModelRenderer bb_main;
	public final ModelRenderer cube_r1;
	public final ModelRenderer cube_r2;
	public final ModelRenderer cube_r3;

	public Modelslimycat() {
		textureWidth = 32;
		textureHeight = 32;
		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		bb_main.setTextureOffset(10, 16).addBox(-4.0F, -10.0F, 0.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(10, 20).addBox(1.0F, -10.0F, 0.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.5F, -8.5603F, 5.508F);
		bb_main.addChild(cube_r1);
		setRotationAngle(cube_r1, -2.8798F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(20, 20).addBox(-1.0F, -1.0F, -4.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.5F, -9.7588F, 6.1319F);
		bb_main.addChild(cube_r2);
		setRotationAngle(cube_r2, 1.9199F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(20, 16).addBox(-1.0F, -1.0F, -4.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.5F, -6.0F, 7.5F);
		bb_main.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.5236F, 0.0F, 0.0F);
		cube_r3.setTextureOffset(0, 16).addBox(-1.0F, -1.0F, -4.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(T e, float f, float f1, float f2, float f3, float f4) {
	}

}
