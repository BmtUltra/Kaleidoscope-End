package com.bmt.kaleidoscope_end.datagen;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifier {
    public static final ResourceKey<BiomeModifier> SUSPICIOUS_END_STONE_SMALL = ResourceKey.create(
            NeoForgeRegistries.Keys.BIOME_MODIFIERS,
            KaleidoscopeEnd.id("suspicious_end_stone_small")
    );
    public static final ResourceKey<BiomeModifier> SUSPICIOUS_END_STONE_LARGE = ResourceKey.create(
            NeoForgeRegistries.Keys.BIOME_MODIFIERS,
            KaleidoscopeEnd.id("suspicious_end_stone_large")
    );

    public static final ResourceKey<BiomeModifier> SUSPICIOUS_END_STONE_BURIED = ResourceKey.create(
            NeoForgeRegistries.Keys.BIOME_MODIFIERS,
            KaleidoscopeEnd.id("suspicious_end_stone_buried")
    );

    public static final ResourceKey<BiomeModifier> ENDER_MINT = ResourceKey.create(
            NeoForgeRegistries.Keys.BIOME_MODIFIERS,
            KaleidoscopeEnd.id("ender_mint")
    );

    public static final ResourceKey<BiomeModifier> DREAM_BERRY = ResourceKey.create(
            NeoForgeRegistries.Keys.BIOME_MODIFIERS,
            KaleidoscopeEnd.id("dream_berry")
    );

    public static void bootstrap(BootstrapContext<BiomeModifier> bootstrap) {
        HolderGetter<Biome> biomes = bootstrap.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatures = bootstrap.lookup(Registries.PLACED_FEATURE);

        bootstrap.register(SUSPICIOUS_END_STONE_SMALL,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_END),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacements.SUSPICIOUS_END_STONE_SMALL)),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );
        bootstrap.register(SUSPICIOUS_END_STONE_LARGE,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_END),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacements.SUSPICIOUS_END_STONE_LARGE)),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );
        bootstrap.register(SUSPICIOUS_END_STONE_BURIED,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_END),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacements.SUSPICIOUS_END_STONE_BURIED)),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );
        bootstrap.register(ENDER_MINT,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_END),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacements.ENDER_MINT)),
                        GenerationStep.Decoration.VEGETAL_DECORATION
                )
        );

        bootstrap.register(DREAM_BERRY,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_END),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacements.DREAM_BERRY)),
                        GenerationStep.Decoration.UNDERGROUND_DECORATION
                )
        );
    }
}
