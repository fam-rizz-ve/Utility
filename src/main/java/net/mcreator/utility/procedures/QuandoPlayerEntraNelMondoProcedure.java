package net.mcreator.utility.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.utility.network.UtilityModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class QuandoPlayerEntraNelMondoProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		UtilityModVariables.MapVariables.get(world).numeroDiGIocatori = UtilityModVariables.MapVariables.get(world).numeroDiGIocatori + 1;
		UtilityModVariables.MapVariables.get(world).markSyncDirty();
	}
}