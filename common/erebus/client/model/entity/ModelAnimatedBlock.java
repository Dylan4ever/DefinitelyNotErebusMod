package erebus.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelAnimatedBlock extends ModelBase {

	ModelRenderer LBL1;
	ModelRenderer LBL2;
	ModelRenderer LBL3;
	ModelRenderer LBL4;
	ModelRenderer LML1;
	ModelRenderer LML2;
	ModelRenderer LML3;
	ModelRenderer LML4;
	ModelRenderer LFL1;
	ModelRenderer LFL2;
	ModelRenderer LFL3;
	ModelRenderer LFL4;
	ModelRenderer RBL1;
	ModelRenderer RBL2;
	ModelRenderer RBL3;
	ModelRenderer RBL4;
	ModelRenderer RML1;
	ModelRenderer RML2;
	ModelRenderer RML3;
	ModelRenderer RML4;
	ModelRenderer RFL1;
	ModelRenderer RFL2;
	ModelRenderer RFL3;
	ModelRenderer RFL4;

	public ModelAnimatedBlock() {
		textureWidth = 16;
		textureHeight = 16;

		LBL1 = new ModelRenderer(this, 0, 16);
		LBL1.addBox(1F, -1F, -1.5F, 5, 3, 3);
		LBL1.setRotationPoint(6F, 18F, 6F);
		LBL1.setTextureSize(64, 32);
		LBL1.mirror = true;
		setRotation(LBL1, 0F, -0.3490659F, -0.3490659F);
		LBL2 = new ModelRenderer(this, 0, 16);
		LBL2.addBox(5F, 0F, -1F, 2, 4, 2);
		LBL2.setRotationPoint(6F, 18F, 6F);
		LBL2.setTextureSize(64, 32);
		LBL2.mirror = true;
		setRotation(LBL2, 0F, -0.3490659F, -0.3490659F);
		LBL3 = new ModelRenderer(this, 0, 16);
		LBL3.addBox(3.5F, 5.5F, -0.5F, 2, 4, 1);
		LBL3.setRotationPoint(6F, 18F, 6F);
		LBL3.setTextureSize(64, 32);
		LBL3.mirror = true;
		setRotation(LBL3, 0F, -0.3490659F, -0.6981317F);
		LBL4 = new ModelRenderer(this, 0, 16);
		LBL4.addBox(2.5F, 9F, -0.5F, 1, 4, 1);
		LBL4.setRotationPoint(6F, 18F, 6F);
		LBL4.setTextureSize(64, 32);
		LBL4.mirror = true;
		setRotation(LBL4, 0F, -0.3490659F, -0.8726646F);
		LML1 = new ModelRenderer(this, 0, 16);
		LML1.addBox(-1F, -1F, -1.5F, 5, 3, 3);
		LML1.setRotationPoint(8F, 17F, 0F);
		LML1.setTextureSize(64, 32);
		LML1.mirror = true;
		setRotation(LML1, 0F, 0F, -0.3490659F);
		LML2 = new ModelRenderer(this, 0, 16);
		LML2.addBox(3F, 0F, -1F, 2, 4, 2);
		LML2.setRotationPoint(8F, 17F, 0F);
		LML2.setTextureSize(64, 32);
		LML2.mirror = true;
		setRotation(LML2, 0F, 0F, -0.3490659F);
		LML3 = new ModelRenderer(this, 0, 16);
		LML3.addBox(1.5F, 4.5F, -0.5F, 2, 4, 1);
		LML3.setRotationPoint(8F, 17F, 0F);
		LML3.setTextureSize(64, 32);
		LML3.mirror = true;
		setRotation(LML3, 0F, 0F, -0.6981317F);
		LML4 = new ModelRenderer(this, 0, 16);
		LML4.addBox(0.5F, 8F, -0.5F, 1, 4, 1);
		LML4.setRotationPoint(8F, 17F, 0F);
		LML4.setTextureSize(64, 32);
		LML4.mirror = true;
		setRotation(LML4, 0F, 0F, -0.8726646F);
		LFL1 = new ModelRenderer(this, 0, 16);
		LFL1.addBox(-1F, -1F, -1.5F, 5, 3, 3);
		LFL1.setRotationPoint(8F, 17F, -6F);
		LFL1.setTextureSize(64, 32);
		LFL1.mirror = true;
		setRotation(LFL1, 0F, 0.3490659F, -0.3490659F);
		LFL2 = new ModelRenderer(this, 0, 16);
		LFL2.addBox(3F, 0F, -1F, 2, 4, 2);
		LFL2.setRotationPoint(8F, 17F, -6F);
		LFL2.setTextureSize(64, 32);
		LFL2.mirror = true;
		setRotation(LFL2, 0F, 0.3490659F, -0.3490659F);
		LFL3 = new ModelRenderer(this, 0, 16);
		LFL3.addBox(1.5F, 4.5F, -0.5F, 2, 4, 1);
		LFL3.setRotationPoint(8F, 17F, -6F);
		LFL3.setTextureSize(64, 32);
		LFL3.mirror = true;
		setRotation(LFL3, 0F, 0.3490659F, -0.6981317F);
		LFL4 = new ModelRenderer(this, 0, 16);
		LFL4.addBox(0.5F, 8F, -0.5F, 1, 4, 1);
		LFL4.setRotationPoint(8F, 17F, -6F);
		LFL4.setTextureSize(64, 32);
		LFL4.mirror = true;
		setRotation(LFL4, 0F, 0.3490659F, -0.8726646F);
		RBL1 = new ModelRenderer(this, 0, 16);
		RBL1.addBox(-6F, -1F, -1.5F, 5, 3, 3);
		RBL1.setRotationPoint(-6F, 18F, 6F);
		RBL1.setTextureSize(64, 32);
		RBL1.mirror = true;
		setRotation(RBL1, 0F, 0.3490659F, 0.3490659F);
		RBL2 = new ModelRenderer(this, 0, 16);
		RBL2.addBox(-7F, 0F, -1F, 2, 4, 2);
		RBL2.setRotationPoint(-6F, 18F, 6F);
		RBL2.setTextureSize(64, 32);
		RBL2.mirror = true;
		setRotation(RBL2, 0F, 0.3490659F, 0.3490659F);
		RBL3 = new ModelRenderer(this, 0, 16);
		RBL3.addBox(-5.5F, 5.5F, -0.5F, 2, 4, 1);
		RBL3.setRotationPoint(-6F, 18F, 6F);
		RBL3.setTextureSize(64, 32);
		RBL3.mirror = true;
		setRotation(RBL3, 0F, 0.3490659F, 0.6981317F);
		RBL4 = new ModelRenderer(this, 0, 16);
		RBL4.addBox(-3.5F, 9F, -0.5F, 1, 4, 1);
		RBL4.setRotationPoint(-6F, 18F, 6F);
		RBL4.setTextureSize(64, 32);
		RBL4.mirror = true;
		setRotation(RBL4, 0F, 0.3490659F, 0.8726646F);
		RML1 = new ModelRenderer(this, 0, 16);
		RML1.addBox(-4F, -1F, -1.5F, 5, 3, 3);
		RML1.setRotationPoint(-8F, 17F, 0F);
		RML1.setTextureSize(64, 32);
		RML1.mirror = true;
		setRotation(RML1, 0F, 0F, 0.3490659F);
		RML2 = new ModelRenderer(this, 0, 16);
		RML2.addBox(-5F, 0F, -1F, 2, 4, 2);
		RML2.setRotationPoint(-8F, 17F, 0F);
		RML2.setTextureSize(64, 32);
		RML2.mirror = true;
		setRotation(RML2, 0F, 0F, 0.3490659F);
		RML3 = new ModelRenderer(this, 0, 16);
		RML3.addBox(-3.5F, 4.5F, -0.5F, 2, 4, 1);
		RML3.setRotationPoint(-8F, 17F, 0F);
		RML3.setTextureSize(64, 32);
		RML3.mirror = true;
		setRotation(RML3, 0F, 0F, 0.6981317F);
		RML4 = new ModelRenderer(this, 0, 16);
		RML4.addBox(-1.5F, 8F, -0.5F, 1, 4, 1);
		RML4.setRotationPoint(-8F, 17F, 0F);
		RML4.setTextureSize(64, 32);
		RML4.mirror = true;
		setRotation(RML4, 0F, 0F, 0.8726646F);
		RFL1 = new ModelRenderer(this, 0, 16);
		RFL1.addBox(-4F, -1F, -1.5F, 5, 3, 3);
		RFL1.setRotationPoint(-8F, 17F, -6F);
		RFL1.setTextureSize(64, 32);
		RFL1.mirror = true;
		setRotation(RFL1, 0F, -0.3490659F, 0.3490659F);
		RFL2 = new ModelRenderer(this, 0, 16);
		RFL2.addBox(-5F, 0F, -1F, 2, 4, 2);
		RFL2.setRotationPoint(-8F, 17F, -6F);
		RFL2.setTextureSize(64, 32);
		RFL2.mirror = true;
		setRotation(RFL2, 0F, -0.3490659F, 0.3490659F);
		RFL3 = new ModelRenderer(this, 0, 16);
		RFL3.addBox(-3.5F, 4.5F, -0.5F, 2, 4, 1);
		RFL3.setRotationPoint(-8F, 17F, -6F);
		RFL3.setTextureSize(64, 32);
		RFL3.mirror = true;
		setRotation(RFL3, 0F, -0.3490659F, 0.6981317F);
		RFL4 = new ModelRenderer(this, 0, 16);
		RFL4.addBox(-1.5F, 8F, -0.5F, 1, 4, 1);
		RFL4.setRotationPoint(-8F, 17F, -6F);
		RFL4.setTextureSize(64, 32);
		RFL4.mirror = true;
		setRotation(RFL4, 0F, -0.3490659F, 0.8726646F);
	}

	@Override
	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
		setRotationAngles(par2, par3, par4, par5, par6, par7, entity);
		LBL1.render(par7);
		LBL2.render(par7);
		LBL3.render(par7);
		LBL4.render(par7);
		LML1.render(par7);
		LML2.render(par7);
		LML3.render(par7);
		LML4.render(par7);
		LFL1.render(par7);
		LFL2.render(par7);
		LFL3.render(par7);
		LFL4.render(par7);
		RBL1.render(par7);
		RBL2.render(par7);
		RBL3.render(par7);
		RBL4.render(par7);
		RML1.render(par7);
		RML2.render(par7);
		RML3.render(par7);
		RML4.render(par7);
		RFL1.render(par7);
		RFL2.render(par7);
		RFL3.render(par7);
		RFL4.render(par7);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity entity) {
		LBL1.rotateAngleX = MathHelper.cos(par1 * 2.0F + (float) Math.PI) * 0.7F * par2 + 0.25F;
		LBL2.rotateAngleX = MathHelper.cos(par1 * 2.0F + (float) Math.PI) * 0.7F * par2 + 0.25F;
		LBL3.rotateAngleX = MathHelper.cos(par1 * 2.0F + (float) Math.PI) * 0.7F * par2 + 0.3F;
		LBL4.rotateAngleX = MathHelper.cos(par1 * 2.0F + (float) Math.PI) * 0.7F * par2 + 0.334F;
		LML1.rotateAngleX = MathHelper.cos(par1 * 2.0F) * 0.7F * par2;
		LML2.rotateAngleX = MathHelper.cos(par1 * 2.0F) * 0.7F * par2;
		LML3.rotateAngleX = MathHelper.cos(par1 * 2.0F) * 0.7F * par2;
		LML4.rotateAngleX = MathHelper.cos(par1 * 2.0F) * 0.7F * par2;
		LFL1.rotateAngleX = MathHelper.cos(par1 * 2.0F + (float) Math.PI) * 0.7F * par2 - 0.25F;
		LFL2.rotateAngleX = MathHelper.cos(par1 * 2.0F + (float) Math.PI) * 0.7F * par2 - 0.25F;
		LFL3.rotateAngleX = MathHelper.cos(par1 * 2.0F + (float) Math.PI) * 0.7F * par2 - 0.3F;
		LFL4.rotateAngleX = MathHelper.cos(par1 * 2.0F + (float) Math.PI) * 0.7F * par2 - 0.334F;
		RBL1.rotateAngleX = MathHelper.cos(par1 * 2.0F) * 0.7F * par2 + 0.25F;
		RBL2.rotateAngleX = MathHelper.cos(par1 * 2.0F) * 0.7F * par2 + 0.25F;
		RBL3.rotateAngleX = MathHelper.cos(par1 * 2.0F) * 0.7F * par2 + 0.3F;
		RBL4.rotateAngleX = MathHelper.cos(par1 * 2.0F) * 0.7F * par2 + 0.334F;
		RML1.rotateAngleX = MathHelper.cos(par1 * 2.0F + (float) Math.PI) * 0.7F * par2;
		RML2.rotateAngleX = MathHelper.cos(par1 * 2.0F + (float) Math.PI) * 0.7F * par2;
		RML3.rotateAngleX = MathHelper.cos(par1 * 2.0F + (float) Math.PI) * 0.7F * par2;
		RML4.rotateAngleX = MathHelper.cos(par1 * 2.0F + (float) Math.PI) * 0.7F * par2;
		RFL1.rotateAngleX = MathHelper.cos(par1 * 2.0F) * 0.7F * par2 - 0.25F;
		RFL2.rotateAngleX = MathHelper.cos(par1 * 2.0F) * 0.7F * par2 - 0.25F;
		RFL3.rotateAngleX = MathHelper.cos(par1 * 2.0F) * 0.7F * par2 - 0.3F;
		RFL4.rotateAngleX = MathHelper.cos(par1 * 2.0F) * 0.7F * par2 - 0.334F;
	}
}