package me.neo.forgedfactory.data;

import me.neo.forgedfactory.FF;
import me.neo.forgedfactory.setup.ModBlocks;
import me.neo.forgedfactory.setup.ModItems;
import me.neo.forgedfactory.util.BlockTagsFF;
import me.neo.forgedfactory.util.ItemTagsFF;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SmeltingRecipe;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        /* SHAPELESS RECIPES */
        ShapelessRecipeBuilder.shapeless(ModItems.HR_OGN_NUGGET.get(), 9).requires(ModItems.HR_OGN_INGOT.get())
                .unlockedBy("has_item", has(ModItems.HR_OGN_INGOT.get())).save(pFinishedRecipeConsumer, modId("h-r_ogn_i2n"));
        ShapelessRecipeBuilder.shapeless(ModItems.HR_OGN_INGOT.get(), 9).requires(ModBlocks.HYPER_RADIOACTIVE_OGANESSON_BLOCK.get())
                .unlockedBy("has_item", has(ModItems.HR_OGN_INGOT.get())).save(pFinishedRecipeConsumer, modId("h-r_ogn_b2i"));

        ShapelessRecipeBuilder.shapeless(ModItems.OGANESSON_NUGGET.get(), 9).requires(ModItems.OGANESSON_INGOT.get())
                .unlockedBy("has_item", has(ModItems.OGANESSON_INGOT.get())).save(pFinishedRecipeConsumer, modId("ogn_i2n"));
        ShapelessRecipeBuilder.shapeless(ModItems.OGANESSON_INGOT.get(), 9).requires(ModBlocks.OGANESSON_BLOCK.get())
                .unlockedBy("has_item", has(ModItems.OGANESSON_INGOT.get())).save(pFinishedRecipeConsumer, modId("ogn_b2i"));

        ShapelessRecipeBuilder.shapeless(ModItems.TITANIUM_NUGGET.get(), 9).requires(ModItems.TITANIUM_INGOT.get())
                .unlockedBy("has_item", has(ModItems.RAW_TITANIUM.get())).save(pFinishedRecipeConsumer, modId("titanium_i2n"));
        ShapelessRecipeBuilder.shapeless(ModItems.TITANIUM_INGOT.get(), 9).requires(ModBlocks.TITANIUM_BLOCK.get())
                .unlockedBy("has_item", has(ModItems.RAW_TITANIUM.get())).save(pFinishedRecipeConsumer, modId("titanium_b2i"));

        ShapelessRecipeBuilder.shapeless(ModItems.TUNGSTEN_NUGGET.get(), 9).requires(ModItems.TUNGSTEN_INGOT.get())
                .unlockedBy("has_item", has(ModItems.TUNGSTEN_INGOT.get())).save(pFinishedRecipeConsumer, modId("tungsten_i2n"));
        ShapelessRecipeBuilder.shapeless(ModItems.TUNGSTEN_INGOT.get(), 9).requires(ModBlocks.TUNGSTEN_BLOCK.get())
                .unlockedBy("has_item", has(ModItems.TUNGSTEN_INGOT.get())).save(pFinishedRecipeConsumer, modId("tungsten_b2i"));

        ShapelessRecipeBuilder.shapeless(ModItems.TIN_NUGGET.get(), 9).requires(ModItems.TIN_INGOT.get())
                .unlockedBy("has_item", has(ModItems.RAW_TIN.get())).save(pFinishedRecipeConsumer, modId("tin_i2n"));
        ShapelessRecipeBuilder.shapeless(ModItems.TIN_INGOT.get(), 9).requires(ModBlocks.TIN_BLOCK.get())
                .unlockedBy("has_item", has(ModItems.RAW_TIN.get())).save(pFinishedRecipeConsumer, modId("tin_b2i"));

        ShapelessRecipeBuilder.shapeless(ModItems.BRONZE_NUGGET.get(), 9).requires(ModItems.BRONZE_INGOT.get())
                .unlockedBy("has_item", has(ModItems.BRONZE_INGOT.get())).save(pFinishedRecipeConsumer, modId("bronze_i2n"));
        ShapelessRecipeBuilder.shapeless(ModItems.BRONZE_INGOT.get(), 9).requires(ModBlocks.BRONZE_BLOCK.get())
                .unlockedBy("has_item", has(ModItems.BRONZE_INGOT.get())).save(pFinishedRecipeConsumer, modId("bronze_b2i"));

        ShapelessRecipeBuilder.shapeless(ModItems.COPPER_NUGGET.get(), 9).requires(Items.COPPER_INGOT)
                .unlockedBy("has_item", has(Items.COPPER_INGOT)).save(pFinishedRecipeConsumer, modId("copper_i2n"));

        ShapelessRecipeBuilder.shapeless(ModItems.PEBBLE.get(), 4).requires(Items.COBBLESTONE)
                .unlockedBy("has_item", has(Items.COBBLESTONE)).save(pFinishedRecipeConsumer, modId("cobble_b2i"));
        ShapelessRecipeBuilder.shapeless(Items.COBBLESTONE, 1).requires(ModItems.PEBBLE.get(), 4)
                .unlockedBy("has_item", has(Items.COBBLESTONE)).save(pFinishedRecipeConsumer, modId("cobble_i2b"));


        /* SHAPED RECIPES */

        ShapedRecipeBuilder.shaped(ModBlocks.HYPER_RADIOACTIVE_OGANESSON_BLOCK.get(), 1).pattern("###").pattern("###").pattern("###")
                .define('#', ModItems.HR_OGN_INGOT.get())
                .unlockedBy("has_item", has(ModItems.HR_OGN_INGOT.get())).save(pFinishedRecipeConsumer, modId("h-r_ogn_i2b"));
        ShapedRecipeBuilder.shaped(ModItems.HR_OGN_INGOT.get(), 1).pattern("###").pattern("###").pattern("###")
                .define('#', ModItems.HR_OGN_NUGGET.get())
                .unlockedBy("has_item", has(ModItems.HR_OGN_INGOT.get())).save(pFinishedRecipeConsumer, modId("h-r_ogn_n2i"));

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

        ShapedRecipeBuilder.shaped(ModBlocks.TIN_BLOCK.get(), 1).pattern("###").pattern("###").pattern("###").define('#', ModItems.TIN_INGOT.get())
                .unlockedBy("has_item", has(ModItems.TIN_INGOT.get())).save(pFinishedRecipeConsumer, modId("tin_i2b"));
        ShapedRecipeBuilder.shaped(ModItems.TIN_INGOT.get(), 1).pattern("###").pattern("###").pattern("###").define('#', ModItems.TIN_NUGGET.get())
                .unlockedBy("has_item", has(ModItems.TIN_INGOT.get())).save(pFinishedRecipeConsumer, modId("tin_n2i"));

        ShapedRecipeBuilder.shaped(ModBlocks.BRONZE_BLOCK.get(), 1).pattern("###").pattern("###").pattern("###").define('#', ModItems.BRONZE_INGOT.get())
                .unlockedBy("has_item", has(ModItems.BRONZE_INGOT.get())).save(pFinishedRecipeConsumer, modId("bronze_i2b"));
        ShapedRecipeBuilder.shaped(ModItems.BRONZE_INGOT.get(), 1).pattern("###").pattern("###").pattern("###").define('#', ModItems.BRONZE_NUGGET.get())
                .unlockedBy("has_item", has(ModItems.BRONZE_INGOT.get())).save(pFinishedRecipeConsumer, modId("bronze_n2i"));

        ShapedRecipeBuilder.shaped(Items.COPPER_INGOT, 1).pattern("###").pattern("###").pattern("###").define('#', ModItems.COPPER_NUGGET.get())
                .unlockedBy("has_item", has(Items.COPPER_INGOT)).save(pFinishedRecipeConsumer, modId("copper_n2i"));

        ShapedRecipeBuilder.shaped(ModItems.COPPER_GEAR.get(), 1).pattern(" N ").pattern("NIN").pattern(" N ").define('N', ItemTagsFF.NUGGETS_COPPER)
                .define('I', Items.COPPER_INGOT).unlockedBy("has_item", has(Items.COPPER_INGOT)).save(pFinishedRecipeConsumer, modId("copper_gear"));
        ShapedRecipeBuilder.shaped(ModItems.TIN_GEAR.get(), 1).pattern(" N ").pattern("NIN").pattern(" N ").define('N', ItemTagsFF.NUGGETS_TIN)
                .define('I', ItemTagsFF.INGOTS_TIN).unlockedBy("has_item", has(ItemTagsFF.INGOTS_TIN)).save(pFinishedRecipeConsumer, modId("tin_gear"));
        ShapedRecipeBuilder.shaped(ModItems.BRONZE_GEAR.get(), 1).pattern(" N ").pattern("NIN").pattern(" N ").define('N', ItemTagsFF.NUGGETS_BRONZE)
                .define('I', ItemTagsFF.INGOTS_BRONZE)
                .unlockedBy("has_item", has(ItemTagsFF.INGOTS_BRONZE)).save(pFinishedRecipeConsumer, modId("bronze_gear"));
        ShapedRecipeBuilder.shaped(ModItems.TITANIUM_GEAR.get(), 1).pattern(" N ").pattern("NIN").pattern(" N ").define('N', ItemTagsFF.NUGGETS_TITANIUM)
                .define('I', ItemTagsFF.INGOTS_TITANIUM)
                .unlockedBy("has_item", has(ItemTagsFF.INGOTS_TITANIUM)).save(pFinishedRecipeConsumer, modId("titanium_gear"));
        ShapedRecipeBuilder.shaped(ModItems.TUNGSTEN_GEAR.get(), 1).pattern(" N ").pattern("NIN").pattern(" N ").define('N', ItemTagsFF.NUGGETS_TUNGSTEN)
                .define('I', ItemTagsFF.INGOTS_TUNGSTEN)
                .unlockedBy("has_item", has(ItemTagsFF.INGOTS_TUNGSTEN)).save(pFinishedRecipeConsumer, modId("tungsten_gear"));

        ShapedRecipeBuilder.shaped(ModBlocks.CRUDE_CHASSIS.get(), 1).pattern("PNP").pattern("AGA").pattern("PNP")
                .define('P', ModItems.PEBBLE.get()).define('N', ItemTagsFF.NUGGETS_COPPER).define('G', ItemTagsFF.GEARS_COPPER).define('A', Items.AMETHYST_SHARD)
                .unlockedBy("has_item", has(ItemTagsFF.GEARS_COPPER)).save(pFinishedRecipeConsumer, modId("crude_chassis"));

        ShapedRecipeBuilder.shaped(ModBlocks.BRONZE_CHASSIS.get(), 1).pattern("CNC").pattern("AGA").pattern("CNC")
                .define('C', ModItems.BRONZE_CASING.get()).define('N', ItemTagsFF.NUGGETS_BRONZE).define('G', ItemTagsFF.GEARS_BRONZE).define('A', Items.AMETHYST_SHARD)
                .unlockedBy("has_item", has(ItemTagsFF.GEARS_BRONZE)).save(pFinishedRecipeConsumer, modId("bronze_chassis"));
        ShapedRecipeBuilder.shaped(ModBlocks.STEEL_CHASSIS.get(), 1).pattern("PNP").pattern("AHA").pattern("PNP")
                .define('P', ItemTagsFF.PLATES_STEEL).define('N', ItemTagsFF.NUGGETS_STEEL).define('H', ModItems.MACHINIST_HAMMER.get()).define('A', Items.AMETHYST_SHARD)
                .unlockedBy("has_item", has(ModItems.MACHINIST_HAMMER.get())).save(pFinishedRecipeConsumer, modId("steel_chassis"));
        ShapedRecipeBuilder.shaped(ModBlocks.TITANIUM_CHASSIS.get(), 1).pattern("PNP").pattern("RGR").pattern("PNP")
                .define('P', ItemTagsFF.PLATES_TITANIUM).define('N', ItemTagsFF.NUGGETS_TITANIUM).define('G', ItemTagsFF.GEARS_TITANIUM).define('R', Items.REDSTONE)
                .unlockedBy("has_item", has(ItemTagsFF.GEARS_TITANIUM)).save(pFinishedRecipeConsumer, modId("titanium_chassis"));
        ShapedRecipeBuilder.shaped(ModBlocks.TUNGSTEN_CHASSIS.get(), 1).pattern("PNP").pattern("RGR").pattern("PNP")
                .define('P', ItemTagsFF.PLATES_TUNGSTEN).define('N', ItemTagsFF.NUGGETS_TUNGSTEN).define('G', ItemTagsFF.GEARS_TUNGSTEN).define('R', Items.REDSTONE)
                .unlockedBy("has_item", has(ItemTagsFF.GEARS_TUNGSTEN)).save(pFinishedRecipeConsumer, modId("tungsten_chassis"));

        ShapedRecipeBuilder.shaped(ModItems.COPPER_PIPE.get(), 6).pattern("N N").pattern("III").pattern("N N")
                .define('N', ItemTagsFF.NUGGETS_COPPER).define('I', Items.COPPER_INGOT)
                .unlockedBy("has_item", has(Items.COPPER_INGOT)).save(pFinishedRecipeConsumer, modId("copper_pipe"));

        ShapedRecipeBuilder.shaped(ModBlocks.ALLOY_KILN.get(), 1).pattern("RNR").pattern("PCP").pattern("RNR")
                .define('R', ModItems.PEBBLE.get()).define('N', ItemTagsFF.NUGGETS_COPPER).define('C', ModBlocks.CRUDE_CHASSIS.get()).define('P', ModItems.COPPER_PIPE.get())
                .unlockedBy("has_item", has(ModBlocks.CRUDE_CHASSIS.get())).save(pFinishedRecipeConsumer, modId("alloy_kiln_recipe"));
        
        ShapedRecipeBuilder.shaped(ModItems.MACHINIST_HAMMER.get(), 1).pattern(" TS").pattern(" NT").pattern("S  ")
                .define('T', ItemTagsFF.INGOTS_TIN).define('S', Items.STICK).define('N', ItemTagsFF.NUGGETS_BRONZE)
                .unlockedBy("has_item", has(ItemTagsFF.INGOTS_TIN)).save(pFinishedRecipeConsumer, modId("machinist_hammer"));

        ShapedRecipeBuilder.shaped(ModItems.BRONZE_CASING.get(), 1).pattern("   ").pattern("HIN").pattern(" NI")
                .define('H', ModItems.MACHINIST_HAMMER.get()).define('I', ItemTagsFF.INGOTS_BRONZE).define('N', ItemTagsFF.NUGGETS_BRONZE)
                .unlockedBy("has_item", has(ModItems.MACHINIST_HAMMER.get())).save(pFinishedRecipeConsumer, modId("bronze_casing"));

        /* PROCESSING RECIPES */
        // Smelting
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.TIN_ORE.get()), ModItems.TIN_INGOT.get(), .7F, 200)
                .unlockedBy("has_item", has(ModBlocks.TIN_ORE.get())).save(pFinishedRecipeConsumer, modId("o2i_tin_smelt"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.DEEPSLATE_TIN_ORE.get()), ModItems.TIN_INGOT.get(), .7F, 200)
                .unlockedBy("has_item", has(ModBlocks.DEEPSLATE_TIN_ORE.get())).save(pFinishedRecipeConsumer, modId("dso2i_tin_smelt"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.RAW_TIN.get()), ModItems.TIN_INGOT.get(), .7F, 200)
                .unlockedBy("has_item", has(ModItems.RAW_TIN.get())).save(pFinishedRecipeConsumer, modId("r2i_tin_smelt"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.TITANIUM_ORE.get()), ModItems.TITANIUM_INGOT.get(), .7F, 200)
                .unlockedBy("has_item", has(ModBlocks.TITANIUM_ORE.get())).save(pFinishedRecipeConsumer, modId("o2i_titanium_smelt"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.DEEPSLATE_TITANIUM_ORE.get()), ModItems.TITANIUM_INGOT.get(), .7F, 200)
                .unlockedBy("has_item", has(ModBlocks.DEEPSLATE_TITANIUM_ORE.get())).save(pFinishedRecipeConsumer, modId("dso2i_titanium_smelt"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.RAW_TITANIUM.get()), ModItems.TITANIUM_INGOT.get(), .7F, 200)
                .unlockedBy("has_item", has(ModItems.RAW_TITANIUM.get())).save(pFinishedRecipeConsumer, modId("r2i_titanium_smelt"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.TITANIUM_DUST.get()), ModItems.TITANIUM_INGOT.get(), .7F, 200)
                .unlockedBy("has_item", has(ModItems.TITANIUM_DUST.get())).save(pFinishedRecipeConsumer, modId("d2i_titanium_smelt"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.TIN_DUST.get()), ModItems.TIN_INGOT.get(), .7F, 200)
                .unlockedBy("has_item", has(ModItems.TIN_DUST.get())).save(pFinishedRecipeConsumer, modId("d2i_tin_smelt"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.TUNGSTEN_DUST.get()), ModItems.TUNGSTEN_INGOT.get(), .7F, 200)
                .unlockedBy("has_item", has(ModItems.TUNGSTEN_DUST.get())).save(pFinishedRecipeConsumer, modId("d2i_tungsten_smelt"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.HR_OGN_DUST.get()), ModItems.HR_OGN_INGOT.get(), .7F, 200)
                .unlockedBy("has_item", has(ModItems.HR_OGN_DUST.get())).save(pFinishedRecipeConsumer, modId("d2i_hr_ogn_smelt"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.OGANESSON_DUST.get()), ModItems.OGANESSON_INGOT.get(), .7F, 200)
                .unlockedBy("has_item", has(ModItems.OGANESSON_DUST.get())).save(pFinishedRecipeConsumer, modId("d2i_oganesson_smelt"));


        // Blasting
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.TIN_ORE.get()), ModItems.TIN_INGOT.get(), .7F, 100)
                .unlockedBy("has_item", has(ModBlocks.TIN_ORE.get())).save(pFinishedRecipeConsumer, modId("o2i_tin_blast"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.DEEPSLATE_TIN_ORE.get()), ModItems.TIN_INGOT.get(), .7F, 100)
                .unlockedBy("has_item", has(ModBlocks.DEEPSLATE_TIN_ORE.get())).save(pFinishedRecipeConsumer, modId("dso2i_tin_blast"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModItems.RAW_TIN.get()), ModItems.TIN_INGOT.get(), .7F, 100)
                .unlockedBy("has_item", has(ModItems.RAW_TIN.get())).save(pFinishedRecipeConsumer, modId("r2i_tin_blast"));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.TITANIUM_ORE.get()), ModItems.TITANIUM_INGOT.get(), .7F, 100)
                .unlockedBy("has_item", has(ModBlocks.TITANIUM_ORE.get())).save(pFinishedRecipeConsumer, modId("o2i_titanium_blast"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.DEEPSLATE_TITANIUM_ORE.get()), ModItems.TITANIUM_INGOT.get(), .7F, 100)
                .unlockedBy("has_item", has(ModBlocks.DEEPSLATE_TITANIUM_ORE.get())).save(pFinishedRecipeConsumer, modId("dso2i_titanium_blast"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModItems.RAW_TITANIUM.get()), ModItems.TITANIUM_INGOT.get(), .7F, 100)
                .unlockedBy("has_item", has(ModItems.RAW_TITANIUM.get())).save(pFinishedRecipeConsumer, modId("r2i_titanium_blast"));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModItems.TITANIUM_DUST.get()), ModItems.TITANIUM_INGOT.get(), .7F, 100)
                .unlockedBy("has_item", has(ModItems.TITANIUM_DUST.get())).save(pFinishedRecipeConsumer, modId("d2i_titanium_blast"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModItems.TIN_DUST.get()), ModItems.TIN_INGOT.get(), .7F, 100)
                .unlockedBy("has_item", has(ModItems.TIN_DUST.get())).save(pFinishedRecipeConsumer, modId("d2i_tin_blast"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModItems.TUNGSTEN_DUST.get()), ModItems.TUNGSTEN_INGOT.get(), .7F, 100)
                .unlockedBy("has_item", has(ModItems.TUNGSTEN_DUST.get())).save(pFinishedRecipeConsumer, modId("d2i_tungsten_blast"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModItems.HR_OGN_DUST.get()), ModItems.HR_OGN_INGOT.get(), .7F, 100)
                .unlockedBy("has_item", has(ModItems.HR_OGN_DUST.get())).save(pFinishedRecipeConsumer, modId("d2i_hr_ogn_blast"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModItems.OGANESSON_DUST.get()), ModItems.OGANESSON_INGOT.get(), .7F, 100)
                .unlockedBy("has_item", has(ModItems.OGANESSON_DUST.get())).save(pFinishedRecipeConsumer, modId("d2i_oganesson_blast"));


    }

    /*
     * KEY:
     * i2n = Ingot to Nuggets
     * b2i = Block To Ingots
     * i2b = Ingot To Blocks
     * n2i = Nuggets To Ingot
     * o2i = Ore to Ingot
     * dso2i = Deepslate ore to Ingot
     * r2i = Raw Material to ingot
     * d2i = Dust to Ingot
     */


    private ResourceLocation modId(String path) {
        return new ResourceLocation(FF.MOD_ID, path);
    }
}
