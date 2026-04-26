package com.bmt.kaleidoscope_end.init;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.item.*;
import com.github.ysbbbbbb.kaleidoscopecookery.init.ModFoods;
import com.github.ysbbbbbb.kaleidoscopecookery.item.BowlFoodOnlyItem;
import com.github.ysbbbbbb.kaleidoscopecookery.item.FoodWithEffectsItem;
import com.github.ysbbbbbb.kaleidoscopecookery.item.WithTooltipsItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class KEItem {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, KaleidoscopeEnd.MODID);

    // 龙之刃
    public static final RegistryObject<Item> DRAGON_TOOTH_KNIFE = ITEMS.register("dragon_tooth_knife",
            DragonToothKnifeItem::new);

    // 末影薄荷
    public static final RegistryObject<Item> ENDER_MINT = ITEMS.register("ender_mint",
            () -> new KEBlockItem(KEBlocks.ENDER_MINT.get(),new Item.Properties()));

    // 虚空海螺
    public static final RegistryObject<Item> VOID_CONCH = ITEMS.register("void_conch",
            () -> new Item(new Item.Properties()));

    // 龙尘
    public static final RegistryObject<Item> DRAGON_DUST = ITEMS.register("dragon_dust",
            () -> new DragonDustItem(new Item.Properties()));

    // 龙牙
    public static final RegistryObject<Item> DRAGON_TOOTH = ITEMS.register("dragon_tooth",
            () -> new Item(new Item.Properties()));

    // 末地炉灶
    public static final RegistryObject<Item> END_STOVE_ITEM = ITEMS.register("end_stove",
            () -> new BlockItem(KEBlocks.END_STOVE.get(), new Item.Properties()));

    // 可疑的末地石
    public static final RegistryObject<Item> SUSPICIOUS_END_STONE_ITEM = ITEMS.register("suspicious_end_stone",
            () -> new BlockItem(KEBlocks.SUSPICIOUS_END_STONE.get(), new Item.Properties()));

    // 可疑的龙蛋
    public static final RegistryObject<Item> SUSPICIOUS_DRAGON_EGG_ITEM = ITEMS.register("suspicious_dragon_egg",
            () -> new BlockItem(KEBlocks.SUSPICIOUS_DRAGON_EGG.get(),
                    new Item.Properties().rarity(Rarity.EPIC)));

    // 锻造模板
    public static final RegistryObject<Item> ENDER_DRAGON_SMITHING_TEMPLATE = ITEMS.register("ender_dragon_smithing_template",
            () -> new SmithingTemplateItem(
                    Component.translatable("item.kaleidoscope_end.ender_dragon_smithing_template.upgrade_description"),
                    Component.translatable("item.kaleidoscope_end.ender_dragon_smithing_template.applies_to_description"),
                    Component.translatable("item.kaleidoscope_end.ender_dragon_smithing_template.ingredients_description"),
                    Component.translatable("item.kaleidoscope_end.ender_dragon_smithing_template.base_slot_description"),
                    Component.translatable("item.kaleidoscope_end.ender_dragon_smithing_template.additions_slot_description"),
                    List.of(),
                    List.of()
            ));

    // 龙蛋壳
    public static final RegistryObject<Item> DRAGON_EGG_SHELL = ITEMS.register("dragon_egg_shell",
            () -> new Item(new Item.Properties()));

    // 龙息紫颂汤
    public static final RegistryObject<Item> DRAGON_BREATH_CHORUS_SOUP_ITEM = ITEMS.register("dragon_breath_chorus_soup",
            () -> new BowlFoodOnlyItem(KEFoods.DRAGON_BREATH_CHORUS_SOUP));

    // 填馅潜影贝
    public static final RegistryObject<Item> STUFFED_SHULKER_ITEM = ITEMS.register("stuffed_shulker",
            () -> new ShulkerShellFoodItem(KEFoods.STUFFED_SHULKER));

    // 紫颂果意面
    public static final RegistryObject<Item> CHORUS_PASTA_ITEM = ITEMS.register("chorus_pasta",
            () -> new BowlFoodOnlyItem(KEFoods.CHORUS_PASTA));

    // 生末影龙肉
    public static final RegistryObject<Item> RAW_ENDER_DRAGON_MEAT_ITEM = ITEMS.register("raw_ender_dragon_meat",
            () -> new Item(new Item.Properties().food(KEFoods.RAW_ENDER_DRAGON_MEAT)));

    // 烤末影龙肉
    public static final RegistryObject<Item> COOKED_ENDER_DRAGON_MEAT_ITEM = ITEMS.register("cooked_ender_dragon_meat",
            () -> new Item(new Item.Properties().food(KEFoods.COOKED_ENDER_DRAGON_MEAT)));

    // 梦境浆果
    public static final RegistryObject<Item> DREAM_BERRY_ITEM = ITEMS.register("dream_berry",
            () -> new KEBlockItem(KEBlocks.DREAM_BERRY_HEAD.get(), new Item.Properties().food(KEFoods.DREAM_BERRY)));

    // 薄荷紫颂慕斯
    public static final RegistryObject<Item> MINT_CHORUS_MOUSSE_ITEM = ITEMS.register("mint_chorus_mousse",
            () -> new FoodWithEffectsItem(KEFoods.MINT_CHORUS_MOUSSE));

    // 视神经
    public static final RegistryObject<Item> OPTIC_NERVE_ITEM = ITEMS.register("optic_nerve",
            () -> new Item(new Item.Properties().food(KEFoods.OPTIC_NERVE)));

    // 潜影贝质
    public static final RegistryObject<Item> SHULKER_SHELL_MEAT_ITEM = ITEMS.register("shulker_shell_meat",
            () -> new Item(new Item.Properties().food(KEFoods.SHULKER_SHELL_MEAT)));

    // 潜影贝质炖
    public static final RegistryObject<Item> SHULKER_SHELL_STEW_ITEM = ITEMS.register("shulker_shell_stew",
            () -> new BowlFoodOnlyItem(KEFoods.SHULKER_SHELL_STEW));

    // 潜影贝冰淇淋
    public static final RegistryObject<Item> SHULKER_ICE_CREAM_ITEM = ITEMS.register("shulker_ice_cream",
            () -> new ShulkerShellFoodItem(KEFoods.SHULKER_ICE_CREAM));

    // 虚空海螺汤面
    public static final RegistryObject<Item> VOID_CONCH_NOODLE_SOUP_ITEM = ITEMS.register("void_conch_noodle_soup",
            () -> new BowlFoodOnlyItem(KEFoods.VOID_CONCH_NOODLE_SOUP));

    // 炒末影螨肉
    public static final RegistryObject<Item> STIR_FRIED_ENDERMITE_MEAT_ITEM = ITEMS.register("stir_fried_endermite_meat",
            () -> new BowlFoodOnlyItem(KEFoods.STIR_FRIED_ENDERMITE_MEAT));

    // 炒末影螨肉盖饭
    public static final RegistryObject<Item> STIR_FRIED_ENDERMITE_MEAT_RICE_BOWL_ITEM = ITEMS.register("stir_fried_endermite_meat_rice_bowl",
            () -> new BowlFoodOnlyItem(KEFoods.STIR_FRIED_ENDERMITE_MEAT_RICE_BOWL));

    // 生末影螨肉
    public static final RegistryObject<Item> RAW_ENDERMITE_MEAT_ITEM = ITEMS.register("raw_endermite_meat",
            () -> new Item(new Item.Properties().food(KEFoods.RAW_ENDERMITE_MEAT)));

    // 烤末影螨肉
    public static final RegistryObject<Item> ROASTED_ENDERMITE_MEAT_ITEM = ITEMS.register("roasted_endermite_meat",
            () -> new Item(new Item.Properties().food(KEFoods.ROASTED_ENDERMITE_MEAT)));

    // 末地猪儿虫
    public static final RegistryObject<Item> END_CATERPILLAR_ITEM = ITEMS.register("end_caterpillar",
            () -> new WithTooltipsItem(new Item.Properties().food(ModFoods.CATERPILLAR), "end_caterpillar"));

    // 龙息乱烩
    public static final RegistryObject<Item> DRAGON_BREATH_MIXED_STEW_ITEM = ITEMS.register("dragon_breath_mixed_stew",
            () -> new ShulkerShellFoodItem(KEFoods.DRAGON_BREATH_MIXED_STEW));

    // 薄荷汤面
    public static final RegistryObject<Item> MINT_NOODLE_SOUP_ITEM = ITEMS.register("mint_noodle_soup",
            () -> new BowlFoodOnlyItem(KEFoods.MINT_NOODLE_SOUP));

    // 薄荷酱汁潜影贝质
    public static final RegistryObject<Item> MINT_SAUCE_SHULKER_MEAT_ITEM = ITEMS.register("mint_sauce_shulker_meat",
            () -> new BowlFoodOnlyItem(KEFoods.MINT_SAUCE_SHULKER_MEAT));

    // 薄荷酱汁潜影贝质盖饭
    public static final RegistryObject<Item> MINT_SAUCE_SHULKER_MEAT_RICE_BOWL_ITEM = ITEMS.register("mint_sauce_shulker_meat_rice_bowl",
            () -> new BowlFoodOnlyItem(KEFoods.MINT_SAUCE_SHULKER_MEAT_RICE_BOWL));

    // 末影薄荷糖
    public static final RegistryObject<Item> ENDER_MINT_CANDY_ITEM = ITEMS.register("ender_mint_candy",
            () -> new FoodWithEffectsItem(KEFoods.ENDER_MINT_CANDY));

    // 龙舒芙蕾
    public static final RegistryObject<Item> DRAGON_SOUFFLE_ITEM = ITEMS.register("dragon_souffle",
            () -> new BowlFoodOnlyItem(KEFoods.DRAGON_SOUFFLE));

    // 龙蛋液
    public static final RegistryObject<Item> DRAGON_EGG_LIQUID = ITEMS.register("dragon_egg_liquid",
            () -> new Item(new Item.Properties().food(KEFoods.DRAGON_EGG_LIQUID_FOOD)));

    // 紫颂果籽
    public static final RegistryObject<Item> CHORUS_SEED = ITEMS.register("chorus_seed",
            () -> new Item(new Item.Properties().food(KEFoods.CHORUS_SEED_FOOD)));

    // 紫颂花瓣
    public static final RegistryObject<Item> CHORUS_PETAL = ITEMS.register("chorus_petal",
            () -> new Item(new Item.Properties()));

    // 煎龙蛋
    public static final RegistryObject<Item> FRIED_DRAGON_EGG_ITEM = ITEMS.register("fried_dragon_egg",
            () -> new FoodWithEffectsItem(KEFoods.FRIED_DRAGON_EGG));

    // 紫颂花茶
    public static final RegistryObject<Item> CHORUS_FLOWER_TEA_ITEM = ITEMS.register("chorus_flower_tea",
            () -> new BowlFoodOnlyItem(KEFoods.CHORUS_FLOWER_TEA));

    // 紫颂花糕
    public static final RegistryObject<Item> CHORUS_FLOWER_CAKE_ITEM = ITEMS.register("chorus_flower_cake",
            () -> new FoodWithEffectsItem(KEFoods.CHORUS_FLOWER_CAKE));

    // 紫颂果籽饼干
    public static final RegistryObject<Item> CHORUS_SEED_COOKIE_ITEM = ITEMS.register("chorus_seed_cookie",
            () -> new FoodWithEffectsItem(KEFoods.CHORUS_SEED_COOKIE));

    // 龙蛋冰淇淋
    public static final RegistryObject<Item> DRAGON_EGG_ICE_CREAM_ITEM = ITEMS.register("dragon_egg_ice_cream",
            () -> new DragonEggShellFoodItem(KEFoods.DRAGON_EGG_ICE_CREAM));

    // 填馅虚空海螺
    public static final RegistryObject<Item> STUFFED_VOID_CONCH_ITEM = ITEMS.register("stuffed_void_conch",
            () -> new FoodWithEffectsItem(KEFoods.STUFFED_VOID_CONCH));

    // 末地猪儿虫刺身
    public static final RegistryObject<Item> END_CATERPILLAR_SASHIMI_ITEM = ITEMS.register("end_caterpillar_sashimi",
            () -> new BowlFoodOnlyItem(KEFoods.END_CATERPILLAR_SASHIMI));

    // 龙息桶
    public static final RegistryObject<Item> DRAGON_BREATH_BUCKET_ITEM = ITEMS.register("dragon_breath_bucket",
            () -> new DragonBreathBucket(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}