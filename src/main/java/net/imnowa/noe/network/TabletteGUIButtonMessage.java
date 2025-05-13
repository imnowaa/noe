package net.imnowa.noe.network;

import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.PacketBuffer;
import net.minecraft.entity.player.PlayerEntity;

import net.imnowa.noe.world.inventory.TabletteGUIMenu;
import net.imnowa.noe.procedures.TabToBlocNoteProcedure;
import net.imnowa.noe.procedures.TabOnToOffProcedure;
import net.imnowa.noe.procedures.GoPhotoModeProcedure;
import net.imnowa.noe.NoeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TabletteGUIButtonMessage {
	private final int buttonID, x, y, z;

	public TabletteGUIButtonMessage(PacketBuffer buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public TabletteGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(TabletteGUIButtonMessage message, PacketBuffer buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(TabletteGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			PlayerEntity entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(PlayerEntity entity, int buttonID, int x, int y, int z) {
		World world = entity.world;
		HashMap guistate = TabletteGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			TabToBlocNoteProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			GoPhotoModeProcedure.execute(entity);
		}
		if (buttonID == 2) {

			TabOnToOffProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		NoeMod.addNetworkMessage(TabletteGUIButtonMessage.class, TabletteGUIButtonMessage::buffer, TabletteGUIButtonMessage::new, TabletteGUIButtonMessage::handler);
	}
}
