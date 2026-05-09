package com.bmt.kaleidoscope_end.init;

import static com.bmt.kaleidoscope_end.init.KEEffects.DREAM;
import static com.bmt.kaleidoscope_end.init.KEEffects.MINT;
import static com.bmt.kaleidoscope_end.init.KEEffects.VOID_EROSION;
import static com.github.ysbbbbbb.kaleidoscopecookery.init.ModEffects.PRESERVATION;
import static com.github.ysbbbbbb.kaleidoscopecookery.init.ModEffects.SATIATED_SHIELD;
import static com.github.ysbbbbbb.kaleidoscopecookery.init.ModEffects.SULFUR;
import static com.github.ysbbbbbb.kaleidoscopecookery.init.ModEffects.TUNDRA_STRIDER;
import static com.github.ysbbbbbb.kaleidoscopecookery.init.ModEffects.VIGOR;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class KEFoods {
    //龙息紫颂汤
    public static final FoodProperties DRAGON_BREATH_CHORUS_SOUP = new FoodProperties.Builder()
            .nutrition(16)
            .saturationModifier(0.643f)
            .effect(() -> new MobEffectInstance(VIGOR, 480 * 20, 0), 1.0f)
            .alwaysEdible().build();

    //填馅潜影贝
    public static final FoodProperties STUFFED_SHULKER = new FoodProperties.Builder()
            .nutrition(13)
            .saturationModifier(0.615f)
            .effect(() -> new MobEffectInstance(SATIATED_SHIELD, 90 * 20, 0), 1.0F)
            .alwaysEdible().build();

    //紫颂果意面
    public static final FoodProperties CHORUS_PASTA = new FoodProperties.Builder()
            .nutrition(9)
            .saturationModifier(0.611f)
            .effect(() -> new MobEffectInstance(SULFUR, 90 * 20, 0), 1.0f)
            .alwaysEdible().build();

    //生末影龙肉
    public static final FoodProperties RAW_ENDER_DRAGON_MEAT = new FoodProperties.Builder()
            .nutrition(8)
            .saturationModifier(0.6f)
            .alwaysEdible().build();

    //熟末影龙肉
    public static final FoodProperties COOKED_ENDER_DRAGON_MEAT = new FoodProperties.Builder()
            .nutrition(16)
            .saturationModifier(0.8f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 20 * 20, 0), 1.0f)
            .alwaysEdible().build();

    //梦境浆果
    public static final FoodProperties DREAM_BERRY = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.3f)
            .effect(() -> new MobEffectInstance(DREAM, 30 * 20, 0), 1.0f)
            .alwaysEdible().build();

    //薄荷紫颂慕斯
    public static final FoodProperties MINT_CHORUS_MOUSSE = new FoodProperties.Builder()
            .nutrition(9)
            .saturationModifier(0.4f)
            .effect(() -> new MobEffectInstance(MINT, 60 * 20, 0), 1.0f)
            .alwaysEdible().build();

    //视神经
    public static final FoodProperties OPTIC_NERVE = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(0.3f)
            .alwaysEdible().build();

    //末地沙拉
    public static final FoodProperties END_SALAD_ITEM = new FoodProperties.Builder()
            .nutrition(10)
            .saturationModifier(0.667F)
            .effect(() -> new MobEffectInstance(DREAM, 90 * 20), 1.0F)
            .build();

    public static final FoodProperties END_SALAD_BLOCK = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.667F)
            .effect(() -> new MobEffectInstance(DREAM, 100 * 20), 1.0F)
            .build();

    //暗黑龙蛋煲
    public static final FoodProperties DARK_DRAGON_EGG_STEW_ITEM = new FoodProperties.Builder()
            .nutrition(16)
            .saturationModifier(1.8F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 120 * 20, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 120 * 20, 1), 1.0f)
            .effect(() -> new MobEffectInstance(VOID_EROSION, 30 * 20), 1.0F)
            .build();

    public static final FoodProperties DARK_DRAGON_EGG_STEW_BLOCK = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(1.8F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 130 * 20, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 130 * 20, 1), 1.0f)
            .effect(() -> new MobEffectInstance(VOID_EROSION, 35 * 20), 1.0F)
            .build();

    //潜影贝质
    public static final FoodProperties SHULKER_SHELL_MEAT = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.4f)
            .effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 3 * 20, 0), 0.5f)
            .alwaysEdible().build();

    //潜影贝质炖
    public static final FoodProperties SHULKER_SHELL_STEW = new FoodProperties.Builder()
            .nutrition(9)
            .saturationModifier(0.8f)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 60 * 20, 0), 1.0f)
            .alwaysEdible().build();

    //潜影贝冰淇淋
    public static final FoodProperties SHULKER_ICE_CREAM = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.55f)
            .effect(() -> new MobEffectInstance(TUNDRA_STRIDER, 60 * 20, 0), 1.0f)
            .alwaysEdible().build();

    //虚空海螺汤面
    public static final FoodProperties VOID_CONCH_NOODLE_SOUP = new FoodProperties.Builder()
            .nutrition(14)
            .saturationModifier(0.643f)
            .effect(() -> new MobEffectInstance(VOID_EROSION, 10 * 20, 0), 1.0f)
            .alwaysEdible().build();

    //炒末影螨肉
    public static final FoodProperties STIR_FRIED_ENDERMITE_MEAT = new FoodProperties.Builder()
            .nutrition(9)
            .saturationModifier(0.611f)
            .effect(() -> new MobEffectInstance(VIGOR, 90 * 20, 0), 1.0f)
            .alwaysEdible().build();

    //炒末影螨肉盖饭
    public static final FoodProperties STIR_FRIED_ENDERMITE_MEAT_RICE_BOWL = new FoodProperties.Builder()
            .nutrition(14)
            .saturationModifier(0.643f)
            .effect(() -> new MobEffectInstance(SATIATED_SHIELD, 180 * 20, 0), 1.0f)
            .alwaysEdible().build();

    //生末影螨肉
    public static final FoodProperties RAW_ENDERMITE_MEAT = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 5 * 20, 0), 0.3f)
            .alwaysEdible().build();

    //烤末影螨肉
    public static final FoodProperties ROASTED_ENDERMITE_MEAT = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.6f)
            .alwaysEdible().build();

    //末地猪儿虫
    public static final FoodProperties END_CATERPILLAR = new FoodProperties.Builder()
            .nutrition(18)
            .saturationModifier(0.2f)
            .alwaysEdible().build();

    //龙息乱烩
    public static final FoodProperties DRAGON_BREATH_MIXED_STEW = new FoodProperties.Builder()
            .nutrition(20)
            .saturationModifier(0.55f)
            .effect(() -> new MobEffectInstance(SATIATED_SHIELD, 80 * 20, 0), 1.0f)
            .alwaysEdible().build();

    //浇汁龙首
    public static final FoodProperties DRAGON_HEAD_WITH_SAUCE_ITEM  = new FoodProperties.Builder()
            .nutrition(24)
            .saturationModifier(0.8F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300 * 20, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 300 * 20, 1), 1.0f)
            .effect(() -> new MobEffectInstance(VOID_EROSION, 35 * 20), 1.0F)
            .build();

    public static final FoodProperties DRAGON_HEAD_WITH_SAUCE_BLOCK = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.8F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300 * 20, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 300 * 20, 1), 1.0f)
            .effect(() -> new MobEffectInstance(VOID_EROSION, 40 * 20), 1.0F)
            .build();
    //薄荷汤面
    public static final FoodProperties MINT_NOODLE_SOUP = new FoodProperties.Builder()
            .nutrition(14)
            .saturationModifier(0.643f)
            .effect(() -> new MobEffectInstance(MINT, 180 * 20, 0), 1.0f)
            .alwaysEdible().build();

    //薄荷酱汁潜影贝质
    public static final FoodProperties MINT_SAUCE_SHULKER_MEAT = new FoodProperties.Builder()
            .nutrition(9)
            .saturationModifier(0.611f)
            .effect(() -> new MobEffectInstance(VIGOR, 90 * 20, 0), 1.0f)
            .alwaysEdible().build();

    //薄荷酱汁潜影贝质盖饭
    public static final FoodProperties MINT_SAUCE_SHULKER_MEAT_RICE_BOWL = new FoodProperties.Builder()
            .nutrition(14)
            .saturationModifier(0.643f)
            .effect(() -> new MobEffectInstance(SATIATED_SHIELD, 180 * 20, 0), 1.0f)
            .alwaysEdible().build();

    //末影薄荷糖
    public static final FoodProperties ENDER_MINT_CANDY = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.4f)
            .effect(() -> new MobEffectInstance(MINT, 15 * 20, 0), 1.0f)
            .alwaysEdible().build();

    //龙舒芙蕾
    public static final FoodProperties DRAGON_SOUFFLE = new FoodProperties.Builder()
            .nutrition(9)
            .saturationModifier(0.8f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, -1, 1), 1.0f)
            .alwaysEdible().build();

    //暗黑龙排
    public static final FoodProperties DARK_DRAGON_STEAK_ITEM  = new FoodProperties.Builder()
            .nutrition(24)
            .saturationModifier(0.8F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300 * 20, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 300 * 20, 1), 1.0f)
            .effect(() -> new MobEffectInstance(VOID_EROSION, 35 * 20), 1.0F)
            .build();

    public static final FoodProperties DARK_DRAGON_STEAK_BLOCK = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.8F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300 * 20, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 300 * 20, 1), 1.0f)
            .effect(() -> new MobEffectInstance(VOID_EROSION, 40 * 20), 1.0F)
            .build();
    // 煎龙蛋
    public static final FoodProperties FRIED_DRAGON_EGG = new FoodProperties.Builder()
            .nutrition(18)
            .saturationModifier(0.8f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300 * 20, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300 * 20, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 300 * 20, 1), 1.0f)
            .alwaysEdible().build();

    // 龙蛋羹
    public static final FoodProperties DRAGON_EGG_CUSTARD_ITEM = new FoodProperties.Builder()
            .nutrition(20)
            .saturationModifier(1.8F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300 * 20, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 300 * 20, 1), 1.0f)
            .effect(() -> new MobEffectInstance(VOID_EROSION, 35 * 20), 1.0F)
            .build();

    public static final FoodProperties DRAGON_EGG_CUSTARD_BLOCK = new FoodProperties.Builder()
            .nutrition(5)
            .saturationModifier(1.8F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300 * 20, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 300 * 20, 1), 1.0f)
            .effect(() -> new MobEffectInstance(VOID_EROSION, 40 * 20), 1.0F)
            .build();

    // 紫颂花茶
    public static final FoodProperties CHORUS_FLOWER_SOUP = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.667f)
            .effect(() -> new MobEffectInstance(PRESERVATION, 180 * 20, 0), 1.0f)
            .alwaysEdible().build();

    // 紫颂花糕
    public static final FoodProperties CHORUS_FLOWER_CAKE = new FoodProperties.Builder()
            .nutrition(8)
            .saturationModifier(0.6f)
            .effect(() -> new MobEffectInstance(PRESERVATION, 120 * 20, 0), 1.0f)
            .alwaysEdible().build();

    // 紫颂果籽饼干
    public static final FoodProperties CHORUS_SEED_COOKIE = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(0.3f)
            .effect(() -> new MobEffectInstance(DREAM, 30 * 20, 0), 0.5f)
            .alwaysEdible().build();

    // 龙蛋液
    public static final FoodProperties DRAGON_EGG_LIQUID_FOOD = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.2f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 10 * 20, 0), 0.3f)
            .alwaysEdible().build();

    // 龙蛋冰淇淋
    public static final FoodProperties DRAGON_EGG_ICE_CREAM_ITEM = new FoodProperties.Builder()
            .nutrition(16)
            .saturationModifier(1.8F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300 * 20, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 300 * 20, 1), 1.0f)
            .effect(() -> new MobEffectInstance(VOID_EROSION, 35 * 20), 1.0F)
            .alwaysEdible().build();

    public static final FoodProperties DRAGON_EGG_ICE_CREAM_BLOCK = new FoodProperties.Builder()
            .nutrition(5)
            .saturationModifier(1.8F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300 * 20, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 300 * 20, 1), 1.0f)
            .effect(() -> new MobEffectInstance(VOID_EROSION, 40 * 20), 1.0F)
            .alwaysEdible().build();

    // 填馅虚空海螺
    public static final FoodProperties STUFFED_VOID_CONCH = new FoodProperties.Builder()
            .nutrition(12)
            .saturationModifier(0.7f)
            .effect(() -> new MobEffectInstance(VOID_EROSION, 30 * 20, 0), 1.0f)
            .alwaysEdible().build();

    // 视神经咕噜肉
    public static final FoodProperties OPTIC_NERVE_SWEET_AND_SOUR_PORK_ITEM = new FoodProperties.Builder()
            .nutrition(14)
            .saturationModifier(0.8F)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 480 * 20, 0), 1.0F)
            .alwaysEdible().build();

    public static final FoodProperties OPTIC_NERVE_SWEET_AND_SOUR_PORK_BLOCK = new FoodProperties.Builder()
            .nutrition(5)
            .saturationModifier(0.8F)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 480 * 20, 0), 1.0f)
            .alwaysEdible().build();

    // 末地猪儿虫刺身
    public static final FoodProperties END_CATERPILLAR_SASHIMI_ITEM = new FoodProperties.Builder()
            .nutrition(18)
            .saturationModifier(1.8F)
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 120 * 20, 0), 1.0f)
            .alwaysEdible().build();

    public static final FoodProperties END_CATERPILLAR_SASHIMI_BLOCK = new FoodProperties.Builder()
            .nutrition(5)
            .saturationModifier(1.8F)
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 120 * 20, 0), 1.0f)
            .alwaysEdible().build();

    // 虚空羊排
    public static final FoodProperties VOID_MUTTON_STEAK_ITEM = new FoodProperties.Builder()
            .nutrition(16)
            .saturationModifier(1.2F)
            .effect(() -> new MobEffectInstance(VOID_EROSION, 180 * 20, 0), 1.0f)
            .alwaysEdible().build();

    public static final FoodProperties VOID_MUTTON_STEAK_BLOCK = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(1.2F)
            .effect(() -> new MobEffectInstance(VOID_EROSION, 30 * 20, 0), 1.0f)
            .alwaysEdible().build();

    // 龙息跳跳糖
    public static final FoodProperties DRAGON_BREATH_POPPING_CANDY = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.1F)
            .alwaysEdible()
//            .effect(() -> new MobEffectInstance(DREAM, 30 * 20, 0), 0.5f)
            .build();
}