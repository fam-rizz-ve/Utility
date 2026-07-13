package net.mcreator.utility.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

import net.mcreator.utility.network.UtilityModVariables;

public class SurvivalNightVisionGogglesBundleBaubleIsUnequippedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			UtilityModVariables.PlayerVariables _vars = entity.getData(UtilityModVariables.PLAYER_VARIABLES);
			_vars.SurvivalNightVisionGogglesEquiped = false;
			_vars.markSyncDirty();
		}
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.NIGHT_VISION);
	}
}