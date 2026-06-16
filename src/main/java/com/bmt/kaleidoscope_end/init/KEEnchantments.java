package com.bmt.kaleidoscope_end.init;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.enchantment.VoidAssaultEnchantment;
import com.bmt.kaleidoscope_end.enchantment.VoidEchoEnchantment;
import com.bmt.kaleidoscope_end.enchantment.VoidShotEnchantment;
import com.bmt.kaleidoscope_end.enchantment.VoidWalkerEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class KEEnchantments {
    private static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, KaleidoscopeEnd.MODID);

    // 虚空强袭
    public static final RegistryObject<Enchantment> VOID_ASSAULT = ENCHANTMENTS.register("void_assault",
            () -> new VoidAssaultEnchantment(
                    Enchantment.Rarity.VERY_RARE,
                    EnchantmentCategory.WEAPON,
                    EquipmentSlot.MAINHAND
            ));

    // 虚空射击
    public static final RegistryObject<Enchantment> VOID_SHOT = ENCHANTMENTS.register("void_shot",
            () -> new VoidShotEnchantment(
                    Enchantment.Rarity.VERY_RARE,
                    EnchantmentCategory.WEAPON,
                    EquipmentSlot.MAINHAND,
                    EquipmentSlot.OFFHAND
            ));

    // 虚空回响
    public static final RegistryObject<Enchantment> VOID_ECHO = ENCHANTMENTS.register("void_echo",
            () -> new VoidEchoEnchantment(
                    Enchantment.Rarity.VERY_RARE,
                    EnchantmentCategory.WEAPON,
                    EquipmentSlot.MAINHAND
            ));

    // 虚空行者
    public static final RegistryObject<Enchantment> VOID_WALKER = ENCHANTMENTS.register("void_walker",
            () -> new VoidWalkerEnchantment(
                    Enchantment.Rarity.VERY_RARE,
                    EnchantmentCategory.ARMOR_FEET,
                    EquipmentSlot.FEET
            ));

    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}