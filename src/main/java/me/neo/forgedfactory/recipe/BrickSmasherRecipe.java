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

public class BrickSmasherRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private ItemStack output;
    private NonNullList<Ingredient> ingredient;
    private int ingredientCount;

    public BrickSmasherRecipe(ResourceLocation id) { this.id = id;}

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if (pLevel.isClientSide()) return false;
        return test(pContainer, 0, 0, ingredientCount);
    }
    private boolean test(SimpleContainer container, int ingNum,int slot, int amnt) {
        return ingredient.get(ingNum).test(container.getItem(slot)) && container.getItem(slot).getCount() >= amnt;
    }
    public int getIngredientCount() { return ingredientCount; }

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
            recipe.ingredient = NonNullList.withSize(1, Ingredient.EMPTY);
            recipe.ingredientCount = GsonHelper.getAsInt(ingredientJson.get(0).getAsJsonObject(), "count");
            recipe.ingredient.set(0, Ingredient.fromJson(ingredientJson.get(0)));

            ResourceLocation itemResourceLocation = ResourceLocation.of(GsonHelper.getAsString(json.get("output").getAsJsonObject(), "item", "minecraft:air"), ':');
            recipe.output = new ItemStack(ForgeRegistries.ITEMS.getValue(itemResourceLocation));

            return recipe;
        }

        @Override
        public @Nullable BrickSmasherRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            BrickSmasherRecipe recipe = new BrickSmasherRecipe(pRecipeId);
            recipe.ingredientCount = pBuffer.readByte();
            recipe.output = pBuffer.readItem();
            return recipe;
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, BrickSmasherRecipe pRecipe) {
            pBuffer.writeByte(pRecipe.getIngredientCount());
            pBuffer.writeItem(pRecipe.output);
            pRecipe.ingredient.get(0).toNetwork(pBuffer);
        }
    }
}
