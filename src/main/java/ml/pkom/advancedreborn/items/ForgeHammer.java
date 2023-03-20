package ml.pkom.advancedreborn.items;

import ml.pkom.mcpitanlibarch.api.item.CompatibleItemSettings;
import ml.pkom.mcpitanlibarch.api.item.ExtendItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

import net.minecraft.util.math.random.Random;

public class ForgeHammer extends ExtendItem {
    public ForgeHammer(CompatibleItemSettings settings, int damage) {
        super(settings.maxDamage(damage));
    }

    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        stack.damage(1, Random.create(), (ServerPlayerEntity) player);
        ItemStack newStack = stack.copy();
        super.onCraft(stack, world, player);
        player.giveItemStack(newStack);
    }
}
