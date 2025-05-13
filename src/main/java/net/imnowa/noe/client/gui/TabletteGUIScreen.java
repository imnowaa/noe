package net.imnowa.noe.client.gui;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.imnowa.noe.world.inventory.TabletteGUIMenu;
import net.imnowa.noe.network.TabletteGUIButtonMessage;
import net.imnowa.noe.NoeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

public class TabletteGUIScreen extends ContainerScreen<TabletteGUIMenu> {
	private final static HashMap<String, Object> guistate = TabletteGUIMenu.guistate;
	private final World world;
	private final int x, y, z;
	private final PlayerEntity entity;
	ImageButton imagebutton_bouton_blocnote;
	ImageButton imagebutton_bouton_blocnote1;
	ImageButton imagebutton_bouton_onoff_bon;

	public TabletteGUIScreen(TabletteGUIMenu container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 200;
		this.ySize = 140;
	}

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("noe:textures/screens/tablette_allume.png"));
		this.blit(ms, this.guiLeft + -140, this.guiTop + -55, 0, 0, 374, 225, 374, 225);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack poseStack, int mouseX, int mouseY) {
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		imagebutton_bouton_blocnote = new ImageButton(this.guiLeft + 109, this.guiTop + 36, 48, 44, 0, 0, 44, new ResourceLocation("noe:textures/screens/atlas/imagebutton_bouton_blocnote.png"), 48, 88, e -> {
			if (true) {
				NoeMod.PACKET_HANDLER.sendToServer(new TabletteGUIButtonMessage(0, x, y, z));
				TabletteGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_bouton_blocnote", imagebutton_bouton_blocnote);
		this.addButton(imagebutton_bouton_blocnote);
		imagebutton_bouton_blocnote1 = new ImageButton(this.guiLeft + 37, this.guiTop + 38, 47, 42, 0, 0, 42, new ResourceLocation("noe:textures/screens/atlas/imagebutton_bouton_blocnote1.png"), 47, 84, e -> {
			if (true) {
				NoeMod.PACKET_HANDLER.sendToServer(new TabletteGUIButtonMessage(1, x, y, z));
				TabletteGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_bouton_blocnote1", imagebutton_bouton_blocnote1);
		this.addButton(imagebutton_bouton_blocnote1);
		imagebutton_bouton_onoff_bon = new ImageButton(this.guiLeft + 3, this.guiTop + -4, 19, 21, 0, 0, 21, new ResourceLocation("noe:textures/screens/atlas/imagebutton_bouton_onoff_bon.png"), 19, 42, e -> {
			if (true) {
				NoeMod.PACKET_HANDLER.sendToServer(new TabletteGUIButtonMessage(2, x, y, z));
				TabletteGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_bouton_onoff_bon", imagebutton_bouton_onoff_bon);
		this.addButton(imagebutton_bouton_onoff_bon);
	}
}
