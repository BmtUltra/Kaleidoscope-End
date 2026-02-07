package com.bmt.kaleidoscope_end.event;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.registry.KEItem;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber(modid = KaleidoscopeEnd.MOD_ID)
public class EndCaterpillarEvent {
    
    @SubscribeEvent
    public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getEntity();
        Entity target = event.getTarget();
        Level level = event.getLevel();

        if (target instanceof Chicken chicken && chicken.isBaby()
            && player.getMainHandItem().is(KEItem.END_CATERPILLAR_ITEM.get())) {

            chicken.setAge(0);

            if (level instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.HEART,
                        chicken.getX(),
                        chicken.getY() + 0.25,
                        chicken.getZ(),
                        5,
                        0.2, 0.1, 0.2, 0.1);

                serverLevel.playSound(null, chicken.getX(), chicken.getY(), chicken.getZ(),
                        SoundEvents.PARROT_EAT, chicken.getSoundSource(),
                        1.0F, 1.0F + (serverLevel.random.nextFloat() - serverLevel.random.nextFloat()) * 0.2F);
            }

            ItemStack mainHandItem = player.getMainHandItem();
            mainHandItem.shrink(1);

            // ModTrigger.EVENT.trigger(player, ModEventTriggerType.USE_END_CATERPILLAR_FEED_CHICKEN);

            event.setCanceled(true);
        }
    }
}