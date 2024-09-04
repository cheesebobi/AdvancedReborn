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

    public static Item CHARGE_PAD_MK_1 = ItemUtil.ofBlock(Blocks.CHARGE_PAD_MK_1, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item CHARGE_PAD_MK_2 = ItemUtil.ofBlock(Blocks.CHARGE_PAD_MK_2, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item CHARGE_PAD_MK_3 = ItemUtil.ofBlock(Blocks.CHARGE_PAD_MK_3, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item CHARGE_PAD_MK_4 = ItemUtil.ofBlock(Blocks.CHARGE_PAD_MK_4, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item CHARGE_PAD_MK_FINAL = ItemUtil.ofBlock(Blocks.CHARGE_PAD_MK_FINAL, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));

    public static Item RAY_SOLAR_1 = ItemUtil.ofBlock(Blocks.RAY_SOLAR_1, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item RAY_SOLAR_2 = ItemUtil.ofBlock(Blocks.RAY_SOLAR_2, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item RAY_SOLAR_3 = ItemUtil.ofBlock(Blocks.RAY_SOLAR_3, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item RAY_SOLAR_4 = ItemUtil.ofBlock(Blocks.RAY_SOLAR_4, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item RAY_GENERATOR_1 = ItemUtil.ofBlock(Blocks.RAY_GENERATOR_1, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item RAY_GENERATOR_2 = ItemUtil.ofBlock(Blocks.RAY_GENERATOR_2, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item RAY_GENERATOR_3 = ItemUtil.ofBlock(Blocks.RAY_GENERATOR_3, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item RAY_GENERATOR_4 = ItemUtil.ofBlock(Blocks.RAY_GENERATOR_4, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item RAY_GENERATOR_5 = ItemUtil.ofBlock(Blocks.RAY_GENERATOR_5, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item RAY_GENERATOR_6 = ItemUtil.ofBlock(Blocks.RAY_GENERATOR_6, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item RAY_GENERATOR_7 = ItemUtil.ofBlock(Blocks.RAY_GENERATOR_7, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item RAY_GENERATOR_8 = ItemUtil.ofBlock(Blocks.RAY_GENERATOR_8, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item RAY_GENERATOR_9 = ItemUtil.ofBlock(Blocks.RAY_GENERATOR_9, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item RAY_GENERATOR_10 = ItemUtil.ofBlock(Blocks.RAY_GENERATOR_10, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));

    public static Item INDUCTION_FURNACE = ItemUtil.ofBlock(Blocks.INDUCTION_FURNACE, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item ROTARY_GRINDER = ItemUtil.ofBlock(Blocks.ROTARY_GRINDER, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item CENTRIFUGAL_EXTRACTOR = ItemUtil.ofBlock(Blocks.CENTRIFUGAL_EXTRACTOR, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item SINGULARITY_COMPRESSOR = ItemUtil.ofBlock(Blocks.SINGULARITY_COMPRESSOR, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item CANNING_MACHINE = ItemUtil.ofBlock(Blocks.CANNING_MACHINE, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item RENAMING_MACHINE = ItemUtil.ofBlock(Blocks.RENAMING_MACHINE, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item TELEPORTER = ItemUtil.ofBlock(Blocks.TELEPORTER, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item FARMING_MACHINE = ItemUtil.ofBlock(Blocks.FARMING_MACHINE, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item LOGGING_MACHINE = ItemUtil.ofBlock(Blocks.LOGGING_MACHINE, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item FERTILIZER_SPREADER = ItemUtil.ofBlock(Blocks.FERTILIZER_SPREADER, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item ENCHANTMENT_EXTRACTOR = ItemUtil.ofBlock(Blocks.ENCHANTMENT_EXTRACTOR, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));

    public static Item FREQ_TRANS = new FreqTrans(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1));
    public static Item CONFIG_WRENCH = new ConfigWrench(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1));
    public static Item FORGE_HAMMER;
    public static Item ADVANCED_FORGE_HAMMER;

    static {
        // 実装しないでおく
        FORGE_HAMMER = new ForgeHammer(nothingSettings.recipeRemainder(FORGE_HAMMER), 80);
        ADVANCED_FORGE_HAMMER = new ForgeHammer(nothingSettings.recipeRemainder(ADVANCED_FORGE_HAMMER), 360);
    }

    // 実装しない
    public static Item NANO_SUIT_HELMET = new NanoSuitItem(NanoArmorMaterial.NANO, ArmorEquipmentType.HEAD, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1));
    public static Item NANO_SUIT_BODY_ARMOR = new NanoSuitItem(NanoArmorMaterial.NANO, ArmorEquipmentType.CHEST, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1));
    public static Item NANO_SUIT_LEGGINGS = new NanoSuitItem(NanoArmorMaterial.NANO, ArmorEquipmentType.LEGS, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1));
    public static Item NANO_SUIT_BOOTS = new NanoSuitItem(NanoArmorMaterial.NANO, ArmorEquipmentType.FEET, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1));

    // 強化バッテリー
    public static Item ADVANCED_BATTERY = new AdvancedBattery(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1), 8 * TechRebornConfig.redCellBatteryMaxCharge, RcEnergyTier.HIGH);
    public static Item ADVANCED_BATTERY_2 = new AdvancedBattery(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1), 64 * TechRebornConfig.redCellBatteryMaxCharge, RcEnergyTier.HIGH);
    public static Item ADVANCED_BATTERY_3 = new AdvancedBattery(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1), 512 * TechRebornConfig.redCellBatteryMaxCharge, RcEnergyTier.HIGH);
    public static Item ADVANCED_BATTERY_4 = new AdvancedBattery(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1), 4096 * TechRebornConfig.redCellBatteryMaxCharge, RcEnergyTier.HIGH);
    public static Item ADVANCED_BATTERY_5 = new AdvancedBattery(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(1).maxDamage(-1), 32768 * TechRebornConfig.redCellBatteryMaxCharge, RcEnergyTier.EXTREME);

    // ダイナマイト (予定: 時限爆弾)
    public static Item DYNAMITE = new Dynamite(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item STICKY_DYNAMITE = new Dynamite(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64),true);
    public static Item INDUSTRIAL_DYNAMITE = new Dynamite(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64),false, true);
    public static Item INDUSTRIAL_STICKY_DYNAMITE = new Dynamite(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64),true, true);
    public static Item INDUSTRIAL_TNT = ItemUtil.ofBlock(Blocks.INDUSTRIAL_TNT, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));

    // ライト、足場(鉄) 強化石材  ネーミングマシン
    public static Item LIGHT = ItemUtil.ofBlock(Blocks.LIGHT, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));

    public static Item CARDBOARD_BOX = ItemUtil.ofBlock(Blocks.CARDBOARD_BOX, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item CARDBOARD_BOX_MINETARO = ItemUtil.ofBlock(Blocks.CARDBOARD_BOX_MINETARO, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item CARDBOARD_BOX_MINEZON = ItemUtil.ofBlock(Blocks.CARDBOARD_BOX_MINEZON, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item CARDBOARD_BOX_NOTHING = ItemUtil.ofBlock(Blocks.CARDBOARD_BOX_NOTHING, CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));

    // 缶
    public static Item EMPTY_CAN = new ExtendItem(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item FUEL_CAN = new FuelCanItem(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64).recipeRemainder(EMPTY_CAN));

    public static FoodComponent CAN_FOOD_COMPONENT = new FoodComponent.Builder().snack().nutrition(2).saturationModifier(2).build();
    public static Item FOOD_CAN = new FoodCanItem(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64).recipeRemainder(EMPTY_CAN).food(CAN_FOOD_COMPONENT));

    // Better Batpack
    public static Item BATPACK_4 = new BetterBatpackItem(TechRebornConfig.lithiumBatpackCharge * 4, new BBArmorMaterial("batpack4"), RcEnergyTier.MEDIUM);
    public static Item BATPACK_16 = new BetterBatpackItem(TechRebornConfig.lithiumBatpackCharge * 16, new BBArmorMaterial("batpack16"), RcEnergyTier.HIGH);
    public static Item BATPACK_64 = new BetterBatpackItem(TechRebornConfig.lithiumBatpackCharge * 64, new BBArmorMaterial("batpack64"), RcEnergyTier.EXTREME);
    public static Item BATPACK_128 = new BetterBatpackItem(TechRebornConfig.lithiumBatpackCharge * 128, new BBArmorMaterial("batpack128"), RcEnergyTier.INSANE);



    // 素材アイテム
    public static Item DUCT_TAPE = new ExtendItem(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));
    public static Item CARDBOARD_SHEET = new ExtendItem(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));

    //public static Item ADD_ITEMS = new AddItems(CompatibleItemSettings.of().addGroup(AdvancedReborn.AR_GROUP).maxCount(64));

    public static void init() {

    }
}
