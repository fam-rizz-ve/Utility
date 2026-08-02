package net.mcreator.utility.procedures;

import net.minecraft.world.entity.Entity;

public class EffectsremoverActiveTickConditionProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.isInvisible()) {
			if (entity instanceof net.minecraft.world.entity.LivingEntity _livEnt) {
				java.util.List<net.minecraft.world.effect.MobEffectInstance> effectsToRemove = new java.util.ArrayList<>();
				for (net.minecraft.world.effect.MobEffectInstance effectInstance : _livEnt.getActiveEffects()) {
					// Controlla che non sia la pozione stessa di questa mod
					if (!effectInstance.getEffect().equals(net.mcreator.utility.init.UtilityModMobEffects.EFFECTSREMOVER.get())) {
						// Verifica se l'effetto NON è infinito (durata < 0 oppure > 1000000)
						boolean isInfinite = effectInstance.getDuration() < 0 || effectInstance.getDuration() > 1000000;
						if (!isInfinite) {
							effectsToRemove.add(effectInstance);
						}
					}
				}
				// Rimuove gli effetti temporanei
				for (net.minecraft.world.effect.MobEffectInstance effect : effectsToRemove) {
					_livEnt.removeEffect(effect.getEffect());
				}
			}
		}
		if (entity instanceof net.minecraft.world.entity.LivingEntity _livEnt) {
			java.util.List<net.minecraft.world.effect.MobEffectInstance> effectsToRemove = new java.util.ArrayList<>();
			for (net.minecraft.world.effect.MobEffectInstance effectInstance : _livEnt.getActiveEffects()) {
				// Controlla che non sia la pozione stessa di questa mod
				if (!effectInstance.getEffect().equals(net.mcreator.utility.init.UtilityModMobEffects.EFFECTSREMOVER.get())) {
					// Verifica se l'effetto NON è infinito (durata < 0 oppure > 1000000)
					boolean isInfinite = effectInstance.getDuration() < 0 || effectInstance.getDuration() > 1000000;
					if (!isInfinite) {
						effectsToRemove.add(effectInstance);
					}
				}
			}
			// Rimuove gli effetti temporanei
			for (net.minecraft.world.effect.MobEffectInstance effect : effectsToRemove) {
				_livEnt.removeEffect(effect.getEffect());
			}
		}
	}
}