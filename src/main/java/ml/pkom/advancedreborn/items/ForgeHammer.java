package ml.pkom.advancedreborn.items;

import ml.pkom.mcpitanlibarch.api.item.CompatibleItemSettings;
import ml.pkom.mcpitanlibarch.api.item.ExtendItem;

public class ForgeHammer extends ExtendItem {
    public ForgeHammer(CompatibleItemSettings settings, int damage) {
        super(settings.maxDamage(damage));
    }
}
