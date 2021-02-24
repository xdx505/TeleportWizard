package com.xdx505.teleportitems.items;

import com.xdx505.teleportitems.exceptions.MinecraftTextFormattedException;
import com.xdx505.teleportitems.common.models.DimensionBlockPos;
import com.xdx505.teleportitems.utils.WorldBlockHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.server.command.TextComponentHelper;

import javax.annotation.Nonnull;

import static com.xdx505.teleportitems.common.TeleportUtils.teleport;

/**
 *  * <p>Abstract teleportation item's class</p>
 *  * <p>Item can teleport player to target point from another dimensions</p>
 * <p>This is an abstract class which describes base teleportation item and general rules for teleportation process on item right click.</p>
 * @see SpawnTeleportationItem
 */
public abstract class BaseTeleportationItem extends Item {

    /**
     * Common constructor inherit super class
     * @param properties item's properties.
     */
    public BaseTeleportationItem(Properties properties) {
        super(properties);
    }

    /**
     * <p>Method do actions after player's right click.</p>
     * @param worldIn world instance
     * @param playerIn player's entity
     * @param handIn player's hand
     * @return Only server side instance.
     * <p>The player teleports to portal point, if all conditions are met.</p>
     */
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (worldIn.isRemote()) {
            return super.onItemRightClick(worldIn, playerIn, handIn);
        }

        final ItemStack stack = playerIn.getHeldItem(handIn);

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

        return new ActionResult<>(ActionResultType.SUCCESS, stack);
    }

    /**
     * Get {@link DimensionBlockPos} teleport target.
     * @param player player entity.
     * @return Target position in {@link DimensionBlockPos} format.
     * @throws MinecraftTextFormattedException if position is unavailable.
     */
    @Nonnull
    abstract DimensionBlockPos getPortalPoint(PlayerEntity player) throws MinecraftTextFormattedException;
}
