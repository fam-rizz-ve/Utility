/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.utility.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.utility.item.*;
import net.mcreator.utility.UtilityMod;

public class UtilityModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(UtilityMod.MODID);
	public static final DeferredItem<Item> FLATKEY;
	public static final DeferredItem<Item> OVERWORDKEY;
	public static final DeferredItem<Item> NETHERKEY;
	public static final DeferredItem<Item> ENDKEY;
	public static final DeferredItem<Item> LIMBOKEY;
	public static final DeferredItem<Item> LIMBO_KEY_PART_1;
	public static final DeferredItem<Item> LIMINALY_KEY;
	public static final DeferredItem<Item> EMPTYKEY;
	public static final DeferredItem<Item> MEDIKIT;
	public static final DeferredItem<Item> BANDAGES;
	public static final DeferredItem<Item> TACTICALKNIFE;
	public static final DeferredItem<Item> IRONKNIFE;
	public static final DeferredItem<Item> KNIFEBLADE;
	public static final DeferredItem<Item> CREATIVENIGHTHELMET_HELMET;
	public static final DeferredItem<Item> EXPLOSIVESUIT_CHESTPLATE;
	public static final DeferredItem<Item> BLAST_CELL;
	public static final DeferredItem<Item> NIGHTELMET_HELMET;
	public static final DeferredItem<Item> NIGHTELMET_CHESTPLATE;
	public static final DeferredItem<Item> NIGHTELMET_LEGGINGS;
	public static final DeferredItem<Item> NIGHTELMET_BOOTS;
	public static final DeferredItem<Item> TACTICAL_TEMPLATE;
	public static final DeferredItem<Item> POWER_ESSENCE;
	public static final DeferredItem<Item> OVERWORLDESSENCE;
	public static final DeferredItem<Item> NEHTERESSENCE;
	public static final DeferredItem<Item> ENDESSECE;
	public static final DeferredItem<Item> FLATESSENCE;
	public static final DeferredItem<Item> ESSENCTIONDISTILIZER;
	public static final DeferredItem<Item> DUNGEONGENERATORBLOCK;
	public static final DeferredItem<Item> FADED_CONCRETE;
	public static final DeferredItem<Item> CREATIVEDESPWANWAND;
	public static final DeferredItem<Item> CREATIVE_NIGHT_VISION_GOGGLES;
	public static final DeferredItem<Item> SURVIVAL_NIGHT_VISION_GOGGLES_ITEM;
	public static final DeferredItem<Item> LENTI_SURVIVAL_NIGHT_VISION_GOGGLES;
	public static final DeferredItem<Item> LENTI_ROTTE_SURVIVAL_NIGHT_VISION_GOGGLES;
	public static final DeferredItem<Item> LENTI_ROTTE_SURVIVAL_N_IGHT_VISION_GOGGLES_ITEM;
	public static final DeferredItem<Item> BUILDING_TOOL;
	static {
		FLATKEY = REGISTRY.register("flatkey", FlatkeyItem::new);
		OVERWORDKEY = REGISTRY.register("overwordkey", OverwordkeyItem::new);
		NETHERKEY = REGISTRY.register("netherkey", NetherkeyItem::new);
		ENDKEY = REGISTRY.register("endkey", EndkeyItem::new);
		LIMBOKEY = REGISTRY.register("limbokey", LimbokeyItem::new);
		LIMBO_KEY_PART_1 = REGISTRY.register("limbo_key_part_1", LimboKeyPart1Item::new);
		LIMINALY_KEY = REGISTRY.register("liminaly_key", LiminalyKeyItem::new);
		EMPTYKEY = REGISTRY.register("emptykey", EmptykeyItem::new);
		MEDIKIT = REGISTRY.register("medikit", MedikitItem::new);
		BANDAGES = REGISTRY.register("bandages", BandagesItem::new);
		TACTICALKNIFE = REGISTRY.register("tacticalknife", TacticalknifeItem::new);
		IRONKNIFE = REGISTRY.register("ironknife", IronknifeItem::new);
		KNIFEBLADE = REGISTRY.register("knifeblade", KnifebladeItem::new);
		CREATIVENIGHTHELMET_HELMET = REGISTRY.register("creativenighthelmet_helmet", CreativenighthelmetItem.Helmet::new);
		EXPLOSIVESUIT_CHESTPLATE = REGISTRY.register("explosivesuit_chestplate", ExplosivesuitItem.Chestplate::new);
		BLAST_CELL = REGISTRY.register("blast_cell", BlastCellItem::new);
		NIGHTELMET_HELMET = REGISTRY.register("nightelmet_helmet", NightelmetItem.Helmet::new);
		NIGHTELMET_CHESTPLATE = REGISTRY.register("nightelmet_chestplate", NightelmetItem.Chestplate::new);
		NIGHTELMET_LEGGINGS = REGISTRY.register("nightelmet_leggings", NightelmetItem.Leggings::new);
		NIGHTELMET_BOOTS = REGISTRY.register("nightelmet_boots", NightelmetItem.Boots::new);
		TACTICAL_TEMPLATE = REGISTRY.register("tactical_template", TacticalTemplateItem::new);
		POWER_ESSENCE = REGISTRY.register("power_essence", PowerEssenceItem::new);
		OVERWORLDESSENCE = REGISTRY.register("overworldessence", OverworldessenceItem::new);
		NEHTERESSENCE = REGISTRY.register("nehteressence", NehteressenceItem::new);
		ENDESSECE = REGISTRY.register("endessece", EndesseceItem::new);
		FLATESSENCE = REGISTRY.register("flatessence", FlatessenceItem::new);
		ESSENCTIONDISTILIZER = block(UtilityModBlocks.ESSENCTIONDISTILIZER, new Item.Properties().rarity(Rarity.EPIC));
		DUNGEONGENERATORBLOCK = block(UtilityModBlocks.DUNGEONGENERATORBLOCK);
		FADED_CONCRETE = block(UtilityModBlocks.FADED_CONCRETE, new Item.Properties().rarity(Rarity.RARE));
		CREATIVEDESPWANWAND = REGISTRY.register("creativedespwanwand", CreativedespwanwandItem::new);
		CREATIVE_NIGHT_VISION_GOGGLES = REGISTRY.register("creative_night_vision_goggles", CreativeNightVisionGogglesItem::new);
		SURVIVAL_NIGHT_VISION_GOGGLES_ITEM = REGISTRY.register("survival_night_vision_goggles_item", SurvivalNightVisionGogglesItemItem::new);
		LENTI_SURVIVAL_NIGHT_VISION_GOGGLES = REGISTRY.register("lenti_survival_night_vision_goggles", LentiSurvivalNightVisionGogglesItem::new);
		LENTI_ROTTE_SURVIVAL_NIGHT_VISION_GOGGLES = REGISTRY.register("lenti_rotte_survival_night_vision_goggles", LentiRotteSurvivalNightVisionGogglesItem::new);
		LENTI_ROTTE_SURVIVAL_N_IGHT_VISION_GOGGLES_ITEM = REGISTRY.register("lenti_rotte_survival_n_ight_vision_goggles_item", LentiRotteSurvivalNIghtVisionGogglesItemItem::new);
		BUILDING_TOOL = REGISTRY.register("building_tool", BuildingToolItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}