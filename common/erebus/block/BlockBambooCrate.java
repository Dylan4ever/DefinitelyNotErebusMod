package erebus.block;

import java.util.Random;

import erebus.ErebusMod;
import erebus.core.helper.LogHelper;
import erebus.core.proxy.CommonProxy;
import erebus.tileentity.TileEntityBambooCrate;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.world.World;

/**
 * @author ProPercivalalb
 */
public class BlockBambooCrate extends BlockContainer {

	private final Random crateRand = new Random();
	
	public BlockBambooCrate(int par1) {
		super(par1, Material.wood);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityBambooCrate();
	}
	
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon("erebus:bambooCrate");
    }
	
	public enum Row {
		BOTTOM,
		TOP,
		UNKNOWN;
	}
	
	public boolean squareCrate(World world, int x, int y, int z) {
		for(int xCount = x - 1; xCount < x + 2; xCount++) {
			for(int yCount = y - 1; yCount < y + 2; yCount++) {
				for(int zCount = z - 1; zCount < z + 2; zCount++) {
					boolean flag1 = xCount == x - 1;
					boolean flag2 = xCount == x + 2;
					boolean flag3 = yCount == y - 1;
					boolean flag4 = yCount == y + 2;
					boolean flag5 = zCount == z - 1;
					boolean flag6 = zCount == z + 2;
					int blockId = world.getBlockId(xCount, yCount, zCount); 
					int blockMeta = world.getBlockMetadata(xCount, yCount, zCount); 
					if(flag1 || flag2 || flag3 || flag4 || flag5 || flag6) {
						if(blockId == blockID) {
							return false;
						}
					}
					else {
						if(blockId != blockID) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	public boolean squareCrateExcluede(World world, int x, int y, int z) {
		for(int xCount = x - 1; xCount < x + 2; xCount++) {
			for(int yCount = y - 1; yCount < y + 2; yCount++) {
				for(int zCount = z - 1; zCount < z + 2; zCount++) {
					if(xCount == x && yCount == y && zCount == z) continue;
					boolean flag1 = xCount == x - 1;
					boolean flag2 = xCount == x + 2;
					boolean flag3 = yCount == y - 1;
					boolean flag4 = yCount == y + 2;
					boolean flag5 = zCount == z - 1;
					boolean flag6 = zCount == z + 2;
					int blockId = world.getBlockId(xCount, yCount, zCount); 
					int blockMeta = world.getBlockMetadata(xCount, yCount, zCount); 
					if(flag1 || flag2 || flag3 || flag4 || flag5 || flag6) {
						if(blockId == blockID) {
							return false;
						}
					}
					else {
						if(blockId != blockID) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	public boolean isValidCrate(World world, int x, int y, int z) {
		if(world.getBlockId(x, y - 1, z) == blockID) y--;
		if(world.getBlockId(x - 1, y, z) == blockID) x--;
		if(world.getBlockId(x, y, z - 1) == blockID) z--;
		return this.squareCrate(world, x, y, z);
	}
	
	public void mark(World world, int x, int y, int z) {
		if(world.isRemote) return;
		if(world.getBlockId(x, y - 1, z) == blockID) y--;
		if(world.getBlockId(x - 1, y, z) == blockID) x--;
		if(world.getBlockId(x, y, z - 1) == blockID) z--;
		for(int xCount = x; xCount <= x + 1; xCount++) {
			for(int yCount = y; yCount <= y + 1; yCount++) {
				for(int zCount = z; zCount <= z + 1; zCount++) {
					world.setBlockMetadataWithNotify(xCount, yCount, zCount, 1, 3);
					//world.setBlock(xCount, yCount + 3, zCount, blockID, 1, 3);
				}
			}
		}
	}
	
	public void unmark(World world, int x, int y, int z) {
		if(world.isRemote) return;
		if(world.getBlockId(x, y - 1, z) == blockID) y--;
		if(world.getBlockId(x - 1, y, z) == blockID) x--;
		if(world.getBlockId(x, y, z - 1) == blockID) z--;
		for(int xCount = x; xCount <= x + 1; xCount++) {
			for(int yCount = y; yCount <= y + 1; yCount++) {
				for(int zCount = z; zCount <= z + 1; zCount++) {
					world.setBlockMetadataWithNotify(xCount, yCount, zCount, 0, 3);
					//world.setBlock(xCount, yCount + 3, zCount, blockID, 1, 3);
				}
			}
		}
	}
	
	@Override
	public void onPostBlockPlaced(World world, int x, int y, int z, int par5) {
		boolean isValid = this.isValidCrate(world, x, y, z);
		if(isValid) {
			this.mark(world, x, y, z);
		}
	}
	
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        if (world.isRemote) {
            return true;
        }
        else
        {
            TileEntityBambooCrate tileentitybamboocrate = (TileEntityBambooCrate)world.getBlockTileEntity(x, y, z);

            if (tileentitybamboocrate != null) {
                player.openGui(ErebusMod.instance, CommonProxy.GUI_ID_BAMBOO_CRATE, world, x, y, z);
            }

            return true;
        }
    }

	@Override
    public int getRenderType() {
    	return -1;
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
    	unmark(par1World, par2, par3, par4);
    	
        TileEntityBambooCrate tileentitycrate = (TileEntityBambooCrate)par1World.getBlockTileEntity(par2, par3, par4);

        if (tileentitycrate != null)
        {
                for (int j1 = 0; j1 < tileentitycrate.getSizeInventory(); ++j1)
                {
                    ItemStack itemstack = tileentitycrate.getStackInSlot(j1);

                    if (itemstack != null)
                    {
                        float f = this.crateRand.nextFloat() * 0.8F + 0.1F;
                        float f1 = this.crateRand.nextFloat() * 0.8F + 0.1F;
                        float f2 = this.crateRand.nextFloat() * 0.8F + 0.1F;

                        while (itemstack.stackSize > 0)
                        {
                            int k1 = this.crateRand.nextInt(21) + 10;

                            if (k1 > itemstack.stackSize)
                            {
                                k1 = itemstack.stackSize;
                            }

                            itemstack.stackSize -= k1;
                            EntityItem entityitem = new EntityItem(par1World, (double)((float)par2 + f), (double)((float)par3 + f1), (double)((float)par4 + f2), new ItemStack(itemstack.itemID, k1, itemstack.getItemDamage()));

                            if (itemstack.hasTagCompound())
                            {
                                entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                            }

                            float f3 = 0.05F;
                            entityitem.motionX = (double)((float)this.crateRand.nextGaussian() * f3);
                            entityitem.motionY = (double)((float)this.crateRand.nextGaussian() * f3 + 0.2F);
                            entityitem.motionZ = (double)((float)this.crateRand.nextGaussian() * f3);
                            par1World.spawnEntityInWorld(entityitem);
                        }
                    }
                }

                par1World.func_96440_m(par2, par3, par4, par5);
            }
        
        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }
}
