package net.mcreator.utility.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class FadedConcreteBlock extends Block {
	public FadedConcreteBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.DEEPSLATE).strength(0.6f).requiresCorrectToolForDrops().speedFactor(0.5f).jumpFactor(0.5f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}