package net.pitan76.advancedreborn.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.pitan76.mcpitanlib.api.event.item.ItemAppendTooltipEvent;
import net.pitan76.mcpitanlib.api.event.item.ItemUseEvent;
import net.pitan76.mcpitanlib.api.item.CompatibleItemSettings;
import net.pitan76.mcpitanlib.api.item.ExtendItem;
import reborncore.common.powerSystem.RcEnergyItem;
import reborncore.common.powerSystem.RcEnergyTier;
import reborncore.common.util.ItemUtils;
import techreborn.items.BatteryItem;

public class AdvancedBattery extends ExtendItem implements RcEnergyItem {
    public int maxEnergy;
    public RcEnergyTier tier;

    public AdvancedBattery(CompatibleItemSettings settings, int maxEnergy, RcEnergyTier tier) {
        super(settings);
        this.maxEnergy = maxEnergy;
        this.tier = tier;
    }

    @Override
    public TypedActionResult<ItemStack> onRightClick(ItemUseEvent event) {
        final ItemStack stack = event.user.getPlayerEntity().getStackInHand(event.hand);
        if (event.user.isSneaking()) {
            ItemUtils.switchActive(stack, 1, event.user.getEntity());
            return new TypedActionResult<>(ActionResult.SUCCESS, stack);
        }
        return new TypedActionResult<>(ActionResult.PASS, stack);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        ItemUtils.checkActive(stack, 1, entity);
        if (world.isClient) {
            return;
        }
        if (!ItemUtils.isActive(stack)){
            return;
        }
        if (entity instanceof PlayerEntity) {
            ItemUtils.distributePowerToInventory((PlayerEntity) entity, stack, tier.getMaxOutput(), (testStack) -> !(testStack.getItem() instanceof BatteryItem));
        }
    }

    @Override
    public void appendTooltip(ItemAppendTooltipEvent e) {
        ItemUtils.buildActiveTooltip(e.stack, e.tooltip);
    }

    @Override
    public long getEnergyCapacity() {
        return maxEnergy;
    }

    @Override
    public RcEnergyTier getTier() {
        return tier;
    }

    @Override
    public int getItemBarStep(ItemStack stack) {
        return ItemUtils.getPowerForDurabilityBar(stack);
    }

    @Override
    public boolean isItemBarVisible(ItemStack stack) {
        return true;
    }

    @Override
    public int getItemBarColor(ItemStack stack) {
        return ItemUtils.getColorForDurabilityBar(stack);
    }
}
