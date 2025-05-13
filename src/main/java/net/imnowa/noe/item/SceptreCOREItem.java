
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

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.block.BlockState;

import net.imnowa.noe.item.renderer.SceptreCOREItemRenderer;
import net.imnowa.noe.init.NoeModTabs;

import java.util.concurrent.Callable;

import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap;

public class SceptreCOREItem extends Item implements IAnimatable {
	private final AnimationFactory cache = GeckoLibUtil.createFactory(this);
	public String animationprocedure = "empty";

	public SceptreCOREItem() {
		super(new Item.Properties().setISTER(() -> new Callable() {
			private final SceptreCOREItemRenderer renderer = new SceptreCOREItemRenderer();

			@Override
			public SceptreCOREItemRenderer call() throws Exception {
				return this.renderer;
			}
		}).group(NoeModTabs.TAB_NOE_AUTRES).maxStackSize(64).isImmuneToFire().rarity(Rarity.EPIC));
	}

	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return false;
	}

	private <E extends IAnimatable> PlayState idlePredicate(AnimationEvent<E> event) {
		if (this.animationprocedure.equals("empty")) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.sceptre_core.idle", EDefaultLoopTypes.LOOP));
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
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
		if (equipmentSlot == EquipmentSlotType.MAINHAND) {
			ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
			builder.putAll(super.getAttributeModifiers(equipmentSlot));
			builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Item modifier", 11d, AttributeModifier.Operation.ADDITION));
			builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(ATTACK_SPEED_MODIFIER, "Item modifier", -2.4, AttributeModifier.Operation.ADDITION));
			return builder.build();
		}
		return super.getAttributeModifiers(equipmentSlot);
	}

	@Override
	public boolean canHarvestBlock(BlockState state) {
		return true;
	}
}
