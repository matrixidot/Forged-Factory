package me.neo.forgedfactory.regestries;

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
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    public static final RegistryObject<Item> HYPER_RADIOACTIVE_OGANESSON_INGOT = ITEMS.register("hyper_radioactive_oganesson_ingot", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    public static final RegistryObject<Item> HYPER_RADIOACTIVE_OGANESSON_NUGGET = ITEMS.register("hyper_radioactive_oganesson_nugget", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    public static final RegistryObject<Item> OGANESSON_INGOT = ITEMS.register("oganesson_ingot", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    public static final RegistryObject<Item> OGANESSON_NUGGET = ITEMS.register("oganesson_nugget", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    public static final RegistryObject<Item> TITANIUM_NUGGET = ITEMS.register("titanium_nugget", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    public static final RegistryObject<Item> TUNGSTEN_NUGGET = ITEMS.register("tungsten_nugget", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
