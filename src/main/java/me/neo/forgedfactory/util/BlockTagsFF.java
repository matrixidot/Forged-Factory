package me.neo.forgedfactory.util;

import me.neo.forgedfactory.FF;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class BlockTagsFF {

    public static final TagKey<Block> STORAGE_BLOCKS_BRONZE = forgeTag("storage_blocks/bronze");
    public static final TagKey<Block> STORAGE_BLOCKS_HR_OGN = forgeTag("storage_blocks/hr_ogn");
    public static final TagKey<Block> STORAGE_BLOCKS_OGANESSON = forgeTag("storage_blocks/oganesson");
    public static final TagKey<Block> STORAGE_BLOCKS_TIN = forgeTag("storage_blocks/tin");
    public static final TagKey<Block> STORAGE_BLOCKS_TITANIUM = forgeTag("storage_blocks/titanium");
    public static final TagKey<Block> STORAGE_BLOCKS_TUNGSTEN = forgeTag("storage_blocks/tungsten");
    public static final TagKey<Block> STORAGE_BLOCKS_STEEL = forgeTag("storage_blocks/steel");

    public static final TagKey<Block> ORES_TIN = forgeTag("ores/tin");
    public static final TagKey<Block> ORES_TITANIUM = forgeTag("ores/titanium");

    public static final TagKey<Block> CHASSIS = ffTag("chassis");

    public static final TagKey<Block> CHASSIS_CRUDE = ffTag("chassis/crude_chassis");
    public static final TagKey<Block> CHASSIS_BRONZE = ffTag("chassis/bronze_chassis");
    public static final TagKey<Block> CHASSIS_STEEL = ffTag("chassis/steel_chassis");
    public static final TagKey<Block> CHASSIS_TITANIUM = ffTag("chassis/titanium_chassis");
    public static final TagKey<Block> CHASSIS_TUNGSTEN = ffTag("chassis/tungsten_chassis");





    private static TagKey<Block> forgeTag(String name) {
        return BlockTags.create(new ResourceLocation("forge", name));
    }

    private static TagKey<Block> ffTag(String name) {
        return BlockTags.create(new ResourceLocation(FF.MOD_ID, name));
    }
}
