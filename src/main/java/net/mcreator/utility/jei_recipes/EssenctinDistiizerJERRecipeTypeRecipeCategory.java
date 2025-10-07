package net.mcreator.utility.jei_recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.utility.init.UtilityModBlocks;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

import java.util.Arrays;

public class EssenctinDistiizerJERRecipeTypeRecipeCategory implements IRecipeCategory<EssenctinDistiizerJERRecipeTypeRecipe> {
	public final static ResourceLocation UID = ResourceLocation.parse("utility:essenctin_distiizer_jer_recipe_type");
	public final static ResourceLocation TEXTURE = ResourceLocation.parse("utility:textures/screens/essenctiondistilizer_gui.png");
	private final IDrawable background;
	private final IDrawable icon;

	public EssenctinDistiizerJERRecipeTypeRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 300, 130);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(UtilityModBlocks.ESSENCTIONDISTILIZER.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<EssenctinDistiizerJERRecipeTypeRecipe> getRecipeType() {
		return UtilityModJeiPlugin.EssenctinDistiizerJERRecipeType_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Essenction distilizer");
	}

	@Override
	public IDrawable getBackground() {
		return this.background;
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public int getWidth() {
		return this.background.getWidth();
	}

	@Override
	public int getHeight() {
		return this.background.getHeight();
	}

	@Override
	public void draw(EssenctinDistiizerJERRecipeTypeRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		this.background.draw(guiGraphics);
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, EssenctinDistiizerJERRecipeTypeRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 4, 4).addIngredients(VanillaTypes.ITEM_STACK, Arrays.asList(recipe.slot0ItemInput().getItems()));
		builder.addSlot(RecipeIngredientRole.INPUT, 6, 6).addIngredients(VanillaTypes.ITEM_STACK, Arrays.asList(recipe.slot1ItemInput().getItems()));
		builder.addSlot(RecipeIngredientRole.INPUT, 0, 0).addIngredients(VanillaTypes.ITEM_STACK, Arrays.asList(recipe.slot2ItemInput().getItems()));
		builder.addSlot(RecipeIngredientRole.INPUT, 0, 0).addIngredients(VanillaTypes.ITEM_STACK, Arrays.asList(recipe.slot3ItemInput().getItems()));
		builder.addSlot(RecipeIngredientRole.INPUT, 0, 0).addIngredients(VanillaTypes.ITEM_STACK, Arrays.asList(recipe.slot4ItemInput().getItems()));
		builder.addSlot(RecipeIngredientRole.INPUT, 0, 0).addIngredients(VanillaTypes.ITEM_STACK, Arrays.asList(recipe.slot5ItemInput().getItems()));
		builder.addSlot(RecipeIngredientRole.INPUT, 0, 0).addIngredients(VanillaTypes.ITEM_STACK, Arrays.asList(recipe.slot6ItemInput().getItems()));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 0, 0).addItemStack(recipe.getResult(0));
	}
}