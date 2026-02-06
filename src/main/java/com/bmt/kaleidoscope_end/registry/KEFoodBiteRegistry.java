package com.bmt.kaleidoscope_end.registry;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.github.ysbbbbbb.kaleidoscopecookery.init.registry.FoodBiteRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class KEFoodBiteRegistry {
    public static ResourceLocation END_SALAD;
    public static ResourceLocation DARK_DRAGON_STEAK;
    public static ResourceLocation DRAGON_HEAD_WITH_SAUCE;
    public static ResourceLocation DARK_DRAGON_EGG_STEW;
    public static ResourceLocation DRAGON_EGG_CUSTARD;

    public static void init() {
        FoodBiteRegistry registry = new FoodBiteRegistry();

        // 末地沙拉
        END_SALAD = registry.registerFoodData(KaleidoscopeEnd.id("end_salad"), FoodBiteRegistry.FoodData
                .create(3, KEFoods.END_SALAD_BLOCK, KEFoods.END_SALAD_ITEM));

        // 暗黑龙排
        DARK_DRAGON_STEAK = registry.registerFoodData(KaleidoscopeEnd.id("dark_dragon_steak"), FoodBiteRegistry.FoodData
                .create(4, KEFoods.DARK_DRAGON_STEAK_BLOCK, KEFoods.DARK_DRAGON_STEAK_ITEM));

        // 浇汁龙首
        DRAGON_HEAD_WITH_SAUCE = registry.registerFoodData(KaleidoscopeEnd.id("dragon_head_with_sauce"), FoodBiteRegistry.FoodData
                .createOneByTwo(6, KEFoods.DRAGON_HEAD_WITH_SAUCE_BLOCK, KEFoods.DRAGON_HEAD_WITH_SAUCE_ITEM));

        // 龙蛋煲
        DARK_DRAGON_EGG_STEW = registry.registerFoodData(KaleidoscopeEnd.id("dark_dragon_egg_stew"), FoodBiteRegistry.FoodData
                .create(4, KEFoods.DARK_DRAGON_EGG_STEW_BLOCK, KEFoods.DARK_DRAGON_EGG_STEW_ITEM)
                .setLootItem(() -> KEItem.DRAGON_EGG_SHELL.get())
                .setAABB(Block.box(1, 0, 1, 15, 11, 15)));

        // 龙蛋羹
        DRAGON_EGG_CUSTARD = registry.registerFoodData(KaleidoscopeEnd.id("dragon_egg_custard"), FoodBiteRegistry.FoodData
                .create(4, KEFoods.DRAGON_EGG_CUSTARD_BLOCK, KEFoods.DRAGON_EGG_CUSTARD_ITEM)
                .setLootItem(() -> KEItem.DRAGON_EGG_SHELL.get())
                .setAABB(Block.box(1, 0, 1, 15, 11, 15)));
    }
}
