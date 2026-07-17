/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.utility.init;

import org.lwjgl.glfw.GLFW;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.utility.network.ExplosivesuitattivazioneMessage;
import net.mcreator.utility.network.AttivadisattivanighthelmetMessage;

@EventBusSubscriber(Dist.CLIENT)
public class UtilityModKeyMappings {
	public static final KeyMapping ATTIVADISATTIVANIGHTHELMET = new KeyMapping("key.utility.attivadisattivanighthelmet", GLFW.GLFW_KEY_H, "key.category.utility.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new AttivadisattivanighthelmetMessage(0, 0));
				AttivadisattivanighthelmetMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping EXPLOSIVESUITATTIVAZIONE = new KeyMapping("key.utility.explosivesuitattivazione", GLFW.GLFW_KEY_J, "key.category.utility.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new ExplosivesuitattivazioneMessage(0, 0));
				ExplosivesuitattivazioneMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(ATTIVADISATTIVANIGHTHELMET);
		event.register(EXPLOSIVESUITATTIVAZIONE);
	}

	@EventBusSubscriber(Dist.CLIENT)
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				ATTIVADISATTIVANIGHTHELMET.consumeClick();
				EXPLOSIVESUITATTIVAZIONE.consumeClick();
			}
		}
	}
}