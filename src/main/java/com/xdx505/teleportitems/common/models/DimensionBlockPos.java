package com.xdx505.teleportitems.common.models;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;

public class DimensionBlockPos extends BlockPos {
    private final DimensionType dimensionType;

    public DimensionBlockPos(DimensionType dimensionType, int x, int y, int z) {
        super(x, y, z);
        this.dimensionType = dimensionType;
    }

    public DimensionType getDimensionType() {
        return dimensionType;
    }
}
