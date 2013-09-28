package erebus.world.genlayer;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import erebus.ModBiomes;

public class GenLayerBiomeErebus extends GenLayer {
	/** this sets all the biomes that are allowed to appear in the overworld */
	private BiomeGenBase[] allowedBiomes;

	public GenLayerBiomeErebus(long par1, GenLayer par3GenLayer) {
		super(par1);
		this.allowedBiomes = new BiomeGenBase[] { ModBiomes.underjungle, ModBiomes.underdesert, ModBiomes.undersavannah };
		this.parent = par3GenLayer;
	}

	/**
	 * Returns a list of integer values generated by this layer. These may be
	 * interpreted as temperatures, rainfall amounts, or biomeList[] indices
	 * based on the particular GenLayer subclass.
	 */
	@Override
	public int[] getInts(int par1, int par2, int par3, int par4) {
		// int[] aint = this.parent.getInts(par1, par2, par3, par4);
		int[] aint1 = IntCache.getIntCache(par3 * par4);

		for (int i1 = 0; i1 < par4; ++i1) {
			for (int j1 = 0; j1 < par3; ++j1) {
				this.initChunkSeed(j1 + par1, i1 + par2);
				// int k1 = aint[j1 + i1 * par3];
				BiomeGenBase biome = this.allowedBiomes[this.nextInt(this.allowedBiomes.length)];
				aint1[j1 + i1 * par3] = biome.biomeID;
			}
		}

		return aint1;
	}
}
