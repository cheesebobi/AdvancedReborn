package ml.pkom.advancedreborn.blocks;

import ml.pkom.advancedreborn.GuiTypes;
import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import ml.pkom.advancedreborn.tile.CanningMachineTile;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import reborncore.api.blockentity.IMachineGuiHandler;

public class CanningMachine extends AdvancedMachineBlock {

    public CanningMachine(Block.Settings settings) {
        super(settings);
    }

    public BlockEntity createBlockEntity(TileCreateEvent event) {
        return new CanningMachineTile(event);
    }

    public IMachineGuiHandler getGui() {
        return GuiTypes.CANNING_MACHINE;
    }
}
