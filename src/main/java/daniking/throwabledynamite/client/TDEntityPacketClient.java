package daniking.throwabledynamite.client;

import daniking.throwabledynamite.common.ThrowableDynamite;
import daniking.throwabledynamite.common.network.TDEntitySpawnPacket;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;

import java.util.UUID;

public class TDEntityPacketClient {

    public static final Identifier PacketID = new Identifier(ThrowableDynamite.MODID, "spawn_packet");


    public static void receiveEntityPacket() {
        ClientSidePacketRegistry.INSTANCE.register(PacketID, (ctx, byteBuf) -> { EntityType<?> et = Registry.ENTITY_TYPE.get(byteBuf.readVarInt());

            UUID uuid = byteBuf.readUuid();
            int entityId = byteBuf.readVarInt();
            Vec3d pos = TDEntitySpawnPacket.PacketBufUtil.readVec3d(byteBuf);
            float pitch = TDEntitySpawnPacket.PacketBufUtil.readAngle(byteBuf);
            float yaw = TDEntitySpawnPacket.PacketBufUtil.readAngle(byteBuf);

            ctx.getTaskQueue().execute(() -> {

                if (MinecraftClient.getInstance().world == null) {
                    throw new IllegalStateException("Tried to spawn entity in a null world!");
                }

                Entity entity = et.create(MinecraftClient.getInstance().world);

                if (entity == null) {
                    throw new IllegalStateException("Failed to create instance of entity \"" + Registry.ENTITY_TYPE.getId(et) + "\"!");
                }

                entity.updateTrackedPosition(pos);
                entity.setPos(pos.x, pos.y, pos.z);
                entity.pitch = pitch;
                entity.yaw = yaw;
                entity.setEntityId(entityId);
                entity.setUuid(uuid);
                MinecraftClient.getInstance().world.addEntity(entityId, entity);
            });
        });
    }
}
