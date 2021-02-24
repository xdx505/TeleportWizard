package com.xdx505.teleportitems.common;

import com.xdx505.teleportitems.common.TeleportDelayThread;
import com.xdx505.teleportitems.common.models.DimensionBlockPos;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class TeleportUtils {

    public static void teleport(World worldIn, PlayerEntity playerIn, ItemStack stack, DimensionBlockPos pos) {
        if (!playerIn.getEntityWorld().getDimensionType().equals(pos.getDimensionType())) {
            //TODO change dimension type
        }

        //TODO if instant teleport

        new TeleportDelayThread(playerIn, new TeleportRunner(playerIn, pos, worldIn)).start();

    }
}