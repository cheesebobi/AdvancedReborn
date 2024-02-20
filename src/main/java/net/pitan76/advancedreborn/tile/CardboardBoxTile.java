package net.pitan76.advancedreborn.tile;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Nameable;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.pitan76.advancedreborn.Tiles;
import net.pitan76.advancedreborn.inventory.IInventory;
import net.pitan76.advancedreborn.screen.CardboardBoxScreenHandler;
import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;
import net.pitan76.mcpitanlib.api.util.TextUtil;
import org.jetbrains.annotations.Nullable;

public class CardboardBoxTile extends BlockEntity implements IInventory, SidedInventory, ExtendedScreenHandlerFactory, Nameable {

    public DefaultedList<ItemStack> inventory = DefaultedList.ofSize(9, ItemStack.EMPTY);
    private Text customName;
    private String note = "";

    public CardboardBoxTile(BlockEntityType<?> type) {
        super(type);
    }

    public CardboardBoxTile(BlockPos pos, BlockState state) {
        this(Tiles.CARDBOARD_BOX_TILE);
    }

    public CardboardBoxTile(TileCreateEvent event) {
        this(event.getBlockPos(), event.getBlockState());
    }

    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean hasNote() {
        return !note.equals("");
    }

    public NbtCompound writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, inventory);
        nbt.putString("note", getNote());
        return super.writeNbt(nbt);
    }

    public void fromTag(BlockState state, NbtCompound tag) {
        super.fromTag(state, tag);
        setNote(tag.getString("note"));
        Inventories.readNbt(tag, inventory);
    }

    public int[] getAvailableSlots(Direction side) {
        int[] result = new int[getItems().size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }
        return result;
    }

    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
        return true;
    }

    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return true;
    }

    public void setCustomName(Text customName) {
        this.customName = customName;
    }


    public void readInventoryNbt(NbtCompound nbt) {
        this.inventory = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
        if (nbt.contains("Items", 9)) {
            Inventories.readNbt(nbt, this.inventory);
        }

    }

    public NbtCompound writeInventoryNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, this.inventory, false);
        return nbt;
    }

    public Text getName() {
        return customName;
    }

    public Text getDisplayName() {
        return hasCustomName() ? customName : TextUtil.translatable("block.advanced_reborn.cardboard_box");
    }

    @Nullable
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new CardboardBoxScreenHandler(syncId, inv, this, getNote(), this);
    }

    public void writeScreenOpeningData(ServerPlayerEntity serverPlayerEntity, PacketByteBuf packetByteBuf) {
        NbtCompound data = new NbtCompound();
        data.putDouble("x", getPos().getX());
        data.putDouble("y", getPos().getY());
        data.putDouble("z", getPos().getZ());
        data.putString("note", getNote());
        packetByteBuf.writeNbt(data);
    }
}
