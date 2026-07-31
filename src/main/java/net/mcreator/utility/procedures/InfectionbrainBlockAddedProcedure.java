package net.mcreator.utility.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.utility.init.UtilityModBlocks;

public class InfectionbrainBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(BlockPos.containing(x + 1, y, z), UtilityModBlocks.INFECTIONTENTACLESBLOCK.get().defaultBlockState(), 3);
		world.setBlock(BlockPos.containing(x - 1, y, z), UtilityModBlocks.INFECTIONTENTACLESBLOCK.get().defaultBlockState(), 3);
		world.setBlock(BlockPos.containing(x, y, z + 1), UtilityModBlocks.INFECTIONTENTACLESBLOCK.get().defaultBlockState(), 3);
		world.setBlock(BlockPos.containing(x, y, z - 1), UtilityModBlocks.INFECTIONTENTACLESBLOCK.get().defaultBlockState(), 3);
		while (true) {
			world.setBlock(BlockPos.containing(x + Mth.nextInt(RandomSource.create(), 1, 10), y, z), UtilityModBlocks.INFECTIONTENTACLESBLOCK.get().defaultBlockState(), 3);
		}
	}
}