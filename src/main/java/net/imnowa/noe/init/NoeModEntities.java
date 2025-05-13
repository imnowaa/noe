/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.imnowa.noe.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;

import net.imnowa.noe.entity.SlimycatEntity;
import net.imnowa.noe.entity.RokoNoirEntity;
import net.imnowa.noe.entity.RokoMarronEntity;
import net.imnowa.noe.entity.LanternevolanteEntity;
import net.imnowa.noe.entity.DeerAdoEntity;
import net.imnowa.noe.NoeMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NoeModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, NoeMod.MODID);
	public static final RegistryObject<EntityType<LanternevolanteEntity>> LANTERNEVOLANTE = register("lanternevolante",
			EntityType.Builder.<LanternevolanteEntity>create(LanternevolanteEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LanternevolanteEntity::new)

					.size(0.6f, 0.7f));
	public static final RegistryObject<EntityType<DeerAdoEntity>> DEER_ADO = register("deer_ado",
			EntityType.Builder.<DeerAdoEntity>create(DeerAdoEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DeerAdoEntity::new)

					.size(0.8f, 1.5f));
	public static final RegistryObject<EntityType<SlimycatEntity>> SLIMYCAT = register("slimycat",
			EntityType.Builder.<SlimycatEntity>create(SlimycatEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SlimycatEntity::new)

					.size(0.5f, 0.5f));
	public static final RegistryObject<EntityType<RokoMarronEntity>> ROKO_MARRON = register("roko_marron",
			EntityType.Builder.<RokoMarronEntity>create(RokoMarronEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RokoMarronEntity::new)

					.size(1.8f, 3.5f));
	public static final RegistryObject<EntityType<RokoNoirEntity>> ROKO_NOIR = register("roko_noir",
			EntityType.Builder.<RokoNoirEntity>create(RokoNoirEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RokoNoirEntity::new)

					.size(1.8f, 3.5f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			LanternevolanteEntity.init();
			DeerAdoEntity.init();
			SlimycatEntity.init();
			RokoMarronEntity.init();
			RokoNoirEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(LANTERNEVOLANTE.get(), LanternevolanteEntity.createAttributes().create());
		event.put(DEER_ADO.get(), DeerAdoEntity.createAttributes().create());
		event.put(SLIMYCAT.get(), SlimycatEntity.createAttributes().create());
		event.put(ROKO_MARRON.get(), RokoMarronEntity.createAttributes().create());
		event.put(ROKO_NOIR.get(), RokoNoirEntity.createAttributes().create());
	}
}
