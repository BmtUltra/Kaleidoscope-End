package com.bmt.kaleidoscope_end.util;

import com.bmt.kaleidoscope_end.registry.KEItem;
import net.minecraft.world.inventory.EnchantmentMenu;

public class EnchantmentScreenHelper {
    public static int warpColor(int color, EnchantmentMenu menu) {
        if (color == 8453920 && menu.slots.get(1).getItem().is(KEItem.VOID_CONCH.get())) {
            return 11141290;
        }
        return color;
    }
}
