package net.mcreator.utility.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class CreativeNightVisionGogglesItem extends Item {
	public CreativeNightVisionGogglesItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC));
	}
}