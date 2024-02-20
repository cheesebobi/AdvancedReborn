package net.pitan76.advancedreborn.addons.computercraft;

import net.pitan76.advancedreborn.AdvancedReborn;
import org.apache.logging.log4j.Level;

public class ComputerCraftAddon {

    public static void init() {
        // data/techreborn/computercraft/turtle_upgrades/*.jsonで定義しているので、ここでは何もしない
        AdvancedReborn.log(Level.INFO, "Found ComputerCraft");
    }
}
