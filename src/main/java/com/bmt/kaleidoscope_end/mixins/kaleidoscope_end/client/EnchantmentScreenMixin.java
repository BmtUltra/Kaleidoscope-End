package com.bmt.kaleidoscope_end.mixins.kaleidoscope_end.client;

import com.bmt.kaleidoscope_end.hooks.kaleidoscope_end.EnchantmentScreenMixinHooks;
import com.bmt.kaleidoscope_end.init.KEItem;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.EnchantmentScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.EnchantmentMenu;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(EnchantmentScreen.class)
public abstract class EnchantmentScreenMixin extends AbstractContainerScreen<EnchantmentMenu> {

    @Shadow
    @Final
    private static ResourceLocation ENCHANTING_TABLE_LOCATION;

    public EnchantmentScreenMixin(EnchantmentMenu p_97741_, Inventory p_97742_, Component p_97743_) {
        super(p_97741_, p_97742_, p_97743_);
    }

    @ModifyArg(method = "renderBg", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;drawString(Lnet/minecraft/client/gui/Font;Ljava/lang/String;III)I"), index = 4)
    private int onDrawString(int color) {
        return EnchantmentScreenMixinHooks.warpColor(color, menu);
    }

    @ModifyArg(method = "renderBg", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;blit(Lnet/minecraft/resources/ResourceLocation;IIIIII)V"), index = 0)
    private ResourceLocation replaceBg(ResourceLocation resourceLocation) {
        if (resourceLocation.equals(ENCHANTING_TABLE_LOCATION) && menu.slots.get(1).getItem().is(KEItem.VOID_CONCH.get())) {
            return EnchantmentScreenMixinHooks.KE_ENCHANTING_TABLE_LOCATION;
        }
        return resourceLocation;
    }
}
