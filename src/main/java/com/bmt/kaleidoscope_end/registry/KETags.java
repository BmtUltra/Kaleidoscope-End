package com.bmt.kaleidoscope_end.registry;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;

public interface KETags {
    interface Items {
        TagKey<Item> MOD_ITEMS = TagKey.create(Registries.ITEM, KaleidoscopeEnd.id("mod_items"));
    }
    
    interface Enchantments {
        TagKey<Enchantment> KE_ENCHANTMENTS = registry();

        private static TagKey<Enchantment> registry() {
            return TagKey.create(Registries.ENCHANTMENT, KaleidoscopeEnd.id("ke_enchantments"));
        }
    }
}
