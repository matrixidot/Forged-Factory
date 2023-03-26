package me.neo.forgedfactory.data;

import me.neo.forgedfactory.FF;
import me.neo.forgedfactory.setup.ModBlocks;
import me.neo.forgedfactory.setup.ModItems;
import me.neo.forgedfactory.util.ItemTagsFF;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> recipe) {
        /* SHAPELESS RECIPES */

        storageBlock(recipe, ModItems.HR_OGN_NUGGET.get(), ModItems.HR_OGN_INGOT.get(), "hr_ogn_n");
        storageBlock(recipe, ModItems.HR_OGN_INGOT.get(), ModBlocks.HR_OGN_BLOCK.get(), "hr_ogn_b");
        storageBlock(recipe, ModItems.OGANESSON_NUGGET.get(), ModItems.OGANESSON_INGOT.get(), "ogn_n");
        storageBlock(recipe, ModItems.OGANESSON_INGOT.get(), ModBlocks.OGANESSON_BLOCK.get(), "ogn_b");
        storageBlock(recipe, ModItems.TITANIUM_NUGGET.get(), ModItems.TITANIUM_INGOT.get(), "titanium_n");
        storageBlock(recipe, ModItems.TITANIUM_INGOT.get(), ModBlocks.TITANIUM_BLOCK.get(), "titanium_b");
        storageBlock(recipe, ModItems.TUNGSTEN_NUGGET.get(), ModItems.TUNGSTEN_INGOT.get(), "tungsten_n");
        storageBlock(recipe, ModItems.TUNGSTEN_INGOT.get(), ModBlocks.TUNGSTEN_BLOCK.get(), "tungsten_b");
        storageBlock(recipe, ModItems.STEEL_NUGGET.get(), ModItems.STEEL_INGOT.get(), "steel_n");
        storageBlock(recipe, ModItems.STEEL_INGOT.get(), ModBlocks.STEEL_BLOCK.get(), "steel_b");
        storageBlock(recipe, ModItems.TIN_NUGGET.get(), ModItems.TIN_INGOT.get(), "tin_n");
        storageBlock(recipe, ModItems.TIN_INGOT.get(), ModBlocks.TIN_BLOCK.get(), "tin_b");
        storageBlock(recipe, ModItems.BRONZE_NUGGET.get(), ModItems.BRONZE_INGOT.get(), "bronze_n");
        storageBlock(recipe, ModItems.BRONZE_INGOT.get(), ModBlocks.BRONZE_BLOCK.get(), "bronze_b");
        storageBlock(recipe, ModItems.COPPER_NUGGET.get(), Items.COPPER_INGOT, "copper_n");

        ShapelessRecipeBuilder.shapeless(ModItems.PEBBLE.get(), 4).requires(Items.COBBLESTONE)
                .unlockedBy("has_item", has(Items.COBBLESTONE)).save(recipe, modId("cobble_b2i"));
        ShapelessRecipeBuilder.shapeless(Items.COBBLESTONE, 1).requires(ModItems.PEBBLE.get(), 4)
                .unlockedBy("has_item", has(Items.COBBLESTONE)).save(recipe, modId("cobble_i2b"));


        /* SHAPED RECIPES */
        // GEARS
        gear(recipe, ItemTagsFF.NUGGETS_COPPER, Items.COPPER_INGOT, ModItems.COPPER_GEAR.get(), "copper");
        gear(recipe, ItemTagsFF.NUGGETS_TIN, ItemTagsFF.INGOTS_TIN, ModItems.TIN_GEAR.get(), "tin");
        gear(recipe, ItemTagsFF.NUGGETS_BRONZE, ItemTagsFF.INGOTS_BRONZE, ModItems.BRONZE_GEAR.get(), "bronze");
        gear(recipe, ItemTagsFF.NUGGETS_TITANIUM, ItemTagsFF.INGOTS_TITANIUM, ModItems.TITANIUM_GEAR.get(), "titanium");
        gear(recipe, ItemTagsFF.NUGGETS_TUNGSTEN, ItemTagsFF.INGOTS_TUNGSTEN, ModItems.TUNGSTEN_GEAR.get(), "tungsten");

        // CHASSIS

        chassis(recipe, ModItems.PEBBLE.get(), ItemTagsFF.NUGGETS_COPPER, Items.AMETHYST_SHARD, ItemTagsFF.GEARS_COPPER, ModBlocks.CRUDE_CHASSIS.get(), "crude");
        chassis(recipe, ModItems.BRONZE_CASING.get(), ItemTagsFF.NUGGETS_BRONZE, Items.AMETHYST_SHARD, ItemTagsFF.GEARS_BRONZE, ModBlocks.BRONZE_CHASSIS.get(), "bronze");
        chassis(recipe, ItemTagsFF.PLATES_STEEL, ItemTagsFF.NUGGETS_STEEL, Items.AMETHYST_SHARD, ModItems.MACHINIST_HAMMER.get(), ModBlocks.STEEL_CHASSIS.get(), "steel");
        chassis(recipe, ItemTagsFF.PLATES_TITANIUM, ItemTagsFF.NUGGETS_TITANIUM, ItemTagsFF.GEARS_TITANIUM, ModItems.MACHINIST_HAMMER.get(), ModBlocks.TITANIUM_CHASSIS.get(), "titanium");
        chassis(recipe, ItemTagsFF.PLATES_TUNGSTEN, ItemTagsFF.NUGGETS_TUNGSTEN, ItemTagsFF.GEARS_TUNGSTEN, ModItems.MACHINIST_HAMMER.get(), ModBlocks.TUNGSTEN_CHASSIS.get(), "tungsten");

        // CASING
        casing(recipe, ItemTagsFF.INGOTS_BRONZE, ItemTagsFF.NUGGETS_BRONZE, ModItems.BRONZE_CASING.get(), "bronze");


        // MISC
        ShapedRecipeBuilder.shaped(ModItems.COPPER_PIPE.get(), 6).pattern("N N").pattern("III").pattern("N N")
                .define('N', ItemTagsFF.NUGGETS_COPPER).define('I', Items.COPPER_INGOT)
                .unlockedBy("has_item", has(Items.COPPER_INGOT)).save(recipe, modId("copper_pipe"));

        ShapedRecipeBuilder.shaped(ModBlocks.COPPER_COIL.get(), 1).pattern(" N ").pattern("NIN").pattern(" N ").define('N', ItemTagsFF.WIRES_COPPER)
                .define('I', Items.IRON_INGOT).unlockedBy("has_item", has(ItemTagsFF.WIRES_COPPER)).save(recipe, modId("copper_coil"));

        ShapedRecipeBuilder.shaped(ModItems.COPPER_WIRE.get(), 1).pattern("NN ").pattern("N N").pattern(" NN").define('N', ItemTagsFF.NUGGETS_COPPER)
                .unlockedBy("has_item", has(Items.COPPER_INGOT)).save(recipe, modId("copper_wire"));

        ShapedRecipeBuilder.shaped(ModItems.IRON_ROD.get(), 1).pattern("  I").pattern(" I ").pattern("I  ").define('I', Items.IRON_INGOT)
                .unlockedBy("has_item", has(Items.IRON_INGOT)).save(recipe, modId("iron_rod"));

        ShapedRecipeBuilder.shaped(ModBlocks.ALLOY_KILN.get(), 1).pattern("RNR").pattern("PCP").pattern("RNR")
                .define('R', ModItems.PEBBLE.get()).define('N', ItemTagsFF.NUGGETS_COPPER).define('C', ModBlocks.CRUDE_CHASSIS.get()).define('P', ModItems.COPPER_PIPE.get())
                .unlockedBy("has_item", has(ModBlocks.CRUDE_CHASSIS.get())).save(recipe, modId("alloy_kiln_recipe"));
        
        ShapedRecipeBuilder.shaped(ModItems.MACHINIST_HAMMER.get(), 1).pattern(" TS").pattern(" NT").pattern("S  ")
                .define('T', ItemTagsFF.INGOTS_TIN).define('S', Items.STICK).define('N', ItemTagsFF.NUGGETS_BRONZE)
                .unlockedBy("has_item", has(ItemTagsFF.INGOTS_TIN)).save(recipe, modId("machinist_hammer"));


        /* PROCESSING RECIPES */
        // Smelting

        smelt(recipe, ModBlocks.DEEPSLATE_TIN_ORE.get(), ModItems.TIN_INGOT.get(), .7f, 200, "dsp_tin");
        smelt(recipe, ModBlocks.TIN_ORE.get(), ModItems.TIN_INGOT.get(), .7f, 200, "ore_tin");
        smelt(recipe, ModItems.TIN_DUST.get(), ModItems.TIN_INGOT.get(), .7f, 200, "dust_tin");
        smelt(recipe, ModItems.RAW_TIN.get(), ModItems.TIN_INGOT.get(), .7f, 200, "raw_tin");

        smelt(recipe, ModBlocks.DEEPSLATE_TITANIUM_ORE.get(), ModItems.TITANIUM_INGOT.get(), .7f, 200, "dsp_titanium");
        smelt(recipe, ModBlocks.TITANIUM_ORE.get(), ModItems.TITANIUM_INGOT.get(), .7f, 200, "ore_titanium");
        smelt(recipe, ModItems.TITANIUM_DUST.get(), ModItems.TITANIUM_INGOT.get(), .7f, 200, "dust_titanium");
        smelt(recipe, ModItems.RAW_TITANIUM.get(), ModItems.TITANIUM_INGOT.get(), .7f, 200, "raw_titanium");

        smelt(recipe, ModItems.COPPER_DUST.get(), Items.COPPER_INGOT, .7f, 200, "dust_copper");
        smelt(recipe, ModItems.STEEL_DUST.get(), ModItems.STEEL_INGOT.get(), .7f, 200, "dust_steel");
        smelt(recipe, ModItems.CARBONATED_IRON_DUST.get(), ModItems.STEEL_INGOT.get(), .7f, 200, "dust_carb_iron");
        smelt(recipe, ModItems.BRONZE_DUST.get(), ModItems.BRONZE_INGOT.get(), .7f, 200, "dust_bronze");
        smelt(recipe, ModItems.TUNGSTEN_DUST.get(), ModItems.TUNGSTEN_INGOT.get(), .7f, 200, "dust_tungsten");

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

//            ShapelessRecipeBuilder.shapeless(ModItems.TUNGSTEN_NUGGET.get(), 9).requires(ModItems.TUNGSTEN_INGOT.get())
//            .unlockedBy("has_item", has(ModItems.TUNGSTEN_INGOT.get())).save(recipe, modId("tungsten_i2n"));
//        ShapelessRecipeBuilder.shapeless(ModItems.TUNGSTEN_INGOT.get(), 9).requires(ModBlocks.TUNGSTEN_BLOCK.get())
//            .unlockedBy("has_item", has(ModItems.TUNGSTEN_INGOT.get())).save(recipe, modId("tungsten_b2i"));
//    ShapedRecipeBuilder.shaped(ModBlocks.TITANIUM_BLOCK.get(), 1).pattern("###").pattern("###").pattern("###").define('#', ModItems.TITANIUM_INGOT.get())
//            .unlockedBy("has_item", has(ModItems.TITANIUM_INGOT.get())).save(recipe, modId("titanium_i2b"));
//        ShapedRecipeBuilder.shaped(ModItems.TITANIUM_INGOT.get(), 1).pattern("###").pattern("###").pattern("###").define('#', ModItems.TITANIUM_NUGGET.get())
//            .unlockedBy("has_item", has(ModItems.TITANIUM_NUGGET.get())).save(recipe, modId("titanium_n2i"));


    private void storageBlock(Consumer<FinishedRecipe> recipeConsumer, ItemLike unpacked, ItemLike packed, String name) {
        ShapelessRecipeBuilder.shapeless(unpacked, 9).requires(packed).unlockedBy(getHasName(packed), has(packed)).save(recipeConsumer, modId(name + "_unpack"));
        ShapedRecipeBuilder.shaped(packed).define('#', unpacked).pattern("###").pattern("###").pattern("###").unlockedBy(getHasName(unpacked), has(unpacked)).save(recipeConsumer, modId(name + "_pack"));
    }

    public void gear(Consumer<FinishedRecipe> finishedRecipe, TagKey<Item> nugget, TagKey<Item> ingot, ItemLike gear, String name) {
        ShapedRecipeBuilder.shaped(gear, 1).pattern(" N ").pattern("NIN").pattern(" N ").define('N', nugget)
                .define('I', ingot).unlockedBy("has_item", has(ingot)).save(finishedRecipe, modId(name + "_gear"));

    }
    public void gear(Consumer<FinishedRecipe> finishedRecipe, TagKey<Item> nugget, ItemLike ingot, ItemLike gear, String name) {
        ShapedRecipeBuilder.shaped(gear, 1).pattern(" N ").pattern("NIN").pattern(" N ").define('N', nugget)
                .define('I', ingot).unlockedBy("has_item", has(ingot)).save(finishedRecipe, modId(name + "_gear"));

    }

    public void chassis(Consumer<FinishedRecipe> finishedRecipe, TagKey corner, TagKey top, ItemLike middle, ItemLike special, ItemLike chassis, String name) {

        ShapedRecipeBuilder.shaped(chassis, 1).pattern("CTC").pattern("MSM").pattern("CTC")
                .define('C', corner).define('T', top).define('M', middle).define('S', special)
                .unlockedBy("has_item", has(special)).save(finishedRecipe, modId(name + "_chassis"));
    }
    public void chassis(Consumer<FinishedRecipe> finishedRecipe, ItemLike corner, TagKey top, ItemLike middle, TagKey special, ItemLike chassis, String name) {

        ShapedRecipeBuilder.shaped(chassis, 1).pattern("CTC").pattern("MSM").pattern("CTC")
                .define('C', corner).define('T', top).define('M', middle).define('S', special)
                .unlockedBy("has_item", has(special)).save(finishedRecipe, modId(name + "_chassis"));
    }
    public void chassis(Consumer<FinishedRecipe> finishedRecipe, TagKey corner, TagKey top, TagKey middle, ItemLike special, ItemLike chassis, String name) {

        ShapedRecipeBuilder.shaped(chassis, 1).pattern("CTC").pattern("MSM").pattern("CTC")
                .define('C', corner).define('T', top).define('M', middle).define('S', special)
                .unlockedBy("has_item", has(special)).save(finishedRecipe, modId(name + "_chassis"));
    }
    //    public void chassis(Consumer<FinishedRecipe> finishedRecipe, ItemLike corner, ItemLike top, ItemLike middle, ItemLike special, ItemLike chassis, String name) {
//
//        ShapedRecipeBuilder.shaped(chassis, 1).pattern("CTC").pattern("MSM").pattern("CTC")
//                .define('C', corner).define('T', top).define('M', middle).define('S', special)
//                .unlockedBy("has_item", has(special)).save(finishedRecipe, modId(name + "_chassis"));
//    }
//    public void chassis(Consumer<FinishedRecipe> finishedRecipe, ItemLike corner, TagKey top, ItemLike middle, ItemLike special, ItemLike chassis, String name) {
//
//        ShapedRecipeBuilder.shaped(chassis, 1).pattern("CTC").pattern("MSM").pattern("CTC")
//                .define('C', corner).define('T', top).define('M', middle).define('S', special)
//                .unlockedBy("has_item", has(special)).save(finishedRecipe, modId(name + "_chassis"));
//    }
//    public void chassis(Consumer<FinishedRecipe> finishedRecipe, TagKey corner, ItemLike top, ItemLike middle, ItemLike special, ItemLike chassis, String name) {
//
//        ShapedRecipeBuilder.shaped(chassis, 1).pattern("CTC").pattern("MSM").pattern("CTC")
//                .define('C', corner).define('T', top).define('M', middle).define('S', special)
//                .unlockedBy("has_item", has(special)).save(finishedRecipe, modId(name + "_chassis"));
//    }
//    public void chassis(Consumer<FinishedRecipe> finishedRecipe, ItemLike corner, TagKey top, TagKey middle, ItemLike special, ItemLike chassis, String name) {
//
//        ShapedRecipeBuilder.shaped(chassis, 1).pattern("CTC").pattern("MSM").pattern("CTC")
//                .define('C', corner).define('T', top).define('M', middle).define('S', special)
//                .unlockedBy("has_item", has(special)).save(finishedRecipe, modId(name + "_chassis"));
//    }
//    public void chassis(Consumer<FinishedRecipe> finishedRecipe, TagKey corner, ItemLike top, TagKey middle, ItemLike special, ItemLike chassis, String name) {
//
//        ShapedRecipeBuilder.shaped(chassis, 1).pattern("CTC").pattern("MSM").pattern("CTC")
//                .define('C', corner).define('T', top).define('M', middle).define('S', special)
//                .unlockedBy("has_item", has(special)).save(finishedRecipe, modId(name + "_chassis"));
//    }
//    public void chassis(Consumer<FinishedRecipe> finishedRecipe, TagKey corner, ItemLike top, TagKey middle, TagKey special, ItemLike chassis, String name) {
//
//        ShapedRecipeBuilder.shaped(chassis, 1).pattern("CTC").pattern("MSM").pattern("CTC")
//                .define('C', corner).define('T', top).define('M', middle).define('S', special)
//                .unlockedBy("has_item", has(special)).save(finishedRecipe, modId(name + "_chassis"));
//    }

    public void casing(Consumer<FinishedRecipe> finishedRecipe, TagKey<Item> ingot, TagKey<Item> nugget, ItemLike casing, String name) {
        ShapedRecipeBuilder.shaped(casing, 1).pattern("   ").pattern("HIN").pattern(" NI")
                .define('H', ModItems.MACHINIST_HAMMER.get()).define('I', ingot).define('N', nugget)
                .unlockedBy("has_item", has(ModItems.MACHINIST_HAMMER.get())).save(finishedRecipe, modId(name + "_casing"));
    }

    public void smelt(Consumer<FinishedRecipe> finishedRecipe, ItemLike in, ItemLike out, float exp, int time, String name) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(in), out, exp, time)
                .unlockedBy("has_item", has(in)).save(finishedRecipe, modId(name + "_smelt"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(in), out, exp, time/2)
                .unlockedBy("has_item", has(in)).save(finishedRecipe, modId(name + "_blast"));
    }


    private ResourceLocation modId(String path) {
        return new ResourceLocation(FF.MOD_ID, path);
    }
}
