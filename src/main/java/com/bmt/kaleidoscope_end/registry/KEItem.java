package com.bmt.kaleidoscope_end.registry;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.item.DragonEggShellFoodItem;
import com.bmt.kaleidoscope_end.item.DragonToothKnifeItem;
import com.bmt.kaleidoscope_end.item.ShulkerShellFoodItem;
import com.github.ysbbbbbb.kaleidoscopecookery.item.BowlFoodOnlyItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class KEItem {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, KaleidoscopeEnd.MODID);

    public static final RegistryObject<Item> DRAGON_TOOTH_KNIFE = ITEMS.register("dragon_tooth_knife",
            () -> new DragonToothKnifeItem());// 龙牙刀

    public static final RegistryObject<Item> ENDER_MINT = ITEMS.register("ender_mint", // 末影薄荷
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> VOID_CONCH = ITEMS.register("void_conch", // 虚空海螺
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRAGON_DUST = ITEMS.register("dragon_dust", // 龙尘
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRAGON_TOOTH = ITEMS.register("dragon_tooth", // 龙牙
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ENDERMITE_EGG = ITEMS.register("endermite_egg", // 末影螨卵
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ENDER_DRAGON_SMITHING_TEMPLATE = ITEMS.register("ender_dragon_smithing_template", // 锻造模板
            () -> new SmithingTemplateItem(
                    Component.translatable("item.kaleidoscope_end.ender_dragon_smithing_template.upgrade_description"),
                    Component.translatable("item.kaleidoscope_end.ender_dragon_smithing_template.applies_to_description"),
                    Component.translatable("item.kaleidoscope_end.ender_dragon_smithing_template.ingredients_description"),
                    Component.translatable("item.kaleidoscope_end.ender_dragon_smithing_template.base_slot_description"),
                    Component.translatable("item.kaleidoscope_end.ender_dragon_smithing_template.additions_slot_description"),
                    List.of(),
                    List.of()
            ));

    public static final RegistryObject<Item> DRAGON_EGG_SHELL = ITEMS.register("dragon_egg_shell", // 龙蛋壳
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRAGON_BREATH_CHORUS_SOUP_ITEM = ITEMS.register("dragon_breath_chorus_soup", // 龙息紫颂汤
            () -> new BowlFoodOnlyItem(KEFoods.DRAGON_BREATH_CHORUS_SOUP));

    public static final RegistryObject<Item> STUFFED_SHULKER_ITEM = ITEMS.register("stuffed_shulker", // 填馅潜影贝
            () -> new ShulkerShellFoodItem(KEFoods.STUFFED_SHULKER));

    public static final RegistryObject<Item> CHORUS_PASTA_ITEM = ITEMS.register("chorus_pasta", // 紫颂果意面
            () -> new BowlFoodOnlyItem(KEFoods.CHORUS_PASTA));

    public static final RegistryObject<Item> RAW_ENDER_DRAGON_MEAT_ITEM = ITEMS.register("raw_ender_dragon_meat", // 生末影龙肉
            () -> new Item(new Item.Properties().food(KEFoods.RAW_ENDER_DRAGON_MEAT)));

    public static final RegistryObject<Item> COOKED_ENDER_DRAGON_MEAT_ITEM = ITEMS.register("cooked_ender_dragon_meat", // 烤末影龙肉
            () -> new Item(new Item.Properties().food(KEFoods.COOKED_ENDER_DRAGON_MEAT)));

    public static final RegistryObject<Item> DREAM_BERRY_ITEM = ITEMS.register("dream_berry", // 梦境浆果
            () -> new Item(new Item.Properties().food(KEFoods.DREAM_BERRY)));

    public static final RegistryObject<Item> MINT_CHORUS_MOUSSE_ITEM = ITEMS.register("mint_chorus_mousse", // 薄荷紫颂慕斯
            () -> new Item(new Item.Properties().food(KEFoods.MINT_CHORUS_MOUSSE)));

    public static final RegistryObject<Item> OPTIC_NERVE_ITEM = ITEMS.register("optic_nerve", // 视神经
            () -> new Item(new Item.Properties().food(KEFoods.OPTIC_NERVE)));

    public static final RegistryObject<Item> END_SALAD_ITEM = ITEMS.register("end_salad", // 末地沙拉
            () -> new BowlFoodOnlyItem(KEFoods.END_SALAD));

    public static final RegistryObject<Item> DARK_DRAGON_EGG_STEW_ITEM = ITEMS.register("dark_dragon_egg_stew", // 暗黑龙蛋煲
            () -> new DragonEggShellFoodItem(KEFoods.DARK_DRAGON_EGG_STEW));

    public static final RegistryObject<Item> SHULKER_SHELL_MEAT_ITEM = ITEMS.register("shulker_shell_meat", // 潜影贝质
            () -> new Item(new Item.Properties().food(KEFoods.SHULKER_SHELL_MEAT)));

    public static final RegistryObject<Item> SHULKER_SHELL_STEW_ITEM = ITEMS.register("shulker_shell_stew", // 潜影贝质炖
            () -> new BowlFoodOnlyItem(KEFoods.SHULKER_SHELL_STEW));

    public static final RegistryObject<Item> SHULKER_ICE_CREAM_ITEM = ITEMS.register("shulker_ice_cream", // 潜影贝冰淇淋
            () -> new ShulkerShellFoodItem(KEFoods.SHULKER_ICE_CREAM));

    public static final RegistryObject<Item> VOID_CONCH_NOODLE_SOUP_ITEM = ITEMS.register("void_conch_noodle_soup", // 虚空海螺汤面
            () -> new BowlFoodOnlyItem(KEFoods.VOID_CONCH_NOODLE_SOUP));

    public static final RegistryObject<Item> STIR_FRIED_ENDERMITE_MEAT_ITEM = ITEMS.register("stir_fried_endermite_meat", // 炒末影螨肉
            () -> new BowlFoodOnlyItem(KEFoods.STIR_FRIED_ENDERMITE_MEAT));

    public static final RegistryObject<Item> STIR_FRIED_ENDERMITE_MEAT_RICE_BOWL_ITEM = ITEMS.register("stir_fried_endermite_meat_rice_bowl", // 炒末影螨肉盖饭
            () -> new BowlFoodOnlyItem(KEFoods.STIR_FRIED_ENDERMITE_MEAT_RICE_BOWL));

    public static final RegistryObject<Item> RAW_ENDERMITE_MEAT_ITEM = ITEMS.register("raw_endermite_meat", // 生末影螨肉
            () -> new Item(new Item.Properties().food(KEFoods.RAW_ENDERMITE_MEAT)));

    public static final RegistryObject<Item> ROASTED_ENDERMITE_MEAT_ITEM = ITEMS.register("roasted_endermite_meat", // 烤末影螨肉
            () -> new Item(new Item.Properties().food(KEFoods.ROASTED_ENDERMITE_MEAT)));

    public static final RegistryObject<Item> END_PIG_WORM_ITEM = ITEMS.register("end_pig_worm", // 末地猪儿虫
            () -> new Item(new Item.Properties().food(KEFoods.END_PIG_WORM)));

    public static final RegistryObject<Item> DRAGON_BREATH_MIXED_STEW_ITEM = ITEMS.register("dragon_breath_mixed_stew", // 龙息乱烩
            () -> new ShulkerShellFoodItem(KEFoods.DRAGON_BREATH_MIXED_STEW));

    public static final RegistryObject<Item> DRAGON_HEAD_WITH_SAUCE_ITEM = ITEMS.register("dragon_head_with_sauce", // 浇汁龙首
            () -> new BowlFoodOnlyItem(KEFoods.DRAGON_HEAD_WITH_SAUCE));

    public static final RegistryObject<Item> MINT_NOODLE_SOUP_ITEM = ITEMS.register("mint_noodle_soup", // 薄荷汤面
            () -> new BowlFoodOnlyItem(KEFoods.MINT_NOODLE_SOUP));

    public static final RegistryObject<Item> MINT_SAUCE_SHULKER_MEAT_ITEM = ITEMS.register("mint_sauce_shulker_meat", // 薄荷酱汁潜影贝质
            () -> new BowlFoodOnlyItem(KEFoods.MINT_SAUCE_SHULKER_MEAT));

    public static final RegistryObject<Item> MINT_SAUCE_SHULKER_MEAT_RICE_BOWL_ITEM = ITEMS.register("mint_sauce_shulker_meat_rice_bowl", // 薄荷酱汁潜影贝质盖饭
            () -> new BowlFoodOnlyItem(KEFoods.MINT_SAUCE_SHULKER_MEAT_RICE_BOWL));

    public static final RegistryObject<Item> ENDER_MINT_CANDY_ITEM = ITEMS.register("ender_mint_candy", // 末影薄荷糖
            () -> new Item(new Item.Properties().food(KEFoods.ENDER_MINT_CANDY)));

    public static final RegistryObject<Item> DRAGON_SOUFFLE_ITEM = ITEMS.register("dragon_souffle", // 龙舒芙蕾
            () -> new BowlFoodOnlyItem(KEFoods.DRAGON_SOUFFLE));

    public static final RegistryObject<Item> DARK_DRAGON_STEAK_ITEM = ITEMS.register("dark_dragon_steak", // 暗黑龙排
            () -> new BowlFoodOnlyItem(KEFoods.DARK_DRAGON_STEAK));

    // 龙蛋液
    public static final RegistryObject<Item> DRAGON_EGG_LIQUID = ITEMS.register("dragon_egg_liquid",
            () -> new Item(new Item.Properties()));

    // 紫颂果籽
    public static final RegistryObject<Item> CHORUS_SEED = ITEMS.register("chorus_seed",
            () -> new Item(new Item.Properties()));

    // 紫颂花瓣
    public static final RegistryObject<Item> CHORUS_PETAL = ITEMS.register("chorus_petal",
            () -> new Item(new Item.Properties()));

    // 煎龙蛋
    public static final RegistryObject<Item> FRIED_DRAGON_EGG_ITEM = ITEMS.register("fried_dragon_egg",
            () -> new Item(new Item.Properties().food(KEFoods.FRIED_DRAGON_EGG)));

    // 龙蛋羹
    public static final RegistryObject<Item> DRAGON_EGG_CUSTARD_ITEM = ITEMS.register("dragon_egg_custard",
            () -> new DragonEggShellFoodItem(KEFoods.DRAGON_EGG_CUSTARD));

    // 紫颂花茶
    public static final RegistryObject<Item> CHORUS_FLOWER_TEA_ITEM = ITEMS.register("chorus_flower_tea",
            () -> new BowlFoodOnlyItem(KEFoods.CHORUS_FLOWER_TEA));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}