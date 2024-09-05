package net.pitan76.advancedreborn.addons.rei;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.plugin.common.BuiltinPlugin;
import net.minecraft.block.Block;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.pitan76.advancedreborn.AdvancedReborn;
import net.pitan76.advancedreborn.Blocks;
import net.pitan76.advancedreborn.Recipes;
import net.pitan76.advancedreborn.addons.autoconfig.AutoConfigAddon;
import net.pitan76.advancedreborn.addons.rei.machine.TwoInputRightOutputCategory;
import net.pitan76.mcpitanlib.api.registry.result.RegistryResult;
import net.pitan76.mcpitanlib.api.util.CompatIdentifier;
import reborncore.common.crafting.RebornRecipe;
import reborncore.common.crafting.RecipeManager;
import techreborn.client.compat.rei.MachineRecipeDisplay;
import techreborn.client.compat.rei.ReiPlugin;
import techreborn.client.compat.rei.fluidreplicator.FluidReplicatorRecipeDisplay;
import techreborn.client.compat.rei.rollingmachine.RollingMachineDisplay;
import techreborn.init.ModRecipes;
import techreborn.init.TRContent;
import techreborn.recipe.recipes.FluidReplicatorRecipe;
import techreborn.recipe.recipes.RollingMachineRecipe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static net.pitan76.advancedreborn.AdvancedReborn.INSTANCE;

public class REIAddon implements REIClientPlugin {

    public static CompatIdentifier PLUGIN = INSTANCE.compatId("advanced_plugin");

    public static Map<RecipeType<?>, RegistryResult<Block>> iconMap = new HashMap<>();

    public REIAddon() {
        iconMap.put(Recipes.CANNING_MACHINE, Blocks.CANNING_MACHINE);
        iconMap.put(ModRecipes.GRINDER, Blocks.ROTARY_GRINDER);
        iconMap.put(ModRecipes.EXTRACTOR, Blocks.CENTRIFUGAL_EXTRACTOR);
        iconMap.put(ModRecipes.COMPRESSOR, Blocks.SINGULARITY_COMPRESSOR);
    }

    public Identifier getPluginIdentifier() {
        return PLUGIN.toMinecraft();
    }

    public void registerCategories(CategoryRegistry recipeHelper) {
        recipeHelper.add(new TwoInputRightOutputCategory<>(Recipes.CANNING_MACHINE));
        registerOthers();
    }

    private void addWorkstations(Identifier identifier, EntryStack<?>... stacks) {
        CategoryRegistry.getInstance().addWorkstations(CategoryIdentifier.of(identifier), stacks);
    }

    public void registerDisplays(DisplayRegistry registry) {
        registerRecipeDisplays(registry);
    }

    public void registerRecipeDisplays(DisplayRegistry recipeHelper) {
        RecipeManager.getRecipeTypes(AdvancedReborn.MOD_ID).forEach(recipeType -> registerMachineRecipe(recipeHelper, recipeType));
    }

    private <R extends RebornRecipe> void registerMachineRecipe(DisplayRegistry registry, RecipeType<?> recipeType) {
        if (recipeType != ModRecipes.RECYCLER) {
            Function<RecipeEntry<RebornRecipe>, Display> recipeDisplay = MachineRecipeDisplay::new;
            if (recipeType == ModRecipes.ROLLING_MACHINE) {
                recipeDisplay = (r) -> {
                    RollingMachineRecipe rollingMachineRecipe = (RollingMachineRecipe)r.value();
                    return new RollingMachineDisplay(new RecipeEntry<>(Registries.RECIPE_TYPE.getId(recipeType), rollingMachineRecipe.getShapedRecipe()));
                };
            }

            if (recipeType == ModRecipes.FLUID_REPLICATOR) {
                recipeDisplay = (r) -> {
                    FluidReplicatorRecipe recipe = (FluidReplicatorRecipe)r.value();
                    return new FluidReplicatorRecipeDisplay(new RecipeEntry<>(Registries.RECIPE_TYPE.getId(recipeType), recipe));
                };
            }

            registry.registerRecipeFiller(RebornRecipe.class, (recipeType1) -> true, (recipeEntry) -> recipeEntry.value().getType() == recipeType, recipeDisplay);
        }
    }

    public void registerOthers() {
        if (AutoConfigAddon.getConfig().linkReiWithTR) registerOthersTR();
        if (AutoConfigAddon.getConfig().linkReiWithAR) {
            addWorkstations(Registries.RECIPE_TYPE.getId(Recipes.CANNING_MACHINE), EntryStacks.of(Blocks.CANNING_MACHINE.get()));
            addWorkstations(Registries.RECIPE_TYPE.getId(ModRecipes.GRINDER), EntryStacks.of(Blocks.ROTARY_GRINDER.get()));
            addWorkstations(Registries.RECIPE_TYPE.getId(ModRecipes.EXTRACTOR), EntryStacks.of(Blocks.CENTRIFUGAL_EXTRACTOR.get()));
            addWorkstations(Registries.RECIPE_TYPE.getId(ModRecipes.COMPRESSOR), EntryStacks.of(Blocks.SINGULARITY_COMPRESSOR.get()));
            addWorkstations(BuiltinPlugin.SMELTING.getIdentifier(), EntryStacks.of(Blocks.INDUCTION_FURNACE.get()));
        }
    }

    public void registerOthersTR() {
        addWorkstations(BuiltinPlugin.SMELTING.getIdentifier(), EntryStacks.of(TRContent.Machine.IRON_FURNACE));
        addWorkstations(BuiltinPlugin.SMELTING.getIdentifier(), EntryStacks.of(TRContent.Machine.ELECTRIC_FURNACE));
    }
}
