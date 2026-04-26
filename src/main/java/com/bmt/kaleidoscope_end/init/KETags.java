package com.bmt.kaleidoscope_end.init;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;

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

    interface Blocks{
        TagKey<Block> END_STONE_GROWABLE = registry();
        private static TagKey<Block> registry() {
            return TagKey.create(Registries.BLOCK, KaleidoscopeEnd.id("end_stone_growable"));
        }
    }
}
