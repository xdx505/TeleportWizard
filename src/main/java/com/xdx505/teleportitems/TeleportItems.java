package com.xdx505.teleportitems;

import com.xdx505.teleportitems.handlers.TickHandler;
import com.xdx505.teleportitems.setup.Registration;
import com.xdx505.teleportitems.storage.config.TeleportItemsConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Main class of Teleport Items mod
 * @author xdx505
 * @version 1.0
 */
@Mod(TeleportItems.MODID)
public class TeleportItems {
    public static final String MODID = "teleportitems";
    private static TeleportItems INSTANCE;
    private final Logger logger = LogManager.getLogger();
    private final TickHandler tickHandler = new TickHandler();

    /**
     * <p>In constructor:</p>
     * <p>1. Set {@link TeleportItems#INSTANCE}</p>
     * <p>2. Config {@link TeleportItemsConfig} registration</p>
     * <p>3. Registration of this instance and {@link TeleportItems#tickHandler} by event bus</p>
     */
    public TeleportItems() {
        INSTANCE = this;
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, TeleportItemsConfig.CONFIG);
        Registration.registerAll();
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(tickHandler);
    }

    /**
     * Get {@link TeleportItems#INSTANCE}
     * @return {@link TeleportItems#INSTANCE}
     */
    public static TeleportItems getInstance() {
        return INSTANCE;
    }

    /**
     * Get apache log4j logger {@link TeleportItems#logger}
     * @return {@link TeleportItems#logger}
     */
    public Logger getLogger() {
        return logger;
    }

    /**
     * Get TickHandler object {@link TeleportItems#tickHandler}
     * @return {@link TeleportItems#tickHandler}
     */
    public TickHandler getTickHandler() {
        return tickHandler;
    }
}
