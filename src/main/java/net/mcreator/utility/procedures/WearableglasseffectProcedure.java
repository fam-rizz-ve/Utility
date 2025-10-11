package net.mcreator.utility.procedures;

import net.minecraftforge.eventbus.api.Event;

@Mod.EventBusSubscriber
public class WearableglasseffectProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == UtilityModItems.WEARABLEGLASS.get()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 1e+59, 10, false, false));
		} else {
			if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == UtilityModItems.WEARABLEGLASS.get())) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.WATER_BREATHING);
			}
		}
	}
}