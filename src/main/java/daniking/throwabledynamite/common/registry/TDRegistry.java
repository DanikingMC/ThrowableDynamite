package daniking.throwabledynamite.common.registry;

import daniking.throwabledynamite.common.ThrowableDynamite;
import daniking.throwabledynamite.common.item.SmallThrowableDynamiteItem;
import daniking.throwabledynamite.common.item.ThrowableDynamiteItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TDRegistry {

    public static final Item THROWABLE_DYNAMITE = new ThrowableDynamiteItem(setGroup());
    public static final Item SMALL_THROWABLE_DYNAMITE = new SmallThrowableDynamiteItem(setGroup());

   private static Item.Settings setGroup() {
        return new Item.Settings().group(ItemGroup.COMBAT);
   }
    public static void init(){
        Registry.register(Registry.ITEM, new Identifier(ThrowableDynamite.MODID, "throwable_dynamite"), THROWABLE_DYNAMITE);
        Registry.register(Registry.ITEM, new Identifier(ThrowableDynamite.MODID, "small_throwable_dynamite"), SMALL_THROWABLE_DYNAMITE);

    }
}
