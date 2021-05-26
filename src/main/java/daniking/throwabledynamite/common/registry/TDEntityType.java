package daniking.throwabledynamite.common.registry;

import daniking.throwabledynamite.common.ThrowableDynamite;
import daniking.throwabledynamite.common.item.entity.DynamiteEntityBase;
import daniking.throwabledynamite.common.item.entity.DynamiteEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;

public class TDEntityType {

    public static final EntityType<DynamiteEntityBase>THROWABLE_DYNAMITE_ENTITY_TYPE = Registry.register(Registry.ENTITY_TYPE, ThrowableDynamite.ModIdentifier("throwable_dynamite"), FabricEntityTypeBuilder.<DynamiteEntityBase>create(SpawnGroup.MISC, DynamiteEntity::new).dimensions(EntityDimensions.fixed(0.25F,0.25F)).trackRangeBlocks(4).trackedUpdateRate(10).build());

}
