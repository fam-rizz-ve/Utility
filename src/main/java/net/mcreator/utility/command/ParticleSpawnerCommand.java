package net.mcreator.utility.command;

import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.commands.Commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

@EventBusSubscriber
public class ParticleSpawnerCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("particle_spawner")

				.then(Commands.argument("Particles_Num", DoubleArgumentType.doubleArg(0)).then(
						Commands.argument("Coordinates_particles", BlockPosArgument.blockPos()).then(Commands.argument("N1_particles", DoubleArgumentType.doubleArg(0)).then(Commands.argument("N2_particles", DoubleArgumentType.doubleArg(0)).then(
								Commands.argument("N3_particles", DoubleArgumentType.doubleArg(0)).then(Commands.argument("N4_particles", DoubleArgumentType.doubleArg(0)).then(Commands.argument("Particles_name", StringArgumentType.word())))))))));
	}

}