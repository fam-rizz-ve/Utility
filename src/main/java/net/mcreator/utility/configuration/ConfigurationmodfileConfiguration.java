package net.mcreator.utility.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ConfigurationmodfileConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;
	public static final ModConfigSpec.ConfigValue<Double> EXPLOSIVE_SUITE_COOLDOWN_TIME;
	static {
		BUILDER.push("explosive_suit");
		EXPLOSIVE_SUITE_COOLDOWN_TIME = BUILDER.define("explosive_suit_cooldown", (double) 100);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}