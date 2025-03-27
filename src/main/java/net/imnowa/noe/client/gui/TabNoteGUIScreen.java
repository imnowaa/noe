package net.imnowa.noe.client.gui;

import net.minecraft.world.World;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.imnowa.noe.world.inventory.TabNoteGUIMenu;
import net.imnowa.noe.network.TabNoteGUIButtonMessage;
import net.imnowa.noe.NoeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

public class TabNoteGUIScreen extends ContainerScreen<TabNoteGUIMenu> {
	private final static HashMap<String, Object> guistate = TabNoteGUIMenu.guistate;
	private final World world;
	private final int x, y, z;
	private final PlayerEntity entity;
	TextFieldWidget Notes;
	ImageButton imagebutton_bouton_valide;
	ImageButton imagebutton_bouton_retour;

	public TabNoteGUIScreen(TabNoteGUIMenu container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 153;
	}

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		Notes.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("noe:textures/screens/tablette_allume.png"));
		this.blit(ms, this.guiLeft + -152, this.guiTop + -49, 0, 0, 374, 225, 374, 225);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		if (Notes.isFocused())
			return Notes.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		Notes.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String NotesValue = Notes.getText();
		super.resize(minecraft, width, height);
		Notes.setText(NotesValue);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack poseStack, int mouseX, int mouseY) {
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		Notes = new TextFieldWidget(this.font, this.guiLeft + -6, this.guiTop + 56, 179, 18, new TranslationTextComponent("gui.noe.tab_note_gui.Notes"));
		Notes.setMaxStringLength(32767);
		guistate.put("text:Notes", Notes);
		this.children.add(this.Notes);
		imagebutton_bouton_valide = new ImageButton(this.guiLeft + 97, this.guiTop + 81, 33, 31, 0, 0, 31, new ResourceLocation("noe:textures/screens/atlas/imagebutton_bouton_valide.png"), 33, 62, e -> {
			if (true) {
				NoeMod.PACKET_HANDLER.sendToServer(new TabNoteGUIButtonMessage(0, x, y, z));
				TabNoteGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_bouton_valide", imagebutton_bouton_valide);
		this.addButton(imagebutton_bouton_valide);
		imagebutton_bouton_retour = new ImageButton(this.guiLeft + 42, this.guiTop + 81, 33, 31, 0, 0, 31, new ResourceLocation("noe:textures/screens/atlas/imagebutton_bouton_retour.png"), 33, 62, e -> {
			if (true) {
				NoeMod.PACKET_HANDLER.sendToServer(new TabNoteGUIButtonMessage(1, x, y, z));
				TabNoteGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_bouton_retour", imagebutton_bouton_retour);
		this.addButton(imagebutton_bouton_retour);
	}
}
