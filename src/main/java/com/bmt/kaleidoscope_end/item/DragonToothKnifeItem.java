package com.bmt.kaleidoscope_end.item;

import java.util.HashSet;
import java.util.Set;

import org.jetbrains.annotations.NotNull;

import com.bmt.kaleidoscope_end.config.Config;
import com.bmt.kaleidoscope_end.item.Tier.DragonToothTier;
import com.github.ysbbbbbb.kaleidoscopecookery.item.KitchenKnifeItem;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class DragonToothKnifeItem extends KitchenKnifeItem {
    private static final DragonToothTier DRAGON_TOOTH_TIER = new DragonToothTier();
    private static final Set<ResourceLocation> END_MOBS_CACHE = new HashSet<>();

    public DragonToothKnifeItem() {
        super(DRAGON_TOOTH_TIER, new Properties()
                .durability(2031)
                .fireResistant()
        );
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        boolean result = super.hurtEnemy(stack, target, attacker);

        if (result && isEndMob(target)) {
            float extraDamage = getDamage() * 3.0f;
            target.hurt(target.damageSources().mobAttack(attacker), extraDamage);
        }

        return result;
    }

    public float getDamage() {
        return DRAGON_TOOTH_TIER.getAttackDamageBonus() + 1.0f; // 8+1
    }

    private boolean isEndMob(LivingEntity entity) {
        ResourceLocation entityId = BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType());

        if (END_MOBS_CACHE.isEmpty()) {
            loadEndMobsFromConfig();
        }

        return END_MOBS_CACHE.contains(entityId);
    }

    private static void loadEndMobsFromConfig() {
        END_MOBS_CACHE.clear();
        for (String mobId : Config.DRAGON_TOOTH_KNIFE_EXTRA_END_MOBS.get()) {
            try {
                ResourceLocation location = ResourceLocation.parse(mobId);
                END_MOBS_CACHE.add(location);
            } catch (Exception e) {
            }
        }
    }

    public static void clearCache() {
        END_MOBS_CACHE.clear();
    }
}