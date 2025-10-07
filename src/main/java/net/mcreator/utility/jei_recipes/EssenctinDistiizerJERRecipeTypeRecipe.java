package net.mcreator.utility.jei_recipes;

import org.checkerframework.checker.units.qual.h;

import net.minecraft.world.level.storage.loot.Serializer;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.NonNullList;

import net.mcreator.utility.util.SizedIngredient;

import javax.annotation.Nonnull;

import java.util.List;
import java.util.ArrayList;

public record EssenctinDistiizerJERRecipeTypeRecipe(ResourceLocation id, SizedIngredient slot0ItemInput, SizedIngredient slot1ItemInput, SizedIngredient slot2ItemInput, SizedIngredient slot3ItemInput, SizedIngredient slot4ItemInput,
		SizedIngredient slot5ItemInput, SizedIngredient slot6ItemInput, SizedIngredient output) implements Recipe<net.minecraft.world.Container> {
	@Override
	public @Nonnull ResourceLocation getId() {
		return id;
	}

	@Override
	public @Nonnull NonNullList<Ingredient> getIngredients() {
		List<SizedIngredient> sizedIngredients = new ArrayList<>();
		sizedIngredients.add(slot0ItemInput);
		sizedIngredients.add(slot1ItemInput);
		sizedIngredients.add(slot2ItemInput);
		sizedIngredients.add(slot3ItemInput);
		sizedIngredients.add(slot4ItemInput);
		sizedIngredients.add(slot5ItemInput);
		sizedIngredients.add(slot6ItemInput);
		NonNullList<Ingredient> ingredients = NonNullList.createWithCapacity(sizedIngredients.size());
		for (SizedIngredient si : sizedIngredients) {
			ingredients.add(si.ingredient());
		}
		return ingredients;
	}

	@Override
	public boolean matches(@Nonnull net.minecraft.world.Container container, @Nonnull Level level) {
		return false;
	}

	@Override
	public boolean canCraftInDimensions(int w, int h) {
		return true;
	}

	@Override
	public @Nonnull ItemStack assemble(@Nonnull net.minecraft.world.Container container, @Nonnull net.minecraft.core.RegistryAccess registryAccess) {
		return ItemStack.EMPTY;
	}

	@Override
	public @Nonnull ItemStack getResultItem(@Nonnull net.minecraft.core.RegistryAccess registryAccess) {
		ItemStack[] stacks = output.getItems();
		return stacks.length > 0 ? stacks[0].copy() : ItemStack.EMPTY;
	}

	public @Nonnull ItemStack getResult(int idx) {
		ItemStack[] stack = output.getItems();
		return stack[0];
	}

	public ItemStack assemble(@Nonnull net.minecraft.world.Container container) {
		return ItemStack.EMPTY;
	}

	@Override
	public @Nonnull RecipeSerializer<?> getSerializer() {
		return Serializer.INSTANCE;
	}

	@Override
	public @Nonnull RecipeType<?> getType() {
		return Type.INSTANCE;
	}

	public static class Type implements RecipeType<EssenctinDistiizerJERRecipeTypeRecipe> {
		private Type() {
		}

		public static final RecipeType<EssenctinDistiizerJERRecipeTypeRecipe> INSTANCE = new Type();
	}

	public static class Serializer implements RecipeSerializer<EssenctinDistiizerJERRecipeTypeRecipe> {
		public static final Serializer INSTANCE = new Serializer();

		@Override
		public EssenctinDistiizerJERRecipeTypeRecipe fromJson(ResourceLocation id, com.google.gson.JsonObject json) {
			SizedIngredient slot0ItemInput = SizedIngredient.fromJson(json.get("slot0"));
			SizedIngredient slot1ItemInput = SizedIngredient.fromJson(json.get("slot1"));
			SizedIngredient slot2ItemInput = SizedIngredient.fromJson(json.get("slot2"));
			SizedIngredient slot3ItemInput = SizedIngredient.fromJson(json.get("slot3"));
			SizedIngredient slot4ItemInput = SizedIngredient.fromJson(json.get("slot4"));
			SizedIngredient slot5ItemInput = SizedIngredient.fromJson(json.get("slot5"));
			SizedIngredient slot6ItemInput = SizedIngredient.fromJson(json.get("slot6"));
			SizedIngredient output = SizedIngredient.fromJson(json.get("output"));
			return new EssenctinDistiizerJERRecipeTypeRecipe(id, slot0ItemInput, slot1ItemInput, slot2ItemInput, slot3ItemInput, slot4ItemInput, slot5ItemInput, slot6ItemInput, output);
		}

		@Override
		public EssenctinDistiizerJERRecipeTypeRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
			SizedIngredient slot0ItemInput = SizedIngredient.read(buf);
			SizedIngredient slot1ItemInput = SizedIngredient.read(buf);
			SizedIngredient slot2ItemInput = SizedIngredient.read(buf);
			SizedIngredient slot3ItemInput = SizedIngredient.read(buf);
			SizedIngredient slot4ItemInput = SizedIngredient.read(buf);
			SizedIngredient slot5ItemInput = SizedIngredient.read(buf);
			SizedIngredient slot6ItemInput = SizedIngredient.read(buf);
			SizedIngredient output = SizedIngredient.read(buf);
			return new EssenctinDistiizerJERRecipeTypeRecipe(id, slot0ItemInput, slot1ItemInput, slot2ItemInput, slot3ItemInput, slot4ItemInput, slot5ItemInput, slot6ItemInput, output);
		}

		@Override
		public void toNetwork(FriendlyByteBuf buf, EssenctinDistiizerJERRecipeTypeRecipe recipe) {
			recipe.slot0ItemInput.toNetwork(buf);
			recipe.slot1ItemInput.toNetwork(buf);
			recipe.slot2ItemInput.toNetwork(buf);
			recipe.slot3ItemInput.toNetwork(buf);
			recipe.slot4ItemInput.toNetwork(buf);
			recipe.slot5ItemInput.toNetwork(buf);
			recipe.slot6ItemInput.toNetwork(buf);
			recipe.output.toNetwork(buf);
		}
	}
}