package daniking.throwabledynamite.common.item;

import daniking.throwabledynamite.common.item.entity.DynamiteEntity;
import daniking.throwabledynamite.common.item.entity.SmallDynamiteEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

/**
 * Base class for dynamite items.
 */

public class ThrowableDynamiteBase extends Item {

    protected enum Type {DYNAMITE, SMALL_DYNAMITE}
    private final Type type;

    public ThrowableDynamiteBase(Settings settings, Type type) {
        super(settings);
        this.type = type;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        ItemStack currentStack = user.getStackInHand(hand);

        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 1F);

        if (!user.abilities.creativeMode) {
            currentStack.decrement(1);
        }

        if (!world.isClient){

            switch (type) {
                case DYNAMITE:
                    DynamiteEntity dynamiteEntity = new DynamiteEntity(world, user);
                    dynamiteEntity.setItem(currentStack);
                    dynamiteEntity.setProperties(user, user.pitch, user.yaw, 0.0F, 1.5F, 0F);
                    world.spawnEntity(dynamiteEntity);
                    break;

                case SMALL_DYNAMITE:
                    SmallDynamiteEntity smallDynamiteEntity = new SmallDynamiteEntity(world, user);
                    smallDynamiteEntity.setItem(currentStack);
                    smallDynamiteEntity.setProperties(user, user.pitch, user.yaw, 0.0F, 1.5F, 0F);
                    world.spawnEntity(smallDynamiteEntity);
                    break;
            }
        }

        return TypedActionResult.success(currentStack, world.isClient());
    }
}
