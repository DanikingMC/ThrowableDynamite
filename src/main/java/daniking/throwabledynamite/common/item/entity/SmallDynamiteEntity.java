package daniking.throwabledynamite.common.item.entity;

import daniking.throwabledynamite.common.ThrowableDynamite;
import daniking.throwabledynamite.common.registry.TDEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class SmallDynamiteEntity extends DynamiteEntityBase {

    public SmallDynamiteEntity(World world, LivingEntity owner) {
        super(TDEntityType.THROWABLE_DYNAMITE_ENTITY_TYPE, world, owner);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {

        if (!world.isClient) {
            world.createExplosion(this, getX(), getY(), getZ(), ThrowableDynamite.config.small_dynamitePower, Explosion.DestructionType.BREAK);
            this.remove();
        }

        for (int i = 0; i < 16; ++i) {
            this.world.addParticle(new ItemStackParticleEffect(ParticleTypes.ITEM, getDefaultItem().getDefaultStack()), this.getX(), this.getY(), this.getZ(), ((double) this.random.nextFloat() - 0.5D) * 0.08D, ((double) this.random.nextFloat() - 0.5D) * 0.08D, ((double) this.random.nextFloat() - 0.5D) * 0.08D);
        }
    }
}

