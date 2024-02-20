package net.pitan76.advancedreborn.armormaterials;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

public class NanoArmorMaterial implements ArmorMaterial {

    public static ArmorMaterial NANO = new NanoArmorMaterial();

    @Override
    public int getDurability(ArmorItem.Type type) {
        return ArmorMaterials.DIAMOND.getDurability(type);
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return ArmorMaterials.DIAMOND.getProtection(type);
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
