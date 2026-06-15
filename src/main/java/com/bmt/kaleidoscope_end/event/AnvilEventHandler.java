package com.bmt.kaleidoscope_end.event;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.init.KEItem;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AnvilUpdateEvent;

@EventBusSubscriber(modid = KaleidoscopeEnd.MOD_ID)
public class AnvilEventHandler {

    private static final ResourceLocation CRIT_CHANCE_MODIFIER_ID =
            ResourceLocation.fromNamespaceAndPath(KaleidoscopeEnd.MOD_ID, "dragon_tooth_crit_chance");

    private static final double CRIT_CHANCE_BONUS = 0.25;

    @SubscribeEvent
    public static void onAnvilUpdate(AnvilUpdateEvent event) {
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();

        if (!ModList.get().isLoaded("apothic_attributes")) {
            return;
        }

        if (right.getItem() != KEItem.DRAGON_TOOTH.get()) {
            return;
        }

        if (left.isEmpty()) {
            return;
        }

        ItemAttributeModifiers existingModifiers = left.getOrDefault(
                DataComponents.ATTRIBUTE_MODIFIERS,
                ItemAttributeModifiers.EMPTY
        );

        for (ItemAttributeModifiers.Entry entry : existingModifiers.modifiers()) {
            if (entry.attribute().equals(ALObjects.Attributes.CRIT_CHANCE) &&
                    entry.modifier().id().equals(CRIT_CHANCE_MODIFIER_ID)) {
                return;
            }
        }
        ItemStack result = left.copy();

        AttributeModifier critModifier = new AttributeModifier(
                CRIT_CHANCE_MODIFIER_ID,
                CRIT_CHANCE_BONUS,
                Operation.ADD_VALUE
        );

        ItemAttributeModifiers modifiers = result.getOrDefault(
                DataComponents.ATTRIBUTE_MODIFIERS,
                ItemAttributeModifiers.EMPTY
        );

        modifiers = modifiers.withModifierAdded(
                ALObjects.Attributes.CRIT_CHANCE,
                critModifier,
                EquipmentSlotGroup.MAINHAND
        );

        result.set(DataComponents.ATTRIBUTE_MODIFIERS, modifiers);
        event.setOutput(result);
        event.setCost(30);
        event.setMaterialCost(1);
    }
}