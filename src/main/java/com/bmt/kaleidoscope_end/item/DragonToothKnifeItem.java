package com.bmt.kaleidoscope_end.item;

import com.bmt.kaleidoscope_end.util.tier.DragonToothTier;
import com.github.ysbbbbbb.kaleidoscopecookery.item.KitchenKnifeItem;

public class DragonToothKnifeItem extends KitchenKnifeItem {
    private static final DragonToothTier DRAGON_TOOTH_TIER = new DragonToothTier();

    public DragonToothKnifeItem() {
        super(DRAGON_TOOTH_TIER, new Properties()
                .durability(3542)
                .fireResistant()
        );
    }
}