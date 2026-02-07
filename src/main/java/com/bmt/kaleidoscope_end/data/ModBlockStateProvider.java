package com.bmt.kaleidoscope_end.data;

import com.bmt.kaleidoscope_end.KaleidoscopeEnd;
import com.bmt.kaleidoscope_end.registry.KEBlocks;
import com.github.ysbbbbbb.kaleidoscopecookery.block.food.FoodBiteBlock;
import com.github.ysbbbbbb.kaleidoscopecookery.init.registry.FoodBiteRegistry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CaveVinesBlock;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.VariantBlockStateBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, KaleidoscopeEnd.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        FoodBiteRegistry.FOOD_DATA_MAP.forEach((resourceLocation, foodData) -> {
            if (resourceLocation.getNamespace().equals(KaleidoscopeEnd.MOD_ID)) {
                Block block = BuiltInRegistries.BLOCK.get(resourceLocation);
                addFoodBiteBlock(block, resourceLocation);
            }
        });

        suspiciousBlock(KEBlocks.SUSPICIOUS_END_STONE);
        suspiciousBlock(KEBlocks.SUSPICIOUS_DRAGON_EGG);

        cropBlock(KEBlocks.ENDER_MINT);
        caveVines(KEBlocks.DREAM_BERRY_PLANT);
        caveVines(KEBlocks.DREAM_BERRY_HEAD);
    }

    protected void suspiciousBlock(DeferredHolder<Block, ? extends Block> holder) {
        Block block = holder.get();
        VariantBlockStateBuilder builder = getVariantBuilder(block);
        builder.forAllStates(blockState -> {
            int dusted = blockState.getValue(BlockStateProperties.DUSTED);
            ResourceLocation file;
            if (holder == KEBlocks.SUSPICIOUS_DRAGON_EGG) {
                file = mcLoc("block/dragon_egg");
            } else {
                file = modLoc("block/%s_%d".formatted(holder.getId().getPath(), dusted));
            }
            return ConfiguredModel.builder().modelFile(new ModelFile.UncheckedModelFile(file)).build();
        });
    }

    protected void caveVines(DeferredHolder<Block, ? extends Block> holder) {
        Block block = holder.get();
        VariantBlockStateBuilder builder = getVariantBuilder(block);
        builder.addModels(builder.partialState().with(CaveVinesBlock.BERRIES, true), ConfiguredModel.builder().modelFile(new ModelFile.UncheckedModelFile(modLoc("block/%s_berries".formatted(holder.getId().getPath())))).build());
        builder.addModels(builder.partialState().with(CaveVinesBlock.BERRIES, false), ConfiguredModel.builder().modelFile(new ModelFile.UncheckedModelFile(modLoc("block/%s".formatted(holder.getId().getPath())))).build());
    }

    protected void cropBlock(DeferredHolder<Block, ? extends Block> holder) {
        Block block = holder.get();
        VariantBlockStateBuilder builder = getVariantBuilder(block);
        builder.forAllStates(blockState -> {
            int age = blockState.getValue(CropBlock.AGE);
            ResourceLocation file = modLoc("block/%s/stage%d".formatted(holder.getId().getPath(), age));
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
