package com.bmt.kaleidoscope_end.event;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.init.KEItem;
import dev.shadowsoffire.attributeslib.api.ALObjects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

import java.util.UUID;

@Mod.EventBusSubscriber(modid = KaleidoscopeEnd.MODID)
public class AnvilEventHandler {
    private static final UUID CRIT_CHANCE_UUID = UUID.fromString("a1b2c3d4-e5f6-7890-abcd-ef1234567890");
    private static final double CRIT_CHANCE_BONUS = 0.25;

    @SubscribeEvent
    public static void onAnvilUpdate(AnvilUpdateEvent event) {
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();

        if (!ModList.get().isLoaded("attributeslib")) {
            return;
        }

        if (right.getItem() != KEItem.DRAGON_TOOTH.get()) {
            return;
        }

        if (left.isEmpty()) {
            return;
        }

        for (AttributeModifier modifier : left.getAttributeModifiers(EquipmentSlot.MAINHAND).values()) {
            if (modifier.getId().equals(CRIT_CHANCE_UUID)) {
                return;
            }
        }

        ItemStack result = left.copy();
        AttributeModifier critModifier = new AttributeModifier(
                CRIT_CHANCE_UUID,
                "dragon_tooth_crit_chance",
                CRIT_CHANCE_BONUS,
                Operation.ADDITION
        );

        result.addAttributeModifier(
                ALObjects.Attributes.CRIT_CHANCE.get(),
                critModifier,
                EquipmentSlot.MAINHAND
        );

        event.setOutput(result);
        event.setCost(30);
        event.setMaterialCost(1);
    }
}