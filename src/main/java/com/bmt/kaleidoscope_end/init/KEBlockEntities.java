package com.bmt.kaleidoscope_end.init;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.blockentity.DragonEggShellBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class KEBlockEntities {
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, KaleidoscopeEnd.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DragonEggShellBlockEntity>> DRAGON_EGG_SHELL =
            BLOCK_ENTITIES.register("dragon_egg_shell",
                    () -> BlockEntityType.Builder.of(DragonEggShellBlockEntity::new,
                            KEBlocks.DRAGON_EGG_SHELL.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}