package me.neo.forgedfactory.blocks.tiles.stone.bricksmasher;

import me.neo.forgedfactory.blocks.WrappedHandler;
import me.neo.forgedfactory.blocks.tiles.stone.alloykiln.AlloyKiln;
import me.neo.forgedfactory.recipe.AlloyKilnRecipe;
import me.neo.forgedfactory.recipe.BrickSmasherRecipe;
import me.neo.forgedfactory.setup.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;

public class BrickSmasherEnt extends BlockEntity implements MenuProvider {
    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 10;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public BrickSmasherEnt(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BRICK_SMASHER.get(), pos, state);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> BrickSmasherEnt.this.progress;
                    case 1 -> BrickSmasherEnt.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> BrickSmasherEnt.this.progress = pValue;
                    case 1 -> BrickSmasherEnt.this.maxProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    private final ItemStackHandler itemHandler = new ItemStackHandler(2) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot) {
                // Makes sure the item is part of a valid recipe.
                case 0 -> level.getRecipeManager().getRecipeFor(BrickSmasherRecipe.Type.INSTANCE, new SimpleContainer(stack), level).orElse(null) != null;
                case 1 -> false;
                default -> super.isItemValid(slot, stack);
            };
        }
    };

    @Override
    public Component getDisplayName() {
        return Component.literal("Brick Smasher");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new BrickSmasherMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            if (side == null) return lazyItemHandler.cast();
            if (directionWrappedHandlerMap.containsKey(side)) {
                Direction localDir = this.getBlockState().getValue(BrickSmasher.HORIZONTAL_FACING);
                if (side == Direction.UP || side == Direction.DOWN) return directionWrappedHandlerMap.get(side).cast();
                return switch (localDir) {
                    case EAST -> directionWrappedHandlerMap.get(side.getClockWise()).cast();
                    case SOUTH -> directionWrappedHandlerMap.get(side).cast();
                    case WEST -> directionWrappedHandlerMap.get(side.getCounterClockWise()).cast();
                    default -> directionWrappedHandlerMap.get(side.getOpposite()).cast();
                };
            }
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("smasherInv", itemHandler.serializeNBT());
        pTag.putInt("smasher.progress", this.progress);
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("smasherInv"));
        progress = pTag.getInt("smasher.progress");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, BrickSmasherEnt ent) {
        if (level.isClientSide()) return;

        if (ent.hasRecipe(ent)) {
            ent.progress++;
            if (ent.progress >= ent.maxProgress) {
                craftItem(ent);
            }
        } else {
            ent.resetProgress();
        }
    }

    private static void craftItem(BrickSmasherEnt entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }
        // Gets the recipes from the Alloying json files.
        Optional<BrickSmasherRecipe> recipe = level.getRecipeManager().getRecipeFor(BrickSmasherRecipe.Type.INSTANCE, inventory, level);

        if(hasRecipe(entity) && entity.itemHandler.getStackInSlot(1).getCount() + recipe.get().getResultItem().getCount() < 65) {
            entity.itemHandler.extractItem(0, 1, false);
            entity.itemHandler.setStackInSlot(1, new ItemStack(recipe.get().getResultItem().getItem(),
                    entity.itemHandler.getStackInSlot(1).getCount() + recipe.get().getResultItem().getCount()));

            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(BrickSmasherEnt ent) {
        Level level = ent.getLevel();
        SimpleContainer inv = new SimpleContainer(ent.itemHandler.getSlots());
        for (int i = 0; i < ent.itemHandler.getSlots(); i++) {
            inv.setItem(i, ent.itemHandler.getStackInSlot(i));
        }
        Optional<BrickSmasherRecipe> recipe = level.getRecipeManager().getRecipeFor(BrickSmasherRecipe.Type.INSTANCE, inv, level);
        return recipe.isPresent() && canInsertAmountIntoOutputSlot(inv) && canInsertItemIntoOutputSlot(inv, recipe.get().getResultItem());
    }

    // Checks if the output slot is clogged by something else.
    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack stack) {
        return inventory.getItem(1).getItem() == stack.getItem() || inventory.getItem(1).isEmpty();
    }
    // Checks if the output slot is already full of that type of item.
    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(1).getMaxStackSize() > inventory.getItem(1).getCount();
    }

    private void resetProgress() {
        this.progress = 0;
    }

    // Wrapped handler (ItemHandler, SlotToExtract, Slot&StackToInsert)
    private final Map<Direction, LazyOptional<WrappedHandler>> directionWrappedHandlerMap =
            Map.of(Direction.DOWN, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i == 1, (i, s) -> false)),
                    Direction.NORTH, LazyOptional.of(() ->
                            // Extract output slot, insert slot 0
                            new WrappedHandler(itemHandler, (i) -> i == 1, (index, stack) -> itemHandler.isItemValid(0, stack))),
                    Direction.SOUTH, LazyOptional.of(() ->
                            // Extract output slot
                            new WrappedHandler(itemHandler, (i) -> i == 1, (i, s) -> false)),
                    Direction.EAST, LazyOptional.of(() ->
                            // Insert slot 0
                            new WrappedHandler(itemHandler, (index) -> false, (index, stack) -> itemHandler.isItemValid(0, stack))),
                    Direction.WEST, LazyOptional.of(() ->
                            // Insert slot 0
                            new WrappedHandler(itemHandler, (index) -> false, (index, stack) -> itemHandler.isItemValid(0, stack))));
}
