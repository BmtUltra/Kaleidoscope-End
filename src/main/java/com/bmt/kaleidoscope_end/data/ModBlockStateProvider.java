package com.bmt.kaleidoscope_end.data;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.registry.KEBlocks;
import com.github.ysbbbbbb.kaleidoscopecookery.block.food.FoodBiteBlock;
import com.github.ysbbbbbb.kaleidoscopecookery.init.registry.FoodBiteRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CaveVinesBlock;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, KaleidoscopeEnd.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        FoodBiteRegistry.FOOD_DATA_MAP.forEach((resourceLocation, foodData) -> {
            if (resourceLocation.getNamespace().equals(KaleidoscopeEnd.MODID)) {
                Block block = ForgeRegistries.BLOCKS.getValue(resourceLocation);
                addFoodBiteBlock(block, resourceLocation);
            }
        });

        suspiciousBlock(KEBlocks.SUSPICIOUS_END_STONE);
    }

    protected void suspiciousBlock(RegistryObject<? extends Block> registryObject) {
        Block block = registryObject.get();
        VariantBlockStateBuilder builder = getVariantBuilder(block);
        builder.forAllStates(blockState -> {
            int dusted = blockState.getValue(BlockStateProperties.DUSTED);
            ResourceLocation file = modLoc("block/%s_%d".formatted(registryObject.getId().getPath(), dusted));
            return ConfiguredModel.builder().modelFile(new ModelFile.UncheckedModelFile(file)).build();
        });
    }


    protected void caveVines(RegistryObject<? extends Block> registryObject) {
        Block block = registryObject.get();
        VariantBlockStateBuilder builder = getVariantBuilder(block);
        builder.addModels(builder.partialState().with(CaveVinesBlock.BERRIES, true), ConfiguredModel.builder().modelFile(new ModelFile.UncheckedModelFile(modLoc("block/%s_berries".formatted(registryObject.getId().getPath())))).build());
        builder.addModels(builder.partialState().with(CaveVinesBlock.BERRIES, false), ConfiguredModel.builder().modelFile(new ModelFile.UncheckedModelFile(modLoc("block/%s".formatted(registryObject.getId().getPath())))).build());
    }

    protected void cropBlock(RegistryObject<? extends Block> registryObject) {
        Block block = registryObject.get();
        VariantBlockStateBuilder builder = getVariantBuilder(block);
        builder.forAllStates(blockState -> {
            int age = blockState.getValue(CropBlock.AGE);
            ResourceLocation file = modLoc("block/%s/stage%d".formatted(registryObject.getId().getPath(), age));
            return ConfiguredModel.builder().modelFile(new ModelFile.UncheckedModelFile(file)).build();
        });
    }

    public void addFoodBiteBlock(Block block, ResourceLocation id) {
        this.horizontalBlock(block, (blockState) -> {
            if (block instanceof FoodBiteBlock foodBiteBlock) {
                int bites = blockState.getValue(foodBiteBlock.getBites());
                ResourceLocation model = KaleidoscopeEnd.fromNamespaceAndPath(id.getNamespace(), "block/food/%s/%s_%d".formatted(id.getPath(), id.getPath(), bites));
                return new ModelFile.UncheckedModelFile(model);
            } else {
                throw new IllegalArgumentException("Block must be an instance of FoodBiteBlock");
            }
        });
    }
}
