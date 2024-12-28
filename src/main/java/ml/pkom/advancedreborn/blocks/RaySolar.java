package ml.pkom.advancedreborn.blocks;

import ml.pkom.advancedreborn.AdvancedReborn;
import ml.pkom.advancedreborn.tile.RaySolarTile;
import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class RaySolar extends AdvancedMachineBlock {

    public boolean isRayGenerator = false;
    public int energy = 1;

    public RaySolar(Block.Settings settings, int energy, boolean allowNight) {
        super(settings);
        if (!AdvancedReborn.solars.contains(this)) AdvancedReborn.solars.add(this);
        this.isRayGenerator = allowNight;
        this.energy = energy;
    }

    public BlockEntity createBlockEntity(TileCreateEvent event) {
        return new RaySolarTile(event, this);
    }

    public BlockEntity createBlockEntity(BlockView world) {
        return createBlockEntity(new TileCreateEvent(world));
    }

    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return createBlockEntity(new TileCreateEvent(pos, state));
    }
}