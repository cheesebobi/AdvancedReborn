package net.pitan76.advancedreborn.items;

import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ProjectileDispenserBehavior;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ProjectileItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import net.pitan76.advancedreborn.Items;
import net.pitan76.advancedreborn.entities.DynamiteEntity;
import net.pitan76.mcpitanlib.api.event.item.ItemUseEvent;
import net.pitan76.mcpitanlib.api.item.CompatibleItemSettings;
import net.pitan76.mcpitanlib.api.item.ExtendItem;

public class Dynamite extends ExtendItem implements ProjectileItem {

    public boolean isSticky = false;
    public boolean isIndustrial = false;

    public Dynamite(CompatibleItemSettings settings) {
        super(settings);
        DispenserBlock.registerBehavior(this, new ProjectileDispenserBehavior(Items.DYNAMITE));
    }

    public Dynamite(CompatibleItemSettings settings, boolean isSticky) {
        this(settings);
        this.isSticky = isSticky;
    }

    public Dynamite(CompatibleItemSettings settings, boolean isSticky, boolean isIndustrial) {
        this(settings);
        this.isSticky = isSticky;
        this.isIndustrial = isIndustrial;
    }

    public TypedActionResult<ItemStack> onRightClick(ItemUseEvent event) {
        ItemStack stack = event.user.getPlayerEntity().getStackInHand(event.hand);
        if (!event.user.getAbilities().creativeMode) stack.decrement(1);
        if (!event.world.isClient()) {
            DynamiteEntity dynamiteEntity = new DynamiteEntity(event.world, event.user.getEntity());
            dynamiteEntity.setVelocity(event.user.getPlayerEntity(), event.user.getPlayerEntity().getPitch(), event.user.getPlayerEntity().getYaw(), 0.0F, 1.5F, 1.0F);
            dynamiteEntity.setItem(stack);
            dynamiteEntity.setSticky(isSticky);
            dynamiteEntity.setIndustrial(isIndustrial);
            event.world.spawnEntity(dynamiteEntity);
            event.world.playSound(null, dynamiteEntity.getX(), dynamiteEntity.getY(), dynamiteEntity.getZ(), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
        return TypedActionResult.success(stack);
    }

    @Override
    public ProjectileEntity createEntity(World world, Position pos, ItemStack stack, Direction direction) {
        DynamiteEntity dynamiteEntity = new DynamiteEntity(world, pos.getX(), pos.getY(), pos.getZ());
        dynamiteEntity.callSetItem(stack);
        dynamiteEntity.setSticky(isSticky);
        dynamiteEntity.setIndustrial(isIndustrial);
        return dynamiteEntity;
    }
}
