package me.neo.forgedfactory.data;


import me.neo.forgedfactory.FF;
import me.neo.forgedfactory.regestries.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
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
                .add(ModBlocks.ALLOY_KILN.get());
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.OGANESSON_BLOCK.get())
                .add(ModBlocks.HYPER_RADIOACTIVE_OGANESSON_BLOCK.get())
                .add(ModBlocks.TITANIUM_BLOCK.get())
                .add(ModBlocks.TUNGSTEN_BLOCK.get());
        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.ALLOY_KILN.get());
        tag(Tags.Blocks.STORAGE_BLOCKS)
                .add(ModBlocks.OGANESSON_BLOCK.get())
                .add(ModBlocks.HYPER_RADIOACTIVE_OGANESSON_BLOCK.get())
                .add(ModBlocks.TITANIUM_BLOCK.get())
                .add(ModBlocks.TUNGSTEN_BLOCK.get());

    }
}
