package me.neo.forgedfactory.blocks.stone.alloykiln;

import me.neo.forgedfactory.blocks.WrappedHandler;
import me.neo.forgedfactory.recipe.AlloyKilnRecipe;
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
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;

public class AlloyKilnEnt extends BlockEntity implements MenuProvider {
    // Important fields
    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 10;
    private int burnTimeMax = 0;
    private int burnTime = 0;

    // Lazy Optionals
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    // Constructor
    public AlloyKilnEnt(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ALLOY_KILN.get(), pos, state);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch(pIndex) {
                    case 0 -> AlloyKilnEnt.this.progress;
                    case 1 -> AlloyKilnEnt.this.maxProgress;
                    case 2 -> AlloyKilnEnt.this.burnTime;
                    case 3 -> AlloyKilnEnt.this.burnTimeMax;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch(pIndex) {
                    case 0 -> AlloyKilnEnt.this.progress = pValue;
                    case 1 -> AlloyKilnEnt.this.maxProgress = pValue;
                    case 2 -> AlloyKilnEnt.this.burnTime = pValue;
                    case 3 -> AlloyKilnEnt.this.burnTimeMax = pValue;
                }
            }

            @Override
            public int getCount() {
                return 4;
            }
        };
    }

    //Creating ItemHandler
    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch(slot) {
                case 0,1 -> ForgeHooks.getBurnTime(stack, RecipeType.SMELTING) <= 0;
                case 2 -> ForgeHooks.getBurnTime(stack, RecipeType.SMELTING) > 0;
                case 3 -> false;
                default -> super.isItemValid(slot, stack);
            };
        }
    };

    @Override
    public Component getDisplayName() {
        return Component.literal("Simple Alloy Kiln");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new AlloyKilnMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            if (side == null) return lazyItemHandler.cast();
            if (directionWrappedHandlerMap.containsKey(side)) {
                Direction localDir = this.getBlockState().getValue(AlloyKiln.FACING);
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
    protected void saveAdditional(CompoundTag nbt) {
        nbt.put("kilnInv", itemHandler.serializeNBT());
        nbt.putInt("kiln.progress", this.progress);
        nbt.putInt("kiln.maxburn", this.burnTimeMax);
        nbt.putInt("kiln.burntime", this.burnTime);
        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("kilnInv"));
        progress = nbt.getInt("kiln.progress");
        burnTimeMax = nbt.getInt("kiln.maxburn");
        burnTime = nbt.getInt("kiln.burntime");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }
    public static void tick(Level level, BlockPos pos, BlockState state, AlloyKilnEnt entity) {
        if (level.isClientSide()) return;
        entity.burnTime = Math.max(0, entity.burnTime-1);
        if (entity.burnTime <= 0 && hasRecipe(entity)) {
            consumeFuel(entity);
        }
        if (entity.burnTime > 0 && hasRecipe(entity)) {
            level.setBlock(pos, state.setValue(AlloyKiln.LIT, true), 2);
            entity.progress = Math.min(entity.maxProgress, entity.progress + 1);
            if (entity.progress >= entity.maxProgress) {
                craftItem(entity);
            }
        } else {
            entity.resetProgress();
            level.setBlock(pos, state.setValue(AlloyKiln.LIT, false), 2);
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static void craftItem(AlloyKilnEnt entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }
        // Gets the recipes from the Alloying json files.
        Optional<AlloyKilnRecipe> recipe = level.getRecipeManager().getRecipeFor(AlloyKilnRecipe.Type.INSTANCE, inventory, level);

        if(hasRecipe(entity) && entity.itemHandler.getStackInSlot(3).getCount() + recipe.get().getResultItem().getCount() < 65) {
            entity.itemHandler.extractItem(0, recipe.get().getIngAmnt(0), false);
            entity.itemHandler.extractItem(1, recipe.get().getIngAmnt(1), false);
            entity.itemHandler.setStackInSlot(3, new ItemStack(recipe.get().getResultItem().getItem(),
                    entity.itemHandler.getStackInSlot(3).getCount() + recipe.get().getResultItem().getCount()));

            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(AlloyKilnEnt entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }
        // Gets the recipes from the GemInfusingStationRecipe json files.
        Optional<AlloyKilnRecipe> recipe = level.getRecipeManager().getRecipeFor(AlloyKilnRecipe.Type.INSTANCE, inventory, level);
        // Returns if the recipe exists or not.
        return recipe.isPresent() && hasEnoughIngredients(inventory, recipe.get()) && canInsertAmountIntoOutputSlot(inventory) && canInsertItemIntoOutputSlot(inventory, recipe.get().getResultItem());
    }
    private static boolean hasEnoughIngredients(SimpleContainer inventory, AlloyKilnRecipe recipe) {
        System.out.println(recipe.getIngAmnt(0) + " " + recipe.getIngredients().get(0).getItems());
        System.out.println(recipe.getIngAmnt(1) + " " + recipe.getIngredients().get(1).getItems());

        if (inventory.getItem(0).getCount() >= recipe.getIngAmnt(0) && inventory.getItem(1).getCount() >= recipe.getIngAmnt(1)) return true;
        return false;
    }

    // Checks if the output slot is clogged by something else.
    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack stack) {
        return inventory.getItem(3).getItem() == stack.getItem() || inventory.getItem(3).isEmpty();
    }
    // Checks if the output slot is already full of that type of item.
    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(3).getMaxStackSize() > inventory.getItem(3).getCount();
    }

    public static void consumeFuel(AlloyKilnEnt ent) {
        ent.burnTimeMax = 0;
        ItemStack stack = ent.itemHandler.getStackInSlot(2);
        final int factor = 1;
        int burnTimeTicks = factor * ForgeHooks.getBurnTime(stack, RecipeType.SMELTING);
        if (burnTimeTicks > 0) {
            ent.burnTimeMax = burnTimeTicks;
            ent.burnTime = ent.burnTimeMax;
            if (stack.getCount() == 1 && stack.hasCraftingRemainingItem()) {
                ent.itemHandler.setStackInSlot(2, stack.getCraftingRemainingItem().copy());
            } else {
                stack.shrink(1);
            }
        }

    }


    private final Map<Direction, LazyOptional<WrappedHandler>> directionWrappedHandlerMap =
            Map.of(Direction.DOWN, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i == 2, (i, s) -> false)),
                    Direction.NORTH, LazyOptional.of(() -> new WrappedHandler(itemHandler, (index) -> index == 1,
                            (index, stack) -> itemHandler.isItemValid(1, stack))),
                    Direction.SOUTH, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i == 2, (i, s) -> false)),
                    Direction.EAST, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i == 1,
                            (index, stack) -> itemHandler.isItemValid(1, stack))),
                    Direction.WEST, LazyOptional.of(() -> new WrappedHandler(itemHandler, (index) -> index == 0 || index == 1,
                            (index, stack) -> itemHandler.isItemValid(0, stack) || itemHandler.isItemValid(1, stack))));
}
