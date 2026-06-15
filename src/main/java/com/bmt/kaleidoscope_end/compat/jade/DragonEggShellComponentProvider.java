package com.bmt.kaleidoscope_end.compat.jade;

import com.bmt.kaleidoscope_end.blockentity.DragonEggShellBlockEntity;
import com.google.common.collect.Lists;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;
import snownee.jade.api.Accessor;
import snownee.jade.api.view.ClientViewGroup;
import snownee.jade.api.view.IClientExtensionProvider;
import snownee.jade.api.view.IServerExtensionProvider;
import snownee.jade.api.view.ItemView;
import snownee.jade.api.view.ViewGroup;

import java.util.List;

public enum DragonEggShellComponentProvider implements IServerExtensionProvider<ItemStack>, IClientExtensionProvider<ItemStack, ItemView> {
    INSTANCE;

    @Override
    public List<ClientViewGroup<ItemView>> getClientGroups(Accessor<?> accessor, List<ViewGroup<ItemStack>> list) {
        return ClientViewGroup.map(list, ItemView::new, null);
    }

    @Override
    public @Nullable List<ViewGroup<ItemStack>> getGroups(Accessor<?> accessor) {
        Object target = accessor.getTarget();
        if (target instanceof DragonEggShellBlockEntity shell) {
            ItemStackHandler handler = shell.getItems();
            List<ItemStack> list = Lists.newArrayList();

            for (int i = 0; i < handler.getSlots(); ++i) {
                ItemStack stack = handler.getStackInSlot(i);
                if (!stack.isEmpty()) {
                    list.add(stack.copy());
                }
            }
            return List.of(new ViewGroup<>(list));
        } else {
            return null;
        }
    }

    @Override
    public ResourceLocation getUid() {
        return JadePlugin.DRAGON_EGG_SHELL;
    }
}