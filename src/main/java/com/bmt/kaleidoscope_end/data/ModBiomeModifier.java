package com.bmt.kaleidoscope_end.data;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifier {
    public static final ResourceKey<BiomeModifier> SUSPICIOUS_END_STONE_SMALL = ResourceKey.create(
            ForgeRegistries.Keys.BIOME_MODIFIERS,
            KaleidoscopeEnd.id("suspicious_end_stone_small")
    );
    public static final ResourceKey<BiomeModifier> SUSPICIOUS_END_STONE_LARGE = ResourceKey.create(
            ForgeRegistries.Keys.BIOME_MODIFIERS,
            KaleidoscopeEnd.id("suspicious_end_stone_large")
    );

    public static final ResourceKey<BiomeModifier> SUSPICIOUS_END_STONE_BURIED = ResourceKey.create(
            ForgeRegistries.Keys.BIOME_MODIFIERS,
            KaleidoscopeEnd.id("suspicious_end_stone_buried")
    );

    public static void bootstrap(BootstapContext<BiomeModifier> bootstrap) {
        HolderGetter<Biome> biomes = bootstrap.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatures = bootstrap.lookup(Registries.PLACED_FEATURE);

        bootstrap.register(SUSPICIOUS_END_STONE_SMALL,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_END),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacements.SUSPICIOUS_END_STONE_SMALL)),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );
        bootstrap.register(SUSPICIOUS_END_STONE_LARGE,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_END),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacements.SUSPICIOUS_END_STONE_LARGE)),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );
        bootstrap.register(SUSPICIOUS_END_STONE_BURIED,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_END),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacements.SUSPICIOUS_END_STONE_BURIED)),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );
    }
}
