/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.utility.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.utility.UtilityMod;

public class UtilityModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, UtilityMod.MODID);
	public static final RegistryObject<SoundEvent> BOMBO_TIMER = REGISTRY.register("bombo_timer", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("utility", "bombo_timer")));
}