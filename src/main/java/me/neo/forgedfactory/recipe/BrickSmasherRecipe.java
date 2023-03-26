package me.neo.forgedfactory.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import me.neo.forgedfactory.FF;
import me.neo.forgedfactory.blocks.tiles.stone.bricksmasher.BrickSmasher;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import javax.crypto.interfaces.PBEKey;

public class BrickSmasherRecipe extends FFRecipe {
    public BrickSmasherRecipe(ResourceLocation id) {
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

    public static class Type implements RecipeType<BrickSmasherRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID = "brick_smasher_recipe";
    }

    public static class Serializer implements RecipeSerializer<BrickSmasherRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(FF.MOD_ID, "brick_smasher_recipe");

        @Override
        public BrickSmasherRecipe fromJson(ResourceLocation pRecipeId, JsonObject json) {
            BrickSmasherRecipe recipe = new BrickSmasherRecipe(pRecipeId);
            JsonArray ingredientJson = json.getAsJsonArray("ingredients");
            recipe.setIngredients(NonNullList.withSize(1, Ingredient.EMPTY));
            recipe.setIngredientCount(GsonHelper.getAsByte(ingredientJson.get(0).getAsJsonObject(), "count"));
            recipe.getInputs().set(0, Ingredient.fromJson(ingredientJson.get(0)));

            ResourceLocation itemResourceLocation = ResourceLocation.of(GsonHelper.getAsString(json.get("output").getAsJsonObject(), "item", "minecraft:air"), ':');
            byte itemAmount = GsonHelper.getAsByte(json.get("output").getAsJsonObject(), "count", (byte) 1);
            recipe.setOutput(new ItemStack(ForgeRegistries.ITEMS.getValue(itemResourceLocation)));
            recipe.setOutputAmount(itemAmount);
            return recipe;
        }

        @Override
        public @Nullable BrickSmasherRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            BrickSmasherRecipe recipe = new BrickSmasherRecipe(pRecipeId);
            recipe.setIngredientCount(0, pBuffer.readByte());
            recipe.setOutput(pBuffer.readItem());
            recipe.setOutputAmount(pBuffer.readByte());
            return recipe;
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, BrickSmasherRecipe pRecipe) {
            pBuffer.writeByte(pRecipe.getIngredientAmount(0));
            pBuffer.writeItem(pRecipe.getOutput());
            pBuffer.writeByte(pRecipe.getOutputAmount());

            pRecipe.getIngredients().get(0).toNetwork(pBuffer);
        }
    }
}
