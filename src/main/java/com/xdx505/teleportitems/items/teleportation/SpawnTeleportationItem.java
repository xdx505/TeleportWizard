package com.xdx505.teleportitems.items.teleportation;

import com.xdx505.teleportitems.exceptions.MinecraftTextFormattedException;
import com.xdx505.teleportitems.utils.DimensionBlockPos;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class SpawnTeleportationItem extends BaseTeleportationItem {
    public SpawnTeleportationItem(Properties properties) {
        super(properties);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("item.teleportitems.teleportitems_spawn.description"));
    }

    @Nonnull
    public DimensionBlockPos getPortalPoint(PlayerEntity player) throws MinecraftTextFormattedException {
        DimensionType dimension = player.world.getDimensionType();
        int spawnX = player.world.getWorldInfo().getSpawnX();
        int spawnY = player.world.getWorldInfo().getSpawnY();
        int spawnZ = player.world.getWorldInfo().getSpawnZ();

        return new DimensionBlockPos(dimension, spawnX, spawnY, spawnZ);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
