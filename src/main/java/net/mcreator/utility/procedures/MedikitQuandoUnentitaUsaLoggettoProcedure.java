package net.mcreator.utility.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;

import net.mcreator.utility.network.UtilityModVariables;
import net.mcreator.utility.init.UtilityModItems;
import net.mcreator.utility.UtilityMod;

public class MedikitQuandoUnentitaUsaLoggettoProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UtilityModItems.MEDIKIT.get()
				&& (entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UtilityModVariables.PlayerVariables())).medikit_cooldown == false) {
			{
				boolean _setval = true;
				entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.medikit_cooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 2));
			{
				ItemStack _ist = itemstack;
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(UtilityModItems.MEDIKIT.get(), 240);
			UtilityMod.queueServerWork(240, () -> {
				{
					boolean _setval = false;
					entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.medikit_cooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			});
		}
	}
}