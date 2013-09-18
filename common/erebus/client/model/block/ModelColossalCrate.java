package erebus.client.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelColossalCrate extends ModelBase {
	// fields
	ModelRenderer BambooBase1;
	ModelRenderer BambooBase2;
	ModelRenderer BambooBase3;
	ModelRenderer BambooBase4;
	ModelRenderer BambooPillar1;
	ModelRenderer BambooPillar2;
	ModelRenderer BambooPillar3;
	ModelRenderer BambooPillar4;
	ModelRenderer BambooTop1;
	ModelRenderer BambooTop2;
	ModelRenderer BambooTop3;
	ModelRenderer BambooTop4;
	ModelRenderer BambooCenter;

	public ModelColossalCrate() {
		textureWidth = 128;
		textureHeight = 128;

		BambooBase1 = new ModelRenderer(this, 0, 0);
		BambooBase1.addBox(-2F, -2F, 0F, 4, 4, 32);
		BambooBase1.setRotationPoint(5F, 21F, -8F);
		BambooBase1.setTextureSize(64, 32);
		BambooBase1.mirror = true;
		setRotation(BambooBase1, 0F, 0F, 0F);
		BambooBase2 = new ModelRenderer(this, 0, 0);
		BambooBase2.addBox(-2F, -2F, 0F, 4, 4, 32);
		BambooBase2.setRotationPoint(-21F, 21F, -8F);
		BambooBase2.setTextureSize(64, 32);
		BambooBase2.mirror = true;
		setRotation(BambooBase2, 0F, 0F, 0F);
		BambooBase3 = new ModelRenderer(this, 0, 36);
		BambooBase3.addBox(0F, 0F, 0F, 32, 4, 4);
		BambooBase3.setRotationPoint(-24F, 19F, -7F);
		BambooBase3.setTextureSize(64, 32);
		BambooBase3.mirror = true;
		setRotation(BambooBase3, 0F, 0F, 0F);
		BambooBase4 = new ModelRenderer(this, 0, 36);
		BambooBase4.addBox(0F, 0F, 0F, 32, 4, 4);
		BambooBase4.setRotationPoint(-24F, 19F, 19F);
		BambooBase4.setTextureSize(64, 32);
		BambooBase4.mirror = true;
		setRotation(BambooBase4, 0F, 0F, 0F);
		BambooPillar1 = new ModelRenderer(this, 72, 0);
		BambooPillar1.addBox(-2F, 0F, -2F, 4, 32, 4);
		BambooPillar1.setRotationPoint(5F, -8F, -5F);
		BambooPillar1.setTextureSize(64, 32);
		BambooPillar1.mirror = true;
		setRotation(BambooPillar1, 0F, 0F, 0F);
		BambooPillar2 = new ModelRenderer(this, 72, 0);
		BambooPillar2.addBox(-2F, 0F, -2F, 4, 32, 4);
		BambooPillar2.setRotationPoint(-21F, -8F, -5F);
		BambooPillar2.setTextureSize(64, 32);
		BambooPillar2.mirror = true;
		setRotation(BambooPillar2, 0F, 0F, 0F);
		BambooPillar3 = new ModelRenderer(this, 72, 0);
		BambooPillar3.addBox(0F, 0F, 0F, 4, 32, 4);
		BambooPillar3.setRotationPoint(-23F, -8F, 19F);
		BambooPillar3.setTextureSize(64, 32);
		BambooPillar3.mirror = true;
		setRotation(BambooPillar3, 0F, 0F, 0F);
		BambooPillar4 = new ModelRenderer(this, 72, 0);
		BambooPillar4.addBox(0F, 0F, 0F, 4, 32, 4);
		BambooPillar4.setRotationPoint(3F, -8F, 19F);
		BambooPillar4.setTextureSize(64, 32);
		BambooPillar4.mirror = true;
		setRotation(BambooPillar4, 0F, 0F, 0F);
		BambooTop1 = new ModelRenderer(this, 0, 0);
		BambooTop1.addBox(-2F, -2F, 0F, 4, 4, 32);
		BambooTop1.setRotationPoint(5F, -5F, -8F);
		BambooTop1.setTextureSize(64, 32);
		BambooTop1.mirror = true;
		setRotation(BambooTop1, 0F, 0F, 0F);
		BambooTop2 = new ModelRenderer(this, 0, 0);
		BambooTop2.addBox(-2F, -2F, 0F, 4, 4, 32);
		BambooTop2.setRotationPoint(-21F, -5F, -8F);
		BambooTop2.setTextureSize(64, 32);
		BambooTop2.mirror = true;
		setRotation(BambooTop2, 0F, 0F, 0F);
		BambooTop3 = new ModelRenderer(this, 0, 36);
		BambooTop3.addBox(0F, -2F, -2F, 32, 4, 4);
		BambooTop3.setRotationPoint(-24F, -5F, -5F);
		BambooTop3.setTextureSize(64, 32);
		BambooTop3.mirror = true;
		setRotation(BambooTop3, 0F, 0F, 0F);
		BambooTop4 = new ModelRenderer(this, 0, 36);
		BambooTop4.addBox(0F, -2F, -2F, 32, 4, 4);
		BambooTop4.setRotationPoint(-24F, -5F, 21F);
		BambooTop4.setTextureSize(64, 32);
		BambooTop4.mirror = true;
		setRotation(BambooTop4, 0F, 0F, 0F);
		BambooCenter = new ModelRenderer(this, 0, 44);
		BambooCenter.addBox(0F, 0F, 0F, 26, 26, 26);
		BambooCenter.setRotationPoint(-21F, -5F, -5F);
		BambooCenter.setTextureSize(64, 32);
		BambooCenter.mirror = true;
		setRotation(BambooCenter, 0F, 0F, 0F);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void renderModel(float f5) {
		BambooBase1.render(f5);
		BambooBase2.render(f5);
		BambooBase3.render(f5);
		BambooBase4.render(f5);
		BambooPillar1.render(f5);
		BambooPillar2.render(f5);
		BambooPillar3.render(f5);
		BambooPillar4.render(f5);
		BambooTop1.render(f5);
		BambooTop2.render(f5);
		BambooTop3.render(f5);
		BambooTop4.render(f5);
		BambooCenter.render(f5);
	}
}
