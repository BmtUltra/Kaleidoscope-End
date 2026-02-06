package com.bmt.kaleidoscope_end.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;
import java.util.Set;

public class KECropBlockBase extends CropBlock {

    public KECropBlockBase(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (state.getBlock() instanceof CropBlock cropBlock && cropBlock.isMaxAge(state)) {
            getHandHarvestItem(state, level, pos, null, player, player.getItemInHand(hand));
            int ageAfterUse = 5;
            level.playSound(null, (double) pos.getX() + 0.5, (double) pos.getY() + 0.5, (double) pos.getZ() + 0.5, SoundEvents.CROP_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.setBlock(pos, this.getStateForAge(ageAfterUse), 2);

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    public Set<Item> getHandHarvestExclude() {
        return Set.of();
    }

    public void getHandHarvestItem(BlockState pState, Level pLevel, BlockPos pPos, @Nullable BlockEntity pBlockEntity, @Nullable Entity pEntity, ItemStack pTool) {
        if (pLevel instanceof ServerLevel) {
            getDrops(pState, (ServerLevel) pLevel, pPos, pBlockEntity, pEntity, pTool).forEach((itemStack) -> {
                if (!getHandHarvestExclude().contains(itemStack.getItem())) {
                    popResource(pLevel, pPos, itemStack);
                }
            });
            pState.spawnAfterBreak((ServerLevel) pLevel, pPos, pTool, true);
        }
    }
}
