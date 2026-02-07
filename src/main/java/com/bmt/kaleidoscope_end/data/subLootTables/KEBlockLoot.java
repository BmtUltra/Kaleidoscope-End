package com.bmt.kaleidoscope_end.data.subLootTables;

import java.util.HashSet;
import java.util.Set;

import com.bmt.kaleidoscope_end.registry.KEItem;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.registry.KEBlocks;
import com.github.ysbbbbbb.kaleidoscopecookery.block.food.FoodBiteBlock;
import com.github.ysbbbbbb.kaleidoscopecookery.init.registry.FoodBiteRegistry;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CaveVines;
import net.minecraft.world.level.block.PotatoBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.neoforge.registries.DeferredHolder;

public class KEBlockLoot extends BlockLootSubProvider {
    private final Set<Block> getKnownBlocks = new HashSet<>();

    public KEBlockLoot(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        this.add(KEBlocks.SUSPICIOUS_END_STONE.get(), noDrop());

        dropSelf(KEBlocks.END_STOVE.get());
        dropOther(KEBlocks.SUSPICIOUS_DRAGON_EGG.get(), Blocks.DRAGON_EGG);

        FoodBiteRegistry.FOOD_DATA_MAP.forEach((resourceLocation, foodData) -> {
            if (resourceLocation.getNamespace().equals(KaleidoscopeEnd.MOD_ID)) {
                dropFoodBite(resourceLocation, foodData);
            }
        });

        simpleCropBlockLoot(KEBlocks.ENDER_MINT.get(), 7, KEItem.ENDER_MINT.get(), KEItem.ENDER_MINT.get(), 1);

        vines(KEBlocks.DREAM_BERRY_HEAD.get(), Items.AIR, KEItem.DREAM_BERRY_ITEM.get());
        vines(KEBlocks.DREAM_BERRY_PLANT.get(), Items.AIR, KEItem.DREAM_BERRY_ITEM.get());
    }

    private void vines(Block block, Item normal, Item berries) {
        this.add(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(berries)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CaveVines.BERRIES, true))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(normal)))
        );
    }

    private void simpleCropBlockLoot(Block cropBlock, int canHarvestAge, Item seed, Item crop, int cropCount) {
        LootItemCondition.Builder ageCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(cropBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PotatoBlock.AGE, canHarvestAge));
        this.add(cropBlock, this.applyExplosionDecay(cropBlock, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(seed)))
                .withPool(LootPool.lootPool().when(ageCondition).add(LootItem.lootTableItem(crop).apply(ApplyBonusCount.addBonusBinomialDistributionCount(this.registries.lookupOrThrow(net.minecraft.core.registries.Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE), 0.5714286F, cropCount))))));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        Set<Block> blocks = new HashSet<>();
        blocks.addAll(KEBlocks.getEntries().stream().map(DeferredHolder::get).toList());
        blocks.addAll(getKnownBlocks);
        return blocks;
    }

    private void dropFoodBite(ResourceLocation id, FoodBiteRegistry.FoodData data) {
        Block block = BuiltInRegistries.BLOCK.get(id);
        Item food = BuiltInRegistries.ITEM.get(id);
        if (block instanceof FoodBiteBlock foodBiteBlock) {
            ConstantValue exactly = ConstantValue.exactly(1.0F);
            StatePropertiesPredicate.Builder notBite = StatePropertiesPredicate.Builder.properties().hasProperty(foodBiteBlock.getBites(), 0);
            LootItemCondition.Builder builder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(foodBiteBlock).setProperties(notBite);
            LootTable.Builder lootTable = LootTable.lootTable();

            for (int i = 0; i < data.getLootItems().size(); ++i) {
                ItemLike itemLike = data.getLootItems().get(i);
                LootPool.Builder rolls = LootPool.lootPool().setRolls(exactly).when(ExplosionCondition.survivesExplosion());
                if (i == 0) {
                    rolls.add(LootItem.lootTableItem(food).when(builder).otherwise(LootItem.lootTableItem(itemLike)));
                } else {
                    rolls.add(EmptyLootItem.emptyItem().when(builder).otherwise(LootItem.lootTableItem(itemLike)));
                }

                lootTable.withPool(rolls);
            }

            this.add(block, lootTable);
            getKnownBlocks.add(block);
        }
    }
}
