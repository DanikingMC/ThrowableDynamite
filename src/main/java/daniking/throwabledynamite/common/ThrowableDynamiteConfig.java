package daniking.throwabledynamite.common;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = ThrowableDynamite.MODID)
public class ThrowableDynamiteConfig implements ConfigData {

    public byte dynamitePower = 4;
    public byte small_dynamitePower = 2;

}
