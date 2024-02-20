package net.pitan76.advancedreborn.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.pitan76.mcpitanlib.api.block.CompatibleBlockSettings;
import team.reborn.energy.Energy;
import team.reborn.energy.EnergyHandler;

public class ChargePadFinal extends ChargePad {

    public ChargePadFinal(CompatibleBlockSettings settings, int multiple) {
        super(settings, multiple);
    }

    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (world.isClient()) return;
        if (!(entity instanceof PlayerEntity)) return;
        PlayerEntity player = (PlayerEntity) entity;
        boolean needCharge = false;
        for (int i = 0; i < player.inventory.size(); i++) {
            ItemStack invStack = player.inventory.getStack(i);

            if (invStack.isEmpty()) {
                continue;
            }

            if (Energy.valid(invStack)) {
                EnergyHandler energy = Energy.of(invStack);
                if (energy.getEnergy() >= energy.getMaxStored()) continue;
                needCharge = true;
            }
        }
        if (needCharge) {
            super.onEntityCollision(state, world, pos, entity);
        }
    }
}
