package com.xdx505.teleportitems.common;

import com.xdx505.teleportitems.common.models.DimensionBlockPos;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class TeleportRunner implements Runnable {
    private final PlayerEntity playerIn;
    private final DimensionBlockPos position;
    private final World worldIn;

    public TeleportRunner(PlayerEntity playerIn, DimensionBlockPos position, World worldIn) {
        this.playerIn = playerIn;
        this.position = position;
        this.worldIn = worldIn;
    }

    @Override
    public void run() {
            playerIn.teleportKeepLoaded(position.getX(), position.getY(), position.getZ());

            final SoundEvent eventEnder = SoundEvents.ENTITY_ENDERMAN_TELEPORT;
            if (eventEnder != null) {
                worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), eventEnder, SoundCategory.BLOCKS, 1.0f, 1.0f);
            }
    }
}
