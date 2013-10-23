package erebus.entity;

import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import erebus.ModItems;
import erebus.tileentity.TileEntityAnimatedChest;
import erebus.utils.Utils;

public class EntityAnimatedChest extends EntityAnimatedBlock {

	public ItemStack[] inventory;
	boolean isOpen = false;
	boolean canClose;
	public float openticks = 0;

	public EntityAnimatedChest(World world) {
		super(world);
		inventory = new ItemStack[27];
		tasks.removeTask(aiWander);
		tasks.removeTask(aiAttackOnCollide);
		tasks.removeTask(aiAttackNearestTarget);
		tasks.addTask(1, new EntityAITempt(this, 1.0D, ModItems.wandOfAnimation.itemID, false));
	}

	public EntityAnimatedChest setContents(IInventory chest) {
		if (chest == null)
			return this;

		inventory = new ItemStack[27];
		for (int i = 0; i < 27; i++) {
			if (chest.getStackInSlot(i) == null)
				continue;
			inventory[i] = chest.getStackInSlot(i).copy();
			chest.setInventorySlotContents(i, null);
		}
		return this;
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if (!worldObj.isRemote && isDead)
			for (ItemStack stack : inventory)
				if (stack != null)
					Utils.dropStack(worldObj, (int) posX, (int) posY, (int) posZ, stack);
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (isOpen)
			if (openticks > -1.570F) //
				openticks = openticks - 0.3925F;//
		if (!isOpen)
			if (openticks < 0F)
				openticks = openticks + 0.3925F;
	}

	@Override
	// TODO make it open and show inventory
	public boolean interact(EntityPlayer player) {
		if (worldObj.isRemote)
			return true;
		ItemStack stack = player.inventory.getCurrentItem();
		if (stack != null && stack.itemID == ModItems.wandOfAnimation.itemID) {
			setDead();
			worldObj.setBlock(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ), blockID, blockMeta, 3);
			TileEntityChest chest = (TileEntityChest) worldObj.getBlockTileEntity(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ));
			for(int i = 0; i < 27; i++)
				chest.setInventorySlotContents(i, inventory[i]);
			return true;
		} else if (stack == null) {
			player.displayGUIChest(new TileEntityAnimatedChest(this));
			setOpen(true);
			System.out.println(isOpen);
			return true;
		} else
			return false;
	}

	protected void setOpen(boolean open) {
		isOpen = open;
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound data) {
		super.writeEntityToNBT(data);

		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < inventory.length; i++)
			if (inventory[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				inventory[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}

		data.setTag("Items", nbttaglist);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound data) {
		super.readEntityFromNBT(data);

		NBTTagList nbttaglist = data.getTagList("Items");
		inventory = new ItemStack[27];

		for (int i = 0; i < nbttaglist.tagCount(); i++) {
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");

			if (b0 >= 0 && b0 < inventory.length)
				inventory[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
		}
	}
}