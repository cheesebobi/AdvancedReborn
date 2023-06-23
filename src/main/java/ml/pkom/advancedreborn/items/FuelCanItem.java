package ml.pkom.advancedreborn.items;

import ml.pkom.mcpitanlibarch.api.item.CompatibleItemSettings;
import ml.pkom.mcpitanlibarch.api.item.ExtendItem;
import ml.pkom.mcpitanlibarch.api.registry.ArchRegistry;

public class FuelCanItem extends ExtendItem {
    public FuelCanItem(CompatibleItemSettings settings) {
        super(settings);
        ArchRegistry.registerFuel(2000, this);
    }
}
