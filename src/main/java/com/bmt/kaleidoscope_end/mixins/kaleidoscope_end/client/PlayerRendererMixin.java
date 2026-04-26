package com.bmt.kaleidoscope_end.mixins.kaleidoscope_end.client;

import com.bmt.kaleidoscope_end.init.KEEffects;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.neoforged.neoforge.fluids.FluidType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.function.BiPredicate;

@Mixin(PlayerRenderer.class)
public class PlayerRendererMixin {
    @WrapOperation(method = "setupRotations*", at = @At(remap = false, value = "INVOKE", target = "Lnet/minecraft/client/player/AbstractClientPlayer;isInFluidType(Ljava/util/function/BiPredicate;)Z"))
    private boolean warpIsInFluidType(AbstractClientPlayer instance, BiPredicate<FluidType, Double> biPredicate, Operation<Boolean> original) {
        if (instance.hasEffect(KEEffects.DREAM)) {
            return true;
        }
        return original.call(instance, biPredicate);
    }
}
