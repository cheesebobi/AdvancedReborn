package net.pitan76.advancedreborn.items;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.pitan76.advancedreborn.Items;
import net.pitan76.mcpitanlib.api.entity.Player;
import net.pitan76.mcpitanlib.api.event.item.ItemFinishUsingEvent;
import net.pitan76.mcpitanlib.api.event.item.ItemUseEvent;
import net.pitan76.mcpitanlib.api.item.CompatibleItemSettings;
import net.pitan76.mcpitanlib.api.item.ExtendItem;
import net.pitan76.mcpitanlib.api.util.ItemStackUtil;

import static net.pitan76.advancedreborn.Items.CAN_FOOD_COMPONENT;

public class FoodCanItem extends ExtendItem {
    public FoodCanItem(CompatibleItemSettings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> onRightClick(ItemUseEvent event) {
        TypedActionResult<ItemStack> result = super.onRightClick(event);
        if (result.getResult().equals(ActionResult.CONSUME)) {
            event.user.getPlayerEntity().heal(1);
        }
        return result;
    }

    public ItemStack onFinishUsing(ItemFinishUsingEvent e) {
        World world = e.world;
        ItemStack stack = e.stack;

        PlayerEntity playerEntity = e.user instanceof PlayerEntity ? (PlayerEntity) e.user : null;
        if (playerEntity instanceof ServerPlayerEntity)
            Criteria.CONSUME_ITEM.trigger((ServerPlayerEntity)playerEntity, stack);


        if (playerEntity != null) {
            Player player = new Player(playerEntity);

            player.incrementStat(Stats.USED.getOrCreateStat(this));
            if (!player.isCreative()) {
                playerEntity.eatFood(world, stack, CAN_FOOD_COMPONENT);
            }
        }

        if (playerEntity == null || !playerEntity.getAbilities().creativeMode) {
            if (stack.isEmpty()) {
                return ItemStackUtil.create(Items.EMPTY_CAN);
            }

            if (playerEntity != null) {
                ItemStack emptyCan = ItemStackUtil.create(Items.EMPTY_CAN);
                boolean inserted = playerEntity.getInventory().insertStack(emptyCan);
                if (!inserted) {
                    playerEntity.dropItem(emptyCan, false);
                }
                if (playerEntity.canConsume(false)) super.onFinishUsing(e);
            }
        }

        return stack;
    }
}
