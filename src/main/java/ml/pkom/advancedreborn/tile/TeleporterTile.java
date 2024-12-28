package ml.pkom.advancedreborn.tile;

import ml.pkom.advancedreborn.Tiles;
import ml.pkom.advancedreborn.addons.autoconfig.AutoConfigAddon;
import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import ml.pkom.mcpitanlibarch.api.util.math.PosUtil;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import techreborn.blockentity.storage.energy.EnergyStorageBlockEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TeleporterTile extends BlockEntity implements BlockEntityTicker<TeleporterTile> {

    private static VoxelShape SHAPE_RANGE = VoxelShapes.cuboid(0, 0, 0, 1, 3, 1);
    private BlockPos teleportPos = null;

    public TeleporterTile(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public TeleporterTile(BlockPos pos, BlockState state) {
        this(Tiles.TELEPORTER_TILE, pos, state);
    }

    public TeleporterTile(TileCreateEvent event) {
        this(event.getBlockPos(), event.getBlockState());
    }

    public void tick(World world, BlockPos pos, BlockState state, TeleporterTile tile) {
        if (!AutoConfigAddon.getConfig().teleporterEnabled) return;
        if (world == null) return;
        if (world.isClient()) return;
        if (getTeleportPos() == null) return;
        List<Entity> entities = getEntities();
        if (entities.isEmpty()) return;
        if (!world.isReceivingRedstonePower(getPos())) return;
        if (use()) {
            spawnTeleportParticles((ServerWorld) getWorld(), getPos().up());
            for (Entity entity : entities) {
                entity.teleport(getTeleportPos().getX(), getTeleportPos().getY(), getTeleportPos().getZ());
                spawnTeleportParticles((ServerWorld) getWorld(), getTeleportPos());
                return;
            }
        }
    }

    private void spawnTeleportParticles(ServerWorld world, BlockPos pos) {
        // Using Vector3f for blue color
        Vector3f blueColor = new Vector3f(0.4F, 0.7F, 1.0F);
        world.spawnParticles(new DustParticleEffect(blueColor, 1.0F), // Blue color and scale
                pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, // Position
                20, // Number of particles
                0.3, 0.5, 0.3, // Particle spread (X, Y, Z)
                0.02); // Speed of particles
    }

    public boolean useTile(BlockEntity blockEntity) {
        if (blockEntity instanceof EnergyStorageBlockEntity) {
            EnergyStorageBlockEntity energyStorage = (EnergyStorageBlockEntity) blockEntity;
            if (energyStorage.getEnergy() >= AutoConfigAddon.getConfig().teleporterUseEnergy) {
                energyStorage.useEnergy(AutoConfigAddon.getConfig().teleporterUseEnergy);
                return true;
            }
        }
        return false;
    }

    public boolean use() {
        if (world == null) return false;
        BlockEntity up = world.getBlockEntity(pos.up());
        BlockEntity down =  world.getBlockEntity(pos.down());
        BlockEntity north = world.getBlockEntity(pos.north());
        BlockEntity south = world.getBlockEntity(pos.south());
        BlockEntity east =  world.getBlockEntity(pos.east());
        BlockEntity west =  world.getBlockEntity(pos.west());

        if (useTile(up))
            return true;
        if (useTile(down))
            return true;
        if (useTile(north))
            return true;
        if (useTile(south))
            return true;
        if (useTile(east))
            return true;
        if (useTile(west))
            return true;
        return false;
    }

    @Nullable
    public BlockPos getTeleportPos() {
        return teleportPos;
    }

    @Nullable
    public void setTeleportPos(BlockPos teleportPos) {
        //System.out.println(teleportPos);
        this.teleportPos = teleportPos;
    }

    public List<Entity> getEntities() {
        VoxelShape voxelShape = SHAPE_RANGE;
        try {
            return voxelShape.getBoundingBoxes().stream().flatMap((box) -> getWorld().getEntitiesByClass(Entity.class, box.offset(getX(), getY(), getZ()), EntityPredicates.VALID_ENTITY).stream()).collect(Collectors.toList());
        } catch (NullPointerException e) {
            return new ArrayList<>();
        }
    }

    public double getX() {
        return getPos().getX();
    }

    public double getY() {
        return getPos().getY();
    }

    public double getZ() {
        return getPos().getZ();
    }

    public void writeNbt(NbtCompound nbt) {
        if (getTeleportPos() != null) {
            nbt.putDouble("tpX", getTeleportPos().getX());
            nbt.putDouble("tpY", getTeleportPos().getY());
            nbt.putDouble("tpZ", getTeleportPos().getZ());
        }
        super.writeNbt(nbt);
    }

    public void readNbt(NbtCompound tag) {
        super.readNbt(tag);
        if (tag.contains("tpX") && tag.contains("tpY") && tag.contains("tpZ")) teleportPos = PosUtil.flooredBlockPos(tag.getDouble("tpX"), tag.getDouble("tpY"), tag.getDouble("tpZ"));
    }
}