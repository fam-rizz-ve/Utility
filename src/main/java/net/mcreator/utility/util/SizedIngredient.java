package net.mcreator.utility.util;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.FriendlyByteBuf;

public record SizedIngredient(Ingredient ingredient, int count) {
	public static SizedIngredient fromJson(com.google.gson.JsonElement json) {
		Ingredient ing = Ingredient.fromJson(json);
		return new SizedIngredient(ing, 1);
	}

	public static SizedIngredient read(FriendlyByteBuf buf) {
		Ingredient ing = Ingredient.fromNetwork(buf);
		int count = buf.readVarInt();
		return new SizedIngredient(ing, count);
	}

	public void toNetwork(FriendlyByteBuf buf) {
		ingredient.toNetwork(buf);
		buf.writeVarInt(count);
	}

	public ItemStack[] getItems() {
		return java.util.Arrays.stream(ingredient.getItems()).map(stack -> {
			ItemStack copy = stack.copy();
			copy.setCount(count);
			return copy;
		}).toArray(ItemStack[]::new);
	}
}