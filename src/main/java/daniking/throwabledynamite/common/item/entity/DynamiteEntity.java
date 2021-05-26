package daniking.throwabledynamite.common.item.entity;

import daniking.throwabledynamite.common.ThrowableDynamite;
import daniking.throwabledynamite.common.registry.TDEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

/**
 * Base class for dynamite entities
 */

public class DynamiteEntity extends DynamiteEntityBase {

    public DynamiteEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public DynamiteEntity(World world, LivingEntity owner) {
        super(TDEntityType.THROWABLE_DYNAMITE_ENTITY_TYPE, world, owner);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {

        if (!world.isClient) {
             world.createExplosion(this, getX(), getY(), getZ(), ThrowableDynamite.config.dynamitePower, Explosion.DestructionType.BREAK);
             this.remove();
        }

        for(int i = 0; i < 16; ++i) {
            this.world.addParticle(new ItemStackParticleEffect(ParticleTypes.ITEM, getDefaultItem().getDefaultStack()), this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D);
        }
    }
}
