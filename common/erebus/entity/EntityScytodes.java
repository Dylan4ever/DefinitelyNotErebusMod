package erebus.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpiderEffectsGroupData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityScytodes extends EntityMob {
	private int shouldDo;
	public int skin = rand.nextInt(4);
	public EntityScytodes(World par1World) {
		super(par1World);
		setSize(2F, 1F);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		dataWatcher.addObject(16, new Byte((byte) 0));
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if (!worldObj.isRemote)
			setBesideClimbableBlock(isCollidedHorizontally);
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(25.0D);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.800000011920929D);
	}

	@Override
	protected Entity findPlayerToAttack() {
		float f = getBrightness(1.0F);
		if (f < 0.5F) {
			double d0 = 16.0D;
			return worldObj.getClosestVulnerablePlayerToEntity(this, d0);
		} else
			return null;
	}

	@Override
	protected String getLivingSound() {
		return "mob.spider.say";
	}

	@Override
	protected String getHurtSound() {
		return "mob.spider.say";
	}

	@Override
	protected String getDeathSound() {
		return "mob.spider.death";
	}

	@Override
	protected void playStepSound(int par1, int par2, int par3, int par4) {
		playSound("mob.spider.step", 0.15F, 1.0F);
	}

	protected String getWebSlingThrowSound() {
		return "erebus:webslingthrow";
	}

	@Override
	protected void attackEntity(Entity entity, float distance) {
		if (distance <2.0F){
			super.attackEntity(entity, distance);
			attackEntityAsMob(entity);
		}
		if (distance > 2.0F && distance < 6.0F && rand.nextInt(10) == 0)
			if (onGround) {
				double d0 = entity.posX - posX;
				double d1 = entity.posZ - posZ;
				float f2 = MathHelper.sqrt_double(d0 * d0 + d1 * d1);
				motionX = d0 / f2 * 0.5D * 0.800000011920929D + motionX * 0.20000000298023224D;
				motionZ = d1 / f2 * 0.5D * 0.800000011920929D + motionZ * 0.20000000298023224D;
				motionY = 0.4000000059604645D;
			}
		if (distance >= 5 & distance < 8.0F)
			if (attackTime == 0) {
				++shouldDo;
				if (shouldDo == 1)
					attackTime = 60;
				else if (shouldDo <= 4)
					attackTime = 6;
				else {
					attackTime = 20;
					shouldDo = 0;
				}
				if (shouldDo > 1 && entity instanceof EntityPlayer) {
					worldObj.playSoundAtEntity(this, getWebSlingThrowSound(), 1.0F, 1.0F);
					for (int var10 = 0; var10 < 1; ++var10) {
						EntityWebSling var11 = new EntityWebSling(worldObj, this);
						var11.posY = posY + height / 2.0F + 0.5D;
						var11.setType((byte) 0);
						worldObj.spawnEntityInWorld(var11);
					}
				}
			}
	}

	@Override
	protected int getDropItemId() {
		return Item.silk.itemID;
	}

	@Override
	protected void dropFewItems(boolean par1, int par2) {
		super.dropFewItems(par1, par2);
		if (par1 && (rand.nextInt(3) == 0 || rand.nextInt(1 + par2) > 0))
			dropItem(Item.spiderEye.itemID, 1);
	}

	@Override
	public boolean isOnLadder() {
		return isBesideClimbableBlock();
	}

	@Override
	public void setInWeb() {
	}

	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.ARTHROPOD;
	}

	@Override
	public boolean isPotionApplicable(PotionEffect par1PotionEffect) {
		return par1PotionEffect.getPotionID() == Potion.poison.id ? false : super.isPotionApplicable(par1PotionEffect);
	}

	public boolean isBesideClimbableBlock() {
		return (dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	}


	public void setBesideClimbableBlock(boolean par1) {
		byte b0 = dataWatcher.getWatchableObjectByte(16);

		if (par1)
			b0 = (byte) (b0 | 1);
		else
			b0 &= -2;

		dataWatcher.updateObject(16, Byte.valueOf(b0));
	}

	@Override
	public EntityLivingData onSpawnWithEgg(EntityLivingData entityLivingData) {
		Object entityLivingData1 = super.onSpawnWithEgg(entityLivingData);

		if (worldObj.rand.nextInt(100) == 0) {
			EntityMoneySpider entityspidermoney = new EntityMoneySpider(worldObj);
			entityspidermoney.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
			entityspidermoney.onSpawnWithEgg((EntityLivingData) null);
			worldObj.spawnEntityInWorld(entityspidermoney);
			entityspidermoney.mountEntity(this);
		}
		if (entityLivingData1 == null) {
			entityLivingData1 = new SpiderEffectsGroupData();
			if (worldObj.difficultySetting > 2 && worldObj.rand.nextFloat() < 0.1F * worldObj.getLocationTensionFactor(posX, posY, posZ))
				((SpiderEffectsGroupData) entityLivingData1).func_111104_a(worldObj.rand);
		}
		if (entityLivingData1 instanceof SpiderEffectsGroupData) {
			int i = ((SpiderEffectsGroupData) entityLivingData1).field_111105_a;
			if (i > 0 && Potion.potionTypes[i] != null)
				addPotionEffect(new PotionEffect(i, Integer.MAX_VALUE));
		}
		return (EntityLivingData) entityLivingData1;
	}
}
