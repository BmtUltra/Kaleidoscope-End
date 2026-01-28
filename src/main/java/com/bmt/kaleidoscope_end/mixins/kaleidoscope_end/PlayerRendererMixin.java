package com.bmt.kaleidoscope_end.mixins.kaleidoscope_end;

import com.bmt.kaleidoscope_end.registry.KEEffects;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraftforge.fluids.FluidType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.function.BiPredicate;

@Mixin(PlayerRenderer.class)
public class PlayerRendererMixin {
    @WrapOperation(remap = false, method = "setupRotations(Lnet/minecraft/client/player/AbstractClientPlayer;Lcom/mojang/blaze3d/vertex/PoseStack;FFF)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/AbstractClientPlayer;isInFluidType(Ljava/util/function/BiPredicate;)Z"))
    private boolean warpIsInFluidType(AbstractClientPlayer instance, BiPredicate<FluidType, Double> biPredicate, Operation<Boolean> original) {
        if (instance.hasEffect(KEEffects.DREAM.get())) {
            return true;
        }
        return original.call(instance, biPredicate);
    }
}
