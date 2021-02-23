package com.xdx505.teleportitems.handlers;

import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

@Mod.EventBusSubscriber
public class TickHandler {
    private final Queue<Runnable> queue = new ConcurrentLinkedDeque<>();

    @SubscribeEvent
    public void onPayerTick(TickEvent.PlayerTickEvent event) {
        while(!queue.isEmpty()) {
            queue.poll().run();
        }
    }

    public void handle(Runnable runnable) {
        queue.add(runnable);
    }
}
