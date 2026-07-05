package net.mcreator.utility.procedures;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

public class DeterminamodalitaProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String modalita = "";
		if (getEntityGameType(entity) == GameType.SURVIVAL) {
			modalita = "survival";
		} else if (getEntityGameType(entity) == GameType.CREATIVE) {
			modalita = "creative";
		} else if (getEntityGameType(entity) == GameType.ADVENTURE) {
			modalita = "adventure";
		} else if (getEntityGameType(entity) == GameType.SPECTATOR) {
			modalita = "spectator";
		}
		return modalita;
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}