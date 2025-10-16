package net.mcreator.utility.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.List;

@JeiPlugin
public class UtilityModJeiInformation implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("utility:information");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		registration.addIngredientInfo(List.of(new ItemStack(UtilityModItems.LIMBO_KEY_PART_1.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.utility.limbo_key_part_1_jei"));
		registration.addIngredientInfo(List.of(new ItemStack(UtilityModBlocks.ESSENCTIONDISTILIZER.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.utility.essenction_distillizer_jei_information"));
	}
}