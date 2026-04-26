package com.bmt.kaleidoscope_end.item;

import com.bmt.kaleidoscope_end.config.Config;
import com.bmt.kaleidoscope_end.util.tier.DragonToothTier;
import com.github.ysbbbbbb.kaleidoscopecookery.item.KitchenKnifeItem;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashSet;
import java.util.Set;

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
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        boolean result = super.hurtEnemy(stack, target, attacker);

        if (result) {
            boolean isInEndDimension = isInEndDimension(attacker.level());
            if (isInEndDimension) {
                float extraDamage = getDamage() * 3.0f;
                target.hurt(target.damageSources().mobAttack(attacker), extraDamage);
            } else {
                if (isEndMob(target)) {
                    float extraDamage = getDamage() * 3.0f;
                    target.hurt(target.damageSources().mobAttack(attacker), extraDamage);
                }
            }
        }
        return result;
    }

    @Override
    public float getDamage() {
        return DRAGON_TOOTH_TIER.getAttackDamageBonus() + 1.0f; //8+1
    }

    private boolean isInEndDimension(Level level) {

        ResourceKey<Level> dimension = level.dimension();
        return dimension.location().equals(THE_END_DIMENSION);
    }

    private boolean isEndMob(LivingEntity entity) {
        ResourceLocation entityId = ForgeRegistries.ENTITY_TYPES.getKey(entity.getType());
        if (entityId == null) {
            return false;
        }

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
            } catch (Exception ignored) {
            }
        }
    }

    public static void clearCache() {
        END_MOBS_CACHE.clear();
    }
}