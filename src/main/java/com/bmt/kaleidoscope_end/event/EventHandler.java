package com.bmt.kaleidoscope_end.event;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.common.KEEndermiteInfo;
import com.bmt.kaleidoscope_end.api.IEndermiteExtension;
import com.bmt.kaleidoscope_end.config.MainConfig;
import com.bmt.kaleidoscope_end.init.KEBlocks;
import com.bmt.kaleidoscope_end.init.KEEffects;
import com.bmt.kaleidoscope_end.init.KEEnchantments;
import com.bmt.kaleidoscope_end.init.KEItem;
import net.minecraft.core.NonNullList;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EventHandler {
    @Mod.EventBusSubscriber(modid = KaleidoscopeEnd.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class GAME {
        private static final Set<ResourceLocation> END_MOBS_CACHE = new HashSet<>();
        private static final ThreadLocal<Boolean> IS_PROCESSING_VOID_ECHO = ThreadLocal.withInitial(() -> false);
        private static final ResourceLocation THE_END_DIMENSION = ResourceLocation.fromNamespaceAndPath("minecraft", "the_end");

        @SubscribeEvent
        public static void EnderManAngerEvent(EnderManAngerEvent event) {
            if (event.getPlayer().hasEffect(KEEffects.MINT.get())) {
                event.setCanceled(true);
            }
        }

        private static boolean isInEndDimension(Level level) {
            ResourceKey<Level> dimension = level.dimension();
            return dimension.location().equals(THE_END_DIMENSION);
        }

        private static boolean isEndMob(LivingEntity entity) {
            ResourceLocation entityId = BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType());
            if (END_MOBS_CACHE.isEmpty()) {
                loadEndMobsFromConfig();
            }
            return END_MOBS_CACHE.contains(entityId);
        }

        private static void loadEndMobsFromConfig() {
            END_MOBS_CACHE.clear();
            for (String mobId : MainConfig.DRAGON_TOOTH_KNIFE_EXTRA_END_MOBS.get()) {
                try {
                    END_MOBS_CACHE.add(ResourceLocation.parse(mobId));
                } catch (Exception ignored) {
                }
            }
        }

        public static void clearEndMobsCache() {
            END_MOBS_CACHE.clear();
        }

        @SubscribeEvent
        public static void LivingHurtEvent(LivingHurtEvent event) {
            if (event.getEntity().hasEffect(KEEffects.DREAM.get()) && event.getSource().is(DamageTypes.FALL)) {
                event.setCanceled(true);
                return;
            }

            if (event.getEntity().hasEffect(KEEffects.MINT.get())) {
                event.setAmount(event.getAmount() * 0.2F);
            }

            if (event.getSource().getEntity() instanceof LivingEntity livingAttacker) {
                ItemStack weapon = livingAttacker.getMainHandItem();
                if (!weapon.isEmpty()) {
                    if (weapon.is(KEItem.DRAGON_TOOTH_KNIFE.get())) {
                        LivingEntity target = event.getEntity();
                        boolean isInEnd = isInEndDimension(livingAttacker.level());
                        if (isInEnd || isEndMob(target)) {
                            event.setAmount(event.getAmount() * 3.0f);
                        }
                    }

                    int voidAssaultLevel = weapon.getEnchantmentLevel(KEEnchantments.VOID_ASSAULT.get());
                    if (voidAssaultLevel > 0) {
                        if (livingAttacker.getRandom().nextFloat() < 0.15F) {
                            float damageMultiplier = 1.0F + voidAssaultLevel;
                            float originalDamage = event.getAmount();
                            event.setAmount(originalDamage * damageMultiplier);
                            livingAttacker.level().playSound(
                                    null,
                                    livingAttacker.getX(),
                                    livingAttacker.getY(),
                                    livingAttacker.getZ(),
                                    SoundEvents.ENDERMAN_TELEPORT,
                                    livingAttacker.getSoundSource(),
                                    1.0F,
                                    1.0F
                            );
                        }
                    }

                    if (event.getSource().getDirectEntity() instanceof Projectile) {
                        int voidShotLevel = weapon.getEnchantmentLevel(KEEnchantments.VOID_SHOT.get());
                        if (voidShotLevel > 0) {
                            if (livingAttacker.getRandom().nextFloat() < 0.15F) {
                                float damageMultiplier = 1.0F + voidShotLevel;
                                float originalDamage = event.getAmount();
                                event.setAmount(originalDamage * damageMultiplier);
                                livingAttacker.level().playSound(
                                        null,
                                        livingAttacker.getX(),
                                        livingAttacker.getY(),
                                        livingAttacker.getZ(),
                                        SoundEvents.ENDERMAN_TELEPORT,
                                        livingAttacker.getSoundSource(),
                                        1.0F,
                                        1.0F
                                );
                            }
                        }
                    }

                    int voidEchoLevel = weapon.getEnchantmentLevel(KEEnchantments.VOID_ECHO.get());
                    if (voidEchoLevel > 0 && livingAttacker.getRandom().nextFloat() < 0.25F
                            && !IS_PROCESSING_VOID_ECHO.get()) {
                        IS_PROCESSING_VOID_ECHO.set(true);

                        LivingEntity target = event.getEntity();
                        float originalDamage = event.getAmount();
                        float echoDamage = originalDamage * (0.40F + (voidEchoLevel - 1) * 0.15F);
                        float flatDamage = 2.0F + (voidEchoLevel - 1) * 1.0F;
                        float totalEchoDamage = echoDamage + flatDamage;

                        Level level = livingAttacker.level();
                        AABB area = target.getBoundingBox().inflate(4.0D);
                        List<LivingEntity> nearbyEntities = level.getEntitiesOfClass(
                                LivingEntity.class, area,
                                entity -> entity != livingAttacker && entity.isAlive()
                        );

                        for (LivingEntity nearby : nearbyEntities) {
                            nearby.hurt(nearby.damageSources().sonicBoom(livingAttacker), totalEchoDamage);
                        }

                        if (level instanceof ServerLevel serverLevel) {
                            serverLevel.sendParticles(
                                    ParticleTypes.SONIC_BOOM,
                                    target.getX(),
                                    target.getY() + 1.0D,
                                    target.getZ(),
                                    1,
                                    0.0D, 0.0D, 0.0D,
                                    0.0D
                            );
                        }
                        level.playSound(
                                null,
                                target.getX(),
                                target.getY(),
                                target.getZ(),
                                SoundEvents.WARDEN_SONIC_BOOM,
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F
                        );
                        IS_PROCESSING_VOID_ECHO.set(false);
                    }
                }
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