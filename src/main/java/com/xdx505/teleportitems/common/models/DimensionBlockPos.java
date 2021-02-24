package com.xdx505.teleportitems.common.models;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;

/**
 * Model class extended from {@link BlockPos}. Add {@link DimensionType} field to block.
 */
public class DimensionBlockPos extends BlockPos {
    private final DimensionType dimensionType;

    /**
     *
     * @param dimensionType type of dimension.
     * @param x coordinate x.
     * @param y coordinate y.
     * @param z coordinate z.
     */
    public DimensionBlockPos(DimensionType dimensionType, int x, int y, int z) {
        super(x, y, z);
        this.dimensionType = dimensionType;
    }

    /**
     * Get {@link DimensionBlockPos#dimensionType}
     * @return {@link DimensionBlockPos#dimensionType}
     */
    public DimensionType getDimensionType() {
        return dimensionType;
    }
}
