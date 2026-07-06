package net.mcreator.utility.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.utility.network.UtilityModVariables;
import net.mcreator.utility.init.UtilityModItems;
import net.mcreator.utility.configuration.ConfigurationmodfileConfiguration;
import net.mcreator.utility.UtilityMod;

public class BandagesQuandoUnentitaUsaLoggettoProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UtilityModItems.BANDAGES.get() && entity.getData(UtilityModVariables.PLAYER_VARIABLES).bende_cooldown == false) {
			{
				UtilityModVariables.PlayerVariables _vars = entity.getData(UtilityModVariables.PLAYER_VARIABLES);
				_vars.bende_cooldown = true;
				_vars.markSyncDirty();
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, (int) (double) ConfigurationmodfileConfiguration.BENDAGES_HEALING_STRENGTH.get()));
			itemstack.shrink(1);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(UtilityModItems.BANDAGES.get(), (int) (double) ConfigurationmodfileConfiguration.BENDAGES_COOLDOWN_TIME.get());
			UtilityMod.queueServerWork((int) (double) ConfigurationmodfileConfiguration.BENDAGES_COOLDOWN_TIME.get(), () -> {
				{
					UtilityModVariables.PlayerVariables _vars = entity.getData(UtilityModVariables.PLAYER_VARIABLES);
					_vars.bende_cooldown = false;
					_vars.markSyncDirty();
				}
			});
		}
	}
}