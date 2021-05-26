package daniking.throwabledynamite.client;

import daniking.throwabledynamite.common.registry.TDEntityType;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class ThrowableDynamiteClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(TDEntityType.THROWABLE_DYNAMITE_ENTITY_TYPE, (dispatcher, context) -> new FlyingItemEntityRenderer<>(dispatcher, context.getItemRenderer()));
        TDEntityPacketClient.receiveEntityPacket();
    }

}
