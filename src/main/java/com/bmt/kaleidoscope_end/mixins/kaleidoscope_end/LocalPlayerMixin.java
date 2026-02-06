package com.bmt.kaleidoscope_end.mixins.kaleidoscope_end;

import com.bmt.kaleidoscope_end.registry.KEEffects;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.function.BiPredicate;

@Mixin(LocalPlayer.class)
public abstract class LocalPlayerMixin extends Player {

    public LocalPlayerMixin(Level p_250508_, BlockPos p_250289_, float p_251702_, GameProfile p_252153_) {
        super(p_250508_, p_250289_, p_251702_, p_252153_);
    }

    @WrapOperation(method = "aiStep", at = @At(remap = false,value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;canStartSwimming()Z"))
    private boolean warpCanStartSwimming(LocalPlayer instance, Operation<Boolean> original) {
        if (this.hasEffect(KEEffects.DREAM.get())) {
            return true;
        }
        return original.call(instance);
    }

    @WrapOperation(method = "aiStep", at = @At(remap = false,value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;isInFluidType(Ljava/util/function/BiPredicate;)Z"))
    private boolean warpIsInFluidType(LocalPlayer instance, BiPredicate<FluidType, Double> biPredicate, Operation<Boolean> original) {
        if (this.hasEffect(KEEffects.DREAM.get())) {
            return true;
        }
        return original.call(instance, biPredicate);
    }
}
