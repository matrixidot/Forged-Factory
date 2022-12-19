package me.neo.forgedfactory.data;


import me.neo.forgedfactory.FF;
import me.neo.forgedfactory.setup.ModBlocks;
import me.neo.forgedfactory.util.BlockTagsFF;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, FF.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.OGANESSON_BLOCK.get())
                .add(ModBlocks.HYPER_RADIOACTIVE_OGANESSON_BLOCK.get())
                .add(ModBlocks.TITANIUM_BLOCK.get())
                .add(ModBlocks.TUNGSTEN_BLOCK.get())
                .add(ModBlocks.TIN_BLOCK.get())
                .add(ModBlocks.TIN_ORE.get())
                .add(ModBlocks.DEEPSLATE_TIN_ORE.get())
                .add(ModBlocks.TITANIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_TITANIUM_ORE.get())
                .add(ModBlocks.BRONZE_BLOCK.get())
                .add(ModBlocks.BRICK_SMASHER.get())
                .add(ModBlocks.ALLOY_KILN.get());
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.OGANESSON_BLOCK.get())
                .add(ModBlocks.HYPER_RADIOACTIVE_OGANESSON_BLOCK.get())
                .add(ModBlocks.TITANIUM_BLOCK.get())
                .add(ModBlocks.TUNGSTEN_BLOCK.get())
                .add(ModBlocks.TITANIUM_ORE.get())
                .add(ModBlocks.STEEL_CHASSIS.get())
                .add(ModBlocks.STEEL_BLOCK.get())
                .add(ModBlocks.BRONZE_CHASSIS.get())
                .add(ModBlocks.TITANIUM_CHASSIS.get())
                .add(ModBlocks.TUNGSTEN_CHASSIS.get())
                .add(ModBlocks.DEEPSLATE_TITANIUM_ORE.get());
        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.TIN_BLOCK.get())
                .add(ModBlocks.TIN_ORE.get())
                .add(ModBlocks.DEEPSLATE_TIN_ORE.get())
                .add(ModBlocks.BRONZE_BLOCK.get())
                .add(ModBlocks.BRICK_SMASHER.get())
                .add(ModBlocks.CRUDE_CHASSIS.get())
                .add(ModBlocks.ALLOY_KILN.get());
        tag(Tags.Blocks.STORAGE_BLOCKS)
                .add(ModBlocks.OGANESSON_BLOCK.get())
                .add(ModBlocks.HYPER_RADIOACTIVE_OGANESSON_BLOCK.get())
                .add(ModBlocks.TITANIUM_BLOCK.get())
                .add(ModBlocks.TUNGSTEN_BLOCK.get())
                .add(ModBlocks.BRONZE_BLOCK.get())
                .add(ModBlocks.STEEL_BLOCK.get())
                .add(ModBlocks.TIN_BLOCK.get());
        tag(Tags.Blocks.ORES)
                .add(ModBlocks.TIN_ORE.get())
                .add(ModBlocks.DEEPSLATE_TIN_ORE.get())
                .add(ModBlocks.TITANIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_TITANIUM_ORE.get());

        tag(BlockTagsFF.ORES_TIN).add(ModBlocks.TIN_ORE.get());
        tag(BlockTagsFF.ORES_TITANIUM).add(ModBlocks.TIN_BLOCK.get());

        tag(BlockTagsFF.STORAGE_BLOCKS_TIN).add(ModBlocks.TIN_BLOCK.get());
        tag(BlockTagsFF.STORAGE_BLOCKS_BRONZE).add(ModBlocks.BRONZE_BLOCK.get());
        tag(BlockTagsFF.STORAGE_BLOCKS_HR_OGN).add(ModBlocks.HYPER_RADIOACTIVE_OGANESSON_BLOCK.get());
        tag(BlockTagsFF.STORAGE_BLOCKS_OGANESSON).add(ModBlocks.OGANESSON_BLOCK.get());
        tag(BlockTagsFF.STORAGE_BLOCKS_TITANIUM).add(ModBlocks.TITANIUM_BLOCK.get());
        tag(BlockTagsFF.STORAGE_BLOCKS_TUNGSTEN).add(ModBlocks.TUNGSTEN_BLOCK.get());

        tag(BlockTagsFF.CHASSIS);
        tag(BlockTagsFF.CHASSIS_CRUDE).add(ModBlocks.CRUDE_CHASSIS.get());
        tag(BlockTagsFF.CHASSIS_BRONZE).add(ModBlocks.BRONZE_CHASSIS.get());
        tag(BlockTagsFF.CHASSIS_STEEL).add(ModBlocks.STEEL_CHASSIS.get());
        tag(BlockTagsFF.CHASSIS_TITANIUM).add(ModBlocks.TITANIUM_CHASSIS.get());
        tag(BlockTagsFF.CHASSIS_TUNGSTEN).add(ModBlocks.TUNGSTEN_CHASSIS.get());
    }
}
