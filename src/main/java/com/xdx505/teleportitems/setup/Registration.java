package com.xdx505.teleportitems.setup;

import com.xdx505.teleportitems.TeleportItems;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Class which register all items, blocks and other.
 */
public class Registration {
    /**
     * Register items,
     */
    public static void registerAll() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        final DeferredRegister<Item> items = DeferredRegister.create(ForgeRegistries.ITEMS, TeleportItems.MODID);
        items.register(modEventBus);

        ModItems.registerItems(items);
    }
}
