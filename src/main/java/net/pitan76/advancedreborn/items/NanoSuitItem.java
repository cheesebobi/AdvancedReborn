package net.pitan76.advancedreborn.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.pitan76.advancedreborn.Items;
import net.pitan76.mcpitanlib.api.item.ArmorEquipmentType;
import net.pitan76.mcpitanlib.api.item.CompatibleItemSettings;
import reborncore.api.events.ApplyArmorToDamageCallback;
import reborncore.api.items.ArmorTickable;
import reborncore.api.items.ItemStackModifiers;
import reborncore.common.powerSystem.PowerSystem;
import reborncore.common.util.ItemUtils;
import team.reborn.energy.Energy;
import team.reborn.energy.EnergyHolder;
import team.reborn.energy.EnergyTier;
import techreborn.items.armor.TRArmourItem;
import techreborn.utils.InitUtils;

public class NanoSuitItem extends TRArmourItem implements EnergyHolder, ItemStackModifiers, ArmorTickable {
    public NanoSuitItem(ArmorMaterial material, ArmorEquipmentType slot, CompatibleItemSettings settings) {
        super(material, slot.getSlot(), settings.build());

        ApplyArmorToDamageCallback.EVENT.register(((player, source, amount) -> {
            for (ItemStack stack : player.getArmorItems()) {
                if (!(stack.getItem() instanceof NanoSuitItem)) {
                    continue;
                }
                double stackEnergy = Energy.of(stack).getEnergy();
                if (stackEnergy == 0) {
                    continue;
                }
                double damageToAbsorb = Math.min(stackEnergy, amount * 2500);
                Energy.of(stack).use(damageToAbsorb);
            }
            return amount;
        }));
    }

    @Override
    public double getMaxStoredPower() {
        return 1_000_000;
    }

    @Override
    public EnergyTier getTier() {
        return EnergyTier.EXTREME;
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return false;
    }

    @Override
    public double getDurability(ItemStack stack) {
        return ItemUtils.getPowerForDurabilityBar(stack);
    }

    @Override
    public boolean showDurability(ItemStack stack) {
        return true;
    }

    @Override
    public int getDurabilityColor(ItemStack stack) {
        return PowerSystem.getDisplayPower().colour;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    public void appendStacks(ItemGroup group, DefaultedList<ItemStack> itemList) {
        if (!isIn(group)) {
            return;
        }
        InitUtils.initPoweredItems(this, itemList);
    }

    public void getAttributeModifiers(EquipmentSlot equipmentSlot, ItemStack stack, Multimap<EntityAttribute, EntityAttributeModifier> attributes) {
        if (equipmentSlot == this.slot && Energy.of(stack).getEnergy() > 0) {
            attributes.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(MODIFIERS[slot.getEntitySlotId()], "Armor modifier", 2, EntityAttributeModifier.Operation.ADDITION));
        } else if (equipmentSlot == this.slot) {
            attributes.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(MODIFIERS[slot.getEntitySlotId()], "Armor modifier", -1, EntityAttributeModifier.Operation.ADDITION));
        }
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return HashMultimap.create();
    }

    public void tickArmor(ItemStack stack, PlayerEntity player) {
        if (stack.getItem().equals(Items.NANO_SUIT_HELMET)) {
            if (Energy.of(stack).getEnergy() > 0) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 300, 3));
            }
        }
    }
}
