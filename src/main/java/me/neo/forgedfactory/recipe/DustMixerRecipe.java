package me.neo.forgedfactory.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import me.neo.forgedfactory.FF;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

public class DustMixerRecipe extends FFRecipe {
    public DustMixerRecipe(ResourceLocation id) {
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
    public static class Type implements RecipeType<DustMixerRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID = "dust_mixer_recipe";
    }
    public static class Serializer implements RecipeSerializer<DustMixerRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(FF.MOD_ID, "dust_mixer_recipe");

        @Override
        public DustMixerRecipe fromJson(ResourceLocation id, JsonObject json) {
            DustMixerRecipe recipe = new DustMixerRecipe(id);
            JsonArray ingredients = json.getAsJsonArray("ingredients");
            recipe.setIngredients(NonNullList.withSize(2, Ingredient.EMPTY));

            recipe.setIngredientCount(GsonHelper.getAsByte(ingredients.get(0).getAsJsonObject(), "count"));
            recipe.setIngredientCount(GsonHelper.getAsByte(ingredients.get(1).getAsJsonObject(), "count"));

            for (int i = 0;i < recipe.getInputs().size(); i++) {
                recipe.getInputs().set(i, Ingredient.fromJson(ingredients.get(i)));
            }
            JsonArray miscJson = json.getAsJsonArray("misc");
            recipe.setProcessingTime(GsonHelper.getAsInt(miscJson.get(0).getAsJsonObject(), "time", 100));
            recipe.setPowerUsage(GsonHelper.getAsInt(miscJson.get(1).getAsJsonObject(), "power", 0));

            ResourceLocation itemResourceLocation = ResourceLocation.of(GsonHelper.getAsString(json.get("output").getAsJsonObject(), "item", "minecraft:air"), ':');
            byte itemAmount = GsonHelper.getAsByte(json.get("output").getAsJsonObject(), "count", (byte) 1);
            recipe.setOutput(new ItemStack(ForgeRegistries.ITEMS.getValue(itemResourceLocation)));
            recipe.setOutputAmount(itemAmount);
            return recipe;
        }

        @Override
        public @Nullable DustMixerRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            DustMixerRecipe recipe = new DustMixerRecipe(pRecipeId);

            recipe.setIngredientCount(0, pBuffer.readByte());
            recipe.setIngredientCount(1, pBuffer.readByte());
            recipe.setOutput(pBuffer.readItem());
            recipe.setOutputAmount(pBuffer.readByte());
            return recipe;
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, DustMixerRecipe pRecipe) {
            pBuffer.writeByte(pRecipe.getIngredientAmount(0));
            pBuffer.writeByte(pRecipe.getIngredientAmount(1));
            pBuffer.writeItem(pRecipe.getOutput());
            pBuffer.writeByte(pRecipe.getOutputAmount());

            pRecipe.getIngredients().get(0).toNetwork(pBuffer);
            pRecipe.getIngredients().get(1).toNetwork(pBuffer);
        }
    }
}
