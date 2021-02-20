package com.xdx505.teleportitems.items.teleportation;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;

public abstract class BaseTeleportationItem extends Item {

    public BaseTeleportationItem(Properties properties) {
        super(properties);
        properties.maxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);

        SoundEvent event = new SoundEvent(new ResourceLocation("entity.splash_potion.break"));
        if (event != null) {
            worldIn.playSound(null, playerIn.lastTickPosX, playerIn.lastTickPosY, playerIn.lastTickPosZ, event, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }

        return new ActionResult<>(ActionResultType.SUCCESS, stack);
    }
}
