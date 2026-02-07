package com.bmt.kaleidoscope_end.data;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.registry.KEBlocks;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.ArrayList;
import java.util.List;

public class ModBlockModelProvider extends BlockModelProvider {
    public ModBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, KaleidoscopeEnd.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        List<String> cropBlocksId = new ArrayList<>();
        cropBlocksId.add("ender_mint");
        for (int i = 0; i < 8; i++) {
            for (String string : cropBlocksId) {
                cross("block/%s/stage%d".formatted(string, i), KaleidoscopeEnd.id("block/%s/stage%d".formatted(string, i))).renderType("cutout");
            }
        }

        suspiciousBlock(KEBlocks.SUSPICIOUS_END_STONE);
        cross("dream_berry_plant",KaleidoscopeEnd.id("block/dream_berry_plant")).renderType("cutout");
        cross("dream_berry_plant_berries",KaleidoscopeEnd.id("block/dream_berry_plant_berries")).renderType("cutout");

        cross("dream_berry_head",KaleidoscopeEnd.id("block/dream_berry_head")).renderType("cutout");
        cross("dream_berry_head_berries",KaleidoscopeEnd.id("block/dream_berry_head_berries")).renderType("cutout");
    }

    protected void suspiciousBlock(DeferredHolder<Block, ? extends Block> holder) {
        for (int i = 0; i < 4; i++) {
            BlockModelBuilder builder = getBuilder(modLoc("block/%s_%d".formatted(holder.getId().getPath(), i)).toString());
            builder.parent(getExistingFile(mcLoc(BLOCK_FOLDER + "/cube_all")));
            builder.texture("all", modLoc("block/%s_%d".formatted(holder.getId().getPath(), i)));
        }
    }
}
