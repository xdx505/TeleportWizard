package com.xdx505.teleportitems;

import com.xdx505.teleportitems.handlers.TickHandler;
import com.xdx505.teleportitems.setup.Registration;
import com.xdx505.teleportitems.storage.models.TeleportItemsConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(TeleportItems.MODID)
public class TeleportItems {
    public static final String MODID = "teleportitems";
    private static TeleportItems INSTANCE;
    private Logger logger = LogManager.getLogger();
    private TickHandler tickHandler = new TickHandler();

    public TeleportItems() {
        INSTANCE = this;
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, TeleportItemsConfig.CONFIG);
        Registration.getInstance();
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static TeleportItems getInstance() {
        return INSTANCE;
    }

    public Logger getLogger() {
        return logger;
    }

    public TickHandler getTickHandler() {
        return tickHandler;
    }
}
