package com.xdx505.teleportitems.utils;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class TeleportUtils {

    public static void teleport(World worldIn, PlayerEntity playerIn, DimensionBlockPos pos) {
        if (!playerIn.getEntityWorld().getDimensionType().equals(pos.getDimensionType())) {
            //TODO change dimension type
            playerIn.changeDimension((ServerWorld) worldIn);

        }

        DimensionBlockPos emptyPosition = WorldBlockHelper.findEmptySpaceByY(worldIn, pos);
        if (emptyPosition != null) {
            playerIn.teleportKeepLoaded(emptyPosition.getX(), emptyPosition.getY(), emptyPosition.getZ());
        }

        SoundEvent event = new SoundEvent(new ResourceLocation("entity.enderman.teleport"));
        if (event == null) {
            return;
        }
        worldIn.playSound(null, pos.getX(), pos.getY(), pos.getZ(), event, SoundCategory.BLOCKS, 1.0f, 1.0f);
    }
}