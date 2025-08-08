package net.mcreator.utility.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.utility.init.UtilityModMobEffects;

public class TatticalsuitactiveeffectQuandoLeffettoSvanisceProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.NIGHT_VISION);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.HEALTH_BOOST);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.JUMP);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.MOVEMENT_SPEED);
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(UtilityModMobEffects.TATTICAL_SUIT_COOLDOWN_EFFECT.get(), 12000, 0, false, false));
	}
}