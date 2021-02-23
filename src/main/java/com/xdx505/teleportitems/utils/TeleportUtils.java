package com.xdx505.teleportitems.utils;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class TeleportUtils {

    public static void teleport(World worldIn, PlayerEntity playerIn, DimensionBlockPos pos) {
        if (!playerIn.getEntityWorld().getDimensionType().equals(pos.getDimensionType())) {
            //TODO change dimension type
            playerIn.changeDimension((ServerWorld) worldIn);

        }

        playerIn.teleportKeepLoaded(pos.getX(), pos.getY(), pos.getZ());
        /*final DimensionBlockPos emptyPosition = WorldBlockHelper.findEmptySpaceByY(worldIn, pos);
        if (emptyPosition != null) {
        } else playerIn.sendMessage(TextComponentHelper.createComponentTranslation(playerIn, "teleportitems.teleporting_noemptyspace"),UUID.randomUUID());*/
    }
}