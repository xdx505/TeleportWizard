package com.xdx505.teleportitems.setup;

import com.xdx505.teleportitems.TeleportItems;
import com.xdx505.teleportitems.items.ModItems;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {
    private static Registration INSTANCE;
    public static DeferredRegister<Item> ITEMS;

    private Registration() {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TeleportItems.MODID);

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(modEventBus);

        final ModItems modItems = ModItems.getInstance();
    }

    public static Registration getInstance() {
        if (INSTANCE == null) {
            return new Registration();
        }
        return INSTANCE;
    }
}
