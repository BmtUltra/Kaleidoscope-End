package com.bmt.kaleidoscope_end.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class KEBlockItem extends BlockItem {

    public KEBlockItem(Block p_40565_, Properties p_40566_) {
        super(p_40565_, p_40566_);
    }

    @Override
    public String getDescriptionId() {
        return this.getOrCreateDescriptionId();
    }
}