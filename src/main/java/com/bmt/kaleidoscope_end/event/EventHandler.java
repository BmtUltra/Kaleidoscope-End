package com.bmt.kaleidoscope_end.event;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.common.KEEndermiteInfo;
import com.bmt.kaleidoscope_end.api.IEndermiteExtension;
import com.bmt.kaleidoscope_end.init.KEBlocks;
import com.bmt.kaleidoscope_end.init.KEEffects;
import com.bmt.kaleidoscope_end.init.KEItem;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.util.BrainBuilder;
import net.minecraftforge.event.entity.living.EnderManAngerEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingMakeBrainEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;


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
        public static void RightClickBlock(PlayerInteractEvent.RightClickBlock event) {
            Player player = event.getEntity();
            if ((player.getMainHandItem().is(Items.BRUSH) || player.getOffhandItem().is(Items.BRUSH)) ||
                    (player.getMainHandItem().is(KEItem.DRAGON_TOOTH.get()) || player.getOffhandItem().is(KEItem.DRAGON_TOOTH.get()))) {
                if (event.getLevel().getBlockState(event.getPos()).is(KEBlocks.SUSPICIOUS_DRAGON_EGG.get()) || event.getLevel().getBlockState(event.getPos()).is(Blocks.DRAGON_EGG)) {
                    event.setUseBlock(Event.Result.DENY);
                }
            }
        }


        @SubscribeEvent
        public static void FillBucketEvent(FillBucketEvent event) {
            Player player = event.getEntity();
            Level level = player.level();
            List<AreaEffectCloud> list = level.getEntitiesOfClass(AreaEffectCloud.class, player.getBoundingBox().inflate(2.0D), (areaEffectCloud) -> areaEffectCloud != null && areaEffectCloud.isAlive() && areaEffectCloud.getOwner() instanceof EnderDragon);
            if (!list.isEmpty()) {
                AreaEffectCloud areaeffectcloud = list.get(0);
                float radius = areaeffectcloud.getRadius();
                areaeffectcloud.kill();
                level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BUCKET_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);
                level.gameEvent(player, GameEvent.FLUID_PICKUP, player.position());
                ItemStack itemStack = KEItem.DRAGON_BREATH_BUCKET_ITEM.get().getDefaultInstance();
                CompoundTag compoundTag = itemStack.getOrCreateTag();
                compoundTag.putFloat("radius", radius);

                event.setFilledBucket(itemStack);
                event.setResult(Event.Result.ALLOW);
            }
        }


        @SubscribeEvent
        public static void EntityInteract(PlayerInteractEvent.EntityInteract event) {
            Player entity = event.getEntity();
            if (event.getTarget() instanceof Endermite endermite && event.getItemStack().is(Items.AMETHYST_SHARD) && !event.getLevel().isClientSide) {
                KEEndermiteInfo info = IEndermiteExtension.getInfo(endermite);
                if (info.inLove <= 0) {
                    info.setInLove(event.getEntity());
                    if (!entity.getAbilities().instabuild) {
                        event.getItemStack().shrink(1);
                        endermite.setTarget(null);
                    }
                }
            }
        }

        @SubscribeEvent
        public static void LivingMakeBrainEvent(LivingMakeBrainEvent event) {
            if (event.getEntity() instanceof Endermite endermite) {
                BrainBuilder<Endermite> builder = event.getTypedBrainBuilder(endermite);
                builder.getMemoryTypes().add(MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES);
            }
        }
    }
}
