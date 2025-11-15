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

public record EssenctionDistillizerJEIRecipeTypeRecipe(ResourceLocation id, SizedIngredient output) implements Recipe<net.minecraft.world.Container> {
	@Override
	public @Nonnull ResourceLocation getId() {
		return id;
	}

	@Override
	public @Nonnull NonNullList<Ingredient> getIngredients() {
		List<SizedIngredient> sizedIngredients = new ArrayList<>();
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

	public static class Type implements RecipeType<EssenctionDistillizerJEIRecipeTypeRecipe> {
		private Type() {
		}

		public static final RecipeType<EssenctionDistillizerJEIRecipeTypeRecipe> INSTANCE = new Type();
	}

	public static class Serializer implements RecipeSerializer<EssenctionDistillizerJEIRecipeTypeRecipe> {
		public static final Serializer INSTANCE = new Serializer();

		@Override
		public EssenctionDistillizerJEIRecipeTypeRecipe fromJson(ResourceLocation id, com.google.gson.JsonObject json) {
			SizedIngredient output = SizedIngredient.fromJson(json.get("output"));
			return new EssenctionDistillizerJEIRecipeTypeRecipe(id, output);
		}

		@Override
		public EssenctionDistillizerJEIRecipeTypeRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
			SizedIngredient output = SizedIngredient.read(buf);
			return new EssenctionDistillizerJEIRecipeTypeRecipe(id, output);
		}

		@Override
		public void toNetwork(FriendlyByteBuf buf, EssenctionDistillizerJEIRecipeTypeRecipe recipe) {
			recipe.output.toNetwork(buf);
		}
	}
}