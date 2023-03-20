package ml.pkom.advancedreborn.items;

import ml.pkom.advancedreborn.Items;
import ml.pkom.advancedreborn.tile.TeleporterTile;
import ml.pkom.mcpitanlibarch.api.event.item.ItemUseOnBlockEvent;
import ml.pkom.mcpitanlibarch.api.item.CompatibleItemSettings;
import ml.pkom.mcpitanlibarch.api.item.ExtendItem;
import ml.pkom.mcpitanlibarch.api.util.math.PosUtil;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import ml.pkom.mcpitanlibarch.api.util.TextUtil;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FreqTrans extends ExtendItem {
    public FreqTrans(CompatibleItemSettings settings) {
        super(settings);
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
            ItemStack stack = player.getStackInHand(hand);
            if (stack.getItem().equals(Items.FREQ_TRANS)) {
                if (world.isClient()) return ActionResult.PASS;
                BlockEntity tile = world.getBlockEntity(pos);
                if (tile instanceof TeleporterTile) {
                    if (!stack.hasNbt()) return ActionResult.FAIL;
                    NbtCompound tag = stack.getNbt();
                    if (!tag.contains("tpX") || !tag.contains("tpY") || !tag.contains("tpZ")) return ActionResult.FAIL;
                    TeleporterTile machine = (TeleporterTile) tile;
                    machine.setTeleportPos(PosUtil.flooredBlockPos(tag.getDouble("tpX"), tag.getDouble("tpY"), tag.getDouble("tpZ")));
                    player.sendMessage(TextUtil.literal("Loaded Teleport Pos from The Frequency Transmitter.(" + tag.getDouble("tpX") + "," + tag.getDouble("tpY") + "," + tag.getDouble("tpZ") + ")"), false);
                    return ActionResult.SUCCESS;
                }
            }
            return ActionResult.PASS;
        });
    }

    public ActionResult onRightClickOnBlock(ItemUseOnBlockEvent event) {
        World world = event.world;
        BlockPos pos = event.hit.getBlockPos();
        BlockEntity tile = world.getBlockEntity(pos);
        if (tile == null) return ActionResult.PASS;
        if (!(tile instanceof TeleporterTile)) return ActionResult.PASS;
        if (world.isClient()) return ActionResult.SUCCESS;
        TeleporterTile machine = (TeleporterTile) tile;
        ItemStack stack = event.player.getPlayerEntity().getStackInHand(event.hand);
        NbtCompound tag = stack.getNbt();
        if (tag == null) {
            tag = new NbtCompound();
        }
        tag.putDouble("tpX", machine.getX());
        tag.putDouble("tpY", machine.getY());
        tag.putDouble("tpZ", machine.getZ());
        stack.setNbt(tag);
        event.player.sendMessage(TextUtil.literal("Saved Machine's Pos to The Frequency Transmitter.(" + tag.getDouble("tpX") + "," + tag.getDouble("tpY") + "," + tag.getDouble("tpZ") + ")"));
        return ActionResult.SUCCESS;
    }

    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(TextUtil.literal("Save pos to Wrench when Right Click with Teleporter."));
        tooltip.add(TextUtil.literal("Load pos from Wrench when Left Click with Teleporter."));
        if (stack.hasNbt()) {
            NbtCompound nbt = stack.getNbt();
            if (nbt != null) if (nbt.contains("tpX") && nbt.contains("tpY") && nbt.contains("tpZ"))
                tooltip.add(TextUtil.literal("Pos(" + nbt.getDouble("tpX") + "," + nbt.getDouble("tpY") + "," + nbt.getDouble("tpZ") + ")"));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
