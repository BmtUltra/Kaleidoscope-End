package com.bmt.kaleidoscope_end.init;

import java.util.Collection;
import java.util.function.Supplier;

import com.bmt.kaleidoscope_end.block.crops.DreamBerryHeadBlock;
import com.bmt.kaleidoscope_end.block.crops.DreamBerryPlantBlock;
import com.bmt.kaleidoscope_end.block.crops.EnderMint;
import org.jetbrains.annotations.NotNull;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.block.SuspiciousDragonEggBlock;
import com.github.ysbbbbbb.kaleidoscopecookery.block.kitchen.StoveBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BrushableBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class KEBlocks {
    private static final DeferredRegister<Block> BLOCK_DEFERRED_REGISTER = DeferredRegister.create(Registries.BLOCK, KaleidoscopeEnd.MOD_ID);
    public static final Supplier<BlockBehaviour.Properties> CROP_DEFAULT_PROPERTIES =
            () -> BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY);

    public static final Supplier<BlockBehaviour.Properties> CAVE_VINES_PROPERTIES =
            () -> BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).randomTicks().noCollission().instabreak().sound(SoundType.WEEPING_VINES).pushReaction(PushReaction.DESTROY);


    public static final DeferredHolder<Block, DreamBerryPlantBlock> DREAM_BERRY_PLANT = BLOCK_DEFERRED_REGISTER.register("dream_berry_plant",
            () -> new DreamBerryPlantBlock(CAVE_VINES_PROPERTIES.get()));

    public static final DeferredHolder<Block, DreamBerryHeadBlock> DREAM_BERRY_HEAD = BLOCK_DEFERRED_REGISTER.register("dream_berry_head",
            () -> new DreamBerryHeadBlock(CAVE_VINES_PROPERTIES.get()));


    public static final DeferredHolder<Block, EnderMint> ENDER_MINT = BLOCK_DEFERRED_REGISTER.register("ender_mint", () -> new EnderMint(CROP_DEFAULT_PROPERTIES.get()));

    // 可疑的末地石
    public static final DeferredHolder<Block, Block> SUSPICIOUS_END_STONE = BLOCK_DEFERRED_REGISTER.register("suspicious_end_stone",
            () -> new BrushableBlock(Blocks.END_STONE, 
                    SoundEvents.BRUSH_SAND, 
                    SoundEvents.BRUSH_SAND_COMPLETED,
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.SAND)
                            .instrument(NoteBlockInstrument.SNARE)
                            .strength(0.25F)
                            .sound(SoundType.SUSPICIOUS_SAND)
                            .pushReaction(PushReaction.DESTROY)){
                @Override
                public @NotNull BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
                    BrushableBlockEntity blockEntity = (BrushableBlockEntity) super.newBlockEntity(blockPos, blockState);
                    if (blockEntity != null) {
                        blockEntity.setLootTable(
                                ResourceKey.create(Registries.LOOT_TABLE, 
                                        KaleidoscopeEnd.id("archaeology/suspicious_end_stone")), 
                                0L);
                    }
                    return blockEntity;
                }
            });

    // 可疑的龙蛋
    public static final DeferredHolder<Block, SuspiciousDragonEggBlock> SUSPICIOUS_DRAGON_EGG = BLOCK_DEFERRED_REGISTER.register("suspicious_dragon_egg",
            () -> new SuspiciousDragonEggBlock(Blocks.DRAGON_EGG, 
                    SoundEvents.BRUSH_SAND, 
                    SoundEvents.BRUSH_SAND_COMPLETED,
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_BLACK)
                            .strength(3.0F, 9.0F)
                            .lightLevel((p_50840_) -> 1)
                            .noOcclusion()
                            .pushReaction(PushReaction.DESTROY)));

    // 末地炉灶
    public static final DeferredHolder<Block, StoveBlock> END_STOVE = BLOCK_DEFERRED_REGISTER.register("end_stove",
            StoveBlock::new);

    public static void register(IEventBus eventBus) {
        BLOCK_DEFERRED_REGISTER.register(eventBus);
    }

    public static Collection<DeferredHolder<Block, ? extends Block>> getEntries() {
        return BLOCK_DEFERRED_REGISTER.getEntries();
    }
}
