package ml.pkom.advancedreborn;

import ml.pkom.advancedreborn.armormaterials.BBArmorMaterial;
import ml.pkom.advancedreborn.armormaterials.NanoArmorMaterial;
import ml.pkom.advancedreborn.items.*;
import ml.pkom.mcpitanlibarch.api.item.ExtendSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import reborncore.common.powerSystem.RcEnergyTier;
import techreborn.config.TechRebornConfig;

public class Items {
    public static Item.Settings nothingSettings = new ExtendSettings();

    public static Item CHARGE_PAD_MK_1 = new BlockItem(Blocks.CHARGE_PAD_MK_1, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("charge_pad")).maxCount(64));
    public static Item CHARGE_PAD_MK_2 = new BlockItem(Blocks.CHARGE_PAD_MK_2, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("charge_pad_2")).maxCount(64));
    public static Item CHARGE_PAD_MK_3 = new BlockItem(Blocks.CHARGE_PAD_MK_3, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("charge_pad_3")).maxCount(64));
    public static Item CHARGE_PAD_MK_4 = new BlockItem(Blocks.CHARGE_PAD_MK_4, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("charge_pad_4")).maxCount(64));
    public static Item CHARGE_PAD_MK_FINAL = new BlockItem(Blocks.CHARGE_PAD_MK_FINAL, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("charge_pad_final")).maxCount(64));

    public static Item RAY_SOLAR_1 = new BlockItem(Blocks.RAY_SOLAR_1, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("ray_solar_panel")).maxCount(64));
    public static Item RAY_SOLAR_2 = new BlockItem(Blocks.RAY_SOLAR_2, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("ray_solar_panel_2")).maxCount(64));
    public static Item RAY_SOLAR_3 = new BlockItem(Blocks.RAY_SOLAR_3, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("ray_solar_panel_3")).maxCount(64));
    public static Item RAY_SOLAR_4 = new BlockItem(Blocks.RAY_SOLAR_4, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("ray_solar_panel_4")).maxCount(64));
    public static Item RAY_GENERATOR_1 = new BlockItem(Blocks.RAY_GENERATOR_1, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("ray_generator")).maxCount(64));
    public static Item RAY_GENERATOR_2 = new BlockItem(Blocks.RAY_GENERATOR_2, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("ray_generator_2")).maxCount(64));
    public static Item RAY_GENERATOR_3 = new BlockItem(Blocks.RAY_GENERATOR_3, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("ray_generator_3")).maxCount(64));
    public static Item RAY_GENERATOR_4 = new BlockItem(Blocks.RAY_GENERATOR_4, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("ray_generator_4")).maxCount(64));
    public static Item RAY_GENERATOR_5 = new BlockItem(Blocks.RAY_GENERATOR_5, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("ray_generator_5")).maxCount(64));
    public static Item RAY_GENERATOR_6 = new BlockItem(Blocks.RAY_GENERATOR_6, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("ray_generator_6")).maxCount(64));
    public static Item RAY_GENERATOR_7 = new BlockItem(Blocks.RAY_GENERATOR_7, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("ray_generator_7")).maxCount(64));
    public static Item RAY_GENERATOR_8 = new BlockItem(Blocks.RAY_GENERATOR_8, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("ray_generator_8")).maxCount(64));
    public static Item RAY_GENERATOR_9 = new BlockItem(Blocks.RAY_GENERATOR_9, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("ray_generator_9")).maxCount(64));
    public static Item RAY_GENERATOR_10 = new BlockItem(Blocks.RAY_GENERATOR_10, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("ray_generator_10")).maxCount(64));

    public static Item INDUCTION_FURNACE = new BlockItem(Blocks.INDUCTION_FURNACE, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("induction_furnace")).maxCount(64));
    public static Item ROTARY_GRINDER = new BlockItem(Blocks.ROTARY_GRINDER, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("rotary_grinder")).maxCount(64));
    public static Item CENTRIFUGAL_EXTRACTOR = new BlockItem(Blocks.CENTRIFUGAL_EXTRACTOR, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("centrifugal_extractor")).maxCount(64));
    public static Item SINGULARITY_COMPRESSOR = new BlockItem(Blocks.SINGULARITY_COMPRESSOR, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("singularity_compressor")).maxCount(64));
    public static Item CANNING_MACHINE = new BlockItem(Blocks.CANNING_MACHINE, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("canning_machine")).maxCount(64));
    public static Item RENAMING_MACHINE = new BlockItem(Blocks.RENAMING_MACHINE, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("renaming_machine")).maxCount(64));
    public static Item TELEPORTER = new BlockItem(Blocks.TELEPORTER, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("teleporter")).maxCount(64));
    public static Item FARMING_MACHINE = new BlockItem(Blocks.FARMING_MACHINE, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("farming_machine")).maxCount(64));
    public static Item LOGGING_MACHINE = new BlockItem(Blocks.LOGGING_MACHINE, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("logging_machine")).maxCount(64));
    public static Item FERTILIZER_SPREADER = new BlockItem(Blocks.FERTILIZER_SPREADER, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("fertilizer_spreader")).maxCount(64));
    public static Item ENCHANTMENT_EXTRACTOR = new BlockItem(Blocks.ENCHANTMENT_EXTRACTOR, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("enchantment_extractor")).maxCount(64));

    public static Item FREQ_TRANS = new FreqTrans(new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("freq_trans")).maxCount(1).maxDamage(-1));
    public static Item CONFIG_WRENCH = new ConfigWrench(new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("config_wrench")).maxCount(1).maxDamage(-1));
    public static Item FORGE_HAMMER;
    public static Item ADVANCED_FORGE_HAMMER;

    static {
        // 実装しないでおく
        FORGE_HAMMER = new ForgeHammer(nothingSettings.recipeRemainder(FORGE_HAMMER), 80);
        ADVANCED_FORGE_HAMMER = new ForgeHammer(nothingSettings.recipeRemainder(ADVANCED_FORGE_HAMMER), 360);
    }

    public static Item NANO_SUIT_HELMET = new NanoSuitItem(NanoArmorMaterial.NANO, ArmorItem.Type.HELMET, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("nano_helmet")).maxCount(1).maxDamage(-1));
    public static Item NANO_SUIT_BODY_ARMOR = new NanoSuitItem(NanoArmorMaterial.NANO, ArmorItem.Type.CHESTPLATE, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("nano_chestplate")).maxCount(1).maxDamage(-1));
    public static Item NANO_SUIT_LEGGINGS = new NanoSuitItem(NanoArmorMaterial.NANO, ArmorItem.Type.LEGGINGS, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("nano_leggings")).maxCount(1).maxDamage(-1));
    public static Item NANO_SUIT_BOOTS = new NanoSuitItem(NanoArmorMaterial.NANO, ArmorItem.Type.BOOTS, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("nano_boots")).maxCount(1).maxDamage(-1));

    // 強化バッテリー
    public static Item ADVANCED_BATTERY = new AdvancedBattery(new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("advanced_battery")).maxCount(1).maxDamage(-1), 8 * TechRebornConfig.redCellBatteryMaxCharge, RcEnergyTier.HIGH);
    public static Item ADVANCED_BATTERY_2 = new AdvancedBattery(new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("advanced_battery_2")).maxCount(1).maxDamage(-1), 64 * TechRebornConfig.redCellBatteryMaxCharge, RcEnergyTier.HIGH);
    public static Item ADVANCED_BATTERY_3 = new AdvancedBattery(new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("advanced_battery_3")).maxCount(1).maxDamage(-1), 512 * TechRebornConfig.redCellBatteryMaxCharge, RcEnergyTier.HIGH);
    public static Item ADVANCED_BATTERY_4 = new AdvancedBattery(new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("advanced_battery_4")).maxCount(1).maxDamage(-1), 4096 * TechRebornConfig.redCellBatteryMaxCharge, RcEnergyTier.HIGH);
    public static Item ADVANCED_BATTERY_5 = new AdvancedBattery(new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("advanced_battery_5")).maxCount(1).maxDamage(-1), 32768 * TechRebornConfig.redCellBatteryMaxCharge, RcEnergyTier.EXTREME);

    // ダイナマイト (予定: 時限爆弾)
    public static Item DYNAMITE = new Dynamite(new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("dynamite")).maxCount(64));
    public static Item STICKY_DYNAMITE = new Dynamite(new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("sticky_dynamite")).maxCount(64),true);
    public static Item INDUSTRIAL_DYNAMITE = new Dynamite(new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("industrial_dynamite")).maxCount(64),false, true);
    public static Item INDUSTRIAL_STICKY_DYNAMITE = new Dynamite(new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("industrial_sticky_dynamite")).maxCount(64),true, true);
    public static Item INDUSTRIAL_TNT = new BlockItem(Blocks.INDUSTRIAL_TNT, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("industrial_tnt")).maxCount(64));

    // ライト、足場(鉄) 強化石材  ネーミングマシン
    public static Item LIGHT = new BlockItem(Blocks.LIGHT, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("light")).maxCount(64));

    public static Item CARDBOARD_BOX = new BlockItem(Blocks.CARDBOARD_BOX, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("cardboard_box")).maxCount(64));
    public static Item CARDBOARD_BOX_MINETARO = new BlockItem(Blocks.CARDBOARD_BOX_MINETARO, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("cardboard_box_minetaro")).maxCount(64));
    public static Item CARDBOARD_BOX_MINEZON = new BlockItem(Blocks.CARDBOARD_BOX_MINEZON, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("cardboard_box_minezon")).maxCount(64));
    public static Item CARDBOARD_BOX_NOTHING = new BlockItem(Blocks.CARDBOARD_BOX_NOTHING, new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("cardboard_box_nothing_logo")).maxCount(64));

    // 缶
    public static Item EMPTY_CAN = new Item(new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("empty_can")).maxCount(64));
    public static Item FUEL_CAN = new FuelCanItem(new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("fuel_can")).maxCount(64).recipeRemainder(EMPTY_CAN));
    public static Item FOOD_CAN = new FoodCanItem(new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("food_can")).maxCount(64).recipeRemainder(EMPTY_CAN).food(new FoodComponent.Builder().snack().hunger(2).saturationModifier(2).build()));

    // Better Batpack
    public static Item BATPACK_4 = new BetterBatpackItem(TechRebornConfig.lithiumBatpackCharge * 4, new BBArmorMaterial("batpack4"), RcEnergyTier.MEDIUM);
    public static Item BATPACK_16 = new BetterBatpackItem(TechRebornConfig.lithiumBatpackCharge * 16, new BBArmorMaterial("batpack16"), RcEnergyTier.HIGH);
    public static Item BATPACK_64 = new BetterBatpackItem(TechRebornConfig.lithiumBatpackCharge * 64, new BBArmorMaterial("batpack64"), RcEnergyTier.EXTREME);
    public static Item BATPACK_128 = new BetterBatpackItem(TechRebornConfig.lithiumBatpackCharge * 128, new BBArmorMaterial("batpack128"), RcEnergyTier.INSANE);



    // 素材アイテム
    public static Item DUCT_TAPE = new Item(new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("duct_tape")).maxCount(64));
    public static Item CARDBOARD_SHEET = new Item(new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("cardboard_sheet")).maxCount(64));

    //public static Item ADD_ITEMS = new AddItems(new ExtendSettings().addGroup(AdvancedReborn.AR_GROUP, AdvancedReborn.id("z_add_items")).maxCount(64));

    public static void init() {
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("charge_pad"), () -> CHARGE_PAD_MK_1);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("charge_pad_2"), () -> CHARGE_PAD_MK_2);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("charge_pad_3"), () -> CHARGE_PAD_MK_3);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("charge_pad_4"), () -> CHARGE_PAD_MK_4);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("charge_pad_final"), () -> CHARGE_PAD_MK_FINAL);

        AdvancedReborn.registry.registerItem(AdvancedReborn.id("ray_solar_panel"), () -> RAY_SOLAR_1);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("ray_solar_panel_2"), () -> RAY_SOLAR_2);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("ray_solar_panel_3"), () -> RAY_SOLAR_3);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("ray_solar_panel_4"), () -> RAY_SOLAR_4);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("ray_generator"), () -> RAY_GENERATOR_1);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("ray_generator_2"), () -> RAY_GENERATOR_2);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("ray_generator_3"), () -> RAY_GENERATOR_3);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("ray_generator_4"), () -> RAY_GENERATOR_4);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("ray_generator_5"), () -> RAY_GENERATOR_5);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("ray_generator_6"), () -> RAY_GENERATOR_6);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("ray_generator_7"), () -> RAY_GENERATOR_7);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("ray_generator_8"), () -> RAY_GENERATOR_8);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("ray_generator_9"), () -> RAY_GENERATOR_9);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("ray_generator_10"), () -> RAY_GENERATOR_10);

        AdvancedReborn.registry.registerItem(AdvancedReborn.id("induction_furnace"), () -> INDUCTION_FURNACE);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("rotary_grinder"), () -> ROTARY_GRINDER);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("centrifugal_extractor"), () -> CENTRIFUGAL_EXTRACTOR);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("singularity_compressor"), () -> SINGULARITY_COMPRESSOR);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("canning_machine"), () -> CANNING_MACHINE);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("renaming_machine"), () -> RENAMING_MACHINE);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("teleporter"), () -> TELEPORTER);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("farming_machine"), () -> FARMING_MACHINE);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("logging_machine"), () -> LOGGING_MACHINE);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("fertilizer_spreader"), () -> FERTILIZER_SPREADER);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("enchantment_extractor"), () -> ENCHANTMENT_EXTRACTOR);

        AdvancedReborn.registry.registerItem(AdvancedReborn.id("freq_trans"), () -> FREQ_TRANS);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("config_wrench"), () -> CONFIG_WRENCH);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("forge_hammer"), () -> FORGE_HAMMER);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("advanced_forge_hammer"), () -> ADVANCED_FORGE_HAMMER);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("dynamite"), () -> DYNAMITE);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("sticky_dynamite"), () -> STICKY_DYNAMITE);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("industrial_dynamite"), () -> INDUSTRIAL_DYNAMITE);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("industrial_sticky_dynamite"), () -> INDUSTRIAL_STICKY_DYNAMITE);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("industrial_tnt"), () -> INDUSTRIAL_TNT);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("light"), () -> LIGHT);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("cardboard_box"), () -> CARDBOARD_BOX);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("cardboard_box_minetaro"), () -> CARDBOARD_BOX_MINETARO);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("cardboard_box_minezon"), () -> CARDBOARD_BOX_MINEZON);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("cardboard_box_nothing_logo"), () -> CARDBOARD_BOX_NOTHING);

        AdvancedReborn.registry.registerItem(AdvancedReborn.id("advanced_battery"), () -> ADVANCED_BATTERY);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("advanced_battery_2"), () -> ADVANCED_BATTERY_2);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("advanced_battery_3"), () -> ADVANCED_BATTERY_3);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("advanced_battery_4"), () -> ADVANCED_BATTERY_4);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("advanced_battery_5"), () -> ADVANCED_BATTERY_5);

        AdvancedReborn.registry.registerItem(AdvancedReborn.id("nano_helmet"), () -> NANO_SUIT_HELMET);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("nano_chestplate"), () -> NANO_SUIT_BODY_ARMOR);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("nano_leggings"), () -> NANO_SUIT_LEGGINGS);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("nano_boots"), () -> NANO_SUIT_BOOTS);

        AdvancedReborn.registry.registerItem(AdvancedReborn.id("empty_can"), () -> EMPTY_CAN);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("fuel_can"), () -> FUEL_CAN);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("food_can"), () -> FOOD_CAN);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("cardboard_sheet"), () -> CARDBOARD_SHEET);
        AdvancedReborn.registry.registerItem(AdvancedReborn.id("duct_tape"), () -> DUCT_TAPE);

        AdvancedReborn.registry.registerItem(new Identifier("better_batpack:batpack4"), () -> BATPACK_4);
        AdvancedReborn.registry.registerItem(new Identifier("better_batpack:batpack16"), () -> BATPACK_16);
        AdvancedReborn.registry.registerItem(new Identifier("better_batpack:batpack64"), () -> BATPACK_64);
        AdvancedReborn.registry.registerItem(new Identifier("better_batpack:batpack128"), () -> BATPACK_128);

        //AdvancedReborn.registry.registerItem(AdvancedReborn.id("z_add_items"), () -> ADD_ITEMS);
    }
}
