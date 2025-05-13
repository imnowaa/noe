package net.imnowa.noe.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.state.Property;
import net.minecraft.state.BooleanProperty;
import net.minecraft.block.BlockState;

import net.imnowa.noe.NoeMod;

public class SonMachineAEcrireProcedure {
	public static void execute(IWorld world, double x, double y, double z, BlockState blockstate) {
		if ((blockstate.getBlock().getStateContainer().getProperty("wait") instanceof BooleanProperty ? blockstate.get((BooleanProperty) blockstate.getBlock().getStateContainer().getProperty("wait")) : false) == false) {
			{
				BlockPos _pos = new BlockPos(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				Property<?> _property = _bs.getBlock().getStateContainer().getProperty("wait");
				if (_property instanceof BooleanProperty)
					world.setBlockState(_pos, _bs.with((BooleanProperty) _property, true), 3);
			}
			if (world instanceof World) {
				if (!((World) world).isRemote()) {
					((World) world).playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("noe:machineaecrire")), SoundCategory.NEUTRAL, (float) 0.1, 1);
				} else {
					((World) world).playSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("noe:machineaecrire")), SoundCategory.NEUTRAL, (float) 0.1, 1, false);
				}
			}
			NoeMod.queueServerWork(100, () -> {
				{
					BlockPos _pos = new BlockPos(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					Property<?> _property = _bs.getBlock().getStateContainer().getProperty("wait");
					if (_property instanceof BooleanProperty)
						world.setBlockState(_pos, _bs.with((BooleanProperty) _property, false), 3);
				}
			});
		}
	}
}
