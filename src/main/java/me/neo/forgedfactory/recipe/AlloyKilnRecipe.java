package me.neo.forgedfactory.recipe;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import me.neo.forgedfactory.FF;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AlloyKilnRecipe extends FFRecipe {

    public AlloyKilnRecipe(ResourceLocation id) {
        super(id);
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return getInputs();
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer) {
        return getOutput();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return getOutput().copy();
    }

    @Override
    public ResourceLocation getId() {
        return getRecipeID();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<AlloyKilnRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID = "alloy_kiln_recipe";
    }

    public static class Serializer implements RecipeSerializer<AlloyKilnRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(FF.MOD_ID, "alloy_kiln_recipe");

        @Override
        public AlloyKilnRecipe fromJson(ResourceLocation pRecipeId, JsonObject json) {
            AlloyKilnRecipe recipe = new AlloyKilnRecipe(pRecipeId);
            JsonArray ingredientJson = json.getAsJsonArray("ingredients");
            recipe.setIngredients(NonNullList.withSize(2, Ingredient.EMPTY));

            recipe.setIngredientCount(GsonHelper.getAsByte(ingredientJson.get(0).getAsJsonObject(), "count"));
            recipe.setIngredientCount(GsonHelper.getAsByte(ingredientJson.get(1).getAsJsonObject(), "count"));

            for (int i = 0; i < recipe.getInputs().size(); i++) {
                recipe.getInputs().set(i, Ingredient.fromJson(ingredientJson.get(i)));
            }
            JsonArray miscJson = json.getAsJsonArray("misc");
            recipe.setProcessingTime(GsonHelper.getAsInt(miscJson.get(0).getAsJsonObject(), "time", 100));
            recipe.setPowerUsage(GsonHelper.getAsInt(miscJson.get(1).getAsJsonObject(), "power", 0));

            // Output Slot
            ResourceLocation itemResourceLocation = ResourceLocation.of(GsonHelper.getAsString(json.get("output").getAsJsonObject(), "item", "minecraft:air"), ':');
            byte itemAmount = GsonHelper.getAsByte(json.get("output").getAsJsonObject(), "count", (byte) 1);
            recipe.setOutput(new ItemStack(ForgeRegistries.ITEMS.getValue(itemResourceLocation)));
            recipe.setOutputAmount(itemAmount);
            return recipe;
        }

        @Override
        public @Nullable AlloyKilnRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            AlloyKilnRecipe recipe = new AlloyKilnRecipe(pRecipeId);
            recipe.setIngredientCount(0, pBuffer.readByte());
            recipe.setIngredientCount(1, pBuffer.readByte());
            recipe.setOutput(pBuffer.readItem());
            recipe.setOutputAmount(pBuffer.readByte());
            return recipe;
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, AlloyKilnRecipe pRecipe) {
            pBuffer.writeByte(pRecipe.getIngredientAmount(0));
            pBuffer.writeByte(pRecipe.getIngredientAmount(1));
            pBuffer.writeItem(pRecipe.getOutput());
            pBuffer.writeByte(pRecipe.getOutputAmount());

            pRecipe.getIngredients().get(0).toNetwork(pBuffer);
            pRecipe.getIngredients().get(1).toNetwork(pBuffer);
        }
    }
}
