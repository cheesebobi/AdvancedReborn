package net.pitan76.advancedreborn.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.stat.Stats;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.pitan76.advancedreborn.tile.CardboardBoxTile;
import net.pitan76.mcpitanlib.api.block.CompatibleBlockSettings;
import net.pitan76.mcpitanlib.api.block.ExtendBlock;
import net.pitan76.mcpitanlib.api.block.ExtendBlockEntityProvider;
import net.pitan76.mcpitanlib.api.event.block.*;
import net.pitan76.mcpitanlib.api.event.block.result.BlockBreakResult;
import net.pitan76.mcpitanlib.api.util.TextUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CardboardBox extends ExtendBlock implements ExtendBlockEntityProvider {

    public static Identifier CONTENTS = new Identifier("contents");
    public static DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public CardboardBox(CompatibleBlockSettings settings) {
        super(settings);
        getStateManager().getDefaultState().with(FACING, Direction.NORTH);
    }

    public void setFacing(Direction facing, World world, BlockPos pos) {
        world.setBlockState(pos, world.getBlockState(pos).with(FACING, facing));
    }

    @Override
    public void appendProperties(AppendPropertiesArgs args) {
        super.appendProperties(args);
        args.addProperty(FACING);
    }

    public BlockEntity createBlockEntity(TileCreateEvent event) {
        return new CardboardBoxTile(event);
    }

    public BlockBreakResult onBreak(BlockBreakEvent e) {
        World world = e.world;
        BlockPos pos = e.pos;
        BlockEntity blockEntity = world.getBlockEntity(pos);

        if (blockEntity instanceof CardboardBoxTile) {
            CardboardBoxTile tile = (CardboardBoxTile) blockEntity;
            if (!world.isClient() && e.player.isCreative() && !tile.isEmpty()) {
                ItemStack itemStack = new ItemStack(this);
                NbtCompound nbtCompound = tile.writeInventoryNbt(new NbtCompound());
                if (tile.hasNote()) {
                    nbtCompound.putString("note" ,tile.getNote());
                }
                if (!nbtCompound.isEmpty()) {
                    if (itemStack.getTag() != null)
                        itemStack.getTag().put("BlockEntityTag", nbtCompound);
                }
                if (tile.hasCustomName()) {
                    itemStack.setCustomName(tile.getCustomName());
                }

                ItemEntity itemEntity = new ItemEntity(world, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, itemStack);
                itemEntity.setToDefaultPickupDelay();
                world.spawnEntity(itemEntity);
            }
        }
        return super.onBreak(e);
    }

    @Override
    public void onStateReplaced(StateReplacedEvent e) {
        if (e.isSameState())
            return;

        BlockEntity blockEntity = e.getBlockEntity();
        if (blockEntity instanceof CardboardBoxTile)
            e.updateComparators();

        super.onStateReplaced(e);
    }

    @Override
    public void onPlaced(BlockPlacedEvent e) {
        LivingEntity placer = e.placer;
        World world = e.world;
        BlockPos pos = e.pos;
        ItemStack stack = e.stack;

        if(placer != null) {
            setFacing(placer.getHorizontalFacing().getOpposite(), world, pos);
        }
        if (stack.hasCustomName()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof CardboardBoxTile) {
                ((CardboardBoxTile)blockEntity).setCustomName(stack.getName());
            }
        }
        super.onPlaced(e);
    }

    @Override
    public ActionResult onRightClick(BlockUseEvent event) {
        if (event.world.isClient) {
            return ActionResult.SUCCESS;
        } else if (event.player.getPlayerEntity().isSpectator()) {
            return ActionResult.CONSUME;
        } else {
            BlockEntity blockEntity = event.world.getBlockEntity(event.pos);
            if (blockEntity instanceof CardboardBoxTile) {
                CardboardBoxTile tile = (CardboardBoxTile)blockEntity;
                event.player.openGuiScreen(tile);
                event.player.getPlayerEntity().incrementStat(Stats.OPEN_SHULKER_BOX);
                PiglinBrain.onGuardedBlockInteracted(event.player.getPlayerEntity(), true);
                return ActionResult.CONSUME;
            } else {
                return ActionResult.PASS;
            }
        }
    }

    @Override
    public ItemStack getPickStack(PickStackEvent e) {
        ItemStack itemStack = super.getPickStack(e);
        BlockEntity blockEntity = e.getBlockEntity();
        if (blockEntity instanceof CardboardBoxTile) {
            NbtCompound nbtCompound = blockEntity.writeNbt(new NbtCompound());
            if (!nbtCompound.isEmpty()) {
                if (itemStack.getTag() != null)
                    itemStack.getTag().put("BlockEntityTag", nbtCompound);
            }
        }

        return itemStack;
    }

    @Environment(EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        super.appendTooltip(stack, world, tooltip, options);
        NbtCompound nbtCompound = stack.getOrCreateSubTag("BlockEntityTag");
        if (nbtCompound != null) {
            if (nbtCompound.contains("note")) {
                tooltip.add(TextUtil.literal(nbtCompound.getString("note")));
            }
            if (nbtCompound.contains("LootTable", 8)) {
                tooltip.add(TextUtil.literal("???????"));
            }
            if (nbtCompound.contains("Items", 9)) {
                DefaultedList<ItemStack> defaultedList = DefaultedList.ofSize(27, ItemStack.EMPTY);
                Inventories.readNbt(nbtCompound, defaultedList);
                int i = 0;
                int j = 0;

                for (ItemStack itemStack : defaultedList) {
                    if (!itemStack.isEmpty()) {
                        ++j;
                        if (i <= 4) {
                            ++i;
                            MutableText mutableText = itemStack.getName().copy();
                            mutableText.append(" x").append(String.valueOf(itemStack.getCount()));
                            tooltip.add(mutableText);
                        }
                    }
                }
                if (j - i > 0) {
                    tooltip.add((TextUtil.translatable("container.advanced_reborn.cardboard_box.more", new Object[]{j - i})).copy().formatted(Formatting.ITALIC));
                }
            }
        }

    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return ScreenHandler.calculateComparatorOutput((Inventory)world.getBlockEntity(pos));
    }

    @Override
    public List<ItemStack> getDroppedStacks(DroppedStacksArgs args) {

        BlockEntity blockEntity = args.getBlockEntity();
        if (blockEntity instanceof CardboardBoxTile) {
            CardboardBoxTile tile = (CardboardBoxTile)blockEntity;
            args.builder = args.builder.putDrop(CONTENTS, (lootContext, consumer) -> {
                for(int i = 0; i < tile.size(); ++i) {
                    consumer.accept(tile.getStack(i));
                }
            });
        }
        return super.getDroppedStacks(args);
    }
}
