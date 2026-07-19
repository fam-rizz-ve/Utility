package net.mcreator.utility.client.gui;

import net.neoforged.neoforge.client.gui.widget.ExtendedSlider;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.utility.world.inventory.GUIOmniWandDIstruzioneMenu;
import net.mcreator.utility.init.UtilityModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class GUIOmniWandDIstruzioneScreen extends AbstractContainerScreen<GUIOmniWandDIstruzioneMenu> implements UtilityModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_confirm;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("utility:textures/screens/gui_omni_wand_d_istruzione.png");
	private ExtendedSlider WidthAndDepth;
	private ExtendedSlider altezza;

	public GUIOmniWandDIstruzioneScreen(GUIOmniWandDIstruzioneMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 146;
		this.imageHeight = 116;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 2 && elementState instanceof Number n) {
			if (name.equals("WidthAndDepth"))
				WidthAndDepth.setValue(n.doubleValue());
			else if (name.equals("altezza"))
				altezza.setValue(n.doubleValue());
		}
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
	public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
		return (this.getFocused() != null && this.isDragging() && button == 0) ? this.getFocused().mouseDragged(mouseX, mouseY, button, dragX, dragY) : super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.utility.gui_omni_wand_d_istruzione.label_configure_the_cube_size"), 9, 9, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_confirm = Button.builder(Component.translatable("gui.utility.gui_omni_wand_d_istruzione.button_confirm"), e -> {
		}).bounds(this.leftPos + 36, this.topPos + 81, 60, 20).build();
		this.addRenderableWidget(button_confirm);
		WidthAndDepth = new ExtendedSlider(this.leftPos + 11, this.topPos + 27, 120, 20, Component.translatable("gui.utility.gui_omni_wand_d_istruzione.WidthAndDepth_prefix"),
				Component.translatable("gui.utility.gui_omni_wand_d_istruzione.WidthAndDepth_suffix"), 1, 99, 5, 1, 0, true) {
			@Override
			protected void applyValue() {
				if (!menuStateUpdateActive)
					menu.sendMenuStateUpdate(entity, 2, "WidthAndDepth", this.getValue(), false);
			}
		};
		this.addRenderableWidget(WidthAndDepth);
		if (!menuStateUpdateActive)
			menu.sendMenuStateUpdate(entity, 2, "WidthAndDepth", WidthAndDepth.getValue(), false);
		altezza = new ExtendedSlider(this.leftPos + 9, this.topPos + 54, 125, 20, Component.translatable("gui.utility.gui_omni_wand_d_istruzione.altezza_prefix"), Component.translatable("gui.utility.gui_omni_wand_d_istruzione.altezza_suffix"), 1, 99,
				5, 1, 0, true) {
			@Override
			protected void applyValue() {
				if (!menuStateUpdateActive)
					menu.sendMenuStateUpdate(entity, 2, "altezza", this.getValue(), false);
			}
		};
		this.addRenderableWidget(altezza);
		if (!menuStateUpdateActive)
			menu.sendMenuStateUpdate(entity, 2, "altezza", altezza.getValue(), false);
	}
}