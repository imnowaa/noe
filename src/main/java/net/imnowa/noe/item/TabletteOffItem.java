
package net.imnowa.noe.item;

import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.ActionResult;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;

import net.imnowa.noe.procedures.OpenTabOffProcedure;
import net.imnowa.noe.init.NoeModTabs;

public class TabletteOffItem extends Item {
	public TabletteOffItem() {
		super(new Item.Properties().group(NoeModTabs.TAB_NOE_AUTRES).maxStackSize(1).rarity(Rarity.UNCOMMON));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
	    ItemStack stack = entity.getHeldItem(hand);
	    
	    if (!world.isRemote) { // Côté serveur
	        ensurePersistentNBT(stack);
	    }
	
	    OpenTabOffProcedure.execute(world, entity.getPosX(), entity.getPosY(), entity.getPosZ(), entity);
	    
	    return super.onItemRightClick(world, entity, hand);
	}


	private void ensurePersistentNBT(ItemStack stack) {
	    if (!stack.hasTag()) {
	        stack.setTag(new CompoundNBT());
	    }
	
	    CompoundNBT tag = stack.getTag();
	    if (tag != null && !tag.contains("Notes")) {
	        tag.putString("Notes", ""); // Assure un stockage persistant des notes
	    }
	}

	@Override
	public boolean canContinueUsing(ItemStack oldStack, ItemStack newStack) {
	    if (oldStack.getItem() == newStack.getItem()) {
	        ensurePersistentNBT(newStack); // Empêche la réinitialisation des données
	        return true;
	    }
	    return super.canContinueUsing(oldStack, newStack);
	}


	@Override
	public ActionResultType onItemUseFirst(ItemStack itemstack, ItemUseContext context) {
		super.onItemUseFirst(itemstack, context);
		OpenTabOffProcedure.execute(context.getWorld(), context.getPos().getX(), context.getPos().getY(), context.getPos().getZ(), context.getPlayer());
		return ActionResultType.SUCCESS;
	}
}
