package me.neo.forgedfactory.regestries;

import me.neo.forgedfactory.FF;
import me.neo.forgedfactory.blocks.stone.alloykiln.AlloyKiln;
import me.neo.forgedfactory.blocks.stone.bricksmasher.BrickSmasher;
import me.neo.forgedfactory.items.CreativeModTab;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FF.MOD_ID);

    public static final RegistryObject<Block> ALLOY_KILN = registerBlock("alloy_kiln",
            () -> new AlloyKiln(BlockBehaviour.Properties.of(Material.STONE).strength(5f).noOcclusion()), CreativeModTab.FORGED_FACTORY);

    public static final RegistryObject<Block> BRICK_SMASHER = registerBlock("brick_smasher",
            () -> new BrickSmasher(BlockBehaviour.Properties.of(Material.STONE).strength(5f).noOcclusion()), CreativeModTab.FORGED_FACTORY);


    // Registers a new block along with its item.
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    // Registers the item of a given block
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
    // Necessary Register method
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
