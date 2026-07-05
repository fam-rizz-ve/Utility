package net.mcreator.utility.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class ControllasevuotoProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, double altezza, double larghezza, double profondita, double quanto_non_centrata_altezza, double quanto_non_centrata_larghezza, String modalita_altezza,
			String modalita_laterale) {
		if (modalita_altezza == null || modalita_laterale == null)
			return false;
		boolean found = false;
		double forward = 0;
		double vertical = 0;
		double check_y = 0;
		double check_z = 0;
		double lateral = 0;
		double check_x = 0;
		found = false;
		forward = 0;
		for (int index0 = 0; index0 < (int) profondita; index0++) {
			if ((modalita_altezza).equals("centrata")) {
				vertical = Math.ceil(altezza / (-2));
			} else if ((modalita_altezza).equals("normal")) {
				vertical = -1;
			} else if ((modalita_altezza).equals("non centrata")) {
				vertical = quanto_non_centrata_altezza * (-1);
			} else {
				if (world instanceof ServerLevel _level) {
					_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal("dimenticato di mettere la modalit\u00E0 altezza"), false);
				}
			}
			for (int index1 = 0; index1 < (int) altezza; index1++) {
				if ((modalita_laterale).equals("centrata")) {
					lateral = Math.ceil(larghezza / (-2));
				} else if ((modalita_laterale).equals("non centrata")) {
					lateral = quanto_non_centrata_larghezza;
				} else {
					if (world instanceof ServerLevel _level) {
						_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal("dimenticato di mettere la modalit\u00E0 laterale"), false);
					}
				}
				for (int index2 = 0; index2 < (int) larghezza; index2++) {
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.NORTH) {
						check_x = x + lateral;
						check_y = y + vertical;
						check_z = (z - forward) - 1;
					} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.SOUTH) {
						check_x = x + lateral;
						check_y = y + vertical;
						check_z = z + forward + 1;
					} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.EAST) {
						check_x = x + forward + 1;
						check_y = y + vertical;
						check_z = z + lateral;
					} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.WEST) {
						check_x = (x - forward) - 1;
						check_y = y + vertical;
						check_z = z + lateral;
					}
					if (!((world.getBlockState(BlockPos.containing(check_x, check_y, check_z))).getBlock() == Blocks.AIR)) {
						found = true;
					}
					lateral = 1 + lateral;
				}
				vertical = 1 + vertical;
			}
			forward = 1 + forward;
		}
		return !found;
	}

	private static Direction getBlockDirection(LevelAccessor world, BlockPos pos) {
		BlockState blockState = world.getBlockState(pos);
		Property<?> property = blockState.getBlock().getStateDefinition().getProperty("facing");
		if (property != null && blockState.getValue(property) instanceof Direction direction)
			return direction;
		else if (blockState.hasProperty(BlockStateProperties.AXIS))
			return Direction.fromAxisAndDirection(blockState.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
		else if (blockState.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
			return Direction.fromAxisAndDirection(blockState.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
		return Direction.NORTH;
	}
}