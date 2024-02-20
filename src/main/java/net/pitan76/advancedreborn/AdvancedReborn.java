package net.pitan76.advancedreborn;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.pitan76.advancedreborn.blocks.RaySolar;
import net.pitan76.mcpitanlib.api.item.CreativeTabBuilder;
import net.pitan76.mcpitanlib.api.item.CreativeTabManager;
import net.pitan76.mcpitanlib.api.registry.CompatRegistry;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class AdvancedReborn implements ModInitializer {
    public static final String MOD_ID = "advanced_reborn";
    public static final String MOD_NAME = "Advanced Reborn";
    public static Logger LOGGER = LogManager.getLogger();
    public static void log(Level level, String message){
        LOGGER.log(level, "[" + MOD_NAME + "] " + message);
    }

    public static CompatRegistry registry = CompatRegistry.createRegistry(MOD_ID);

    // Add ItemGroup
    public static DefaultedList<ItemStack> addStacksIG = DefaultedList.of();

    public static ItemGroup AR_GROUP = CreativeTabBuilder.create(
            id("item_group")).
            setIcon(() -> new ItemStack(Items.CHARGE_PAD_MK_FINAL, 1)).
            build();

    @Override
    public void onInitialize() {
        registry.registerItemGroup(id("item_group"), () -> AR_GROUP);

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
                CreativeTabManager.addStack(() -> AR_GROUP, stack);
            }
        }

        registry.allRegister();
    }

    public static List<RaySolar> solars = new ArrayList<>();

    static {
        solars.add((RaySolar) Blocks.RAY_SOLAR_1);
    }

    public static Identifier id(String id) {
        return new Identifier(MOD_ID, id);
    }
}