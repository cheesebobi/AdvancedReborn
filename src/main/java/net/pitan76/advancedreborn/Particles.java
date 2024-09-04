package net.pitan76.advancedreborn;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;

import static net.pitan76.advancedreborn.AdvancedReborn.INSTANCE;
import static net.pitan76.advancedreborn.AdvancedReborn.registry;

public class Particles {
    public static SimpleParticleType ENERGY = FabricParticleTypes.simple();


    public static void init() {
        registry.registerParticleType(INSTANCE.compatId("energy"), () -> ENERGY);
    }
}
