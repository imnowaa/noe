package net.imnowa.noe.item.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import net.imnowa.noe.item.model.TabletteItemModel;
import net.imnowa.noe.item.TabletteItem;

import java.util.Set;
import java.util.HashSet;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

public class TabletteItemRenderer extends GeoItemRenderer<TabletteItem> {
	public TabletteItemRenderer() {
		super(new TabletteItemModel());
	}

	@Override
	public RenderType getRenderType(TabletteItem animatable, float partialTicks, MatrixStack poseStack, IRenderTypeBuffer bufferSource, IVertexBuilder buffer, int packedLight, ResourceLocation texture) {
		return RenderType.getEntityTranslucent(getTextureLocation(animatable));
	}

	private static final float SCALE_RECIPROCAL = 1.0f / 16.0f;
	protected boolean renderArms = false;
	protected IRenderTypeBuffer currentBuffer;
	public ItemCameraTransforms.TransformType transformType;
	protected TabletteItem animatable;
	private final Set<String> hiddenBones = new HashSet<>();
	private final Set<String> suppressedBones = new HashSet<>();

	@Override
	public void func_239207_a_(ItemStack stack, ItemCameraTransforms.TransformType transformType, MatrixStack matrixStack, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlay) {
		this.transformType = transformType;
		super.func_239207_a_(stack, transformType, matrixStack, bufferIn, combinedLightIn, combinedOverlay);
	}

	@Override
	public void render(TabletteItem animatable, MatrixStack matrixStackIn, IRenderTypeBuffer renderTypeBuffer, int packedLightIn, ItemStack itemStack) {
		this.currentBuffer = renderTypeBuffer;
		this.animatable = animatable;
		super.render(animatable, matrixStackIn, renderTypeBuffer, packedLightIn, itemStack);
		if (this.renderArms) {
			this.renderArms = false;
		}
	}

	@Override
	public ResourceLocation getTextureLocation(TabletteItem instance) {
		return super.getTextureLocation(instance);
	}
}
