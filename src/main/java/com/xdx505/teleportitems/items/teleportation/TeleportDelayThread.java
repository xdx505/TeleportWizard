package com.xdx505.teleportitems.items.teleportation;

import com.xdx505.teleportitems.TeleportItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.server.command.TextComponentHelper;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class TeleportDelayThread extends Thread {
    final private Runnable onTeleport;
    final private int delay = 3;
    final private PlayerEntity entityPlayer;
    final private BlockPos initPos;
    final private float initHp;

    public TeleportDelayThread(PlayerEntity entityPlayer, Runnable onTeleport) {
        this.onTeleport = onTeleport;
        this.entityPlayer = entityPlayer;
        this.initPos = entityPlayer.getPosition();
        this.initHp = entityPlayer.getHealth();
    }

    @Override
    public void run() {
        super.run();
        try {
            int delayRemain = delay;
            long timestamp = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
            while (delayRemain > 0) {
                delayRemain = delay - (int) (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - timestamp);

                final BlockPos curentPos = entityPlayer.getPosition();
                if (!curentPos.equals(initPos) || initHp > entityPlayer.getHealth()) {
                    ITextComponent message = TextComponentHelper.createComponentTranslation(entityPlayer, "teleportitems.moving_teleport_text");
                    entityPlayer.sendMessage(message, UUID.randomUUID());
                    entityPlayer.sendStatusMessage(message, true);
                    return;
                }

                entityPlayer.sendStatusMessage(TextComponentHelper.createComponentTranslation(entityPlayer, "teleportitems.delay_teleport_text", delayRemain), true);
                Thread.sleep(TimeUnit.SECONDS.toMillis(1));
            }
            entityPlayer.sendStatusMessage(TextComponentHelper.createComponentTranslation(entityPlayer, "teleportitems.teleporting_text"), true);
        } catch (Exception e) {
            TeleportItems.getInstance().getLogger().error(e);
        }
    }
}

