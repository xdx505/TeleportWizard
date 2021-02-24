package com.xdx505.teleportitems.items;

import com.xdx505.teleportitems.items.teleportation.SpawnTeleportationItem;
import com.xdx505.teleportitems.setup.Registration;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class ModItems {
    private static ModItems INSTANCE;

    private ModItems(DeferredRegister<Item> items) {
        final RegistryObject<Item> SPAWN_TELEPORTATION_ITEM = items.register("teleportitems_spawn", () ->
                new SpawnTeleportationItem(new Item.Properties().group(ItemGroup.COMBAT)));
    }

    public static ModItems getInstance(DeferredRegister<Item> items) {
        if (INSTANCE == null) {
            INSTANCE = new ModItems(items);
        }
        return INSTANCE;
    }
}
