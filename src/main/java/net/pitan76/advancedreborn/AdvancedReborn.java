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
import net.pitan76.mcpitanlib.api.util.CompatIdentifier;
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
        RegistryResult<ItemGroup> result = registry.registerItemGroup(AR_GROUP);

        ModManager.beforeInit();

        registry.registerItem(INSTANCE.compatId("charge_pad"), () -> Items.CHARGE_PAD_MK_1);
        registry.registerItem(INSTANCE.compatId("charge_pad_2"), () -> Items.CHARGE_PAD_MK_2);
        registry.registerItem(INSTANCE.compatId("charge_pad_3"), () -> Items.CHARGE_PAD_MK_3);
        registry.registerItem(INSTANCE.compatId("charge_pad_4"), () -> Items.CHARGE_PAD_MK_4);
        registry.registerItem(INSTANCE.compatId("charge_pad_final"), () -> Items.CHARGE_PAD_MK_FINAL);

        registry.registerItem(INSTANCE.compatId("ray_solar_panel"), () -> Items.RAY_SOLAR_1);
        registry.registerItem(INSTANCE.compatId("ray_solar_panel_2"), () -> Items.RAY_SOLAR_2);
        registry.registerItem(INSTANCE.compatId("ray_solar_panel_3"), () -> Items.RAY_SOLAR_3);
        registry.registerItem(INSTANCE.compatId("ray_solar_panel_4"), () -> Items.RAY_SOLAR_4);
        registry.registerItem(INSTANCE.compatId("ray_generator"), () -> Items.RAY_GENERATOR_1);
        registry.registerItem(INSTANCE.compatId("ray_generator_2"), () -> Items.RAY_GENERATOR_2);
        registry.registerItem(INSTANCE.compatId("ray_generator_3"), () -> Items.RAY_GENERATOR_3);
        registry.registerItem(INSTANCE.compatId("ray_generator_4"), () -> Items.RAY_GENERATOR_4);
        registry.registerItem(INSTANCE.compatId("ray_generator_5"), () -> Items.RAY_GENERATOR_5);
        registry.registerItem(INSTANCE.compatId("ray_generator_6"), () -> Items.RAY_GENERATOR_6);
        registry.registerItem(INSTANCE.compatId("ray_generator_7"), () -> Items.RAY_GENERATOR_7);
        registry.registerItem(INSTANCE.compatId("ray_generator_8"), () -> Items.RAY_GENERATOR_8);
        registry.registerItem(INSTANCE.compatId("ray_generator_9"), () -> Items.RAY_GENERATOR_9);
        registry.registerItem(INSTANCE.compatId("ray_generator_10"), () -> Items.RAY_GENERATOR_10);

        registry.registerItem(INSTANCE.compatId("induction_furnace"), () -> Items.INDUCTION_FURNACE);
        registry.registerItem(INSTANCE.compatId("rotary_grinder"), () -> Items.ROTARY_GRINDER);
        registry.registerItem(INSTANCE.compatId("centrifugal_extractor"), () -> Items.CENTRIFUGAL_EXTRACTOR);
        registry.registerItem(INSTANCE.compatId("singularity_compressor"), () -> Items.SINGULARITY_COMPRESSOR);
        registry.registerItem(INSTANCE.compatId("canning_machine"), () -> Items.CANNING_MACHINE);
        registry.registerItem(INSTANCE.compatId("renaming_machine"), () -> Items.RENAMING_MACHINE);
        registry.registerItem(INSTANCE.compatId("teleporter"), () -> Items.TELEPORTER);
        registry.registerItem(INSTANCE.compatId("farming_machine"), () -> Items.FARMING_MACHINE);
        registry.registerItem(INSTANCE.compatId("logging_machine"), () -> Items.LOGGING_MACHINE);
        registry.registerItem(INSTANCE.compatId("fertilizer_spreader"), () -> Items.FERTILIZER_SPREADER);
        registry.registerItem(INSTANCE.compatId("enchantment_extractor"), () -> Items.ENCHANTMENT_EXTRACTOR);

        registry.registerItem(INSTANCE.compatId("freq_trans"), () -> Items.FREQ_TRANS);
        registry.registerItem(INSTANCE.compatId("config_wrench"), () -> Items.CONFIG_WRENCH);
        registry.registerItem(INSTANCE.compatId("forge_hammer"), () -> Items.FORGE_HAMMER);
        registry.registerItem(INSTANCE.compatId("advanced_forge_hammer"), () -> Items.ADVANCED_FORGE_HAMMER);
        registry.registerItem(INSTANCE.compatId("dynamite"), () -> Items.DYNAMITE);
        registry.registerItem(INSTANCE.compatId("sticky_dynamite"), () -> Items.STICKY_DYNAMITE);
        registry.registerItem(INSTANCE.compatId("industrial_dynamite"), () -> Items.INDUSTRIAL_DYNAMITE);
        registry.registerItem(INSTANCE.compatId("industrial_sticky_dynamite"), () -> Items.INDUSTRIAL_STICKY_DYNAMITE);
        registry.registerItem(INSTANCE.compatId("industrial_tnt"), () -> Items.INDUSTRIAL_TNT);
        registry.registerItem(INSTANCE.compatId("light"), () -> Items.LIGHT);
        registry.registerItem(INSTANCE.compatId("cardboard_box"), () -> Items.CARDBOARD_BOX);
        registry.registerItem(INSTANCE.compatId("cardboard_box_minetaro"), () -> Items.CARDBOARD_BOX_MINETARO);
        registry.registerItem(INSTANCE.compatId("cardboard_box_minezon"), () -> Items.CARDBOARD_BOX_MINEZON);
        registry.registerItem(INSTANCE.compatId("cardboard_box_nothing_logo"), () -> Items.CARDBOARD_BOX_NOTHING);

        registry.registerItem(INSTANCE.compatId("advanced_battery"), () -> Items.ADVANCED_BATTERY);
        registry.registerItem(INSTANCE.compatId("advanced_battery_2"), () -> Items.ADVANCED_BATTERY_2);
        registry.registerItem(INSTANCE.compatId("advanced_battery_3"), () -> Items.ADVANCED_BATTERY_3);
        registry.registerItem(INSTANCE.compatId("advanced_battery_4"), () -> Items.ADVANCED_BATTERY_4);
        registry.registerItem(INSTANCE.compatId("advanced_battery_5"), () -> Items.ADVANCED_BATTERY_5);

        //registry.registerItem(INSTANCE.compatId("nano_helmet"), () -> Items.NANO_SUIT_HELMET);
        //registry.registerItem(INSTANCE.compatId("nano_chestplate"), () -> Items.NANO_SUIT_BODY_ARMOR);
        //registry.registerItem(INSTANCE.compatId("nano_leggings"), () -> Items.NANO_SUIT_LEGGINGS);
        //registry.registerItem(INSTANCE.compatId("nano_boots"), () -> Items.NANO_SUIT_BOOTS);

        registry.registerItem(INSTANCE.compatId("empty_can"), () -> Items.EMPTY_CAN);
        registry.registerItem(INSTANCE.compatId("fuel_can"), () -> Items.FUEL_CAN);
        registry.registerItem(INSTANCE.compatId("food_can"), () -> Items.FOOD_CAN);
        registry.registerItem(INSTANCE.compatId("cardboard_sheet"), () -> Items.CARDBOARD_SHEET);
        registry.registerItem(INSTANCE.compatId("duct_tape"), () -> Items.DUCT_TAPE);

        registry.registerItem(CompatIdentifier.of("better_batpack:batpack4"), () -> Items.BATPACK_4);
        registry.registerItem(CompatIdentifier.of("better_batpack:batpack16"), () -> Items.BATPACK_16);
        registry.registerItem(CompatIdentifier.of("better_batpack:batpack64"), () -> Items.BATPACK_64);
        registry.registerItem(CompatIdentifier.of("better_batpack:batpack128"), () -> Items.BATPACK_128);

        //registry.registerItem(INSTANCE.compatId("z_add_items"), () -> Items.ADD_ITEMS);



        registry.registerBlock(INSTANCE.compatId("charge_pad"), () -> Blocks.CHARGE_PAD_MK_1);
        registry.registerBlock(INSTANCE.compatId("charge_pad_2"), () -> Blocks.CHARGE_PAD_MK_2);
        registry.registerBlock(INSTANCE.compatId("charge_pad_3"), () -> Blocks.CHARGE_PAD_MK_3);
        registry.registerBlock(INSTANCE.compatId("charge_pad_4"), () -> Blocks.CHARGE_PAD_MK_4);
        registry.registerBlock(INSTANCE.compatId("charge_pad_final"), () -> Blocks.CHARGE_PAD_MK_FINAL);

        registry.registerBlock(INSTANCE.compatId("ray_solar_panel"), () -> Blocks.RAY_SOLAR_1);
        registry.registerBlock(INSTANCE.compatId("ray_solar_panel_2"), () -> Blocks.RAY_SOLAR_2);
        registry.registerBlock(INSTANCE.compatId("ray_solar_panel_3"), () -> Blocks.RAY_SOLAR_3);
        registry.registerBlock(INSTANCE.compatId("ray_solar_panel_4"), () -> Blocks.RAY_SOLAR_4);
        registry.registerBlock(INSTANCE.compatId("ray_generator"), () -> Blocks.RAY_GENERATOR_1);
        registry.registerBlock(INSTANCE.compatId("ray_generator_2"), () -> Blocks.RAY_GENERATOR_2);
        registry.registerBlock(INSTANCE.compatId("ray_generator_3"), () -> Blocks.RAY_GENERATOR_3);
        registry.registerBlock(INSTANCE.compatId("ray_generator_4"), () -> Blocks.RAY_GENERATOR_4);
        registry.registerBlock(INSTANCE.compatId("ray_generator_5"), () -> Blocks.RAY_GENERATOR_5);
        registry.registerBlock(INSTANCE.compatId("ray_generator_6"), () -> Blocks.RAY_GENERATOR_6);
        registry.registerBlock(INSTANCE.compatId("ray_generator_7"), () -> Blocks.RAY_GENERATOR_7);
        registry.registerBlock(INSTANCE.compatId("ray_generator_8"), () -> Blocks.RAY_GENERATOR_8);
        registry.registerBlock(INSTANCE.compatId("ray_generator_9"), () -> Blocks.RAY_GENERATOR_9);
        registry.registerBlock(INSTANCE.compatId("ray_generator_10"), () -> Blocks.RAY_GENERATOR_10);

        registry.registerBlock(INSTANCE.compatId("induction_furnace"), () -> Blocks.INDUCTION_FURNACE);
        registry.registerBlock(INSTANCE.compatId("rotary_grinder"), () -> Blocks.ROTARY_GRINDER);
        registry.registerBlock(INSTANCE.compatId("centrifugal_extractor"), () -> Blocks.CENTRIFUGAL_EXTRACTOR);
        registry.registerBlock(INSTANCE.compatId("singularity_compressor"), () -> Blocks.SINGULARITY_COMPRESSOR);
        registry.registerBlock(INSTANCE.compatId("canning_machine"), () -> Blocks.CANNING_MACHINE);
        registry.registerBlock(INSTANCE.compatId("renaming_machine"), () -> Blocks.RENAMING_MACHINE);
        registry.registerBlock(INSTANCE.compatId("teleporter"), () -> Blocks.TELEPORTER);
        registry.registerBlock(INSTANCE.compatId("farming_machine"), () -> Blocks.FARMING_MACHINE);
        registry.registerBlock(INSTANCE.compatId("logging_machine"), () -> Blocks.LOGGING_MACHINE);
        registry.registerBlock(INSTANCE.compatId("fertilizer_spreader"), () -> Blocks.FERTILIZER_SPREADER);
        registry.registerBlock(INSTANCE.compatId("enchantment_extractor"), () -> Blocks.ENCHANTMENT_EXTRACTOR);

        registry.registerBlock(INSTANCE.compatId("industrial_tnt"), () -> Blocks.INDUSTRIAL_TNT);
        registry.registerBlock(INSTANCE.compatId("light"), () -> Blocks.LIGHT);
        registry.registerBlock(INSTANCE.compatId("cardboard_box"), () -> Blocks.CARDBOARD_BOX);
        registry.registerBlock(INSTANCE.compatId("cardboard_box_minetaro"), () -> Blocks.CARDBOARD_BOX_MINETARO);
        registry.registerBlock(INSTANCE.compatId("cardboard_box_minezon"), () -> Blocks.CARDBOARD_BOX_MINEZON);
        registry.registerBlock(INSTANCE.compatId("cardboard_box_nothing_logo"), () -> Blocks.CARDBOARD_BOX_NOTHING);

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
        //solars.add((RaySolar) Blocks.RAY_SOLAR_1);
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