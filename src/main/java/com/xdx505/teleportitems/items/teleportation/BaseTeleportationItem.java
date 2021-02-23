package com.xdx505.teleportitems.items.teleportation;

import com.xdx505.teleportitems.exceptions.MinecraftTextFormattedException;
import com.xdx505.teleportitems.utils.DimensionBlockPos;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.UUID;

import static com.xdx505.teleportitems.utils.TeleportUtils.teleport;

public abstract class BaseTeleportationItem extends Item {

    public BaseTeleportationItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);

        SoundEvent event = new SoundEvent(new ResourceLocation("entity.splash_potion.break"));
        if (event != null) {
            worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), event, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }

        stack.shrink(1);

        DimensionBlockPos portalPoint;
        try {
            portalPoint = getPortalPoint(playerIn);
        } catch (MinecraftTextFormattedException e) {
            playerIn.sendMessage(e.getReason(), UUID.randomUUID());
            return new ActionResult<>(ActionResultType.FAIL, stack);
        }
        teleport(worldIn, playerIn, portalPoint);

        return new ActionResult<>(ActionResultType.SUCCESS, stack);
    }

    @Nonnull
    abstract DimensionBlockPos getPortalPoint(PlayerEntity player) throws MinecraftTextFormattedException;
}
