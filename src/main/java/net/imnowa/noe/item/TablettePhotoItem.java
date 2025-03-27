
package net.imnowa.noe.item;

import software.bernie.geckolib3.util.GeckoLibUtil;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.builder.ILoopType.EDefaultLoopTypes;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.AnimationState;

import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.ActionResult;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.item.ItemGroup;
import net.minecraft.client.util.ITooltipFlag;

import net.imnowa.noe.procedures.TablettePhotoRCProcedure;
import net.imnowa.noe.item.renderer.TablettePhotoItemRenderer;
import net.imnowa.noe.init.NoeModTabs;

import java.util.concurrent.Callable;

public class TablettePhotoItem extends Item implements IAnimatable {
	private final AnimationFactory cache = GeckoLibUtil.createFactory(this);
	public String animationprocedure = "empty";

	public TablettePhotoItem() {
		super(new Item.Properties().setISTER(() -> new Callable() {
			private final TablettePhotoItemRenderer renderer = new TablettePhotoItemRenderer();

			@Override
			public TablettePhotoItemRenderer call() throws Exception {
				return this.renderer;
			}
		}).group(NoeModTabs.TAB_NOE_AUTRES).maxStackSize(1).rarity(Rarity.UNCOMMON));
	}

	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return false;
	}

	private <E extends IAnimatable> PlayState idlePredicate(AnimationEvent<E> event) {
		if (this.animationprocedure.equals("empty")) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.tablette.idle", EDefaultLoopTypes.LOOP));
			return PlayState.CONTINUE;
		}
		return PlayState.STOP;
	}

	String prevAnim = "empty";

	private <E extends IAnimatable> PlayState procedurePredicate(AnimationEvent<E> event) {
		if (!this.animationprocedure.equals("empty") && event.getController().getAnimationState() == AnimationState.Stopped || (!this.animationprocedure.equals(prevAnim) && !this.animationprocedure.equals("empty"))) {
			if (!this.animationprocedure.equals(prevAnim))
				event.getController().markNeedsReload();
			event.getController().setAnimation(new AnimationBuilder().addAnimation(this.animationprocedure, EDefaultLoopTypes.PLAY_ONCE));
			if (event.getController().getAnimationState() == AnimationState.Stopped) {
				this.animationprocedure = "empty";
				event.getController().markNeedsReload();
			}
		} else if (this.animationprocedure.equals("empty")) {
			prevAnim = "empty";
			return PlayState.STOP;
		}
		prevAnim = this.animationprocedure;
		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimationData data) {
		AnimationController procedureController = new AnimationController<>(this, "procedureController", 0, this::procedurePredicate);
		data.addAnimationController(procedureController);
		AnimationController idleController = new AnimationController<>(this, "idleController", 0, this::idlePredicate);
		data.addAnimationController(idleController);
	}

	@Override
	public AnimationFactory getFactory() {
		return this.cache;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
		ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
		TablettePhotoRCProcedure.execute(entity);
		return ar;
	}

	@Override
	public ActionResultType onItemUseFirst(ItemStack itemstack, ItemUseContext context) {
		super.onItemUseFirst(itemstack, context);
		TablettePhotoRCProcedure.execute(context.getPlayer());
		return ActionResultType.SUCCESS;
	}

	@Override
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, flag);
        
        if (stack.hasTag()) {
            CompoundNBT tag = stack.getTag();
            if (tag != null && tag.contains("Notes", 8)) {
                String note = tag.getString("Notes");
                if (note.isEmpty()) {
                    tooltip.add(new StringTextComponent("La tablette n'a pas de notes.").mergeStyle(TextFormatting.RED));
                } else {
                    tooltip.add(new StringTextComponent("Notes :").mergeStyle(TextFormatting.GRAY));
                    tooltip.add(new StringTextComponent(note).mergeStyle(TextFormatting.AQUA));
                }
            } else {
                tooltip.add(new StringTextComponent("La tablette n'a pas de notes.").mergeStyle(TextFormatting.RED));
            }
        } else {
            tooltip.add(new StringTextComponent("La tablette n'a pas de notes.").mergeStyle(TextFormatting.RED));
        }
    }
}
