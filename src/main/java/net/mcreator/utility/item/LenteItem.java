package net.mcreator.utility.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class LenteItem extends Item {
	public LenteItem() {
		super(new Item.Properties());
	}

	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return slotChanged && !oldStack.equals(newStack);
	}
}