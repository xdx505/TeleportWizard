package com.xdx505.teleportitems.storage.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class TeleportItemsConfig {
    public static final ForgeConfigSpec CONFIG;
    public static ForgeConfigSpec.ConfigValue<Integer> teleportDelay;

    static {
        ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();
        init(configBuilder);
        CONFIG = configBuilder.build();
    }

    private static void init(ForgeConfigSpec.Builder config) {
        config.comment("Mod config file.\n\n");

        teleportDelay = config
                .comment("Delay before teleport in seconds")
                .define("delay", 3);
    }
}
