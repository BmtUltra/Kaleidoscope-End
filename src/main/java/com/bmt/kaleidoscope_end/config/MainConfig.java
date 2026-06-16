package com.bmt.kaleidoscope_end.config;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.event.EventHandler;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

import java.util.Arrays;
import java.util.List;

@Mod.EventBusSubscriber(modid = KaleidoscopeEnd.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MainConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> DRAGON_TOOTH_KNIFE_EXTRA_END_MOBS;

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

    public static final ForgeConfigSpec SPEC = BUILDER.build();

    @SubscribeEvent
    static void onLoad(final ModConfigEvent.Loading event) {
        if (event.getConfig().getSpec() == SPEC) {
            EventHandler.GAME.clearEndMobsCache();
        }
    }

    @SubscribeEvent
    static void onReload(final ModConfigEvent.Reloading event) {
        if (event.getConfig().getSpec() == SPEC) {
            EventHandler.GAME.clearEndMobsCache();
        }
    }
}