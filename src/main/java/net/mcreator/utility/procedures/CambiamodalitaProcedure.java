package net.mcreator.utility.procedures;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.utility.network.UtilityModVariables;

public class CambiamodalitaProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getData(UtilityModVariables.PLAYER_VARIABLES).ultima_gamemode).equals("survival")) {
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.SURVIVAL);
		} else if ((entity.getData(UtilityModVariables.PLAYER_VARIABLES).ultima_gamemode).equals("creative")) {
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.CREATIVE);
		} else if ((entity.getData(UtilityModVariables.PLAYER_VARIABLES).ultima_gamemode).equals("adventure")) {
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.ADVENTURE);
		} else if ((entity.getData(UtilityModVariables.PLAYER_VARIABLES).ultima_gamemode).equals("spectator")) {
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.SPECTATOR);
		}
	}
}