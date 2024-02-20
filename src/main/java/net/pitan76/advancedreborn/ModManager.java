package net.pitan76.advancedreborn;

import net.fabricmc.loader.api.FabricLoader;

public class ModManager {
    public static void beforeInit() {
        if (FabricLoader.getInstance().isModLoaded("autoconfig1u")) {
            net.pitan76.advancedreborn.addons.autoconfig.AutoConfigAddon.init();
        }
    }

    public static void afterInit() {
    }

    public static void initAfterLoadedTR() {
        /*
        if (FabricLoader.getInstance().isModLoaded("computercraft")) {
            if (AutoConfigAddon.getConfig().linkComputerCraft) net.pitan76.advancedreborn.addons.computercraft.ComputerCraftAddon.init();
        }
         */
    }
}
