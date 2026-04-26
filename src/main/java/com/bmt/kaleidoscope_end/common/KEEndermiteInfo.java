package com.bmt.kaleidoscope_end.common;

import com.bmt.kaleidoscope_end.api.IEndermiteExtension;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.util.INBTSerializable;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("all")
public class KEEndermiteInfo implements INBTSerializable<CompoundTag> {
    private final Endermite endermite;
    public boolean fed = false;
    public int inLove = 0;
    public int loveTime = 0;
    public int cooldown = 0;

    public boolean isInLove() {
        return inLove > 0;
    }

    public KEEndermiteInfo(Endermite endermite) {
        this.endermite = endermite;
    }

    @Override
    public CompoundTag serializeNBT(HolderLookup.Provider provider) {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putBoolean("fed", fed);
        compoundTag.putInt("inLove", inLove);
        return compoundTag;
    }

    @Override
    public void deserializeNBT(HolderLookup.Provider provider, CompoundTag nbt) {
        fed = nbt.getBoolean("fed");
        inLove = nbt.getInt("inLove");
    }

    public CompoundTag serializeNBT() {
        return serializeNBT(null);
    }

    public void deserializeNBT(CompoundTag nbt) {
        deserializeNBT(null, nbt);
    }

    public void aiStep() {
        if (!endermite.level().isClientSide) {
            if (isInLove()) {
                findValidBreedPartner(endermite).ifPresent(target -> {
                    endermite.getNavigation().moveTo(target, 1);
                    endermite.lookAt(target, 30, 30);
                    ++this.loveTime;
                    if (this.loveTime >= 60 && endermite.distanceToSqr(target) < 9.0D) {
                        Entity entity = endermite.getType().create(endermite.level());
                        if (entity != null) {
                            entity.setPos(endermite.getPosition(1));
                            endermite.level().addFreshEntity(entity);

                            KEEndermiteInfo info = IEndermiteExtension.getInfo(target);
                            info.cooldown = 6000;
                            info.inLove = 0;
                            info.loveTime = 0;
                            inLove = 0;
                            loveTime = 0;
                            cooldown = 6000;
                        }
                    }
                });
            }
            RandomSource random = endermite.getRandom();
            Level level = endermite.level();
            if (this.inLove > 0) {
                --this.inLove;
                if (this.inLove % 10 == 0) {
                    double d0 = random.nextGaussian() * 0.02D;
                    double d1 = random.nextGaussian() * 0.02D;
                    double d2 = random.nextGaussian() * 0.02D;
                    level.addParticle(ParticleTypes.HEART, endermite.getRandomX(1.0D), endermite.getRandomY() + 0.5D, endermite.getRandomZ(1.0D), d0, d1, d2);
                }
            }
        }
        cooldown = Math.max(0, cooldown - 1);
    }

    public void setInLove(@Nullable Player player) {
        if (cooldown <= 0) {
            this.inLove = 600;
            this.fed = true;
            burstLoveParticle(endermite);
            endermite.setPersistenceRequired();
        }
    }

    public void burstLoveParticle(Endermite endermite) {
        if (!endermite.level().isClientSide) {
            RandomSource random = endermite.getRandom();
            for (int i = 0; i < 7; ++i) {
                double d0 = random.nextGaussian() * 0.02D;
                double d1 = random.nextGaussian() * 0.02D;
                double d2 = random.nextGaussian() * 0.02D;
                ((ServerLevel) endermite.level()).sendParticles(ParticleTypes.HEART, endermite.getRandomX(1.0D), endermite.getRandomY() + 0.5D, endermite.getRandomZ(1.0D), 1, d0, d1, d2, 1);
            }
        }
    }

    private Optional<Endermite> findValidBreedPartner(Endermite endermite) {
        List<Endermite> nearbyEndermites = endermite.level().getEntitiesOfClass(
                Endermite.class,
                endermite.getBoundingBox().inflate(8.0D),
                other -> other != endermite && other.isAlive()
        );
        return nearbyEndermites.stream()
                .filter(other -> {
                    KEEndermiteInfo info = IEndermiteExtension.getInfo(other);
                    return info.isInLove();
                })
                .findFirst();
    }
}