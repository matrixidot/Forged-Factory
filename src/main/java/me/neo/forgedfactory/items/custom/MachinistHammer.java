package me.neo.forgedfactory.items.custom;

import me.neo.forgedfactory.items.CreativeModTab;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class MachinistHammer extends Item {

    public MachinistHammer(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        ItemStack stack = itemStack.copy();
        if (stack.hurt(1, RandomSource.create(), null)) {
            return ItemStack.EMPTY;
        } else {
            return stack;
        }
    }
}
