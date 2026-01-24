package com.bmt.kaleidoscope_end.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class KEFoods {
    public static final FoodProperties DRAGON_BREATH_CHORUS_SOUP = new FoodProperties.Builder()
            .nutrition(8)
            .saturationMod(0.8f)
            .build();

    public static final FoodProperties STUFFED_SHULKER = new FoodProperties.Builder()
            .nutrition(10)
            .saturationMod(1.2f)
            .meat()
            .build();

    public static final FoodProperties CHORUS_PASTA = new FoodProperties.Builder()
            .nutrition(6)
            .saturationMod(0.6f)
            .fast()
            .build();

    public static final FoodProperties RAW_ENDER_DRAGON_MEAT = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(0.3f)
            .meat()
            .build();

    public static final FoodProperties COOKED_ENDER_DRAGON_MEAT = new FoodProperties.Builder()
            .nutrition(8)
            .saturationMod(1.0f)
            .meat()
            .build();

    public static final FoodProperties DREAM_BERRY = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(0.3f)
            .fast()
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 600, 0), 1.0f)
            .build();

    public static final FoodProperties MINT_CHORUS_MOUSSE = new FoodProperties.Builder()
            .nutrition(6)
            .saturationMod(0.7f)
            .fast()
            .effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 100, 0), 0.3f)
            .build();

    public static final FoodProperties OPTIC_NERVE = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.1f)
            .meat()
            .effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 200, 0), 0.8f)
            .build();

    public static final FoodProperties END_SALAD = new FoodProperties.Builder()
            .nutrition(5)
            .saturationMod(0.6f)
            .fast()
            .build();

    public static final FoodProperties DARK_DRAGON_EGG_STEW = new FoodProperties.Builder()
            .nutrition(12)
            .saturationMod(1.5f)
            .meat()
            .alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 0), 1.0f)
            .build();

    public static final FoodProperties SHULKER_SHELL_MEAT = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(0.4f)
            .meat()
            .effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 50, 0), 0.5f)
            .build();

    public static final FoodProperties SHULKER_SHELL_STEW = new FoodProperties.Builder()
            .nutrition(8)
            .saturationMod(1.0f)
            .meat()
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 600, 0), 1.0f)
            .build();

    public static final FoodProperties SHULKER_ICE_CREAM = new FoodProperties.Builder()
            .nutrition(6)
            .saturationMod(0.8f)
            .alwaysEat()
            .build();

    public static final FoodProperties VOID_CONCH_NOODLE_SOUP = new FoodProperties.Builder()
            .nutrition(10)
            .saturationMod(1.2f)
            .build();

    public static final FoodProperties STIR_FRIED_ENDERMITE_MEAT = new FoodProperties.Builder()
            .nutrition(7)
            .saturationMod(0.9f)
            .meat()
            .build();

    public static final FoodProperties STIR_FRIED_ENDERMITE_MEAT_RICE_BOWL = new FoodProperties.Builder()
            .nutrition(12)
            .saturationMod(1.5f)
            .meat()
            .build();

    public static final FoodProperties RAW_ENDERMITE_MEAT = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.2f)
            .meat()
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 100, 0), 0.3f)
            .build();

    public static final FoodProperties ROASTED_ENDERMITE_MEAT = new FoodProperties.Builder()
            .nutrition(5)
            .saturationMod(0.6f)
            .meat()
            .build();

    public static final FoodProperties END_PIG_WORM = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(0.5f)
            .meat()
            .build();

    public static final FoodProperties DRAGON_BREATH_MIXED_STEW = new FoodProperties.Builder()
            .nutrition(14)
            .saturationMod(1.8f)
            .meat()
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 0), 1.0f)
            .build();

    public static final FoodProperties DRAGON_HEAD_WITH_SAUCE = new FoodProperties.Builder()
            .nutrition(16)
            .saturationMod(2.0f)
            .meat()
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 0), 1.0f)
            .build();

    public static final FoodProperties MINT_NOODLE_SOUP = new FoodProperties.Builder()
            .nutrition(8)
            .saturationMod(1.0f)
            .fast()
            .build();

    public static final FoodProperties MINT_SAUCE_SHULKER_MEAT = new FoodProperties.Builder()
            .nutrition(9)
            .saturationMod(1.1f)
            .meat()
            .build();

    public static final FoodProperties MINT_SAUCE_SHULKER_MEAT_RICE_BOWL = new FoodProperties.Builder()
            .nutrition(13)
            .saturationMod(1.6f)
            .meat()
            .build();

    public static final FoodProperties ENDER_MINT_CANDY = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.3f)
            .fast()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 0), 1.0f)
            .build();

    public static final FoodProperties DRAGON_SOUFFLE = new FoodProperties.Builder()
            .nutrition(5)
            .saturationMod(0.7f)
            .fast()
            .build();

    public static final FoodProperties DARK_DRAGON_STEAK = new FoodProperties.Builder()
            .nutrition(12)
            .saturationMod(1.4f)
            .meat()
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 800, 0), 1.0f)
            .build();
}
