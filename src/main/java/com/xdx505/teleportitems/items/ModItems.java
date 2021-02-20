package com.xdx505.teleportitems.items;

import com.xdx505.teleportitems.items.teleportation.SpawnTeleportationItem;
import com.xdx505.teleportitems.setup.Registration;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
    public static final RegistryObject<Item> SPAWN_TELEPORTATION_ITEM = Registration.ITEMS.register("teleportitems_spawn", () ->
            new SpawnTeleportationItem(new Item.Properties().group(ItemGroup.COMBAT)));

    public static void register() {

    }
}
