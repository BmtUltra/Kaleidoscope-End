package com.bmt.kaleidoscope_end.mixins.kaleidoscope_end;

import com.bmt.kaleidoscope_end.init.KEEffects;
import com.bmt.kaleidoscope_end.init.KEEnchantments;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(method = {"getDamageAfterArmorAbsorb", "getDamageAfterMagicAbsorb"}, at = @At("HEAD"), cancellable = true)
    private void onGetDamageAfterArmorAbsorb(DamageSource damageSource, float damage, CallbackInfoReturnable<Float> cir) {
        if (damageSource.getEntity() instanceof LivingEntity living && living.hasEffect(KEEffects.VOID_EROSION.get())) {
            cir.setReturnValue(damage);
        }
    }

    @Inject(method = "jumpFromGround", at = @At("HEAD"), cancellable = true)
    private void kaleidoscope_end$voidWalkerPreventJump(CallbackInfo ci) {
        LivingEntity living = (LivingEntity) (Object) this;

        ItemStack boots = living.getItemBySlot(EquipmentSlot.FEET);
        if (boots.isEmpty()) {
            return;
        }

        int voidWalkerLevel = EnchantmentHelper.getEnchantmentLevel(KEEnchantments.VOID_WALKER.get(), living);

        if (voidWalkerLevel <= 0) {
            return;
        }

        BlockPos entityPos = BlockPos.containing(living.position().add(0, -0.3, 0));

        if (living.level().getBlockState(entityPos).isAir()) {
            ci.cancel();
        }
    }
}