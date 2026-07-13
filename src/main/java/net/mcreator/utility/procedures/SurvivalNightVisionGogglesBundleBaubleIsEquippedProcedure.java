package net.mcreator.utility.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.utility.network.UtilityModVariables;
import net.mcreator.utility.init.UtilityModMobEffects;

public class SurvivalNightVisionGogglesBundleBaubleIsEquippedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(UtilityModVariables.PLAYER_VARIABLES).SUrvivalNIghtVisionGogglesIsActiveBefereUnequip) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(UtilityModMobEffects.SURVIVAL_N_IGHT_VISION_GOGGLES_EFFECT, -1, 0, false, false));
		}
		{
			UtilityModVariables.PlayerVariables _vars = entity.getData(UtilityModVariables.PLAYER_VARIABLES);
			_vars.SurvivalNightVisionGogglesEquiped = true;
			_vars.markSyncDirty();
		}
	}
}