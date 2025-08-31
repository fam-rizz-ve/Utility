package net.mcreator.utility.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class BlastCellItem extends Item {
	public BlastCellItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}