package com.bmt.kaleidoscope_end.enchantment;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.init.KEEnchantments;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

@Mod.EventBusSubscriber(modid = KaleidoscopeEnd.MODID)
public class VoidAssaultEnchantment extends Enchantment {
    private static final Random RANDOM = new Random();

    private static final boolean ENABLED = true;
    private static final int MAX_LEVEL = 3;
    private static final double BASE_CHANCE = 0.15;
    private static final double BASE_DAMAGE_MULTIPLIER = 1.0;
    private static final double DAMAGE_MULTIPLIER_PER_LEVEL = 1.0;

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
                && other != Enchantments.SHARPNESS
                && other != Enchantments.SMITE
                && other != Enchantments.BANE_OF_ARTHROPODS;
    }

    @Override
    public boolean canEnchant(@NotNull ItemStack stack) {
        if (!ENABLED) {
            return false;
        }

        return stack.canApplyAtEnchantingTable(this)
                && (stack.getItem() instanceof net.minecraft.world.item.SwordItem
                || stack.getItem() instanceof net.minecraft.world.item.AxeItem);
    }

    @Override
    public boolean canApplyAtEnchantingTable(@NotNull ItemStack stack) {
        return canEnchant(stack);
    }

    @Override
    public boolean isAllowedOnBooks() {
        return super.isAllowedOnBooks();
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

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        if (!ENABLED) {
            return;
        }

        DamageSource source = event.getSource();
        Entity attacker = source.getEntity();

        if (attacker instanceof LivingEntity livingAttacker) {
            ItemStack weapon = livingAttacker.getMainHandItem();

            if (!weapon.isEmpty()) {
                int level = weapon.getEnchantmentLevel(KEEnchantments.VOID_ASSAULT.get());

                if (level > 0 && RANDOM.nextDouble() < BASE_CHANCE) {
                    float damageMultiplier = (float)(BASE_DAMAGE_MULTIPLIER +
                            (DAMAGE_MULTIPLIER_PER_LEVEL * (level - 1)));
                    float extraDamage = event.getAmount() * damageMultiplier;
                    event.setAmount(event.getAmount() + extraDamage);

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
    }
}