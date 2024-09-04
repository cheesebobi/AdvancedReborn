package net.pitan76.advancedreborn;

import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;
import net.pitan76.advancedreborn.blocks.*;
import net.pitan76.mcpitanlib.api.block.CompatibleBlockSettings;
import net.pitan76.mcpitanlib.api.block.CompatibleMaterial;
import net.pitan76.mcpitanlib.api.block.ExtendBlock;

import static net.pitan76.advancedreborn.AdvancedReborn.INSTANCE;
import static net.pitan76.advancedreborn.AdvancedReborn.registry;

public class Blocks {

    public static CompatibleBlockSettings baseSetting = CompatibleBlockSettings.of(CompatibleMaterial.METAL).requiresTool().strength(2, 8);

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

    }
}
