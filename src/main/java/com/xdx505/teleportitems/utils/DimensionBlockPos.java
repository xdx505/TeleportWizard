package com.xdx505.teleportitems.utils;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;

import javax.swing.text.html.parser.Entity;

public class DimensionBlockPos extends BlockPos {
    private final DimensionType dimensionType;

    public DimensionBlockPos(DimensionType dimensionType, int X, int Y, int Z) {
        super(X, Y, Z);
        this.dimensionType = dimensionType;
    }

    public DimensionType getDimensionType() {
        return dimensionType;
    }
}
