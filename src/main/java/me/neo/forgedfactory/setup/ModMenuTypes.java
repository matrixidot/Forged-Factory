package me.neo.forgedfactory.setup;

import me.neo.forgedfactory.FF;
import me.neo.forgedfactory.blocks.tiles.stone.alloykiln.AlloyKilnMenu;
import me.neo.forgedfactory.blocks.tiles.stone.bricksmasher.BrickSmasherEnt;
import me.neo.forgedfactory.blocks.tiles.stone.bricksmasher.BrickSmasherMenu;
import me.neo.forgedfactory.blocks.tiles.stone.dustmixer.DustMixerEnt;
import me.neo.forgedfactory.blocks.tiles.stone.dustmixer.DustMixerMenu;
import me.neo.forgedfactory.recipe.BrickSmasherRecipe;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, FF.MOD_ID);

    public static final RegistryObject<MenuType<AlloyKilnMenu>> ALLOY_KILN_MENU = registerMenuType(AlloyKilnMenu::new, "alloy_kiln_menu");
    public static final RegistryObject<MenuType<BrickSmasherMenu>> BRICK_SMASHER_MENU = registerMenuType(BrickSmasherMenu::new, "brick_smasher_menu");
    public static final RegistryObject<MenuType<DustMixerMenu>> DUST_MIXER_MENU = registerMenuType(DustMixerMenu::new, "dust_mixer_menu");


    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }
    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
