package net.mcreator.utility.init;

import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.utility.jei_recipes.EssenctionDistillizerJEIRecipeTypeRecipeCategory;
import net.mcreator.utility.jei_recipes.EssenctionDistillizerJEIRecipeTypeRecipe;
import net.mcreator.utility.client.gui.EssenctiondistilizerGUIScreen;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.Objects;
import java.util.List;

@JeiPlugin
public class UtilityModJeiPlugin implements IModPlugin {
	public static mezz.jei.api.recipe.RecipeType<EssenctionDistillizerJEIRecipeTypeRecipe> EssenctionDistillizerJEIRecipeType_Type = new mezz.jei.api.recipe.RecipeType<>(EssenctionDistillizerJEIRecipeTypeRecipeCategory.UID,
			EssenctionDistillizerJEIRecipeTypeRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("utility:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new EssenctionDistillizerJEIRecipeTypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		List<EssenctionDistillizerJEIRecipeTypeRecipe> EssenctionDistillizerJEIRecipeTypeRecipes = recipeManager.getAllRecipesFor(EssenctionDistillizerJEIRecipeTypeRecipe.Type.INSTANCE);
		registration.addRecipes(EssenctionDistillizerJEIRecipeType_Type, EssenctionDistillizerJEIRecipeTypeRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(UtilityModBlocks.ESSENCTIONDISTILIZER.get().asItem()), EssenctionDistillizerJEIRecipeType_Type);
	}

	@Override
	public void registerGuiHandlers(IGuiHandlerRegistration registration) {
		registration.addRecipeClickArea(EssenctiondistilizerGUIScreen.class, 1, 1, 100, 100, EssenctionDistillizerJEIRecipeType_Type);
	}
}