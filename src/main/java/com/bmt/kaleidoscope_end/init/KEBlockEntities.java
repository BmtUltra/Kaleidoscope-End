package com.bmt.kaleidoscope_end.init;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.blockentity.DragonEggShellBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class KEBlockEntities {
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, KaleidoscopeEnd.MODID);

    public static final RegistryObject<BlockEntityType<DragonEggShellBlockEntity>> DRAGON_EGG_SHELL =
            BLOCK_ENTITIES.register("dragon_egg_shell",
                    () -> BlockEntityType.Builder.of(DragonEggShellBlockEntity::new,
                            KEBlocks.DRAGON_EGG_SHELL.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}