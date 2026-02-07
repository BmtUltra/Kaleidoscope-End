package com.bmt.kaleidoscope_end.mixins.kaleidoscope_end;

import com.bmt.kaleidoscope_end.registry.KEEffects;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.fluids.FluidType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.BiPredicate;

@Mixin(Entity.class)
public abstract class EntityMixin {

    @Inject(remap = false, method = "getFluidTypeHeight", at = @At("RETURN"), cancellable = true)
    private void getFluidTypeHeight(FluidType type, CallbackInfoReturnable<Double> cir) {
        if (type == NeoForgeMod.EMPTY_TYPE.value()) {
            if ((Object) this instanceof Player player) {
                if (player.hasEffect(KEEffects.DREAM)) {
                    cir.setReturnValue(1D);
                }
            }
        }
    }

    @WrapOperation(method = "updateSwimming", at = @At(remap = false, value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;canStartSwimming()Z"))
    private boolean warpCanStartSwimming(Entity instance, Operation<Boolean> original) {
        if ((Object) this instanceof Player player) {
            if (player.hasEffect(KEEffects.DREAM)) {
                return true;
            }
        }
        return original.call(instance);
    }

    @WrapOperation(method = {"updateSwimming", "isVisuallyCrawling"}, at = @At(remap = false, value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;isInFluidType(Ljava/util/function/BiPredicate;)Z"))
    private boolean warpIsInFluidType(Entity instance, BiPredicate<FluidType, Double> biPredicate, Operation<Boolean> original) {
        if ((Object) this instanceof Player player) {
            if (player.hasEffect(KEEffects.DREAM)) {
                return true;
            }
        }
        return original.call(instance, biPredicate);
    }

    @Inject(remap = false, method = "isInFluidType()Z", at = @At("RETURN"), cancellable = true)
    private void isInFluidType(CallbackInfoReturnable<Boolean> cir) {
        if ((Object) this instanceof Player player) {
            if (player.hasEffect(KEEffects.DREAM)) {
                cir.setReturnValue(true);
            }
        }
    }
}
