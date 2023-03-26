package me.neo.forgedfactory.util;

import me.neo.forgedfactory.recipe.AlloyKilnRecipe;
import me.neo.forgedfactory.recipe.DustMixerRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;

public class RecipeUtil {
    public static boolean isIngForAlloyKiln(Level level, ItemStack stack, int index) {
        if (stack.isEmpty()) return false;
        for (Recipe<?> recipe : level.getRecipeManager().getRecipes()) {
            if (recipe instanceof AlloyKilnRecipe) {
                if (((AlloyKilnRecipe) recipe).getIngredients().get(index).test(stack)) return true;
            }
        }
        return false;
    }

    public static boolean isIngForDustMixer(Level level, ItemStack stack, int index) {
        if (stack.isEmpty()) return false;
        for (Recipe<?> recipe : level.getRecipeManager().getRecipes()) {
            if (recipe instanceof DustMixerRecipe) {
                if (((DustMixerRecipe) recipe).getIngredients().get(index).test(stack)) return true;
            }
        }
        return false;
    }

}
