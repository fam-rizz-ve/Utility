package net.mcreator.utility.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.utility.world.inventory.OmniWandGUIMenu;
import net.mcreator.utility.network.OmniWandGUIButtonMessage;
import net.mcreator.utility.init.UtilityModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class OmniWandGUIScreen extends AbstractContainerScreen<OmniWandGUIMenu> implements UtilityModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_despawn;
	private ImageButton imagebutton_demolizione;
	private ImageButton imagebutton_teleport;
	private ImageButton imagebutton_costruire;

	public OmniWandGUIScreen(OmniWandGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 400;
		this.imageHeight = 200;
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
		guiGraphics.drawString(this.font, Component.translatable("gui.utility.omni_wand_gui.label_select_the_wand_mode"), 145, 24, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.utility.omni_wand_gui.label_destrucion"), 87, 56, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.utility.omni_wand_gui.label_wand_mode"), 204, 24, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.utility.omni_wand_gui.label_destruction"), 132, 56, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.utility.omni_wand_gui.label_teleport"), 204, 56, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.utility.omni_wand_gui.label_build"), 276, 56, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_despawn = new ImageButton(this.leftPos + 86, this.topPos + 78, 33, 33, new WidgetSprites(ResourceLocation.parse("utility:textures/screens/despawn.png"), ResourceLocation.parse("utility:textures/screens/despawnselezionato.png")),
				e -> {
					int x = OmniWandGUIScreen.this.x;
					int y = OmniWandGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new OmniWandGUIButtonMessage(0, x, y, z));
						OmniWandGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_despawn);
		imagebutton_demolizione = new ImageButton(this.leftPos + 149, this.topPos + 75, 33, 39,
				new WidgetSprites(ResourceLocation.parse("utility:textures/screens/demolizione.png"), ResourceLocation.parse("utility:textures/screens/descruzioneselzionata.png")), e -> {
					int x = OmniWandGUIScreen.this.x;
					int y = OmniWandGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new OmniWandGUIButtonMessage(1, x, y, z));
						OmniWandGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_demolizione);
		imagebutton_teleport = new ImageButton(this.leftPos + 204, this.topPos + 69, 54, 51,
				new WidgetSprites(ResourceLocation.parse("utility:textures/screens/teleport.png"), ResourceLocation.parse("utility:textures/screens/teleportselezionato.png")), e -> {
					int x = OmniWandGUIScreen.this.x;
					int y = OmniWandGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new OmniWandGUIButtonMessage(2, x, y, z));
						OmniWandGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_teleport);
		imagebutton_costruire = new ImageButton(this.leftPos + 271, this.topPos + 77, 45, 45,
				new WidgetSprites(ResourceLocation.parse("utility:textures/screens/costruire.png"), ResourceLocation.parse("utility:textures/screens/costruireselezionato.png")), e -> {
					int x = OmniWandGUIScreen.this.x;
					int y = OmniWandGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new OmniWandGUIButtonMessage(3, x, y, z));
						OmniWandGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_costruire);
	}
}