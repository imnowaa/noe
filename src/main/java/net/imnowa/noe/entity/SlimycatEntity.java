package net.imnowa.noe.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;

import net.minecraft.world.World;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.CreatureAttribute;

import net.imnowa.noe.init.NoeModEntities;

public class SlimycatEntity extends MonsterEntity {
	public SlimycatEntity(FMLPlayMessages.SpawnEntity packet, World world) {
		this(NoeModEntities.SLIMYCAT.get(), world);
	}

	public SlimycatEntity(EntityType<SlimycatEntity> type, World world) {
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
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1));
		this.goalSelector.addGoal(2, new PanicGoal(this, 1.2));
		this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(4, new SwimGoal(this));
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
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}

	public static void init() {
	}

	public static AttributeModifierMap.MutableAttribute createAttributes() {
		AttributeModifierMap.MutableAttribute builder = MobEntity.func_233666_p_();
		builder = builder.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.createMutableAttribute(Attributes.MAX_HEALTH, 10);
		builder = builder.createMutableAttribute(Attributes.ARMOR, 0);
		builder = builder.createMutableAttribute(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.createMutableAttribute(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}
}
