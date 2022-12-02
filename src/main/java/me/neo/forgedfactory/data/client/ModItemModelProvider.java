package me.neo.forgedfactory.data.client;

import me.neo.forgedfactory.FF;
import me.neo.forgedfactory.regestries.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.Locale;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, FF.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent("hyper_radioactive_oganesson_block", modLoc("block/hyper_radioactive_oganesson_block"));
        withExistingParent("oganesson_block", modLoc("block/oganesson_block"));
        withExistingParent("titanium_block", modLoc("block/titanium_block"));
        withExistingParent("tungsten_block", modLoc("block/tungsten_block"));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
        builder(itemGenerated, "entangled_ingot");
        builder(itemGenerated, "hyper_radioactive_oganesson_ingot");
        builder(itemGenerated, "hyper_radioactive_oganesson_nugget");
        builder(itemGenerated, "oganesson_ingot");
        builder(itemGenerated, "oganesson_nugget");
        builder(itemGenerated, "titanium_ingot");
        builder(itemGenerated, "titanium_nugget");
        builder(itemGenerated, "tungsten_ingot");
        builder(itemGenerated, "tungsten_nugget");

    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}
