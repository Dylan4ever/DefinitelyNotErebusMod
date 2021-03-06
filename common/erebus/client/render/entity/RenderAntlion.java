package erebus.client.render.entity;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import erebus.client.model.entity.ModelAntlion;
import erebus.entity.EntityAntlion;

@SideOnly(Side.CLIENT)
public class RenderAntlion extends RenderLiving {

	private static ResourceLocation Texture;
	public RenderAntlion(ModelAntlion model, float par2) {
		super(model, par2);

	}

	@Override
	public void doRenderLiving(EntityLiving entityLiving, double par2, double par4, double par6, float par8, float par9) {
		super.doRenderLiving(entityLiving, par2, par4, par6, par8, par9);
	}

	@Override
	public void doRender(Entity entity, double par2, double par4, double par6, float par8, float par9) {
		super.doRenderLiving((EntityAntlion) entity, par2, par4, par6, par8, par9);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entityliving, float f) {
		scaleAntlion((EntityAntlion) entityliving, f);

	}

	protected void scaleAntlion(EntityAntlion entityAntlion, float f) {
		if (!entityAntlion.isBoss()) {
			float f1 = 0.75F;
			shadowSize = f1;
			GL11.glScalef(f1, f1, f1);
		} else {
			float f1 = 1.0F;
			shadowSize = f1;
			GL11.glScalef(f1, f1, f1);
		}

	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		EntityAntlion antlion = (EntityAntlion) entity;
		if (!antlion.isBoss())
			Texture = new ResourceLocation("erebus:textures/mob/ModelAntlion.png");
		if (antlion.isBoss())
			Texture = new ResourceLocation("erebus:textures/mob/ModelAntlionSandstone.png");
		return Texture;
	}
}
