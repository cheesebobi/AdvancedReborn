package net.pitan76.advancedreborn;

import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import reborncore.common.crafting.RebornRecipe;
import reborncore.common.crafting.RebornRecipeType;
import reborncore.common.crafting.RecipeManager;

public class Recipes {
    public static RebornRecipeType<RebornRecipe> CANNING_MACHINE = RecipeManager.newRecipeType(AdvancedReborn.id("canning_machine"));

    public static RebornRecipeType<?> byName(Identifier identifier) {
        return (RebornRecipeType<?>) Registries.RECIPE_SERIALIZER.get(identifier);
    }

    public static void init() {

    }
}