package net.mcreator.utility.init;

import top.theillusivec4.curios.api.type.capability.ICurio;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.CuriosCapability;

import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

import net.minecraft.world.item.ItemStack;

import net.mcreator.utility.procedures.CReativeNightVisionGogglesBaubleIsUnequippedProcedure;
import net.mcreator.utility.procedures.CReativeNightVisionGogglesBaubleIsEquippedProcedure;

public class UtilityModCuriosCompat {
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerItem(CuriosCapability.ITEM, (stack, context) -> new ICurio() {
			@Override
			public ItemStack getStack() {
				return stack;
			}

			@Override
			public void onEquip(SlotContext slotContext, ItemStack prevStack) {
				CReativeNightVisionGogglesBaubleIsEquippedProcedure.execute(slotContext.entity());
			}

			@Override
			public void onUnequip(SlotContext slotContext, ItemStack newStack) {
				CReativeNightVisionGogglesBaubleIsUnequippedProcedure.execute(slotContext.entity());
			}
		}, UtilityModItems.CREATIVE_NIGHT_VISION_GOGGLES_ITEM.get());
	}
}