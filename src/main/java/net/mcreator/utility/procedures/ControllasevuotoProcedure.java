package net.mcreator.utility.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class ControllasevuotoProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, double altezza, double larghezza, double profondita) {
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
			vertical = Math.ceil(altezza / (-2));
			for (int index1 = 0; index1 < (int) altezza; index1++) {
				lateral = Math.ceil(larghezza / (-2));
				for (int index2 = 0; index2 < (int) larghezza; index2++) {
					if ((new Object() {
						public Direction getDirection(BlockPos pos) {
							BlockState _bs = world.getBlockState(pos);
							Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (property != null && _bs.getValue(property) instanceof Direction _dir)
								return _dir;
							else if (_bs.hasProperty(BlockStateProperties.AXIS))
								return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
							else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
								return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
							return Direction.NORTH;
						}
					}.getDirection(BlockPos.containing(x, y, z))) == Direction.NORTH) {
						check_x = x + lateral;
						check_y = y + vertical;
						check_z = (z - forward) - 1;
					} else if ((new Object() {
						public Direction getDirection(BlockPos pos) {
							BlockState _bs = world.getBlockState(pos);
							Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (property != null && _bs.getValue(property) instanceof Direction _dir)
								return _dir;
							else if (_bs.hasProperty(BlockStateProperties.AXIS))
								return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
							else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
								return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
							return Direction.NORTH;
						}
					}.getDirection(BlockPos.containing(x, y, z))) == Direction.SOUTH) {
						check_x = x + lateral;
						check_y = y + vertical;
						check_z = z + forward + 1;
					} else if ((new Object() {
						public Direction getDirection(BlockPos pos) {
							BlockState _bs = world.getBlockState(pos);
							Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (property != null && _bs.getValue(property) instanceof Direction _dir)
								return _dir;
							else if (_bs.hasProperty(BlockStateProperties.AXIS))
								return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
							else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
								return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
							return Direction.NORTH;
						}
					}.getDirection(BlockPos.containing(x, y, z))) == Direction.EAST) {
						check_x = x + forward + 1;
						check_y = y + vertical;
						check_z = z + lateral;
					} else if ((new Object() {
						public Direction getDirection(BlockPos pos) {
							BlockState _bs = world.getBlockState(pos);
							Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (property != null && _bs.getValue(property) instanceof Direction _dir)
								return _dir;
							else if (_bs.hasProperty(BlockStateProperties.AXIS))
								return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
							else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
								return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
							return Direction.NORTH;
						}
					}.getDirection(BlockPos.containing(x, y, z))) == Direction.WEST) {
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
}