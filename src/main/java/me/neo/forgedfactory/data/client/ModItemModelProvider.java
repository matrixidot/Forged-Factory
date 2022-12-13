package me.neo.forgedfactory.data.client;

import me.neo.forgedfactory.FF;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

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
        withExistingParent("tin_block", modLoc("block/tin_block"));
        withExistingParent("tin_ore", modLoc("block/tin_ore"));
        withExistingParent("deepslate_tin_ore", modLoc("block/deepslate_tin_ore"));
        withExistingParent("titanium_ore", modLoc("block/titanium_ore"));
        withExistingParent("deepslate_titanium_ore", modLoc("block/deepslate_titanium_ore"));
        withExistingParent("bronze_block", modLoc("block/bronze_block"));
        withExistingParent("alloy_kiln", modLoc("block/alloy_kiln"));
        withExistingParent("brick_smasher", modLoc("block/brick_smasher"));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
        builder(itemGenerated, "entangled_ingot");
        builder(itemGenerated, "hr_ogn_ingot");
        builder(itemGenerated, "hr_ogn_nugget");
        builder(itemGenerated, "hr_ogn_dust");
        builder(itemGenerated, "hr_ogn_plate");
        builder(itemGenerated, "oganesson_ingot");
        builder(itemGenerated, "oganesson_nugget");
        builder(itemGenerated, "oganesson_dust");
        builder(itemGenerated, "oganesson_plate");
        builder(itemGenerated, "titanium_ingot");
        builder(itemGenerated, "titanium_nugget");
        builder(itemGenerated, "titanium_dust");
        builder(itemGenerated, "titanium_plate");
        builder(itemGenerated, "raw_titanium");
        builder(itemGenerated, "tungsten_ingot");
        builder(itemGenerated, "tungsten_nugget");
        builder(itemGenerated, "tungsten_dust");
        builder(itemGenerated, "tungsten_plate");
        builder(itemGenerated, "tin_ingot");
        builder(itemGenerated, "tin_nugget");
        builder(itemGenerated, "tin_dust");
        builder(itemGenerated, "tin_plate");
        builder(itemGenerated, "raw_tin");
        builder(itemGenerated, "bronze_ingot");
        builder(itemGenerated, "bronze_nugget");
        builder(itemGenerated, "bronze_dust");
        builder(itemGenerated, "bronze_plate");
        builder(itemGenerated, "copper_nugget");
        builder(itemGenerated, "copper_dust");
        builder(itemGenerated, "copper_plate");


    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}
