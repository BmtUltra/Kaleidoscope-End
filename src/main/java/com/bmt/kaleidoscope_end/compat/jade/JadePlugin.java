package com.bmt.kaleidoscope_end.compat.jade;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.blockentity.DragonEggShellBlockEntity;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class JadePlugin implements IWailaPlugin {
    public static final ResourceLocation DRAGON_EGG_SHELL = ResourceLocation.fromNamespaceAndPath(KaleidoscopeEnd.MOD_ID, "dragon_egg_shell");

    @Override
    public void register(IWailaCommonRegistration registration) {
        registration.registerItemStorage(DragonEggShellComponentProvider.INSTANCE, DragonEggShellBlockEntity.class);
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerItemStorageClient(DragonEggShellComponentProvider.INSTANCE);
    }
}