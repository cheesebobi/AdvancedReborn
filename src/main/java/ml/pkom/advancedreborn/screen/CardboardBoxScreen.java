package ml.pkom.advancedreborn.screen;

import ml.pkom.advancedreborn.AdvancedReborn;
import ml.pkom.advancedreborn.Defines;
import ml.pkom.mcpitanlibarch.api.client.SimpleHandledScreen;
import ml.pkom.mcpitanlibarch.api.client.render.handledscreen.DrawBackgroundArgs;
import ml.pkom.mcpitanlibarch.api.client.render.handledscreen.DrawMouseoverTooltipArgs;
import ml.pkom.mcpitanlibarch.api.client.render.handledscreen.RenderArgs;
import ml.pkom.mcpitanlibarch.api.network.ClientNetworking;
import ml.pkom.mcpitanlibarch.api.network.PacketByteUtil;
import ml.pkom.mcpitanlibarch.api.util.TextUtil;
import ml.pkom.mcpitanlibarch.api.util.client.RenderUtil;
import ml.pkom.mcpitanlibarch.api.util.client.ScreenUtil;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CardboardBoxScreen extends SimpleHandledScreen {
    private static final Identifier TEXTURE = AdvancedReborn.id("textures/gui/cardboard_box.png");
    private TextFieldWidget noteBox;

    private final CardboardBoxScreenHandler handler;

    public CardboardBoxScreen(ScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        backgroundHeight = 133;
        this.playerInventoryTitleY = this.backgroundHeight - 94;
        this.handler = (CardboardBoxScreenHandler) handler;
    }

    @Override
    public void drawBackgroundOverride(DrawBackgroundArgs args) {

        ScreenUtil.setBackground(TEXTURE);
        if (client == null) return;
        client.getTextureManager().bindTexture(TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        args.getDrawObjectDM().getContext().drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);
        getNoteBox().render(args.drawObjectDM.getContext(), args.mouseX, args.mouseY, args.delta);
        RenderUtil.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public void initOverride() {
        super.initOverride();
        noteBox = new TextFieldWidget(textRenderer, x + 98,  y + 7, 70, 9, TextUtil.literal(""));
        getNoteBox().setText(handler.tmpNote);
        getNoteBox().setDrawsBackground(false);
        getNoteBox().setFocusUnlocked(false);
        ScreenUtil.TextFieldUtil.setFocused(getNoteBox(), true);
        getNoteBox().setMaxLength(2048);
        addSelectableChild(getNoteBox());
    }

    public void close() {
        super.close();
        PacketByteBuf buf = PacketByteUtil.create();
        NbtCompound data = new NbtCompound();
        data.putString("note", getNote());
        data.putDouble("x", handler.pos.getX());
        data.putDouble("y", handler.pos.getY());
        data.putDouble("z", handler.pos.getZ());
        //AdvancedReborn.LOGGER.info("nbt: " + data);
        buf.writeNbt(data);
        ClientNetworking.send(Defines.CARDBOARD_BOX_CLOSE_PACKET_ID, buf);
    }

    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (getNoteBox().keyPressed(keyCode, scanCode, modifiers)) return true;
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    public void removed() {
        super.removed();
        ScreenUtil.setRepeatEvents(false);
    }

    public TextFieldWidget getNoteBox() {
        return noteBox;
    }

    public void setNoteBox(TextFieldWidget noteBox) {
        this.noteBox = noteBox;
    }

    public String getNote() {
        return getNoteBox().getText();
    }

    public void renderOverride(RenderArgs args) {
        callRenderBackground(args.drawObjectDM);
        super.renderOverride(args);
        callDrawMouseoverTooltip(new DrawMouseoverTooltipArgs(args.drawObjectDM, args.mouseX, args.mouseY));
    }
}
