package com.bmt.kaleidoscope_end.block;

import org.jetbrains.annotations.Nullable;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BrushableBlock;
import net.minecraft.world.level.block.Fallable;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SuspiciousDragonEggBlock extends BrushableBlock implements Fallable {
    protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public SuspiciousDragonEggBlock(Block block, SoundEvent soundEvent1, SoundEvent soundEvent2, Properties properties) {
        super(block, soundEvent1, soundEvent2, properties);
    }

    public void onPlace(BlockState p_53233_, Level p_53234_, BlockPos p_53235_, BlockState p_53236_, boolean p_53237_) {
        p_53234_.scheduleTick(p_53235_, this, this.getDelayAfterPlace());
    }

    public BlockState updateShape(BlockState p_53226_, Direction p_53227_, BlockState p_53228_, LevelAccessor p_53229_, BlockPos p_53230_, BlockPos p_53231_) {
        p_53229_.scheduleTick(p_53230_, this, this.getDelayAfterPlace());
        return super.updateShape(p_53226_, p_53227_, p_53228_, p_53229_, p_53230_, p_53231_);
    }

    public void tick(BlockState p_221124_, ServerLevel p_221125_, BlockPos p_221126_, RandomSource p_221127_) {
        if (isFree(p_221125_.getBlockState(p_221126_.below())) && p_221126_.getY() >= p_221125_.getMinBuildHeight()) {
            FallingBlockEntity.fall(p_221125_, p_221126_, p_221124_);
        }
    }

    @SuppressWarnings("deprecation")
    public static boolean isFree(BlockState p_53242_) {
        return p_53242_.isAir() || p_53242_.is(BlockTags.FIRE) || p_53242_.liquid() || p_53242_.canBeReplaced();
    }

    public VoxelShape getShape(BlockState p_52930_, BlockGetter p_52931_, BlockPos p_52932_, CollisionContext p_52933_) {
        return SHAPE;
    }

    public void attack(BlockState p_52918_, Level p_52919_, BlockPos p_52920_, Player p_52921_) {
        this.teleport(p_52918_, p_52919_, p_52920_);
    }

    private void teleport(BlockState blockState, Level level, BlockPos blockPos) {
        WorldBorder worldborder = level.getWorldBorder();

        for (int i = 0; i < 1000; ++i) {
            BlockPos blockpos = blockPos.offset(level.random.nextInt(16) - level.random.nextInt(16), level.random.nextInt(8) - level.random.nextInt(8), level.random.nextInt(16) - level.random.nextInt(16));
            if (level.getBlockState(blockpos).isAir() && worldborder.isWithinBounds(blockpos)) {
                if (level.isClientSide) {
                    for (int j = 0; j < 128; ++j) {
                        double d0 = level.random.nextDouble();
                        float f = (level.random.nextFloat() - 0.5F) * 0.2F;
                        float f1 = (level.random.nextFloat() - 0.5F) * 0.2F;
                        float f2 = (level.random.nextFloat() - 0.5F) * 0.2F;
                        double d1 = Mth.lerp(d0, blockpos.getX(), blockPos.getX()) + (level.random.nextDouble() - 0.5D) + 0.5D;
                        double d2 = Mth.lerp(d0, blockpos.getY(), blockPos.getY()) + level.random.nextDouble() - 0.5D;
                        double d3 = Mth.lerp(d0, blockpos.getZ(), blockPos.getZ()) + (level.random.nextDouble() - 0.5D) + 0.5D;
                        level.addParticle(ParticleTypes.PORTAL, d1, d2, d3, f, f1, f2);
                    }
                } else {
                    level.setBlock(blockpos, blockState, 2);
                    level.removeBlock(blockPos, false);
                }
                return;
            }
        }
    }

    protected int getDelayAfterPlace() {
        return 5;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos p_277683_, BlockState p_277381_) {
        BrushableBlockEntity blockEntity = (BrushableBlockEntity) super.newBlockEntity(p_277683_, p_277381_);
        if (blockEntity != null) {
            blockEntity.setLootTable(
                    ResourceKey.create(Registries.LOOT_TABLE, 
                            KaleidoscopeEnd.id("archaeology/suspicious_dragon_egg")), 
                    0L);
        }
        return blockEntity;
    }
}
