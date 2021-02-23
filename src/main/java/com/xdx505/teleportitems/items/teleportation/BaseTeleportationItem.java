package com.xdx505.teleportitems.items.teleportation;

import com.xdx505.teleportitems.exceptions.MinecraftTextFormattedException;
import com.xdx505.teleportitems.utils.DimensionBlockPos;
import com.xdx505.teleportitems.utils.WorldBlockHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.server.command.TextComponentHelper;

import javax.annotation.Nonnull;

import static com.xdx505.teleportitems.utils.TeleportUtils.teleport;

public abstract class BaseTeleportationItem extends Item {

    public BaseTeleportationItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);

        final DimensionBlockPos portalPoint;
        try {
            portalPoint = getPortalPoint(playerIn);
        } catch (MinecraftTextFormattedException e) {
            playerIn.sendMessage(e.getReason(), Util.DUMMY_UUID);
            return new ActionResult<>(ActionResultType.FAIL, stack);
        }

        if (!WorldBlockHelper.isPlayerCapaciousBlock(worldIn, portalPoint)) {
            playerIn.sendStatusMessage(TextComponentHelper.createComponentTranslation(playerIn, "teleportitems.teleporting_noemptyspace"), true);
            return new ActionResult<>(ActionResultType.FAIL, stack);
        }

        stack.shrink(1);

        final SoundEvent eventGlass = SoundEvents.ENTITY_SPLASH_POTION_BREAK;
        if (eventGlass != null) {
            worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), eventGlass, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }

        teleport(worldIn, playerIn, stack, portalPoint);

        final SoundEvent eventEnder = SoundEvents.ENTITY_ENDERMAN_TELEPORT;
        if (eventEnder != null) {
            worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), eventEnder, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }

        return new ActionResult<>(ActionResultType.SUCCESS, stack);
    }

    @Nonnull
    abstract DimensionBlockPos getPortalPoint(PlayerEntity player) throws MinecraftTextFormattedException;
}
