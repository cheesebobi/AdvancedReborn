package net.pitan76.advancedreborn.items;

import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ProjectileItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import net.pitan76.advancedreborn.entities.DynamiteEntity;
import net.pitan76.mcpitanlib.api.event.item.ItemUseEvent;
import net.pitan76.mcpitanlib.api.item.CompatibleItemSettings;
import net.pitan76.mcpitanlib.api.item.ExtendItem;
import net.pitan76.mcpitanlib.api.util.WorldUtil;
import net.pitan76.mcpitanlib.api.util.math.PosUtil;

public class Dynamite extends ExtendItem implements ProjectileItem {

    public boolean isSticky = false;
    public boolean isIndustrial = false;

    public Dynamite(CompatibleItemSettings settings) {
        super(settings);
        DispenserBlock.registerProjectileBehavior(this);
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

    @Override
    public TypedActionResult<ItemStack> onRightClick(ItemUseEvent e) {
        ItemStack stack = e.user.getStackInHand(e.hand);
        if (e.isClient()) return TypedActionResult.success(stack);

        if (!e.user.isCreative()) stack.decrement(1);

        DynamiteEntity dynamiteEntity = new DynamiteEntity(e.world, e.user.getEntity());
        dynamiteEntity.setVelocity(e.user.getPlayerEntity(), e.user.getPitch(), e.user.getYaw(), 0.0F, 1.5F, 1.0F);
        dynamiteEntity.callSetItem(stack);
        dynamiteEntity.setSticky(isSticky);
        dynamiteEntity.setIndustrial(isIndustrial);
        WorldUtil.spawnEntity(e.world, dynamiteEntity);
        BlockPos blockPos = PosUtil.flooredBlockPos(dynamiteEntity.getX(), dynamiteEntity.getY(), dynamiteEntity.getZ());
        WorldUtil.playSound(e.world, null, blockPos, SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);

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
