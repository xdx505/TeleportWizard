package com.xdx505.teleportitems.setup;

import com.xdx505.teleportitems.items.SpawnTeleportationItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.registries.DeferredRegister;

public class ModItems {
    public static void registerItems(DeferredRegister<Item> items) {
        //Spawn teleportation item
        items.register("teleportitems_spawn", () -> new SpawnTeleportationItem(new Item.Properties().group(ItemGroup.COMBAT)));
    }
}
