package net.mcreator.utility.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.utility.UtilityMod;

import javax.annotation.Nullable;

import java.util.function.Function;

@EventBusSubscriber
public class WaterEssenceProcedureProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
				.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("utility:wateressence")))) != 0) {
			if (Mth.nextInt(RandomSource.create(), 1, 5) == 2) {
				createTimedLoop(5, 20, _timedLoop -> {
					entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.DROWN)), 2);
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) != 0) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.BUBBLE_COLUMN_UP, (entity.getX()), (entity.getY()), (entity.getZ()), 50, 1, 1, 1, 0.1);
					}
					return true;
				});
			}
		}
	}

	private static class UtilityModTimedLoop {
		private int iterator = 0;
		private int ticks = 0;
		private final int total;
		private final Function<UtilityModTimedLoop, Boolean> forEach;

		private UtilityModTimedLoop(int total, int ticks, Function<UtilityModTimedLoop, Boolean> forEach) {
			this.total = total;
			this.ticks = ticks;
			this.forEach = forEach;
			run();
		}

		private void run() {
			if (forEach.apply(this))
				UtilityMod.queueServerWork(ticks, this::next);
		}

		private void next() {
			if (total > ++iterator)
				run();
		}
	}

	private static UtilityModTimedLoop createTimedLoop(int total, int ticks, Function<UtilityModTimedLoop, Boolean> forEach) {
		return new UtilityModTimedLoop(total, ticks, forEach);
	}
}