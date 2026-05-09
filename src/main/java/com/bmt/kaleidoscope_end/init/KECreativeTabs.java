package com.bmt.kaleidoscope_end.init;

import java.util.Objects;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.github.ysbbbbbb.kaleidoscopecookery.init.registry.FoodBiteRegistry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class KECreativeTabs {
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KaleidoscopeEnd.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> KALEIDOSCOPE_END_FOODS = CREATIVE_MODE_TABS.register("kaleidoscope_end_foods",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.kaleidoscope_end_foods"))
                    .icon(() -> new ItemStack(KEItem.ENDER_MINT.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(KEItem.DRAGON_TOOTH_KNIFE.get());
                        output.accept(KEItem.VOID_CONCH.get());
                        output.accept(KEItem.DRAGON_DUST.get());
                        output.accept(KEItem.DRAGON_TOOTH.get());
                        output.accept(KEItem.DRAGON_EGG_SHELL.get());
                        output.accept(KEItem.ENDER_DRAGON_SMITHING_TEMPLATE.get());
                        output.accept(KEItem.ENDER_MINT.get());
                        output.accept(KEItem.DRAGON_BREATH_CHORUS_SOUP_ITEM.get());
                        output.accept(KEItem.STUFFED_SHULKER_ITEM.get());
                        output.accept(KEItem.CHORUS_PASTA_ITEM.get());
                        output.accept(KEItem.RAW_ENDER_DRAGON_MEAT_ITEM.get());
                        output.accept(KEItem.COOKED_ENDER_DRAGON_MEAT_ITEM.get());
                        output.accept(KEItem.DREAM_BERRY_ITEM.get());
                        output.accept(KEItem.MINT_CHORUS_MOUSSE_ITEM.get());
                        output.accept(KEItem.OPTIC_NERVE_ITEM.get());

                        FoodBiteRegistry.FOOD_DATA_MAP.forEach((resourceLocation, foodData) -> {
                            if (resourceLocation.getNamespace().equals(KaleidoscopeEnd.MOD_ID)) {
                                Item item = BuiltInRegistries.ITEM.get(resourceLocation);
                                output.accept(Objects.requireNonNull(item));
                            }
                        });

                        output.accept(KEItem.SHULKER_SHELL_MEAT_ITEM.get());
                        output.accept(KEItem.SHULKER_SHELL_STEW_ITEM.get());
                        output.accept(KEItem.SHULKER_ICE_CREAM_ITEM.get());
                        output.accept(KEItem.VOID_CONCH_NOODLE_SOUP_ITEM.get());
                        output.accept(KEItem.STIR_FRIED_ENDERMITE_MEAT_ITEM.get());
                        output.accept(KEItem.STIR_FRIED_ENDERMITE_MEAT_RICE_BOWL_ITEM.get());
                        output.accept(KEItem.RAW_ENDERMITE_MEAT_ITEM.get());
                        output.accept(KEItem.ROASTED_ENDERMITE_MEAT_ITEM.get());
                        output.accept(KEItem.END_CATERPILLAR_ITEM.get());
                        output.accept(KEItem.DRAGON_BREATH_MIXED_STEW_ITEM.get());
                        output.accept(KEItem.MINT_NOODLE_SOUP_ITEM.get());
                        output.accept(KEItem.MINT_SAUCE_SHULKER_MEAT_ITEM.get());
                        output.accept(KEItem.MINT_SAUCE_SHULKER_MEAT_RICE_BOWL_ITEM.get());
                        output.accept(KEItem.ENDER_MINT_CANDY_ITEM.get());
                        output.accept(KEItem.DRAGON_SOUFFLE_ITEM.get());
                        output.accept(KEItem.DRAGON_EGG_LIQUID.get());
                        output.accept(KEItem.CHORUS_SEED.get());
                        output.accept(KEItem.CHORUS_PETAL.get());
                        output.accept(KEItem.FRIED_DRAGON_EGG_ITEM.get());
                        output.accept(KEItem.CHORUS_FLOWER_SOUP_ITEM.get());
                        output.accept(KEItem.CHORUS_FLOWER_CAKE_ITEM.get());
                        output.accept(KEItem.CHORUS_SEED_COOKIE_ITEM.get());
                        output.accept(KEItem.STUFFED_VOID_CONCH_ITEM.get());
                        output.accept(KEItem.DRAGON_BREATH_BUCKET_ITEM.get());
                        output.accept(KEItem.END_STOVE_ITEM.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}