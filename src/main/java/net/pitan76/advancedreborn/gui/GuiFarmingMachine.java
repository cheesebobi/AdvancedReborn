package net.pitan76.advancedreborn.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerEntity;
import net.pitan76.advancedreborn.tile.FarmingMachineTile;
import reborncore.client.gui.GuiBase;
import reborncore.common.screen.BuiltScreenHandler;

public class GuiFarmingMachine extends GuiBase<BuiltScreenHandler> {

    public FarmingMachineTile tile;
    public GuiFarmingMachine(int syncId, PlayerEntity player, FarmingMachineTile tile) {
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
        drawSlot(context, 55, 32, layer);
        drawSlot(context, 73, 32, layer);
        drawSlot(context, 55, 50, layer);
        drawSlot(context, 73, 50, layer);

        drawSlot(context, 55, 72, layer);
        drawSlot(context, 73, 72, layer);
        drawSlot(context, 91, 72, layer);
        drawSlot(context, 109, 72, layer);
        drawSlot(context, 127, 72, layer);

        drawSlot(context, 8, 72, layer);
    }

    public void drawForeground(DrawContext context, int mouseX, int mouseY) {
        super.drawForeground(context, mouseX, mouseY);
        Layer layer = Layer.FOREGROUND;
        builder.drawMultiEnergyBar(context, this, 9, 19, (int) tile.getEnergy(), (int) tile.getMaxStoredPower(), mouseX, mouseY, 0, layer);
    }
}
