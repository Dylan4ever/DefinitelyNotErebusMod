package erebus.client.render.entity;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import erebus.client.model.entity.ModelAnimatedChest;
import erebus.entity.EntityAnimatedChest;

public class RenderAnimatedChest extends RenderLiving
{
	private static final ResourceLocation Texture = new ResourceLocation("erebus:textures/mob/ModelAnimatedChest.png");

	public RenderAnimatedChest(ModelAnimatedChest model, float shadowSize)
	{
		super(model, shadowSize);
	}

	public void renderAnimatedChest(EntityAnimatedChest entityAnimatedChest, double x, double y, double z, float rotationYaw, float partialTickTime)
	{
		super.doRenderLiving(entityAnimatedChest, x, y, z, rotationYaw, partialTickTime);
	}

	@Override
	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float rotationYaw, float partialTickTime)
	{
		renderAnimatedChest((EntityAnimatedChest)entityLiving, x, y, z, rotationYaw, partialTickTime);
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float rotationYaw, float partialTickTime)
	{
		renderAnimatedChest((EntityAnimatedChest)entity, x, y, z, rotationYaw, partialTickTime);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return Texture;
	}

}
