package com.bmt.kaleidoscope_end.data;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.registry.KEBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> SUSPICIOUS_END_STONE_SMALL = createKey("suspicious_end_stone_small");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SUSPICIOUS_END_STONE_LARGE = createKey("suspicious_end_stone_large");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SUSPICIOUS_END_STONE_BURIED = createKey("suspicious_end_stone_buried");

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, KaleidoscopeEnd.id(name));
    }

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest ruletest1 = new BlockMatchTest(Blocks.END_STONE);
        List<OreConfiguration.TargetBlockState> list2 = List.of(OreConfiguration.target(ruletest1, KEBlocks.SUSPICIOUS_END_STONE.get().defaultBlockState()));

        FeatureUtils.register(context, SUSPICIOUS_END_STONE_SMALL, Feature.ORE, new OreConfiguration(list2, 4, 0.5F));
        FeatureUtils.register(context, SUSPICIOUS_END_STONE_LARGE, Feature.ORE, new OreConfiguration(list2, 12, 0.7F));
        FeatureUtils.register(context, SUSPICIOUS_END_STONE_BURIED, Feature.ORE, new OreConfiguration(list2, 8, 1.0F));
    }
}
