package net.pitan76.advancedreborn;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.pitan76.advancedreborn.tile.*;
import reborncore.common.network.BlockPosPayload;
import reborncore.common.screen.BuiltScreenHandler;
import reborncore.common.screen.BuiltScreenHandlerProvider;
import techreborn.blockentity.GuiType;

public class GuiTypes {
    public static GuiType<CanningMachineTile> CANNING_MACHINE = register(AdvancedReborn.MOD_ID + "__canning_machine");
    public static GuiType<RenamingMachineTile> RENAMING_MACHINE = register(AdvancedReborn.MOD_ID + "__renaming_machine");
    public static GuiType<InductionFurnaceTile> INDUCTION_FURNACE = register(AdvancedReborn.MOD_ID + "__induction_furnace_machine");
    public static GuiType<RotaryGrinderTile> ROTARY_GRINDER = register(AdvancedReborn.MOD_ID + "__rotary_grinder_machine");
    public static GuiType<CentrifugalExtractorTile> CENTRIFUGAL_EXTRACTOR = register(AdvancedReborn.MOD_ID + "__centrifugal_extractor_machine");
    public static GuiType<SingularityCompressorTile> SINGULARITY_COMPRESSOR = register(AdvancedReborn.MOD_ID + "__singularity_compressor_machine");
    public static GuiType<FarmingMachineTile> FARMING_MACHINE = register(AdvancedReborn.MOD_ID + "__farming_machine");
    public static GuiType<LoggingMachineTile> LOGGING_MACHINE = register(AdvancedReborn.MOD_ID + "__logging_machine");
    public static GuiType<FertilizerSpreaderTile> FERTILIZER_SPREADER = register(AdvancedReborn.MOD_ID + "__fertilizer_spreader");
    public static GuiType<EnchantmentExtractorTile> ENCHANTMENT_EXTRACTOR = register(AdvancedReborn.MOD_ID + "__enchantment_extractor");

    public static void init() {

    }

    private static <T extends BlockEntity> GuiType<T> register(String path) {
        var id = Identifier.of("techreborn", path);
        var screenHandlerType = Registry.register(Registries.SCREEN_HANDLER, id, new ExtendedScreenHandlerType<>(getScreenHandlerFactory(id), ScreenHandlerData.PACKET_CODEC));
        return new GuiType<>(id, screenHandlerType);
    }

    private static ExtendedScreenHandlerType.ExtendedFactory<BuiltScreenHandler, ScreenHandlerData> getScreenHandlerFactory(Identifier identifier) {
        return (syncId, playerInventory, payload) -> {
            if (!payload.isWithinDistance(playerInventory.player, 16)) {
                throw new IllegalStateException("Player cannot use this block entity as its too far away");
            }

            final BlockEntity blockEntity = playerInventory.player.getWorld().getBlockEntity(payload.pos());
            BuiltScreenHandler screenHandler = ((BuiltScreenHandlerProvider) blockEntity).createScreenHandler(syncId, playerInventory.player);

            //noinspection unchecked
            screenHandler.setType((ScreenHandlerType<BuiltScreenHandler>) Registries.SCREEN_HANDLER.get(identifier));
            return screenHandler;
        };
    }

    record ScreenHandlerData(BlockPos pos) implements BlockPosPayload {
        public static final PacketCodec<RegistryByteBuf, ScreenHandlerData> PACKET_CODEC = PacketCodec.tuple(
                BlockPos.PACKET_CODEC, ScreenHandlerData::pos,
                ScreenHandlerData::new
        );
    }
}
