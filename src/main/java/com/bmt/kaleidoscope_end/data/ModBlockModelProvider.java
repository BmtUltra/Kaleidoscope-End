package com.bmt.kaleidoscope_end.data;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.registry.KEBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockModelProvider extends BlockModelProvider {
    public ModBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, KaleidoscopeEnd.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        suspiciousBlock(KEBlocks.SUSPICIOUS_END_STONE);
    }

    protected void suspiciousBlock(RegistryObject<? extends Block> registryObject) {
        for (int i = 0; i < 4; i++) {
            BlockModelBuilder builder = getBuilder(modLoc("block/%s_%d".formatted(registryObject.getId().getPath(), i)).toString());
            builder.parent(getExistingFile(mcLoc(BLOCK_FOLDER + "/cube_all")));
            builder.texture("all", modLoc("block/%s_%d".formatted(registryObject.getId().getPath(), i)));
        }
    }
}
