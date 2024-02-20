package net.pitan76.advancedreborn.armormaterials;

import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.pitan76.mcpitanlib.api.item.ArmorEquipmentType;
import net.pitan76.mcpitanlib.api.item.CompatibleArmorMaterial;

public class NanoArmorMaterial implements CompatibleArmorMaterial {

    public static ArmorMaterial NANO = new NanoArmorMaterial();

    @Override
    public int getDurability(ArmorEquipmentType type) {
        return ArmorMaterials.DIAMOND.getDurability(type.getSlot());
    }

    @Override
    public int getProtection(ArmorEquipmentType type) {
        return ArmorMaterials.DIAMOND.getProtectionAmount(type.getSlot());
    }

    @Override
    public int getEnchantability() {
        return ArmorMaterials.DIAMOND.getEnchantability();
    }

    @Override
    public SoundEvent getEquipSound() {
        return ArmorMaterials.DIAMOND.getEquipSound();
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }

    @Override
    public String getName() {
        return "nano";
    }

    @Override
    public float getToughness() {
        return ArmorMaterials.DIAMOND.getToughness();
    }

    @Override
    public float getKnockbackResistance() {
        return ArmorMaterials.DIAMOND.getKnockbackResistance();
    }
}
