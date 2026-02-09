package com.bmt.kaleidoscope_end.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class DragonDustItem extends BoneMealItem {

    public DragonDustItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockPos blockpos1 = blockpos.relative(context.getClickedFace());

        if (applyDragonDust(context.getItemInHand(), level, blockpos, context.getPlayer())) {
            if (!level.isClientSide) {
                level.levelEvent(1505, blockpos, 0);
            }

            Player player = context.getPlayer();
            if (player != null) {
                player.getCooldowns().addCooldown(this, 100);
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            BlockState blockstate = level.getBlockState(blockpos);
            boolean flag = blockstate.isFaceSturdy(level, blockpos, context.getClickedFace());
            if (flag && growWaterPlantWithoutConsume(context.getItemInHand(), level, blockpos1, context.getClickedFace())) {
                if (!level.isClientSide) {
                    level.levelEvent(1505, blockpos1, 0);
                }

                Player player = context.getPlayer();
                if (player != null) {
                    player.getCooldowns().addCooldown(this, 100);
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        }
    }

    @SuppressWarnings("unused")
    public static boolean applyDragonDust(ItemStack stack, Level level, BlockPos pos, @Nullable Player player) {
        BlockState blockstate = level.getBlockState(pos);

        int hook = net.minecraftforge.event.ForgeEventFactory.onApplyBonemeal(player, level, pos, blockstate, stack);
        if (hook != 0) return hook > 0;

        if (blockstate.getBlock() instanceof net.minecraft.world.level.block.BonemealableBlock) {
            net.minecraft.world.level.block.BonemealableBlock bonemealableblock = (net.minecraft.world.level.block.BonemealableBlock)blockstate.getBlock();
            if (bonemealableblock.isValidBonemealTarget(level, pos, blockstate, level.isClientSide)) {
                if (level instanceof net.minecraft.server.level.ServerLevel) {
                    if (bonemealableblock.isBonemealSuccess(level, level.random, pos, blockstate)) {
                        bonemealableblock.performBonemeal((net.minecraft.server.level.ServerLevel)level, level.random, pos, blockstate);
                    }
                }
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unused")
    public static boolean growWaterPlantWithoutConsume(ItemStack stack, Level level, BlockPos pos, @Nullable Direction direction) {
        if (level.getBlockState(pos).is(net.minecraft.world.level.block.Blocks.WATER) && level.getFluidState(pos).getAmount() == 8) {
            if (!(level instanceof net.minecraft.server.level.ServerLevel)) {
                return true;
            } else {
                net.minecraft.util.RandomSource randomsource = level.getRandom();
                net.minecraft.server.level.ServerLevel serverlevel = (net.minecraft.server.level.ServerLevel)level;

                label78:
                for(int i = 0; i < 128; ++i) {
                    BlockPos blockpos = pos;
                    BlockState blockstate = net.minecraft.world.level.block.Blocks.SEAGRASS.defaultBlockState();

                    for(int j = 0; j < i / 16; ++j) {
                        blockpos = blockpos.offset(randomsource.nextInt(3) - 1, (randomsource.nextInt(3) - 1) * randomsource.nextInt(3) / 2, randomsource.nextInt(3) - 1);
                        if (level.getBlockState(blockpos).isCollisionShapeFullBlock(level, blockpos)) {
                            continue label78;
                        }
                    }

                    net.minecraft.core.Holder<net.minecraft.world.level.biome.Biome> holder = level.getBiome(blockpos);
                    if (holder.is(net.minecraft.tags.BiomeTags.PRODUCES_CORALS_FROM_BONEMEAL)) {
                        if (i == 0 && direction != null && direction.getAxis().isHorizontal()) {
                            blockstate = net.minecraft.core.registries.BuiltInRegistries.BLOCK.getTag(net.minecraft.tags.BlockTags.WALL_CORALS).flatMap((p_204098_) -> p_204098_.getRandomElement(level.random)).map((p_204100_) -> p_204100_.value().defaultBlockState()).orElse(blockstate);
                            if (blockstate.hasProperty(net.minecraft.world.level.block.BaseCoralWallFanBlock.FACING)) {
                                blockstate = blockstate.setValue(net.minecraft.world.level.block.BaseCoralWallFanBlock.FACING, direction);
                            }
                        } else if (randomsource.nextInt(4) == 0) {
                            blockstate = net.minecraft.core.registries.BuiltInRegistries.BLOCK.getTag(net.minecraft.tags.BlockTags.UNDERWATER_BONEMEALS).flatMap((p_204091_) -> p_204091_.getRandomElement(level.random)).map((p_204095_) -> p_204095_.value().defaultBlockState()).orElse(blockstate);
                        }
                    }

                    if (blockstate.is(net.minecraft.tags.BlockTags.WALL_CORALS, (p_204093_) -> p_204093_.hasProperty(net.minecraft.world.level.block.BaseCoralWallFanBlock.FACING))) {
                        for(int k = 0; !blockstate.canSurvive(level, blockpos) && k < 4; ++k) {
                            blockstate = blockstate.setValue(net.minecraft.world.level.block.BaseCoralWallFanBlock.FACING, net.minecraft.core.Direction.Plane.HORIZONTAL.getRandomDirection(randomsource));
                        }
                    }

                    if (blockstate.canSurvive(level, blockpos)) {
                        BlockState blockstate1 = level.getBlockState(blockpos);
                        if (blockstate1.is(net.minecraft.world.level.block.Blocks.WATER) && level.getFluidState(blockpos).getAmount() == 8) {
                            level.setBlock(blockpos, blockstate, 3);
                        } else if (blockstate1.is(net.minecraft.world.level.block.Blocks.SEAGRASS) && randomsource.nextInt(10) == 0) {
                            ((net.minecraft.world.level.block.BonemealableBlock)net.minecraft.world.level.block.Blocks.SEAGRASS).performBonemeal(serverlevel, randomsource, blockpos, blockstate1);
                        }
                    }
                }
                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }
}