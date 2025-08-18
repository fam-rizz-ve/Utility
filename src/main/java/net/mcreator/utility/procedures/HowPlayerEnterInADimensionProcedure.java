package net.mcreator.utility.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.utility.network.UtilityModVariables;
import net.mcreator.utility.init.UtilityModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class HowPlayerEnterInADimensionProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UtilityModVariables.PlayerVariables())).switch_dimension).equals("true")) {
			if (!world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()) {
				if (((entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UtilityModVariables.PlayerVariables())).chiave_appena_usata).equals("flate key")
						|| ((entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UtilityModVariables.PlayerVariables())).chiave_appena_usata).equals("overword key")) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y - 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"fill ~-1 ~ ~-1 ~1 ~ ~1 minecraft:dirt");
				} else if (((entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UtilityModVariables.PlayerVariables())).chiave_appena_usata).equals("nether key")) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y - 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"fill ~-1 ~ ~-1 ~1 ~ ~1 minecraft:netherrack");
				} else if (((entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UtilityModVariables.PlayerVariables())).chiave_appena_usata).equals("end key")) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y - 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"fill ~-1 ~ ~-1 ~1 ~ ~1 minecraft:end_stone");
				}
			}
			if (world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~-1 ~-1 ~-1 ~1 ~1 ~1 minecraft:air");
			}
			if (((entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UtilityModVariables.PlayerVariables())).chiave_appena_usata).equals("limbo key")) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "limbo_2"));
					if (template != null) {
						template.placeInWorld(_serverworld, new BlockPos(0, 0, 0), new BlockPos(0, 0, 0), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
				{
					Entity _ent = entity;
					_ent.teleportTo(75, 12, 48);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(75, 12, 48, _ent.getYRot(), _ent.getXRot());
				}
				if (entity instanceof Player _player) {
					_player.getAbilities().mayBuild = false;
					_player.onUpdateAbilities();
				}
				{
					String _setval = DeterminamodalitaProcedure.execute(entity);
					entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ultima_gamemode = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof ServerPlayer _player)
					_player.setGameMode(GameType.ADVENTURE);
				if (entity instanceof Player _player) {
					_player.getAbilities().invulnerable = true;
					_player.onUpdateAbilities();
				}
			}
			if (((entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UtilityModVariables.PlayerVariables())).chiave_appena_usata).equals("liminal key")) {
				if (!UtilityModVariables.MapVariables.get(world).liminal_generato) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "inizio_liminal"));
						if (template != null) {
							template.placeInWorld(_serverworld, new BlockPos(0, 0, 0), new BlockPos(0, 0, 0), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
						}
					}
					UtilityModVariables.MapVariables.get(world).liminal_generato = true;
					UtilityModVariables.MapVariables.get(world).syncData(world);
				}
				{
					Entity _ent = entity;
					_ent.teleportTo(9, 2, 9);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(9, 2, 9, _ent.getYRot(), _ent.getXRot());
				}
				if (entity instanceof Player _player) {
					_player.getAbilities().mayBuild = false;
					_player.onUpdateAbilities();
				}
				{
					String _setval = DeterminamodalitaProcedure.execute(entity);
					entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ultima_gamemode = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof ServerPlayer _player)
					_player.setGameMode(GameType.ADVENTURE);
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/effect give @s minecraft:saturation infinite 1 false");
					}
				}
			}
			if (((entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UtilityModVariables.PlayerVariables())).chiave_appena_usata).equals("flate key")) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(UtilityModItems.FLATKEY.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			} else if (((entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UtilityModVariables.PlayerVariables())).chiave_appena_usata).equals("overword key")) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(UtilityModItems.OVERWORDKEY.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			} else if (((entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UtilityModVariables.PlayerVariables())).chiave_appena_usata).equals("nether key")) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(UtilityModItems.NETHERKEY.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			} else if (((entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UtilityModVariables.PlayerVariables())).chiave_appena_usata).equals("end key")) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(UtilityModItems.ENDKEY.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			} else if (((entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UtilityModVariables.PlayerVariables())).chiave_appena_usata).equals("limbo key")) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(UtilityModItems.LIMBOKEY.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			} else if (((entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UtilityModVariables.PlayerVariables())).chiave_appena_usata).equals("liminal key")) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(UtilityModItems.LIMINALY_KEY.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			}
			if (((entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UtilityModVariables.PlayerVariables())).last_key).equals("flate key")) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(UtilityModItems.FLATKEY.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (((entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UtilityModVariables.PlayerVariables())).last_key).equals("overword key")) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(UtilityModItems.OVERWORDKEY.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (((entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UtilityModVariables.PlayerVariables())).last_key).equals("nether key")) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(UtilityModItems.NETHERKEY.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (((entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UtilityModVariables.PlayerVariables())).last_key).equals("end key")) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(UtilityModItems.ENDKEY.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (((entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UtilityModVariables.PlayerVariables())).last_key).equals("limbo key")) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(UtilityModItems.LIMBOKEY.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (entity instanceof Player _player) {
					_player.getAbilities().mayBuild = true;
					_player.onUpdateAbilities();
				}
				if (entity instanceof Player _player) {
					_player.getAbilities().invulnerable = false;
					_player.onUpdateAbilities();
				}
				CambiamodalitaProcedure.execute(entity);
			} else if (((entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UtilityModVariables.PlayerVariables())).last_key).equals("liminal key")) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(UtilityModItems.LIMINALY_KEY.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (entity instanceof Player _player) {
					_player.getAbilities().mayBuild = true;
					_player.onUpdateAbilities();
				}
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.SATURATION);
				CambiamodalitaProcedure.execute(entity);
			}
			{
				String _setval = (entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UtilityModVariables.PlayerVariables())).chiave_appena_usata;
				entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.last_key = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "false";
				entity.getCapability(UtilityModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.switch_dimension = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}