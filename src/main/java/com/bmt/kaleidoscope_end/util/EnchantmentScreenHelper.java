package com.bmt.kaleidoscope_end.util;

import com.bmt.kaleidoscope_end.registry.KEItem;
import net.minecraft.world.inventory.EnchantmentMenu;

public class EnchantmentScreenHelper {

    // 原版颜色
    private static final int VANILLA_ENABLED_COLOR = 8453920;     // 绿色 (0x80FF20) - 经验够时的文字
    private static final int VANILLA_DISABLED_COLOR = 6839882;    // 深灰色 (0x68574A) - 经验不够时的基础色
    private static final int VANILLA_DISABLED_HALF = 3419941;     // (0x68574A & 0xFEFEFE) >> 1 = 0x342BA5
    private static final int VANILLA_LEVEL_COLOR = 4226832;       // (0x408010) - 经验不够时的等级数字
    private static final int VANILLA_HIGHLIGHTED_COLOR = 16777088; // (0xFFFFA0) - 鼠标悬停时的颜色
    
    // 自定义颜色
    private static final int CUSTOM_ENABLED_COLOR = 11141290;     // 紫色 (0xAA00AA)
    private static final int CUSTOM_DISABLED_COLOR = 4539717;     // 深紫色 (0x453545)
    private static final int CUSTOM_DISABLED_HALF = 2269858;      // (0x453545 & 0xFEFEFE) >> 1 = 0x229AA2
    private static final int CUSTOM_LEVEL_COLOR = 6684774;        // 暗紫色 (0x660066)
    private static final int CUSTOM_HIGHLIGHTED_COLOR = 14745855; // 亮紫色 (0xE0C0FF)

    public static int warpColor(int color, EnchantmentMenu menu) {
        if (!menu.slots.get(1).getItem().is(KEItem.VOID_CONCH.get())) {
            return color;
        }
        
        // 经验够的情况 - 绿色改为紫色
        if (color == VANILLA_ENABLED_COLOR) {
            return CUSTOM_ENABLED_COLOR;
        }
        
        // 经验不够的情况 - 深灰色改为深紫色
        if (color == VANILLA_DISABLED_COLOR) {
            return CUSTOM_DISABLED_COLOR;
        }
        
        // 经验不够时的半透明颜色
        if (color == VANILLA_DISABLED_HALF) {
            return CUSTOM_DISABLED_HALF;
        }
        
        // 经验不够时的等级数字颜色
        if (color == VANILLA_LEVEL_COLOR) {
            return CUSTOM_LEVEL_COLOR;
        }
        
        // 鼠标悬停时的颜色
        if (color == VANILLA_HIGHLIGHTED_COLOR) {
            return CUSTOM_HIGHLIGHTED_COLOR;
        }
        
        return color;
    }
}
