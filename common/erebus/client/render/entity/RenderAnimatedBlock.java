package erebus.client.render.entity;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import erebus.client.model.entity.ModelAnimatedBlock;
import erebus.entity.EntityAnimatedBlock;

@SideOnly(Side.CLIENT)
public class RenderAnimatedBlock extends RenderLiving {

	private final RenderBlocks blockRenderer = new RenderBlocks();

	public RenderAnimatedBlock(ModelAnimatedBlock model, float scale) {
		super(model, scale);
	}

	public void renderAnimatedBlock(EntityAnimatedBlock entity, double x, double y, double z, float par8, float par9) {
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glTranslatef((float) x, (float) y, (float) z);
		GL11.glTranslatef(0.0F, 0.75F, 0.0F);
		GL11.glRotatef(-entity.renderYawOffset, 0.0F, 1.0F, 0.0F);
		bindTexture(TextureMap.locationBlocksTexture);
		renderBlocks.renderBlockAsItem(Block.blocksList[entity.blockID], entity.blockMeta, 1.0F);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();

		super.doRenderLiving(entity, x, y, z, par8, par9);
	}

	@Override
	public void doRenderLiving(EntityLiving entity, double x, double y, double z, float par8, float par9) {
		renderAnimatedBlock((EntityAnimatedBlock) entity, x, y, z, par8, par9);
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float par8, float par9) {
		renderAnimatedBlock((EntityAnimatedBlock) entity, x, y, z, par8, par9);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entityliving, float scale) {
		shadowSize = 0.3F;
		GL11.glScalef(1.0F, 1.0F, 1.0F);
		EntityAnimatedBlock entityAnimatedBlock = (EntityAnimatedBlock) entityliving;
		if (entityAnimatedBlock.isClimbing())
			GL11.glRotatef(90.0F, -1.0F, 0.0F, 0.0F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		EntityAnimatedBlock animatedblock = (EntityAnimatedBlock) entity;
		return new ResourceLocation("textures/blocks/" + Block.blocksList[animatedblock.blockID].getIcon(0, animatedblock.blockMeta).getIconName() + ".png");
	}
}