package ml.pkom.advancedreborn.gui;

import ml.pkom.advancedreborn.tile.InductionFurnaceTile;
import ml.pkom.mcpitanlibarch.api.util.TextUtil;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import reborncore.client.gui.GuiBase;
import reborncore.client.gui.GuiBuilder;
import reborncore.common.screen.BuiltScreenHandler;

public class GuiInductionFurnace extends GuiBase<BuiltScreenHandler> {

    public InductionFurnaceTile tile;
    public GuiInductionFurnace(int syncId, PlayerEntity player, InductionFurnaceTile tile) {
        super(player, tile, tile.createScreenHandler(syncId, player));
        this.tile = tile;
        backgroundWidth = 176;
        backgroundHeight = 166;
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
        // 本当はリソースロケーションを指定しないといけないが、今回はdrawSlot内の処理で指定しているためとりあえず指定せずにおいておく
        drawSlot(context, 8, 72, layer);
        drawTwoLongSlot(context, 55 - 18, 45, layer);
        drawOutputTwoLongSlot(context, 101, 45, layer);
        drawText(context, TextUtil.translatable("advanced_reborn.advanced_machine.text.speed", tile.getHeatPer() + "%"), 75, 70, 0, layer);
    }

    public void drawTwoLongSlot(DrawContext context, int x, int y, Layer layer) {
        if (layer == Layer.BACKGROUND) {
            x += this.x;
            y += this.y;
        }
        drawTwoLongSlotBuilder(context, this, x - 1, y - 1);
    }

    public void drawTwoLongSlotBuilder(DrawContext context, Screen gui, int posX, int posY) {
        getMinecraft().getTextureManager().bindTexture(GuiBuilder.resourceLocation);
        context.drawTexture(GuiBuilder.resourceLocation, posX, posY, 150, 0, 18 - 4, 18);
        context.drawTexture(GuiBuilder.resourceLocation, posX + 14, posY, 150 + 4, 0, 18 - 8, 18);
        context.drawTexture(GuiBuilder.resourceLocation, posX + 22, posY, 150 + 4, 0, 18 - 4, 18);
    }

    public void drawOutputTwoLongSlot(DrawContext context, int x, int y, Layer layer) {
        if (layer == Layer.BACKGROUND) {
            x += this.x;
            y += this.y;
        }
        drawOutputTwoLongSlotBuilder(context, this, x - 5, y - 5);
    }

    public void drawOutputTwoLongSlotBuilder(DrawContext context, Screen gui, int posX, int posY) {
        getMinecraft().getTextureManager().bindTexture(GuiBuilder.resourceLocation);
        context.drawTexture(GuiBuilder.resourceLocation, posX, posY, 174, 0, 26 - 4, 26);
        context.drawTexture(GuiBuilder.resourceLocation, posX + 22, posY, 174 + 4, 0, 26 - 4, 26);
    }

    public void drawForeground(DrawContext context, int mouseX, int mouseY) {
        super.drawForeground(context, mouseX, mouseY);
        Layer layer = Layer.FOREGROUND;
        builder.drawProgressBar(context, this, tile.getProgressScaled(100), 100, 76, 48, mouseX, mouseY, GuiBuilder.ProgressDirection.RIGHT, layer);
        builder.drawMultiEnergyBar(context, this, 9, 19, (int) tile.getEnergy(), (int) tile.getMaxStoredPower(), mouseX, mouseY, 0, layer);
    }
}
