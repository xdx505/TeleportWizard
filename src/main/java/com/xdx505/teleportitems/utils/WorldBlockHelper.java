package com.xdx505.teleportitems.utils;

import com.xdx505.teleportitems.common.models.DimensionBlockPos;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Class width helpful utils
 * @see WorldBlockHelper#isPlayerCapaciousBlock(World, DimensionBlockPos)
 */
public class WorldBlockHelper {

    /**
     * <p>This method check empty space upper current block.</p>
     * <p>If next block by Y is air block returns true;</p>
     * @param worldIn {@link World} current world
     * @param pos {@link DimensionBlockPos} current position
     * @return true, if next block by Y is air block
     */
    public static boolean isPlayerCapaciousBlock(World worldIn, DimensionBlockPos pos) {
        if (!worldIn.isAirBlock(pos)) {
            return false;
        }
        return worldIn.isAirBlock(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()));
    }
}
