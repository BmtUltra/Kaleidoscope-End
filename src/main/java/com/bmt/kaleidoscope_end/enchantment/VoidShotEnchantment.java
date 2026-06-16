package com.bmt.kaleidoscope_end.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.jetbrains.annotations.NotNull;

public class VoidShotEnchantment extends Enchantment {
    private static final int MAX_LEVEL = 4;

    public VoidShotEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot... slots) {
        super(rarity, category, slots);
    }

    @Override
    public int getMinCost(int level) {
        return 15 + (level - 1) * 9;
    }

    @Override
    public int getMaxCost(int level) {
        return 65 + (level - 1) * 9;
    }

    @Override
    public int getMaxLevel() {
        return MAX_LEVEL;
    }

    @Override
    public boolean canEnchant(@NotNull ItemStack stack) {
        return stack.canApplyAtEnchantingTable(this)
                && (stack.getItem() instanceof BowItem
                || stack.getItem() instanceof CrossbowItem);
    }

    @Override
    public boolean isDiscoverable() {
        return super.isDiscoverable();
    }

    @Override
    public boolean isTradeable() {
        return super.isTradeable();
    }

    @Override
    public boolean isTreasureOnly() {
        return super.isTreasureOnly();
    }
}