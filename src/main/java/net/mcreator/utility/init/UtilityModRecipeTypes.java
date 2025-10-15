package net.mcreator.utility.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraft.world.item.crafting.RecipeSerializer;

import net.mcreator.utility.jei_recipes.EssenctionDistillizerJEIRecipeTypeRecipe;
import net.mcreator.utility.UtilityMod;

@Mod.EventBusSubscriber(modid = UtilityMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class UtilityModRecipeTypes {
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, "utility");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		event.enqueueWork(() -> {
			SERIALIZERS.register(bus);
			SERIALIZERS.register("essenction_distillizer_jei_recipe_type", () -> EssenctionDistillizerJEIRecipeTypeRecipe.Serializer.INSTANCE);
		});
	}
}