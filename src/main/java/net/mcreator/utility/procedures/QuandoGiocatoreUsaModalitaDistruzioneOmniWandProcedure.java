package net.mcreator.utility.procedures;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.SectionPos;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.screens.Screen;

import net.mcreator.utility.network.UtilityModVariables;
import net.mcreator.utility.init.UtilityModItems;
import net.mcreator.utility.UtilityMod;

import javax.annotation.Nullable;

@EventBusSubscriber(Dist.CLIENT)
public class QuandoGiocatoreUsaModalitaDistruzioneOmniWandProcedure {
	@SubscribeEvent
	public static void onLeftClick(PlayerInteractEvent.LeftClickEmpty event) {
		PacketDistributor.sendToServer(new QuandoGiocatoreUsaModalitaDistruzioneOmniWandMessage());
		execute(event.getLevel(), event.getEntity());
	}

	@EventBusSubscriber
	public record QuandoGiocatoreUsaModalitaDistruzioneOmniWandMessage() implements CustomPacketPayload {
		public static final Type<QuandoGiocatoreUsaModalitaDistruzioneOmniWandMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(UtilityMod.MODID, "procedure_quando_giocatore_usa_modalita_distruzione_omni_wand"));
		public static final StreamCodec<RegistryFriendlyByteBuf, QuandoGiocatoreUsaModalitaDistruzioneOmniWandMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, QuandoGiocatoreUsaModalitaDistruzioneOmniWandMessage message) -> {
		}, (RegistryFriendlyByteBuf buffer) -> new QuandoGiocatoreUsaModalitaDistruzioneOmniWandMessage());

		@Override
		public Type<QuandoGiocatoreUsaModalitaDistruzioneOmniWandMessage> type() {
			return TYPE;
		}

		public static void handleData(final QuandoGiocatoreUsaModalitaDistruzioneOmniWandMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.SERVERBOUND) {
				context.enqueueWork(() -> {
					if (!context.player().level().getChunkSource().hasChunk(SectionPos.blockToSectionCoord(context.player().getX()), SectionPos.blockToSectionCoord(context.player().getZ())))
						return;
					execute(context.player().level(), context.player());
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}

		@SubscribeEvent
		public static void registerMessage(FMLCommonSetupEvent event) {
			UtilityMod.addNetworkMessage(QuandoGiocatoreUsaModalitaDistruzioneOmniWandMessage.TYPE, QuandoGiocatoreUsaModalitaDistruzioneOmniWandMessage.STREAM_CODEC, QuandoGiocatoreUsaModalitaDistruzioneOmniWandMessage::handleData);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double BloccoX = 0;
		double BloccoY = 0;
		double BloccoZ = 0;
		double InizialeX = 0;
		double InizialeZ = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UtilityModItems.OMNI_WANDS.get() && entity.getData(UtilityModVariables.PLAYER_VARIABLES).ModalitaOmniWand == 2
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == UtilityModItems.DESTRUCTIBLE_WAND.get()) {
			if (Screen.hasControlDown()) {
				{
					UtilityModVariables.PlayerVariables _vars = entity.getData(UtilityModVariables.PLAYER_VARIABLES);
					_vars.YGuardataPlayerOmniWandDistruzione = entity.level()
							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(500)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1;
					_vars.markSyncDirty();
				}
			} else {
				BloccoY = entity.getData(UtilityModVariables.PLAYER_VARIABLES).YGuardataPlayerOmniWandDistruzione;
				BloccoX = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(500)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()
						- entity.getData(UtilityModVariables.PLAYER_VARIABLES).GrandezzaCuboXZOmniWandDistruzione / 2;
				BloccoZ = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(500)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()
						- entity.getData(UtilityModVariables.PLAYER_VARIABLES).GrandezzaCuboXZOmniWandDistruzione / 2;
				InizialeX = BloccoX;
				InizialeZ = BloccoZ;
				for (int index207 = 0; index207 < (int) entity.getData(UtilityModVariables.PLAYER_VARIABLES).GrandezzaCuboYOmniWandDistruzione; index207++) {
					for (int index208 = 0; index208 < (int) entity.getData(UtilityModVariables.PLAYER_VARIABLES).GrandezzaCuboXZOmniWandDistruzione; index208++) {
						for (int index209 = 0; index209 < (int) entity.getData(UtilityModVariables.PLAYER_VARIABLES).GrandezzaCuboXZOmniWandDistruzione; index209++) {
							world.setBlock(BlockPos.containing(BloccoX, BloccoY, BloccoZ), Blocks.AIR.defaultBlockState(), 3);
							BloccoX = BloccoX + 1;
						}
						BloccoZ = BloccoZ + 1;
						BloccoX = InizialeX;
					}
					BloccoY = BloccoY + 1;
					BloccoZ = InizialeZ;
				}
			}
		}
	}
}