package ml.pkom.advancedreborn.items;

import ml.pkom.mcpitanlibarch.api.item.CompatibleItemSettings;
import ml.pkom.mcpitanlibarch.api.item.ExtendItem;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class FuelCanItem extends ExtendItem {
    public FuelCanItem(CompatibleItemSettings settings) {
        super(settings);
        FuelRegistry.INSTANCE.add(this, 2000);
    }
}
