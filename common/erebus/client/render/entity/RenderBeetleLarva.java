package erebus.client.render.entity;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import erebus.client.model.entity.ModelBeetleLarva;
import erebus.entity.EntityBeetleLarva;

@SideOnly(Side.CLIENT)
public class RenderBeetleLarva extends RenderLiving {

	private static final ResourceLocation Texture = new ResourceLocation("erebus:textures/entities/larva.png");

	public RenderBeetleLarva(ModelBeetleLarva model, float shadowSize) {
		super(model, shadowSize);

	}

	public void renderBeetleLarva(EntityBeetleLarva entityBeetleLarva, double x, double y, double z, float rotationYaw, float partialTickTime) {
		super.doRenderLiving(entityBeetleLarva, x, y, z, rotationYaw, partialTickTime);
	}

	@Override
	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float rotationYaw, float partialTickTime) {
		renderBeetleLarva((EntityBeetleLarva) entityLiving, x, y, z, rotationYaw, partialTickTime);
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float rotationYaw, float partialTickTime) {
		renderBeetleLarva((EntityBeetleLarva) entity, x, y, z, rotationYaw, partialTickTime);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entityliving, float f) {
		shadowSize = 0.3F;
		// GL11.glScalef(1F, 1F, 1F); - unnecessary?
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return Texture;
	}
}
