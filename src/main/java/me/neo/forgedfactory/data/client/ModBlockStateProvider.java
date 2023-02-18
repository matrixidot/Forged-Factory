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
        simpleBlock(ModBlocks.HR_OGN_BLOCK.get());
        simpleBlock(ModBlocks.TITANIUM_BLOCK.get());
        simpleBlock(ModBlocks.TUNGSTEN_BLOCK.get());
        simpleBlock(ModBlocks.TIN_BLOCK.get());
        simpleBlock(ModBlocks.TIN_ORE.get());
        simpleBlock(ModBlocks.DEEPSLATE_TIN_ORE.get());
        simpleBlock(ModBlocks.TITANIUM_ORE.get());
        simpleBlock(ModBlocks.DEEPSLATE_TITANIUM_ORE.get());
        simpleBlock(ModBlocks.BRONZE_BLOCK.get());
        simpleBlock(ModBlocks.CRUDE_CHASSIS.get());
        simpleBlock(ModBlocks.BRONZE_CHASSIS.get());
        simpleBlock(ModBlocks.STEEL_CHASSIS.get());
        simpleBlock(ModBlocks.STEEL_BLOCK.get());
        simpleBlock(ModBlocks.TITANIUM_CHASSIS.get());
        simpleBlock(ModBlocks.TUNGSTEN_CHASSIS.get());


        horizontalBlock(ModBlocks.ALLOY_KILN.get(), new ModelFile.ExistingModelFile(new ResourceLocation(FF.MOD_ID, "block/alloy_kiln"), models().existingFileHelper));
        horizontalBlock(ModBlocks.BRICK_SMASHER.get(), new ModelFile.ExistingModelFile(new ResourceLocation(FF.MOD_ID, "block/alloy_kiln"), models().existingFileHelper));
        horizontalBlock(ModBlocks.DUST_MIXER.get(), new ModelFile.ExistingModelFile(new ResourceLocation(FF.MOD_ID, "block/alloy_kiln"), models().existingFileHelper));
    }


}
