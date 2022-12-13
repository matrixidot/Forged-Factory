package me.neo.forgedfactory.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class BlockTagsFF {

    public static final TagKey<Block> STORAGE_BLOCKS_BRONZE = forgeTag("storage_blocks/bronze");
    public static final TagKey<Block> STORAGE_BLOCKS_HR_OGN = forgeTag("storage_blocks/hr_ogn");
    public static final TagKey<Block> STORAGE_BLOCKS_OGANESSON = forgeTag("storage_blocks/oganesson");
    public static final TagKey<Block> STORAGE_BLOCKS_TIN = forgeTag("storage_blocks/tin");
    public static final TagKey<Block> STORAGE_BLOCKS_TITANIUM = forgeTag("storage_blocks/titanium");
    public static final TagKey<Block> STORAGE_BLOCKS_TUNGSTEN = forgeTag("storage_blocks/tungsten");

    public static final TagKey<Block> ORES_TIN = forgeTag("ores/tin");
    public static final TagKey<Block> ORES_TITANIUM = forgeTag("ores/titanium");


    private static TagKey<Block> forgeTag(String name) {
        return BlockTags.create(new ResourceLocation("forge", name));
    }
}
