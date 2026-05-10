package com.bmt.kaleidoscope_end.mixins.kaleidoscope_end;

import com.bmt.kaleidoscope_end.init.KEItem;
import com.bmt.kaleidoscope_end.init.KETags;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.EnchantmentMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(EnchantmentMenu.class)
public abstract class EnchantmentMenuMixin {
    @Shadow
    protected abstract List<EnchantmentInstance> getEnchantmentList(RegistryAccess registryAccess, ItemStack stack, int slot, int cost);

    @Shadow
    @Final
    private RandomSource random;

    @Shadow
    @Final
    private Container enchantSlots;

    @Unique
    private boolean kaleidoscope$calling = false;

    @Inject(method = "getEnchantmentList", at = @At("RETURN"), cancellable = true)
    @SuppressWarnings("deprecation")
    private void modifyEnchantments(RegistryAccess registryAccess, ItemStack stack, int slot, int cost, CallbackInfoReturnable<List<EnchantmentInstance>> cir) {

        if (kaleidoscope$calling) return;

        ItemStack item = this.enchantSlots.getItem(1);
        if (!item.is(KEItem.VOID_CONCH.get())) {
            return;
        }

        kaleidoscope$calling = true;

        List<EnchantmentInstance> olds = new ArrayList<>(cir.getReturnValue());
        List<EnchantmentInstance> news = getEnchantmentList(registryAccess, stack, slot + 1, cost);
        List<EnchantmentInstance> toAdd = new ArrayList<>();

        for (EnchantmentInstance newEnchant : news) {
            boolean found = false;
            for (int j = 0; j < olds.size(); j++) {
                EnchantmentInstance oldEnchant = olds.get(j);
                if (oldEnchant.enchantment.equals(newEnchant.enchantment)) {
                    found = true;
                    if (newEnchant.level > oldEnchant.level) {
                        olds.set(j, newEnchant);
                    } else if (newEnchant.level == oldEnchant.level) {
                        olds.set(j, new EnchantmentInstance(newEnchant.enchantment, newEnchant.level + 1));
                    }
                    break;
                }
            }

            if (!found) {
                boolean compatible = true;
                for (EnchantmentInstance oldEnchant : olds) {
                    if (!Enchantment.areCompatible(newEnchant.enchantment, oldEnchant.enchantment)) {
                        compatible = false;
                        break;
                    }
                }
                if (compatible) {
                    toAdd.add(newEnchant);
                }
            }
        }
        olds.addAll(toAdd);

        if (random.nextFloat() <= 0.6F) {
            var enchantmentRegistry = registryAccess.registryOrThrow(Registries.ENCHANTMENT);
            enchantmentRegistry.getTag(KETags.Enchantments.KE_ENCHANTMENTS).ifPresent(holders -> {
                List<Holder<Enchantment>> compatibleHolders = holders.stream()
                        .filter(holder -> {
                            Enchantment enchantment = holder.value();
                            if (!enchantment.canEnchant(stack)) {
                                return false;
                            }
                            for (EnchantmentInstance oldEnchant : olds) {
                                if (!Enchantment.areCompatible(holder, oldEnchant.enchantment)) {
                                    return false;
                                }
                            }
                            return true;
                        })
                        .toList();

                if (!compatibleHolders.isEmpty()) {
                    Holder<Enchantment> holder = compatibleHolders.get(random.nextInt(compatibleHolders.size()));

                    int add = 1;
                    int maxLevel = holder.value().getMaxLevel();
                    for (int i = 1; i <= maxLevel; i++) {
                        if (holder.value().getMinCost(i) > cost) {
                            maxLevel = i - 1;
                            break;
                        }
                    }

                    if (maxLevel >= 1) {
                        int total = 0;
                        for (int i = 1; i <= maxLevel; i++) {
                            total = total + i + add;
                        }
                        int nextInt = 1 + random.nextInt(total);
                        for (int i = 1; i <= maxLevel; i++) {
                            nextInt = nextInt - (i + add);
                            if (nextInt <= 0) {
                                olds.add(new EnchantmentInstance(holder, i));
                                break;
                            }
                        }
                    }
                }
            });
        }
        kaleidoscope$calling = false;
        cir.setReturnValue(olds);
    }

    @Unique
    private static final TagKey<Item> EXTRA_FUEL =
            TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("neoforge", "enchanting_fuels"));

    @Redirect(
            method = "quickMoveStack",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"
            )
    )
    private boolean kaleidoscope$shiftMove(ItemStack stack, Item item) {
        if (stack.is(item)) return true;
        return stack.is(EXTRA_FUEL);
    }
}