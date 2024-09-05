package net.pitan76.advancedreborn;

import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;
import net.pitan76.advancedreborn.blocks.*;
import net.pitan76.mcpitanlib.api.block.CompatibleBlockSettings;
import net.pitan76.mcpitanlib.api.block.CompatibleMaterial;
import net.pitan76.mcpitanlib.api.block.ExtendBlock;
import net.pitan76.mcpitanlib.api.registry.result.RegistryResult;

import static net.pitan76.advancedreborn.AdvancedReborn.INSTANCE;
import static net.pitan76.advancedreborn.AdvancedReborn.registry;

public class Blocks {

    public static CompatibleBlockSettings baseSetting = CompatibleBlockSettings.of(CompatibleMaterial.METAL).requiresTool().strength(2, 8);

    public static RegistryResult<Block> CHARGE_PAD_MK_1;
    public static RegistryResult<Block> CHARGE_PAD_MK_2;
    public static RegistryResult<Block> CHARGE_PAD_MK_3;
    public static RegistryResult<Block> CHARGE_PAD_MK_4;
    public static RegistryResult<Block> CHARGE_PAD_MK_FINAL;

    public static RegistryResult<Block> RAY_SOLAR_1;
    public static RegistryResult<Block> RAY_SOLAR_2;
    public static RegistryResult<Block> RAY_SOLAR_3;
    public static RegistryResult<Block> RAY_SOLAR_4;

    public static RegistryResult<Block> RAY_GENERATOR_1;
    public static RegistryResult<Block> RAY_GENERATOR_2;
    public static RegistryResult<Block> RAY_GENERATOR_3;
    public static RegistryResult<Block> RAY_GENERATOR_4;
    public static RegistryResult<Block> RAY_GENERATOR_5;
    public static RegistryResult<Block> RAY_GENERATOR_6;
    public static RegistryResult<Block> RAY_GENERATOR_7;
    public static RegistryResult<Block> RAY_GENERATOR_8;
    public static RegistryResult<Block> RAY_GENERATOR_9;
    public static RegistryResult<Block> RAY_GENERATOR_10;


    public static RegistryResult<Block> INDUCTION_FURNACE;
    public static RegistryResult<Block> ROTARY_GRINDER;
    public static RegistryResult<Block> CENTRIFUGAL_EXTRACTOR;
    public static RegistryResult<Block> SINGULARITY_COMPRESSOR;
    public static RegistryResult<Block> CANNING_MACHINE;
    public static RegistryResult<Block> RENAMING_MACHINE;
    public static RegistryResult<Block> TELEPORTER;
    public static RegistryResult<Block> FARMING_MACHINE;
    public static RegistryResult<Block> LOGGING_MACHINE;
    public static RegistryResult<Block> FERTILIZER_SPREADER;
    public static RegistryResult<Block> ENCHANTMENT_EXTRACTOR;


    //breakByHand
    public static RegistryResult<Block> CARDBOARD_BOX;
    public static RegistryResult<Block> CARDBOARD_BOX_MINEZON;
    public static RegistryResult<Block> CARDBOARD_BOX_MINETARO;
    public static RegistryResult<Block> CARDBOARD_BOX_NOTHING;

    public static RegistryResult<Block> LIGHT;
    // breakByHand

    public static RegistryResult<Block> INDUSTRIAL_TNT;

    public static void init() {
        CHARGE_PAD_MK_1 = registry.registerBlock(INSTANCE.compatId("CHARGE_PAD_MK_1"), () -> new ChargePad(baseSetting, 4));
        CHARGE_PAD_MK_2 = registry.registerBlock(INSTANCE.compatId("CHARGE_PAD_MK_2"), () -> new ChargePad(baseSetting, 16));
        CHARGE_PAD_MK_3 = registry.registerBlock(INSTANCE.compatId("CHARGE_PAD_MK_3"), () -> new ChargePad(baseSetting, 64));
        CHARGE_PAD_MK_4 = registry.registerBlock(INSTANCE.compatId("CHARGE_PAD_MK_4"), () -> new ChargePad(baseSetting, 128));
        CHARGE_PAD_MK_FINAL = registry.registerBlock(INSTANCE.compatId("CHARGE_PAD_MK_FINAL"), () -> new ChargePadFinal(baseSetting, 256));
        RAY_SOLAR_1 = registry.registerBlock(INSTANCE.compatId("RAY_SOLAR_1"), () -> new RaySolar(baseSetting, 1, false));
        RAY_SOLAR_2 = registry.registerBlock(INSTANCE.compatId("RAY_SOLAR_2"), () -> new RaySolar(baseSetting, 8, false));
        RAY_SOLAR_3 = registry.registerBlock(INSTANCE.compatId("RAY_SOLAR_3"), () -> new RaySolar(baseSetting, 64, false));
        RAY_SOLAR_4 = registry.registerBlock(INSTANCE.compatId("RAY_SOLAR_4"), () -> new RaySolar(baseSetting, 512, false));
        RAY_GENERATOR_1 = registry.registerBlock(INSTANCE.compatId("RAY_GENERATOR_1"), () -> new RaySolar(baseSetting, 2, true));
        RAY_GENERATOR_2 = registry.registerBlock(INSTANCE.compatId("RAY_GENERATOR_2"), () -> new RaySolar(baseSetting, 8, true));
        RAY_GENERATOR_3 = registry.registerBlock(INSTANCE.compatId("RAY_GENERATOR_3"), () -> new RaySolar(baseSetting, 32, true));
        RAY_GENERATOR_4 = registry.registerBlock(INSTANCE.compatId("RAY_GENERATOR_4"), () -> new RaySolar(baseSetting, 128, true));
        RAY_GENERATOR_5 = registry.registerBlock(INSTANCE.compatId("RAY_GENERATOR_5"), () -> new RaySolar(baseSetting, 512, true));
        RAY_GENERATOR_6 = registry.registerBlock(INSTANCE.compatId("RAY_GENERATOR_6"), () -> new RaySolar(baseSetting, 2048, true));
        RAY_GENERATOR_7 = registry.registerBlock(INSTANCE.compatId("RAY_GENERATOR_7"), () -> new RaySolar(baseSetting, 8192, true));
        RAY_GENERATOR_8 = registry.registerBlock(INSTANCE.compatId("RAY_GENERATOR_8"), () -> new RaySolar(baseSetting, 32768, true));
        RAY_GENERATOR_9 = registry.registerBlock(INSTANCE.compatId("RAY_GENERATOR_9"), () -> new RaySolar(baseSetting, 131072, true));
        RAY_GENERATOR_10 = registry.registerBlock(INSTANCE.compatId("RAY_GENERATOR_10"), () -> new RaySolar(baseSetting, 532480, true));
        INDUCTION_FURNACE = registry.registerBlock(INSTANCE.compatId("INDUCTION_FURNACE"), () -> new InductionFurnace(baseSetting));
        ROTARY_GRINDER = registry.registerBlock(INSTANCE.compatId("ROTARY_GRINDER"), () -> new RotaryGrinder(baseSetting));
        CENTRIFUGAL_EXTRACTOR = registry.registerBlock(INSTANCE.compatId("CENTRIFUGAL_EXTRACTOR"), () -> new CentrifugalExtractor(baseSetting));
        SINGULARITY_COMPRESSOR = registry.registerBlock(INSTANCE.compatId("SINGULARITY_COMPRESSOR"), () -> new SingularityCompressor(baseSetting));
        CANNING_MACHINE = registry.registerBlock(INSTANCE.compatId("CANNING_MACHINE"), () -> new CanningMachine(baseSetting));
        RENAMING_MACHINE = registry.registerBlock(INSTANCE.compatId("RENAMING_MACHINE"), () -> new RenamingMachine(baseSetting));
        TELEPORTER = registry.registerBlock(INSTANCE.compatId("TELEPORTER"), () -> new Teleporter(baseSetting));
        FARMING_MACHINE = registry.registerBlock(INSTANCE.compatId("FARMING_MACHINE"), () -> new FarmingMachine(baseSetting));
        LOGGING_MACHINE = registry.registerBlock(INSTANCE.compatId("LOGGING_MACHINE"), () -> new LoggingMachine(baseSetting));
        FERTILIZER_SPREADER = registry.registerBlock(INSTANCE.compatId("FERTILIZER_SPREADER"), () -> new FertilizerSpreader(baseSetting));
        ENCHANTMENT_EXTRACTOR = registry.registerBlock(INSTANCE.compatId("ENCHANTMENT_EXTRACTOR"), () -> new EnchantmentExtractor(baseSetting));
        CARDBOARD_BOX = registry.registerBlock(INSTANCE.compatId("CARDBOARD_BOX"), () -> new CardboardBox(CompatibleBlockSettings.of(CompatibleMaterial.WOOD).sounds(BlockSoundGroup.WOOD).strength(1, 3)));
        CARDBOARD_BOX_MINEZON = registry.registerBlock(INSTANCE.compatId("CARDBOARD_BOX_MINEZON"), () -> new CardboardBox(CompatibleBlockSettings.of(CompatibleMaterial.WOOD).sounds(BlockSoundGroup.WOOD).strength(1, 3)));
        CARDBOARD_BOX_MINETARO = registry.registerBlock(INSTANCE.compatId("CARDBOARD_BOX_MINETARO"), () -> new CardboardBox(CompatibleBlockSettings.of(CompatibleMaterial.WOOD).sounds(BlockSoundGroup.WOOD).strength(1, 3)));
        CARDBOARD_BOX_NOTHING = registry.registerBlock(INSTANCE.compatId("CARDBOARD_BOX_NOTHING"), () -> new CardboardBox(CompatibleBlockSettings.of(CompatibleMaterial.WOOD).sounds(BlockSoundGroup.WOOD).strength(1, 3)));
        LIGHT = registry.registerBlock(INSTANCE.compatId("LIGHT"), () -> new ExtendBlock(CompatibleBlockSettings.of(CompatibleMaterial.METAL).strength(1.5F, 4).luminance((state) -> 15)));
        INDUSTRIAL_TNT = registry.registerBlock(INSTANCE.compatId("INDUSTRIAL_TNT"), () -> new IndustrialTNT(CompatibleBlockSettings.copy(net.minecraft.block.Blocks.TNT)));
    }
}