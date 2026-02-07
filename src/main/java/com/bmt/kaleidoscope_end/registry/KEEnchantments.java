package com.bmt.kaleidoscope_end.registry;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.Enchantment;

public class KEEnchantments {
    
    public static final ResourceKey<Enchantment> VOID_ASSAULT = ResourceKey.create(
        Registries.ENCHANTMENT,
        ResourceLocation.fromNamespaceAndPath(KaleidoscopeEnd.MOD_ID, "void_assault")
    );
    
}