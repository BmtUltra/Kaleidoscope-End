package com.bmt.kaleidoscope_end.block;


import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CaveVinesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

public class KECaveVinesHeadBlock extends CaveVinesBlock {
    private final Supplier<? extends Block> bodyBlock;
    private final Supplier<Item> fruitItem;

    public KECaveVinesHeadBlock(Properties properties, Supplier<? extends Block> bodyBlock, Supplier<Item> fruitItem) {
        super(properties);
        this.bodyBlock = bodyBlock;
        this.fruitItem = fruitItem;
    }

    @Override
    protected Block getBodyBlock() {
        return bodyBlock.get();
    }

    public ItemStack getCloneItemStack(BlockGetter p_153007_, BlockPos p_153008_, BlockState p_153009_) {
        return new ItemStack(fruitItem.get());
    }

    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
        if (blockState.getValue(BERRIES)) {
            Block.popResource(level, blockPos, new ItemStack(fruitItem.get(), 1));
            float f = Mth.randomBetween(level.random, 0.8F, 1.2F);
            level.playSound(null, blockPos, SoundEvents.CAVE_VINES_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, f);
            BlockState blockstate = blockState.setValue(BERRIES, Boolean.FALSE);
            level.setBlock(blockPos, blockstate, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(player, blockstate));
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }
}