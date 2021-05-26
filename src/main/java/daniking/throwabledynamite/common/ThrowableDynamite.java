package daniking.throwabledynamite.common;

import daniking.throwabledynamite.common.registry.TDRegistry;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class ThrowableDynamite implements ModInitializer {

	public static final String MODID = "throwabledynamite";
	public static ThrowableDynamiteConfig config;

	@Override
	public void onInitialize() {
		AutoConfig.register(ThrowableDynamiteConfig.class, GsonConfigSerializer::new);
		config = AutoConfig.getConfigHolder(ThrowableDynamiteConfig.class).getConfig();
		System.out.println("Hello Fabric world!");
		TDRegistry.init();
	}

	public static Identifier ModIdentifier(String path){
		return new Identifier(MODID, path);
	}
}
