package net.mcreator.utility.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.utility.procedures.TatticalsuitactiveeffectQuandoLeffettoSvanisceProcedure;
import net.mcreator.utility.procedures.TatticalsuitactiveeffectQuandoLeffettoIniziavieneApplicatoProcedure;

public class TatticalsuitactiveeffectMobEffect extends MobEffect {
	public TatticalsuitactiveeffectMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16738048);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.addAttributeModifiers(entity, attributeMap, amplifier);
		TatticalsuitactiveeffectQuandoLeffettoIniziavieneApplicatoProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		TatticalsuitactiveeffectQuandoLeffettoSvanisceProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}