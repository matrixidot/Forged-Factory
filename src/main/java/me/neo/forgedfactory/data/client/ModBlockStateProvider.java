package me.neo.forgedfactory.data.client;

import me.neo.forgedfactory.FF;
import me.neo.forgedfactory.setup.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, FF.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.OGANESSON_BLOCK.get());
        simpleBlock(ModBlocks.HYPER_RADIOACTIVE_OGANESSON_BLOCK.get());
        simpleBlock(ModBlocks.TITANIUM_BLOCK.get());
        simpleBlock(ModBlocks.TUNGSTEN_BLOCK.get());
        directionalBlock(ModBlocks.ALLOY_KILN.get(), new ModelFile.ExistingModelFile(new ResourceLocation(FF.MOD_ID, "block/alloy_kiln"), models().existingFileHelper));
    }


}
