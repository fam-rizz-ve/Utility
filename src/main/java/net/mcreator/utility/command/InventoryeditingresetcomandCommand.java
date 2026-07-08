package net.mcreator.utility.command;

import org.checkerframework.checker.units.qual.s;

import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

import com.mojang.brigadier.arguments.StringArgumentType;

@EventBusSubscriber
public class InventoryeditingresetcomandCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("Inveditor").requires(s -> s.hasPermission(4)).then(Commands.argument("name", EntityArgument.player()).then(Commands.argument("reset", StringArgumentType.word()))));
	}

}