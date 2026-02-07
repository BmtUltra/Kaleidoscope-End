package com.bmt.kaleidoscope_end.data;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.bmt.kaleidoscope_end.data.subAdvancements.KEAdvances;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModAdvancementProvider extends AdvancementProvider {
    public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper) {
        super(output, registries, existingFileHelper, List.of(new KEAdvances()));
    }
}
