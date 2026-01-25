package com.bmt.kaleidoscope_end.registry;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.item.DragonEggShellFoodItem;
import com.bmt.kaleidoscope_end.item.DragonToothKnifeItem;
import com.bmt.kaleidoscope_end.item.ShulkerShellFoodItem;
import com.github.ysbbbbbb.kaleidoscopecookery.item.BowlFoodOnlyItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Supplier;

public class KEItem {
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KaleidoscopeEnd.MODID);

    public static final DeferredItem<Item> DRAGON_TOOTH_KNIFE = registerItem("dragon_tooth_knife",
            () -> new DragonToothKnifeItem());

    public static final DeferredItem<Item> ENDER_MINT = ITEMS.registerSimpleItem("ender_mint");

    public static final DeferredItem<Item> VOID_CONCH = ITEMS.registerSimpleItem("void_conch");

    public static final DeferredItem<Item> DRAGON_DUST = ITEMS.registerSimpleItem("dragon_dust");

    public static final DeferredItem<Item> DRAGON_TOOTH = ITEMS.registerSimpleItem("dragon_tooth");

    public static final DeferredItem<Item> ENDERMITE_EGG = ITEMS.registerSimpleItem("endermite_egg");

    public static final DeferredItem<Item> ENDER_DRAGON_SMITHING_TEMPLATE = registerItem("ender_dragon_smithing_template",
            () -> new SmithingTemplateItem(
                    Component.translatable("item.kaleidoscope_end.ender_dragon_smithing_template.upgrade_description"),
                    Component.translatable("item.kaleidoscope_end.ender_dragon_smithing_template.applies_to_description"),
                    Component.translatable("item.kaleidoscope_end.ender_dragon_smithing_template.ingredients_description"),
                    Component.translatable("item.kaleidoscope_end.ender_dragon_smithing_template.base_slot_description"),
                    Component.translatable("item.kaleidoscope_end.ender_dragon_smithing_template.additions_slot_description"),
                    List.of(),
                    List.of()
            ));

    public static final DeferredItem<Item> DRAGON_EGG_SHELL = ITEMS.registerSimpleItem("dragon_egg_shell");

    public static final DeferredItem<Item> DRAGON_BREATH_CHORUS_SOUP_ITEM = registerItem("dragon_breath_chorus_soup",
            () -> new BowlFoodOnlyItem(KEFoods.DRAGON_BREATH_CHORUS_SOUP));

    public static final DeferredItem<Item> STUFFED_SHULKER_ITEM = registerItem("stuffed_shulker",
            () -> new ShulkerShellFoodItem(KEFoods.STUFFED_SHULKER));

    public static final DeferredItem<Item> CHORUS_PASTA_ITEM = registerItem("chorus_pasta",
            () -> new BowlFoodOnlyItem(KEFoods.CHORUS_PASTA));

    public static final DeferredItem<Item> RAW_ENDER_DRAGON_MEAT_ITEM = registerItem("raw_ender_dragon_meat",
            () -> new Item(new Item.Properties().food(KEFoods.RAW_ENDER_DRAGON_MEAT)));

    public static final DeferredItem<Item> COOKED_ENDER_DRAGON_MEAT_ITEM = registerItem("cooked_ender_dragon_meat",
            () -> new Item(new Item.Properties().food(KEFoods.COOKED_ENDER_DRAGON_MEAT)));

    public static final DeferredItem<Item> DREAM_BERRY_ITEM = registerItem("dream_berry",
            () -> new Item(new Item.Properties().food(KEFoods.DREAM_BERRY)));

    public static final DeferredItem<Item> MINT_CHORUS_MOUSSE_ITEM = registerItem("mint_chorus_mousse",
            () -> new Item(new Item.Properties().food(KEFoods.MINT_CHORUS_MOUSSE)));

    public static final DeferredItem<Item> OPTIC_NERVE_ITEM = registerItem("optic_nerve",
            () -> new Item(new Item.Properties().food(KEFoods.OPTIC_NERVE)));

    public static final DeferredItem<Item> END_SALAD_ITEM = registerItem("end_salad",
            () -> new BowlFoodOnlyItem(KEFoods.END_SALAD));

    public static final DeferredItem<Item> DARK_DRAGON_EGG_STEW_ITEM = registerItem("dark_dragon_egg_stew",
            () -> new DragonEggShellFoodItem(KEFoods.DARK_DRAGON_EGG_STEW));

    public static final DeferredItem<Item> SHULKER_SHELL_MEAT_ITEM = registerItem("shulker_shell_meat",
            () -> new Item(new Item.Properties().food(KEFoods.SHULKER_SHELL_MEAT)));

    public static final DeferredItem<Item> SHULKER_SHELL_STEW_ITEM = registerItem("shulker_shell_stew",
            () -> new BowlFoodOnlyItem(KEFoods.SHULKER_SHELL_STEW));

    public static final DeferredItem<Item> SHULKER_ICE_CREAM_ITEM = registerItem("shulker_ice_cream",
            () -> new ShulkerShellFoodItem(KEFoods.SHULKER_ICE_CREAM));

    public static final DeferredItem<Item> VOID_CONCH_NOODLE_SOUP_ITEM = registerItem("void_conch_noodle_soup",
            () -> new BowlFoodOnlyItem(KEFoods.VOID_CONCH_NOODLE_SOUP));

    public static final DeferredItem<Item> STIR_FRIED_ENDERMITE_MEAT_ITEM = registerItem("stir_fried_endermite_meat",
            () -> new BowlFoodOnlyItem(KEFoods.STIR_FRIED_ENDERMITE_MEAT));

    public static final DeferredItem<Item> STIR_FRIED_ENDERMITE_MEAT_RICE_BOWL_ITEM = registerItem("stir_fried_endermite_meat_rice_bowl",
            () -> new BowlFoodOnlyItem(KEFoods.STIR_FRIED_ENDERMITE_MEAT_RICE_BOWL));

    public static final DeferredItem<Item> RAW_ENDERMITE_MEAT_ITEM = registerItem("raw_endermite_meat",
            () -> new Item(new Item.Properties().food(KEFoods.RAW_ENDERMITE_MEAT)));

    public static final DeferredItem<Item> ROASTED_ENDERMITE_MEAT_ITEM = registerItem("roasted_endermite_meat",
            () -> new Item(new Item.Properties().food(KEFoods.ROASTED_ENDERMITE_MEAT)));

    public static final DeferredItem<Item> END_PIG_WORM_ITEM = registerItem("end_pig_worm",
            () -> new Item(new Item.Properties().food(KEFoods.END_PIG_WORM)));

    public static final DeferredItem<Item> DRAGON_BREATH_MIXED_STEW_ITEM = registerItem("dragon_breath_mixed_stew",
            () -> new ShulkerShellFoodItem(KEFoods.DRAGON_BREATH_MIXED_STEW));

    public static final DeferredItem<Item> DRAGON_HEAD_WITH_SAUCE_ITEM = registerItem("dragon_head_with_sauce",
            () -> new BowlFoodOnlyItem(KEFoods.DRAGON_HEAD_WITH_SAUCE));

    public static final DeferredItem<Item> MINT_NOODLE_SOUP_ITEM = registerItem("mint_noodle_soup",
            () -> new BowlFoodOnlyItem(KEFoods.MINT_NOODLE_SOUP));

    public static final DeferredItem<Item> MINT_SAUCE_SHULKER_MEAT_ITEM = registerItem("mint_sauce_shulker_meat",
            () -> new BowlFoodOnlyItem(KEFoods.MINT_SAUCE_SHULKER_MEAT));

    public static final DeferredItem<Item> MINT_SAUCE_SHULKER_MEAT_RICE_BOWL_ITEM = registerItem("mint_sauce_shulker_meat_rice_bowl",
            () -> new BowlFoodOnlyItem(KEFoods.MINT_SAUCE_SHULKER_MEAT_RICE_BOWL));

    public static final DeferredItem<Item> ENDER_MINT_CANDY_ITEM = registerItem("ender_mint_candy",
            () -> new Item(new Item.Properties().food(KEFoods.ENDER_MINT_CANDY)));

    public static final DeferredItem<Item> DRAGON_SOUFFLE_ITEM = registerItem("dragon_souffle",
            () -> new BowlFoodOnlyItem(KEFoods.DRAGON_SOUFFLE));

    public static final DeferredItem<Item> DARK_DRAGON_STEAK_ITEM = registerItem("dark_dragon_steak",
            () -> new BowlFoodOnlyItem(KEFoods.DARK_DRAGON_STEAK));

    private static DeferredItem<Item> registerItem(String name, Supplier<Item> supplier) {
        return ITEMS.registerItem(name, props -> supplier.get());
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}