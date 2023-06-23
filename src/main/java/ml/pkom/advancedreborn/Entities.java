package ml.pkom.advancedreborn;

import ml.pkom.advancedreborn.entities.DynamiteEntity;
import ml.pkom.advancedreborn.entities.IndustrialTNTEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static ml.pkom.advancedreborn.AdvancedReborn.registry;

public class Entities {
    public static EntityType<DynamiteEntity> DYNAMITE = Registry.register(Registries.ENTITY_TYPE, AdvancedReborn.id("dynamite"), (FabricEntityTypeBuilder.<DynamiteEntity>create(SpawnGroup.MISC, DynamiteEntity::new)).dimensions(EntityDimensions.fixed(0.25f,0.25f)).trackRangeBlocks(10).trackedUpdateRate(10).build());
    public static EntityType<IndustrialTNTEntity> I_TNT = Registry.register(Registries.ENTITY_TYPE, AdvancedReborn.id("industrial_tnt"), (FabricEntityTypeBuilder.<IndustrialTNTEntity>create(SpawnGroup.MISC, IndustrialTNTEntity::new)).dimensions(EntityDimensions.fixed(0.98f,0.98f)).trackRangeBlocks(10).trackedUpdateRate(10).build());

    public static void init() {

    }
}
