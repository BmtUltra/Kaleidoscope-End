package com.bmt.kaleidoscope_end.config;

import java.util.Arrays;
import java.util.List;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.event.EventHandler;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@SuppressWarnings("deprecation")
@EventBusSubscriber(modid = KaleidoscopeEnd.MOD_ID)
public class MainConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.ConfigValue<List<? extends String>> DRAGON_TOOTH_KNIFE_EXTRA_END_MOBS;

    static {
        BUILDER.push("dragon_tooth_knife");

        DRAGON_TOOTH_KNIFE_EXTRA_END_MOBS = BUILDER
                .comment("List of end mob entity IDs that take extra damage from Dragon Tooth Knife",
                        "Format: modid:entity_id (e.g., minecraft:enderman, minecraft:endermite)",
                        "Default includes: enderman, endermite, shulker, ender_dragon")
                .defineList("extraEndMobs",
                        Arrays.asList(
                                "minecraft:enderman",
                                "minecraft:endermite",
                                "minecraft:shulker",
                                "minecraft:ender_dragon"
                        ),
                        obj -> obj instanceof String);

        BUILDER.pop();
    }
    public static final ModConfigSpec SPEC = BUILDER.build();

    @SubscribeEvent
    static void onLoad(final ModConfigEvent.Loading event) {
        if (event.getConfig().getSpec() == SPEC) {
            EventHandler.clearEndMobsCache();
        }
    }

    @SubscribeEvent
    static void onReload(final ModConfigEvent.Reloading event) {
        if (event.getConfig().getSpec() == SPEC) {
            EventHandler.clearEndMobsCache();
        }
    }
}