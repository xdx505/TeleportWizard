package com.xdx505.teleportitems;

import com.xdx505.teleportitems.setup.Registration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(TeleportItems.MODID)
public class TeleportItems {
    public static final String MODID = "teleportitems";
    private static TeleportItems INSTANCE;
    private final Logger logger = LogManager.getLogger();

    public TeleportItems() {
        INSTANCE = this;
        Registration.register();
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static TeleportItems getInstance() {
        return INSTANCE;
    }

    public Logger getLogger() {
        return logger;
    }
}
