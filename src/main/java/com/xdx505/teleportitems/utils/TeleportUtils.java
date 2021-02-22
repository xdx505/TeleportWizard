package com.xdx505.teleportitems.utils;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class TeleportUtils {

    public static void teleport(PlayerEntity playerIn, DimensionBlockPos pos) {
        if (pos.getDimensionType() != null) {
            //TODO change dimension type
        }
        playerIn.teleportKeepLoaded(pos.getX(), pos.getY(), pos.getZ());
    }
}