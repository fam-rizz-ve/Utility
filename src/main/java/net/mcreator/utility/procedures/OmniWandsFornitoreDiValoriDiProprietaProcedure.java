package net.mcreator.utility.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.utility.network.UtilityModVariables;

public class OmniWandsFornitoreDiValoriDiProprietaProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		return entity.getData(UtilityModVariables.PLAYER_VARIABLES).ModalitaOmniWand;
	}
}