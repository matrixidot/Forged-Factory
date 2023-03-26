package me.neo.forgedfactory.recipe;

import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import java.util.Collections;
import java.util.List;

// Basic recipe functionality
// Multiple inputs (with amounts)
// Multiple outputs (with amounts)
// Processing time (set by json)
// Energy requirement (fe/t);
public abstract class FFRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private ItemStack output;
    private NonNullList<Ingredient> ingredients = NonNullList.create();
    private NonNullList<Byte> ingredientCounts = NonNullList.create();
    private byte outputAmount;
    private int processingTime;
    private int powerUsage;

    public FFRecipe(ResourceLocation id) {
        this.id = id;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if (pLevel.isClientSide()) return false;
        int numIngredients = ingredients.size();
        // Requires the inputs to be in order starting at 0.
        for (int i = 0; i < numIngredients; i++) {
            if (test(pContainer, i, i, ingredientCounts.get(i))) continue;
            else return false;
        }
        return true;
    }
    // Returns true if the stack matches with the stack in the slot and if the amount is the same or higher.
    private boolean test(SimpleContainer container, int ingNum,int slot, int amnt) {
        return ingredients.get(ingNum).test(container.getItem(slot)) && container.getItem(slot).getCount() >= amnt;
    }


    // Getters and setters
    public ResourceLocation getRecipeID() {
        return id;
    }

    public void setOutput(ItemStack output) {
        this.output = output;
    }
    public void setOutputAmount(byte amount) {
        this.outputAmount = amount;
    }
    public ItemStack getOutput() {
        return output;
    }
    public int getOutputAmount() {
        return outputAmount;
    }

    public void setIngredients(NonNullList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    public NonNullList<Ingredient> getInputs() {
        return ingredients;
    }
    public List<Item> getIngredientAsList(int index) {
        ItemStack stack = ingredients.get(index).getItems()[0];
        return Collections.singletonList(stack.getItem());
    }

    public void setIngredientCount(byte count) {
        ingredientCounts.add(count);
    }
    public void setIngredientCount(int index, byte count) {
        ingredientCounts.set(index, count);
    }
    public int getIngredientAmount(int index) {
        return ingredientCounts.get(index);
    }
    public int getIngredientAmount(Ingredient ingredient) {
        return ingredientCounts.get(ingredients.indexOf(ingredient));
    }

    public void setProcessingTime(int ticks) {
        processingTime = ticks;
    }
    public int getProcessingTime() {
        return processingTime;
    }

    public void setPowerUsage(int fePerTick) {
        powerUsage = fePerTick;
    }
    public int getPowerUsage() {
        return powerUsage;
    }
}
