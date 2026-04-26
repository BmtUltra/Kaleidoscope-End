package com.bmt.kaleidoscope_end.data;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.init.KEEnchantments;
import com.bmt.kaleidoscope_end.init.KETags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class EnchantmentTagsProvider extends IntrinsicHolderTagsProvider<Enchantment> {
    public EnchantmentTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, Registries.ENCHANTMENT, completableFuture, enchantment -> ForgeRegistries.ENCHANTMENTS.getResourceKey(enchantment).get(), KaleidoscopeEnd.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(KETags.Enchantments.KE_ENCHANTMENTS).add(
                KEEnchantments.VOID_ASSAULT.get()
        );
    }
}
