package com.bmt.kaleidoscope_end.registry;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.enchantment.VoidAssaultEnchantment;
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

    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}