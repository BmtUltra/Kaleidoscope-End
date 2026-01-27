package com.bmt.kaleidoscope_end.mixins.kaleidoscope_end;

import com.bmt.kaleidoscope_end.registry.KEEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.FluidType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.function.BiPredicate;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity {

    protected PlayerMixin(EntityType<? extends LivingEntity> p_20966_, Level p_20967_) {
        super(p_20966_, p_20967_);
    }

    @Unique
    public boolean isInFluidType(FluidState state) {
        if (this.hasEffect(KEEffects.DREAM.get())) {
            return true;
        }
        return super.isInFluidType(state);
    }

    @Unique
    public boolean canSwimInFluidType(FluidType type) {
        if (this.hasEffect(KEEffects.DREAM.get())) {
            return type.isAir();
        }
        return super.canSwimInFluidType(type);
    }

    @Unique
    public boolean canStartSwimming() {
        if (this.hasEffect(KEEffects.DREAM.get())) {
            return true;
        }
        return super.canStartSwimming();
    }

    @Unique
    public boolean isInFluidType(BiPredicate<FluidType, Double> predicate) {
        if (this.hasEffect(KEEffects.DREAM.get())) {
            return true;
        }
        return isInFluidType(predicate, false);
    }
}
