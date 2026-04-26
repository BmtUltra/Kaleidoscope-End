package com.bmt.kaleidoscope_end.mixins.kaleidoscope_end;

import com.bmt.kaleidoscope_end.init.KEEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.fluids.FluidType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FluidType.class)
public class FluidTypeMixin {
    @Inject(remap = false,method = "canSwim", at = @At("RETURN"), cancellable = true)
    private void canSwim(Entity entity, CallbackInfoReturnable<Boolean> cir) {
        FluidType fluidType = (FluidType) (Object) this;
        if (fluidType == ForgeMod.EMPTY_TYPE.get() && entity instanceof Player player && player.hasEffect(KEEffects.DREAM.get())) {
            cir.setReturnValue(true);
        }
    }
}
