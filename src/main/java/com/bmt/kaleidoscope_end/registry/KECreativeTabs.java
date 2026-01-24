package com.bmt.kaleidoscope_end.registry;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class KECreativeTabs {
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KaleidoscopeEnd.MODID);

    public static final RegistryObject<CreativeModeTab> KALEIDOSCOPE_END_FOODS = CREATIVE_MODE_TABS.register("kaleidoscope_end_foods",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.kaleidoscope_end_foods"))
                    .icon(() -> new ItemStack(KEItem.ENDER_MINT.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(KEItem.DRAGON_TOOTH_KNIFE.get());
                        output.accept(KEItem.VOID_CONCH.get());
                        output.accept(KEItem.DRAGON_DUST.get());
                        output.accept(KEItem.DRAGON_TOOTH.get());
                        output.accept(KEItem.DRAGON_EGG_SHELL.get());
                        output.accept(KEItem.ENDERMITE_EGG.get());
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
                        output.accept(KEItem.END_SALAD_ITEM.get());
                        output.accept(KEItem.DARK_DRAGON_EGG_STEW_ITEM.get());
                        output.accept(KEItem.SHULKER_SHELL_MEAT_ITEM.get());
                        output.accept(KEItem.SHULKER_SHELL_STEW_ITEM.get());
                        output.accept(KEItem.SHULKER_ICE_CREAM_ITEM.get());
                        output.accept(KEItem.VOID_CONCH_NOODLE_SOUP_ITEM.get());
                        output.accept(KEItem.STIR_FRIED_ENDERMITE_MEAT_ITEM.get());
                        output.accept(KEItem.STIR_FRIED_ENDERMITE_MEAT_RICE_BOWL_ITEM.get());
                        output.accept(KEItem.RAW_ENDERMITE_MEAT_ITEM.get());
                        output.accept(KEItem.ROASTED_ENDERMITE_MEAT_ITEM.get());
                        output.accept(KEItem.END_PIG_WORM_ITEM.get());
                        output.accept(KEItem.DRAGON_BREATH_MIXED_STEW_ITEM.get());
                        output.accept(KEItem.DRAGON_HEAD_WITH_SAUCE_ITEM.get());
                        output.accept(KEItem.MINT_NOODLE_SOUP_ITEM.get());
                        output.accept(KEItem.MINT_SAUCE_SHULKER_MEAT_ITEM.get());
                        output.accept(KEItem.MINT_SAUCE_SHULKER_MEAT_RICE_BOWL_ITEM.get());
                        output.accept(KEItem.ENDER_MINT_CANDY_ITEM.get());
                        output.accept(KEItem.DRAGON_SOUFFLE_ITEM.get());
                        output.accept(KEItem.DARK_DRAGON_STEAK_ITEM.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}