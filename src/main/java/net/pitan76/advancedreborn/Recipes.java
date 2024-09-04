package net.pitan76.advancedreborn;

import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import reborncore.common.crafting.RebornRecipe;
import reborncore.common.crafting.RecipeManager;

public class Recipes {
    public static RecipeType<RebornRecipe> CANNING_MACHINE = RecipeManager.newRecipeType(AdvancedReborn.id("canning_machine"));

    public static RecipeType<?> byName(Identifier identifier) {
        return (RecipeType<?>) Registries.RECIPE_SERIALIZER.get(identifier);
    }

    public static void init() {

    }
}
