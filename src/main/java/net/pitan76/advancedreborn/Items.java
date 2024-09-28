package net.pitan76.advancedreborn;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.pitan76.advancedreborn.armormaterials.BBArmorMaterial;
import net.pitan76.advancedreborn.items.*;
import net.pitan76.mcpitanlib.api.item.CompatibleItemSettings;
import net.pitan76.mcpitanlib.api.item.ExtendItem;
import net.pitan76.mcpitanlib.api.registry.result.RegistryResult;
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
    //public static Item FORGE_HAMMER;
    //public static Item ADVANCED_FORGE_HAMMER;

    static {
        // 実装しないでおく
        //FORGE_HAMMER = new ForgeHammer(nothingSettings.recipeRemainder(FORGE_HAMMER), 80);
        //ADVANCED_FORGE_HAMMER = new ForgeHammer(nothingSettings.recipeRemainder(ADVANCED_FORGE_HAMMER), 360);
    }

    // 実装しない
    /*
    public static RegistryResult<Item> NANO_SUIT_HELMET;
    public static RegistryResult<Item> NANO_SUIT_BODY_ARMOR;
    public static RegistryResult<Item> NANO_SUIT_LEGGINGS;
    public static RegistryResult<Item> NANO_SUIT_BOOTS;

     */

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
        CHARGE_PAD_MK_1 = registry.registerItem(INSTANCE.compatId("charge_pad"), () -> ItemUtil.ofBlock(Blocks.CHARGE_PAD_MK_1.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        CHARGE_PAD_MK_2 = registry.registerItem(INSTANCE.compatId("charge_pad_2"), () -> ItemUtil.ofBlock(Blocks.CHARGE_PAD_MK_2.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        CHARGE_PAD_MK_3 = registry.registerItem(INSTANCE.compatId("charge_pad_3"), () -> ItemUtil.ofBlock(Blocks.CHARGE_PAD_MK_3.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        CHARGE_PAD_MK_4 = registry.registerItem(INSTANCE.compatId("charge_pad_4"), () -> ItemUtil.ofBlock(Blocks.CHARGE_PAD_MK_4.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        CHARGE_PAD_MK_FINAL = registry.registerItem(INSTANCE.compatId("charge_pad_final"), () -> ItemUtil.ofBlock(Blocks.CHARGE_PAD_MK_FINAL.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RAY_SOLAR_1 = registry.registerItem(INSTANCE.compatId("ray_solar_panel"), () -> ItemUtil.ofBlock(Blocks.RAY_SOLAR_1.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RAY_SOLAR_2 = registry.registerItem(INSTANCE.compatId("ray_solar_panel_2"), () -> ItemUtil.ofBlock(Blocks.RAY_SOLAR_2.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RAY_SOLAR_3 = registry.registerItem(INSTANCE.compatId("ray_solar_panel_3"), () -> ItemUtil.ofBlock(Blocks.RAY_SOLAR_3.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RAY_SOLAR_4 = registry.registerItem(INSTANCE.compatId("ray_solar_panel_4"), () -> ItemUtil.ofBlock(Blocks.RAY_SOLAR_4.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RAY_GENERATOR_1 = registry.registerItem(INSTANCE.compatId("ray_generator"), () -> ItemUtil.ofBlock(Blocks.RAY_GENERATOR_1.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RAY_GENERATOR_2 = registry.registerItem(INSTANCE.compatId("ray_generator_2"), () -> ItemUtil.ofBlock(Blocks.RAY_GENERATOR_2.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RAY_GENERATOR_3 = registry.registerItem(INSTANCE.compatId("ray_generator_3"), () -> ItemUtil.ofBlock(Blocks.RAY_GENERATOR_3.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RAY_GENERATOR_4 = registry.registerItem(INSTANCE.compatId("ray_generator_4"), () -> ItemUtil.ofBlock(Blocks.RAY_GENERATOR_4.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RAY_GENERATOR_5 = registry.registerItem(INSTANCE.compatId("ray_generator_5"), () -> ItemUtil.ofBlock(Blocks.RAY_GENERATOR_5.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RAY_GENERATOR_6 = registry.registerItem(INSTANCE.compatId("ray_generator_6"), () -> ItemUtil.ofBlock(Blocks.RAY_GENERATOR_6.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RAY_GENERATOR_7 = registry.registerItem(INSTANCE.compatId("ray_generator_7"), () -> ItemUtil.ofBlock(Blocks.RAY_GENERATOR_7.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RAY_GENERATOR_8 = registry.registerItem(INSTANCE.compatId("ray_generator_8"), () -> ItemUtil.ofBlock(Blocks.RAY_GENERATOR_8.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RAY_GENERATOR_9 = registry.registerItem(INSTANCE.compatId("ray_generator_9"), () -> ItemUtil.ofBlock(Blocks.RAY_GENERATOR_9.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RAY_GENERATOR_10 = registry.registerItem(INSTANCE.compatId("ray_generator_10"), () -> ItemUtil.ofBlock(Blocks.RAY_GENERATOR_10.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        INDUCTION_FURNACE = registry.registerItem(INSTANCE.compatId("induction_furnace"), () -> ItemUtil.ofBlock(Blocks.INDUCTION_FURNACE.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        ROTARY_GRINDER = registry.registerItem(INSTANCE.compatId("rotary_grinder"), () -> ItemUtil.ofBlock(Blocks.ROTARY_GRINDER.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        CENTRIFUGAL_EXTRACTOR = registry.registerItem(INSTANCE.compatId("centrifugal_extractor"), () -> ItemUtil.ofBlock(Blocks.CENTRIFUGAL_EXTRACTOR.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        SINGULARITY_COMPRESSOR = registry.registerItem(INSTANCE.compatId("singularity_compressor"), () -> ItemUtil.ofBlock(Blocks.SINGULARITY_COMPRESSOR.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        CANNING_MACHINE = registry.registerItem(INSTANCE.compatId("canning_machine"), () -> ItemUtil.ofBlock(Blocks.CANNING_MACHINE.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        RENAMING_MACHINE = registry.registerItem(INSTANCE.compatId("renaming_machine"), () -> ItemUtil.ofBlock(Blocks.RENAMING_MACHINE.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        TELEPORTER = registry.registerItem(INSTANCE.compatId("teleporter"), () -> ItemUtil.ofBlock(Blocks.TELEPORTER.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        FARMING_MACHINE = registry.registerItem(INSTANCE.compatId("farming_machine"), () -> ItemUtil.ofBlock(Blocks.FARMING_MACHINE.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        LOGGING_MACHINE = registry.registerItem(INSTANCE.compatId("logging_machine"), () -> ItemUtil.ofBlock(Blocks.LOGGING_MACHINE.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        FERTILIZER_SPREADER = registry.registerItem(INSTANCE.compatId("fertilizer_spreader"), () -> ItemUtil.ofBlock(Blocks.FERTILIZER_SPREADER.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        ENCHANTMENT_EXTRACTOR = registry.registerItem(INSTANCE.compatId("enchantment_extractor"), () -> ItemUtil.ofBlock(Blocks.ENCHANTMENT_EXTRACTOR.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        FREQ_TRANS = registry.registerItem(INSTANCE.compatId("freq_trans"), () -> new FreqTrans(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1)));
        CONFIG_WRENCH = registry.registerItem(INSTANCE.compatId("config_wrench"), () -> new ConfigWrench(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1)));
        /*
        NANO_SUIT_HELMET = registry.registerItem(INSTANCE.compatId("nano_suit_helmet"), () -> new NanoSuitItem(NanoArmorMaterial.NANO, ArmorEquipmentType.HEAD, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1)));
        NANO_SUIT_BODY_ARMOR = registry.registerItem(INSTANCE.compatId("nano_suit_body_armor"), () -> new NanoSuitItem(NanoArmorMaterial.NANO, ArmorEquipmentType.CHEST, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1)));
        NANO_SUIT_LEGGINGS = registry.registerItem(INSTANCE.compatId("nano_suit_leggings"), () -> new NanoSuitItem(NanoArmorMaterial.NANO, ArmorEquipmentType.LEGS, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1)));
        NANO_SUIT_BOOTS = registry.registerItem(INSTANCE.compatId("nano_suit_boots"), () -> new NanoSuitItem(NanoArmorMaterial.NANO, ArmorEquipmentType.FEET, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1)));

         */
        ADVANCED_BATTERY = registry.registerItem(INSTANCE.compatId("advanced_battery"), () -> new AdvancedBattery(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1), 8 * TechRebornConfig.redCellBatteryMaxCharge, RcEnergyTier.HIGH));
        ADVANCED_BATTERY_2 = registry.registerItem(INSTANCE.compatId("advanced_battery_2"), () -> new AdvancedBattery(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1), 64 * TechRebornConfig.redCellBatteryMaxCharge, RcEnergyTier.HIGH));
        ADVANCED_BATTERY_3 = registry.registerItem(INSTANCE.compatId("advanced_battery_3"), () -> new AdvancedBattery(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1), 512 * TechRebornConfig.redCellBatteryMaxCharge, RcEnergyTier.HIGH));
        ADVANCED_BATTERY_4 = registry.registerItem(INSTANCE.compatId("advanced_battery_4"), () -> new AdvancedBattery(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1), 4096 * TechRebornConfig.redCellBatteryMaxCharge, RcEnergyTier.HIGH));
        ADVANCED_BATTERY_5 = registry.registerItem(INSTANCE.compatId("advanced_battery_5"), () -> new AdvancedBattery(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1), 32768 * TechRebornConfig.redCellBatteryMaxCharge, RcEnergyTier.EXTREME));
        DYNAMITE = registry.registerItem(INSTANCE.compatId("dynamite"), () -> new Dynamite(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        STICKY_DYNAMITE = registry.registerItem(INSTANCE.compatId("sticky_dynamite"), () -> new Dynamite(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64),true));
        INDUSTRIAL_DYNAMITE = registry.registerItem(INSTANCE.compatId("industrial_dynamite"), () -> new Dynamite(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64),false, true));
        INDUSTRIAL_STICKY_DYNAMITE = registry.registerItem(INSTANCE.compatId("industrial_sticky_dynamite"), () -> new Dynamite(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64),true, true));
        INDUSTRIAL_TNT = registry.registerItem(INSTANCE.compatId("industrial_tnt"), () -> ItemUtil.ofBlock(Blocks.INDUSTRIAL_TNT.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        LIGHT = registry.registerItem(INSTANCE.compatId("light"), () -> ItemUtil.ofBlock(Blocks.LIGHT.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        CARDBOARD_BOX = registry.registerItem(INSTANCE.compatId("cardboard_box"), () -> ItemUtil.ofBlock(Blocks.CARDBOARD_BOX.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        CARDBOARD_BOX_MINETARO = registry.registerItem(INSTANCE.compatId("cardboard_box_minetaro"), () -> ItemUtil.ofBlock(Blocks.CARDBOARD_BOX_MINETARO.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        CARDBOARD_BOX_MINEZON = registry.registerItem(INSTANCE.compatId("cardboard_box_minezon"), () -> ItemUtil.ofBlock(Blocks.CARDBOARD_BOX_MINEZON.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        CARDBOARD_BOX_NOTHING = registry.registerItem(INSTANCE.compatId("cardboard_box_nothing_logo"), () -> ItemUtil.ofBlock(Blocks.CARDBOARD_BOX_NOTHING.getOrNull(),  CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        EMPTY_CAN = registry.registerItem(INSTANCE.compatId("empty_can"), () -> new ExtendItem(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        FUEL_CAN = registry.registerItem(INSTANCE.compatId("fuel_can"), () -> new FuelCanItem(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64).recipeRemainder(EMPTY_CAN.getOrNull())));
        FOOD_CAN = registry.registerItem(INSTANCE.compatId("food_can"), () -> new FoodCanItem(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64).recipeRemainder(EMPTY_CAN.getOrNull()).food(CAN_FOOD_COMPONENT)));
        BATPACK_4 = registry.registerItem(CompatIdentifier.of("better_batpack", "batpack_4"), () -> new BetterBatpackItem(TechRebornConfig.lithiumBatpackCharge * 4, new BBArmorMaterial("batpack4"), RcEnergyTier.MEDIUM));
        BATPACK_16 = registry.registerItem(CompatIdentifier.of("better_batpack", "batpack_16"), () -> new BetterBatpackItem(TechRebornConfig.lithiumBatpackCharge * 16, new BBArmorMaterial("batpack16"), RcEnergyTier.HIGH));
        BATPACK_64 = registry.registerItem(CompatIdentifier.of("better_batpack", "batpack_64"), () -> new BetterBatpackItem(TechRebornConfig.lithiumBatpackCharge * 64, new BBArmorMaterial("batpack64"), RcEnergyTier.EXTREME));
        BATPACK_128 = registry.registerItem(CompatIdentifier.of("better_batpack", "batpack_128"), () -> new BetterBatpackItem(TechRebornConfig.lithiumBatpackCharge * 128, new BBArmorMaterial("batpack128"), RcEnergyTier.INSANE));
        DUCT_TAPE = registry.registerItem(INSTANCE.compatId("duct_tape"), () -> new ExtendItem(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
        CARDBOARD_SHEET = registry.registerItem(INSTANCE.compatId("cardboard_sheet"), () -> new ExtendItem(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));

        //ADD_ITEMS = registry.registerItem(INSTANCE.compatId("add_items"), () -> new AddItems(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64)));
    }
}
