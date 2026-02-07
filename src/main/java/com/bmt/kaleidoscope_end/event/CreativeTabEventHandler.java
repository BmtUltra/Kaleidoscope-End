package com.bmt.kaleidoscope_end.event;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@EventBusSubscriber(modid = KaleidoscopeEnd.MOD_ID)
public class CreativeTabEventHandler {

    @SubscribeEvent
    public static void addItemsToTabs(BuildCreativeModeTabContentsEvent event) {
        ResourceLocation tabLocation = event.getTabKey().location();
        if (tabLocation.equals(KaleidoscopeEnd.fromNamespaceAndPath("kaleidoscope_cookery", "cookery_food"))) {
            BuiltInRegistries.ITEM.entrySet().stream()
                .filter(entry -> entry.getKey().location().getNamespace().equals(KaleidoscopeEnd.MOD_ID))
                .forEach(entry -> event.remove(new ItemStack(entry.getValue()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS));
        }
    }
}