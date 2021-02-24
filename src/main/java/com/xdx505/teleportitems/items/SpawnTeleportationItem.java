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
        int spawnY = player.world.getWorldInfo().getSpawnY() + 1;
        int spawnZ = player.world.getWorldInfo().getSpawnZ();

        return new DimensionBlockPos(dimension, spawnX, spawnY, spawnZ);
    }
}
