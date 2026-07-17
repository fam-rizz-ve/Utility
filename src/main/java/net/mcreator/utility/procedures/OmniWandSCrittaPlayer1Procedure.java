package net.mcreator.utility.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.utility.network.UtilityModVariables;

public class OmniWandSCrittaPlayer1Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return entity.getData(UtilityModVariables.PLAYER_VARIABLES).NomeMostratoOmniWand1;
	}
}