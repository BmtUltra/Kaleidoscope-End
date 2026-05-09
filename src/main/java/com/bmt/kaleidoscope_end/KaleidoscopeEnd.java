package com.bmt.kaleidoscope_end;

import com.bmt.kaleidoscope_end.config.MainConfig;
import com.bmt.kaleidoscope_end.init.*;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(KaleidoscopeEnd.MOD_ID)
public class KaleidoscopeEnd {
    public static final String MOD_ID = "kaleidoscope_end";

    public KaleidoscopeEnd(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        KEEffects.register(modEventBus);
        KEBlocks.register(modEventBus);
        KEBlockEntityType.register(modEventBus);
        KEItem.register(modEventBus);
        KECreativeTabs.register(modEventBus);
        modContainer.registerConfig(ModConfig.Type.COMMON, MainConfig.SPEC);
        KEFoodBiteRegistry.init();
        KETeacups.init();
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(KESoupBases::registerAll);
    }

    public static ResourceLocation id(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }

    public static ResourceLocation fromNamespaceAndPath(String namespace, String id) {
        return ResourceLocation.fromNamespaceAndPath(namespace, id);
    }
}