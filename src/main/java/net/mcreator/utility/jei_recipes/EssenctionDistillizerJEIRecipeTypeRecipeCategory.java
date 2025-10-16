package net.mcreator.utility.jei_recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.utility.init.UtilityModJeiPlugin;
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

public class EssenctionDistillizerJEIRecipeTypeRecipeCategory implements IRecipeCategory<EssenctionDistillizerJEIRecipeTypeRecipe> {
	public final static ResourceLocation UID = ResourceLocation.parse("utility:essenction_distillizer_jei_recipe_type");
	public final static ResourceLocation TEXTURE = ResourceLocation.parse("utility:textures/screens/essenctiondistillizerjei.png");
	private final IDrawable background;
	private final IDrawable icon;

	public EssenctionDistillizerJEIRecipeTypeRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 83);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(UtilityModBlocks.ESSENCTIONDISTILIZER.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<EssenctionDistillizerJEIRecipeTypeRecipe> getRecipeType() {
		return UtilityModJeiPlugin.EssenctionDistillizerJEIRecipeType_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Essenction Distillizer");
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
	public void draw(EssenctionDistillizerJEIRecipeTypeRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		this.background.draw(guiGraphics);
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, EssenctionDistillizerJEIRecipeTypeRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 70, 8).addIngredients(VanillaTypes.ITEM_STACK, Arrays.asList(recipe.slot0ItemInput().getItems()));
		builder.addSlot(RecipeIngredientRole.INPUT, 88, 35).addIngredients(VanillaTypes.ITEM_STACK, Arrays.asList(recipe.slot1ItemInput().getItems()));
		builder.addSlot(RecipeIngredientRole.INPUT, 70, 62).addIngredients(VanillaTypes.ITEM_STACK, Arrays.asList(recipe.slot2ItemInput().getItems()));
		builder.addSlot(RecipeIngredientRole.INPUT, 34, 62).addIngredients(VanillaTypes.ITEM_STACK, Arrays.asList(recipe.slot3ItemInput().getItems()));
		builder.addSlot(RecipeIngredientRole.INPUT, 16, 35).addIngredients(VanillaTypes.ITEM_STACK, Arrays.asList(recipe.slot4ItemInput().getItems()));
		builder.addSlot(RecipeIngredientRole.INPUT, 34, 8).addIngredients(VanillaTypes.ITEM_STACK, Arrays.asList(recipe.slot5ItemInput().getItems()));
		builder.addSlot(RecipeIngredientRole.INPUT, 52, 35).addIngredients(VanillaTypes.ITEM_STACK, Arrays.asList(recipe.slot6ItemInput().getItems()));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 142, 35).addItemStack(recipe.getResult(0));
	}
}