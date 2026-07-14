package net.mcreator.utility.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class OmniWandsItem extends Item {
	public OmniWandsItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC));
	}
}