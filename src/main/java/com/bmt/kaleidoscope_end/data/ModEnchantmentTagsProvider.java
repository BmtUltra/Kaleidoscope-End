package com.bmt.kaleidoscope_end.data;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.NotNull;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.registry.KETags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModEnchantmentTagsProvider extends EnchantmentTagsProvider {
    public ModEnchantmentTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, KaleidoscopeEnd.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(KETags.Enchantments.KE_ENCHANTMENTS)
            .add(ModEnchantmentProvider.VOID_ASSAULT);
    }
}
