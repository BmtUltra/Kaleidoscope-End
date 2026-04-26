package com.bmt.kaleidoscope_end.event;

import com.bmt.kaleidoscope_end.init.KEItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChorusPlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber(modid = com.bmt.kaleidoscope_end.KaleidoscopeEnd.MOD_ID)
public class ChorusFlowerInteractionHandler {

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if (event.getLevel().isClientSide()) {
            return;
        }

        Player player = event.getEntity();
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);
        ItemStack heldItem = player.getItemInHand(event.getHand());

        if (heldItem.getItem() == Items.SHEARS && state.is(Blocks.CHORUS_FLOWER)) {
            if (!player.isCreative()) {
                EquipmentSlot slot = event.getHand() == net.minecraft.world.InteractionHand.MAIN_HAND ?
                        EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
                heldItem.hurtAndBreak(1, player, slot);
            }

            BlockState plantState = Blocks.CHORUS_PLANT.defaultBlockState();

            for (Direction direction : Direction.values()) {
                BlockPos neighborPos = pos.relative(direction);
                BlockState neighborState = level.getBlockState(neighborPos);

                BooleanProperty property = getConnectionProperty(direction);
                if (property != null) {
                    boolean shouldConnect = neighborState.is(Blocks.CHORUS_FLOWER) ||
                            neighborState.is(Blocks.CHORUS_PLANT);
                    plantState = plantState.setValue(property, shouldConnect);
                }
            }

            level.setBlock(pos, plantState, 3);

            if (level instanceof ServerLevel) {
                ItemStack petals = new ItemStack(KEItem.CHORUS_PETAL.get(), 2);
                ItemEntity itemEntity = new ItemEntity(
                        level,
                        pos.getX() + 0.5,
                        pos.getY() + 0.5,
                        pos.getZ() + 0.5,
                        petals
                );
                itemEntity.setDefaultPickUpDelay();
                level.addFreshEntity(itemEntity);
            }

            level.playSound(null, pos, SoundEvents.SHEEP_SHEAR, SoundSource.PLAYERS, 1.0F, 1.0F);

            event.setCanceled(true);
        }
    }

    private static BooleanProperty getConnectionProperty(Direction direction) {
        return switch (direction) {
            case DOWN -> ChorusPlantBlock.DOWN;
            case UP -> ChorusPlantBlock.UP;
            case NORTH -> ChorusPlantBlock.NORTH;
            case SOUTH -> ChorusPlantBlock.SOUTH;
            case WEST -> ChorusPlantBlock.WEST;
            case EAST -> ChorusPlantBlock.EAST;
        };
    }
}