package com.bmt.kaleidoscope_end.registry;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.github.ysbbbbbb.kaleidoscopecookery.init.registry.FoodBiteRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class KEFoodBiteRegistry {
    public static ResourceLocation DARK_DRAGON_EGG_STEW;

    public static void init() {
        FoodBiteRegistry registry = new FoodBiteRegistry();
        DARK_DRAGON_EGG_STEW = registry.registerFoodData(KaleidoscopeEnd.id("dark_dragon_egg_stew"), FoodBiteRegistry.FoodData
                .create(4, KEFoods.DARK_DRAGON_EGG_STEW_BLOCK, KEFoods.DARK_DRAGON_EGG_STEW_ITEM)
                .setLootItem(() -> KEItem.DRAGON_EGG_SHELL.get())
                .setAABB(Block.box(0, 0, 0, 16, 11, 16))
        );

    }
}
