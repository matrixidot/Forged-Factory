package me.neo.forgedfactory.recipe;

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

public class AlloyKilnRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private ItemStack output;
    private NonNullList<Ingredient> ingredient;
    private int firstIngCount;
    private int secondIngCount;
    private int outputAmount;

    public AlloyKilnRecipe(ResourceLocation id) {
        this.id = id;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if (pLevel.isClientSide()) return false;
        return (test(pContainer, 0, 0, firstIngCount) && test(pContainer, 1, 1, secondIngCount));
    }
    // Returns true if the stack matches with the stack in the slot and if the amount is the same or higher.
    private boolean test(SimpleContainer container, int ingNum,int slot, int amnt) {
        return ingredient.get(ingNum).test(container.getItem(slot)) && container.getItem(slot).getCount() >= amnt;
    }
    public int getFirstIngCount() { return firstIngCount; }
    public int getSecondIngCount() { return secondIngCount; }
    public int getOutputAmount() { return outputAmount; }

    public List<Item> getFirstInputAsList() {
        ItemStack stack = ingredient.get(0).getItems()[0];
        return Collections.singletonList(stack.getItem());
    }
    public List<Item> getSecondInputAsList() {
        ItemStack stack = ingredient.get(1).getItems()[0];
        return Collections.singletonList(stack.getItem());
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return ingredient;
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer) {
        return output;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
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
            recipe.ingredient = NonNullList.withSize(2, Ingredient.EMPTY);
            recipe.firstIngCount = GsonHelper.getAsInt(ingredientJson.get(0).getAsJsonObject(), "count");
            recipe.secondIngCount = GsonHelper.getAsInt(ingredientJson.get(1).getAsJsonObject(), "count");
            for (int i = 0; i < recipe.ingredient.size(); i++) {
                recipe.ingredient.set(i, Ingredient.fromJson(ingredientJson.get(i)));
            }
            // Output Slot
            ResourceLocation itemResourceLocation = ResourceLocation.of(GsonHelper.getAsString(json.get("output").getAsJsonObject(), "item", "minecraft:air"), ':');
            int itemAmount = GsonHelper.getAsInt(json.get("output").getAsJsonObject(), "count", 1);
            recipe.output = new ItemStack(ForgeRegistries.ITEMS.getValue(itemResourceLocation));
            recipe.outputAmount = itemAmount;


            return recipe;
        }

        @Override
        public @Nullable AlloyKilnRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            AlloyKilnRecipe recipe = new AlloyKilnRecipe(pRecipeId);
            recipe.firstIngCount = pBuffer.readByte();
            recipe.secondIngCount = pBuffer.readByte();
            recipe.output = pBuffer.readItem();
            recipe.outputAmount = pBuffer.readInt();
            return recipe;
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, AlloyKilnRecipe pRecipe) {
            pBuffer.writeByte(pRecipe.getFirstIngCount());
            pBuffer.writeByte(pRecipe.getSecondIngCount());
            pBuffer.writeItem(pRecipe.output);
            pBuffer.writeInt(pRecipe.outputAmount);

            pRecipe.ingredient.get(0).toNetwork(pBuffer);
            pRecipe.ingredient.get(1).toNetwork(pBuffer);
        }
    }
}
