package me.neo.forgedfactory.data;

import me.neo.forgedfactory.FF;
import me.neo.forgedfactory.setup.ModBlocks;
import me.neo.forgedfactory.setup.ModItems;
import me.neo.forgedfactory.util.BlockTagsFF;
import me.neo.forgedfactory.util.ItemTagsFF;
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
                .add(ModItems.HR_OGN_INGOT.get())
                .add(ModItems.OGANESSON_INGOT.get())
                .add(ModItems.TITANIUM_INGOT.get())
                .add(ModItems.TIN_INGOT.get())
                .add(ModItems.BRONZE_INGOT.get())
                .add(ModItems.STEEL_INGOT.get())
                .add(ModItems.TUNGSTEN_INGOT.get());
        tag(Tags.Items.STORAGE_BLOCKS)
                .add(ModBlocks.TUNGSTEN_BLOCK.get().asItem())
                .add(ModBlocks.HR_OGN_BLOCK.get().asItem())
                .add(ModBlocks.TITANIUM_BLOCK.get().asItem())
                .add(ModBlocks.TIN_BLOCK.get().asItem())
                .add(ModBlocks.BRONZE_BLOCK.get().asItem())
                .add(ModBlocks.STEEL_BLOCK.get().asItem())
                .add(ModBlocks.OGANESSON_BLOCK.get().asItem());
        tag(Tags.Items.NUGGETS)
                .add(ModItems.OGANESSON_NUGGET.get())
                .add(ModItems.HR_OGN_NUGGET.get())
                .add(ModItems.TITANIUM_NUGGET.get())
                .add(ModItems.TIN_NUGGET.get())
                .add(ModItems.COPPER_NUGGET.get())
                .add(ModItems.BRONZE_NUGGET.get())
                .add(ModItems.STEEL_NUGGET.get())
                .add(ModItems.TUNGSTEN_NUGGET.get());
        tag(Tags.Items.RAW_MATERIALS)
                .add(ModItems.RAW_TITANIUM.get())
                .add(ModItems.RAW_TIN.get());

        tag(ItemTagsFF.DUSTS_BRONZE).add(ModItems.BRONZE_DUST.get());
        tag(ItemTagsFF.DUSTS_COPPER).add(ModItems.COPPER_DUST.get());
        tag(ItemTagsFF.DUSTS_HR_OGN).add(ModItems.HR_OGN_DUST.get());
        tag(ItemTagsFF.DUSTS_OGANESSON).add(ModItems.OGANESSON_DUST.get());
        tag(ItemTagsFF.DUSTS_TIN).add(ModItems.TIN_DUST.get());
        tag(ItemTagsFF.DUSTS_TITANIUM).add(ModItems.TITANIUM_DUST.get());
        tag(ItemTagsFF.DUSTS_TUNGSTEN).add(ModItems.TUNGSTEN_DUST.get());
        tag(ItemTagsFF.DUSTS_STEEL).add(ModItems.STEEL_DUST.get());
        tag(ItemTagsFF.DUSTS_DIAMOND).add(ModItems.DIAMOND_DUST.get());
        tag(ItemTagsFF.DUSTS_EMERALD).add(ModItems.EMERALD_DUST.get());
        tag(ItemTagsFF.DUSTS_IRON).add(ModItems.IRON_DUST.get());
        tag(ItemTagsFF.DUSTS_AMETHYST).add(ModItems.AMETHYST_DUST.get());

        tag(ItemTagsFF.INGOTS_BRONZE).add(ModItems.BRONZE_INGOT.get());
        tag(ItemTagsFF.INGOTS_HR_OGN).add(ModItems.HR_OGN_INGOT.get());
        tag(ItemTagsFF.INGOTS_OGANESSON).add(ModItems.OGANESSON_INGOT.get());
        tag(ItemTagsFF.INGOTS_TIN).add(ModItems.TIN_INGOT.get());
        tag(ItemTagsFF.INGOTS_TITANIUM).add(ModItems.TITANIUM_INGOT.get());
        tag(ItemTagsFF.INGOTS_TUNGSTEN).add(ModItems.TUNGSTEN_INGOT.get());
        tag(ItemTagsFF.INGOTS_ENTANGLED).add(ModItems.ENTANGLED_INGOT.get());
        tag(ItemTagsFF.INGOTS_STEEL).add(ModItems.STEEL_INGOT.get());

        tag(ItemTagsFF.PLATES);
        tag(ItemTagsFF.PLATES_BRONZE).add(ModItems.BRONZE_PLATE.get());
        tag(ItemTagsFF.PLATES_COPPER).add(ModItems.COPPER_PLATE.get());
        tag(ItemTagsFF.PLATES_HR_OGN).add(ModItems.HR_OGN_PLATE.get());
        tag(ItemTagsFF.PLATES_OGANESSON).add(ModItems.OGANESSON_PLATE.get());
        tag(ItemTagsFF.PLATES_TIN).add(ModItems.TIN_PLATE.get());
        tag(ItemTagsFF.PLATES_TITANIUM).add(ModItems.TITANIUM_PLATE.get());
        tag(ItemTagsFF.PLATES_TUNGSTEN).add(ModItems.TUNGSTEN_PLATE.get());
        tag(ItemTagsFF.PLATES_STEEL).add(ModItems.STEEL_PLATE.get());
        tag(ItemTagsFF.PLATES_IRON).add(ModItems.IRON_PLATE.get());

        tag(ItemTagsFF.NUGGETS_BRONZE).add(ModItems.BRONZE_NUGGET.get());
        tag(ItemTagsFF.NUGGETS_COPPER).add(ModItems.COPPER_NUGGET.get());
        tag(ItemTagsFF.NUGGETS_HR_OGN).add(ModItems.HR_OGN_NUGGET.get());
        tag(ItemTagsFF.NUGGETS_OGANESSON).add(ModItems.OGANESSON_NUGGET.get());
        tag(ItemTagsFF.NUGGETS_TIN).add(ModItems.TIN_NUGGET.get());
        tag(ItemTagsFF.NUGGETS_TITANIUM).add(ModItems.TITANIUM_NUGGET.get());
        tag(ItemTagsFF.NUGGETS_TUNGSTEN).add(ModItems.TUNGSTEN_NUGGET.get());
        tag(ItemTagsFF.NUGGETS_STEEL).add(ModItems.STEEL_NUGGET.get());

        tag(ItemTagsFF.RAW_MATERIALS_TIN).add(ModItems.RAW_TIN.get());
        tag(ItemTagsFF.RAW_MATERIALS_TITANIUM).add(ModItems.RAW_TITANIUM.get());

        tag(ItemTagsFF.GEARS);
        tag(ItemTagsFF.GEARS_COPPER).add(ModItems.COPPER_GEAR.get());
        tag(ItemTagsFF.GEARS_BRONZE).add(ModItems.BRONZE_GEAR.get());
        tag(ItemTagsFF.GEARS_TIN).add(ModItems.TIN_GEAR.get());
        tag(ItemTagsFF.GEARS_TITANIUM).add(ModItems.TITANIUM_GEAR.get());
        tag(ItemTagsFF.GEARS_TUNGSTEN).add(ModItems.TUNGSTEN_GEAR.get());


        copy(BlockTagsFF.STORAGE_BLOCKS_BRONZE, ItemTagsFF.STORAGE_BLOCKS_BRONZE);
        copy(BlockTagsFF.STORAGE_BLOCKS_HR_OGN, ItemTagsFF.STORAGE_BLOCKS_HR_OGN);
        copy(BlockTagsFF.STORAGE_BLOCKS_OGANESSON, ItemTagsFF.STORAGE_BLOCKS_OGANESSON);
        copy(BlockTagsFF.STORAGE_BLOCKS_TIN, ItemTagsFF.STORAGE_BLOCKS_TIN);
        copy(BlockTagsFF.STORAGE_BLOCKS_TITANIUM, ItemTagsFF.STORAGE_BLOCKS_TITANIUM);
        copy(BlockTagsFF.STORAGE_BLOCKS_TUNGSTEN, ItemTagsFF.STORAGE_BLOCKS_TUNGSTEN);
        copy(BlockTagsFF.STORAGE_BLOCKS_STEEL, ItemTagsFF.STORAGE_BLOCKS_STEEL);


        copy(BlockTagsFF.ORES_TIN, ItemTagsFF.ORES_TIN);
        copy(BlockTagsFF.ORES_TITANIUM, ItemTagsFF.ORES_TITANIUM);

    }
}
