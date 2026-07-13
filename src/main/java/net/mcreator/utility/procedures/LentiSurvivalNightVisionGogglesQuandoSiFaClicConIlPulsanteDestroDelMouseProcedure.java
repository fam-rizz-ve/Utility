package net.mcreator.utility.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.mcreator.utility.network.UtilityModVariables;

public class LentiSurvivalNightVisionGogglesQuandoSiFaClicConIlPulsanteDestroDelMouseProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		itemstack.shrink(1);
		{
			UtilityModVariables.PlayerVariables _vars = entity.getData(UtilityModVariables.PLAYER_VARIABLES);
			_vars.UtilizzateLeLentiDelSurvivalNIghtVisionGoggles = true;
			_vars.markSyncDirty();
		}
	}
}