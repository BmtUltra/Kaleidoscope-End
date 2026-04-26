package com.bmt.kaleidoscope_end.datagen;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.init.KEItem;
import com.bmt.kaleidoscope_end.init.KETags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture1, CompletableFuture<TagLookup<Block>> completableFuture2, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture1, completableFuture2, KaleidoscopeEnd.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(Tags.Items.ENCHANTING_FUELS).add(
                KEItem.VOID_CONCH.get()
        );

        tag(KETags.Items.MOD_ITEMS)
                .add(KEItem.ENDER_MINT.get())
                .add(KEItem.ENDER_MINT_CANDY_ITEM.get())
                .add(KEItem.CHORUS_PETAL.get())
                .add(KEItem.CHORUS_SEED.get())
                .add(KEItem.CHORUS_SEED_COOKIE_ITEM.get())
                .add(KEItem.CHORUS_PASTA_ITEM.get())
                .add(KEItem.CHORUS_FLOWER_CAKE_ITEM.get())
                .add(KEItem.CHORUS_FLOWER_TEA_ITEM.get())
                .add(KEItem.DREAM_BERRY_ITEM.get())
                .add(KEItem.DRAGON_DUST.get())
                .add(KEItem.DRAGON_TOOTH.get())
                .add(KEItem.DRAGON_TOOTH_KNIFE.get())
                .add(KEItem.DRAGON_EGG_SHELL.get())
                .add(KEItem.DRAGON_EGG_LIQUID.get())
                .add(KEItem.VOID_CONCH.get())
                .add(KEItem.END_CATERPILLAR_ITEM.get())
                .add(KEItem.RAW_ENDER_DRAGON_MEAT_ITEM.get())
                .add(KEItem.COOKED_ENDER_DRAGON_MEAT_ITEM.get())
                .add(KEItem.RAW_ENDERMITE_MEAT_ITEM.get())
                .add(KEItem.ROASTED_ENDERMITE_MEAT_ITEM.get())
                .add(KEItem.SHULKER_SHELL_MEAT_ITEM.get())
                .add(KEItem.OPTIC_NERVE_ITEM.get())
                .add(KEItem.DRAGON_BREATH_BUCKET_ITEM.get())
                .add(KEItem.ENDER_DRAGON_SMITHING_TEMPLATE.get());
    }
}
