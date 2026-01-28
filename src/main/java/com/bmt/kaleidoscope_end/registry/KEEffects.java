package com.bmt.kaleidoscope_end.registry;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class KEEffects {
    private static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, KaleidoscopeEnd.MODID);

    // 梦境
    public static final RegistryObject<MobEffect> DREAM = EFFECTS.register("dream",
            () -> new MobEffect(MobEffectCategory.BENEFICIAL, 0xFFFFFF) {
                @Override
                public void applyEffectTick(@NotNull LivingEntity living, int p_19468_) {
                    living.fallDistance = 1;
                }

                @Override
                public boolean isDurationEffectTick(int p_19455_, int p_19456_) {
                    return true;
                }
            });

    // 虚空侵蚀
    public static final RegistryObject<MobEffect> VOID_EROSION = EFFECTS.register("void_erosion",
            () -> new MobEffect(MobEffectCategory.BENEFICIAL, 0x4B0082) {
            });

    // 薄荷
    public static final RegistryObject<MobEffect> MINT = EFFECTS.register("mint",
            () -> new MobEffect(MobEffectCategory.BENEFICIAL, 0xDA70D6) {
            });

    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }
}