package com.client.mod.mixin;

import com.client.mod.CustomClientMod;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public abstract class GameRendererMixin {

    @Shadow
    public abstract void loadPostProcessor(Identifier id);

    @Shadow
    public abstract boolean hasShader();

    @Inject(method = "render", at = @At("HEAD"))
    private void onRender(CallbackInfo ci) {
        // تفعيل الموشن بلور إذا كان الخيار مفعلاً والشيدر غير محمل
        if (CustomClientMod.motionBlurEnabled && !this.hasShader()) {
            try {
                this.loadPostProcessor(Identifier.of("minecraft", "shaders/post/blur.json"));
            } catch (Exception ignored) {
            }
        }
    }
}
