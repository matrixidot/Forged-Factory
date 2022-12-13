package me.neo.forgedfactory.util;

import me.neo.forgedfactory.recipe.AlloyKilnRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;

public class RecipeUtil {
    public static boolean isFirstIngForAlloyKiln(Level level, ItemStack stack) {
        if (stack.isEmpty()) return false;
        for (Recipe<?> recipe : level.getRecipeManager().getRecipes()) {
            if (recipe instanceof AlloyKilnRecipe) {
                if (((AlloyKilnRecipe) recipe).getFirstInputAsList().contains(stack.getItem())) return true;
            }
        }
        return false;
    }

    public static boolean isSecondIngForAlloyKiln(Level level, ItemStack stack) {
        if (stack.isEmpty()) return false;
        for (Recipe<?> recipe : level.getRecipeManager().getRecipes()) {
            if (recipe instanceof AlloyKilnRecipe) {
                if (((AlloyKilnRecipe) recipe).getSecondInputAsList().contains(stack.getItem())) return true;
            }
        }
        return false;
    }
}
