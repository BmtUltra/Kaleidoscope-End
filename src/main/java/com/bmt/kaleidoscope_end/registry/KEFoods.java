package com.bmt.kaleidoscope_end.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

import static com.bmt.kaleidoscope_end.registry.KEEffects.*;
import static com.github.ysbbbbbb.kaleidoscopecookery.init.ModEffects.*;

public class KEFoods {
    public static final FoodProperties DRAGON_BREATH_CHORUS_SOUP = new FoodProperties.Builder()
            .nutrition(16)
            .saturationModifier(0.8f)
            .effect(() -> new MobEffectInstance(VIGOR, 9600, 0), 1.0f)
            .alwaysEdible().build();

    public static final FoodProperties STUFFED_SHULKER = new FoodProperties.Builder()
            .nutrition(13)
            .saturationModifier(0.615f)
            .effect(() -> new MobEffectInstance(SATIATED_SHIELD, 1800,0), 1.0F)
            .alwaysEdible().build();

    public static final FoodProperties CHORUS_PASTA = new FoodProperties.Builder()
            .nutrition(9)
            .saturationModifier(0.611f)
            .effect(() -> new MobEffectInstance(SULFUR, 1800, 0), 1.0f)
            .alwaysEdible().build();

    public static final FoodProperties RAW_ENDER_DRAGON_MEAT = new FoodProperties.Builder()
            .nutrition(8)
            .saturationModifier(0.6f)
            .alwaysEdible().build();

    public static final FoodProperties COOKED_ENDER_DRAGON_MEAT = new FoodProperties.Builder()
            .nutrition(16)
            .saturationModifier(0.8f)
            .alwaysEdible().build();

    public static final FoodProperties DREAM_BERRY = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.3f)
            .effect(() -> new MobEffectInstance(DREAM, 600, 0), 1.0f)
            .alwaysEdible().build();

    public static final FoodProperties MINT_CHORUS_MOUSSE = new FoodProperties.Builder()
            .nutrition(9)
            .saturationModifier(0.4f)
            .effect(() -> new MobEffectInstance(MINT, 1200, 0), 1.0f)
            .alwaysEdible().build();

    public static final FoodProperties OPTIC_NERVE = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(0.3f)
            .alwaysEdible().build();

    public static final FoodProperties END_SALAD = new FoodProperties.Builder()
            .nutrition(10)
            .saturationModifier(0.667f)
            .effect(() -> new MobEffectInstance(PRESERVATION, 1800, 0), 1.0f)
            .alwaysEdible().build();

    public static final FoodProperties DARK_DRAGON_EGG_STEW = new FoodProperties.Builder()
            .nutrition(16)
            .saturationModifier(1.8f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 0), 1.0f)
            .alwaysEdible().build();

    public static final FoodProperties SHULKER_SHELL_MEAT = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.4f)
            .effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 50, 0), 0.5f)
            .alwaysEdible().build();

    public static final FoodProperties SHULKER_SHELL_STEW = new FoodProperties.Builder()
            .nutrition(9)
            .saturationModifier(0.8f)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 1200, 0), 1.0f)
            .alwaysEdible().build();

    public static final FoodProperties SHULKER_ICE_CREAM = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.55f)
            .effect(() -> new MobEffectInstance(TUNDRA_STRIDER, 1200, 0), 1.0f)
            .alwaysEdible().build();

    public static final FoodProperties VOID_CONCH_NOODLE_SOUP = new FoodProperties.Builder()
            .nutrition(14)
            .saturationModifier(0.643f)
            .effect(() -> new MobEffectInstance(VOID_EROSION, 3600, 0), 1.0f)
            .alwaysEdible().build();

    public static final FoodProperties STIR_FRIED_ENDERMITE_MEAT = new FoodProperties.Builder()
            .nutrition(9)
            .saturationModifier(0.611f)
            .effect(() -> new MobEffectInstance(VIGOR, 1800, 0), 1.0f)
            .alwaysEdible().build();

    public static final FoodProperties STIR_FRIED_ENDERMITE_MEAT_RICE_BOWL = new FoodProperties.Builder()
            .nutrition(14)
            .saturationModifier(0.643f)
            .effect(() -> new MobEffectInstance(SATIATED_SHIELD, 3600, 0), 1.0f)
            .alwaysEdible().build();

    public static final FoodProperties RAW_ENDERMITE_MEAT = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 100, 0), 0.3f)
            .alwaysEdible().build();

    public static final FoodProperties ROASTED_ENDERMITE_MEAT = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.6f)
            .alwaysEdible().build();

    public static final FoodProperties END_CATERPILLAR = new FoodProperties.Builder()
            .nutrition(18)
            .saturationModifier(0.2f)
            .alwaysEdible().build();

    public static final FoodProperties DRAGON_BREATH_MIXED_STEW = new FoodProperties.Builder()
            .nutrition(16)
            .saturationModifier(0.8f)
            .effect(() -> new MobEffectInstance(SATIATED_SHIELD, 1600, 0), 1.0f)
            .alwaysEdible().build();

    public static final FoodProperties DRAGON_HEAD_WITH_SAUCE = new FoodProperties.Builder()
            .nutrition(24)
            .saturationModifier(1.2f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 0), 1.0f)
            .alwaysEdible().build();

    public static final FoodProperties MINT_NOODLE_SOUP = new FoodProperties.Builder()
            .nutrition(14)
            .saturationModifier(0.643f)
            .effect(() -> new MobEffectInstance(MINT, 3600, 0), 1.0f)
            .alwaysEdible().build();

    public static final FoodProperties MINT_SAUCE_SHULKER_MEAT = new FoodProperties.Builder()
            .nutrition(9)
            .saturationModifier(0.611f)
            .effect(() -> new MobEffectInstance(VIGOR, 1800, 0), 1.0f)
            .alwaysEdible().build();

    public static final FoodProperties MINT_SAUCE_SHULKER_MEAT_RICE_BOWL = new FoodProperties.Builder()
            .nutrition(14)
            .saturationModifier(0.643f)
            .effect(() -> new MobEffectInstance(SATIATED_SHIELD, 3600, 0), 1.0f)
            .alwaysEdible().build();

    public static final FoodProperties ENDER_MINT_CANDY = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.4f)
            .effect(() -> new MobEffectInstance(MINT, 300, 0), 1.0f)
            .alwaysEdible().build();

    public static final FoodProperties DRAGON_SOUFFLE = new FoodProperties.Builder()
            .nutrition(5)
            .saturationModifier(0.7f)
            .alwaysEdible().build();

    public static final FoodProperties DARK_DRAGON_STEAK = new FoodProperties.Builder()
            .nutrition(24)
            .saturationModifier(0.8f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1600, 0), 1.0f)
            .alwaysEdible().build();

    // 煎龙蛋
    public static final FoodProperties FRIED_DRAGON_EGG = new FoodProperties.Builder()
            .nutrition(8)
            .saturationModifier(0.6f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 6000, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 1), 1.0f)
            .alwaysEdible().build();

    // 龙蛋羹
    public static final FoodProperties DRAGON_EGG_CUSTARD = new FoodProperties.Builder()
            .nutrition(10)
            .saturationModifier(0.7f)
            .alwaysEdible().build();

    // 紫颂花茶
    public static final FoodProperties CHORUS_FLOWER_TEA = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(0.3f)
            .alwaysEdible().build();
}