package net.mcreator.utility.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class TatticalSuitCooldownEffectMobEffect extends MobEffect {
	public TatticalSuitCooldownEffectMobEffect() {
		super(MobEffectCategory.NEUTRAL, -6710887);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}