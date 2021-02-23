package com.xdx505.teleportitems.utils;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

public class WorldBlockHelper {

    public static boolean isPlayerCapaciousBlock(World worldIn, DimensionBlockPos pos) {
        if (!worldIn.isAirBlock(pos)) {
            return false;
        }
        return worldIn.isAirBlock(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()));
    }

    public static DimensionBlockPos findEmptySpaceByY(World worldIn, DimensionBlockPos srcPos) {
        final DimensionType dimensionType = srcPos.getDimensionType();
        int x = srcPos.getX();
        int z = srcPos.getZ();

        for (int i = srcPos.getY(); i < 256; i++) {
            final DimensionBlockPos dimensionBlockPos = new DimensionBlockPos(dimensionType, x, i, z);
            if (isPlayerCapaciousBlock(worldIn, dimensionBlockPos)) return dimensionBlockPos;
        }

        return null;
    }
}
