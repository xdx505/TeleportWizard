package com.xdx505.teleportitems.setup;

import com.xdx505.teleportitems.TeleportItems;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {
    public static void registerAll() {
        final DeferredRegister<Item> items = DeferredRegister.create(ForgeRegistries.ITEMS, TeleportItems.MODID);

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        items.register(modEventBus);

        ModItems.registerItems(items);
    }
}
