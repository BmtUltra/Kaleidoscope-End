package com.bmt.kaleidoscope_end.event;

import org.jetbrains.annotations.NotNull;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.registry.KEBlocks;
import com.bmt.kaleidoscope_end.registry.KEEffects;
import com.bmt.kaleidoscope_end.registry.KEItem;

import net.minecraft.core.Holder;
import net.minecraft.core.NonNullList;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.EnderManAngerEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber(modid = KaleidoscopeEnd.MOD_ID)
public class EventHandler {
    
    @SubscribeEvent
    public static void onEnderManAnger(EnderManAngerEvent event) {
        if (event.getPlayer().hasEffect(Holder.direct(KEEffects.MINT.get()))) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent.Pre event) {
        if (event.getEntity().hasEffect(Holder.direct(KEEffects.MINT.get()))) {
            event.setNewDamage(event.getNewDamage() * 0.2F);
        }
        if (event.getEntity().hasEffect(Holder.direct(KEEffects.DREAM.get())) && event.getSource().is(DamageTypes.FALL)) {
            event.setNewDamage(0);
        }
    }

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (event.getEntity().hasEffect(Holder.direct(KEEffects.VOID_EROSION.get()))) {
            event.setCanceled(true);
            event.getEntity().setHealth(1);
        }

        if (event.getEntity().getType() == EntityType.ENDER_DRAGON) {
            if (event.getSource().getEntity() instanceof Player player) {
                NonNullList<ItemStack> items = player.getInventory().items;
                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).is(Items.DRAGON_EGG)) {
                        items.set(i, new ItemStack(KEItem.SUSPICIOUS_DRAGON_EGG_ITEM.get(), items.get(i).getCount()));
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        @NotNull InteractionHand hand = event.getHand();
        Player player = event.getEntity();
        if (player.getItemInHand(hand).is(KEItem.DRAGON_TOOTH.get())) {
            if (event.getLevel().getBlockState(event.getPos()).getBlock() == Blocks.END_STONE) {
                event.getLevel().setBlock(event.getPos(), KEBlocks.SUSPICIOUS_END_STONE.get().defaultBlockState(), 3);
                event.getEntity().getItemInHand(hand).shrink(1);
            } else if (event.getLevel().getBlockState(event.getPos()).getBlock() == Blocks.DRAGON_EGG) {
                event.getLevel().setBlock(event.getPos(), KEBlocks.SUSPICIOUS_DRAGON_EGG.get().defaultBlockState(), 3);
                event.getEntity().getItemInHand(hand).shrink(1);
            }
        }
        if ((player.getMainHandItem().is(Items.BRUSH) || player.getOffhandItem().is(Items.BRUSH)) ||
                (player.getMainHandItem().is(KEItem.DRAGON_TOOTH.get()) || player.getOffhandItem().is(KEItem.DRAGON_TOOTH.get()))) {
            if (event.getLevel().getBlockState(event.getPos()).is(KEBlocks.SUSPICIOUS_DRAGON_EGG.get()) || event.getLevel().getBlockState(event.getPos()).is(Blocks.DRAGON_EGG)) {
                event.setCanceled(true);
            }
        }
    }
}
