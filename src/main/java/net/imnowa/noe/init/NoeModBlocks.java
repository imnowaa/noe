/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.imnowa.noe.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.block.Block;

import net.imnowa.noe.block.TheiereBlock;
import net.imnowa.noe.block.SacdeFrappeBlock;
import net.imnowa.noe.block.SacDeFrappeFuturBlock;
import net.imnowa.noe.block.PianoCharonBlock;
import net.imnowa.noe.block.PianoBlock;
import net.imnowa.noe.block.MachineaecrireBlock;
import net.imnowa.noe.block.GouvernailBlock;
import net.imnowa.noe.block.CoussinBlock;
import net.imnowa.noe.block.CamOnBlock;
import net.imnowa.noe.block.CamOffBlock;
import net.imnowa.noe.block.BoiteBijouxBlock;
import net.imnowa.noe.block.BarreTractionBlock;
import net.imnowa.noe.block.BancAbdoBlock;
import net.imnowa.noe.NoeMod;

public class NoeModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, NoeMod.MODID);
	public static final RegistryObject<Block> PIANO = REGISTRY.register("piano", () -> new PianoBlock());
	public static final RegistryObject<Block> BOITE_BIJOUX = REGISTRY.register("boite_bijoux", () -> new BoiteBijouxBlock());
	public static final RegistryObject<Block> COUSSIN = REGISTRY.register("coussin", () -> new CoussinBlock());
	public static final RegistryObject<Block> THEIERE = REGISTRY.register("theiere", () -> new TheiereBlock());
	public static final RegistryObject<Block> GOUVERNAIL = REGISTRY.register("gouvernail", () -> new GouvernailBlock());
	public static final RegistryObject<Block> MACHINEAECRIRE = REGISTRY.register("machineaecrire", () -> new MachineaecrireBlock());
	public static final RegistryObject<Block> PIANO_CHARON = REGISTRY.register("piano_charon", () -> new PianoCharonBlock());
	public static final RegistryObject<Block> SACDE_FRAPPE = REGISTRY.register("sacde_frappe", () -> new SacdeFrappeBlock());
	public static final RegistryObject<Block> SAC_DE_FRAPPE_FUTUR = REGISTRY.register("sac_de_frappe_futur", () -> new SacDeFrappeFuturBlock());
	public static final RegistryObject<Block> BARRE_TRACTION = REGISTRY.register("barre_traction", () -> new BarreTractionBlock());
	public static final RegistryObject<Block> BANC_ABDO = REGISTRY.register("banc_abdo", () -> new BancAbdoBlock());
	public static final RegistryObject<Block> CAM_OFF = REGISTRY.register("cam_off", () -> new CamOffBlock());
	public static final RegistryObject<Block> CAM_ON = REGISTRY.register("cam_on", () -> new CamOnBlock());

	// Start of user code block custom blocks
	// End of user code block custom blocks
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class BlocksClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			PianoBlock.registerRenderLayer();
			BoiteBijouxBlock.registerRenderLayer();
			CoussinBlock.registerRenderLayer();
			TheiereBlock.registerRenderLayer();
			GouvernailBlock.registerRenderLayer();
			MachineaecrireBlock.registerRenderLayer();
			PianoCharonBlock.registerRenderLayer();
			SacdeFrappeBlock.registerRenderLayer();
			SacDeFrappeFuturBlock.registerRenderLayer();
			BarreTractionBlock.registerRenderLayer();
			BancAbdoBlock.registerRenderLayer();
			CamOffBlock.registerRenderLayer();
			CamOnBlock.registerRenderLayer();
		}
	}
}
