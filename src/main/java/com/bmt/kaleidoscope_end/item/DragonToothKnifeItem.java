package com.bmt.kaleidoscope_end.item;

import java.util.HashSet;
import java.util.Set;

import com.bmt.kaleidoscope_end.config.MainConfig;
import org.jetbrains.annotations.NotNull;

import com.bmt.kaleidoscope_end.util.tier.DragonToothTier;
import com.github.ysbbbbbb.kaleidoscopecookery.item.KitchenKnifeItem;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;

public class DragonToothKnifeItem extends KitchenKnifeItem {
    private static final DragonToothTier DRAGON_TOOTH_TIER = new DragonToothTier();
    private static final Set<ResourceLocation> END_MOBS_CACHE = new HashSet<>();
    private static final ResourceLocation THE_END_DIMENSION = ResourceLocation.fromNamespaceAndPath("minecraft", "the_end");

    public DragonToothKnifeItem() {
        super(DRAGON_TOOTH_TIER, new Properties()
                .durability(3542)
                .fireResistant()
        );
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        boolean result = super.hurtEnemy(stack, target, attacker);

        if (result) {
            boolean isInEndDimension = isInEndDimension(attacker.level());
            if (isInEndDimension) {
                float extraDamage = getAttackDamage() * 3.0f;
                target.hurt(target.damageSources().mobAttack(attacker), extraDamage);
            } else {
                if (isEndMob(target)) {
                    float extraDamage = getAttackDamage() * 3.0f;
                    target.hurt(target.damageSources().mobAttack(attacker), extraDamage);
                }
            }
        }
        return result;
    }

    @SuppressWarnings("deprecation")
    private float getAttackDamage() {
        ItemAttributeModifiers modifiers = this.getDefaultAttributeModifiers();
        for (ItemAttributeModifiers.Entry entry : modifiers.modifiers()) {
            if (entry.attribute() == Attributes.ATTACK_DAMAGE) {
                return (float) entry.modifier().amount();
            }
        }
        return DRAGON_TOOTH_TIER.getAttackDamageBonus() + 1.0f;
    }

    private boolean isInEndDimension(Level level) {
        ResourceKey<Level> dimension = level.dimension();
        return dimension.location().equals(THE_END_DIMENSION);
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
        for (String mobId : MainConfig.DRAGON_TOOTH_KNIFE_EXTRA_END_MOBS.get()) {
            try {
                ResourceLocation location = ResourceLocation.parse(mobId);
                END_MOBS_CACHE.add(location);
            } catch (Exception ignored) {
            }
        }
    }
    public static void clearCache() {
        END_MOBS_CACHE.clear();
    }
}