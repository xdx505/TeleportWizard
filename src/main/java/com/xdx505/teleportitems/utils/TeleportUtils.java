package com.xdx505.teleportitems.utils;

import net.minecraft.entity.player.PlayerEntity;

import javax.annotation.Nullable;

public class TeleportUtils {

    public static void teleport(PlayerEntity player, DimensionBlockPos pos) {
        if (pos.getDimensionType() != null) {
            //TODO change dimension type
        }
        player.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
    }
}