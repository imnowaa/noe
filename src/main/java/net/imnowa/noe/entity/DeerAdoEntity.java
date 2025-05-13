package net.imnowa.noe.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.World;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ActionResultType;
import net.minecraft.network.IPacket;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;

import net.imnowa.noe.init.NoeModEntities;

@Mod.EventBusSubscriber
public class DeerAdoEntity extends MonsterEntity {
	@SubscribeEvent
	public static void addLivingEntityToBiomes(BiomeLoadingEvent event) {
		event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(NoeModEntities.DEER_ADO.get(), 20, 4, 4));
	}

	public DeerAdoEntity(FMLPlayMessages.SpawnEntity packet, World world) {
		this(NoeModEntities.DEER_ADO.get(), world);
	}

	public DeerAdoEntity(EntityType<DeerAdoEntity> type, World world) {
		super(type, world);
		stepHeight = 1f;
		experienceValue = 0;
		setNoAI(false);
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.attacker.getWidth() * this.attacker.getWidth() + entity.getWidth();
			}
		});
		this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1));
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(5, new SwimGoal(this));
	}

	@Override
	public CreatureAttribute getCreatureAttribute() {
		return CreatureAttribute.UNDEFINED;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
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
		EntitySpawnPlacementRegistry.register(NoeModEntities.DEER_ADO.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawn);
	}

	public static AttributeModifierMap.MutableAttribute createAttributes() {
		AttributeModifierMap.MutableAttribute builder = MobEntity.func_233666_p_();
		builder = builder.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.2);
		builder = builder.createMutableAttribute(Attributes.MAX_HEALTH, 10);
		builder = builder.createMutableAttribute(Attributes.ARMOR, 0);
		builder = builder.createMutableAttribute(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.createMutableAttribute(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}
}
