package net.mcreator.utility.procedures;

import org.checkerframework.checker.units.qual.A;

import org.apache.commons.lang3.function.FailableFunction;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

import java.util.function.Supplier;

import com.mojang.serialization.JsonOps;

@EventBusSubscriber
public class ModChatMessageProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player1 && !_player1.level().isClientSide())
			_player1.displayClientMessage(((MutableComponent) tryOrDefault(
					"{\"text\":\"\",\"extra\":[{\"text\":\"W\",\"color\":\"#04DC2D\"},{\"text\":\"e\",\"color\":\"#04D632\"},{\"text\":\"l\",\"color\":\"#05D138\"},{\"text\":\"c\",\"color\":\"#05CB3D\"},{\"text\":\"o\",\"color\":\"#05C543\"},{\"text\":\"m\",\"color\":\"#05C048\"},{\"text\":\"e\",\"color\":\"#06BA4D\"},{\"text\":\",\",\"color\":\"#06B553\"},{\"text\":\" \"},{\"text\":\"a\",\"color\":\"#06A95D\"},{\"text\":\"n\",\"color\":\"#07A463\"},{\"text\":\"d\",\"color\":\"#079E68\"},{\"text\":\" \"},{\"text\":\"t\",\"color\":\"#079373\"},{\"text\":\"h\",\"color\":\"#088D78\"},{\"text\":\"a\",\"color\":\"#08877E\"},{\"text\":\"n\",\"color\":\"#088283\"},{\"text\":\"k\",\"color\":\"#087C89\"},{\"text\":\"s\",\"color\":\"#09768E\"},{\"text\":\" \"},{\"text\":\"f\",\"color\":\"#096B99\"},{\"text\":\"o\",\"color\":\"#09669E\"},{\"text\":\"r\",\"color\":\"#0A60A3\"},{\"text\":\" \"},{\"text\":\"d\",\"color\":\"#0A55AE\"},{\"text\":\"o\",\"color\":\"#0A4FB4\"},{\"text\":\"w\",\"color\":\"#0B49B9\"},{\"text\":\"n\",\"color\":\"#0B44BE\"},{\"text\":\"l\",\"color\":\"#0B3EC4\"},{\"text\":\"o\",\"color\":\"#0B38C9\"},{\"text\":\"a\",\"color\":\"#0C33CF\"},{\"text\":\"d\",\"color\":\"#0C2DD4\"},{\"text\":\"i\",\"color\":\"#0C27D9\"},{\"text\":\"n\",\"color\":\"#0C22DF\"},{\"text\":\"g\",\"color\":\"#0D1CE4\"},{\"text\":\" \"},{\"text\":\"o\",\"color\":\"#0D11EF\"},{\"text\":\"u\",\"color\":\"#0D0BF4\"},{\"text\":\"r\",\"color\":\"#0E06FA\"},{\"text\":\" \"},{\"text\":\"m\",\"color\":\"#1200FF\"},{\"text\":\"o\",\"color\":\"#1600FF\"},{\"text\":\"d\",\"color\":\"#1900FF\"},{\"text\":\".\",\"color\":\"#1D00FF\"},{\"text\":\" \"},{\"text\":\"H\",\"color\":\"#2500FF\"},{\"text\":\"e\",\"color\":\"#2900FF\"},{\"text\":\"r\",\"color\":\"#2D00FF\"},{\"text\":\"e\",\"color\":\"#3000FF\"},{\"text\":\" \"},{\"text\":\"i\",\"color\":\"#3800FF\"},{\"text\":\"s\",\"color\":\"#3C00FF\"},{\"text\":\" \"},{\"text\":\"t\",\"color\":\"#4300FF\"},{\"text\":\"h\",\"color\":\"#4700FF\"},{\"text\":\"e\",\"color\":\"#4B00FF\"},{\"text\":\" \"},{\"text\":\"l\",\"color\":\"#5300FF\"},{\"text\":\"i\",\"color\":\"#5700FF\"},{\"text\":\"n\",\"color\":\"#5A00FF\"},{\"text\":\"k\",\"color\":\"#5E00FF\"},{\"text\":\" \"},{\"text\":\"t\",\"color\":\"#6600FF\"},{\"text\":\"o\",\"color\":\"#6A00FF\"},{\"text\":\" \"},{\"text\":\"o\",\"color\":\"#7100FF\"},{\"text\":\"u\",\"color\":\"#7500FF\"},{\"text\":\"r\",\"color\":\"#7900FF\"},{\"text\":\" \"},{\"text\":\"D\",\"color\":\"#8000FF\"},{\"text\":\"i\",\"color\":\"#8400FF\"},{\"text\":\"s\",\"color\":\"#8800FF\"},{\"text\":\"c\",\"color\":\"#8C00FF\"},{\"text\":\"o\",\"color\":\"#9000FF\"},{\"text\":\"r\",\"color\":\"#9400FF\"},{\"text\":\"d\",\"color\":\"#9700FF\"},{\"text\":\"!\",\"color\":\"#9B00FF\"},{\"text\":\"\\n\"}]}",
					_txt0 -> ComponentSerialization.CODEC.parse(JsonOps.INSTANCE, com.google.gson.JsonParser.parseString(_txt0)).getOrThrow(), Component::empty)), false);
		if (entity instanceof Player _player3 && !_player3.level().isClientSide())
			_player3.displayClientMessage(((MutableComponent) tryOrDefault("{\"text\":\"https://discord.gg/qqcxxmCmV\",\"color\":\"blue\",\"underlined\":true,\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://discord.gg/qqcxxmCmV\"}}",
					_txt2 -> ComponentSerialization.CODEC.parse(JsonOps.INSTANCE, com.google.gson.JsonParser.parseString(_txt2)).getOrThrow(), Component::empty)), false);
	}

	private static <A, B> A tryOrDefault(B funcArg, FailableFunction<B, A, Exception> func, Supplier<A> fallback) {
		try {
			return func.apply(funcArg);
		} catch (Exception e) {
			return fallback.get();
		}
	}
}