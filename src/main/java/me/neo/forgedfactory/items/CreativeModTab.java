package me.neo.forgedfactory.items;

import me.neo.forgedfactory.regestries.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

public class CreativeModTab {
    public static final CreativeModeTab FORGED_FACTORY = new CreativeModeTab("fftab") {
        @Override
        public ItemStack makeIcon() { return new ItemStack(Blocks.DIRT); }
    };
}
