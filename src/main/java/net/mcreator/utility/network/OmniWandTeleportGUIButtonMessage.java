package net.mcreator.utility.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.SectionPos;

import net.mcreator.utility.procedures.OmniWandPulsanteSinistraCambioPlayer2Procedure;
import net.mcreator.utility.procedures.OmniWandPulsanteSinistraCambioPlayer1Procedure;
import net.mcreator.utility.procedures.OmniWandPulsanteDestraCambioPlayer2Procedure;
import net.mcreator.utility.procedures.OmniWandPulsanteDestraCambioPlayer1Procedure;
import net.mcreator.utility.UtilityMod;

@EventBusSubscriber
public record OmniWandTeleportGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<OmniWandTeleportGUIButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(UtilityMod.MODID, "omni_wand_teleport_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, OmniWandTeleportGUIButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, OmniWandTeleportGUIButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new OmniWandTeleportGUIButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<OmniWandTeleportGUIButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final OmniWandTeleportGUIButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.getChunkSource().hasChunk(SectionPos.blockToSectionCoord(x), SectionPos.blockToSectionCoord(z)))
			return;
		if (buttonID == 0) {

			OmniWandPulsanteSinistraCambioPlayer1Procedure.execute(world, entity);
		}
		if (buttonID == 1) {

			OmniWandPulsanteDestraCambioPlayer1Procedure.execute(world, entity);
		}
		if (buttonID == 2) {

			OmniWandPulsanteSinistraCambioPlayer2Procedure.execute(world, entity);
		}
		if (buttonID == 3) {

			OmniWandPulsanteDestraCambioPlayer2Procedure.execute(world, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		UtilityMod.addNetworkMessage(OmniWandTeleportGUIButtonMessage.TYPE, OmniWandTeleportGUIButtonMessage.STREAM_CODEC, OmniWandTeleportGUIButtonMessage::handleData);
	}
}