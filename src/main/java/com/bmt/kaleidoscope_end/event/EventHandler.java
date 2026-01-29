package com.bmt.kaleidoscope_end.event;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.registry.KEBlocks;
import com.bmt.kaleidoscope_end.registry.KEEffects;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.event.entity.living.EnderManAngerEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;


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

        @SubscribeEvent
        public static void RightClickBlock(PlayerInteractEvent.RightClickBlock event) {
            @NotNull InteractionHand hand = event.getHand();
            Player player = event.getEntity();
            if (player.getItemInHand(hand).is(Items.NETHER_STAR)) {
                if (event.getLevel().getBlockState(event.getPos()).getBlock() == Blocks.END_STONE) {
                    event.getLevel().setBlock(event.getPos(), KEBlocks.SUSPICIOUS_END_STONE.get().defaultBlockState(), 3);
                    event.getLevel().getBlockEntity(event.getPos(), BlockEntityType.BRUSHABLE_BLOCK).ifPresent(brushableBlockEntity -> {
                        brushableBlockEntity.setLootTable(KaleidoscopeEnd.id("archaeology/suspicious_end_stone"), event.getLevel().getRandom().nextLong());
                    });
                    event.getEntity().getItemInHand(hand).shrink(1);
                } else if (event.getLevel().getBlockState(event.getPos()).getBlock() == Blocks.DRAGON_EGG) {
                    event.getLevel().setBlock(event.getPos(), KEBlocks.SUSPICIOUS_DRAGON_EGG.get().defaultBlockState(), 3);
                    event.getEntity().getItemInHand(hand).shrink(1);
                }
            }
            if ((player.getMainHandItem().is(Items.BRUSH) || player.getOffhandItem().is(Items.BRUSH))||
                    (player.getMainHandItem().is(Items.NETHER_STAR) || player.getOffhandItem().is(Items.NETHER_STAR))) {
                if (event.getLevel().getBlockState(event.getPos()).is(KEBlocks.SUSPICIOUS_DRAGON_EGG.get()) || event.getLevel().getBlockState(event.getPos()).is(Blocks.DRAGON_EGG)) {
                    event.setUseBlock(Event.Result.DENY);
                }
            }
        }
    }
}
