package daniking.throwabledynamite.common.item.entity;

import daniking.throwabledynamite.client.TDEntityPacketClient;
import daniking.throwabledynamite.common.network.TDEntitySpawnPacket;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.Packet;

import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

public abstract class DynamiteEntityBase extends ThrownItemEntity {

    public DynamiteEntityBase(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public DynamiteEntityBase(EntityType<? extends ThrownItemEntity> entityType, World world, LivingEntity owner) {
        super(entityType, owner, world);
    }

    @Override
    protected Item getDefaultItem() {
        return this.getItem().getItem();
    }

    @Override
    public Packet<?> createSpawnPacket() {
        return TDEntitySpawnPacket.create(this, TDEntityPacketClient.PacketID);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
    }
}
