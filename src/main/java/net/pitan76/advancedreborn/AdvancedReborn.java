package net.pitan76.advancedreborn;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.pitan76.advancedreborn.blocks.RaySolar;
import net.pitan76.mcpitanlib.api.item.CreativeTabBuilder;
import net.pitan76.mcpitanlib.api.item.CreativeTabManager;
import net.pitan76.mcpitanlib.api.registry.result.RegistryResult;
import net.pitan76.mcpitanlib.api.registry.v2.CompatRegistryV2;
import net.pitan76.mcpitanlib.api.util.IdentifierUtil;
import net.pitan76.mcpitanlib.api.util.ItemStackUtil;
import net.pitan76.mcpitanlib.fabric.ExtendModInitializer;

import java.util.ArrayList;
import java.util.List;

public class AdvancedReborn extends ExtendModInitializer {
    public static final String MOD_ID = "advanced_reborn";
    public static final String MOD_NAME = "Advanced Reborn";

    public static AdvancedReborn INSTANCE;
    public static CompatRegistryV2 registry;

    public static void log(String message) {
        INSTANCE.logger.info("[" + MOD_NAME + "] " + message);
    }

    // Add ItemGroup
    public static DefaultedList<ItemStack> addStacksIG = DefaultedList.of();

    public static CreativeTabBuilder AR_GROUP;

    @Override
    public void init() {
        INSTANCE = this;
        registry = super.registry;

        AR_GROUP = CreativeTabBuilder.create(
                        INSTANCE.compatId("item_group")).
                setIcon(() -> ItemStackUtil.create(Items.CHARGE_PAD_MK_FINAL, 1));
        RegistryResult<ItemGroup> result = registry.registerItemGroup(compatId("item_group"), AR_GROUP);

        ModManager.beforeInit();
        Items.init();
        Blocks.init();
        Entities.init();
        Tiles.init();
        GuiTypes.init();
        Recipes.init();
        Particles.init();
        ScreenHandlers.init();
        ARDispenserBehavior.init();
        Network.init();
        ModManager.afterInit();

        if (!addStacksIG.isEmpty()) {
            for (ItemStack stack : addStacksIG) {
                CreativeTabManager.addStack(result::getOrNull, stack);
            }
        }
    }

    public static List<RaySolar> solars = new ArrayList<>();

    static {
        solars.add((RaySolar) Blocks.RAY_SOLAR_1);
    }

    public static Identifier _id(String id) {
        return IdentifierUtil.id(MOD_ID, id);
    }

    @Override
    public String getId() {
        return MOD_ID;
    }

    @Override
    public String getName() {
        return MOD_NAME;
    }
}