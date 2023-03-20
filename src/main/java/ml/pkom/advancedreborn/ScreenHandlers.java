package ml.pkom.advancedreborn;

import ml.pkom.advancedreborn.screen.CardboardBoxScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.screen.ScreenHandlerType;

import static ml.pkom.advancedreborn.AdvancedReborn.registry;

public class ScreenHandlers {
    public static ScreenHandlerType<CardboardBoxScreenHandler> CARDBOARD_BOX_SCREEN_HANDLER = new ExtendedScreenHandlerType<>(CardboardBoxScreenHandler::new);

    public static void init() {
        registry.registerScreenHandlerType(AdvancedReborn.id("cardboard_box"), () -> CARDBOARD_BOX_SCREEN_HANDLER);
    }
}
