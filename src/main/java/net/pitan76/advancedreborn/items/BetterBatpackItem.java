package net.pitan76.advancedreborn.items;

import net.pitan76.mcpitanlib.api.event.item.ItemAppendTooltipEvent;
import net.pitan76.mcpitanlib.api.item.CompatibleArmorMaterial;
import net.pitan76.mcpitanlib.api.item.ExtendItemProvider;
import reborncore.common.powerSystem.RcEnergyTier;
import techreborn.items.armor.BatpackItem;
import techreborn.utils.TRItemUtils;

public class BetterBatpackItem extends BatpackItem implements ExtendItemProvider {

    public BetterBatpackItem(int maxCharge, CompatibleArmorMaterial material, RcEnergyTier tier) {
        super(maxCharge, material.build(), tier);
    }

    /*@Override
    public boolean isDamageable() {
        return false;
    }



    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }
     */

    @Override
    public void appendTooltip(ItemAppendTooltipEvent e, Options options) {
        ExtendItemProvider.super.appendTooltip(e, options);
        TRItemUtils.buildActiveTooltip(e.stack, e.tooltip);

    }
}
