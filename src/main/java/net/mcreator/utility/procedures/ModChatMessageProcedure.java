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
					"[   {     \"text\": \"\",     \"extra\": [       {\"text\": \"W\", \"color\": \"#04DC2D\"},       {\"text\": \"e\", \"color\": \"#04D632\"},       {\"text\": \"l\", \"color\": \"#05D138\"},       {\"text\": \"c\", \"color\": \"#05CB3D\"},       {\"text\": \"o\", \"color\": \"#05C543\"},       {\"text\": \"m\", \"color\": \"#05C048\"},       {\"text\": \"e\", \"color\": \"#06BA4D\"},       {\"text\": \",\", \"color\": \"#06B553\"},       {\"text\": \" \"},       {\"text\": \"a\", \"color\": \"#06A95D\"},       {\"text\": \"n\", \"color\": \"#07A463\"},       {\"text\": \"d\", \"color\": \"#079E68\"},       {\"text\": \" \"},       {\"text\": \"t\", \"color\": \"#079373\"},       {\"text\": \"h\", \"color\": \"#088D78\"},       {\"text\": \"a\", \"color\": \"#08877E\"},       {\"text\": \"n\", \"color\": \"#088283\"},       {\"text\": \"k\", \"color\": \"#087C89\"},       {\"text\": \"s\", \"color\": \"#09768E\"},       {\"text\": \" \"},       {\"text\": \"f\", \"color\": \"#096B99\"},       {\"text\": \"o\", \"color\": \"#09669E\"},       {\"text\": \"r\", \"color\": \"#0A60A3\"},       {\"text\": \" \"},       {\"text\": \"d\", \"color\": \"#0A55AE\"},       {\"text\": \"o\", \"color\": \"#0A4FB4\"},       {\"text\": \"w\", \"color\": \"#0B49B9\"},       {\"text\": \"n\", \"color\": \"#0B44BE\"},       {\"text\": \"l\", \"color\": \"#0B3EC4\"},       {\"text\": \"o\", \"color\": \"#0B38C9\"},       {\"text\": \"a\", \"color\": \"#0C33CF\"},       {\"text\": \"d\", \"color\": \"#0C2DD4\"},       {\"text\": \"i\", \"color\": \"#0C27D9\"},       {\"text\": \"n\", \"color\": \"#0C22DF\"},       {\"text\": \"g\", \"color\": \"#0D1CE4\"},       {\"text\": \" \", \"color\": \"#0D11EF\"},       {\"text\": \"o\", \"color\": \"#0D11EF\"},       {\"text\": \"u\", \"color\": \"#0D0BF4\"},       {\"text\": \"r\", \"color\": \"#0E06FA\"},       {\"text\": \" \"},       {\"text\": \"m\", \"color\": \"#1200FF\"},       {\"text\": \"o\", \"color\": \"#1600FF\"},       {\"text\": \"d\", \"color\": \"#1900FF\"},       {\"text\": \".\", \"color\": \"#1D00FF\"},       {\"text\": \" \"},       {\"text\": \"H\", \"color\": \"#2500FF\"},       {\"text\": \"e\", \"color\": \"#2900FF\"},       {\"text\": \"r\", \"color\": \"#2D00FF\"},       {\"text\": \"e\", \"color\": \"#3000FF\"},       {\"text\": \" \"},       {\"text\": \"i\", \"color\": \"#3800FF\"},       {\"text\": \"s\", \"color\": \"#3C00FF\"},       {\"text\": \" \"},       {\"text\": \"t\", \"color\": \"#4300FF\"},       {\"text\": \"h\", \"color\": \"#4700FF\"},       {\"text\": \"e\", \"color\": \"#4B00FF\"},       {\"text\": \" \"},       {\"text\": \"l\", \"color\": \"#5300FF\"},       {\"text\": \"i\", \"color\": \"#5700FF\"},       {\"text\": \"n\", \"color\": \"#5A00FF\"},       {\"text\": \"k\", \"color\": \"#5E00FF\"},       {\"text\": \" \"},       {\"text\": \"t\", \"color\": \"#6600FF\"},       {\"text\": \"o\", \"color\": \"#6A00FF\"},       {\"text\": \" \"},       {\"text\": \"o\", \"color\": \"#7100FF\"},       {\"text\": \"u\", \"color\": \"#7500FF\"},       {\"text\": \"r\", \"color\": \"#7900FF\"},       {\"text\": \" \"},       {\"text\": \"D\", \"color\": \"#8000FF\"},       {\"text\": \"i\", \"color\": \"#8400FF\"},       {\"text\": \"s\", \"color\": \"#8800FF\"},       {\"text\": \"c\", \"color\": \"#8C00FF\"},       {\"text\": \"o\", \"color\": \"#9000FF\"},       {\"text\": \"r\", \"color\": \"#9400FF\"},       {\"text\": \"d\", \"color\": \"#9700FF\"},       {\"text\": \"!\", \"color\": \"#9B00FF\"},       {\"text\": \" (\"}     ]   },   {     \"text\": \"https://discord.gg/qqcxxmCmV\",     \"color\": \"blue\",     \"underlined\": true,     \"clickEvent\": {       \"action\": \"open_url\",       \"value\": \"https://discord.gg/qqcxxmCmV\"     }   },   {     \"text\": \")\"   } ]",
					_txt0 -> ComponentSerialization.CODEC.parse(JsonOps.INSTANCE, com.google.gson.JsonParser.parseString(_txt0)).getOrThrow(), Component::empty)), false);
		if (entity instanceof Player _player3 && !_player3.level().isClientSide())
			_player3.displayClientMessage(((MutableComponent) tryOrDefault(
					"{\"text\":\"\",\"extra\":[{\"text\":\"\\n\"},{\"text\":\"O\",\"color\":\"#04D831\"},{\"text\":\"t\",\"color\":\"#04D336\"},{\"text\":\"h\",\"color\":\"#05CF3A\"},{\"text\":\"e\",\"color\":\"#05CA3E\"},{\"text\":\"r\",\"color\":\"#05C642\"},{\"text\":\" \"},{\"text\":\"V\",\"color\":\"#05BD4B\"},{\"text\":\"e\",\"color\":\"#06B84F\"},{\"text\":\"r\",\"color\":\"#06B454\"},{\"text\":\"s\",\"color\":\"#06AF58\"},{\"text\":\"i\",\"color\":\"#06AB5C\"},{\"text\":\"o\",\"color\":\"#06A660\"},{\"text\":\"n\",\"color\":\"#07A265\"},{\"text\":\"s\",\"color\":\"#079D69\"},{\"text\":\" \"},{\"text\":\"a\",\"color\":\"#079472\"},{\"text\":\"v\",\"color\":\"#079076\"},{\"text\":\"a\",\"color\":\"#088B7A\"},{\"text\":\"i\",\"color\":\"#08877E\"},{\"text\":\"l\",\"color\":\"#088283\"},{\"text\":\"a\",\"color\":\"#087E87\"},{\"text\":\"b\",\"color\":\"#08798B\"},{\"text\":\"l\",\"color\":\"#097590\"},{\"text\":\"e\",\"color\":\"#097094\"},{\"text\":\":\",\"color\":\"#096C98\"},{\"text\":\"\\n\"},{\"text\":\"F\",\"color\":\"#0A63A1\"},{\"text\":\"o\",\"color\":\"#0A5EA5\"},{\"text\":\"r\",\"color\":\"#0A5AA9\"},{\"text\":\"g\",\"color\":\"#0A55AE\"},{\"text\":\"e\",\"color\":\"#0A51B2\"},{\"text\":\" \"},{\"text\":\"(\",\"color\":\"#0B48BA\"},{\"text\":\"D\",\"color\":\"#0B43BF\",\"bold\":true},{\"text\":\"i\",\"color\":\"#0B3FC3\",\"bold\":true},{\"text\":\"s\",\"color\":\"#0B3AC7\",\"bold\":true},{\"text\":\"c\",\"color\":\"#0C36CC\",\"bold\":true},{\"text\":\"o\",\"color\":\"#0C31D0\",\"bold\":true},{\"text\":\"n\",\"color\":\"#0C2DD4\",\"bold\":true},{\"text\":\"t\",\"color\":\"#0C28D8\",\"bold\":true},{\"text\":\"i\",\"color\":\"#0C24DD\",\"bold\":true},{\"text\":\"n\",\"color\":\"#0D1FE1\",\"bold\":true},{\"text\":\"u\",\"color\":\"#0D1BE5\",\"bold\":true},{\"text\":\"e\",\"color\":\"#0D16EA\",\"bold\":true},{\"text\":\"d\",\"color\":\"#0D12EE\",\"bold\":true},{\"text\":\" \"},{\"text\":\"f\",\"color\":\"#0E09F6\",\"bold\":true},{\"text\":\"o\",\"color\":\"#0E04FB\",\"bold\":true},{\"text\":\"r\",\"color\":\"#0E00FF\",\"bold\":true},{\"text\":\" \"},{\"text\":\"n\",\"color\":\"#1400FF\",\"bold\":true},{\"text\":\"o\",\"color\":\"#1700FF\",\"bold\":true},{\"text\":\"w\",\"color\":\"#1A00FF\",\"bold\":true},{\"text\":\")\",\"color\":\"#1D00FF\"},{\"text\":\":\",\"color\":\"#2000FF\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"#2600FF\"},{\"text\":\"1\",\"color\":\"#2900FF\",\"underlined\":true},{\"text\":\".\",\"color\":\"#2C00FF\",\"underlined\":true},{\"text\":\"2\",\"color\":\"#2F00FF\",\"underlined\":true},{\"text\":\"0\",\"color\":\"#3200FF\",\"underlined\":true},{\"text\":\".\",\"color\":\"#3400FF\",\"underlined\":true},{\"text\":\"1\",\"color\":\"#3700FF\",\"underlined\":true},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"#3D00FF\"},{\"text\":\"1\",\"color\":\"#4000FF\",\"underlined\":true},{\"text\":\".\",\"color\":\"#4300FF\",\"underlined\":true},{\"text\":\"1\",\"color\":\"#4600FF\",\"underlined\":true},{\"text\":\"9\",\"color\":\"#4900FF\",\"underlined\":true},{\"text\":\".\",\"color\":\"#4C00FF\",\"underlined\":true},{\"text\":\"4\",\"color\":\"#4F00FF\",\"underlined\":true},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"#5500FF\"},{\"text\":\"1\",\"color\":\"#5800FF\",\"underlined\":true},{\"text\":\".\",\"color\":\"#5B00FF\",\"underlined\":true},{\"text\":\"1\",\"color\":\"#5E00FF\",\"underlined\":true},{\"text\":\"9\",\"color\":\"#6100FF\",\"underlined\":true},{\"text\":\".\",\"color\":\"#6400FF\",\"underlined\":true},{\"text\":\"2\",\"color\":\"#6700FF\",\"underlined\":true},{\"text\":\"\\n\"},{\"text\":\"N\",\"color\":\"#6D00FF\"},{\"text\":\"e\",\"color\":\"#7000FF\"},{\"text\":\"o\",\"color\":\"#7300FF\"},{\"text\":\"f\",\"color\":\"#7600FF\"},{\"text\":\"o\",\"color\":\"#7900FF\"},{\"text\":\"r\",\"color\":\"#7B00FF\"},{\"text\":\"g\",\"color\":\"#7E00FF\"},{\"text\":\"e\",\"color\":\"#8100FF\"},{\"text\":\":\",\"color\":\"#8400FF\"},{\"text\":\" \"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"#8D00FF\"},{\"text\":\"1\",\"color\":\"#9000FF\",\"underlined\":true},{\"text\":\".\",\"color\":\"#9300FF\",\"underlined\":true},{\"text\":\"2\",\"color\":\"#9600FF\",\"underlined\":true},{\"text\":\"1\",\"color\":\"#9900FF\",\"underlined\":true},{\"text\":\".\",\"color\":\"#9C00FF\",\"underlined\":true},{\"text\":\"1\",\"color\":\"#9F00FF\",\"underlined\":true}]}",
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