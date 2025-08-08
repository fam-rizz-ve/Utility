package net.mcreator.utility.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.Component;

import net.mcreator.utility.network.UtilityModVariables;
import net.mcreator.utility.init.UtilityModMobEffects;
import net.mcreator.utility.init.UtilityModItems;

public class AttivadisattivanighthelmetQuandoIlTastoVienePremutoProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == UtilityModItems.NIGHTELMET_HELMET.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == UtilityModItems.NIGHTELMET_CHESTPLATE.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == UtilityModItems.NIGHTELMET_LEGGINGS.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == UtilityModItems.NIGHTELMET_BOOTS.get() && !(entity instanceof LivingEntity _livEnt8
						&& _livEnt8.hasEffect(UtilityModMobEffects.TATTICAL_SUIT_COOLDOWN_EFFECT.get()) && entity instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(UtilityModMobEffects.TATTICALSUITACTIVEEFFECT.get()))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(UtilityModMobEffects.TATTICALSUITACTIVEEFFECT.get(), 3000, 0));
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == UtilityModItems.CREATIVENIGHTHELMET_HELMET.get() && entity instanceof LivingEntity _livEnt13
				&& _livEnt13.hasEffect(MobEffects.NIGHT_VISION)) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.NIGHT_VISION);
		} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == UtilityModItems.CREATIVENIGHTHELMET_HELMET.get()
				&& !(entity instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect(MobEffects.NIGHT_VISION))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, -1, 0, false, false));
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == UtilityModItems.EXPLOSIVESUIT_CHESTPLATE.get()
				&& ((entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UtilityModVariables.PlayerVariables())).modalita_explosive_chessplate).equals("esplodi alla morte")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Manual detonation mode: press J to explode"), true);
			{
				String _setval = "esplodi a comando";
				entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.modalita_explosive_chessplate = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == UtilityModItems.EXPLOSIVESUIT_CHESTPLATE.get()
				&& ((entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UtilityModVariables.PlayerVariables())).modalita_explosive_chessplate).equals("esplodi a comando")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Explode on death mode: upon your death, you will create an explosion around you"), true);
			{
				String _setval = "esplodi alla morte";
				entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.modalita_explosive_chessplate = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}