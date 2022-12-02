package me.neo.forgedfactory.regestries;

import me.neo.forgedfactory.FF;
import me.neo.forgedfactory.blocks.stone.alloykiln.AlloyKilnEnt;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, FF.MOD_ID);

    public static final RegistryObject<BlockEntityType<AlloyKilnEnt>> ALLOY_KILN = BLOCK_ENTITIES.register("alloy_kiln",
            () -> BlockEntityType.Builder.of(AlloyKilnEnt::new, ModBlocks.ALLOY_KILN.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
