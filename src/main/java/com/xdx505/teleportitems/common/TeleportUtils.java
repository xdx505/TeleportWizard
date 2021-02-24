package com.xdx505.teleportitems.common;

import com.xdx505.teleportitems.common.models.DimensionBlockPos;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Class check dimension, type of teleport. Than create {@link TeleportDelayThread} to set delay before teleport.
 */
public class TeleportUtils {

    /**
     * Can check dimension, type of teleport. Than create and start {@link TeleportDelayThread} to set delay before teleport.
     * @param worldIn world.
     * @param playerIn player's entity.
     * @param stack item stack.
     * @param pos target position.
     */
    public static void teleport(World worldIn, PlayerEntity playerIn, ItemStack stack, DimensionBlockPos pos) {
        if (!playerIn.getEntityWorld().getDimensionType().equals(pos.getDimensionType())) {
            //TODO change dimension type
        }

        //TODO if instant teleport

        new TeleportDelayThread(playerIn, new TeleportRunner(playerIn, pos, worldIn)).start();
    }
}