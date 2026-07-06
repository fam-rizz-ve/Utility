package net.mcreator.utility.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.utility.network.UtilityModVariables;
import net.mcreator.utility.init.UtilityModItems;
import net.mcreator.utility.configuration.ConfigurationmodfileConfiguration;
import net.mcreator.utility.UtilityMod;

public class MedikitQuandoUnentitaUsaLoggettoProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UtilityModItems.MEDIKIT.get() && entity.getData(UtilityModVariables.PLAYER_VARIABLES).medikit_cooldown == false) {
			{
				UtilityModVariables.PlayerVariables _vars = entity.getData(UtilityModVariables.PLAYER_VARIABLES);
				_vars.medikit_cooldown = true;
				_vars.markSyncDirty();
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, (int) (double) ConfigurationmodfileConfiguration.MEDIKIT_HEALING_STRENGTH.get()));
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
				});
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(UtilityModItems.MEDIKIT.get(), (int) (double) ConfigurationmodfileConfiguration.MEDIKIT_COOLDOWN_TIME.get());
			UtilityMod.queueServerWork((int) (double) ConfigurationmodfileConfiguration.MEDIKIT_COOLDOWN_TIME.get(), () -> {
				{
					UtilityModVariables.PlayerVariables _vars = entity.getData(UtilityModVariables.PLAYER_VARIABLES);
					_vars.medikit_cooldown = false;
					_vars.markSyncDirty();
				}
			});
		}
	}
}