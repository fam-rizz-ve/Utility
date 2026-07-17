package net.mcreator.utility.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.utility.network.UtilityModVariables;

public class OmniWandPulsanteDestraCambioPlayer2Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(UtilityModVariables.PLAYER_VARIABLES).indiceCorrenteOmniWand2 < UtilityModVariables.MapVariables.get(world).numeroDiGIocatori - 1) {
			{
				UtilityModVariables.PlayerVariables _vars = entity.getData(UtilityModVariables.PLAYER_VARIABLES);
				_vars.indiceCorrenteOmniWand2 = entity.getData(UtilityModVariables.PLAYER_VARIABLES).indiceCorrenteOmniWand2 + 1;
				_vars.markSyncDirty();
			}
		} else {
			{
				UtilityModVariables.PlayerVariables _vars = entity.getData(UtilityModVariables.PLAYER_VARIABLES);
				_vars.indiceCorrenteOmniWand2 = 0;
				_vars.markSyncDirty();
			}
		}
		{
			UtilityModVariables.PlayerVariables _vars = entity.getData(UtilityModVariables.PLAYER_VARIABLES);
			_vars.NomeMostratoOmniWand2 = OttieniNomeDaStringaSeparatiDaVirgoleProcedure.execute(entity.getData(UtilityModVariables.PLAYER_VARIABLES).indiceCorrenteOmniWand2, UtilityModVariables.MapVariables.get(world).lista_giocatori);
			_vars.markSyncDirty();
		}
	}
}