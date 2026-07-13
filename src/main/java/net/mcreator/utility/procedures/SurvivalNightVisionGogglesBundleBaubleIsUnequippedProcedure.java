package net.mcreator.utility.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.utility.network.UtilityModVariables;
import net.mcreator.utility.init.UtilityModMobEffects;

public class SurvivalNightVisionGogglesBundleBaubleIsUnequippedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			UtilityModVariables.PlayerVariables _vars = entity.getData(UtilityModVariables.PLAYER_VARIABLES);
			_vars.SurvivalNightVisionGogglesEquiped = false;
			_vars.markSyncDirty();
		}
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(UtilityModMobEffects.SURVIVAL_N_IGHT_VISION_GOGGLES_EFFECT)) {
			{
				UtilityModVariables.PlayerVariables _vars = entity.getData(UtilityModVariables.PLAYER_VARIABLES);
				_vars.SUrvivalNIghtVisionGogglesIsActiveBefereUnequip = true;
				_vars.markSyncDirty();
			}
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(UtilityModMobEffects.SURVIVAL_N_IGHT_VISION_GOGGLES_EFFECT);
		} else {
			{
				UtilityModVariables.PlayerVariables _vars = entity.getData(UtilityModVariables.PLAYER_VARIABLES);
				_vars.SUrvivalNIghtVisionGogglesIsActiveBefereUnequip = false;
				_vars.markSyncDirty();
			}
		}
	}
}