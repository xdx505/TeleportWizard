package com.xdx505.teleportitems.common;

import com.xdx505.teleportitems.TeleportItems;
import com.xdx505.teleportitems.storage.config.TeleportItemsConfig;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.server.command.TextComponentHelper;

import java.util.concurrent.TimeUnit;

/**
 * <p>This thread set delay before teleporting. Delay time can be configured in config.</p>
 * If player doesn't take damage and doesn't move during the delay, he will teleport.
 */
public class TeleportDelayThread extends Thread {
    final private Runnable onTeleport;
    final private int delaySec = TeleportItemsConfig.getTeleportDelay().get();
    final private PlayerEntity entityPlayer;
    final private BlockPos initPos;
    final private float initHp;

    /**
     * Constructor.
     * @param entityPlayer player's entity.
     * @param onTeleport teleport thread.
     */
    public TeleportDelayThread(PlayerEntity entityPlayer, Runnable onTeleport) {
        this.onTeleport = onTeleport;
        this.entityPlayer = entityPlayer;
        this.initPos = entityPlayer.getPosition();
        this.initHp = entityPlayer.getHealth();
    }

    /**
     * If player doesn't take damage and doesn't move during the delay, he will teleport.
     */
    @Override
    public void run() {
        super.run();
        try {
            int delayRemain = delaySec;
            long timestamp = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
            while (delayRemain > 0) {
                delayRemain = delaySec - (int) (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - timestamp);

                final BlockPos curentPos = entityPlayer.getPosition();
                if (!curentPos.equals(initPos) || initHp > entityPlayer.getHealth()) {
                    ITextComponent message = TextComponentHelper.createComponentTranslation(entityPlayer, "teleportitems.moving_teleport_text");
                    entityPlayer.sendMessage(message, Util.DUMMY_UUID);
                    entityPlayer.sendStatusMessage(message, true);
                    return;
                }

                entityPlayer.sendStatusMessage(TextComponentHelper.createComponentTranslation(entityPlayer, "teleportitems.delay_teleport_text", delayRemain), true);
                Thread.sleep(TimeUnit.SECONDS.toMillis(1));
            }
            entityPlayer.sendStatusMessage(TextComponentHelper.createComponentTranslation(entityPlayer, "teleportitems.teleporting_text"), true);
            TeleportItems.getInstance().getTickHandler().handle(onTeleport);
        } catch (Exception e) {
            TeleportItems.getInstance().getLogger().error(e);
        }
    }
}

