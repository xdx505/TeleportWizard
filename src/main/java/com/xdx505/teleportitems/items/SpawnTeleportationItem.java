package com.xdx505.teleportitems.items;

import com.xdx505.teleportitems.common.models.DimensionBlockPos;
import com.xdx505.teleportitems.exceptions.MinecraftTextFormattedException;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

/**
 * <p>Teleportation to spawn item's class</p>
 * <p>Item can teleport player to spawn from another dimensions</p>
 * @see BaseTeleportationItem
 */
public class SpawnTeleportationItem extends BaseTeleportationItem {
    /**
     * Common constructor inherit super class
     * @param properties item's properties.
     */
    public SpawnTeleportationItem(Properties properties) {
        super(properties);
    }

    /**
     * Method helps to describe item in game by .lang file data
     * @param stack item stack
     * @param worldIn entity's world
     * @param tooltip list with descriptions
     * @param flagIn flag for client side
     */
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("item.teleportitems.teleportitems_spawn.description"));
    }

    /**
     * Method returns spawn point of world. Can't be null.
     * @param player player entity.
     * @return spawn point.
     */
    @Nonnull
    public DimensionBlockPos getPortalPoint(PlayerEntity player) {
        DimensionType dimension = player.world.getDimensionType();
        int spawnX = player.world.getWorldInfo().getSpawnX();
        int spawnY = player.world.getWorldInfo().getSpawnY() + 1;
        int spawnZ = player.world.getWorldInfo().getSpawnZ();

        return new DimensionBlockPos(dimension, spawnX, spawnY, spawnZ);
    }
}
