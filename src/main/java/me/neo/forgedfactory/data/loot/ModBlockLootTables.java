package me.neo.forgedfactory.data.loot;


import me.neo.forgedfactory.regestries.ModBlocks;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLoot {
    @Override
    protected void addTables() {
        oreDrops();
        blockDrops();
        //blockEntityDrops();
    }

    private void oreDrops() {

    }
    private void blockDrops() {
        this.dropSelf(ModBlocks.OGANESSON_BLOCK.get());
        this.dropSelf(ModBlocks.TITANIUM_BLOCK.get());
        this.dropSelf(ModBlocks.HYPER_RADIOACTIVE_OGANESSON_BLOCK.get());
        this.dropSelf(ModBlocks.TUNGSTEN_BLOCK.get());
        this.dropSelf(ModBlocks.ALLOY_KILN.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
