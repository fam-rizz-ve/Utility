package net.mcreator.utility.procedures;

import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.utility.network.UtilityModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class QuandoSiAvviaIlMondoProcedure {
	@SubscribeEvent
	public static void onWorldLoad(net.neoforged.neoforge.event.level.LevelEvent.Load event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		UtilityModVariables.MapVariables.get(world).numeroDiGIocatori = 0;
		UtilityModVariables.MapVariables.get(world).markSyncDirty();
	}
}