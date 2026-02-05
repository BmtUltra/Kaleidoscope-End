package com.bmt.kaleidoscope_end.registry;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.ForgeRegistries;

public interface KETags {
    interface Enchantments {
        TagKey<Enchantment> KE_ENCHANTMENTS = registry("ke_enchantments");

        private static TagKey<Enchantment> registry(String id) {
            return TagKey.create(ForgeRegistries.ENCHANTMENTS.getRegistryKey(), KaleidoscopeEnd.id(id));
        }
    }
}
