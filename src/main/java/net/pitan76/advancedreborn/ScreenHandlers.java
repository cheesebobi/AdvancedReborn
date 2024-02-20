package net.pitan76.advancedreborn;

import net.fabricmc.fabric.impl.screenhandler.ExtendedScreenHandlerType;
import net.minecraft.screen.ScreenHandlerType;
import net.pitan76.advancedreborn.screen.CardboardBoxScreenHandler;

import static net.pitan76.advancedreborn.AdvancedReborn.registry;

public class ScreenHandlers {
    public static ScreenHandlerType<CardboardBoxScreenHandler> CARDBOARD_BOX_SCREEN_HANDLER = new ExtendedScreenHandlerType<>(CardboardBoxScreenHandler::new);

    public static void init() {
        registry.registerScreenHandlerType(AdvancedReborn.id("cardboard_box"), () -> CARDBOARD_BOX_SCREEN_HANDLER);
    }
}
