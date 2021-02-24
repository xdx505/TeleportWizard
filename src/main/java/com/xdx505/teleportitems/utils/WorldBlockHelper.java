package com.xdx505.teleportitems.utils;

import com.xdx505.teleportitems.common.models.DimensionBlockPos;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WorldBlockHelper {

    public static boolean isPlayerCapaciousBlock(World worldIn, DimensionBlockPos pos) {
        if (!worldIn.isAirBlock(pos)) {
            return false;
        }
        return worldIn.isAirBlock(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()));
    }
}
