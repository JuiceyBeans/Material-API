package com.juiceybeans.materialapi;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {

    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue EXAMPLE_BOOL = BUILDER.comment("Example boolean")
            .define("exampleBool", true);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean exampleBool;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        exampleBool = EXAMPLE_BOOL.get();
    }
}
