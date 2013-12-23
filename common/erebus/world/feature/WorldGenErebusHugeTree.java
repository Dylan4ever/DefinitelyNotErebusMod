package erebus.world.feature;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import erebus.ModBlocks;

public class WorldGenErebusHugeTree extends WorldGenerator {

	private final int baseHeight;
	private final int woodMetadata;
	private final int leavesMetadata;
	private final boolean thorns;
	private final int woodID;
	private final int leavesID;

	public WorldGenErebusHugeTree(boolean par1, int par2, int par3, int par4, boolean par5, int par6, int par7) {
		super(par1);
		baseHeight = par2;
		woodMetadata = par3;
		leavesMetadata = par4;
		thorns = par5;
		woodID = par6;
		leavesID = par7;
	}

	@Override
	public boolean generate(World world, Random rand, int par3, int par4, int par5) {
		int var6 = rand.nextInt(3) + baseHeight;
		boolean var7 = true;

		if (par4 >= 1 && par4 + var6 + 1 <= 256) {
			int var8;
			int var10;
			int var11;
			int var12;

			for (var8 = par4; var8 <= par4 + 1 + var6; ++var8) {
				byte var9 = 2;

				if (var8 == par4)
					var9 = 1;

				if (var8 >= par4 + 1 + var6 - 2)
					var9 = 2;

				for (var10 = par3 - var9; var10 <= par3 + var9 && var7; ++var10)
					for (var11 = par5 - var9; var11 <= par5 + var9 && var7; ++var11)
						if (var8 >= 0 && var8 < 256) {
							var12 = world.getBlockId(var10, var8, var11);

							if (var12 != 0 && Block.blocksList[var12] != null && !Block.blocksList[var12].isLeaves(world, var10, var8, var11) && var12 != Block.grass.blockID && var12 != Block.dirt.blockID && Block.blocksList[var12] != null &&
							!Block.blocksList[var12].isWood(world, var10, var8, var11) && var12 != Block.sapling.blockID)
								var7 = false;
						} else
							var7 = false;
			}

			if (!var7)
				return false;
			else {
				var8 = world.getBlockId(par3, par4 - 1, par5);

				if ((var8 == Block.grass.blockID || var8 == Block.dirt.blockID) && par4 < 256 - var6 - 1) {
					world.setBlock(par3, par4 - 1, par5, Block.dirt.blockID);
					world.setBlock(par3 + 1, par4 - 1, par5, Block.dirt.blockID);
					world.setBlock(par3, par4 - 1, par5 + 1, Block.dirt.blockID);
					world.setBlock(par3 + 1, par4 - 1, par5 + 1, Block.dirt.blockID);
					growLeaves(world, par3, par5, par4 + var6, 2, rand);

					for (int var14 = par4 + var6 - 2 - rand.nextInt(4); var14 > par4 + var6 / 2; var14 -= 2 + rand.nextInt(4)) {
						float var15 = rand.nextFloat() * (float) Math.PI * 2.0F;
						var11 = par3 + (int) (0.5F + MathHelper.cos(var15) * 4.0F);
						var12 = par5 + (int) (0.5F + MathHelper.sin(var15) * 4.0F);
						growLeaves(world, var11, var12, var14, 0, rand);

						for (int var13 = 0; var13 < 5; ++var13) {
							var11 = par3 + (int) (1.5F + MathHelper.cos(var15) * var13);
							var12 = par5 + (int) (1.5F + MathHelper.sin(var15) * var13);
							setBlockAndMetadata(world, var11, var14 - 3 + var13 / 2, var12, woodID, woodMetadata);
						}
					}

					for (var10 = 0; var10 < var6; ++var10) {
						var11 = world.getBlockId(par3, par4 + var10, par5);

						if (var11 == 0 || Block.blocksList[var11] == null || Block.blocksList[var11].isLeaves(world, par3, par4 + var10, par5)) {
							setBlockAndMetadata(world, par3, par4 + var10, par5, woodID, woodMetadata);

							if (var10 > 0) {
								if (rand.nextInt(3) > 0 && world.isAirBlock(par3 - 1, par4 + var10, par5) && thorns == true)
									setBlockAndMetadata(world, par3 - 1, par4 + var10, par5, ModBlocks.thorns.blockID, 8);

								if (rand.nextInt(3) > 0 && world.isAirBlock(par3, par4 + var10, par5 - 1) && thorns == true)
									setBlockAndMetadata(world, par3, par4 + var10, par5 - 1, ModBlocks.thorns.blockID, 1);
							}
						}

						if (var10 < var6 - 1) {
							var11 = world.getBlockId(par3 + 1, par4 + var10, par5);

							if (var11 == 0 || Block.blocksList[var11] == null || Block.blocksList[var11].isLeaves(world, par3 + 1, par4 + var10, par5)) {
								setBlockAndMetadata(world, par3 + 1, par4 + var10, par5, woodID, woodMetadata);

								if (var10 > 0) {
									if (rand.nextInt(3) > 0 && world.isAirBlock(par3 + 2, par4 + var10, par5) && thorns == true)
										setBlockAndMetadata(world, par3 + 2, par4 + var10, par5, ModBlocks.thorns.blockID, 2);

									if (rand.nextInt(3) > 0 && world.isAirBlock(par3 + 1, par4 + var10, par5 - 1) && thorns == true)
										setBlockAndMetadata(world, par3 + 1, par4 + var10, par5 - 1, ModBlocks.thorns.blockID, 1);
								}
							}

							var11 = world.getBlockId(par3 + 1, par4 + var10, par5 + 1);

							if (var11 == 0 || Block.blocksList[var11] == null || Block.blocksList[var11].isLeaves(world, par3 + 1, par4 + var10, par5 + 1)) {
								setBlockAndMetadata(world, par3 + 1, par4 + var10, par5 + 1, woodID, woodMetadata);

								if (var10 > 0) {
									if (rand.nextInt(3) > 0 && world.isAirBlock(par3 + 2, par4 + var10, par5 + 1) && thorns == true)
										setBlockAndMetadata(world, par3 + 2, par4 + var10, par5 + 1, ModBlocks.thorns.blockID, 2);

									if (rand.nextInt(3) > 0 && world.isAirBlock(par3 + 1, par4 + var10, par5 + 2) && thorns == true)
										setBlockAndMetadata(world, par3 + 1, par4 + var10, par5 + 2, ModBlocks.thorns.blockID, 4);
								}
							}

							var11 = world.getBlockId(par3, par4 + var10, par5 + 1);

							if (var11 == 0 || Block.blocksList[var11] == null || Block.blocksList[var11].isLeaves(world, par3, par4 + var10, par5 + 1)) {
								setBlockAndMetadata(world, par3, par4 + var10, par5 + 1, woodID, woodMetadata);

								if (var10 > 0) {
									if (rand.nextInt(3) > 0 && world.isAirBlock(par3 - 1, par4 + var10, par5 + 1) && thorns == true)
										setBlockAndMetadata(world, par3 - 1, par4 + var10, par5 + 1, ModBlocks.thorns.blockID, 8);

									if (rand.nextInt(3) > 0 && world.isAirBlock(par3, par4 + var10, par5 + 2) && thorns == true)
										setBlockAndMetadata(world, par3, par4 + var10, par5 + 2, ModBlocks.thorns.blockID, 4);
								}
							}
						}
					}

					return true;
				} else
					return false;
			}
		} else
			return false;
	}

	private void growLeaves(World world, int par2, int par3, int par4, int par5, Random par6Random) {
		byte var7 = 2;

		for (int var8 = par4 - var7; var8 <= par4; ++var8) {
			int var9 = var8 - par4;
			int var10 = par5 + 1 - var9;

			for (int var11 = par2 - var10; var11 <= par2 + var10 + 1; ++var11) {
				int var12 = var11 - par2;

				for (int var13 = par3 - var10; var13 <= par3 + var10 + 1; ++var13) {
					int var14 = var13 - par3;

					Block block = Block.blocksList[world.getBlockId(var11, var8, var13)];

					if ((var12 >= 0 || var14 >= 0 || var12 * var12 + var14 * var14 <= var10 * var10) && (var12 <= 0 && var14 <= 0 || var12 * var12 + var14 * var14 <= (var10 + 1) * (var10 + 1)) && (par6Random.nextInt(4) != 0 || var12 * var12 + var14 * var14 <= (var10 - 1) * (var10 - 1)) &&
					(block == null || block.canBeReplacedByLeaves(world, var11, var8, var13)))
						setBlockAndMetadata(world, var11, var8, var13, leavesID, leavesMetadata);
				}
			}
		}
	}
}