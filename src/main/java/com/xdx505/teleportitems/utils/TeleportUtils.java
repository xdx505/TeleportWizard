package com.xdx505.teleportitems.utils;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.server.command.TextComponentHelper;

import java.util.UUID;

public class TeleportUtils {

    public static void teleport(World worldIn, PlayerEntity playerIn, DimensionBlockPos pos) {
        if (!playerIn.getEntityWorld().getDimensionType().equals(pos.getDimensionType())) {
            //TODO change dimension type
            playerIn.changeDimension((ServerWorld) worldIn);

        }

        final DimensionBlockPos emptyPosition = WorldBlockHelper.findEmptySpaceByY(worldIn, pos);
        if (emptyPosition != null) {
            playerIn.teleportKeepLoaded(emptyPosition.getX(), emptyPosition.getY(), emptyPosition.getZ());
        } else playerIn.sendMessage(TextComponentHelper.createComponentTranslation(playerIn, "teleportitems.teleporting_noemptyspace"),UUID.randomUUID());
    }
}