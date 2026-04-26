package com.bmt.kaleidoscope_end.init;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public interface KETags {
    interface Enchantments {
        TagKey<Enchantment> KE_ENCHANTMENTS = registry("ke_enchantments");

        private static TagKey<Enchantment> registry(String id) {
            return TagKey.create(ForgeRegistries.ENCHANTMENTS.getRegistryKey(), KaleidoscopeEnd.id(id));
        }
    }

    interface Blocks{
        TagKey<Block> END_STONE_GROWABLE = registry("end_stone_growable");
        private static TagKey<Block> registry(String id) {
            return TagKey.create(ForgeRegistries.BLOCKS.getRegistryKey(), KaleidoscopeEnd.id(id));
        }
    }
}
