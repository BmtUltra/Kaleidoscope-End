package com.bmt.kaleidoscope_end.data;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.registry.KEBlocks;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModBlockModelProvider extends BlockModelProvider {
    public ModBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, KaleidoscopeEnd.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        suspiciousBlock(KEBlocks.SUSPICIOUS_END_STONE);
    }

    protected void suspiciousBlock(DeferredHolder<Block, ? extends Block> holder) {
        for (int i = 0; i < 4; i++) {
            BlockModelBuilder builder = getBuilder(modLoc("block/%s_%d".formatted(holder.getId().getPath(), i)).toString());
            builder.parent(getExistingFile(mcLoc(BLOCK_FOLDER + "/cube_all")));
            builder.texture("all", modLoc("block/%s_%d".formatted(holder.getId().getPath(), i)));
        }
    }
}
