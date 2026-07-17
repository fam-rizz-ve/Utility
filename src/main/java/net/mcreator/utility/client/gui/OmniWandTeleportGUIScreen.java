package net.mcreator.utility.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.utility.world.inventory.OmniWandTeleportGUIMenu;
import net.mcreator.utility.procedures.OmniWandSCrittaPlayer2Procedure;
import net.mcreator.utility.procedures.OmniWandSCrittaPlayer1Procedure;
import net.mcreator.utility.network.OmniWandTeleportGUIButtonMessage;
import net.mcreator.utility.init.UtilityModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class OmniWandTeleportGUIScreen extends AbstractContainerScreen<OmniWandTeleportGUIMenu> implements UtilityModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_empty;
	private Button button_empty1;
	private Button button_empty2;
	private Button button_empty3;
	private Button button_confirm;
	private Button button_empty4;
	private Button button_empty5;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("utility:textures/screens/omni_wand_teleport_gui.png");

	public OmniWandTeleportGUIScreen(OmniWandTeleportGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 146;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.utility.omni_wand_teleport_gui.label_teleport"), 65, 6, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.utility.omni_wand_teleport_gui.label_to"), 83, 51, -12829636, false);
		guiGraphics.drawString(this.font, OmniWandSCrittaPlayer1Procedure.execute(entity), 51, 24, -1, false);
		guiGraphics.drawString(this.font, OmniWandSCrittaPlayer2Procedure.execute(entity), 51, 74, -1, false);
	}

	@Override
	public void init() {
		super.init();
		button_empty = Button.builder(Component.translatable("gui.utility.omni_wand_teleport_gui.button_empty"), e -> {
			int x = OmniWandTeleportGUIScreen.this.x;
			int y = OmniWandTeleportGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OmniWandTeleportGUIButtonMessage(0, x, y, z));
				OmniWandTeleportGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 11, this.topPos + 20, 30, 20).build();
		this.addRenderableWidget(button_empty);
		button_empty1 = Button.builder(Component.translatable("gui.utility.omni_wand_teleport_gui.button_empty1"), e -> {
			int x = OmniWandTeleportGUIScreen.this.x;
			int y = OmniWandTeleportGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OmniWandTeleportGUIButtonMessage(1, x, y, z));
				OmniWandTeleportGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 137, this.topPos + 20, 30, 20).build();
		this.addRenderableWidget(button_empty1);
		button_empty2 = Button.builder(Component.translatable("gui.utility.omni_wand_teleport_gui.button_empty2"), e -> {
			int x = OmniWandTeleportGUIScreen.this.x;
			int y = OmniWandTeleportGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OmniWandTeleportGUIButtonMessage(2, x, y, z));
				OmniWandTeleportGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 11, this.topPos + 69, 30, 20).build();
		this.addRenderableWidget(button_empty2);
		button_empty3 = Button.builder(Component.translatable("gui.utility.omni_wand_teleport_gui.button_empty3"), e -> {
			int x = OmniWandTeleportGUIScreen.this.x;
			int y = OmniWandTeleportGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new OmniWandTeleportGUIButtonMessage(3, x, y, z));
				OmniWandTeleportGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 137, this.topPos + 69, 30, 20).build();
		this.addRenderableWidget(button_empty3);
		button_confirm = Button.builder(Component.translatable("gui.utility.omni_wand_teleport_gui.button_confirm"), e -> {
		}).bounds(this.leftPos + 56, this.topPos + 105, 60, 20).build();
		this.addRenderableWidget(button_confirm);
		button_empty4 = Button.builder(Component.translatable("gui.utility.omni_wand_teleport_gui.button_empty4"), e -> {
		}).bounds(this.leftPos + 47, this.topPos + 69, 80, 20).build();
		this.addRenderableWidget(button_empty4);
		button_empty5 = Button.builder(Component.translatable("gui.utility.omni_wand_teleport_gui.button_empty5"), e -> {
		}).bounds(this.leftPos + 47, this.topPos + 20, 80, 20).build();
		this.addRenderableWidget(button_empty5);
	}
}