package net.pitan76.advancedreborn.addons.rei;

import me.shedaniel.rei.api.BuiltinPlugin;
import me.shedaniel.rei.api.EntryStack;
import me.shedaniel.rei.api.RecipeDisplay;
import me.shedaniel.rei.api.RecipeHelper;
import me.shedaniel.rei.api.plugins.REIPluginV0;
import net.minecraft.recipe.Recipe;
import net.minecraft.util.Identifier;
import net.pitan76.advancedreborn.AdvancedReborn;
import net.pitan76.advancedreborn.Blocks;
import net.pitan76.advancedreborn.Recipes;
import net.pitan76.advancedreborn.addons.autoconfig.AutoConfigAddon;
import net.pitan76.advancedreborn.addons.rei.machine.TwoInputRightOutputCategory;
import reborncore.common.crafting.RebornRecipe;
import reborncore.common.crafting.RebornRecipeType;
import reborncore.common.crafting.RecipeManager;
import techreborn.compat.rei.MachineRecipeDisplay;
import techreborn.compat.rei.ReiPlugin;
import techreborn.init.ModRecipes;
import techreborn.init.TRContent;

import java.util.function.Function;
import java.util.function.Predicate;

public class REIAddon implements REIPluginV0 {

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

    public void registerPluginCategories(RecipeHelper recipeHelper) {
        recipeHelper.registerCategory(new TwoInputRightOutputCategory<>(Recipes.CANNING_MACHINE));
    }

    public void registerRecipeDisplays(RecipeHelper recipeHelper) {
        RecipeManager.getRecipeTypes(AdvancedReborn.MOD_ID).forEach(rebornRecipeType -> registerMachineRecipe(recipeHelper, rebornRecipeType));
    }

    public <R extends RebornRecipe> void registerMachineRecipe(RecipeHelper recipeHelper, RebornRecipeType<R> recipeType) {
        Function<R, RecipeDisplay> recipeDisplay = r -> new MachineRecipeDisplay<>((RebornRecipe) r);
        recipeHelper.registerRecipes(recipeType.getName(), (Predicate<Recipe>) recipe -> {
            if (recipe instanceof RebornRecipe) {
                return ((RebornRecipe) recipe).getRebornRecipeType() == recipeType;
            }
            return false;
        }, recipeDisplay);
    }

    public void registerOthers(RecipeHelper recipeHelper) {
        if (AutoConfigAddon.getConfig().linkReiWithTR) registerOthersTR(recipeHelper);
        if (AutoConfigAddon.getConfig().linkReiWithAR) {
            recipeHelper.registerWorkingStations(Recipes.CANNING_MACHINE.getName(), EntryStack.create(Blocks.CANNING_MACHINE));
            recipeHelper.registerWorkingStations(ModRecipes.GRINDER.getName(), EntryStack.create(Blocks.ROTARY_GRINDER));
            recipeHelper.registerWorkingStations(ModRecipes.EXTRACTOR.getName(), EntryStack.create(Blocks.CENTRIFUGAL_EXTRACTOR));
            recipeHelper.registerWorkingStations(ModRecipes.COMPRESSOR.getName(), EntryStack.create(Blocks.SINGULARITY_COMPRESSOR));
            recipeHelper.registerWorkingStations(BuiltinPlugin.SMELTING, EntryStack.create(Blocks.INDUCTION_FURNACE));
        }
    }

    public void registerOthersTR(RecipeHelper recipeHelper) {
        recipeHelper.registerWorkingStations(BuiltinPlugin.SMELTING, EntryStack.create(TRContent.Machine.IRON_FURNACE));
        recipeHelper.registerWorkingStations(BuiltinPlugin.SMELTING, EntryStack.create(TRContent.Machine.ELECTRIC_FURNACE));
    }
}
