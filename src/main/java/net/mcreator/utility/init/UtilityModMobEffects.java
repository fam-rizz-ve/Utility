/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.utility.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.utility.procedures.TatticalsuitactiveeffectQuandoLeffettoSvanisceProcedure;
import net.mcreator.utility.procedures.SurvivalNIghtVisionGogglesEffectQuandoLeffettoSvanisceProcedure;
import net.mcreator.utility.potion.TatticalsuitactiveeffectMobEffect;
import net.mcreator.utility.potion.TatticalSuitCooldownEffectMobEffect;
import net.mcreator.utility.potion.SurvivalNIghtVisionGogglesEffectMobEffect;
import net.mcreator.utility.UtilityMod;

@EventBusSubscriber
public class UtilityModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, UtilityMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> TATTICALSUITACTIVEEFFECT = REGISTRY.register("tatticalsuitactiveeffect", () -> new TatticalsuitactiveeffectMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> TATTICAL_SUIT_COOLDOWN_EFFECT = REGISTRY.register("tattical_suit_cooldown_effect", () -> new TatticalSuitCooldownEffectMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SURVIVAL_N_IGHT_VISION_GOGGLES_EFFECT = REGISTRY.register("survival_n_ight_vision_goggles_effect", () -> new SurvivalNIghtVisionGogglesEffectMobEffect());

	@SubscribeEvent
	public static void onEffectRemoved(MobEffectEvent.Remove event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	@SubscribeEvent
	public static void onEffectExpired(MobEffectEvent.Expired event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	private static void expireEffects(Entity entity, MobEffectInstance effectInstance) {
		if (effectInstance.getEffect().is(TATTICALSUITACTIVEEFFECT)) {
			TatticalsuitactiveeffectQuandoLeffettoSvanisceProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(SURVIVAL_N_IGHT_VISION_GOGGLES_EFFECT)) {
			SurvivalNIghtVisionGogglesEffectQuandoLeffettoSvanisceProcedure.execute(entity);
		}
	}
}