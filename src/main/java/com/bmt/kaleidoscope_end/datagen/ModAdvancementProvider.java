package com.bmt.kaleidoscope_end.datagen;

import com.bmt.kaleidoscope_end.datagen.subAdvancements.KEAdvances;
import com.google.gson.JsonObject;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModAdvancementProvider extends ForgeAdvancementProvider {
    private final PackOutput.PathProvider pathProvider;

    public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper) {
        super(output, registries, existingFileHelper, List.of(new KEAdvances()));
        this.pathProvider = output.createPathProvider(PackOutput.Target.DATA_PACK, "advancements");

    }

    public static BiConsumer<JsonObject, ResourceLocation> BUILD_CONDITION;

    @Override
    public @NotNull CompletableFuture<?> run(@NotNull CachedOutput cachedOutput) {
        List<CompletableFuture<?>> list = new ArrayList<>();
        BUILD_CONDITION = (jsonObject, resourceLocation) -> {
            Path path = this.pathProvider.json(resourceLocation);
            list.add(DataProvider.saveStable(cachedOutput, jsonObject, path));
        };
        return CompletableFuture.allOf(super.run(cachedOutput), CompletableFuture.allOf(list.toArray(CompletableFuture[]::new)));
    }
}
