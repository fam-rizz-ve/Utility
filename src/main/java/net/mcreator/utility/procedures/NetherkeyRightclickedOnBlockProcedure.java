package net.mcreator.utility.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.core.BlockPos;

import net.mcreator.utility.network.UtilityModVariables;

public class NetherkeyRightclickedOnBlockProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getData(UtilityModVariables.PLAYER_VARIABLES).last_key).equals("flate key")) {
			{
				UtilityModVariables.PlayerVariables _vars = entity.getData(UtilityModVariables.PLAYER_VARIABLES);
				_vars.ultima_x_flat = entity.getX();
				_vars.ultima_y_flat = entity.getY();
				_vars.ultima_z_flat = entity.getZ();
				_vars.markSyncDirty();
			}
		} else if ((entity.getData(UtilityModVariables.PLAYER_VARIABLES).last_key).equals("overword key")) {
			{
				UtilityModVariables.PlayerVariables _vars = entity.getData(UtilityModVariables.PLAYER_VARIABLES);
				_vars.ultima_x_overword = entity.getX();
				_vars.ultima_y_overword = entity.getY();
				_vars.ultima_z_overword = entity.getZ();
				_vars.markSyncDirty();
			}
		} else if ((entity.getData(UtilityModVariables.PLAYER_VARIABLES).last_key).equals("nether key")) {
			{
				UtilityModVariables.PlayerVariables _vars = entity.getData(UtilityModVariables.PLAYER_VARIABLES);
				_vars.ultima_x_nether = entity.getX();
				_vars.ultima_y_nether = entity.getY();
				_vars.ultima_z_nether = entity.getZ();
				_vars.markSyncDirty();
			}
		} else if ((entity.getData(UtilityModVariables.PLAYER_VARIABLES).last_key).equals("end key")) {
			{
				UtilityModVariables.PlayerVariables _vars = entity.getData(UtilityModVariables.PLAYER_VARIABLES);
				_vars.ultima_x_end = entity.getX();
				_vars.ultima_y_end = entity.getY();
				_vars.ultima_z_end = entity.getZ();
				_vars.markSyncDirty();
			}
		}
		{
			Entity _ent = entity;
			double _tx = entity.getData(UtilityModVariables.PLAYER_VARIABLES).ultima_x_nether;
			double _ty = entity.getData(UtilityModVariables.PLAYER_VARIABLES).ultima_y_nether;
			double _tz = entity.getData(UtilityModVariables.PLAYER_VARIABLES).ultima_z_nether;
			_ent.teleportTo(_tx, _ty, _tz);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
		}
		{
			UtilityModVariables.PlayerVariables _vars = entity.getData(UtilityModVariables.PLAYER_VARIABLES);
			_vars.chiave_appena_usata = "nether key";
			_vars.markSyncDirty();
		}
		if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
			ResourceKey<Level> destinationType = Level.NETHER;
			if (_player.level().dimension() == destinationType)
				return;
			ServerLevel nextLevel = _player.server.getLevel(destinationType);
			if (nextLevel != null) {
				_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
				_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
				_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
				for (MobEffectInstance _effectinstance : _player.getActiveEffects())
					_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
				_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
			}
		}
		{
			UtilityModVariables.PlayerVariables _vars = entity.getData(UtilityModVariables.PLAYER_VARIABLES);
			_vars.switch_dimension = "true";
			_vars.markSyncDirty();
		}
	}
}