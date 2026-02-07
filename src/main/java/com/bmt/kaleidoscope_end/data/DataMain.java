package com.bmt.kaleidoscope_end.data;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = KaleidoscopeEnd.MOD_ID)
public class DataMain {
    @SubscribeEvent
    public static void generate(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        
        DatapackBuiltinEntriesProvider datapackProvider = generator.addProvider(
            event.includeServer(),
            new DatapackBuiltinEntriesProvider(
                output,
                lookupProvider,
                new RegistrySetBuilder()
                    .add(Registries.CONFIGURED_FEATURE, ModFeatures::bootstrap)
                    .add(Registries.PLACED_FEATURE, ModPlacements::bootstrap)
                    .add(Registries.ENCHANTMENT, ModEnchantmentProvider::bootstrap)
                    .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifier::bootstrap),
                Set.of(KaleidoscopeEnd.MOD_ID)
            )
        );

        CompletableFuture<HolderLookup.Provider> registryProvider = datapackProvider.getRegistryProvider();
        
        // 进度
        generator.addProvider(event.includeServer(), 
            new ModAdvancementProvider(output, registryProvider, existingFileHelper));

        // 方块标签
        var blockTagsProvider = new ModBlockTagsProvider(output, registryProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);

        // 物品标签
        generator.addProvider(event.includeServer(), 
            new ModItemTagProvider(output, registryProvider, blockTagsProvider.contentsGetter(), existingFileHelper));

        // 附魔标签
        generator.addProvider(event.includeServer(), 
            new ModEnchantmentTagsProvider(output, registryProvider, existingFileHelper));

        // 方块模型
        generator.addProvider(event.includeClient(), 
            new ModBlockModelProvider(output, existingFileHelper));

        // 方块状态
        generator.addProvider(event.includeClient(), 
            new ModBlockStateProvider(output, existingFileHelper));

        // 战利品表
        generator.addProvider(event.includeServer(), 
            new ModLootTableProvider(output, registryProvider));
    }
}
