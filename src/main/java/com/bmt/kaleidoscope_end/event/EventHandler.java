package com.bmt.kaleidoscope_end.event;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.registry.KEEffects;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraftforge.event.entity.living.EnderManAngerEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


public class EventHandler {
    @Mod.EventBusSubscriber(modid = KaleidoscopeEnd.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class GAME {
        @SubscribeEvent
        public static void EnderManAngerEvent(EnderManAngerEvent event) {
            if (event.getPlayer().hasEffect(KEEffects.MINT.get())) {
                event.setCanceled(true);
            }
        }

        @SubscribeEvent
        public static void LivingHurtEvent(LivingHurtEvent event) {
            if (event.getEntity().hasEffect(KEEffects.MINT.get())) {
                event.setAmount(event.getAmount() * 0.2F);
            }
            if (event.getEntity().hasEffect(KEEffects.DREAM.get()) && event.getSource().is(DamageTypes.FALL)) {
                event.setAmount(0);
                event.setCanceled(true);
            }
        }

        @SubscribeEvent
        public static void LivingDeathEvent(LivingDeathEvent event) {
            if (event.getEntity().hasEffect(KEEffects.VOID_EROSION.get())) {
                event.setCanceled(true);
                event.getEntity().setHealth(1);
            }
        }

    }
}
