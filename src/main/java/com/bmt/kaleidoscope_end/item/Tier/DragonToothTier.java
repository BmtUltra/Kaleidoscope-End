package com.bmt.kaleidoscope_end.item.Tier;

import com.bmt.kaleidoscope_end.init.KEItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class DragonToothTier implements Tier {
    private static final ForgeTier BASE_TIER = new ForgeTier(
            5,
            3542,
            8.0F,
            0,
            15,
            null,
            () -> Ingredient.of(KEItem.DRAGON_TOOTH.get())
    );

    @Override
    public int getUses() {
        return BASE_TIER.getUses();
    }

    @Override
    public float getSpeed() {
        return BASE_TIER.getSpeed();
    }

    @Override
    public float getAttackDamageBonus() {
        return 8.0F;
    }

    @Override
    public int getLevel() {
        return BASE_TIER.getLevel();
    }

    @Override
    public int getEnchantmentValue() {
        return BASE_TIER.getEnchantmentValue();
    }

    @Override
    public Ingredient getRepairIngredient() {
        return BASE_TIER.getRepairIngredient();
    }
}