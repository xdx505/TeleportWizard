package com.xdx505.teleportitems;

import com.xdx505.teleportitems.setup.Registration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(TeleportItems.MOD_ID)
public class TeleportItems {
    public static final String MOD_ID = "teleportitems";
    private static final Logger LOGGER = LogManager.getLogger();

    public TeleportItems() {
        Registration.register();
        MinecraftForge.EVENT_BUS.register(this);
    }
}
