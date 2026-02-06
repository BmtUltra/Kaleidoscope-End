package com.bmt.kaleidoscope_end.mixins.kaleidoscope_end;

import com.bmt.kaleidoscope_end.registry.KEItem;
import com.bmt.kaleidoscope_end.registry.KETags;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.EnchantmentMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import java.util.ArrayList;
import java.util.List;

@Mixin(EnchantmentMenu.class)
public abstract class EnchantmentMenuMixin {
    @Shadow
    protected abstract List<EnchantmentInstance> getEnchantmentList(ItemStack p_39472_, int p_39473_, int p_39474_);


    @Shadow
    @Final
    private RandomSource random;

    @Shadow
    @Final
    private Container enchantSlots;


    @Shadow
    @Final
    public int[] costs;

    @WrapOperation(method = "lambda$clickMenuButton$1", at = @At(remap = false,value = "INVOKE", target = "Lnet/minecraft/world/inventory/EnchantmentMenu;getEnchantmentList(Lnet/minecraft/world/item/ItemStack;II)Ljava/util/List;"))
    private List<EnchantmentInstance> modifyEnchantments(EnchantmentMenu instance, ItemStack itemStack, int seed, int cost, Operation<List<EnchantmentInstance>> original, @Local(argsOnly = true) Player player) {
        List<EnchantmentInstance> olds = original.call(instance, itemStack, seed, cost);
        ItemStack item = this.enchantSlots.getItem(1);
        if (item.is(KEItem.VOID_CONCH.get())) {
            List<EnchantmentInstance> news = getEnchantmentList(itemStack, seed + 1, cost);
            List<EnchantmentInstance> toAdd = new ArrayList<>();
            for (int i = 0; i < news.size(); i++) {
                EnchantmentInstance e1 = news.get(i);
                for (int j = 0; j < olds.size(); j++) {
                    EnchantmentInstance e2 = olds.get(j);
                    if (e2.enchantment == e1.enchantment) {
                        if (e1.level > e2.level) {
                            olds.set(j, e1);
                        } else if (e1.level == e2.level) {
                            olds.set(j, new EnchantmentInstance(e1.enchantment, e1.level + 1));
                        }
                    }
                }

                if (i == news.size() - 1) {
                    boolean compatible = true;
                    for (EnchantmentInstance old : olds) {
                        if (!e1.enchantment.isCompatibleWith(old.enchantment)) {
                            compatible = false;
                            break;
                        }
                    }
                    if (compatible) {
                        toAdd.add(e1);
                    }
                }
            }

            olds.addAll(toAdd);

            if (random.nextFloat() <= 0.6F) {
                player.level().registryAccess().lookupOrThrow(ForgeRegistries.ENCHANTMENTS.getRegistryKey()).get(KETags.Enchantments.KE_ENCHANTMENTS).ifPresent(holders -> {
                    List<Holder<Enchantment>> list = holders.stream().filter(holder -> holder.value().canEnchant(itemStack)).toList();
                    if (list.isEmpty()) {
                        return;
                    }
                    Holder<Enchantment> holder = list.get(random.nextInt(list.size()));


                    int add = 1;
                    int maxLevel = holder.value().getMaxLevel();
                    for (int i = 1; i <= maxLevel; i++) {
                        if (holder.value().getMinCost(i) > cost) {
                            maxLevel = maxLevel - 1;
                            break;
                        }
                    }
                    int total = 0;
                    for (int i = 1; i <= maxLevel; i++) {
                        total = total + i + add;
                    }
                    int nextInt = 1 + random.nextInt(total);
                    for (int i = 1; i <= maxLevel; i++) {
                        nextInt = nextInt - (i + add);
                        if (nextInt <= 0) {
                            olds.add(new EnchantmentInstance(holder.get(), i));
                            break;
                        }
                    }
                });
            }

        }

        return olds;
    }
}
