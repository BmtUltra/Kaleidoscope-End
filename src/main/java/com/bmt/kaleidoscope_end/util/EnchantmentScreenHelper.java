package com.bmt.kaleidoscope_end.util;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.registry.KEItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.EnchantmentMenu;

public class EnchantmentScreenHelper {
    public static final ResourceLocation KE_ENCHANTING_TABLE_LOCATION = KaleidoscopeEnd.id("textures/gui/container/enchanting_table.png");

    public static int warpColor(int color, EnchantmentMenu menu) {
        if (color == 8453920 && menu.slots.get(1).getItem().is(KEItem.VOID_CONCH.get())) {
            return 11141290;
        }
        return color;
    }
}
