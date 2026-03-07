package org.zickit.noGibberish.mixin;

import net.minecraft.text.Style;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Style.class)
public class StyleMixin {
    /**
     * This targets the getter for the 'obfuscated' property.
     * By forcing it to return false, the §k code is effectively disabled globally.
     */
    @Inject(method = "isObfuscated", at = @At("HEAD"), cancellable = true)
    private void onIsObfuscated(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}