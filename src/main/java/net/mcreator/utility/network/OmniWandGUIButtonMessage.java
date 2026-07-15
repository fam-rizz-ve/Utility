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

import net.mcreator.utility.procedures.QuandoPulsanteTeleportOmniWandECliccatoProcedure;
import net.mcreator.utility.procedures.QuandoPulsanteDisctruzioneOmniWandECliccatoProcedure;
import net.mcreator.utility.procedures.QuandoPulsanteDespawnOmniWandECliccatoProcedure;
import net.mcreator.utility.procedures.QuandoPulsanteBuildOmniWandECliccatoProcedure;
import net.mcreator.utility.UtilityMod;

@EventBusSubscriber
public record OmniWandGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<OmniWandGUIButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(UtilityMod.MODID, "omni_wand_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, OmniWandGUIButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, OmniWandGUIButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new OmniWandGUIButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<OmniWandGUIButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final OmniWandGUIButtonMessage message, final IPayloadContext context) {
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

			QuandoPulsanteDespawnOmniWandECliccatoProcedure.execute(entity);
		}
		if (buttonID == 1) {

			QuandoPulsanteDisctruzioneOmniWandECliccatoProcedure.execute(entity);
		}
		if (buttonID == 2) {

			QuandoPulsanteTeleportOmniWandECliccatoProcedure.execute(entity);
		}
		if (buttonID == 3) {

			QuandoPulsanteBuildOmniWandECliccatoProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		UtilityMod.addNetworkMessage(OmniWandGUIButtonMessage.TYPE, OmniWandGUIButtonMessage.STREAM_CODEC, OmniWandGUIButtonMessage::handleData);
	}
}