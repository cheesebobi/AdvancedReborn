package ml.pkom.advancedreborn.blocks;

import ml.pkom.advancedreborn.GuiTypes;
import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import ml.pkom.advancedreborn.tile.InductionFurnaceTile;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import reborncore.api.blockentity.IMachineGuiHandler;

public class InductionFurnace extends AdvancedMachineBlock {

    public InductionFurnace(Block.Settings settings) {
        super(settings);
    }

    public BlockEntity createBlockEntity(TileCreateEvent event) {
        return new InductionFurnaceTile(event);
    }

    public IMachineGuiHandler getGui() {
        return GuiTypes.INDUCTION_FURNACE;
    }
}
