package com.xdx505.teleportitems.utils;

import com.xdx505.teleportitems.items.teleportation.TeleportDelayThread;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TeleportUtils {

    public static void teleport(World worldIn, PlayerEntity playerIn, ItemStack stack, DimensionBlockPos pos) {
        if (!playerIn.getEntityWorld().getDimensionType().equals(pos.getDimensionType())) {
            //TODO change dimension type
        }

        //TODO if instant teleport

        new TeleportDelayThread(playerIn, new Runnable() {
            @Override
            public void run() {
                playerIn.teleportKeepLoaded(pos.getX(), pos.getY(), pos.getZ());
            }
        }).start();
    }
}