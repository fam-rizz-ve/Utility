/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.utility.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.utility.block.InfectiontentaclesblockBlock;
import net.mcreator.utility.block.InfectionbrainBlock;
import net.mcreator.utility.block.FadedConcreteBlock;
import net.mcreator.utility.block.EssenctiondistilizerBlock;
import net.mcreator.utility.block.DungeongeneratorblockBlock;
import net.mcreator.utility.UtilityMod;

public class UtilityModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(UtilityMod.MODID);
	public static final DeferredBlock<Block> ESSENCTIONDISTILIZER;
	public static final DeferredBlock<Block> DUNGEONGENERATORBLOCK;
	public static final DeferredBlock<Block> FADED_CONCRETE;
	public static final DeferredBlock<Block> INFECTIONBRAIN;
	public static final DeferredBlock<Block> INFECTIONTENTACLESBLOCK;
	static {
		ESSENCTIONDISTILIZER = REGISTRY.register("essenctiondistilizer", EssenctiondistilizerBlock::new);
		DUNGEONGENERATORBLOCK = REGISTRY.register("dungeongeneratorblock", DungeongeneratorblockBlock::new);
		FADED_CONCRETE = REGISTRY.register("faded_concrete", FadedConcreteBlock::new);
		INFECTIONBRAIN = REGISTRY.register("infectionbrain", InfectionbrainBlock::new);
		INFECTIONTENTACLESBLOCK = REGISTRY.register("infectiontentaclesblock", InfectiontentaclesblockBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}