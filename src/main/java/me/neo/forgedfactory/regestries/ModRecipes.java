package me.neo.forgedfactory.regestries;

import me.neo.forgedfactory.FF;
import me.neo.forgedfactory.recipe.AlloyKilnRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, FF.MOD_ID);

    public static final RegistryObject<RecipeSerializer<AlloyKilnRecipe>> ALLOY_KILN_RECIPE_SERIALIZER = SERIALIZERS.register("alloy_kiln_recipe",
            () -> AlloyKilnRecipe.Serializer.INSTANCE);



    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
