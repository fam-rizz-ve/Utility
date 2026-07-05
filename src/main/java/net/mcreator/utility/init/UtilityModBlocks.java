/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.utility.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.utility.block.FadedConcreteBlock;
import net.mcreator.utility.block.EssenctiondistilizerBlock;
import net.mcreator.utility.block.DungeongeneratorblockBlock;
import net.mcreator.utility.UtilityMod;

public class UtilityModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(UtilityMod.MODID);
	public static final DeferredBlock<Block> ESSENCTIONDISTILIZER;
	public static final DeferredBlock<Block> DUNGEONGENERATORBLOCK;
	public static final DeferredBlock<Block> FADED_CONCRETE;
	static {
		ESSENCTIONDISTILIZER = REGISTRY.register("essenctiondistilizer", EssenctiondistilizerBlock::new);
		DUNGEONGENERATORBLOCK = REGISTRY.register("dungeongeneratorblock", DungeongeneratorblockBlock::new);
		FADED_CONCRETE = REGISTRY.register("faded_concrete", FadedConcreteBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}