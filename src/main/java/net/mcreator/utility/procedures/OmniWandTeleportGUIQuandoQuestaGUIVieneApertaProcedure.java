package net.mcreator.utility.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.MutableComponent;

import net.mcreator.utility.network.UtilityModVariables;

import java.util.ArrayList;

public class OmniWandTeleportGUIQuandoQuestaGUIVieneApertaProcedure {
	public static void execute(LevelAccessor world) {
		UtilityModVariables.MapVariables.get(world).lista_giocatori = "";
		UtilityModVariables.MapVariables.get(world).markSyncDirty();
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			UtilityModVariables.MapVariables.get(world).lista_giocatori = UtilityModVariables.MapVariables.get(world).lista_giocatori + "," + ((MutableComponent) entityiterator.getDisplayName()).getString();
			UtilityModVariables.MapVariables.get(world).markSyncDirty();
		}
		UtilityModVariables.MapVariables.get(world).lista_giocatori = UtilityModVariables.MapVariables.get(world).lista_giocatori.substring(1);
		UtilityModVariables.MapVariables.get(world).markSyncDirty();
	}
}