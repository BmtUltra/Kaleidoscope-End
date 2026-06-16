package com.bmt.kaleidoscope_end.init;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.block.DragonEggShellBlock;
import com.bmt.kaleidoscope_end.block.SuspiciousDragonEggBlock;
import com.bmt.kaleidoscope_end.block.crops.DreamBerryHeadBlock;
import com.bmt.kaleidoscope_end.block.crops.DreamBerryPlantBlock;
import com.bmt.kaleidoscope_end.block.crops.EnderMint;
import com.github.ysbbbbbb.kaleidoscopecookery.block.kitchen.StoveBlock;
import net.minecraft.core.BlockPos;
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
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.function.Supplier;

public class KEBlocks {
    private static final DeferredRegister<Block> BLOCK_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, KaleidoscopeEnd.MODID);

    public static final Supplier<BlockBehaviour.Properties> CROP_DEFAULT_PROPERTIES =
            () -> BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY);

    public static final Supplier<BlockBehaviour.Properties> CAVE_VINES_PROPERTIES =
            () -> BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).randomTicks().noCollission().instabreak().sound(SoundType.WEEPING_VINES).pushReaction(PushReaction.DESTROY);

    public static final RegistryObject<DreamBerryPlantBlock> DREAM_BERRY_PLANT = BLOCK_DEFERRED_REGISTER.register("dream_berry_plant",
            () -> new DreamBerryPlantBlock(CAVE_VINES_PROPERTIES.get()));

    public static final RegistryObject<DreamBerryHeadBlock> DREAM_BERRY_HEAD = BLOCK_DEFERRED_REGISTER.register("dream_berry_head",
            () -> new DreamBerryHeadBlock(CAVE_VINES_PROPERTIES.get()));

    public static final RegistryObject<DragonEggShellBlock> DRAGON_EGG_SHELL = BLOCK_DEFERRED_REGISTER.register("dragon_egg_shell",
            DragonEggShellBlock::new);

    public static final RegistryObject<EnderMint> ENDER_MINT = BLOCK_DEFERRED_REGISTER.register("ender_mint",
            () -> new EnderMint(CROP_DEFAULT_PROPERTIES.get()));

    // 可疑的末地石
    public static final RegistryObject<Block> SUSPICIOUS_END_STONE = BLOCK_DEFERRED_REGISTER.register("suspicious_end_stone",
            () -> new BrushableBlock(Blocks.END_STONE,
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.SAND)
                            .instrument(NoteBlockInstrument.SNARE)
                            .strength(0.25F)
                            .sound(SoundType.SUSPICIOUS_SAND)
                            .pushReaction(PushReaction.DESTROY),
                    SoundEvents.BRUSH_SAND,
                    SoundEvents.BRUSH_SAND_COMPLETED) {
                @Override
                public @NotNull BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
                    @Nullable BrushableBlockEntity blockEntity = (BrushableBlockEntity) super.newBlockEntity(blockPos, blockState);
                    if (blockEntity != null) {
                        blockEntity.setLootTable(KaleidoscopeEnd.id("archaeology/suspicious_end_stone"), 0);
                    }
                    return blockEntity;
                }
            });

    // 可疑的紫珀块
    public static final RegistryObject<Block> SUSPICIOUS_PURPUR_BLOCK = BLOCK_DEFERRED_REGISTER.register("suspicious_purpur_block",
            () -> new BrushableBlock(Blocks.PURPUR_BLOCK,
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_MAGENTA)
                            .instrument(NoteBlockInstrument.SNARE)
                            .strength(0.25F)
                            .sound(SoundType.SUSPICIOUS_SAND)
                            .pushReaction(PushReaction.DESTROY),
                    SoundEvents.BRUSH_SAND,
                    SoundEvents.BRUSH_SAND_COMPLETED) {
                @Override
                public @NotNull BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
                    @Nullable BrushableBlockEntity blockEntity = (BrushableBlockEntity) super.newBlockEntity(blockPos, blockState);
                    if (blockEntity != null) {
                        blockEntity.setLootTable(KaleidoscopeEnd.id("archaeology/suspicious_purpur_block"), 0);
                    }
                    return blockEntity;
                }
            });

    // 可疑的龙蛋
    public static final RegistryObject<Block> SUSPICIOUS_DRAGON_EGG = BLOCK_DEFERRED_REGISTER.register("suspicious_dragon_egg",
            () -> new SuspiciousDragonEggBlock(Blocks.DRAGON_EGG,
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_BLACK)
                            .strength(3.0F, 9.0F)
                            .lightLevel((p_50840_) -> 1)
                            .noOcclusion()
                            .pushReaction(PushReaction.DESTROY),
                    SoundEvents.BRUSH_SAND,
                    SoundEvents.BRUSH_SAND_COMPLETED));

    // 末地炉灶
    public static final RegistryObject<Block> END_STOVE = BLOCK_DEFERRED_REGISTER.register("end_stove",
            StoveBlock::new);

    public static void register(IEventBus eventBus) {
        BLOCK_DEFERRED_REGISTER.register(eventBus);
    }

    public static Collection<RegistryObject<Block>> getEntries() {
        return BLOCK_DEFERRED_REGISTER.getEntries();
    }
}