package com.bmt.kaleidoscope_end.item;

import com.bmt.kaleidoscope_end.item.Tier.DragonToothTier;
import com.github.ysbbbbbb.kaleidoscopecookery.item.KitchenKnifeItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.item.ItemStack;

public class DragonToothKnifeItem extends KitchenKnifeItem {
    private static final DragonToothTier DRAGON_TOOTH_TIER = new DragonToothTier();

    public DragonToothKnifeItem() {
        super(DRAGON_TOOTH_TIER, new Properties()
                .durability(2031)
                .fireResistant()
        );
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        boolean result = super.hurtEnemy(stack, target, attacker);

        if (result && isEndMob(target)) {
            float extraDamage = getDamage() * 3.0f;
            target.hurt(target.damageSources().mobAttack(attacker), extraDamage);
        }

        return result;
    }

    @Override
    public float getDamage() {
        return DRAGON_TOOTH_TIER.getAttackDamageBonus() + 1.0f; //8+1
    }

    private boolean isEndMob(LivingEntity entity) {
        return entity instanceof EnderMan ||
                entity instanceof Endermite ||
                entity instanceof Shulker ||
                entity instanceof EnderDragon;
    }
}