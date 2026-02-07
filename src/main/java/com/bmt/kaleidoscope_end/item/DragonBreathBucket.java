package com.bmt.kaleidoscope_end.item;


import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class DragonBreathBucket extends Item {
    @Nullable
    private static EnderDragon FAKE_DRAGON = null;

    public DragonBreathBucket(Properties properties) {
        super(properties.stacksTo(1));
    }


    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        Level level = useOnContext.getLevel();
        if (FAKE_DRAGON == null) {
            FAKE_DRAGON = EntityType.ENDER_DRAGON.create(level);
        }
        Vec3 clickLocation = useOnContext.getClickLocation();
        AreaEffectCloud areaeffectcloud = new AreaEffectCloud(level, clickLocation.x(), clickLocation.y(), clickLocation.z());
        areaeffectcloud.setParticle(ParticleTypes.DRAGON_BREATH);

        float radius = 3.0F;
        CustomData customData = useOnContext.getItemInHand().get(DataComponents.CUSTOM_DATA);
        if (customData != null) {
            radius = customData.copyTag().getFloat("radius");
        }
        
        areaeffectcloud.setRadius(radius);
        areaeffectcloud.setDuration(600);
        areaeffectcloud.setRadiusPerTick((7.0F - areaeffectcloud.getRadius()) / (float) areaeffectcloud.getDuration());
        areaeffectcloud.addEffect(new MobEffectInstance(MobEffects.HARM, 1, 1));
        areaeffectcloud.setOwner(FAKE_DRAGON);
        level.addFreshEntity(areaeffectcloud);

        Player player = useOnContext.getPlayer();
        if (player != null) {
            player.setItemInHand(useOnContext.getHand(), Items.BUCKET.getDefaultInstance());
            level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BUCKET_EMPTY, SoundSource.NEUTRAL, 1.0F, 1.0F);
        }
        return InteractionResult.SUCCESS;
    }
}