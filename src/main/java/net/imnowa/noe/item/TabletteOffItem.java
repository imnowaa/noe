
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

import net.imnowa.noe.procedures.OpenTabOffProcedure;
import net.imnowa.noe.init.NoeModTabs;

public class TabletteOffItem extends Item {
	public TabletteOffItem() {
		super(new Item.Properties().group(NoeModTabs.TAB_NOE_AUTRES).maxStackSize(1).rarity(Rarity.UNCOMMON));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
		ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
		OpenTabOffProcedure.execute(world, entity.getPosX(), entity.getPosY(), entity.getPosZ(), entity);
		return ar;
	}

	@Override
	public ActionResultType onItemUseFirst(ItemStack itemstack, ItemUseContext context) {
		super.onItemUseFirst(itemstack, context);
		OpenTabOffProcedure.execute(context.getWorld(), context.getPos().getX(), context.getPos().getY(), context.getPos().getZ(), context.getPlayer());
		return ActionResultType.SUCCESS;
	}
}
