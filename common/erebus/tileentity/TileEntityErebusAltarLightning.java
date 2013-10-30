package erebus.tileentity;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import erebus.ModBlocks;

public class TileEntityErebusAltarLightning extends TileEntity {

	public int animationTicks;
	public boolean active;
	public int fuzz;
	@Override
	public void updateEntity() {
		findEnemyToAttack();
		if (active) {
			if (animationTicks == 0)
				worldObj.playSoundEffect(xCoord, yCoord, zCoord, "erebus:altarchangestate", 1.0F, 1.3F);
			if (animationTicks <= 24)
				animationTicks++;
			if(animationTicks==25)
				if (fuzz < 20) {
					fuzz++;
					if (fuzz >= 20)
						fuzz = 0;
				}
		}
		if (!active) {
			if (animationTicks == 25)
				worldObj.playSoundEffect(xCoord, yCoord, zCoord, "erebus:altarchangestate", 1.0F, 1.3F);
			if (animationTicks >= 1)
				animationTicks--;
			if (animationTicks == 1)
				worldObj.setBlock(xCoord, yCoord, zCoord, ModBlocks.erebusAltar.blockID);
		}
		if (animationTicks >= 1 && animationTicks <= 24)
			flameOn(worldObj, xCoord, yCoord, zCoord);
	}

	@SideOnly(Side.CLIENT)
	public void flameOn(World par1World, int par2, int par3, int par4) {
		double d0 = par2 + 0.53125F;
		double d1 = par3 + 1.25F;
		double d2 = par4 + 0.53125F;
		par1World.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
		par1World.spawnParticle("flame", d0, d1, d2, 0.0D, 0.0D, 0.0D);
		par1World.spawnParticle("smoke", d0, d1, d2 - 0.265625, 0.0D, 0.0D, 0.0D);
		par1World.spawnParticle("flame", d0, d1, d2 - 0.265625, 0.0D, 0.0D, 0.0D);
		par1World.spawnParticle("smoke", d0, d1, d2 + 0.265625, 0.0D, 0.0D, 0.0D);
		par1World.spawnParticle("flame", d0, d1, d2 + 0.265625, 0.0D, 0.0D, 0.0D);
		par1World.spawnParticle("smoke", d0 - 0.265625, d1, d2, 0.0D, 0.0D, 0.0D);
		par1World.spawnParticle("flame", d0 - 0.265625, d1, d2, 0.0D, 0.0D, 0.0D);
		par1World.spawnParticle("smoke", d0 + 0.265625, d1, d2, 0.0D, 0.0D, 0.0D);
		par1World.spawnParticle("flame", d0 + 0.265625, d1, d2, 0.0D, 0.0D, 0.0D);
		par1World.spawnParticle("smoke", d0, d1 + 0.25, d2, 0.0D, 0.0D, 0.0D);
		par1World.spawnParticle("flame", d0, d1 + 0.25, d2, 0.0D, 0.0D, 0.0D);
		par1World.spawnParticle("smoke", d0, d1 + 0.5, d2, 0.0D, 0.0D, 0.0D);
		par1World.spawnParticle("flame", d0, d1 + 0.5, d2, 0.0D, 0.0D, 0.0D);
	}

	public void setActive(boolean par1) {
		active = par1;
	}

	protected Entity findEnemyToAttack() {
		List list = worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D, xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D).expand(6D, 2D, 6D));
		if (active)
			for (int i = 0; i < list.size(); i++) {
				Entity entity = (Entity) list.get(i);
				if (entity != null)
					if (entity instanceof EntityLivingBase)
						if (((EntityLivingBase) entity).getCreatureAttribute().equals(EnumCreatureAttribute.ARTHROPOD)) {
							double a = entity.posX;
							double b = entity.boundingBox.minY;
							double c = entity.posZ;
							EntityLightningBolt entitybolt = new EntityLightningBolt(worldObj, 0D, 0D, 0D);
							entitybolt.setLocationAndAngles(a, b, c, 0F, 0F);
							worldObj.addWeatherEffect(entitybolt);
						}
			}
		return null;
	}


	@Override
	public void writeToNBT(NBTTagCompound state) {
		super.writeToNBT(state);
		state.setInteger("animationTicks", animationTicks);
		state.setInteger("fuzz", fuzz);
		state.setBoolean("active", active);
	}

	@Override
	public void readFromNBT(NBTTagCompound state) {
		super.readFromNBT(state);
		animationTicks = state.getInteger("animationTicks");
		fuzz = state.getInteger("fuzz");
		active = state.getBoolean("active");
	}
}
