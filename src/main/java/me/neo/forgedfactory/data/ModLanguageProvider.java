package me.neo.forgedfactory.data;

import me.neo.forgedfactory.items.CreativeModTab;
import me.neo.forgedfactory.setup.ModBlocks;
import me.neo.forgedfactory.setup.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fml.common.Mod;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(DataGenerator gen, String modid, String locale) {
        super(gen, modid, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + CreativeModTab.FORGED_FACTORY.getRecipeFolderName(), "Forged Factory");

        add(ModItems.ENTANGLED_INGOT.get(), "Entangled Ingot");

        add(ModItems.HR_OGN_INGOT.get(), "Hyper Radioactive Oganesson Ingot");
        add(ModItems.HR_OGN_NUGGET.get(), "Hyper Radioactive Oganesson Nugget");
        add(ModItems.HR_OGN_DUST.get(), "Hyper Radioactive Oganesson Dust");
        add(ModItems.HR_OGN_PLATE.get(), "Hyper Radioactive Oganesson Plate");

        add(ModItems.OGANESSON_INGOT.get(), "Oganesson Ingot");
        add(ModItems.OGANESSON_NUGGET.get(), "Oganesson Nugget");
        add(ModItems.OGANESSON_DUST.get(), "Oganesson Dust");
        add(ModItems.OGANESSON_PLATE.get(), "Oganesson Plate");

        add(ModItems.TITANIUM_INGOT.get(), "Titanium Ingot");
        add(ModItems.TITANIUM_NUGGET.get(), "Titanium Nugget");
        add(ModItems.TITANIUM_DUST.get(), "Titanium Dust");
        add(ModItems.TITANIUM_PLATE.get(), "Titanium Plate");
        add(ModItems.RAW_TITANIUM.get(), "Raw Titanium");
        add(ModItems.TITANIUM_GEAR.get(), "Titanium Gear");

        add(ModItems.COPPER_WIRE.get(), "Copper Wire");
        add(ModItems.IRON_ROD.get(), "Iron Rod");

        add(ModItems.TUNGSTEN_INGOT.get(), "Tungsten Ingot");
        add(ModItems.TUNGSTEN_NUGGET.get(), "Tungsten Nugget");
        add(ModItems.TUNGSTEN_DUST.get(), "Tungsten Dust");
        add(ModItems.TUNGSTEN_PLATE.get(), "Tungsten Plate");
        add(ModItems.TUNGSTEN_GEAR.get(), "Tungsten Gear");


        add(ModItems.BRONZE_INGOT.get(), "Bronze Ingot");
        add(ModItems.BRONZE_NUGGET.get(), "Bronze Nugget");
        add(ModItems.BRONZE_DUST.get(), "Bronze Dust");
        add(ModItems.BRONZE_PLATE.get(), "Bronze Plate");
        add(ModItems.BRONZE_GEAR.get(), "Bronze Gear");

        add(ModItems.STEEL_INGOT.get(), "Steel Ingot");
        add(ModItems.STEEL_NUGGET.get(), "Steel Nugget");
        add(ModItems.STEEL_DUST.get(), "Steel Dust");
        add(ModItems.STEEL_PLATE.get(), "Steel Plate");


        add(ModItems.COPPER_NUGGET.get(), "Copper Nugget");
        add(ModItems.COPPER_DUST.get(), "Copper Dust");
        add(ModItems.COPPER_PLATE.get(), "Copper Plate");
        add(ModItems.COPPER_GEAR.get(), "Copper Gear");
        add(ModItems.COPPER_PIPE.get(), "Copper Pipe");

        add(ModItems.TIN_INGOT.get(), "Tin Ingot");
        add(ModItems.TIN_NUGGET.get(), "Tin Nugget");
        add(ModItems.TIN_DUST.get(), "Tin Dust");
        add(ModItems.TIN_PLATE.get(), "Tin Plate");
        add(ModItems.RAW_TIN.get(), "Raw Tin");
        add(ModItems.TIN_GEAR.get(), "Tin Gear");

        add(ModItems.IRON_DUST.get(), "Iron Dust");
        add(ModItems.IRON_PLATE.get(), "Iron Plate");
        add(ModItems.CARBONATED_IRON_DUST.get(), "FeC Blend");


        // Storage Blocks
        add(ModBlocks.OGANESSON_BLOCK.get(), "Block of Oganesson");
        add(ModBlocks.TITANIUM_BLOCK.get(), "Block of Titanium");
        add(ModBlocks.TUNGSTEN_BLOCK.get(), "Block of Tungsten");
        add(ModBlocks.HYPER_RADIOACTIVE_OGANESSON_BLOCK.get(), "Block of H-R Oganesson");
        add(ModBlocks.TIN_BLOCK.get(), "Block of Tin");
        add(ModBlocks.BRONZE_BLOCK.get(), "Block of Bronze");
        add(ModBlocks.STEEL_BLOCK.get(), "Block of Steel");

        // Ores
        add(ModBlocks.TIN_ORE.get(), "Tin Ore");
        add(ModBlocks.DEEPSLATE_TIN_ORE.get(), "Deepslate Tin Ore");
        add(ModBlocks.TITANIUM_ORE.get(), "Titanium Ore");
        add(ModBlocks.DEEPSLATE_TITANIUM_ORE.get(), "Deepslate Titanium Ore");

        // Misc
        add(ModBlocks.CRUDE_CHASSIS.get(), "Crude Machine Chassis");
        add(ModBlocks.STEEL_CHASSIS.get(), "Steel Machine Chassis");
        add(ModBlocks.BRONZE_CHASSIS.get(), "Bronze Machine Chassis");
        add(ModBlocks.TUNGSTEN_CHASSIS.get(), "Tungsten Machine Chassis");
        add(ModBlocks.TITANIUM_CHASSIS.get(), "Titanium Machine Chassis");
        add(ModItems.PEBBLE.get(), "Pebble");
        add(ModItems.MACHINIST_HAMMER.get(), "Machinist's Hammer");
        add(ModItems.DIAMOND_DUST.get(), "Diamond Grit");
        add(ModItems.EMERALD_DUST.get(), "Emerald Grit");
        add(ModItems.AMETHYST_DUST.get(), "Amethyst Powder");


        // Block Entities
        add(ModBlocks.ALLOY_KILN.get(), "Alloy Kiln");
        add(ModBlocks.BRICK_SMASHER.get(), "Brick Smasher");

        // Coils
        add(ModBlocks.COPPER_COIL.get(), "Copper Coil");
    }
}
