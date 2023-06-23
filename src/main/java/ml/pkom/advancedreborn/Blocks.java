package ml.pkom.advancedreborn;

import ml.pkom.advancedreborn.blocks.*;
import ml.pkom.mcpitanlibarch.api.block.CompatibleBlockSettings;
import ml.pkom.mcpitanlibarch.api.block.CompatibleMaterial;
import ml.pkom.mcpitanlibarch.api.block.ExtendBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;

public class Blocks {

    public static AbstractBlock.Settings baseSetting = CompatibleBlockSettings.of(CompatibleMaterial.METAL).requiresTool().strength(2, 8).build();

    public static Block CHARGE_PAD_MK_1 = new ChargePad(baseSetting, 4);
    public static Block CHARGE_PAD_MK_2 = new ChargePad(baseSetting, 16);
    public static Block CHARGE_PAD_MK_3 = new ChargePad(baseSetting, 64);
    public static Block CHARGE_PAD_MK_4 = new ChargePad(baseSetting, 128);
    public static Block CHARGE_PAD_MK_FINAL = new ChargePadFinal(baseSetting, 256);

    public static Block RAY_SOLAR_1 = new RaySolar(baseSetting, 1, false);
    public static Block RAY_SOLAR_2 = new RaySolar(baseSetting, 8, false);
    public static Block RAY_SOLAR_3 = new RaySolar(baseSetting, 64, false);
    public static Block RAY_SOLAR_4 = new RaySolar(baseSetting, 512, false);

    public static Block RAY_GENERATOR_1 = new RaySolar(baseSetting, 2, true);
    public static Block RAY_GENERATOR_2 = new RaySolar(baseSetting, 8, true);
    public static Block RAY_GENERATOR_3 = new RaySolar(baseSetting, 32, true);
    public static Block RAY_GENERATOR_4 = new RaySolar(baseSetting, 128, true);
    public static Block RAY_GENERATOR_5 = new RaySolar(baseSetting, 512, true);
    public static Block RAY_GENERATOR_6 = new RaySolar(baseSetting, 2048, true);
    public static Block RAY_GENERATOR_7 = new RaySolar(baseSetting, 8192, true);
    public static Block RAY_GENERATOR_8 = new RaySolar(baseSetting, 32768, true);
    public static Block RAY_GENERATOR_9 = new RaySolar(baseSetting, 131072, true);
    public static Block RAY_GENERATOR_10 = new RaySolar(baseSetting, 532480, true);


    public static Block INDUCTION_FURNACE = new InductionFurnace(baseSetting);
    public static Block ROTARY_GRINDER = new RotaryGrinder(baseSetting);
    public static Block CENTRIFUGAL_EXTRACTOR = new CentrifugalExtractor(baseSetting);
    public static Block SINGULARITY_COMPRESSOR = new SingularityCompressor(baseSetting);
    public static Block CANNING_MACHINE = new CanningMachine(baseSetting);
    public static Block RENAMING_MACHINE = new RenamingMachine(baseSetting);
    public static Block TELEPORTER = new Teleporter(baseSetting);
    public static Block FARMING_MACHINE = new FarmingMachine(baseSetting);
    public static Block LOGGING_MACHINE = new LoggingMachine(baseSetting);
    public static Block FERTILIZER_SPREADER = new FertilizerSpreader(baseSetting);
    public static Block ENCHANTMENT_EXTRACTOR = new EnchantmentExtractor(baseSetting);


    //breakByHand
    public static Block CARDBOARD_BOX = new CardboardBox(CompatibleBlockSettings.of(CompatibleMaterial.WOOD).sounds(BlockSoundGroup.WOOD).strength(1, 3));
    public static Block CARDBOARD_BOX_MINEZON = new CardboardBox(CompatibleBlockSettings.of(CompatibleMaterial.WOOD).sounds(BlockSoundGroup.WOOD).strength(1, 3));
    public static Block CARDBOARD_BOX_MINETARO = new CardboardBox(CompatibleBlockSettings.of(CompatibleMaterial.WOOD).sounds(BlockSoundGroup.WOOD).strength(1, 3));
    public static Block CARDBOARD_BOX_NOTHING = new CardboardBox(CompatibleBlockSettings.of(CompatibleMaterial.WOOD).sounds(BlockSoundGroup.WOOD).strength(1, 3));

    public static Block LIGHT = new ExtendBlock(CompatibleBlockSettings.of(CompatibleMaterial.METAL).strength(1.5F, 4).luminance((state) -> 15));
    // breakByHand

    public static Block INDUSTRIAL_TNT = new IndustrialTNT(CompatibleBlockSettings.copy(net.minecraft.block.Blocks.TNT));

    public static void init() {
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("charge_pad"), () -> CHARGE_PAD_MK_1);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("charge_pad_2"), () -> CHARGE_PAD_MK_2);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("charge_pad_3"), () -> CHARGE_PAD_MK_3);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("charge_pad_4"), () -> CHARGE_PAD_MK_4);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("charge_pad_final"), () -> CHARGE_PAD_MK_FINAL);

        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("ray_solar_panel"), () -> RAY_SOLAR_1);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("ray_solar_panel_2"), () -> RAY_SOLAR_2);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("ray_solar_panel_3"), () -> RAY_SOLAR_3);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("ray_solar_panel_4"), () -> RAY_SOLAR_4);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("ray_generator"), () -> RAY_GENERATOR_1);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("ray_generator_2"), () -> RAY_GENERATOR_2);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("ray_generator_3"), () -> RAY_GENERATOR_3);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("ray_generator_4"), () -> RAY_GENERATOR_4);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("ray_generator_5"), () -> RAY_GENERATOR_5);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("ray_generator_6"), () -> RAY_GENERATOR_6);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("ray_generator_7"), () -> RAY_GENERATOR_7);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("ray_generator_8"), () -> RAY_GENERATOR_8);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("ray_generator_9"), () -> RAY_GENERATOR_9);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("ray_generator_10"), () -> RAY_GENERATOR_10);

        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("induction_furnace"), () -> INDUCTION_FURNACE);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("rotary_grinder"), () -> ROTARY_GRINDER);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("centrifugal_extractor"), () -> CENTRIFUGAL_EXTRACTOR);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("singularity_compressor"), () -> SINGULARITY_COMPRESSOR);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("canning_machine"), () -> CANNING_MACHINE);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("renaming_machine"), () -> RENAMING_MACHINE);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("teleporter"), () -> TELEPORTER);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("farming_machine"), () -> FARMING_MACHINE);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("logging_machine"), () -> LOGGING_MACHINE);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("fertilizer_spreader"), () -> FERTILIZER_SPREADER);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("enchantment_extractor"), () -> ENCHANTMENT_EXTRACTOR);

        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("industrial_tnt"), () -> INDUSTRIAL_TNT);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("light"), () -> LIGHT);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("cardboard_box"), () -> CARDBOARD_BOX);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("cardboard_box_minetaro"), () -> CARDBOARD_BOX_MINETARO);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("cardboard_box_minezon"), () -> CARDBOARD_BOX_MINEZON);
        AdvancedReborn.registry.registerBlock(AdvancedReborn.id("cardboard_box_nothing_logo"), () -> CARDBOARD_BOX_NOTHING);


    }
}
