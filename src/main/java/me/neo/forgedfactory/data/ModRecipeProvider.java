package me.neo.forgedfactory.data;

import me.neo.forgedfactory.FF;
import me.neo.forgedfactory.regestries.ModBlocks;
import me.neo.forgedfactory.regestries.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapedRecipe;

import java.security.interfaces.RSAKey;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        /* SHAPELESS RECIPES */
        ShapelessRecipeBuilder.shapeless(ModItems.HYPER_RADIOACTIVE_OGANESSON_NUGGET.get(), 9).requires(ModItems.HYPER_RADIOACTIVE_OGANESSON_INGOT.get())
                .unlockedBy("has_item", has(ModItems.HYPER_RADIOACTIVE_OGANESSON_INGOT.get())).save(pFinishedRecipeConsumer, modId("h-r_ogn_i2n"));
        ShapelessRecipeBuilder.shapeless(ModItems.HYPER_RADIOACTIVE_OGANESSON_INGOT.get(), 9).requires(ModBlocks.HYPER_RADIOACTIVE_OGANESSON_BLOCK.get())
                .unlockedBy("has_item", has(ModItems.HYPER_RADIOACTIVE_OGANESSON_INGOT.get())).save(pFinishedRecipeConsumer, modId("h-r_ogn_b2i"));

        ShapelessRecipeBuilder.shapeless(ModItems.OGANESSON_NUGGET.get(), 9).requires(ModItems.OGANESSON_INGOT.get())
                .unlockedBy("has_item", has(ModItems.OGANESSON_INGOT.get())).save(pFinishedRecipeConsumer, modId("ogn_i2n"));
        ShapelessRecipeBuilder.shapeless(ModItems.OGANESSON_INGOT.get(), 9).requires(ModBlocks.OGANESSON_BLOCK.get())
                .unlockedBy("has_item", has(ModItems.OGANESSON_INGOT.get())).save(pFinishedRecipeConsumer, modId("ogn_b2i"));

        ShapelessRecipeBuilder.shapeless(ModItems.TITANIUM_NUGGET.get(), 9).requires(ModItems.TITANIUM_INGOT.get())
                .unlockedBy("has_item", has(ModItems.TITANIUM_INGOT.get())).save(pFinishedRecipeConsumer, modId("titanium_i2n"));
        ShapelessRecipeBuilder.shapeless(ModItems.TITANIUM_INGOT.get(), 9).requires(ModBlocks.TITANIUM_BLOCK.get())
                .unlockedBy("has_item", has(ModItems.TITANIUM_INGOT.get())).save(pFinishedRecipeConsumer, modId("titanium_b2i"));

        ShapelessRecipeBuilder.shapeless(ModItems.TUNGSTEN_NUGGET.get(), 9).requires(ModItems.TUNGSTEN_INGOT.get())
                .unlockedBy("has_item", has(ModItems.TUNGSTEN_INGOT.get())).save(pFinishedRecipeConsumer, modId("tungsten_i2n"));
        ShapelessRecipeBuilder.shapeless(ModItems.TUNGSTEN_INGOT.get(), 9).requires(ModBlocks.TUNGSTEN_BLOCK.get())
                .unlockedBy("has_item", has(ModItems.TUNGSTEN_INGOT.get())).save(pFinishedRecipeConsumer, modId("tungsten_b2i"));

        /* SHAPED RECIPES */

        ShapedRecipeBuilder.shaped(ModBlocks.HYPER_RADIOACTIVE_OGANESSON_BLOCK.get(), 1).pattern("###").pattern("###").pattern("###")
                .define('#', ModItems.HYPER_RADIOACTIVE_OGANESSON_INGOT.get())
                .unlockedBy("has_item", has(ModItems.HYPER_RADIOACTIVE_OGANESSON_INGOT.get())).save(pFinishedRecipeConsumer, modId("h-r_ogn_i2b"));
        ShapedRecipeBuilder.shaped(ModItems.HYPER_RADIOACTIVE_OGANESSON_INGOT.get(), 1).pattern("###").pattern("###").pattern("###")
                .define('#', ModItems.HYPER_RADIOACTIVE_OGANESSON_NUGGET.get())
                .unlockedBy("has_item", has(ModItems.HYPER_RADIOACTIVE_OGANESSON_INGOT.get())).save(pFinishedRecipeConsumer, modId("h-r_ogn_n2i"));

        ShapedRecipeBuilder.shaped(ModBlocks.OGANESSON_BLOCK.get(), 1).pattern("###").pattern("###").pattern("###").define('#', ModItems.OGANESSON_INGOT.get())
                .unlockedBy("has_item", has(ModItems.OGANESSON_INGOT.get())).save(pFinishedRecipeConsumer, modId("ogn_i2b"));
        ShapedRecipeBuilder.shaped(ModItems.OGANESSON_INGOT.get(), 1).pattern("###").pattern("###").pattern("###").define('#', ModItems.OGANESSON_NUGGET.get())
                .unlockedBy("has_item", has(ModItems.OGANESSON_NUGGET.get())).save(pFinishedRecipeConsumer, modId("ogn_n2i"));

        ShapedRecipeBuilder.shaped(ModBlocks.TITANIUM_BLOCK.get(), 1).pattern("###").pattern("###").pattern("###").define('#', ModItems.TITANIUM_INGOT.get())
                .unlockedBy("has_item", has(ModItems.TITANIUM_INGOT.get())).save(pFinishedRecipeConsumer, modId("titanium_i2b"));
        ShapedRecipeBuilder.shaped(ModItems.TITANIUM_INGOT.get(), 1).pattern("###").pattern("###").pattern("###").define('#', ModItems.TITANIUM_NUGGET.get())
                .unlockedBy("has_item", has(ModItems.TITANIUM_NUGGET.get())).save(pFinishedRecipeConsumer, modId("titanium_n2i"));

        ShapedRecipeBuilder.shaped(ModBlocks.TUNGSTEN_BLOCK.get(), 1).pattern("###").pattern("###").pattern("###").define('#', ModItems.TUNGSTEN_INGOT.get())
                .unlockedBy("has_item", has(ModItems.TUNGSTEN_INGOT.get())).save(pFinishedRecipeConsumer, modId("tungsten_i2b"));
        ShapedRecipeBuilder.shaped(ModItems.TUNGSTEN_INGOT.get(), 1).pattern("###").pattern("###").pattern("###").define('#', ModItems.TUNGSTEN_NUGGET.get())
                .unlockedBy("has_item", has(ModItems.TUNGSTEN_NUGGET.get())).save(pFinishedRecipeConsumer, modId("tungsten_n2i"));

    }

    /*
     * KEY:
     * i2n = Ingot to Nuggets
     * b2i = Block To Ingots
     * i2b = Ingot To Blocks
     * n2i = Nuggets To Ingot
     */


    private ResourceLocation modId(String path) {
        return new ResourceLocation(FF.MOD_ID, path);
    }
}
