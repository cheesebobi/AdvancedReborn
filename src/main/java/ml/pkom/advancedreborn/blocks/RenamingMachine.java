package ml.pkom.advancedreborn.blocks;

import ml.pkom.advancedreborn.GuiTypes;
import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import ml.pkom.advancedreborn.tile.RenamingMachineTile;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import reborncore.api.blockentity.IMachineGuiHandler;

public class RenamingMachine extends AdvancedMachineBlock {

    public RenamingMachine(Block.Settings settings) {
        super(settings);
    }

    public BlockEntity createBlockEntity(TileCreateEvent event) {
        return new RenamingMachineTile(event);
    }

    public IMachineGuiHandler getGui() {
        return GuiTypes.RENAMING_MACHINE;
    }
}
