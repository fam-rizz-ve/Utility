package net.mcreator.utility.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.utility.network.UtilityModVariables;

public class OmniWandsInformazioniSpecialiProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String Tips = "";
		if (entity.getData(UtilityModVariables.PLAYER_VARIABLES).ModalitaOmniWand == 1) {
			Tips = "In this mode if you attack an entity it despawn. ";
		} else if (entity.getData(UtilityModVariables.PLAYER_VARIABLES).ModalitaOmniWand == 2) {
			Tips = "modalit\u00E0 distruzione";
		} else if (entity.getData(UtilityModVariables.PLAYER_VARIABLES).ModalitaOmniWand == 3) {
			Tips = "modalit\u00E0 teletrasporto";
		} else if (entity.getData(UtilityModVariables.PLAYER_VARIABLES).ModalitaOmniWand == 4) {
			Tips = "modalit\u00E0 building";
		}
		return Tips + "You can press alt+ right click for change the mode of the wand";
	}
}