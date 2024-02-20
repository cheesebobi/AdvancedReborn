package net.pitan76.advancedreborn.mixins;

import net.pitan76.advancedreborn.ModManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import techreborn.TechReborn;

@Mixin(TechReborn.class)
public class TechRebornMixin {
    @Inject(method = "onInitialize", at = @At("TAIL"), remap = false)
    public void onInitialize(CallbackInfo ci) {
        ModManager.initAfterLoadedTR();
    }
}
