package erebus.world.feature;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import erebus.ModBlocks;

public class WorldGenBigMushroomErebus extends WorldGenerator {

	private int mushroomType = -1;

	public WorldGenBigMushroomErebus(int par1) {
		super(true);
		mushroomType = par1;
	}

	public WorldGenBigMushroomErebus() {
		super(false);
	}

	@Override
	public boolean generate(World world, Random rand, int par3, int par4, int par5) {
		int var6 = rand.nextInt(2);

		if (mushroomType >= 0)
			var6 = mushroomType;

		int var7 = rand.nextInt(3) + 4;
		boolean var8 = true;

		if (par4 >= 1 && par4 + var7 + 1 < 256) {
			int var9;
			int var11;
			int var12;
			int var13;

			for (var9 = par4; var9 <= par4 + 1 + var7; ++var9) {
				byte var10 = 3;

				if (var9 <= par4 + 3)
					var10 = 0;

				for (var11 = par3 - var10; var11 <= par3 + var10 && var8; ++var11)
					for (var12 = par5 - var10; var12 <= par5 + var10 && var8; ++var12)
						if (var9 >= 0 && var9 < 256) {
							var13 = world.getBlockId(var11, var9, var12);

							Block block = Block.blocksList[var13];

							if (var13 != 0 && block != null && !block.isLeaves(world, var11, var9, var12))
								var8 = false;
						} else
							var8 = false;
			}

			if (!var8)
				return false;
			else {
				var9 = world.getBlockId(par3, par4 - 1, par5);

				if (var9 != ModBlocks.umberstone.blockID && var9 != Block.obsidian.blockID && var9 != Block.glowStone.blockID)
					return false;
				else {
					int var16 = par4 + var7;

					if (var6 == 1)
						var16 = par4 + var7 - 3;

					for (var11 = var16; var11 <= par4 + var7; ++var11) {
						var12 = 1;

						if (var11 < par4 + var7)
							++var12;

						if (var6 == 0)
							var12 = 3;

						for (var13 = par3 - var12; var13 <= par3 + var12; ++var13)
							for (int var14 = par5 - var12; var14 <= par5 + var12; ++var14) {
								int var15 = 5;

								if (var13 == par3 - var12)
									--var15;

								if (var13 == par3 + var12)
									++var15;

								if (var14 == par5 - var12)
									var15 -= 3;

								if (var14 == par5 + var12)
									var15 += 3;

								if (var6 == 0 || var11 < par4 + var7) {
									if ((var13 == par3 - var12 || var13 == par3 + var12) && (var14 == par5 - var12 || var14 == par5 + var12))
										continue;

									if (var13 == par3 - (var12 - 1) && var14 == par5 - var12)
										var15 = 1;

									if (var13 == par3 - var12 && var14 == par5 - (var12 - 1))
										var15 = 1;

									if (var13 == par3 + var12 - 1 && var14 == par5 - var12)
										var15 = 3;

									if (var13 == par3 + var12 && var14 == par5 - (var12 - 1))
										var15 = 3;

									if (var13 == par3 - (var12 - 1) && var14 == par5 + var12)
										var15 = 7;

									if (var13 == par3 - var12 && var14 == par5 + var12 - 1)
										var15 = 7;

									if (var13 == par3 + var12 - 1 && var14 == par5 + var12)
										var15 = 9;

									if (var13 == par3 + var12 && var14 == par5 + var12 - 1)
										var15 = 9;
								}

								if (var15 == 5 && var11 < par4 + var7)
									var15 = 0;

								Block block = Block.blocksList[world.getBlockId(var13, var11, var14)];

								if ((var15 != 0 || par4 >= par4 + var7 - 1) && (block == null || block.canBeReplacedByLeaves(world, var13, var11, var14)))
									setBlockAndMetadata(world, var13, var11, var14, Block.mushroomCapBrown.blockID + var6, var15);
							}
					}

					for (var11 = 0; var11 < var7; ++var11) {
						var12 = world.getBlockId(par3, par4 + var11, par5);

						Block block = Block.blocksList[var12];

						if (block == null || block.canBeReplacedByLeaves(world, par3, par4 + var11, par5))
							setBlockAndMetadata(world, par3, par4 + var11, par5, Block.mushroomCapBrown.blockID + var6, 10);
					}

					return true;
				}
			}
		} else
			return false;
	}
}
