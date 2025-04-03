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
import net.imnowa.noe.block.PianoBlock;
import net.imnowa.noe.block.GouvernailBlock;
import net.imnowa.noe.block.CoussinBlock;
import net.imnowa.noe.block.BoiteBijouxBlock;
import net.imnowa.noe.NoeMod;

public class NoeModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, NoeMod.MODID);
	public static final RegistryObject<Block> PIANO = REGISTRY.register("piano", () -> new PianoBlock());
	public static final RegistryObject<Block> BOITE_BIJOUX = REGISTRY.register("boite_bijoux", () -> new BoiteBijouxBlock());
	public static final RegistryObject<Block> COUSSIN = REGISTRY.register("coussin", () -> new CoussinBlock());
	public static final RegistryObject<Block> THEIERE = REGISTRY.register("theiere", () -> new TheiereBlock());
	public static final RegistryObject<Block> GOUVERNAIL = REGISTRY.register("gouvernail", () -> new GouvernailBlock());

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
		}
	}
}
