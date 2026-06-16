package com.bmt.kaleidoscope_end.enchantment;

import com.bmt.kaleidoscope_end.init.KEEnchantments;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.jetbrains.annotations.NotNull;

public class VoidAssaultEnchantment extends Enchantment {
    private static final int MAX_LEVEL = 3;

    public VoidAssaultEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot... slots) {
        super(rarity, category, slots);
    }

    @Override
    public int getMinCost(int level) {
        return 15 + (level - 1) * 9;
    }

    @Override
    public int getMaxCost(int level) {
        return super.getMinCost(level) + 50;
    }

    @Override
    public int getMaxLevel() {
        return MAX_LEVEL;
    }

    @Override
    public boolean checkCompatibility(@NotNull Enchantment other) {
        return super.checkCompatibility(other)
                && other != KEEnchantments.VOID_ECHO.get();
    }

    @Override
    public boolean canEnchant(@NotNull ItemStack stack) {
        return stack.canApplyAtEnchantingTable(this)
                && (stack.getItem() instanceof SwordItem
                || stack.getItem() instanceof AxeItem);
    }

    @Override
    public boolean isDiscoverable() {
        return false;
    }

    @Override
    public boolean isTradeable() {
        return false;
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }
}