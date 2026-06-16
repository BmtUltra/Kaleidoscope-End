package com.bmt.kaleidoscope_end.init;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.github.ysbbbbbb.kaleidoscopecookery.init.registry.TeacupRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

public class KETeacups {
    public static ResourceLocation VOID_TEA;
    public static ResourceLocation ENDER_MINT_TEA;
    public static ResourceLocation CHORUS_FLOWER_TEA;
    public static ResourceLocation ENDER_DRAGON_TEA;

    public static void init() {
        TeacupRegistry registry = new TeacupRegistry() {
            @Override
            public ResourceLocation registerTeacupData(String name, TeacupData data) {
                ResourceLocation id = ResourceLocation.fromNamespaceAndPath(KaleidoscopeEnd.MODID, name);
                TEACUP_DATA_MAP.put(id, data);
                return id;
            }
        };

        // 虚空茶
        VOID_TEA = registry.registerTeacupData("void_tea",
                TeacupRegistry.TeacupData.create(4)
                        .addEffect(() -> new MobEffectInstance(KEEffects.VOID_EROSION.get(), 3 * 60 * 20))
        );

        // 末影薄荷茶
        ENDER_MINT_TEA = registry.registerTeacupData("ender_mint_tea",
                TeacupRegistry.TeacupData.create(4)
                        .addEffect(() -> new MobEffectInstance(KEEffects.MINT.get(), 5 * 60 * 20))
        );

        // 紫颂花茶
        CHORUS_FLOWER_TEA = registry.registerTeacupData("chorus_flower_tea",
                TeacupRegistry.TeacupData.create(4)
                        .addEffect(() -> new MobEffectInstance(KEEffects.DREAM.get(), 3 * 60 * 20))
        );

        // 末影龙茶
        ENDER_DRAGON_TEA = registry.registerTeacupData("ender_dragon_tea",
                TeacupRegistry.TeacupData.create(6)
                        .addEffect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3 * 60 * 20, 2))
                        .addEffect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3 * 60 * 20, 2))
                        .addEffect(() -> new MobEffectInstance(MobEffects.REGENERATION, 3 * 60 * 20, 2))
        );
    }

    public static ResourceLocation id(String name) {
        return ResourceLocation.fromNamespaceAndPath(KaleidoscopeEnd.MODID, name);
    }
}