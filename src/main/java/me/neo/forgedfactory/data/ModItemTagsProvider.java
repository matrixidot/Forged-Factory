package me.neo.forgedfactory.data;

import me.neo.forgedfactory.FF;
import me.neo.forgedfactory.regestries.ModBlocks;
import me.neo.forgedfactory.regestries.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator pGenerator, BlockTagsProvider pBlockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, pBlockTagsProvider, FF.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(Tags.Items.INGOTS)
                .add(ModItems.ENTANGLED_INGOT.get())
                .add(ModItems.HYPER_RADIOACTIVE_OGANESSON_INGOT.get())
                .add(ModItems.OGANESSON_INGOT.get())
                .add(ModItems.TITANIUM_INGOT.get())
                .add(ModItems.TUNGSTEN_INGOT.get());
        tag(Tags.Items.STORAGE_BLOCKS)
                .add(ModBlocks.TUNGSTEN_BLOCK.get().asItem())
                .add(ModBlocks.HYPER_RADIOACTIVE_OGANESSON_BLOCK.get().asItem())
                .add(ModBlocks.TITANIUM_BLOCK.get().asItem())
                .add(ModBlocks.OGANESSON_BLOCK.get().asItem());
        tag(Tags.Items.NUGGETS)
                .add(ModItems.OGANESSON_NUGGET.get())
                .add(ModItems.HYPER_RADIOACTIVE_OGANESSON_NUGGET.get())
                .add(ModItems.TITANIUM_NUGGET.get())
                .add(ModItems.TUNGSTEN_NUGGET.get());
    }
}
