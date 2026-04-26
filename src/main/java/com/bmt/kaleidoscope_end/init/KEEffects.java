package com.bmt.kaleidoscope_end.init;

import org.jetbrains.annotations.NotNull;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class KEEffects {
    private static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, KaleidoscopeEnd.MOD_ID);

    // 梦境
    public static final DeferredHolder<MobEffect, MobEffect> DREAM = EFFECTS.register("dream",
            () -> new MobEffect(MobEffectCategory.BENEFICIAL, 0xFFFFFF) {
                @Override
                public boolean applyEffectTick(@NotNull LivingEntity living, int amplifier) {
                    living.fallDistance = 1;
                    return true;
                }

                @Override
                public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
                    return true;
                }
            });

    // 虚空侵蚀
    public static final DeferredHolder<MobEffect, MobEffect> VOID_EROSION = EFFECTS.register("void_erosion",
            () -> new MobEffect(MobEffectCategory.BENEFICIAL, 0x4B0082) {
            });

    // 薄荷
    public static final DeferredHolder<MobEffect, MobEffect> MINT = EFFECTS.register("mint",
            () -> new MobEffect(MobEffectCategory.BENEFICIAL, 0xDA70D6) {
            });

    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }
}