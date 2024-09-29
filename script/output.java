package net.pitan76.advancedreborn;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.pitan76.advancedreborn.armormaterials.BBArmorMaterial;
import net.pitan76.advancedreborn.armormaterials.NanoArmorMaterial;
import net.pitan76.advancedreborn.items.*;
import net.pitan76.mcpitanlib.api.item.ArmorEquipmentType;
import net.pitan76.mcpitanlib.api.item.CompatibleItemSettings;
import net.pitan76.mcpitanlib.api.item.ExtendItem;
import net.pitan76.mcpitanlib.api.util.CompatIdentifier;
import net.pitan76.mcpitanlib.api.util.ItemUtil;
import reborncore.common.powerSystem.RcEnergyTier;
import techreborn.config.TechRebornConfig;

import static net.pitan76.advancedreborn.AdvancedReborn.INSTANCE;
import static net.pitan76.advancedreborn.AdvancedReborn.registry;

public class Items {
    public static CompatibleItemSettings nothingSettings = CompatibleItemSettings.of();

    public static RegistryResult<Item> CHARGE_PAD_MK_1;
    public static RegistryResult<Item> CHARGE_PAD_MK_2;
    public static RegistryResult<Item> CHARGE_PAD_MK_3;
    public static RegistryResult<Item> CHARGE_PAD_MK_4;
    public static RegistryResult<Item> CHARGE_PAD_MK_FINAL;

    public static RegistryResult<Item> RAY_SOLAR_1;
    public static RegistryResult<Item> RAY_SOLAR_2;
    public static RegistryResult<Item> RAY_SOLAR_3;
    public static RegistryResult<Item> RAY_SOLAR_4;
    public static RegistryResult<Item> RAY_GENERATOR_1;
    public static RegistryResult<Item> RAY_GENERATOR_2;
    public static RegistryResult<Item> RAY_GENERATOR_3;
    public static RegistryResult<Item> RAY_GENERATOR_4;
    public static RegistryResult<Item> RAY_GENERATOR_5;
    public static RegistryResult<Item> RAY_GENERATOR_6;
    public static RegistryResult<Item> RAY_GENERATOR_7;
    public static RegistryResult<Item> RAY_GENERATOR_8;
    public static RegistryResult<Item> RAY_GENERATOR_9;
    public static RegistryResult<Item> RAY_GENERATOR_10;

    public static RegistryResult<Item> INDUCTION_FURNACE;
    public static RegistryResult<Item> ROTARY_GRINDER;
    public static RegistryResult<Item> CENTRIFUGAL_EXTRACTOR;
    public static RegistryResult<Item> SINGULARITY_COMPRESSOR;
    public static RegistryResult<Item> CANNING_MACHINE;
    public static RegistryResult<Item> RENAMING_MACHINE;
    public static RegistryResult<Item> TELEPORTER;
    public static RegistryResult<Item> FARMING_MACHINE;
    public static RegistryResult<Item> LOGGING_MACHINE;
    public static RegistryResult<Item> FERTILIZER_SPREADER;
    public static RegistryResult<Item> ENCHANTMENT_EXTRACTOR;

    public static RegistryResult<Item> FREQ_TRANS;
    public static RegistryResult<Item> CONFIG_WRENCH;
    public static Item FORGE_HAMMER;
    public static Item ADVANCED_FORGE_HAMMER;

    static {
        // 実装しないでおく
        FORGE_HAMMER = new ForgeHammer(nothingSettings.recipeRemainder(FORGE_HAMMER), 80);
        ADVANCED_FORGE_HAMMER = new ForgeHammer(nothingSettings.recipeRemainder(ADVANCED_FORGE_HAMMER), 360);
    }

    // 実装しない
    public static RegistryResult<Item> NANO_SUIT_HELMET;
    public static RegistryResult<Item> NANO_SUIT_BODY_ARMOR;
    public static RegistryResult<Item> NANO_SUIT_LEGGINGS;
    public static RegistryResult<Item> NANO_SUIT_BOOTS;

    // 強化バッテリー
    public static RegistryResult<Item> ADVANCED_BATTERY;
    public static RegistryResult<Item> ADVANCED_BATTERY_2;
    public static RegistryResult<Item> ADVANCED_BATTERY_3;
    public static RegistryResult<Item> ADVANCED_BATTERY_4;
    public static RegistryResult<Item> ADVANCED_BATTERY_5;

    // ダイナマイト (予定: 時限爆弾)
    public static RegistryResult<Item> DYNAMITE;
    public static RegistryResult<Item> STICKY_DYNAMITE;
    public static RegistryResult<Item> INDUSTRIAL_DYNAMITE;
    public static RegistryResult<Item> INDUSTRIAL_STICKY_DYNAMITE;
    public static RegistryResult<Item> INDUSTRIAL_TNT;

    // ライト、足場(鉄) 強化石材  ネーミングマシン
    public static RegistryResult<Item> LIGHT;

    public static RegistryResult<Item> CARDBOARD_BOX;
    public static RegistryResult<Item> CARDBOARD_BOX_MINETARO;
    public static RegistryResult<Item> CARDBOARD_BOX_MINEZON;
    public static RegistryResult<Item> CARDBOARD_BOX_NOTHING;

    // 缶
    public static RegistryResult<Item> EMPTY_CAN;
    public static RegistryResult<Item> FUEL_CAN;

    public static FoodComponent CAN_FOOD_COMPONENT = new FoodComponent.Builder().snack().nutrition(2).saturationModifier(2).build();
    public static RegistryResult<Item> FOOD_CAN;

    // Better Batpack
    public static RegistryResult<Item> BATPACK_4;
    public static RegistryResult<Item> BATPACK_16;
    public static RegistryResult<Item> BATPACK_64;
    public static RegistryResult<Item> BATPACK_128;



    // 素材アイテム
    public static RegistryResult<Item> DUCT_TAPE;
    public static RegistryResult<Item> CARDBOARD_SHEET;

    //public static RegistryResult<Item> ADD_ITEMS;

    public static void init() {
        CHARGE_PAD_MK_1 = registry.registerItem(INSTANCE.compatId("CHARGE_PAD_MK_1"), () -> ItemUtil.ofBlock(Blocks.CHARGE_PAD_MK_1, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        CHARGE_PAD_MK_2 = registry.registerItem(INSTANCE.compatId("CHARGE_PAD_MK_2"), () -> ItemUtil.ofBlock(Blocks.CHARGE_PAD_MK_2, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        CHARGE_PAD_MK_3 = registry.registerItem(INSTANCE.compatId("CHARGE_PAD_MK_3"), () -> ItemUtil.ofBlock(Blocks.CHARGE_PAD_MK_3, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        CHARGE_PAD_MK_4 = registry.registerItem(INSTANCE.compatId("CHARGE_PAD_MK_4"), () -> ItemUtil.ofBlock(Blocks.CHARGE_PAD_MK_4, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        CHARGE_PAD_MK_FINAL = registry.registerItem(INSTANCE.compatId("CHARGE_PAD_MK_FINAL"), () -> ItemUtil.ofBlock(Blocks.CHARGE_PAD_MK_FINAL, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RAY_SOLAR_1 = registry.registerItem(INSTANCE.compatId("RAY_SOLAR_1"), () -> ItemUtil.ofBlock(Blocks.RAY_SOLAR_1, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RAY_SOLAR_2 = registry.registerItem(INSTANCE.compatId("RAY_SOLAR_2"), () -> ItemUtil.ofBlock(Blocks.RAY_SOLAR_2, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RAY_SOLAR_3 = registry.registerItem(INSTANCE.compatId("RAY_SOLAR_3"), () -> ItemUtil.ofBlock(Blocks.RAY_SOLAR_3, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RAY_SOLAR_4 = registry.registerItem(INSTANCE.compatId("RAY_SOLAR_4"), () -> ItemUtil.ofBlock(Blocks.RAY_SOLAR_4, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RAY_GENERATOR_1 = registry.registerItem(INSTANCE.compatId("RAY_GENERATOR_1"), () -> ItemUtil.ofBlock(Blocks.RAY_GENERATOR_1, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RAY_GENERATOR_2 = registry.registerItem(INSTANCE.compatId("RAY_GENERATOR_2"), () -> ItemUtil.ofBlock(Blocks.RAY_GENERATOR_2, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RAY_GENERATOR_3 = registry.registerItem(INSTANCE.compatId("RAY_GENERATOR_3"), () -> ItemUtil.ofBlock(Blocks.RAY_GENERATOR_3, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RAY_GENERATOR_4 = registry.registerItem(INSTANCE.compatId("RAY_GENERATOR_4"), () -> ItemUtil.ofBlock(Blocks.RAY_GENERATOR_4, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RAY_GENERATOR_5 = registry.registerItem(INSTANCE.compatId("RAY_GENERATOR_5"), () -> ItemUtil.ofBlock(Blocks.RAY_GENERATOR_5, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RAY_GENERATOR_6 = registry.registerItem(INSTANCE.compatId("RAY_GENERATOR_6"), () -> ItemUtil.ofBlock(Blocks.RAY_GENERATOR_6, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RAY_GENERATOR_7 = registry.registerItem(INSTANCE.compatId("RAY_GENERATOR_7"), () -> ItemUtil.ofBlock(Blocks.RAY_GENERATOR_7, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RAY_GENERATOR_8 = registry.registerItem(INSTANCE.compatId("RAY_GENERATOR_8"), () -> ItemUtil.ofBlock(Blocks.RAY_GENERATOR_8, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RAY_GENERATOR_9 = registry.registerItem(INSTANCE.compatId("RAY_GENERATOR_9"), () -> ItemUtil.ofBlock(Blocks.RAY_GENERATOR_9, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RAY_GENERATOR_10 = registry.registerItem(INSTANCE.compatId("RAY_GENERATOR_10"), () -> ItemUtil.ofBlock(Blocks.RAY_GENERATOR_10, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        INDUCTION_FURNACE = registry.registerItem(INSTANCE.compatId("INDUCTION_FURNACE"), () -> ItemUtil.ofBlock(Blocks.INDUCTION_FURNACE, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        ROTARY_GRINDER = registry.registerItem(INSTANCE.compatId("ROTARY_GRINDER"), () -> ItemUtil.ofBlock(Blocks.ROTARY_GRINDER, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        CENTRIFUGAL_EXTRACTOR = registry.registerItem(INSTANCE.compatId("CENTRIFUGAL_EXTRACTOR"), () -> ItemUtil.ofBlock(Blocks.CENTRIFUGAL_EXTRACTOR, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        SINGULARITY_COMPRESSOR = registry.registerItem(INSTANCE.compatId("SINGULARITY_COMPRESSOR"), () -> ItemUtil.ofBlock(Blocks.SINGULARITY_COMPRESSOR, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        CANNING_MACHINE = registry.registerItem(INSTANCE.compatId("CANNING_MACHINE"), () -> ItemUtil.ofBlock(Blocks.CANNING_MACHINE, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RENAMING_MACHINE = registry.registerItem(INSTANCE.compatId("RENAMING_MACHINE"), () -> ItemUtil.ofBlock(Blocks.RENAMING_MACHINE, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        TELEPORTER = registry.registerItem(INSTANCE.compatId("TELEPORTER"), () -> ItemUtil.ofBlock(Blocks.TELEPORTER, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        FARMING_MACHINE = registry.registerItem(INSTANCE.compatId("FARMING_MACHINE"), () -> ItemUtil.ofBlock(Blocks.FARMING_MACHINE, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        LOGGING_MACHINE = registry.registerItem(INSTANCE.compatId("LOGGING_MACHINE"), () -> ItemUtil.ofBlock(Blocks.LOGGING_MACHINE, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        FERTILIZER_SPREADER = registry.registerItem(INSTANCE.compatId("FERTILIZER_SPREADER"), () -> ItemUtil.ofBlock(Blocks.FERTILIZER_SPREADER, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        ENCHANTMENT_EXTRACTOR = registry.registerItem(INSTANCE.compatId("ENCHANTMENT_EXTRACTOR"), () -> ItemUtil.ofBlock(Blocks.ENCHANTMENT_EXTRACTOR, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        FREQ_TRANS = registry.registerItem(INSTANCE.compatId("FREQ_TRANS"), () -> new FreqTrans(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1)));
        CONFIG_WRENCH = registry.registerItem(INSTANCE.compatId("CONFIG_WRENCH"), () -> new ConfigWrench(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1)));
        NANO_SUIT_HELMET = registry.registerItem(INSTANCE.compatId("NANO_SUIT_HELMET"), () -> new NanoSuitItem(NanoArmorMaterial.NANO, ArmorEquipmentType.HEAD, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1)));
        NANO_SUIT_BODY_ARMOR = registry.registerItem(INSTANCE.compatId("NANO_SUIT_BODY_ARMOR"), () -> new NanoSuitItem(NanoArmorMaterial.NANO, ArmorEquipmentType.CHEST, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1)));
        NANO_SUIT_LEGGINGS = registry.registerItem(INSTANCE.compatId("NANO_SUIT_LEGGINGS"), () -> new NanoSuitItem(NanoArmorMaterial.NANO, ArmorEquipmentType.LEGS, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1)));
        NANO_SUIT_BOOTS = registry.registerItem(INSTANCE.compatId("NANO_SUIT_BOOTS"), () -> new NanoSuitItem(NanoArmorMaterial.NANO, ArmorEquipmentType.FEET, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1)));
        ADVANCED_BATTERY = registry.registerItem(INSTANCE.compatId("ADVANCED_BATTERY"), () -> new AdvancedBattery(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1), 8 * TechRebornConfig.redCellBatteryMaxCharge, RcEnergyTier.HIGH));
        ADVANCED_BATTERY_2 = registry.registerItem(INSTANCE.compatId("ADVANCED_BATTERY_2"), () -> new AdvancedBattery(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1), 64 * TechRebornConfig.redCellBatteryMaxCharge, RcEnergyTier.HIGH));
        ADVANCED_BATTERY_3 = registry.registerItem(INSTANCE.compatId("ADVANCED_BATTERY_3"), () -> new AdvancedBattery(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1), 512 * TechRebornConfig.redCellBatteryMaxCharge, RcEnergyTier.HIGH));
        ADVANCED_BATTERY_4 = registry.registerItem(INSTANCE.compatId("ADVANCED_BATTERY_4"), () -> new AdvancedBattery(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1), 4096 * TechRebornConfig.redCellBatteryMaxCharge, RcEnergyTier.HIGH));
        ADVANCED_BATTERY_5 = registry.registerItem(INSTANCE.compatId("ADVANCED_BATTERY_5"), () -> new AdvancedBattery(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1), 32768 * TechRebornConfig.redCellBatteryMaxCharge, RcEnergyTier.EXTREME));
        DYNAMITE = registry.registerItem(INSTANCE.compatId("DYNAMITE"), () -> new Dynamite(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        STICKY_DYNAMITE = registry.registerItem(INSTANCE.compatId("STICKY_DYNAMITE"), () -> new Dynamite(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64),true));
        INDUSTRIAL_DYNAMITE = registry.registerItem(INSTANCE.compatId("INDUSTRIAL_DYNAMITE"), () -> new Dynamite(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64),false, true));
        INDUSTRIAL_STICKY_DYNAMITE = registry.registerItem(INSTANCE.compatId("INDUSTRIAL_STICKY_DYNAMITE"), () -> new Dynamite(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64),true, true));
        INDUSTRIAL_TNT = registry.registerItem(INSTANCE.compatId("INDUSTRIAL_TNT"), () -> ItemUtil.ofBlock(Blocks.INDUSTRIAL_TNT, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        LIGHT = registry.registerItem(INSTANCE.compatId("LIGHT"), () -> ItemUtil.ofBlock(Blocks.LIGHT, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        CARDBOARD_BOX = registry.registerItem(INSTANCE.compatId("CARDBOARD_BOX"), () -> ItemUtil.ofBlock(Blocks.CARDBOARD_BOX, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        CARDBOARD_BOX_MINETARO = registry.registerItem(INSTANCE.compatId("CARDBOARD_BOX_MINETARO"), () -> ItemUtil.ofBlock(Blocks.CARDBOARD_BOX_MINETARO, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        CARDBOARD_BOX_MINEZON = registry.registerItem(INSTANCE.compatId("CARDBOARD_BOX_MINEZON"), () -> ItemUtil.ofBlock(Blocks.CARDBOARD_BOX_MINEZON, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        CARDBOARD_BOX_NOTHING = registry.registerItem(INSTANCE.compatId("cardboard_box_nothing_logo"), () -> ItemUtil.ofBlock(Blocks.CARDBOARD_BOX_NOTHING, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        EMPTY_CAN = registry.registerItem(INSTANCE.compatId("EMPTY_CAN"), () -> new ExtendItem(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        FUEL_CAN = registry.registerItem(INSTANCE.compatId("FUEL_CAN"), () -> new FuelCanItem(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64).recipeRemainder(EMPTY_CAN)));
        FOOD_CAN = registry.registerItem(INSTANCE.compatId("FOOD_CAN"), () -> new FoodCanItem(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64).recipeRemainder(EMPTY_CAN).food(CAN_FOOD_COMPONENT)));
        BATPACK_4 = registry.registerItem(INSTANCE.compatId("BATPACK_4"), () -> new BetterBatpackItem(TechRebornConfig.lithiumBatpackCharge * 4, new BBArmorMaterial("batpack4"), RcEnergyTier.MEDIUM));
        BATPACK_16 = registry.registerItem(INSTANCE.compatId("BATPACK_16"), () -> new BetterBatpackItem(TechRebornConfig.lithiumBatpackCharge * 16, new BBArmorMaterial("batpack16"), RcEnergyTier.HIGH));
        BATPACK_64 = registry.registerItem(INSTANCE.compatId("BATPACK_64"), () -> new BetterBatpackItem(TechRebornConfig.lithiumBatpackCharge * 64, new BBArmorMaterial("batpack64"), RcEnergyTier.EXTREME));
        BATPACK_128 = registry.registerItem(INSTANCE.compatId("BATPACK_128"), () -> new BetterBatpackItem(TechRebornConfig.lithiumBatpackCharge * 128, new BBArmorMaterial("batpack128"), RcEnergyTier.INSANE));
        DUCT_TAPE = registry.registerItem(INSTANCE.compatId("DUCT_TAPE"), () -> new ExtendItem(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        CARDBOARD_SHEET = registry.registerItem(INSTANCE.compatId("CARDBOARD_SHEET"), () -> new ExtendItem(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        ADD_ITEMS = registry.registerItem(INSTANCE.compatId("ADD_ITEMS"), () -> new AddItems(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));

    }
}
