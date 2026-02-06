package com.bmt.kaleidoscope_end.registry;

import com.bmt.kaleidoscope_end.registry.soupbase.DragonBreathBucketSoupBase;
import com.github.ysbbbbbb.kaleidoscopecookery.crafting.soupbase.SoupBaseManager;

public class KESoupBases {
    public static void registerAll() {
        SoupBaseManager.registerSoupBase(new DragonBreathBucketSoupBase());
    }
}