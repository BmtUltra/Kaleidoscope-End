package com.bmt.kaleidoscope_end.data;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class ModFeatures {

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, KaleidoscopeEnd.id(name));
    }

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {


    }
}
