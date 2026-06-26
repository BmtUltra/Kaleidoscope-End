package com.bmt.kaleidoscope_end.mixins.kaleidoscope_end;

import com.bmt.kaleidoscope_end.init.KEBlocks;
import com.github.ysbbbbbb.kaleidoscopecookery.block.kitchen.StoveBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(StoveBlock.class)
public class StoveBlockMixin {

    @Inject(method = "randomTick", at = @At("HEAD"), cancellable = true)
    private void kaleidoscope_twilight$preventRainExtinguish(BlockState state, ServerLevel level, BlockPos pos, RandomSource random, CallbackInfo ci) {
        if (kaleidoscopeTwilight_1_21_1_NeoForge$isTwilightStove(state)) {
            ci.cancel();
        }
    }

    @Inject(method = "updateShape", at = @At("HEAD"), cancellable = true)
    private void kaleidoscope_twilight$preventWaterExtinguish(BlockState state, Direction direction, BlockState neighborState, LevelAccessor levelAccessor, BlockPos pos, BlockPos neighborPos, CallbackInfoReturnable<BlockState> cir) {
        if (kaleidoscopeTwilight_1_21_1_NeoForge$isTwilightStove(state)) {
            cir.setReturnValue(state);
        }
    }

    @Unique
    private static boolean kaleidoscopeTwilight_1_21_1_NeoForge$isTwilightStove(BlockState state) {
        return state.is(KEBlocks.END_STOVE.get());
    }
}