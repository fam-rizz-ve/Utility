package net.mcreator.utility.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.utility.procedures.TatticalsuitactiveeffectQuandoLeffettoIniziavieneApplicatoProcedure;

public class TatticalsuitactiveeffectMobEffect extends MobEffect {
	public TatticalsuitactiveeffectMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16738048);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		TatticalsuitactiveeffectQuandoLeffettoIniziavieneApplicatoProcedure.execute(entity);
	}
}