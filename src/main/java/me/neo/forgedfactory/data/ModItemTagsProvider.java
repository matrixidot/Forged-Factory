package me.neo.forgedfactory.data;

import me.neo.forgedfactory.FF;
import me.neo.forgedfactory.setup.ModBlocks;
import me.neo.forgedfactory.setup.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator pGenerator, BlockTagsProvider pBlockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, pBlockTagsProvider, FF.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(Tags.Items.INGOTS)
                .add(ModItems.ENTANGLED_INGOT.get())
                .add(ModItems.HR_OGN_INGOT.get())
                .add(ModItems.OGANESSON_INGOT.get())
                .add(ModItems.TITANIUM_INGOT.get())
                .add(ModItems.TIN_INGOT.get())
                .add(ModItems.TUNGSTEN_INGOT.get());
        tag(Tags.Items.STORAGE_BLOCKS)
                .add(ModBlocks.TUNGSTEN_BLOCK.get().asItem())
                .add(ModBlocks.HYPER_RADIOACTIVE_OGANESSON_BLOCK.get().asItem())
                .add(ModBlocks.TITANIUM_BLOCK.get().asItem())
                .add(ModBlocks.TIN_BLOCK.get().asItem())
                .add(ModBlocks.OGANESSON_BLOCK.get().asItem());
        tag(Tags.Items.NUGGETS)
                .add(ModItems.OGANESSON_NUGGET.get())
                .add(ModItems.HR_OGN_NUGGET.get())
                .add(ModItems.TITANIUM_NUGGET.get())
                .add(ModItems.TIN_NUGGET.get())
                .add(ModItems.TUNGSTEN_NUGGET.get());
        tag(Tags.Items.RAW_MATERIALS)
                .add(ModItems.RAW_TITANIUM.get())
                .add(ModItems.RAW_TIN.get());
    }
}
