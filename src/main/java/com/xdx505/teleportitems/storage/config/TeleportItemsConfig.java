package com.xdx505.teleportitems.storage.config;

import net.minecraftforge.common.ForgeConfigSpec;

/**
 * <p>This class generate mod's config file.</p>
 */
public class TeleportItemsConfig {
    public static final ForgeConfigSpec CONFIG;
    private static ForgeConfigSpec.ConfigValue<Integer> teleportDelay;

    static {
        ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();
        init(configBuilder);
        CONFIG = configBuilder.build();
    }

    /**
     * <p>This method initializes config file with parameters:</p>
     * <p>{@link TeleportItemsConfig#teleportDelay} - delay before teleportation</p>
     * @param config
     */
    private static void init(ForgeConfigSpec.Builder config) {
        config.comment("Mod config file.\n\n");

        teleportDelay = config
                .comment("Delay before teleport in seconds")
                .define("delay", 3);
    }

    /**
     * Get {@link TeleportItemsConfig#teleportDelay} in seconds.
     * @return {@link TeleportItemsConfig#teleportDelay}
     */
    public static ForgeConfigSpec.ConfigValue<Integer> getTeleportDelay() {
        return teleportDelay;
    }
}
