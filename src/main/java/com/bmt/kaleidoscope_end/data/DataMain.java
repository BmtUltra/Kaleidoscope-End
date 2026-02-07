package com.bmt.kaleidoscope_end.data;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = KaleidoscopeEnd.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataMain {
    @SubscribeEvent
    public static void generate(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        DatapackBuiltinEntriesProvider datapackBuiltinEntriesProvider = generator.addProvider(event.includeServer(),
                new DatapackBuiltinEntriesProvider(
                        generator.getPackOutput(),
                        event.getLookupProvider(),
                        new RegistrySetBuilder().
                                add(Registries.CONFIGURED_FEATURE, ModFeatures::bootstrap).
                                add(Registries.PLACED_FEATURE, ModPlacements::bootstrap).
                                add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifier::bootstrap)

                        ,
                        Set.of(KaleidoscopeEnd.MODID)
                ));

        CompletableFuture<HolderLookup.Provider> registryProvider = datapackBuiltinEntriesProvider.getRegistryProvider();
        generator.addProvider(event.includeServer(), new ModAdvancementProvider(generator.getPackOutput(), registryProvider, event.getExistingFileHelper()));

        BlockTagsProvider blockTagsProvider = generator.addProvider(event.includeServer(), new ModBlockTagsProvider(generator.getPackOutput(), registryProvider, event.getExistingFileHelper()));

        generator.addProvider(event.includeServer(), new ModItemTagProvider(generator.getPackOutput(), registryProvider, blockTagsProvider.contentsGetter(), event.getExistingFileHelper()));


        generator.addProvider(event.includeServer(), new ModBlockModelProvider(generator.getPackOutput(), event.getExistingFileHelper()));

        generator.addProvider(event.includeServer(), new ModBlockStateProvider(generator.getPackOutput(), event.getExistingFileHelper()));

        generator.addProvider(event.includeServer(), new ModLootTableProvider(generator.getPackOutput(),registryProvider));

        generator.addProvider(event.includeServer(), new EnchantmentTagsProvider(generator.getPackOutput(), registryProvider, event.getExistingFileHelper()));
    }


}
