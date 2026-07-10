package net.mcreator.utility.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.utility.network.UtilityModVariables;

public class CReativeNightVisionGogglesBaubleIsUnequippedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			UtilityModVariables.PlayerVariables _vars = entity.getData(UtilityModVariables.PLAYER_VARIABLES);
			_vars.CreativeNightVisionGoglesIsEquped = false;
			_vars.markSyncDirty();
		}
	}
}