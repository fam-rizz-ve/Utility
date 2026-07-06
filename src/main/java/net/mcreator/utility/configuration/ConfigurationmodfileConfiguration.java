package net.mcreator.utility.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ConfigurationmodfileConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;
	public static final ModConfigSpec.ConfigValue<Double> EXPLOSIVE_SUITE_COOLDOWN_TIME;
	public static final ModConfigSpec.ConfigValue<Double> EXPLOSIVE_SUITE_EXPLOSIVE_POWER;
	public static final ModConfigSpec.ConfigValue<Double> MEDIKIT_COOLDOWN_TIME;
	public static final ModConfigSpec.ConfigValue<Double> MEDIKIT_HEALING_STRENGTH;
	public static final ModConfigSpec.ConfigValue<Double> BENDAGES_COOLDOWN_TIME;
	public static final ModConfigSpec.ConfigValue<Double> BENDAGES_HEALING_STRENGTH;
	public static final ModConfigSpec.ConfigValue<Double> TACTICAL_SUIT_EFFECT_DURATION_TIME;
	public static final ModConfigSpec.ConfigValue<Double> TACTICAL_SUIT_EFFECT_COOLDOWN_TIME;
	static {
		BUILDER.push("explosive_suit");
		EXPLOSIVE_SUITE_COOLDOWN_TIME = BUILDER.define("explosive_suit_cooldown", (double) 100);
		EXPLOSIVE_SUITE_EXPLOSIVE_POWER = BUILDER.define("explosive_suit_power", (double) 10);
		BUILDER.pop();
		BUILDER.push("medikit");
		MEDIKIT_COOLDOWN_TIME = BUILDER.define("medikit_cooldown", (double) 240);
		MEDIKIT_HEALING_STRENGTH = BUILDER.define("medikit_healing_power", (double) 2);
		BUILDER.pop();
		BUILDER.push("bendage");
		BENDAGES_COOLDOWN_TIME = BUILDER.define("bendages_cooldown", (double) 120);
		BENDAGES_HEALING_STRENGTH = BUILDER.define("bendages_healing_power", (double) 1);
		BUILDER.pop();
		BUILDER.push("tactical_suit");
		TACTICAL_SUIT_EFFECT_DURATION_TIME = BUILDER.define("tactical_suit_effect_duration", (double) 3000);
		TACTICAL_SUIT_EFFECT_COOLDOWN_TIME = BUILDER.define("tactical_suit_effect_cooldown", (double) 8400);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}