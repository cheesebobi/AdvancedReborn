package ml.pkom.advancedreborn.blocks;

import ml.pkom.advancedreborn.GuiTypes;
import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import ml.pkom.advancedreborn.tile.EnchantmentExtractorTile;
import net.minecraft.block.entity.BlockEntity;
import reborncore.api.blockentity.IMachineGuiHandler;

public class EnchantmentExtractor extends AdvancedMachineBlock {
    public EnchantmentExtractor(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(TileCreateEvent event) {
        return new EnchantmentExtractorTile(event);
    }

    @Override
    public IMachineGuiHandler getGui() {
        return GuiTypes.ENCHANTMENT_EXTRACTOR;
    }
}
