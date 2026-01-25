package com.bmt.kaleidoscope_end.registry;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class KEEffects {
    private static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(
            net.minecraft.core.registries.BuiltInRegistries.MOB_EFFECT, KaleidoscopeEnd.MODID);

    public static final DeferredHolder<MobEffect, MobEffect> DREAM = EFFECTS.register("dream",
            () -> new MobEffect(MobEffectCategory.BENEFICIAL, 0xFFFFFF) {});

    public static final DeferredHolder<MobEffect, MobEffect> VOID_EROSION = EFFECTS.register("void_erosion",
            () -> new MobEffect(MobEffectCategory.BENEFICIAL, 0x4B0082) {});

    public static final DeferredHolder<MobEffect, MobEffect> MINT = EFFECTS.register("mint",
            () -> new MobEffect(MobEffectCategory.BENEFICIAL, 0xDA70D6) {});

    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }
}