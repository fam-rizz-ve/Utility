/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.utility.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.utility.client.gui.InventoryeditorGUIScreen;
import net.mcreator.utility.client.gui.EssenctiondistilizerGUIScreen;

@EventBusSubscriber(Dist.CLIENT)
public class UtilityModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(UtilityModMenus.ESSENCTIONDISTILIZER_GUI.get(), EssenctiondistilizerGUIScreen::new);
		event.register(UtilityModMenus.INVENTORYEDITOR_GUI.get(), InventoryeditorGUIScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}