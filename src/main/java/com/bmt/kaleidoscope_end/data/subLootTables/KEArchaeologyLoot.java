package com.bmt.kaleidoscope_end.data.subLootTables;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.registry.KEBlocks;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public class KEArchaeologyLoot implements LootTableSubProvider {
    @Override
    public void generate(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> builderBiConsumer) {
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

    private void addArchaeology(BiConsumer<ResourceLocation, LootTable.Builder> builderBiConsumer, RegistryObject<Block> registryObject, LootTable.Builder builder) {
        builderBiConsumer.accept(KaleidoscopeEnd.id("archaeology/%s".formatted(registryObject.getId().getPath())), builder);
    }
}
