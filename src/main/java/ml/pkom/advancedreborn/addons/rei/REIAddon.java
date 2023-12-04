package ml.pkom.advancedreborn.addons.rei;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.plugin.common.BuiltinPlugin;
import ml.pkom.advancedreborn.AdvancedReborn;
import ml.pkom.advancedreborn.Blocks;
import ml.pkom.advancedreborn.Recipes;
import ml.pkom.advancedreborn.addons.autoconfig.AutoConfigAddon;
import ml.pkom.advancedreborn.addons.rei.machine.TwoInputRightOutputCategory;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.util.Identifier;
import reborncore.common.crafting.RebornRecipe;
import reborncore.common.crafting.RebornRecipeType;
import reborncore.common.crafting.RecipeManager;
import techreborn.api.recipe.recipes.FluidReplicatorRecipe;
import techreborn.api.recipe.recipes.RollingMachineRecipe;
import techreborn.client.compat.rei.MachineRecipeDisplay;
import techreborn.client.compat.rei.ReiPlugin;
import techreborn.client.compat.rei.fluidreplicator.FluidReplicatorRecipeDisplay;
import techreborn.client.compat.rei.rollingmachine.RollingMachineDisplay;
import techreborn.init.ModRecipes;
import techreborn.init.TRContent;

import java.util.function.Function;

public class REIAddon implements REIClientPlugin {

    public static Identifier PLUGIN = AdvancedReborn.id("advanced_plugin");

    //public static Map<RebornRecipeType<?>, ItemConvertible> iconMap = new HashMap<>();

    public REIAddon() {
        ReiPlugin.iconMap.put(Recipes.CANNING_MACHINE, Blocks.CANNING_MACHINE);
        ReiPlugin.iconMap.put(ModRecipes.GRINDER, Blocks.ROTARY_GRINDER);
        ReiPlugin.iconMap.put(ModRecipes.EXTRACTOR, Blocks.CENTRIFUGAL_EXTRACTOR);
        ReiPlugin.iconMap.put(ModRecipes.COMPRESSOR, Blocks.SINGULARITY_COMPRESSOR);
    }

    public Identifier getPluginIdentifier() {
        return PLUGIN;
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
        RecipeManager.getRecipeTypes(AdvancedReborn.MOD_ID).forEach(rebornRecipeType -> registerMachineRecipe(recipeHelper, rebornRecipeType));
    }

    private <R extends RebornRecipe> void registerMachineRecipe(DisplayRegistry registry, RebornRecipeType<R> recipeType) {
        if (recipeType != ModRecipes.RECYCLER) {
            Function<RecipeEntry<RebornRecipe>, Display> recipeDisplay = MachineRecipeDisplay::new;
            if (recipeType == ModRecipes.ROLLING_MACHINE) {
                recipeDisplay = (r) -> {
                    RollingMachineRecipe rollingMachineRecipe = (RollingMachineRecipe)r.value();
                    return new RollingMachineDisplay(new RecipeEntry(recipeType.name(), rollingMachineRecipe.getShapedRecipe()));
                };
            }

            if (recipeType == ModRecipes.FLUID_REPLICATOR) {
                recipeDisplay = (r) -> {
                    FluidReplicatorRecipe recipe = (FluidReplicatorRecipe)r.value();
                    return new FluidReplicatorRecipeDisplay(new RecipeEntry(recipeType.name(), recipe));
                };
            }

            registry.registerRecipeFiller(RebornRecipe.class, (recipeType1) -> true, (recipeEntry) -> recipeEntry.value().getRebornRecipeType() == recipeType, recipeDisplay);
        }
    }

    public void registerOthers() {
        if (AutoConfigAddon.getConfig().linkReiWithTR) registerOthersTR();
        if (AutoConfigAddon.getConfig().linkReiWithAR) {
            addWorkstations(Recipes.CANNING_MACHINE.name(), EntryStacks.of(Blocks.CANNING_MACHINE));
            addWorkstations(ModRecipes.GRINDER.name(), EntryStacks.of(Blocks.ROTARY_GRINDER));
            addWorkstations(ModRecipes.EXTRACTOR.name(), EntryStacks.of(Blocks.CENTRIFUGAL_EXTRACTOR));
            addWorkstations(ModRecipes.COMPRESSOR.name(), EntryStacks.of(Blocks.SINGULARITY_COMPRESSOR));
            addWorkstations(BuiltinPlugin.SMELTING.getIdentifier(), EntryStacks.of(Blocks.INDUCTION_FURNACE));
        }
    }

    public void registerOthersTR() {
        addWorkstations(BuiltinPlugin.SMELTING.getIdentifier(), EntryStacks.of(TRContent.Machine.IRON_FURNACE));
        addWorkstations(BuiltinPlugin.SMELTING.getIdentifier(), EntryStacks.of(TRContent.Machine.ELECTRIC_FURNACE));
    }
}
