package net.mcreator.utility.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.utility.network.UtilityModVariables;
import net.mcreator.utility.init.UtilityModMenus;

public class PulsanteConfirmOmniWandDistruzioneCLiccatoProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			UtilityModVariables.PlayerVariables _vars = entity.getData(UtilityModVariables.PLAYER_VARIABLES);
			_vars.GrandezzaCuboXZOmniWandDistruzione = (entity instanceof Player _entity0 && _entity0.containerMenu instanceof UtilityModMenus.MenuAccessor _menu0) ? _menu0.getMenuState(2, "BaseCubo", 0.0) : 0.0;
			_vars.GrandezzaCuboYOmniWandDistruzione = (entity instanceof Player _entity1 && _entity1.containerMenu instanceof UtilityModMenus.MenuAccessor _menu1) ? _menu1.getMenuState(2, "altezza", 0.0) : 0.0;
			_vars.markSyncDirty();
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}