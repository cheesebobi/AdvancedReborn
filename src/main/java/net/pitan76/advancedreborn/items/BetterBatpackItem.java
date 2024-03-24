package net.pitan76.advancedreborn.items;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.pitan76.mcpitanlib.api.item.CompatibleArmorMaterial;
import org.jetbrains.annotations.Nullable;
import reborncore.common.util.ItemUtils;
import team.reborn.energy.EnergyTier;
import techreborn.items.armor.BatpackItem;

import java.util.List;

public class BetterBatpackItem extends BatpackItem {

    public BetterBatpackItem(int maxCharge, CompatibleArmorMaterial material, EnergyTier tier) {
        super(maxCharge, material.build(), tier);
    }

    @Override
    public boolean isDamageable() {
        return false;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Environment(EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, @Nullable World worldIn, List<Text> tooltip, TooltipContext flagIn) {
        ItemUtils.buildActiveTooltip(stack, tooltip);
    }
}
