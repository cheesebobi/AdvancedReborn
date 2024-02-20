package net.pitan76.advancedreborn.armormaterials;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

public class BBArmorMaterial implements ArmorMaterial {

    public String name = "";

    public BBArmorMaterial(String name) {
        this.name = name;
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return ArmorMaterials.IRON.getDurability(ArmorItem.Type.CHESTPLATE);
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return ArmorMaterials.IRON.getProtection(ArmorItem.Type.CHESTPLATE);
    }

    @Override
    public int getEnchantability() {
        return ArmorMaterials.IRON.getEnchantability();
    }

    @Override
    public SoundEvent getEquipSound() {
        return ArmorMaterials.IRON.getEquipSound();
    }

    @Override
    public Ingredient getRepairIngredient() {
        return ArmorMaterials.IRON.getRepairIngredient();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getToughness() {
        return ArmorMaterials.IRON.getToughness();
    }

    @Override
    public float getKnockbackResistance() {
        return ArmorMaterials.IRON.getKnockbackResistance();
    }
}
