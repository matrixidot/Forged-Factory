package me.neo.forgedfactory.data;

import me.neo.forgedfactory.FF;
import me.neo.forgedfactory.data.client.ModBlockStateProvider;
import me.neo.forgedfactory.data.client.ModItemModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FF.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    private DataGenerators() {}
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        gen.addProvider(true, new ModBlockStateProvider(gen, existingFileHelper));
        gen.addProvider(true, new ModItemModelProvider(gen, existingFileHelper));

        ModBlockTagsProvider blockTags = new ModBlockTagsProvider(gen, existingFileHelper);
        gen.addProvider(true, blockTags);
        gen.addProvider(true, new ModItemTagsProvider(gen, blockTags, existingFileHelper));

        gen.addProvider(true, new ModLootTableProvider(gen));
        gen.addProvider(true, new ModRecipeProvider(gen));

        gen.addProvider(true, new ModLanguageProvider(gen, FF.MOD_ID, "en_us"));

    }
}
