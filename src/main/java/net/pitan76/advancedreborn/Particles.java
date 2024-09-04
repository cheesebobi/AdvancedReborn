package net.pitan76.advancedreborn;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class Particles {
    public static SimpleParticleType ENERGY = FabricParticleTypes.simple();


    public static void init() {
        Registry.register(Registries.PARTICLE_TYPE, AdvancedReborn.id("energy"), ENERGY);
    }
}
