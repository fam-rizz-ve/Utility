package net.mcreator.utility.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class DungeongeneratorblockAllaggiornamentoDelTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double numero_casuale_quale_tipo_di_stanza = 0;
		double tentativi = 0;
		boolean struttura_piazzata = false;
		struttura_piazzata = false;
		for (int index0 = 0; index0 < 5; index0++) {
			numero_casuale_quale_tipo_di_stanza = Mth.nextInt(RandomSource.create(), 1, 1000);
			if (numero_casuale_quale_tipo_di_stanza < 190) {
				if (ControllasevuotoProcedure.execute(world, x, y, z, 5, 5, 8, 0, 0, "normal", "centrata")) {
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.NORTH) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_corridoio_dritto_1"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y - 1, z), BlockPos.containing(x - 2, y - 1, z),
										new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.SOUTH) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_corridoio_dritto_1"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y - 1, z), BlockPos.containing(x + 2, y - 1, z),
										new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.EAST) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_corridoio_dritto_1"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x, y - 1, z - 2), BlockPos.containing(x, y - 1, z - 2), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
										_serverworld.random, 3);
							}
						}
					} else {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_corridoio_dritto_1"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x, y - 1, z + 2), BlockPos.containing(x, y - 1, z + 2),
										new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					}
					struttura_piazzata = true;
					break;
				}
			} else if (numero_casuale_quale_tipo_di_stanza < 245) {
				if (ControllasevuotoProcedure.execute(world, x, y, z, 5, 9, 9, 0, 0, "normal", "centrata")) {
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.NORTH) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_curva_a_destra_1"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x - 6, y - 1, z), BlockPos.containing(x - 6, y - 1, z),
										new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.SOUTH) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_curva_a_destra_1"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x + 6, y - 1, z), BlockPos.containing(x + 6, y - 1, z),
										new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.EAST) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_curva_a_destra_1"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x, y - 1, z - 6), BlockPos.containing(x, y - 1, z - 6), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
										_serverworld.random, 3);
							}
						}
					} else {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_curva_a_destra_1"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x, y - 1, z + 6), BlockPos.containing(x, y - 1, z + 6),
										new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					}
					struttura_piazzata = true;
					break;
				}
			} else if (numero_casuale_quale_tipo_di_stanza < 300) {
				if (ControllasevuotoProcedure.execute(world, x, y, z, 5, 9, 9, 0, 0, "normal", "centrata")) {
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.NORTH) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_curva_a_sinistra_1"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x + 6, y - 1, z - 8), BlockPos.containing(x + 6, y - 1, z - 8),
										new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.SOUTH) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_curva_a_sinistra_1"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x - 6, y - 1, z + 8), BlockPos.containing(x - 6, y - 1, z + 8),
										new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.EAST) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_curva_a_sinistra_1"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x + 8, y - 1, z + 6), BlockPos.containing(x + 8, y - 1, z + 6),
										new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_curva_a_sinistra_1"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x - 8, y - 1, z - 6), BlockPos.containing(x - 8, y - 1, z - 6),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					}
					struttura_piazzata = true;
					break;
				}
			} else if (numero_casuale_quale_tipo_di_stanza < 535) {
				if (ControllasevuotoProcedure.execute(world, x, y, z, 5, 9, 5, 0, 0, "normal", "centrata")) {
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.NORTH) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_incrocio_a_t"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x - 4, y - 1, z - 0), BlockPos.containing(x - 4, y - 1, z - 0),
										new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.SOUTH) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_incrocio_a_t"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x + 4, y - 1, z + 0), BlockPos.containing(x + 4, y - 1, z + 0),
										new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.EAST) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_incrocio_a_t"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x + 0, y - 1, z - 4), BlockPos.containing(x + 0, y - 1, z - 4),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_incrocio_a_t"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x - 0, y - 1, z + 4), BlockPos.containing(x - 0, y - 1, z + 4),
										new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					}
					struttura_piazzata = true;
					break;
				}
			} else if (numero_casuale_quale_tipo_di_stanza < 710) {
				if (ControllasevuotoProcedure.execute(world, x, y, z, 5, 7, 7, 0, 0, "normal", "centrata")) {
					if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.NORTH) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_incrocio_a_x_1"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x - 3, y - 1, z - 6), BlockPos.containing(x - 3, y - 1, z - 6),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.SOUTH) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_incrocio_a_x_1"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x + 3, y - 1, z + 6), BlockPos.containing(x + 3, y - 1, z + 6),
										new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.EAST) {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_incrocio_a_x_1"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x + 6, y - 1, z + 3), BlockPos.containing(x + 6, y - 1, z + 3),
										new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					} else {
						if (world instanceof ServerLevel _serverworld) {
							StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_incrocio_a_x_1"));
							if (template != null) {
								template.placeInWorld(_serverworld, BlockPos.containing(x - 6, y - 1, z - 3), BlockPos.containing(x - 6, y - 1, z - 3),
										new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
							}
						}
					}
					struttura_piazzata = true;
					break;
				}
			} else {
				if (numero_casuale_quale_tipo_di_stanza < 720) {
					if (ControllasevuotoProcedure.execute(world, x, y, z, 13, 5, 9, 3, 0, "non centrata", "centrata") && y < 23) {
						if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.NORTH) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_scala_1"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y - 4, z - 8), BlockPos.containing(x - 2, y - 4, z - 8),
											new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.SOUTH) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_scala_1"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y - 4, z + 8), BlockPos.containing(x + 2, y - 4, z + 8),
											new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.EAST) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_scala_1"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x + 8, y - 4, z - 2), BlockPos.containing(x + 8, y - 4, z - 2),
											new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_scala_1"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x - 8, y - 4, z + 2), BlockPos.containing(x - 8, y - 4, z + 2),
											new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						}
						struttura_piazzata = true;
						break;
					}
				} else if (numero_casuale_quale_tipo_di_stanza < 730) {
					if (ControllasevuotoProcedure.execute(world, x, y, z, 12, 5, 9, 8, 0, "non centrata", "centrata") && y > -23) {
						if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.NORTH) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_scala_1"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y - 9, z - 0), BlockPos.containing(x + 2, y - 9, z - 0),
											new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.SOUTH) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_scala_1"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y - 9, z + 0), BlockPos.containing(x - 2, y - 9, z + 0),
											new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.EAST) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_scala_1"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x + 0, y - 9, z + 2), BlockPos.containing(x + 0, y - 9, z + 2),
											new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_scala_1"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x + 0, y - 9, z - 2), BlockPos.containing(x + 0, y - 9, z - 2),
											new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						}
						struttura_piazzata = true;
						break;
					}
				} else if (numero_casuale_quale_tipo_di_stanza < 740) {
					if (ControllasevuotoProcedure.execute(world, x, y, z, 16, 7, 7, 4, 0, "non centrata", "centrata")) {
						if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.NORTH) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_ascensore"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x + 3, y - 4, z - 7), BlockPos.containing(x + 3, y - 4, z - 7),
											new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.SOUTH) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_ascensore"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x - 3, y - 4, z + 7), BlockPos.containing(x - 3, y - 4, z + 7),
											new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.EAST) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_ascensore"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x + 7, y - 4, z + 3), BlockPos.containing(x + 7, y - 4, z + 3),
											new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_ascensore"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x - 7, y - 4, z - 3), BlockPos.containing(x - 7, y - 4, z - 3),
											new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						}
						struttura_piazzata = true;
						break;
					}
				} else if (numero_casuale_quale_tipo_di_stanza < 770) {
					if (ControllasevuotoProcedure.execute(world, x, y, z, 7, 9, 9, 0, 0, "normal", "centrata")) {
						if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.NORTH) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_core_room_1"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x - 9, y - 1, z - 0), BlockPos.containing(x - 9, y - 1, z - 0),
											new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.SOUTH) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_core_room_1"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x + 9, y - 1, z + 0), BlockPos.containing(x + 9, y - 1, z + 0),
											new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.EAST) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_core_room_1"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x + 0, y - 1, z - 9), BlockPos.containing(x + 0, y - 1, z - 9),
											new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_core_room_1"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x - 0, y - 1, z + 9), BlockPos.containing(x - 0, y - 1, z + 9),
											new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						}
						struttura_piazzata = true;
						break;
					}
				} else if (numero_casuale_quale_tipo_di_stanza < 785) {
					if (ControllasevuotoProcedure.execute(world, x, y, z, 5, 15, 25, 0, 2, "normal", "non centrata")) {
						if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.NORTH) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_coridoio_loop"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x - 2, y - 1, z - 24), BlockPos.containing(x - 2, y - 1, z - 24),
											new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.SOUTH) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_coridoio_loop"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x + 2, y - 1, z + 24), BlockPos.containing(x + 2, y - 1, z + 24),
											new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.EAST) {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_coridoio_loop"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x + 24, y - 1, z - 2), BlockPos.containing(x + 24, y - 1, z - 2),
											new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						} else {
							if (world instanceof ServerLevel _serverworld) {
								StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("utility", "liminal_coridoio_loop"));
								if (template != null) {
									template.placeInWorld(_serverworld, BlockPos.containing(x - 24, y - 1, z + 2), BlockPos.containing(x - 24, y - 1, z + 2),
											new StructurePlaceSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
								}
							}
						}
						struttura_piazzata = true;
						break;
					}
				} else {
					if (DungeonGeneratorPart2Procedure.execute(world, x, y, z, numero_casuale_quale_tipo_di_stanza)) {
						struttura_piazzata = true;
						break;
					}
				}
			}
		}
		if (!struttura_piazzata) {
			if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.NORTH) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~1 ~-1 ~-1 ~-1 ~2 ~-1 minecraft:stone_bricks");
			} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.SOUTH) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~-1 ~-1 ~1 ~1 ~2 ~1 minecraft:stone_bricks");
			} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.EAST) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~1 ~-1 ~-1 ~1 ~2 ~1 minecraft:stone_bricks");
			} else {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~-1 ~-1 ~1 ~-1 ~2 ~-1 minecraft:stone_bricks");
			}
		}
		world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
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