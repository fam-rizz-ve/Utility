package net.mcreator.utility.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.utility.network.UtilityModVariables;

public class OmniWandsQuandoUnentitaViventeEColpitaConLoggettoProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity.getData(UtilityModVariables.PLAYER_VARIABLES).ModalitaOmniWand == 1) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}