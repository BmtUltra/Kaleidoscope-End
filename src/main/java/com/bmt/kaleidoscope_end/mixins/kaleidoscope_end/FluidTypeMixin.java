package com.bmt.kaleidoscope_end.mixins.kaleidoscope_end;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.bmt.kaleidoscope_end.registry.KEEffects;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.fluids.FluidType;

@Mixin(FluidType.class)
public class FluidTypeMixin {
    @Inject(remap = false, method = "canSwim", at = @At("RETURN"), cancellable = true)
    private void canSwim(Entity entity, CallbackInfoReturnable<Boolean> cir) {
        FluidType fluidType = (FluidType) (Object) this;
        if (fluidType == NeoForgeMod.EMPTY_TYPE.value() && entity instanceof Player player && player.hasEffect(KEEffects.DREAM)) {
            cir.setReturnValue(true);
        }
    }
}
