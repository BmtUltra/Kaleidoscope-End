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
            .saturationMod(0.8f)
            .effect(() -> new MobEffectInstance(VIGOR.get(), 9600, 0), 1.0f)
            .alwaysEat().build();

    //填馅潜影贝
    public static final FoodProperties STUFFED_SHULKER = new FoodProperties.Builder()
            .nutrition(13)
            .saturationMod(0.615f)
            .meat()
            .effect(() -> new MobEffectInstance(SATIATED_SHIELD.get(), 1800,0), 1.0F)
            .alwaysEat().build();

    //紫颂果意面
    public static final FoodProperties CHORUS_PASTA = new FoodProperties.Builder()
            .nutrition(9)
            .saturationMod(0.611f)
            .effect(() -> new MobEffectInstance(SULFUR.get(), 1800, 0), 1.0f)
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
            .alwaysEat().build();

    //梦境浆果
    public static final FoodProperties DREAM_BERRY = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.3f)
            .effect(() -> new MobEffectInstance(DREAM.get(), 600, 0), 1.0f)
            .alwaysEat().build();

    //薄荷紫颂慕斯
    public static final FoodProperties MINT_CHORUS_MOUSSE = new FoodProperties.Builder()
            .nutrition(9)
            .saturationMod(0.4f)
            .effect(() -> new MobEffectInstance(MINT.get(), 1200, 0), 1.0f)
            .alwaysEat().build();

    //视神经
    public static final FoodProperties OPTIC_NERVE = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(0.3f)
            .meat()
            //.effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 200, 0), 0.8f)
            .alwaysEat().build();

    //末地沙拉
    public static final FoodProperties END_SALAD = new FoodProperties.Builder()
            .nutrition(10)
            .saturationMod(0.667f)
            .effect(() -> new MobEffectInstance(PRESERVATION.get(), 1800, 0), 1.0f)
            .alwaysEat().build();

    //暗黑龙蛋煲
    public static final FoodProperties DARK_DRAGON_EGG_STEW = new FoodProperties.Builder()
            .nutrition(16)
            .saturationMod(1.8f)
            .meat()
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 0), 1.0f)
            .alwaysEat().build();

    //潜影贝质
    public static final FoodProperties SHULKER_SHELL_MEAT = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(0.4f)
            .meat()
            .effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 50, 0), 0.5f)
            .alwaysEat().build();

    //潜影贝质炖
    public static final FoodProperties SHULKER_SHELL_STEW = new FoodProperties.Builder()
            .nutrition(9)
            .saturationMod(0.8f)
            .meat()
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 1200, 0), 1.0f)
            .alwaysEat().build();

    //潜影贝冰淇淋
    public static final FoodProperties SHULKER_ICE_CREAM = new FoodProperties.Builder()
            .nutrition(6)
            .saturationMod(0.55f)
            .effect(() -> new MobEffectInstance(TUNDRA_STRIDER.get(), 1200, 0), 1.0f)
            .alwaysEat().build();

    //虚空海螺汤面
    public static final FoodProperties VOID_CONCH_NOODLE_SOUP = new FoodProperties.Builder()
            .nutrition(14)
            .saturationMod(0.643f)
            .effect(() -> new MobEffectInstance(VOID_EROSION.get(), 3600, 0), 1.0f)
            .alwaysEat().build();

    //炒末影螨肉
    public static final FoodProperties STIR_FRIED_ENDERMITE_MEAT = new FoodProperties.Builder()
            .nutrition(9)
            .saturationMod(0.611f)
            .meat()
            .effect(() -> new MobEffectInstance(VIGOR.get(), 1800, 0), 1.0f)
            .alwaysEat().build();

    //炒末影螨肉盖饭
    public static final FoodProperties STIR_FRIED_ENDERMITE_MEAT_RICE_BOWL = new FoodProperties.Builder()
            .nutrition(14)
            .saturationMod(0.643f)
            .meat()
            .effect(() -> new MobEffectInstance(SATIATED_SHIELD.get(), 3600, 0), 1.0f)
            .alwaysEat().build();

    //生末影螨肉
    public static final FoodProperties RAW_ENDERMITE_MEAT = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.3f)
            .meat()
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 100, 0), 0.3f)
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
            .nutrition(16)
            .saturationMod(0.8f)
            .meat()
            .effect(() -> new MobEffectInstance(SATIATED_SHIELD.get(), 1600, 0), 1.0f)
            .alwaysEat().build();

    //浇汁龙首
    public static final FoodProperties DRAGON_HEAD_WITH_SAUCE = new FoodProperties.Builder()
            .nutrition(24)
            .saturationMod(1.2f)
            .meat()
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 0), 1.0f)
            .alwaysEat().build();

    //薄荷汤面
    public static final FoodProperties MINT_NOODLE_SOUP = new FoodProperties.Builder()
            .nutrition(14)
            .saturationMod(0.643f)
            .effect(() -> new MobEffectInstance(MINT.get(), 3600, 0), 1.0f)
            .alwaysEat().build();

    //薄荷酱汁潜影贝质
    public static final FoodProperties MINT_SAUCE_SHULKER_MEAT = new FoodProperties.Builder()
            .nutrition(9)
            .saturationMod(0.611f)
            .meat()
            .effect(() -> new MobEffectInstance(VIGOR.get(), 1800, 0), 1.0f)
            .alwaysEat().build();

    //薄荷酱汁潜影贝质盖饭
    public static final FoodProperties MINT_SAUCE_SHULKER_MEAT_RICE_BOWL = new FoodProperties.Builder()
            .nutrition(14)
            .saturationMod(0.643f)
            .meat()
            .effect(() -> new MobEffectInstance(SATIATED_SHIELD.get(), 3600, 0), 1.0f)
            .alwaysEat().build();

    //末影薄荷糖
    public static final FoodProperties ENDER_MINT_CANDY = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.4f)
            .effect(() -> new MobEffectInstance(MINT.get(), 300, 0), 1.0f)
            .alwaysEat().build();

    //龙舒芙蕾
    public static final FoodProperties DRAGON_SOUFFLE = new FoodProperties.Builder()
            .nutrition(5)
            .saturationMod(0.7f)
            .alwaysEat().build();

    //暗黑龙排
    public static final FoodProperties DARK_DRAGON_STEAK = new FoodProperties.Builder()
            .nutrition(24)
            .saturationMod(0.8f)
            .meat()
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1600, 0), 1.0f)
            .alwaysEat().build();

    // 煎龙蛋
    public static final FoodProperties FRIED_DRAGON_EGG = new FoodProperties.Builder()
            .nutrition(8)
            .saturationMod(0.6f)
            .meat()
            .alwaysEat().build();

    // 龙蛋羹
    public static final FoodProperties DRAGON_EGG_CUSTARD = new FoodProperties.Builder()
            .nutrition(10)
            .saturationMod(0.7f)
            .alwaysEat().build();

    // 紫颂花茶
    public static final FoodProperties CHORUS_FLOWER_TEA = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(0.3f)
            .alwaysEat().build();
}