package net.mcreator.utility.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

public class InfectionbrainBlock extends Block {
	public InfectionbrainBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.LODESTONE).strength(20f, 10f).lightLevel(blockstate -> 8).requiresCorrectToolForDrops().hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true));
	}

	@Override
	public int getExpDrop(BlockState state, LevelAccessor level, BlockPos pos, BlockEntity blockEntity, Entity breaker, ItemStack tool) {
		return Mth.randomBetweenInclusive(level.getRandom(), 5, 10);
	}
}