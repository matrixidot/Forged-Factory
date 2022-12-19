package me.neo.forgedfactory.setup;

import me.neo.forgedfactory.FF;
import me.neo.forgedfactory.items.CreativeModTab;
import me.neo.forgedfactory.items.custom.MachinistHammer;
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
    public static final RegistryObject<Item> TITANIUM_GEAR = ITEMS.register("titanium_gear", () ->
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
    public static final RegistryObject<Item> TIN_GEAR = ITEMS.register("tin_gear", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));


    public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> TUNGSTEN_NUGGET = ITEMS.register("tungsten_nugget", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> TUNGSTEN_DUST = ITEMS.register("tungsten_dust", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> TUNGSTEN_PLATE = ITEMS.register("tungsten_plate", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> TUNGSTEN_GEAR = ITEMS.register("tungsten_gear", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));

    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> STEEL_DUST = ITEMS.register("steel_dust", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> STEEL_PLATE = ITEMS.register("steel_plate", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));

    public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> BRONZE_NUGGET = ITEMS.register("bronze_nugget", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> BRONZE_DUST = ITEMS.register("bronze_dust", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> BRONZE_PLATE = ITEMS.register("bronze_plate", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> BRONZE_GEAR = ITEMS.register("bronze_gear", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));

    public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> COPPER_DUST = ITEMS.register("copper_dust", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> COPPER_PLATE = ITEMS.register("copper_plate", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> COPPER_GEAR = ITEMS.register("copper_gear", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> COPPER_PIPE = ITEMS.register("copper_pipe", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));

    public static final RegistryObject<Item> IRON_DUST = ITEMS.register("iron_dust", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> IRON_PLATE = ITEMS.register("iron_plate", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));

    public static final RegistryObject<Item> PEBBLE = ITEMS.register("pebble", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> MACHINIST_HAMMER = ITEMS.register("machinist_hammer", () -> new MachinistHammer(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY).durability(48)));
    public static final RegistryObject<Item> CARBONATED_IRON_DUST = ITEMS.register("carbonated_iron_dust", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> AMETHYST_DUST = ITEMS.register("amethyst_dust", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> DIAMOND_DUST = ITEMS.register("diamond_dust", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> EMERALD_DUST = ITEMS.register("emerald_dust", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));
    public static final RegistryObject<Item> BRONZE_CASING = ITEMS.register("bronze_casing", () ->
            new Item(new Item.Properties().tab(CreativeModTab.FORGED_FACTORY)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
