package com.bmt.kaleidoscope_end.data;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;

public class ModBiomeModifier {

    public static void bootstrap(BootstapContext<BiomeModifier> bootstrap) {
        HolderGetter<Biome> biomes = bootstrap.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatures = bootstrap.lookup(Registries.PLACED_FEATURE);

    }
}
