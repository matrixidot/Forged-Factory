package me.neo.forgedfactory.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ItemTagsFF {


    public static final TagKey<Item> NUGGETS_BRONZE = forgeTag("nuggets/bronze");
    public static final TagKey<Item> NUGGETS_HR_OGN = forgeTag("nuggets/hr_ogn");
    public static final TagKey<Item> NUGGETS_OGANESSON = forgeTag("nuggets/oganesson");
    public static final TagKey<Item> NUGGETS_TIN = forgeTag("nuggets/tin");
    public static final TagKey<Item> NUGGETS_COPPER = forgeTag("nuggets/copper");
    public static final TagKey<Item> NUGGETS_TITANIUM = forgeTag("nuggets/titanium");
    public static final TagKey<Item> NUGGETS_TUNGSTEN = forgeTag("nuggets/tungsten");
    public static final TagKey<Item> NUGGETS_STEEL = forgeTag("nuggets/steel");

    public static final TagKey<Item> PLATES = forgeTag("plates");

    public static final TagKey<Item> PLATES_BRONZE = forgeTag("plates/bronze");
    public static final TagKey<Item> PLATES_COPPER = forgeTag("plates/copper");
    public static final TagKey<Item> PLATES_HR_OGN = forgeTag("plates/hr_ogn");
    public static final TagKey<Item> PLATES_OGANESSON = forgeTag("plates/oganesson");
    public static final TagKey<Item> PLATES_TIN = forgeTag("plates/tin");
    public static final TagKey<Item> PLATES_TITANIUM = forgeTag("plates/titanium");
    public static final TagKey<Item> PLATES_TUNGSTEN = forgeTag("plates/tungsten");
    public static final TagKey<Item> PLATES_IRON = forgeTag("plates/iron");
    public static final TagKey<Item> PLATES_STEEL = forgeTag("plates/steel");

    public static final TagKey<Item> INGOTS_BRONZE = forgeTag("ingots/bronze");
    public static final TagKey<Item> INGOTS_ENTANGLED = forgeTag("ingots/entangled");
    public static final TagKey<Item> INGOTS_HR_OGN = forgeTag("ingots/hr_ogn");
    public static final TagKey<Item> INGOTS_OGANESSON = forgeTag("ingots/oganesson");
    public static final TagKey<Item> INGOTS_TIN = forgeTag("ingots/tin");
    public static final TagKey<Item> INGOTS_TITANIUM = forgeTag("ingots/titanium");
    public static final TagKey<Item> INGOTS_TUNGSTEN = forgeTag("ingots/tungsten");
    public static final TagKey<Item> INGOTS_STEEL = forgeTag("ingots/steel");

    public static final TagKey<Item> DUSTS_BRONZE = forgeTag("dusts/bronze");
    public static final TagKey<Item> DUSTS_COPPER = forgeTag("dusts/copper");
    public static final TagKey<Item> DUSTS_HR_OGN = forgeTag("dusts/hr_ogn");
    public static final TagKey<Item> DUSTS_OGANESSON = forgeTag("dusts/oganesson");
    public static final TagKey<Item> DUSTS_TIN = forgeTag("dusts/tin");
    public static final TagKey<Item> DUSTS_TITANIUM = forgeTag("dusts/titanium");
    public static final TagKey<Item> DUSTS_TUNGSTEN = forgeTag("dusts/tungsten");
    public static final TagKey<Item> DUSTS_STEEL = forgeTag("dusts/steel");
    public static final TagKey<Item> DUSTS_IRON = forgeTag("dusts/iron");
    public static final TagKey<Item> DUSTS_AMETHYST = forgeTag("dusts/amethyst");
    public static final TagKey<Item> DUSTS_DIAMOND = forgeTag("dusts/diamond");
    public static final TagKey<Item> DUSTS_EMERALD = forgeTag("dusts/emerald");

    public static final TagKey<Item> STORAGE_BLOCKS_BRONZE = forgeTag("storage_blocks/bronze");
    public static final TagKey<Item> STORAGE_BLOCKS_HR_OGN = forgeTag("storage_blocks/hr_ogn");
    public static final TagKey<Item> STORAGE_BLOCKS_OGANESSON = forgeTag("storage_blocks/oganesson");
    public static final TagKey<Item> STORAGE_BLOCKS_TIN = forgeTag("storage_blocks/tin");
    public static final TagKey<Item> STORAGE_BLOCKS_TITANIUM = forgeTag("storage_blocks/titanium");
    public static final TagKey<Item> STORAGE_BLOCKS_TUNGSTEN = forgeTag("storage_blocks/tungsten");
    public static final TagKey<Item> STORAGE_BLOCKS_STEEL = forgeTag("storage_blocks/steel");

    public static final TagKey<Item> GEARS = forgeTag("gears");

    public static final TagKey<Item> GEARS_BRONZE = forgeTag("gears/bronze");
    public static final TagKey<Item> GEARS_TIN = forgeTag("gears/tin");
    public static final TagKey<Item> GEARS_COPPER = forgeTag("gears/copper");
    public static final TagKey<Item> GEARS_TITANIUM = forgeTag("gears/titanium");
    public static final TagKey<Item> GEARS_TUNGSTEN = forgeTag("gears/tungsten");


    public static final TagKey<Item> ORES_TIN = forgeTag("ores/tin");
    public static final TagKey<Item> ORES_TITANIUM = forgeTag("ores/titanium");

    public static final TagKey<Item> RAW_MATERIALS_TIN = forgeTag("raw_materials/tin");
    public static final TagKey<Item> RAW_MATERIALS_TITANIUM = forgeTag("raw_materials/titanium");



    private static TagKey<Item> forgeTag(String name) {
        return ItemTags.create(new ResourceLocation("forge", name));
    }
}
