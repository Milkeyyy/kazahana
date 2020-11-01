// Made with Blockbench 3.7.2
// Exported for Minecraft version 1.14
// Paste this class into your mod and generate all required imports

public static class Modelezo_deer extends EntityModel {
	private final ModelRenderer Doutai;
	private final ModelRenderer cube_r1;
	private final ModelRenderer Shippo;
	private final ModelRenderer Atama;
	private final ModelRenderer cube_r2;
	private final ModelRenderer Tsuno;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer Kubi;
	private final ModelRenderer cube_r12;
	private final ModelRenderer Ashi;
	private final ModelRenderer Mae_Migi;
	private final ModelRenderer Mae_Hidari;
	private final ModelRenderer Ushiro_Migi;
	private final ModelRenderer Ushiro_Hidari;

	public Modelezo_deer() {
		textureWidth = 64;
		textureHeight = 64;

		Doutai = new ModelRenderer(this);
		Doutai.setRotationPoint(0.0F, 12.6F, 0.5F);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Doutai.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -1.5708F, 0.0F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 22, 51, -7.5F, -3.5F, -3.0F, 15, 7, 6, 0.0F, false));

		Shippo = new ModelRenderer(this);
		Shippo.setRotationPoint(2.0F, 15.2F, 11.55F);
		Shippo.cubeList.add(new ModelBox(Shippo, 60, 47, -2.5F, -3.8F, -3.55F, 1, 3, 1, 0.0F, false));

		Atama = new ModelRenderer(this);
		Atama.setRotationPoint(-0.5F, 3.95F, -7.05F);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.5029F, 5.64F, 2.7587F);
		Atama.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, -1.5708F, 0.0F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 60, 0, -8.1087F, -2.99F, -0.4971F, 1, 1, 1, 0.0F, false));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 0, -7.1087F, -4.99F, -1.9971F, 4, 4, 4, 0.0F, false));

		Tsuno = new ModelRenderer(this);
		Tsuno.setRotationPoint(-0.5F, -2.95F, 1.65F);
		Atama.addChild(Tsuno);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-1.6539F, 0.6229F, -3.5F);
		Tsuno.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0873F, -1.5708F, 0.0F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 8, 61, -0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F, false));

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(1.0029F, 8.69F, 1.1087F);
		Tsuno.addChild(cube_r4);
		setRotationAngle(cube_r4, 1.0472F, -1.5708F, -0.3054F);
		cube_r4.cubeList.add(new ModelBox(cube_r4, 8, 61, -5.1087F, -5.8784F, 6.6756F, 1, 2, 1, 0.0F, false));

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(1.0029F, 8.69F, 1.1087F);
		Tsuno.addChild(cube_r5);
		setRotationAngle(cube_r5, -0.5236F, -1.5708F, -0.3054F);
		cube_r5.cubeList.add(new ModelBox(cube_r5, 8, 61, -5.1087F, -5.3003F, -8.0132F, 1, 2, 1, 0.0F, false));

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(1.0029F, 8.69F, 1.1087F);
		Tsuno.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.3491F, -1.5708F, 0.0F);
		cube_r6.cubeList.add(new ModelBox(cube_r6, 8, 61, -5.1087F, -9.4004F, 4.9859F, 1, 2, 1, 0.0F, false));

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(1.0029F, 8.69F, 1.1087F);
		Tsuno.addChild(cube_r7);
		setRotationAngle(cube_r7, -0.48F, -1.5708F, 0.0F);
		cube_r7.cubeList.add(new ModelBox(cube_r7, 8, 61, -5.1087F, -8.5533F, -6.9326F, 1, 2, 1, 0.0F, false));

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(1.0029F, 8.69F, 1.1087F);
		Tsuno.addChild(cube_r8);
		setRotationAngle(cube_r8, -0.6981F, -1.5708F, 0.0F);
		cube_r8.cubeList.add(new ModelBox(cube_r8, 8, 61, -5.1087F, -9.7698F, -3.7703F, 1, 2, 1, 0.0F, false));

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(1.0029F, 8.69F, 1.1087F);
		Tsuno.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.6981F, -1.5708F, 0.0F);
		cube_r9.cubeList.add(new ModelBox(cube_r9, 8, 61, -5.1087F, -9.8573F, 2.666F, 1, 2, 1, 0.0F, false));
		cube_r9.cubeList.add(new ModelBox(cube_r9, 8, 61, -5.1087F, -7.5378F, 2.0899F, 1, 4, 1, 0.0F, false));

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(3.671F, 0.6198F, -3.5F);
		Tsuno.addChild(cube_r10);
		setRotationAngle(cube_r10, -0.0873F, -1.5708F, 0.0F);
		cube_r10.cubeList.add(new ModelBox(cube_r10, 8, 61, -0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F, false));

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-0.5786F, 2.783F, -3.5F);
		Tsuno.addChild(cube_r11);
		setRotationAngle(cube_r11, -0.6981F, -1.5708F, 0.0F);
		cube_r11.cubeList.add(new ModelBox(cube_r11, 8, 61, -0.5F, -2.0F, -0.5F, 1, 4, 1, 0.0F, false));

		Kubi = new ModelRenderer(this);
		Kubi.setRotationPoint(0.0F, 23.2F, 1.5F);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(0.0029F, -13.61F, -5.7413F);
		Kubi.addChild(cube_r12);
		setRotationAngle(cube_r12, -1.0908F, 0.0F, 0.0F);
		cube_r12.cubeList.add(new ModelBox(cube_r12, 38, 0, -1.5029F, 1.2473F, -4.9567F, 3, 4, 9, 0.0F, false));

		Ashi = new ModelRenderer(this);
		Ashi.setRotationPoint(0.0F, 24.0F, 0.0F);

		Mae_Migi = new ModelRenderer(this);
		Mae_Migi.setRotationPoint(-3.5F, -6.75F, 0.5F);
		Ashi.addChild(Mae_Migi);
		Mae_Migi.cubeList.add(new ModelBox(Mae_Migi, 0, 59, 0.85F, -3.15F, -5.6F, 1, 10, 1, 0.0F, false));

		Mae_Hidari = new ModelRenderer(this);
		Mae_Hidari.setRotationPoint(2.5F, -6.75F, 0.5F);
		Ashi.addChild(Mae_Hidari);
		Mae_Hidari.cubeList.add(new ModelBox(Mae_Hidari, 0, 59, -0.95F, -3.15F, -5.6F, 1, 10, 1, 0.0F, false));

		Ushiro_Migi = new ModelRenderer(this);
		Ushiro_Migi.setRotationPoint(-3.5F, -6.25F, 11.5F);
		Ashi.addChild(Ushiro_Migi);
		Ushiro_Migi.cubeList.add(new ModelBox(Ushiro_Migi, 4, 58, 0.85F, -2.85F, -6.1F, 1, 9, 1, 0.0F, false));

		Ushiro_Hidari = new ModelRenderer(this);
		Ushiro_Hidari.setRotationPoint(2.5F, -6.25F, 11.5F);
		Ashi.addChild(Ushiro_Hidari);
		Ushiro_Hidari.cubeList.add(new ModelBox(Ushiro_Hidari, 4, 58, -0.85F, -2.85F, -6.1F, 1, 9, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Doutai.render(f5);
		Shippo.render(f5);
		Atama.render(f5);
		Kubi.render(f5);
		Ashi.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.Mae_Migi.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.Ushiro_Migi.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.Atama.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Atama.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.Ushiro_Hidari.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Mae_Hidari.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}