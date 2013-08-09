package erebus.block;

import java.util.Random;

import erebus.ErebusMod;
import erebus.ModBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockErebusOre extends Block
{
    public BlockErebusOre(int par1)
    {
        super(par1, Material.rock);
        this.setCreativeTab(ErebusMod.tabErebus);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID == ModBlocks.oreCoal_U.blockID ? Item.coal.itemID : (this.blockID == ModBlocks.oreDiamond_U.blockID ? Item.diamond.itemID : (this.blockID == ModBlocks.oreLapis_U.blockID ? Item.dyePowder.itemID : (this.blockID == ModBlocks.oreEmerald_U.blockID ? Item.emerald.itemID : (this.blockID == ModBlocks.oreJade_U.blockID ? null : this.blockID))));
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return this.blockID == ModBlocks.oreLapis_U.blockID ? 4 + par1Random.nextInt(5) : 1;
    }

    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */
    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        if (par1 > 0 && this.blockID != this.idDropped(0, par2Random, par1))
        {
            int j = par2Random.nextInt(par1 + 2) - 1;

            if (j < 0)
            {
                j = 0;
            }

            return this.quantityDropped(par2Random) * (j + 1);
        }
        else
        {
            return this.quantityDropped(par2Random);
        }
    }

    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);

        if (this.idDropped(par5, par1World.rand, par7) != this.blockID)
        {
            int j1 = 0;

            if (this.blockID == ModBlocks.oreCoal_U.blockID)
            {
                j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 0, 2);
            }
            else if (this.blockID == ModBlocks.oreDiamond_U.blockID)
            {
                j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 3, 7);
            }
            else if (this.blockID == ModBlocks.oreEmerald_U.blockID)
            {
                j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 3, 7);
            }
            else if (this.blockID == ModBlocks.oreLapis_U.blockID)
            {
                j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 2, 5);
            }
            else if (this.blockID == ModBlocks.oreJade_U.blockID)
            {
                j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 3, 7);
            }

            this.dropXpOnBlockBreak(par1World, par2, par3, par4, j1);
        }
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int par1)
    {
        return this.blockID == ModBlocks.oreLapis_U.blockID ? 4 : 0;
    }
}
