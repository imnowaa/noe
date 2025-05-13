/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.imnowa.noe.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.RegistryObject;

import net.minecraft.util.SoundEvent;
import net.minecraft.util.ResourceLocation;

import net.imnowa.noe.NoeMod;

public class NoeModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, NoeMod.MODID);
	public static final RegistryObject<SoundEvent> POWERUP = REGISTRY.register("powerup", () -> new SoundEvent(new ResourceLocation("noe", "powerup")));
	public static final RegistryObject<SoundEvent> TYPING = REGISTRY.register("typing", () -> new SoundEvent(new ResourceLocation("noe", "typing")));
	public static final RegistryObject<SoundEvent> INFILTRATION = REGISTRY.register("infiltration", () -> new SoundEvent(new ResourceLocation("noe", "infiltration")));
	public static final RegistryObject<SoundEvent> MACHINEAECRIRE = REGISTRY.register("machineaecrire", () -> new SoundEvent(new ResourceLocation("noe", "machineaecrire")));
	public static final RegistryObject<SoundEvent> PUNCHBAG = REGISTRY.register("punchbag", () -> new SoundEvent(new ResourceLocation("noe", "punchbag")));
}
