package com.bmt.kaleidoscope_end.data;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.registry.KEBlocks;
import com.bmt.kaleidoscope_nether.KaleidoscopeNether;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public class ModBlockModelProvider extends BlockModelProvider {
    public ModBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, KaleidoscopeEnd.MODID, existingFileHelper);
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

    protected void suspiciousBlock(RegistryObject<? extends Block> registryObject) {
        for (int i = 0; i < 4; i++) {
            BlockModelBuilder builder = getBuilder(modLoc("block/%s_%d".formatted(registryObject.getId().getPath(), i)).toString());
            builder.parent(getExistingFile(mcLoc(BLOCK_FOLDER + "/cube_all")));
            builder.texture("all", modLoc("block/%s_%d".formatted(registryObject.getId().getPath(), i)));
        }
    }
}
