package com.bmt.kaleidoscope_end.block.crops;


import com.bmt.kaleidoscope_end.init.KEItem;
import com.bmt.kaleidoscope_end.init.KETags;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class EnderMint extends KECropBlockBase {
    public EnderMint(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return blockState.is(KETags.Blocks.END_STONE_GROWABLE);
    }

    @Override
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (serverLevel.getRawBrightness(blockPos, 0) >= 9) {
            int i = this.getAge(blockState);
            if (i < this.getMaxAge()) {
                float f = getGrowthSpeed(this.defaultBlockState(), serverLevel, blockPos);
                if (randomSource.nextInt((int)(25.0F / f) + 1) == 0) {
                    serverLevel.setBlock(blockPos, this.getStateForAge(i + 1), 2);
                }
            }
        }
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return KEItem.ENDER_MINT.get();
    }

    @Override
    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        BlockPos blockpos = blockPos.below();
        return this.mayPlaceOn(levelReader.getBlockState(blockpos), levelReader, blockpos);
    }
}