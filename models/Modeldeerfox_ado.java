// Made with Blockbench 4.12.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modeldeerfox_ado extends EntityModel<Entity> {
	private final ModelRenderer deerfox;
	private final ModelRenderer neck;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer body;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer Tail;
	private final ModelRenderer base_r1;
	private final ModelRenderer Mid;
	private final ModelRenderer mid_r1;
	private final ModelRenderer Fin;
	private final ModelRenderer fur4_r1;
	private final ModelRenderer fur3_r1;
	private final ModelRenderer fur2_r1;
	private final ModelRenderer fur1_r1;
	private final ModelRenderer fin_r1;
	private final ModelRenderer BG;
	private final ModelRenderer cube_r6;
	private final ModelRenderer BD;
	private final ModelRenderer cube_r7;
	private final ModelRenderer AG;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer AD;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer head;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer bone3;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r19;
	private final ModelRenderer bone4;
	private final ModelRenderer cube_r20;

	public Modeldeerfox_ado() {
		textureWidth = 128;
		textureHeight = 128;

		deerfox = new ModelRenderer(this);
		deerfox.setRotationPoint(0.0F, 24.0F, -2.25F);

		neck = new ModelRenderer(this);
		neck.setRotationPoint(-2.5F, -15.333F, -7.3221F);
		deerfox.addChild(neck);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 11.0F, 0.0F);
		neck.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0873F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(28, 70).addBox(-1.0F, -17.0F, -4.0F, 7.0F, 7.0F, 6.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 4.083F, -0.4279F);
		neck.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.1309F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(67, 34).addBox(-1.0F, -12.0F, -4.0F, 7.0F, 4.0F, 6.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -16.3309F, 5.9981F);
		deerfox.addChild(body);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(cube_r3);
		setRotationAngle(cube_r3, -0.0873F, 0.0F, 3.1416F);
		cube_r3.setTextureOffset(29, 34).addBox(-5.0F, -5.0F, -4.5F, 10.0F, 10.0F, 9.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, 0.2054F, -6.0634F);
		body.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, 3.1416F);
		cube_r4.setTextureOffset(2, 26).addBox(-5.0F, -5.0F, -4.5F, 10.0F, 10.0F, 7.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, -0.2889F, -13.616F);
		body.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.1745F, 0.0F, -3.1416F);
		cube_r5.setTextureOffset(40, 16).addBox(-5.0F, -5.0F, -3.5F, 10.0F, 10.0F, 8.0F, 0.0F, false);

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.0F, -17.1994F, 10.4102F);
		deerfox.addChild(Tail);

		base_r1 = new ModelRenderer(this);
		base_r1.setRotationPoint(0.0F, 0.0F, 7.75F);
		Tail.addChild(base_r1);
		setRotationAngle(base_r1, 0.0F, 0.0F, 3.1416F);
		base_r1.setTextureOffset(51, 3).addBox(-3.0F, -3.0F, -10.75F, 6.0F, 6.0F, 6.0F, 0.0F, false);

		Mid = new ModelRenderer(this);
		Mid.setRotationPoint(0.0F, -0.7348F, 5.6736F);
		Tail.addChild(Mid);

		mid_r1 = new ModelRenderer(this);
		mid_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Mid.addChild(mid_r1);
		setRotationAngle(mid_r1, -0.2182F, 0.0F, 3.1416F);
		mid_r1.setTextureOffset(0, 44).addBox(-4.0F, -4.0F, -4.5F, 8.0F, 8.0F, 9.0F, 0.0F, false);

		Fin = new ModelRenderer(this);
		Fin.setRotationPoint(0.0F, -0.6519F, 0.2146F);
		Mid.addChild(Fin);

		fur4_r1 = new ModelRenderer(this);
		fur4_r1.setRotationPoint(4.0F, -2.3137F, 12.0696F);
		Fin.addChild(fur4_r1);
		setRotationAngle(fur4_r1, 0.6545F, 0.0F, 0.0F);
		fur4_r1.setTextureOffset(98, 71).addBox(-9.0F, 1.0F, -1.0F, 10.0F, 0.0F, 3.0F, 0.0F, false);

		fur3_r1 = new ModelRenderer(this);
		fur3_r1.setRotationPoint(4.0F, -10.2465F, 5.9826F);
		Fin.addChild(fur3_r1);
		setRotationAngle(fur3_r1, 0.6545F, 0.0F, 0.0F);
		fur3_r1.setTextureOffset(98, 71).addBox(-9.0F, 1.0F, -1.0F, 10.0F, 0.0F, 3.0F, 0.0F, false);

		fur2_r1 = new ModelRenderer(this);
		fur2_r1.setRotationPoint(5.0F, -5.7916F, 10.0312F);
		Fin.addChild(fur2_r1);
		setRotationAngle(fur2_r1, 0.0F, 0.6545F, -1.5708F);
		fur2_r1.setTextureOffset(98, 71).addBox(-5.0F, 0.0F, -1.5F, 10.0F, 0.0F, 3.0F, 0.0F, false);

		fur1_r1 = new ModelRenderer(this);
		fur1_r1.setRotationPoint(-5.0F, -5.7916F, 10.0312F);
		Fin.addChild(fur1_r1);
		setRotationAngle(fur1_r1, 0.0F, 0.6545F, -1.5708F);
		fur1_r1.setTextureOffset(98, 71).addBox(-5.0F, 0.0F, -1.5F, 10.0F, 0.0F, 3.0F, 0.0F, false);

		fin_r1 = new ModelRenderer(this);
		fin_r1.setRotationPoint(0.0F, -1.8346F, 4.8744F);
		Fin.addChild(fin_r1);
		setRotationAngle(fin_r1, -0.6545F, 0.0F, 3.1416F);
		fin_r1.setTextureOffset(4, 4).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);

		BG = new ModelRenderer(this);
		BG.setRotationPoint(3.25F, -14.0F, 7.2018F);
		deerfox.addChild(BG);
		BG.setTextureOffset(76, 67).addBox(-1.75F, -1.0F, -0.7018F, 3.0F, 15.0F, 3.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(2.75F, 1.9191F, -1.2037F);
		BG.addChild(cube_r6);
		setRotationAngle(cube_r6, -0.1745F, 0.0F, -3.1416F);
		cube_r6.setTextureOffset(26, 53).addBox(0.0F, -4.0F, -3.5F, 5.0F, 9.0F, 8.0F, 0.0F, false);

		BD = new ModelRenderer(this);
		BD.setRotationPoint(-3.5F, -14.0F, 5.5F);
		deerfox.addChild(BD);
		BD.setTextureOffset(76, 67).addBox(-1.0F, -0.7902F, 0.8294F, 3.0F, 15.0F, 3.0F, 0.0F, true);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-2.5F, 1.9191F, 0.4981F);
		BD.addChild(cube_r7);
		setRotationAngle(cube_r7, -0.1745F, 0.0F, 3.1416F);
		cube_r7.setTextureOffset(26, 53).addBox(-5.0F, -4.0F, -3.5F, 5.0F, 9.0F, 8.0F, 0.0F, true);

		AG = new ModelRenderer(this);
		AG.setRotationPoint(0.0F, -17.9489F, -8.0153F);
		deerfox.addChild(AG);
		AG.setTextureOffset(69, 0).addBox(1.5F, 12.828F, -1.5931F, 3.0F, 5.0F, 3.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(0.0F, 11.4644F, 0.0319F);
		AG.addChild(cube_r8);
		setRotationAngle(cube_r8, -0.0873F, 0.0F, 0.0F);
		cube_r8.setTextureOffset(76, 23).addBox(1.5F, -5.5F, -1.5F, 3.0F, 7.0F, 3.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(0.0F, 7.0F, 0.0F);
		AG.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.2182F, 0.0F, 0.0F);
		cube_r9.setTextureOffset(0, 0).addBox(1.5F, -2.5F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(6.0F, 3.868F, -1.9866F);
		AG.addChild(cube_r10);
		setRotationAngle(cube_r10, -0.1745F, 0.0F, -3.1416F);
		cube_r10.setTextureOffset(72, 9).addBox(0.0F, -3.0F, -1.5F, 5.0F, 8.0F, 6.0F, 0.0F, false);

		AD = new ModelRenderer(this);
		AD.setRotationPoint(0.0F, -10.9489F, -8.0153F);
		deerfox.addChild(AD);
		AD.setTextureOffset(69, 0).addBox(-4.5F, 5.828F, -1.5931F, 3.0F, 5.0F, 3.0F, 0.0F, true);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(0.0F, 4.4644F, 0.0319F);
		AD.addChild(cube_r11);
		setRotationAngle(cube_r11, -0.0873F, 0.0F, 0.0F);
		cube_r11.setTextureOffset(76, 23).addBox(-4.5F, -5.5F, -1.5F, 3.0F, 7.0F, 3.0F, 0.0F, true);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(0.0F, 0.0F, 0.0F);
		AD.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.2182F, 0.0F, 0.0F);
		cube_r12.setTextureOffset(0, 0).addBox(-4.5F, -2.5F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, true);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(-6.0F, -3.132F, -1.9866F);
		AD.addChild(cube_r13);
		setRotationAngle(cube_r13, -0.1745F, 0.0F, 3.1416F);
		cube_r13.setTextureOffset(72, 9).addBox(-5.0F, -3.0F, -1.5F, 5.0F, 8.0F, 6.0F, 0.0F, true);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -22.6542F, -10.9195F);
		deerfox.addChild(head);
		head.setTextureOffset(0, 63).addBox(-3.5F, -6.5958F, -4.0805F, 7.0F, 7.0F, 7.0F, 0.001F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(-3.75F, -13.868F, 1.9226F);
		head.addChild(cube_r14);
		setRotationAngle(cube_r14, -0.5236F, 0.2618F, -0.3054F);
		cube_r14.setTextureOffset(4, 24).addBox(-0.5F, 1.4658F, -2.1565F, 1.0F, 6.0F, 1.0F, 0.0F, true);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(3.75F, -13.868F, 1.9226F);
		head.addChild(cube_r15);
		setRotationAngle(cube_r15, -0.5236F, -0.2618F, 0.3054F);
		cube_r15.setTextureOffset(4, 24).addBox(-0.5F, 1.4658F, -2.1565F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(4.5F, -11.868F, -3.0774F);
		head.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.3927F, -0.2618F, 0.3054F);
		cube_r16.setTextureOffset(4, 24).addBox(-0.5F, 0.4658F, -2.1565F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(-4.5F, -11.868F, -3.0774F);
		head.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.3927F, 0.2618F, -0.3054F);
		cube_r17.setTextureOffset(33, 24).addBox(-0.5F, 0.4658F, -2.1565F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-3.0F, -7.8458F, 1.4195F);
		head.addChild(bone3);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(6.0F, 0.0F, 1.0F);
		bone3.addChild(cube_r18);
		setRotationAngle(cube_r18, -0.2268F, -0.6194F, 0.3783F);
		cube_r18.setTextureOffset(34, 9).addBox(-1.0F, -1.5F, -0.5F, 2.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(0.0F, 0.0F, 1.0F);
		bone3.addChild(cube_r19);
		setRotationAngle(cube_r19, -0.2268F, 0.6194F, -0.3783F);
		cube_r19.setTextureOffset(40, 9).addBox(-1.0F, -1.5F, -0.5F, 2.0F, 4.0F, 1.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, -2.2207F, -5.3128F);
		head.addChild(bone4);
		bone4.setTextureOffset(35, 1).addBox(-2.0F, -1.4751F, -2.2677F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(0.0F, -0.2111F, -0.1758F);
		bone4.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.48F, 0.0F, 0.0F);
		cube_r20.setTextureOffset(45, 54).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		deerfox.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		this.BD.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.BG.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.AD.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.AG.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}