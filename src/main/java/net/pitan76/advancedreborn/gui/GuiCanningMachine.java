package net.pitan76.advancedreborn.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerEntity;
import net.pitan76.advancedreborn.tile.CanningMachineTile;
import reborncore.client.gui.GuiBase;
import reborncore.client.gui.GuiBuilder;
import reborncore.common.screen.BuiltScreenHandler;

public class GuiCanningMachine extends GuiBase<BuiltScreenHandler> {

    public CanningMachineTile tile;
    public GuiCanningMachine(int syncId, PlayerEntity player, CanningMachineTile tile) {
        super(player, tile, tile.createScreenHandler(syncId, player));
        this.tile = tile;
    }

    public boolean isConfigEnabled() {
        return true;
    }

    public void init() {
        super.init();
    }

    public void drawBackground(DrawContext context, float lastFrameDuration, int mouseX, int mouseY) {
        super.drawBackground(context, lastFrameDuration, mouseX, mouseY);
        Layer layer = Layer.BACKGROUND;
        drawSlot(context, 55, 35, layer);
        drawSlot(context, 55, 55, layer);
        drawOutputSlot(context, 101, 45, layer);
        drawSlot(context, 8, 72, layer);
    }

    public void drawForeground(DrawContext context, int mouseX, int mouseY) {
        super.drawForeground(context, mouseX, mouseY);
        Layer layer = Layer.FOREGROUND;
        builder.drawProgressBar(context, this, tile.getProgressScaled(100), 100, 76, 48, mouseX, mouseY, GuiBuilder.ProgressDirection.RIGHT, layer);
        builder.drawMultiEnergyBar(context, this, 9, 19, (int) tile.getEnergy(), (int) tile.getMaxStoredPower(), mouseX, mouseY, 0, layer);
    }
}
