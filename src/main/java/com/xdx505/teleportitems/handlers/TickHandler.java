package com.xdx505.teleportitems.handlers;

import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Server tick handler.
 */
@Mod.EventBusSubscriber
public class TickHandler {
    private final Queue<Runnable> queue = new ConcurrentLinkedDeque<>();

    /**
     * What server need to do on tick. Check queue for runnable objects and run them.
     * @param event event.
     */
    @SubscribeEvent
    public void onPlayerTick(TickEvent.ServerTickEvent event) {
        while(!queue.isEmpty()) {
            queue.poll().run();
        }
    }

    /**
     * Add thread to queue
     * @param runnable thread to add.
     */
    public void handle(Runnable runnable) {
        queue.add(runnable);
    }
}
