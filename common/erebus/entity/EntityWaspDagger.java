package erebus.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityWaspDagger extends EntityThrowable {
	public static float rotationticks;
	public EntityWaspDagger(World par1World) {
		super(par1World);
	}

	public EntityWaspDagger(World par1World, EntityLivingBase par2EntityLiving) {
		super(par1World, par2EntityLiving);
	}

	public EntityWaspDagger(World par1World, double par2, double par4, double par6) {
		super(par1World, par2, par4, par6);
	}

	@Override
	protected void onImpact(MovingObjectPosition MovingObjectPosition) {
		if (MovingObjectPosition.entityHit != null) {
			byte byte0 = 4;
			if (MovingObjectPosition.entityHit instanceof EntityWasp)
				byte0 = 0;
			if (!MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), byte0))
				;
		}
		for (int i = 0; i < 8; i++)
			worldObj.spawnParticle("reddust", posX, posY, posZ, 0.0D, 0.0D, 0.0D);
		if (!worldObj.isRemote)
			setDead();
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if (rotationticks < 360F) {
			rotationticks = rotationticks + 20F;
			if (rotationticks >= 360F)
				rotationticks = 0;
		}
	}
}