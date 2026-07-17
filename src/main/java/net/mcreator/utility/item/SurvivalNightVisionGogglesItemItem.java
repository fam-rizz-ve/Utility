package net.mcreator.utility.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class SurvivalNightVisionGogglesItemItem extends Item {
	public SurvivalNightVisionGogglesItemItem() {
		super(new Item.Properties().durability(2000).rarity(Rarity.EPIC));
	}

	@Override
	public boolean isPiglinCurrency(ItemStack stack) {
		return true;
	}

	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return slotChanged && !oldStack.equals(newStack);
	}
}