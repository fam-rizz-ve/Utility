package net.mcreator.utility.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.utility.network.UtilityModVariables;
import net.mcreator.utility.init.UtilityModItems;
import net.mcreator.utility.UtilityMod;

public class ExplosivesuitattivazioneQuandoIlTastoVienePremutoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UtilityModVariables.PlayerVariables())).modalita_explosive_chessplate).equals("esplodi a comando")
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == UtilityModItems.EXPLOSIVESUIT_CHESTPLATE.get()) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("utility:bombo_timer")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("utility:bombo_timer")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			UtilityMod.queueServerWork(40, () -> {
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(null, x, y, z, 10, Level.ExplosionInteraction.TNT);
			});
		}
	}
}