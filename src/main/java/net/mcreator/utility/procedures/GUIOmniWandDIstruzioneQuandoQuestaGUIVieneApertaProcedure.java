package net.mcreator.utility.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.utility.network.UtilityModVariables;
import net.mcreator.utility.init.UtilityModMenus;

public class GUIOmniWandDIstruzioneQuandoQuestaGUIVieneApertaProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && _player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu)
			_menu.sendMenuStateUpdate(_player, 2, "WidthAndDepth", entity.getData(UtilityModVariables.PLAYER_VARIABLES).GrandezzaCuboXZOmniWandDistruzione, true);
		if (entity instanceof Player _player && _player.containerMenu instanceof UtilityModMenus.MenuAccessor _menu)
			_menu.sendMenuStateUpdate(_player, 2, "altezza", entity.getData(UtilityModVariables.PLAYER_VARIABLES).GrandezzaCuboYOmniWandDistruzione, true);
	}
}