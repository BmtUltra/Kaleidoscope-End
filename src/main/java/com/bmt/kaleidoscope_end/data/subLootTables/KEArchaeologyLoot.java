package com.bmt.kaleidoscope_end.data.subLootTables;

import java.util.function.BiConsumer;

import org.jetbrains.annotations.NotNull;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.registry.KEBlocks;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.neoforged.neoforge.registries.DeferredHolder;

public class KEArchaeologyLoot implements LootTableSubProvider {
    public KEArchaeologyLoot(HolderLookup.Provider provider) {
    }

    @Override
    public void generate(@NotNull BiConsumer<ResourceKey<LootTable>, LootTable.Builder> builderBiConsumer) {
        this.addArchaeology(builderBiConsumer, KEBlocks.SUSPICIOUS_END_STONE, LootTable.lootTable().withPool(
                LootPool.lootPool().add(
                        LootItem.lootTableItem(Items.APPLE)
                )
        ));
        this.addArchaeology(builderBiConsumer, KEBlocks.SUSPICIOUS_DRAGON_EGG, LootTable.lootTable().withPool(
                LootPool.lootPool().add(
                        LootItem.lootTableItem(Items.APPLE)
                )
        ));
    }

    private void addArchaeology(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> builderBiConsumer, DeferredHolder<Block, ? extends Block> holder, LootTable.Builder builder) {
        builderBiConsumer.accept(ResourceKey.create(Registries.LOOT_TABLE, KaleidoscopeEnd.id("archaeology/%s".formatted(holder.getId().getPath()))), builder);
    }
}
