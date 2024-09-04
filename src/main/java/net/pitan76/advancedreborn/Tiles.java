package net.pitan76.advancedreborn;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.pitan76.advancedreborn.blocks.RaySolar;
import net.pitan76.advancedreborn.tile.*;
import net.pitan76.mcpitanlib.api.registry.result.RegistryResult;
import net.pitan76.mcpitanlib.api.tile.BlockEntityTypeBuilder;

import static net.pitan76.advancedreborn.AdvancedReborn.INSTANCE;
import static net.pitan76.advancedreborn.AdvancedReborn.registry;

public class Tiles {
    public static RegistryResult<BlockEntityType<?>> INDUCTION_FURNACE_TILE = registry.registerBlockEntityType(INSTANCE.compatId("induction_furnace"), () -> create(InductionFurnaceTile::new, Blocks.INDUCTION_FURNACE));
    public static RegistryResult<BlockEntityType<?>> ROTARY_GRINDER_TILE = registry.registerBlockEntityType(INSTANCE.compatId("rotary_grinder"), () -> create(RotaryGrinderTile::new, Blocks.ROTARY_GRINDER));
    public static RegistryResult<BlockEntityType<?>> CENTRIFUGAL_EXTRACTOR_TILE = registry.registerBlockEntityType(INSTANCE.compatId("centrifugal_extractor"), () -> create(CentrifugalExtractorTile::new, Blocks.CENTRIFUGAL_EXTRACTOR));
    public static RegistryResult<BlockEntityType<?>> SINGULARITY_COMPRESSOR_TILE = registry.registerBlockEntityType(INSTANCE.compatId("singularity_compressor"), () -> create(SingularityCompressorTile::new, Blocks.SINGULARITY_COMPRESSOR));
    public static RegistryResult<BlockEntityType<?>> RAY_SOLAR_TILE = registry.registerBlockEntityType(INSTANCE.compatId("ray_solar"), () -> create(RaySolarTile::new, AdvancedReborn.solars.toArray(new RaySolar[AdvancedReborn.solars.size()])));
    public static RegistryResult<BlockEntityType<?>> CARDBOARD_BOX_TILE = registry.registerBlockEntityType(INSTANCE.compatId("cardboard_box"), () -> create(CardboardBoxTile::new, Blocks.CARDBOARD_BOX));
    public static RegistryResult<BlockEntityType<?>> CANNING_MACHINE_TILE = registry.registerBlockEntityType(INSTANCE.compatId("canning_machine"), () -> create(CanningMachineTile::new, Blocks.CANNING_MACHINE));
    public static RegistryResult<BlockEntityType<?>> RENAMING_MACHINE_TILE = registry.registerBlockEntityType(INSTANCE.compatId("renaming_machine"), () -> create(RenamingMachineTile::new, Blocks.RENAMING_MACHINE));
    public static RegistryResult<BlockEntityType<?>> TELEPORTER_TILE = registry.registerBlockEntityType(INSTANCE.compatId("teleporter"), () -> create(TeleporterTile::new, Blocks.TELEPORTER));
    public static RegistryResult<BlockEntityType<?>> FARMING_MACHINE_TILE = registry.registerBlockEntityType(INSTANCE.compatId("farming_machine"), () -> create(FarmingMachineTile::new, Blocks.FARMING_MACHINE));
    public static RegistryResult<BlockEntityType<?>> LOGGING_MACHINE_TILE = registry.registerBlockEntityType(INSTANCE.compatId("logging_machine"), () -> create(LoggingMachineTile::new, Blocks.LOGGING_MACHINE));
    public static RegistryResult<BlockEntityType<?>> FERTILIZER_SPREADER_TILE = registry.registerBlockEntityType(INSTANCE.compatId("fertilizer_spreader"), () -> create(FertilizerSpreaderTile::new, Blocks.FERTILIZER_SPREADER));
    public static RegistryResult<BlockEntityType<?>> ENCHANTMENT_EXTRACTOR_TILE = registry.registerBlockEntityType(INSTANCE.compatId("enchantment_extractor"), () -> create(EnchantmentExtractorTile::new, Blocks.ENCHANTMENT_EXTRACTOR));

    public static void init() {

    }

    public static <T extends BlockEntity> BlockEntityType<T> create(BlockEntityTypeBuilder.Factory<T> supplier, Block... blocks) {
        return BlockEntityTypeBuilder.create(supplier, blocks).build();
    }
}
