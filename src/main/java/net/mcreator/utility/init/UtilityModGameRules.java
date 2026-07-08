/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.utility.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.GameRules;

@EventBusSubscriber
public class UtilityModGameRules {
	public static GameRules.Key<GameRules.BooleanValue> INVENTORY_EDTIOR;

	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		INVENTORY_EDTIOR = GameRules.register("inventoryEdtior", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
	}
}