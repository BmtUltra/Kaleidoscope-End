package com.bmt.kaleidoscope_end.blockentity;

import com.bmt.kaleidoscope_end.init.KEBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DragonEggShellBlockEntity extends BlockEntity {
    public static final String ITEMS = "ShellItems";
    private final ItemStackHandler items = new ItemStackHandler(8);

    public DragonEggShellBlockEntity(BlockPos pos, BlockState state) {
        super(KEBlockEntities.DRAGON_EGG_SHELL.get(), pos, state);
    }

    public void putOn(ItemStack stack) {
        if (!stack.getItem().canFitInsideContainerItems()) {
            return;
        }
        ItemStack reminder = ItemHandlerHelper.insertItemStacked(this.items, stack.copy(), false);
        if (stack.getCount() != reminder.getCount()) {
            stack.shrink(stack.getCount() - reminder.getCount());
            if (this.level != null) {
                this.level.playSound(null, this.worldPosition, SoundEvents.ITEM_FRAME_ADD_ITEM, SoundSource.BLOCKS);
            }
            this.setChanged();
        }
    }

    public void takeOut(Player player) {
        for (int i = 0; i < items.getSlots(); i++) {
            ItemStack stack = items.getStackInSlot(i);
            if (!stack.isEmpty()) {
                ItemStack extractItem = items.extractItem(i, items.getSlotLimit(i), false);
                ItemHandlerHelper.giveItemToPlayer(player, extractItem);
                if (this.level != null) {
                    this.level.playSound(null, this.worldPosition, SoundEvents.ITEM_FRAME_REMOVE_ITEM, SoundSource.BLOCKS);
                }
                this.setChanged();
                return;
            }
        }
    }

    public ItemStackHandler getItems() {
        return items;
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put(ITEMS, this.items.serializeNBT());
    }

    @Override
    public @NotNull CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        tag.put(ITEMS, this.items.serializeNBT());
        return tag;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}