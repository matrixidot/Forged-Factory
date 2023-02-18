package me.neo.forgedfactory.blocks.tiles.stone.dustmixer;

import me.neo.forgedfactory.blocks.WrappedHandler;
import me.neo.forgedfactory.blocks.tiles.stone.alloykiln.AlloyKilnEnt;
import me.neo.forgedfactory.recipe.AlloyKilnRecipe;
import me.neo.forgedfactory.recipe.DustMixerRecipe;
import me.neo.forgedfactory.setup.ModBlockEntities;
import me.neo.forgedfactory.util.RecipeUtil;
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
import net.minecraft.world.level.chunk.SingleValuePalette;
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

public class DustMixerEnt extends BlockEntity implements MenuProvider {
    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 100;
    private int burnTime = 0;
    private int burnTimeMax = 0;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public DustMixerEnt(BlockPos pos, BlockState state) {
        super(ModBlockEntities.DUST_MIXER.get(), pos, state);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> DustMixerEnt.this.progress;
                    case 1 -> DustMixerEnt.this.maxProgress;
                    case 2 -> DustMixerEnt.this.burnTime;
                    case 3 -> DustMixerEnt.this.burnTimeMax;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> DustMixerEnt.this.progress = pValue;
                    case 1 -> DustMixerEnt.this.maxProgress = pValue;
                    case 2 -> DustMixerEnt.this.burnTime = pValue;
                    case 3 -> DustMixerEnt.this.burnTimeMax = pValue;
                }
            }

            @Override
            public int getCount() {
                return 4;
            }
        };
    }

    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
            for (int i = 0; i < itemHandler.getSlots(); i++) {
                inventory.setItem(i, itemHandler.getStackInSlot(i));
            }
            return switch(slot) {
                case 0 -> RecipeUtil.isIngForDustMixer(level, stack, 0);
                case 1 -> RecipeUtil.isIngForDustMixer(level, stack, 1);
                case 2 -> ForgeHooks.getBurnTime(stack, RecipeType.SMELTING) > 0;
                case 3 -> false;
                default -> super.isItemValid(slot, stack);
            };
        }
    };

    @Override
    public Component getDisplayName() {
        return Component.translatable("dust_mixer_entity");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new DustMixerMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            if (side == null) return lazyItemHandler.cast();
            if (directionWrappedHandlerMap.containsKey(side)) {
                Direction localDir = this.getBlockState().getValue(DustMixer.HORIZONTAL_FACING);
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
        nbt.put("mixerInv", itemHandler.serializeNBT());
        nbt.putInt("mixer.progress", this.progress);
        nbt.putInt("mixer.maxburn", this.burnTimeMax);
        nbt.putInt("mixer.burntime", this.burnTime);
        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("mixerInv"));
        progress = nbt.getInt("mixer.progress");
        burnTimeMax = nbt.getInt("mixer.maxburn");
        burnTime = nbt.getInt("mixer.burntime");
    }

    public void drops() {
        SimpleContainer inv = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inv.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inv);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, DustMixerEnt entity) {
        if (level.isClientSide()) return;
        entity.burnTime = Math.max(0, entity.burnTime - 1);
        if (entity.burnTime <= 0 && hasRecipe(entity)) {
            consumeFuel(entity);
        }
        if (entity.burnTime > 0 && hasRecipe(entity)) {
            level.setBlock(pos, state.setValue(DustMixer.LIT, true), 2);
            entity.progress = Math.min(entity.maxProgress, entity.progress + 1);
            if (entity.progress >= entity.maxProgress) {
                craftItem(entity);
            }
        } else if (entity.burnTime > 0) {
            level.setBlock(pos, state.setValue(DustMixer.LIT, true), 2);
            entity.resetProgress();
        } else {
            level.setBlock(pos, state.setValue(DustMixer.LIT, false), 2);
            entity.resetProgress();
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static void craftItem(DustMixerEnt entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }
        Optional<DustMixerRecipe> recipe = level.getRecipeManager().getRecipeFor(DustMixerRecipe.Type.INSTANCE, inventory, level);

        if (hasRecipe(entity) && entity.itemHandler.getStackInSlot(3).getCount() + recipe.get().getOutputAmount() < 65) {
            entity.itemHandler.extractItem(0, recipe.get().getIngredientAmount(0), false);
            entity.itemHandler.extractItem(1, recipe.get().getIngredientAmount(1), false);
            entity.itemHandler.setStackInSlot(3, new ItemStack(recipe.get().getResultItem().getItem(),
                    entity.itemHandler.getStackInSlot(3).getCount() + recipe.get().getOutputAmount()));
            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(DustMixerEnt entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }
        Optional<DustMixerRecipe> recipe = level.getRecipeManager().getRecipeFor(DustMixerRecipe.Type.INSTANCE, inventory, level);

        return recipe.isPresent() && hasEnoughIngredients(inventory, recipe.get(), entity) && canInsertAmountIntoOutput(inventory) && canInsertItemIntoOutput(inventory, recipe.get().getResultItem());
    }

    private static boolean hasEnoughIngredients(SimpleContainer inventory, DustMixerRecipe recipe, DustMixerEnt entity) {
        return recipe.matches(inventory, entity.level);
    }
    private static boolean canInsertItemIntoOutput(SimpleContainer inventory, ItemStack stack) {
        return inventory.getItem(3).getItem() == stack.getItem() || inventory.getItem(3).isEmpty();
    }
    // Checks if the output slot is already full of that type of item.
    private static boolean canInsertAmountIntoOutput(SimpleContainer inventory) {
        return inventory.getItem(3).getMaxStackSize() > inventory.getItem(3).getCount();
    }

    public static void consumeFuel(DustMixerEnt ent) {
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

    // Wrapped handler (ItemHandler, SlotToExtract, Slot&StackToInsert)
    private final Map<Direction, LazyOptional<WrappedHandler>> directionWrappedHandlerMap =
            Map.of(Direction.DOWN, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i == 3, (i, s) -> false)),
                    Direction.NORTH, LazyOptional.of(() ->
                            // Don't extract from third slot but insert to it.
                            new WrappedHandler(itemHandler, (index) -> false, (index, stack) -> itemHandler.isItemValid(2, stack))),
                    Direction.SOUTH, LazyOptional.of(() ->
                            // Just extract from output slot.
                            new WrappedHandler(itemHandler, (i) -> i == 3, (i, s) -> false)),
                    Direction.EAST, LazyOptional.of(() ->
                            // Don't extract from first/second slot just insert.
                            new WrappedHandler(itemHandler, (index) -> false, (index, stack) -> itemHandler.isItemValid(0, stack) || itemHandler.isItemValid(1, stack))),
                    Direction.WEST, LazyOptional.of(() ->
                            // Don't extract from first/second slot just insert.
                            new WrappedHandler(itemHandler, (index) -> false, (index, stack) -> itemHandler.isItemValid(0, stack) || itemHandler.isItemValid(1, stack))));
}
