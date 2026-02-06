package com.bmt.kaleidoscope_end.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

import static com.bmt.kaleidoscope_end.registry.KEEffects.*;
import static com.github.ysbbbbbb.kaleidoscopecookery.init.ModEffects.*;
import static net.minecraft.world.effect.MobEffects.*;

public class KEFoods {
    //龙息紫颂汤
    public static final FoodProperties DRAGON_BREATH_CHORUS_SOUP = new FoodProperties.Builder()
            .nutrition(16)
            .saturationMod(0.643f)
            .effect(() -> new MobEffectInstance(VIGOR.get(), 480 * 20, 0), 1.0f)
            .alwaysEat().build();

    //填馅潜影贝
    public static final FoodProperties STUFFED_SHULKER = new FoodProperties.Builder()
            .nutrition(13)
            .saturationMod(0.615f)
            .meat()
            .effect(() -> new MobEffectInstance(SATIATED_SHIELD.get(), 90 * 20, 0), 1.0F)
            .alwaysEat().build();

    //紫颂果意面
    public static final FoodProperties CHORUS_PASTA = new FoodProperties.Builder()
            .nutrition(9)
            .saturationMod(0.611f)
            .effect(() -> new MobEffectInstance(SULFUR.get(), 90 * 20, 0), 1.0f)
            .alwaysEat().build();

    //生末影龙肉
    public static final FoodProperties RAW_ENDER_DRAGON_MEAT = new FoodProperties.Builder()
            .nutrition(8)
            .saturationMod(0.6f)
            .meat()
            .alwaysEat().build();

    //熟末影龙肉
    public static final FoodProperties COOKED_ENDER_DRAGON_MEAT = new FoodProperties.Builder()
            .nutrition(16)
            .saturationMod(0.8f)
            .meat()
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 20 * 20, 0), 1.0f)
            .alwaysEat().build();

    //梦境浆果
    public static final FoodProperties DREAM_BERRY = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.3f)
            .effect(() -> new MobEffectInstance(DREAM.get(), 30 * 20, 0), 1.0f)
            .alwaysEat().build();

    //薄荷紫颂慕斯
    public static final FoodProperties MINT_CHORUS_MOUSSE = new FoodProperties.Builder()
            .nutrition(9)
            .saturationMod(0.4f)
            .effect(() -> new MobEffectInstance(MINT.get(), 60 * 20, 0), 1.0f)
            .alwaysEat().build();

    //视神经
    public static final FoodProperties OPTIC_NERVE = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(0.3f)
            .meat()
            .alwaysEat().build();

    //末地沙拉
    public static final FoodProperties END_SALAD_ITEM = new FoodProperties.Builder()
            .nutrition(10)
            .saturationMod(0.667F)
            .effect(() -> new MobEffectInstance(DREAM.get(), 90 * 20), 1.0F)
            .meat().build();

    public static final FoodProperties END_SALAD_BLOCK = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(0.667F)
            .effect(() -> new MobEffectInstance(DREAM.get(), 100 * 20), 1.0F)
            .meat().build();

    //暗黑龙蛋煲
    public static final FoodProperties DARK_DRAGON_EGG_STEW_ITEM = new FoodProperties.Builder()
            .nutrition(16)
            .saturationMod(1.8F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 120 * 20, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 120 * 20, 1), 1.0f)
            .effect(() -> new MobEffectInstance(VOID_EROSION.get(), 30 * 20), 1.0F)
            .meat().build();

    public static final FoodProperties DARK_DRAGON_EGG_STEW_BLOCK = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(1.8F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 130 * 20, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 130 * 20, 1), 1.0f)
            .effect(() -> new MobEffectInstance(VOID_EROSION.get(), 35 * 20), 1.0F)
            .meat().build();

    //潜影贝质
    public static final FoodProperties SHULKER_SHELL_MEAT = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(0.4f)
            .meat()
            .effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 3 * 20, 0), 0.5f)
            .alwaysEat().build();

    //潜影贝质炖
    public static final FoodProperties SHULKER_SHELL_STEW = new FoodProperties.Builder()
            .nutrition(9)
            .saturationMod(0.8f)
            .meat()
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 60 * 20, 0), 1.0f)
            .alwaysEat().build();

    //潜影贝冰淇淋
    public static final FoodProperties SHULKER_ICE_CREAM = new FoodProperties.Builder()
            .nutrition(6)
            .saturationMod(0.55f)
            .effect(() -> new MobEffectInstance(TUNDRA_STRIDER.get(), 60 * 20, 0), 1.0f)
            .alwaysEat().build();

    //虚空海螺汤面
    public static final FoodProperties VOID_CONCH_NOODLE_SOUP = new FoodProperties.Builder()
            .nutrition(14)
            .saturationMod(0.643f)
            .effect(() -> new MobEffectInstance(VOID_EROSION.get(), 10 * 20, 0), 1.0f)
            .alwaysEat().build();

    //炒末影螨肉
    public static final FoodProperties STIR_FRIED_ENDERMITE_MEAT = new FoodProperties.Builder()
            .nutrition(9)
            .saturationMod(0.611f)
            .meat()
            .effect(() -> new MobEffectInstance(VIGOR.get(), 90 * 20, 0), 1.0f)
            .alwaysEat().build();

    //炒末影螨肉盖饭
    public static final FoodProperties STIR_FRIED_ENDERMITE_MEAT_RICE_BOWL = new FoodProperties.Builder()
            .nutrition(14)
            .saturationMod(0.643f)
            .meat()
            .effect(() -> new MobEffectInstance(SATIATED_SHIELD.get(), 180 * 20, 0), 1.0f)
            .alwaysEat().build();

    //生末影螨肉
    public static final FoodProperties RAW_ENDERMITE_MEAT = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.3f)
            .meat()
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 5 * 20, 0), 0.3f)
            .alwaysEat().build();

    //烤末影螨肉
    public static final FoodProperties ROASTED_ENDERMITE_MEAT = new FoodProperties.Builder()
            .nutrition(6)
            .saturationMod(0.6f)
            .meat()
            .alwaysEat().build();

    //末地猪儿虫
    public static final FoodProperties END_CATERPILLAR = new FoodProperties.Builder()
            .nutrition(18)
            .saturationMod(0.2f)
            .meat()
            .alwaysEat().build();

    //龙息乱烩
    public static final FoodProperties DRAGON_BREATH_MIXED_STEW = new FoodProperties.Builder()
            .nutrition(20)
            .saturationMod(0.55f)
            .meat()
            .effect(() -> new MobEffectInstance(SATIATED_SHIELD.get(), 80 * 20, 0), 1.0f)
            .alwaysEat().build();

    //浇汁龙首
    public static final FoodProperties DRAGON_HEAD_WITH_SAUCE = new FoodProperties.Builder()
            .nutrition(24)
            .saturationMod(1.0f)
            .meat()
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60 * 20, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 60 * 20, 1), 1.0f)
            .alwaysEat().build();

    //薄荷汤面
    public static final FoodProperties MINT_NOODLE_SOUP = new FoodProperties.Builder()
            .nutrition(14)
            .saturationMod(0.643f)
            .effect(() -> new MobEffectInstance(MINT.get(), 180 * 20, 0), 1.0f)
            .alwaysEat().build();

    //薄荷酱汁潜影贝质
    public static final FoodProperties MINT_SAUCE_SHULKER_MEAT = new FoodProperties.Builder()
            .nutrition(9)
            .saturationMod(0.611f)
            .meat()
            .effect(() -> new MobEffectInstance(VIGOR.get(), 90 * 20, 0), 1.0f)
            .alwaysEat().build();

    //薄荷酱汁潜影贝质盖饭
    public static final FoodProperties MINT_SAUCE_SHULKER_MEAT_RICE_BOWL = new FoodProperties.Builder()
            .nutrition(14)
            .saturationMod(0.643f)
            .meat()
            .effect(() -> new MobEffectInstance(SATIATED_SHIELD.get(), 180 * 20, 0), 1.0f)
            .alwaysEat().build();

    //末影薄荷糖
    public static final FoodProperties ENDER_MINT_CANDY = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.4f)
            .effect(() -> new MobEffectInstance(MINT.get(), 15 * 20, 0), 1.0f)
            .alwaysEat().build();

    //龙舒芙蕾
    public static final FoodProperties DRAGON_SOUFFLE = new FoodProperties.Builder()
            .nutrition(9)
            .saturationMod(0.8f)
            .effect(() -> new MobEffectInstance(DREAM.get(), 90 * 20, 0), 1.0f)
            .alwaysEat().build();

    //暗黑龙排
    public static final FoodProperties DARK_DRAGON_STEAK = new FoodProperties.Builder()
            .nutrition(24)
            .saturationMod(0.8f)
            .meat()
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60 * 20, 0), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 60 * 20, 0), 1.0f)
            .alwaysEat().build();

    // 煎龙蛋
    public static final FoodProperties FRIED_DRAGON_EGG = new FoodProperties.Builder()
            .nutrition(18)
            .saturationMod(0.8f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300 * 20, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300 * 20, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 300 * 20, 1), 1.0f)
            .meat()
            .alwaysEat().build();

    // 龙蛋羹
    public static final FoodProperties DRAGON_EGG_CUSTARD_ITEM = new FoodProperties.Builder()
            .nutrition(20)
            .saturationMod(1.8F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300 * 20, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 300 * 20, 1), 1.0f)
            .effect(() -> new MobEffectInstance(VOID_EROSION.get(), 35 * 20), 1.0F)
            .meat().build();

    public static final FoodProperties DRAGON_EGG_CUSTARD_BLOCK = new FoodProperties.Builder()
            .nutrition(5)
            .saturationMod(1.8F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300 * 20, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 300 * 20, 1), 1.0f)
            .effect(() -> new MobEffectInstance(VOID_EROSION.get(), 40 * 20), 1.0F)
            .meat().build();

    // 紫颂花茶
    public static final FoodProperties CHORUS_FLOWER_TEA = new FoodProperties.Builder()
            .nutrition(6)
            .saturationMod(0.667f)
            .effect(() -> new MobEffectInstance(PRESERVATION.get(), 180 * 20, 0), 1.0f)
            .alwaysEat().build();

    // 紫颂花糕
    public static final FoodProperties CHORUS_FLOWER_CAKE = new FoodProperties.Builder()
            .nutrition(8)
            .saturationMod(0.6f)
            .effect(() -> new MobEffectInstance(PRESERVATION.get(), 120 * 20, 0), 1.0f)
            .alwaysEat().build();

    // 紫颂果籽饼干
    public static final FoodProperties CHORUS_SEED_COOKIE = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(0.3f)
            .effect(() -> new MobEffectInstance(DREAM.get(), 30 * 20, 0), 0.5f)
            .alwaysEat().build();

    // 龙蛋液
    public static final FoodProperties DRAGON_EGG_LIQUID_FOOD = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(0.2f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 10 * 20, 0), 0.3f)
            .alwaysEat().build();

    // 紫颂果籽
    public static final FoodProperties CHORUS_SEED_FOOD = new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(0.1f)
            .alwaysEat().build();
}