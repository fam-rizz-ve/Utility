package net.mcreator.utility.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.utility.network.UtilityModVariables;

import java.util.List;

public class OmniWandsInformazioniSpecialiProcedure {
	public static void execute(Entity entity, List<Component> tooltip) {
		if (entity == null || tooltip == null)
			return;
		if (entity.getData(UtilityModVariables.PLAYER_VARIABLES).ModalitaOmniWand == 1) {
			tooltip.add(1, Component.literal("In this mode if you attack a entity with it, it despawn"));
		} else if (entity.getData(UtilityModVariables.PLAYER_VARIABLES).ModalitaOmniWand == 2) {
			tooltip.add(1, Component.literal(""));
		} else if (entity.getData(UtilityModVariables.PLAYER_VARIABLES).ModalitaOmniWand == 3) {
			tooltip.add(1, Component.literal(""));
		} else if (entity.getData(UtilityModVariables.PLAYER_VARIABLES).ModalitaOmniWand == 4) {
			tooltip.add(1, Component.literal(""));
		}
	}
}