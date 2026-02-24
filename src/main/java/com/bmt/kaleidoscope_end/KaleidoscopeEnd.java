package com.bmt.kaleidoscope_end;

import com.bmt.kaleidoscope_end.config.Config;
import com.bmt.kaleidoscope_end.registry.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(KaleidoscopeEnd.MODID)
public class KaleidoscopeEnd {
    public static final String MODID = "kaleidoscope_end";

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public KaleidoscopeEnd(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        modEventBus.addListener(this::commonSetup);

        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        KEEffects.register(modEventBus);
        KEBlocks.register(modEventBus);
//        KEBlockEntityType.register(modEventBus);
        KEItem.register(modEventBus);
    //    KEPaintings.register(modEventBus);
        KECreativeTabs.register(modEventBus);
        KEEnchantments.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);

        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        KEFoodBiteRegistry.init();
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(KESoupBases::registerAll);
    }

    public static ResourceLocation id(String name) {
        return ResourceLocation.tryBuild(MODID, name);
    }

    public static ResourceLocation fromNamespaceAndPath(String namespace, String id) {
        return ResourceLocation.tryBuild(namespace, id);
    }
}