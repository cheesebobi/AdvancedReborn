package net.pitan76.advancedreborn.tile;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.pitan76.advancedreborn.Blocks;
import net.pitan76.advancedreborn.Tiles;
import net.pitan76.advancedreborn.blocks.RaySolar;
import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;
import org.jetbrains.annotations.Nullable;
import reborncore.api.IToolDrop;
import reborncore.common.powerSystem.PowerAcceptorBlockEntity;

public class RaySolarTile extends PowerAcceptorBlockEntity implements IToolDrop {

    public RaySolar solar = (RaySolar) Blocks.RAY_SOLAR_1;
    public long energy = 1;

    public RaySolarTile(BlockEntityType<?> type) {
        super(type);
        //this.solar = (RaySolar) state.getBlock();
        this.energy = solar.energy;
    }

    public RaySolarTile(TileCreateEvent event, RaySolar solar) {
        this(event);
        this.solar = solar;
        this.energy = solar.energy;
    }

    public RaySolarTile(TileCreateEvent event) {
        this(Tiles.RAY_SOLAR_TILE);
    }

    // 1.17
    public RaySolarTile(BlockPos pos, BlockState state) {
        this(new TileCreateEvent(pos, state));
    }

    @Override
    public void tick() {
        super.tick();
        if (world == null) {
            return;
        }

        if (world.isClient()) {
            return;
        }
        if ((!world.isRaining() && !world.isThundering() && world.isDay() && world.isSkyVisible(pos.up())) || solar.isRayGenerator) {
            addEnergy(getEuPerTick(energy));
        }
    }

    public boolean canProvideEnergy(@Nullable Direction side) {
        return true;
    }

    public double getBaseMaxPower() {
        return energy * 8;
    }

    public double getBaseMaxOutput() {
        return energy * 4;
    }

    public double getBaseMaxInput() {
        return energy * 4;
    }

    public ItemStack getToolDrop(PlayerEntity p0) {
        return new ItemStack(solar);
    }
}
