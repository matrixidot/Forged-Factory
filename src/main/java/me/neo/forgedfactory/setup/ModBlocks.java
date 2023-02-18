package me.neo.forgedfactory.setup;

import me.neo.forgedfactory.FF;
import me.neo.forgedfactory.blocks.tiles.stone.alloykiln.AlloyKiln;
import me.neo.forgedfactory.blocks.tiles.stone.bricksmasher.BrickSmasher;
import me.neo.forgedfactory.blocks.tiles.stone.dustmixer.DustMixer;
import me.neo.forgedfactory.items.CreativeModTab;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
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
            () -> new AlloyKiln(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops().noOcclusion().sound(SoundType.METAL).lightLevel(state -> state.getValue(AlloyKiln.LIT) ? 14 : 0)), CreativeModTab.FORGED_FACTORY);
    public static final RegistryObject<Block> BRICK_SMASHER = registerBlock("brick_smasher",
            () -> new BrickSmasher(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops().noOcclusion().sound(SoundType.STONE)), CreativeModTab.FORGED_FACTORY);
    public static final RegistryObject<Block> DUST_MIXER = registerBlock("dust_mixer",
            () -> new DustMixer(BlockBehaviour.Properties.of(Material.METAL).strength(3f).requiresCorrectToolForDrops().noOcclusion().sound(SoundType.METAL)), CreativeModTab.FORGED_FACTORY);



    public static final RegistryObject<Block> HR_OGN_BLOCK = registerBlock("hyper_radioactive_oganesson_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(3f).requiresCorrectToolForDrops().sound(SoundType.METAL)), CreativeModTab.FORGED_FACTORY);
    public static final RegistryObject<Block> OGANESSON_BLOCK = registerBlock("oganesson_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(3f).requiresCorrectToolForDrops().sound(SoundType.METAL)), CreativeModTab.FORGED_FACTORY);
    public static final RegistryObject<Block> TITANIUM_BLOCK = registerBlock("titanium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(3f).requiresCorrectToolForDrops().sound(SoundType.METAL)), CreativeModTab.FORGED_FACTORY);
    public static final RegistryObject<Block> TUNGSTEN_BLOCK = registerBlock("tungsten_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(3f).requiresCorrectToolForDrops().sound(SoundType.METAL)), CreativeModTab.FORGED_FACTORY);
    public static final RegistryObject<Block> TIN_BLOCK = registerBlock("tin_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(3f).requiresCorrectToolForDrops().sound(SoundType.METAL)), CreativeModTab.FORGED_FACTORY);
    public static final RegistryObject<Block> BRONZE_BLOCK = registerBlock("bronze_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(3f).requiresCorrectToolForDrops().sound(SoundType.METAL)), CreativeModTab.FORGED_FACTORY);
    public static final RegistryObject<Block> STEEL_BLOCK = registerBlock("steel_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(3f).requiresCorrectToolForDrops().sound(SoundType.METAL)), CreativeModTab.FORGED_FACTORY);



    public static final RegistryObject<Block> TIN_ORE = registerBlock("tin_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CreativeModTab.FORGED_FACTORY);
    public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CreativeModTab.FORGED_FACTORY);
    public static final RegistryObject<Block> TITANIUM_ORE = registerBlock("titanium_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CreativeModTab.FORGED_FACTORY);
    public static final RegistryObject<Block> DEEPSLATE_TITANIUM_ORE = registerBlock("deepslate_titanium_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CreativeModTab.FORGED_FACTORY);

    public static final RegistryObject<Block> CRUDE_CHASSIS = registerBlock("crude_chassis",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1f).requiresCorrectToolForDrops().sound(SoundType.STONE)), CreativeModTab.FORGED_FACTORY);
    public static final RegistryObject<Block> BRONZE_CHASSIS = registerBlock("bronze_chassis",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(1f).requiresCorrectToolForDrops().sound(SoundType.METAL)), CreativeModTab.FORGED_FACTORY);
    public static final RegistryObject<Block> STEEL_CHASSIS = registerBlock("steel_chassis",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(1f).requiresCorrectToolForDrops().sound(SoundType.METAL)), CreativeModTab.FORGED_FACTORY);
    public static final RegistryObject<Block> TUNGSTEN_CHASSIS = registerBlock("tungsten_chassis",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops().sound(SoundType.METAL)), CreativeModTab.FORGED_FACTORY);
    public static final RegistryObject<Block> TITANIUM_CHASSIS = registerBlock("titanium_chassis",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops().sound(SoundType.METAL)), CreativeModTab.FORGED_FACTORY);


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
