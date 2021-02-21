package com.xdx505.teleportitems.items.teleportation;

import com.xdx505.teleportitems.exceptions.MinecraftTextFormattedException;
import com.xdx505.teleportitems.utils.DimensionBlockPos;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.UUID;

import static com.xdx505.teleportitems.utils.TeleportUtils.teleport;

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

        stack.shrink(1);

        DimensionBlockPos portalPoint;
        try {
            portalPoint = getPortalPoint(playerIn);
        } catch (MinecraftTextFormattedException e) {
            playerIn.sendMessage(e.getReason(), UUID.randomUUID());
            return new ActionResult<>(ActionResultType.FAIL, stack);
        }

        scheduleTeleport(playerIn, portalPoint, stack);

        return new ActionResult<>(ActionResultType.SUCCESS, stack);
    }

    protected void scheduleTeleport(PlayerEntity playerIn, DimensionBlockPos pos, @Nullable ItemStack itemStack) {
        teleport(playerIn, pos);
    }

    @Nonnull
    abstract DimensionBlockPos getPortalPoint(PlayerEntity player) throws MinecraftTextFormattedException;
}
