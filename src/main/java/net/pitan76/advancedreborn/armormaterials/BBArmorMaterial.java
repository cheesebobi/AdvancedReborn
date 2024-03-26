package net.pitan76.advancedreborn.armormaterials;

import net.minecraft.item.ArmorMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.pitan76.mcpitanlib.api.item.ArmorEquipmentType;
import net.pitan76.mcpitanlib.api.item.CompatibleArmorMaterial;

public class BBArmorMaterial implements CompatibleArmorMaterial {

    public String name = "";

    public BBArmorMaterial(String name) {
        this.name = name;
    }

    @Override
    public int getDurability(ArmorEquipmentType type) {
        return ArmorMaterials.IRON.getDurability(ArmorEquipmentType.CHEST.getType());
    }

    @Override
    public int getProtection(ArmorEquipmentType type) {
        return ArmorMaterials.IRON.getProtection(ArmorEquipmentType.CHEST.getType());
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
    public Identifier getId() {
        return new Identifier(name);
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
