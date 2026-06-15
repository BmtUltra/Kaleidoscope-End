package com.bmt.kaleidoscope_end.client;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.client.render.block.DragonEggShellBlockEntityRender;
import com.bmt.kaleidoscope_end.init.KEBlockEntities;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = KaleidoscopeEnd.MOD_ID, value = Dist.CLIENT)
public class KEClient {

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(KEBlockEntities.DRAGON_EGG_SHELL.get(), DragonEggShellBlockEntityRender::new);
    }
}