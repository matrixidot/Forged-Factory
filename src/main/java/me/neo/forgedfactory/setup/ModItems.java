package me.neo.forgedfactory.setup;

import me.neo.forgedfactory.FF;
import me.neo.forgedfactory.items.CreativeModTab;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FF.MOD_ID);

    public static final RegistryObject<Item> ENTANGLED_INGOT = ITEMS.register("entangled_ingot", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));

    public static final RegistryObject<Item> HR_OGN_INGOT = ITEMS.register("hr_ogn_ingot", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> HR_OGN_NUGGET = ITEMS.register("hr_ogn_nugget", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> HR_OGN_DUST = ITEMS.register("hr_ogn_dust", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> HR_OGN_PLATE = ITEMS.register("hr_ogn_plate", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));

    public static final RegistryObject<Item> OGANESSON_INGOT = ITEMS.register("oganesson_ingot", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> OGANESSON_NUGGET = ITEMS.register("oganesson_nugget", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> OGANESSON_DUST = ITEMS.register("oganesson_dust", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> OGANESSON_PLATE = ITEMS.register("oganesson_plate", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));

    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> TITANIUM_NUGGET = ITEMS.register("titanium_nugget", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> TITANIUM_DUST = ITEMS.register("titanium_dust", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> TITANIUM_PLATE = ITEMS.register("titanium_plate", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> RAW_TITANIUM = ITEMS.register("raw_titanium", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));

    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> TIN_NUGGET = ITEMS.register("tin_nugget", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> TIN_DUST = ITEMS.register("tin_dust", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> TIN_PLATE = ITEMS.register("tin_plate", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));


    public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> TUNGSTEN_NUGGET = ITEMS.register("tungsten_nugget", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> TUNGSTEN_DUST = ITEMS.register("tungsten_dust", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> TUNGSTEN_PLATE = ITEMS.register("tungsten_plate", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
