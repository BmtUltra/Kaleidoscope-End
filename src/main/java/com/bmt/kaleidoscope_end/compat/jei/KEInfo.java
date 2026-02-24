package com.bmt.kaleidoscope_end.compat.jei;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.registry.KEItem;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

@JeiPlugin
public class KEInfo implements IModPlugin {

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return ResourceLocation.tryBuild(KaleidoscopeEnd.MODID, "jei_plugin");
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registration) {
        addAllMaterialInfo(registration);
    }

    private void addAllMaterialInfo(IRecipeRegistration registration) {
        // 虚空海螺
        registration.addIngredientInfo(
                new ItemStack(KEItem.VOID_CONCH.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("item.kaleidoscope_end.void_conch.description")
        );
        
        // 龙尘
        registration.addIngredientInfo(
                new ItemStack(KEItem.DRAGON_DUST.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("item.kaleidoscope_end.dragon_dust.description")
        );
        
        // 龙牙
        registration.addIngredientInfo(
                new ItemStack(KEItem.DRAGON_TOOTH.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("item.kaleidoscope_end.dragon_tooth.description")
        );
        
        // 末影薄荷
        registration.addIngredientInfo(
                new ItemStack(KEItem.ENDER_MINT.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("item.kaleidoscope_end.ender_mint.description")
        );
        
        // 龙息桶
        registration.addIngredientInfo(
                new ItemStack(KEItem.DRAGON_BREATH_BUCKET_ITEM.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("item.kaleidoscope_end.dragon_breath_bucket.description")
        );
        
        // 紫颂花瓣
        registration.addIngredientInfo(
                new ItemStack(KEItem.CHORUS_PETAL.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("item.kaleidoscope_end.chorus_petal.description")
        );
        
        // 生末影龙肉
        registration.addIngredientInfo(
                new ItemStack(KEItem.RAW_ENDER_DRAGON_MEAT_ITEM.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("item.kaleidoscope_end.raw_ender_dragon_meat.description")
        );
        
        // 生末影螨肉
        registration.addIngredientInfo(
                new ItemStack(KEItem.RAW_ENDERMITE_MEAT_ITEM.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("item.kaleidoscope_end.raw_endermite_meat.description")
        );
        
        // 潜影贝质
        registration.addIngredientInfo(
                new ItemStack(KEItem.SHULKER_SHELL_MEAT_ITEM.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("item.kaleidoscope_end.shulker_shell_meat.description")
        );
        
        // 视神经
        registration.addIngredientInfo(
                new ItemStack(KEItem.OPTIC_NERVE_ITEM.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("item.kaleidoscope_end.optic_nerve.description")
        );
        
        // 梦境浆果
        registration.addIngredientInfo(
                new ItemStack(KEItem.DREAM_BERRY_ITEM.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("item.kaleidoscope_end.dream_berry.description")
        );
        
        // 龙蛋液
        registration.addIngredientInfo(
                new ItemStack(KEItem.DRAGON_EGG_LIQUID.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("item.kaleidoscope_end.dragon_egg_liquid.description")
        );
        
        // 紫颂果籽
        registration.addIngredientInfo(
                new ItemStack(KEItem.CHORUS_SEED.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("item.kaleidoscope_end.chorus_seed.description")
        );
    }
}