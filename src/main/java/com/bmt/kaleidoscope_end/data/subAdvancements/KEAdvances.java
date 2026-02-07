package com.bmt.kaleidoscope_end.data.subAdvancements;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.registry.KEEffects;
import com.bmt.kaleidoscope_end.registry.KEFoodBiteRegistry;
import com.bmt.kaleidoscope_end.registry.KEItem;
import com.bmt.kaleidoscope_end.registry.KETags;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.internal.NeoForgeAdvancementProvider;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class KEAdvances implements NeoForgeAdvancementProvider.AdvancementGenerator {

    @Override
    public void generate(HolderLookup.@NotNull Provider provider, @NotNull Consumer<AdvancementHolder> consumer, @NotNull ExistingFileHelper existingFileHelper) {
        // 根进度 - 获得任意模组物品
        AdvancementHolder root = Advancement.Builder.advancement()
                .display(
                        KEItem.ENDER_MINT.get(),
                        Component.translatable("advancements.kaleidoscope_end.root.title"),
                        Component.translatable("advancements.kaleidoscope_end.root.description"),
                        ResourceLocation.fromNamespaceAndPath(KaleidoscopeEnd.MOD_ID, "textures/advancement/background.png"),
                        AdvancementType.TASK,
                        true, true, false
                )
                .addCriterion("mod_items", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(KETags.Items.MOD_ITEMS).build()
                ))
                .save(consumer, KaleidoscopeEnd.MOD_ID + ":root");

        // 龙尘 - 获得龙尘
        AdvancementHolder dragonDust = Advancement.Builder.advancement()
                .parent(root)
                .display(
                        KEItem.DRAGON_DUST.get(),
                        Component.translatable("advancements.kaleidoscope_end.dragon_dust.title"),
                        Component.translatable("advancements.kaleidoscope_end.dragon_dust.description"),
                        null,
                        AdvancementType.TASK,
                        true, true, false
                )
                .addCriterion("dragon_dust", InventoryChangeTrigger.TriggerInstance.hasItems(
                        KEItem.DRAGON_DUST.get()
                ))
                .save(consumer, KaleidoscopeEnd.MOD_ID + ":dragon_dust");

        // 龙蛋壳 - 获得龙蛋壳
        AdvancementHolder dragonEggShell = Advancement.Builder.advancement()
                .parent(dragonDust)
                .display(
                        KEItem.DRAGON_EGG_SHELL.get(),
                        Component.translatable("advancements.kaleidoscope_end.dragon_egg_shell.title"),
                        Component.translatable("advancements.kaleidoscope_end.dragon_egg_shell.description"),
                        null,
                        AdvancementType.GOAL,
                        true, true, false
                )
                .addCriterion("dragon_egg_shell", InventoryChangeTrigger.TriggerInstance.hasItems(
                        KEItem.DRAGON_EGG_SHELL.get()
                ))
                .save(consumer, KaleidoscopeEnd.MOD_ID + ":dragon_egg_shell");

        // 龙蛋饮食 - 吃掉龙蛋相关食物
        Item darkDragonEggStewItem = BuiltInRegistries.ITEM.get(KEFoodBiteRegistry.DARK_DRAGON_EGG_STEW);
        Item dragonEggCustardItem = BuiltInRegistries.ITEM.get(KEFoodBiteRegistry.DRAGON_EGG_CUSTARD);
        
        Advancement.Builder.advancement()
                .parent(dragonEggShell)
                .display(
                        darkDragonEggStewItem,
                        Component.translatable("advancements.kaleidoscope_end.dragon_egg_diet.title"),
                        Component.translatable("advancements.kaleidoscope_end.dragon_egg_diet.description"),
                        null,
                        AdvancementType.CHALLENGE,
                        true, true, false
                )
                .addCriterion("dark_dragon_egg_stew", ConsumeItemTrigger.TriggerInstance.usedItem(
                        darkDragonEggStewItem
                ))
                .addCriterion("dragon_egg_custard", ConsumeItemTrigger.TriggerInstance.usedItem(
                        dragonEggCustardItem
                ))
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, KaleidoscopeEnd.MOD_ID + ":dragon_egg_diet");

        // 龙牙刀 - 获得龙牙刀（隐藏挑战）
        Advancement.Builder.advancement()
                .parent(dragonDust)
                .display(
                        KEItem.DRAGON_TOOTH_KNIFE.get(),
                        Component.translatable("advancements.kaleidoscope_end.dragon_tooth_knife.title"),
                        Component.translatable("advancements.kaleidoscope_end.dragon_tooth_knife.description"),
                        null,
                        AdvancementType.CHALLENGE,
                        true, true, true
                )
                .addCriterion("dragon_tooth_knife", InventoryChangeTrigger.TriggerInstance.hasItems(
                        KEItem.DRAGON_TOOTH_KNIFE.get()
                ))
                .save(consumer, KaleidoscopeEnd.MOD_ID + ":dragon_tooth_knife");

        // 虚空海螺 - 获得虚空海螺
        AdvancementHolder voidConch = Advancement.Builder.advancement()
                .parent(dragonDust)
                .display(
                        KEItem.VOID_CONCH.get(),
                        Component.translatable("advancements.kaleidoscope_end.void_conch.title"),
                        Component.translatable("advancements.kaleidoscope_end.void_conch.description"),
                        null,
                        AdvancementType.TASK,
                        true, true, false
                )
                .addCriterion("void_conch", InventoryChangeTrigger.TriggerInstance.hasItems(
                        KEItem.VOID_CONCH.get()
                ))
                .save(consumer, KaleidoscopeEnd.MOD_ID + ":void_conch");

        // 虚空侵蚀 - 获得虚空侵蚀效果
        Advancement.Builder.advancement()
                .parent(voidConch)
                .display(
                        KEItem.VOID_CONCH_NOODLE_SOUP_ITEM.get(),
                        Component.translatable("advancements.kaleidoscope_end.void_erosion.title"),
                        Component.translatable("advancements.kaleidoscope_end.void_erosion.description"),
                        null,
                        AdvancementType.GOAL,
                        true, true, false
                )
                .addCriterion("void_erosion", EffectsChangedTrigger.TriggerInstance.hasEffects(
                        MobEffectsPredicate.Builder.effects().and(KEEffects.VOID_EROSION)
                ))
                .save(consumer, KaleidoscopeEnd.MOD_ID + ":void_erosion");

        // 梦境浆果 - 获得梦境浆果
        AdvancementHolder dreamBerry = Advancement.Builder.advancement()
                .parent(root)
                .display(
                        KEItem.DREAM_BERRY_ITEM.get(),
                        Component.translatable("advancements.kaleidoscope_end.dream_berry.title"),
                        Component.translatable("advancements.kaleidoscope_end.dream_berry.description"),
                        null,
                        AdvancementType.TASK,
                        true, true, false
                )
                .addCriterion("dream_berry", InventoryChangeTrigger.TriggerInstance.hasItems(
                        KEItem.DREAM_BERRY_ITEM.get()
                ))
                .save(consumer, KaleidoscopeEnd.MOD_ID + ":dream_berry");

        // 梦境 - 获得梦境效果
        Advancement.Builder.advancement()
                .parent(dreamBerry)
                .display(
                        KEItem.CHORUS_PETAL.get(),
                        Component.translatable("advancements.kaleidoscope_end.dream.title"),
                        Component.translatable("advancements.kaleidoscope_end.dream.description"),
                        null,
                        AdvancementType.TASK,
                        true, true, false
                )
                .addCriterion("dream", EffectsChangedTrigger.TriggerInstance.hasEffects(
                        MobEffectsPredicate.Builder.effects().and(KEEffects.DREAM)
                ))
                .save(consumer, KaleidoscopeEnd.MOD_ID + ":dream");

        // 末地毛虫 - 获得末地毛虫
        Advancement.Builder.advancement()
                .parent(root)
                .display(
                        KEItem.END_CATERPILLAR_ITEM.get(),
                        Component.translatable("advancements.kaleidoscope_end.end_caterpillar.title"),
                        Component.translatable("advancements.kaleidoscope_end.end_caterpillar.description"),
                        null,
                        AdvancementType.TASK,
                        true, true, false
                )
                .addCriterion("end_caterpillar", InventoryChangeTrigger.TriggerInstance.hasItems(
                        KEItem.END_CATERPILLAR_ITEM.get()
                ))
                .save(consumer, KaleidoscopeEnd.MOD_ID + ":end_caterpillar");
    }
}
