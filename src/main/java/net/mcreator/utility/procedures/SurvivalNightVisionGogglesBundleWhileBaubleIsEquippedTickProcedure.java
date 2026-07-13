package net.mcreator.utility.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.utility.network.UtilityModVariables;
import net.mcreator.utility.init.UtilityModMobEffects;

public class SurvivalNightVisionGogglesBundleWhileBaubleIsEquippedTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getDamageValue() < itemstack.getMaxDamage() - 1) {
			{
				UtilityModVariables.PlayerVariables _vars = entity.getData(UtilityModVariables.PLAYER_VARIABLES);
				_vars.SurvivalNightVisionGogglesCanActivate = true;
				_vars.markSyncDirty();
			}
			if (entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(UtilityModMobEffects.SURVIVAL_N_IGHT_VISION_GOGGLES_EFFECT)) {
				if (world instanceof ServerLevel _level) {
					itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
					});
				}
			}
		} else if (itemstack.getDamageValue() >= itemstack.getMaxDamage() - 1) {
			{
				UtilityModVariables.PlayerVariables _vars = entity.getData(UtilityModVariables.PLAYER_VARIABLES);
				_vars.SurvivalNightVisionGogglesCanActivate = false;
				_vars.markSyncDirty();
			}
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(UtilityModMobEffects.SURVIVAL_N_IGHT_VISION_GOGGLES_EFFECT);
		}
		if (entity.getData(UtilityModVariables.PLAYER_VARIABLES).UtilizzateLeLentiDelSurvivalNIghtVisionGoggles) {
			itemstack.setDamageValue(0);
			{
				UtilityModVariables.PlayerVariables _vars = entity.getData(UtilityModVariables.PLAYER_VARIABLES);
				_vars.UtilizzateLeLentiDelSurvivalNIghtVisionGoggles = false;
				_vars.markSyncDirty();
			}
		}
	}
}