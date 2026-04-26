package com.bmt.kaleidoscope_end.item;

import com.github.ysbbbbbb.kaleidoscopecookery.api.item.IHasContainer;
import com.github.ysbbbbbb.kaleidoscopecookery.item.FoodWithEffectsItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.items.ItemHandlerHelper;
import org.jetbrains.annotations.NotNull;

public class ShulkerShellFoodItem extends FoodWithEffectsItem implements IHasContainer {
    public ShulkerShellFoodItem(FoodProperties properties) {
        super(properties);
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity entity) {
        ItemStack itemStack = super.finishUsingItem(stack, level, entity);
        ItemStack shulkerShell = new ItemStack(Items.SHULKER_SHELL);

        if (itemStack.isEmpty()) {
            return shulkerShell;
        }

        if (entity instanceof Player player) {
            ItemHandlerHelper.giveItemToPlayer(player, shulkerShell);
        } else {
            ItemEntity itemEntity = new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), shulkerShell);
            level.addFreshEntity(itemEntity);
        }
        return itemStack;
    }

    @Override
    public Item getContainerItem() {
        return Items.SHULKER_SHELL;
    }
}