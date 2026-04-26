package com.bmt.kaleidoscope_end.event;

import java.util.List;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.api.IEndermiteExtension;
import com.bmt.kaleidoscope_end.common.KEEndermiteInfo;
import com.bmt.kaleidoscope_end.init.KEBlocks;
import com.bmt.kaleidoscope_end.init.KEEffects;
import com.bmt.kaleidoscope_end.init.KEItem;

import net.minecraft.core.Holder;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;
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
        Player player = event.getEntity();
        if ((player.getMainHandItem().is(KEItem.DRAGON_TOOTH.get()) || player.getOffhandItem().is(KEItem.DRAGON_TOOTH.get()))) {
            if (event.getLevel().getBlockState(event.getPos()).is(KEBlocks.SUSPICIOUS_DRAGON_EGG.get()) ||
                    event.getLevel().getBlockState(event.getPos()).is(Blocks.DRAGON_EGG)) {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        Level level = player.level();

        if (!event.getItemStack().is(Items.BUCKET)) {
            return;
        }
        
        List<AreaEffectCloud> list = level.getEntitiesOfClass(AreaEffectCloud.class, player.getBoundingBox().inflate(2.0D), (areaEffectCloud) -> areaEffectCloud != null && areaEffectCloud.isAlive() && areaEffectCloud.getOwner() instanceof EnderDragon);
        if (!list.isEmpty()) {
            AreaEffectCloud areaeffectcloud = list.getFirst();
            float radius = areaeffectcloud.getRadius();
            areaeffectcloud.kill();
            level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BUCKET_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);
            level.gameEvent(player, GameEvent.FLUID_PICKUP, player.position());
            
            ItemStack itemStack = KEItem.DRAGON_BREATH_BUCKET_ITEM.get().getDefaultInstance();
            CompoundTag tag = new CompoundTag();
            tag.putFloat("radius", radius);
            itemStack.set(net.minecraft.core.component.DataComponents.CUSTOM_DATA, net.minecraft.world.item.component.CustomData.of(tag));

            ItemStack bucketInHand = event.getItemStack();
            bucketInHand.shrink(1);
            
            if (bucketInHand.isEmpty()) {
                player.setItemInHand(event.getHand(), itemStack);
            } else {
                if (!player.getInventory().add(itemStack)) {
                    player.drop(itemStack, false);
                }
            }
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getEntity();
        if (event.getTarget() instanceof Endermite endermite &&
                event.getItemStack().is(Items.AMETHYST_SHARD) &&
                !event.getLevel().isClientSide) {

            KEEndermiteInfo info = IEndermiteExtension.getInfo(endermite);
            if (info.inLove <= 0) {
                info.setInLove(event.getEntity());
                if (!player.getAbilities().instabuild) {
                    event.getItemStack().shrink(1);
                    endermite.setTarget(null);
                }
            }
        }
    }
}
