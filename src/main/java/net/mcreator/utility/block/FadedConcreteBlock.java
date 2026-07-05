package net.mcreator.utility.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class FadedConcreteBlock extends Block {
	public FadedConcreteBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.DEEPSLATE).strength(0.6f).requiresCorrectToolForDrops().speedFactor(0.5f).jumpFactor(0.5f));
	}
}