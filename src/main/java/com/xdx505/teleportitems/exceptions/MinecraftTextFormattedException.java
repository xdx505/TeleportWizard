package com.xdx505.teleportitems.exceptions;

import net.minecraft.util.text.ITextComponent;

/**
 * Exception with minecraft localization support
 */
public class MinecraftTextFormattedException extends Throwable {
    private final ITextComponent reason;

    /**
     * Constructor
     * @param reason reason of the exception.
     */
    public MinecraftTextFormattedException(ITextComponent reason) {
        this.reason = reason;
    }

    /**
     * Get {@link MinecraftTextFormattedException#reason}
     * @return {@link MinecraftTextFormattedException#reason}
     */
    public ITextComponent getReason() {
        return reason;
    }
}
