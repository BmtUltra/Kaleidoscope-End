package com.bmt.kaleidoscope_end.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.jetbrains.annotations.NotNull;

public class VoidWalkerEnchantment extends Enchantment {
    private static final int MAX_LEVEL = 1;

    public VoidWalkerEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot... slots) {
        super(rarity, category, slots);
    }

    @Override
    public int getMinCost(int level) {
        return 15;
    }

    @Override
    public int getMaxCost(int level) {
        return 65;
    }

    @Override
    public int getMaxLevel() {
        return MAX_LEVEL;
    }

    @Override
    public boolean canEnchant(@NotNull ItemStack stack) {
        return stack.canApplyAtEnchantingTable(this)
                && stack.getItem() instanceof ArmorItem
                && ((ArmorItem) stack.getItem()).getEquipmentSlot() == EquipmentSlot.FEET;
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