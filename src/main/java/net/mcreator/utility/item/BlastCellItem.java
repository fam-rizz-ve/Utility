package net.mcreator.utility.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class BlastCellItem extends Item {
	public BlastCellItem() {
		super(new Item.Properties());
	}

	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return slotChanged && !oldStack.equals(newStack);
	}
}