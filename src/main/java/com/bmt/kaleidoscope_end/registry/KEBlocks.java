package com.bmt.kaleidoscope_end.registry;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.block.SuspiciousDragonEggBlock;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BrushableBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collection;

public class KEBlocks {
    private static final DeferredRegister<Block> BLOCK_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, KaleidoscopeEnd.MODID);

    public static final RegistryObject<Block> SUSPICIOUS_END_STONE = BLOCK_DEFERRED_REGISTER.register("suspicious_end_stone",
            () -> new BrushableBlock(Blocks.END_STONE, BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.SNARE).strength(0.25F).sound(SoundType.SUSPICIOUS_SAND).pushReaction(PushReaction.DESTROY), SoundEvents.BRUSH_SAND, SoundEvents.BRUSH_SAND_COMPLETED));

    public static final RegistryObject<Block> SUSPICIOUS_DRAGON_EGG = BLOCK_DEFERRED_REGISTER.register("suspicious_dragon_egg",
            () -> new SuspiciousDragonEggBlock(Blocks.DRAGON_EGG, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(3.0F, 9.0F).lightLevel((p_50840_) -> {
                return 1;
            }).noOcclusion().pushReaction(PushReaction.DESTROY), SoundEvents.BRUSH_SAND, SoundEvents.BRUSH_SAND_COMPLETED));


    public static void register(IEventBus eventBus) {
        BLOCK_DEFERRED_REGISTER.register(eventBus);
    }

    public static Collection<RegistryObject<Block>> getEntries() {
        return BLOCK_DEFERRED_REGISTER.getEntries();
    }
}
