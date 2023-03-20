package ml.pkom.advancedreborn.items;

import ml.pkom.advancedreborn.Items;
import ml.pkom.mcpitanlibarch.api.event.item.ItemUseEvent;
import ml.pkom.mcpitanlibarch.api.item.CompatibleItemSettings;
import ml.pkom.mcpitanlibarch.api.item.ExtendItem;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

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

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        PlayerEntity playerEntity = user instanceof PlayerEntity ? (PlayerEntity)user : null;
        if (playerEntity instanceof ServerPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger((ServerPlayerEntity)playerEntity, stack);
        }
        if (playerEntity != null) {
            playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
            if (!playerEntity.getAbilities().creativeMode) {
                //stack.decrement(1);
                playerEntity.eatFood(world, stack);
            }
        }

        if (playerEntity == null || !playerEntity.getAbilities().creativeMode) {
            if (stack.isEmpty()) {
                return new ItemStack(Items.EMPTY_CAN);
            }

            if (playerEntity != null) {
                ItemStack emptyCan = new ItemStack(Items.EMPTY_CAN);
                boolean inserted = playerEntity.getInventory().insertStack(emptyCan);
                if (!inserted) {
                    playerEntity.dropItem(emptyCan, false);
                }
                if (playerEntity.canConsume(false)) finishUsing(stack, world, user);
            }
        }

        return stack;
    }
}
