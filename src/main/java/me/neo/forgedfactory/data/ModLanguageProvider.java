package me.neo.forgedfactory.data;

import me.neo.forgedfactory.items.CreativeModTab;
import me.neo.forgedfactory.regestries.ModBlocks;
import me.neo.forgedfactory.regestries.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ModelFile;
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
        add(ModItems.HYPER_RADIOACTIVE_OGANESSON_INGOT.get(), "Hyper Radioactive Oganesson Ingot");
        add(ModItems.HYPER_RADIOACTIVE_OGANESSON_NUGGET.get(), "Hyper Radioactive Oganesson Nugget");
        add(ModItems.OGANESSON_INGOT.get(), "Oganesson Ingot");
        add(ModItems.OGANESSON_NUGGET.get(), "Oganesson Nugget");
        add(ModItems.TITANIUM_INGOT.get(), "Titanium Ingot");
        add(ModItems.TITANIUM_NUGGET.get(), "Titanium Nugget");
        add(ModItems.TUNGSTEN_INGOT.get(), "Tungsten Ingot");
        add(ModItems.TUNGSTEN_NUGGET.get(), "Tungsten Nugget");
        add(ModBlocks.OGANESSON_BLOCK.get(), "Block of Oganesson");
        add(ModBlocks.TITANIUM_BLOCK.get(), "Block of Titanium");
        add(ModBlocks.TUNGSTEN_BLOCK.get(), "Block of Tungsten");
        add(ModBlocks.HYPER_RADIOACTIVE_OGANESSON_BLOCK.get(), "Block of H-R Oganesson");
        add(ModBlocks.ALLOY_KILN.get(), "Alloy Kiln");
    }
}
