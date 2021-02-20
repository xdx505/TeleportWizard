package com.xdx505.teleportitems.exceptions;

import net.minecraft.util.text.ITextComponent;

public class MinecraftTextFormattedException {
    private final ITextComponent reason;

    public MinecraftTextFormattedException(ITextComponent reason) {
        this.reason = reason;
    }

    public ITextComponent getReason() {
        return reason;
    }
}
