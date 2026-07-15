package net.mcreator.utility.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.utility.network.UtilityModVariables;

public class QuandoPulsanteTeleportOmniWandECliccatoProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			UtilityModVariables.PlayerVariables _vars = entity.getData(UtilityModVariables.PLAYER_VARIABLES);
			_vars.ModalitaOmniWand = 3;
			_vars.markSyncDirty();
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}