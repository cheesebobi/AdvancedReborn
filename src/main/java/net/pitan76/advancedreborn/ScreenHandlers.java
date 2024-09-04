package net.pitan76.advancedreborn;

import net.minecraft.screen.ScreenHandlerType;
import net.pitan76.advancedreborn.screen.CardboardBoxScreenHandler;
import net.pitan76.mcpitanlib.api.gui.ExtendedScreenHandlerTypeBuilder;

import static net.pitan76.advancedreborn.AdvancedReborn.INSTANCE;
import static net.pitan76.advancedreborn.AdvancedReborn.registry;

public class ScreenHandlers {
    public static ScreenHandlerType<CardboardBoxScreenHandler> CARDBOARD_BOX_SCREEN_HANDLER = new ExtendedScreenHandlerTypeBuilder<>(CardboardBoxScreenHandler::new).build();

    public static void init() {
        registry.registerScreenHandlerType(INSTANCE.compatId("cardboard_box"), () -> CARDBOARD_BOX_SCREEN_HANDLER);
    }
}
