package net.imnowa.noe.entity;

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

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;

import net.minecraft.world.World;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ActionResultType;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.IPacket;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;

import net.imnowa.noe.init.NoeModEntities;

public class DeerfoxadoEntity extends MonsterEntity implements IAnimatable {
	public static final DataParameter<Boolean> SHOOT = EntityDataManager.createKey(DeerfoxadoEntity.class, DataSerializers.BOOLEAN);
	public static final DataParameter<String> ANIMATION = EntityDataManager.createKey(DeerfoxadoEntity.class, DataSerializers.STRING);
	public static final DataParameter<String> TEXTURE = EntityDataManager.createKey(DeerfoxadoEntity.class, DataSerializers.STRING);
	private final AnimationFactory cache = GeckoLibUtil.createFactory(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public DeerfoxadoEntity(FMLPlayMessages.SpawnEntity packet, World world) {
		this(NoeModEntities.DEERFOXADO.get(), world);
	}

	public DeerfoxadoEntity(EntityType<DeerfoxadoEntity> type, World world) {
		super(type, world);
		stepHeight = 0.6f;
		experienceValue = 0;
		setNoAI(false);
		enablePersistence();
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerData() {
		super.registerData();
		this.dataManager.register(SHOOT, false);
		this.dataManager.register(ANIMATION, "undefined");
		this.dataManager.register(TEXTURE, "texture_deerfox");
	}

	public void setTexture(String texture) {
		this.dataManager.set(TEXTURE, texture);
	}

	public String getTexture() {
		return this.dataManager.get(TEXTURE);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1));
		this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(6, new SwimGoal(this));
	}

	@Override
	public CreatureAttribute getCreatureAttribute() {
		return CreatureAttribute.UNDEFINED;
	}

	@Override
	public boolean canDespawn(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putString("Texture", this.getTexture());
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		if (compound.contains("Texture"))
			this.setTexture(compound.getString("Texture"));
	}

	@Override
	public ActionResultType func_230254_b_(PlayerEntity sourceentity, Hand hand) {
		ItemStack itemstack = sourceentity.getHeldItem(hand);
		ActionResultType retval = ActionResultType.func_233537_a_(this.world.isRemote());
		super.func_230254_b_(sourceentity, hand);
		sourceentity.startRiding(this);
		return retval;
	}

	@Override
	public void travel(Vector3d dir) {
		Entity entity = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
		if (this.isBeingRidden()) {
			this.rotationYaw = entity.rotationYaw;
			this.prevRotationYaw = this.rotationYaw;
			this.rotationPitch = entity.rotationPitch * 0.5F;
			this.setRotation(this.rotationYaw, this.rotationPitch);
			this.jumpMovementFactor = this.getAIMoveSpeed() * 0.15F;
			this.renderYawOffset = entity.rotationYaw;
			this.rotationYawHead = entity.rotationYaw;
			if (entity instanceof LivingEntity) {
				this.setAIMoveSpeed((float) this.getAttributeValue(Attributes.MOVEMENT_SPEED));
				float forward = ((LivingEntity) entity).moveForward;
				float strafe = ((LivingEntity) entity).moveStrafing;
				super.travel(new Vector3d(strafe, 0, forward));
			}
			this.prevLimbSwingAmount = this.limbSwingAmount;
			double d1 = this.getPosX() - this.prevPosX;
			double d0 = this.getPosZ() - this.prevPosZ;
			float f1 = (float) MathHelper.sqrt(d1 * d1 + d0 * d0) * 4;
			if (f1 > 1.0F)
				f1 = 1.0F;
			this.limbSwingAmount += (f1 - this.limbSwingAmount) * 0.4F;
			this.limbSwing += this.limbSwingAmount;
			return;
		}
		this.jumpMovementFactor = 0.02F;
		super.travel(dir);
	}

	public static void init() {
	}

	public static AttributeModifierMap.MutableAttribute createAttributes() {
		AttributeModifierMap.MutableAttribute builder = MobEntity.func_233666_p_();
		builder = builder.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.createMutableAttribute(Attributes.MAX_HEALTH, 15);
		builder = builder.createMutableAttribute(Attributes.ARMOR, 0);
		builder = builder.createMutableAttribute(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.createMutableAttribute(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}

	private <E extends IAnimatable> PlayState movementPredicate(AnimationEvent<E> event) {
		if (this.animationprocedure.equals("empty")) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.model.idle", EDefaultLoopTypes.LOOP));
			return PlayState.CONTINUE;
		}
		return PlayState.STOP;
	}

	String prevAnim = "empty";

	private <E extends IAnimatable> PlayState procedurePredicate(AnimationEvent<E> event) {
		if (!animationprocedure.equals("empty") && event.getController().getAnimationState() == AnimationState.Stopped || (!this.animationprocedure.equals(prevAnim) && !this.animationprocedure.equals("empty"))) {
			if (!this.animationprocedure.equals(prevAnim))
				event.getController().markNeedsReload();
			event.getController().setAnimation(new AnimationBuilder().addAnimation(this.animationprocedure, EDefaultLoopTypes.PLAY_ONCE));
			if (event.getController().getAnimationState() == AnimationState.Stopped) {
				this.animationprocedure = "empty";
				event.getController().markNeedsReload();
			}
		} else if (animationprocedure.equals("empty")) {
			prevAnim = "empty";
			return PlayState.STOP;
		}
		prevAnim = this.animationprocedure;
		return PlayState.CONTINUE;
	}

	@Override
	protected void onDeathUpdate() {
		++this.deathTime;
		if (this.deathTime == 20) {
			this.remove(true);
			this.dropExperience();
		}
	}

	public String getSyncedAnimation() {
		return this.dataManager.get(ANIMATION);
	}

	public void setAnimation(String animation) {
		this.dataManager.set(ANIMATION, animation);
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<>(this, "movement", 4, this::movementPredicate));
		data.addAnimationController(new AnimationController<>(this, "procedure", 4, this::procedurePredicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.cache;
	}
}
