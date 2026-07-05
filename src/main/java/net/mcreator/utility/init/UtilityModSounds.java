/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.utility.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.utility.UtilityMod;

public class UtilityModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, UtilityMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> BOMBO_TIMER = REGISTRY.register("bombo_timer", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("utility", "bombo_timer")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MAGICAL_KEY = REGISTRY.register("magical_key", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("utility", "magical_key")));
	public static final DeferredHolder<SoundEvent, SoundEvent> NIGHT_VISION = REGISTRY.register("night_vision", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("utility", "night_vision")));
}