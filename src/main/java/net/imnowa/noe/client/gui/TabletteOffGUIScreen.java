package net.imnowa.noe.client.gui;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.imnowa.noe.world.inventory.TabletteOffGUIMenu;
import net.imnowa.noe.network.TabletteOffGUIButtonMessage;
import net.imnowa.noe.NoeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

public class TabletteOffGUIScreen extends ContainerScreen<TabletteOffGUIMenu> {
	private final static HashMap<String, Object> guistate = TabletteOffGUIMenu.guistate;
	private final World world;
	private final int x, y, z;
	private final PlayerEntity entity;
	ImageButton imagebutton_bouton_onoff_bon;

	public TabletteOffGUIScreen(TabletteOffGUIMenu container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 173;
		this.ySize = 148;
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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("noe:textures/screens/tablette_eteinte.png"));
		this.blit(ms, this.guiLeft + -153, this.guiTop + -51, 0, 0, 374, 225, 374, 225);

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
		imagebutton_bouton_onoff_bon = new ImageButton(this.guiLeft + -10, this.guiTop + 0, 19, 21, 0, 0, 21, new ResourceLocation("noe:textures/screens/atlas/imagebutton_bouton_onoff_bon.png"), 19, 42, e -> {
			if (true) {
				NoeMod.PACKET_HANDLER.sendToServer(new TabletteOffGUIButtonMessage(0, x, y, z));
				TabletteOffGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_bouton_onoff_bon", imagebutton_bouton_onoff_bon);
		this.addButton(imagebutton_bouton_onoff_bon);
	}
}
