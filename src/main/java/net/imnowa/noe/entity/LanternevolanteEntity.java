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
import net.minecraft.world.IServerWorld;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.IPacket;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.block.BlockState;

import net.imnowa.noe.procedures.NbtLanterneProcedure;
import net.imnowa.noe.procedures.MobmonteeconstanteProcedure;
import net.imnowa.noe.init.NoeModEntities;

import javax.annotation.Nullable;

public class LanternevolanteEntity extends MonsterEntity implements IAnimatable {
	public static final DataParameter<Boolean> SHOOT = EntityDataManager.createKey(LanternevolanteEntity.class, DataSerializers.BOOLEAN);
	public static final DataParameter<String> ANIMATION = EntityDataManager.createKey(LanternevolanteEntity.class, DataSerializers.STRING);
	public static final DataParameter<String> TEXTURE = EntityDataManager.createKey(LanternevolanteEntity.class, DataSerializers.STRING);
	private final AnimationFactory cache = GeckoLibUtil.createFactory(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public LanternevolanteEntity(FMLPlayMessages.SpawnEntity packet, World world) {
		this(NoeModEntities.LANTERNEVOLANTE.get(), world);
	}

	public LanternevolanteEntity(EntityType<LanternevolanteEntity> type, World world) {
		super(type, world);
		stepHeight = 0.6f;
		experienceValue = 0;
		setNoAI(false);
		this.moveController = new FlyingMovementController(this, 10, true);
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
		this.dataManager.register(TEXTURE, "texture_lanterne");
	}

	public void setTexture(String texture) {
		this.dataManager.set(TEXTURE, texture);
	}

	public String getTexture() {
		return this.dataManager.get(TEXTURE);
	}

	@Override
	protected PathNavigator createNavigator(World world) {
		return new FlyingPathNavigator(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new SwimGoal(this));
		this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, (float) 0.5));
	}

	@Override
	public CreatureAttribute getCreatureAttribute() {
		return CreatureAttribute.UNDEFINED;
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
	public boolean onLivingFall(float l, float d) {
		return false;
	}

	@Override
	public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData livingdata, @Nullable CompoundNBT tag) {
		ILivingEntityData retval = super.onInitialSpawn(world, difficulty, reason, livingdata, tag);
		NbtLanterneProcedure.execute(this);
		return retval;
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
	public void baseTick() {
		super.baseTick();
		MobmonteeconstanteProcedure.execute(this.world, this);
	}

	@Override
	protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}

	@Override
	public void setNoGravity(boolean ignored) {
		super.setNoGravity(true);
	}

	public void livingTick() {
		super.livingTick();
		this.setNoGravity(true);
	}

	public static void init() {
	}

	public static AttributeModifierMap.MutableAttribute createAttributes() {
		AttributeModifierMap.MutableAttribute builder = MobEntity.func_233666_p_();
		builder = builder.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0);
		builder = builder.createMutableAttribute(Attributes.MAX_HEALTH, 2);
		builder = builder.createMutableAttribute(Attributes.ARMOR, 0);
		builder = builder.createMutableAttribute(Attributes.ATTACK_DAMAGE, 0);
		builder = builder.createMutableAttribute(Attributes.FOLLOW_RANGE, 0);
		builder = builder.createMutableAttribute(Attributes.FLYING_SPEED, 0);
		return builder;
	}

	private <E extends IAnimatable> PlayState movementPredicate(AnimationEvent<E> event) {
		if (this.animationprocedure.equals("empty")) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", EDefaultLoopTypes.LOOP));
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
