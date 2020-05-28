package com.teamacronymcoders.quantumquarry.quarry;

import com.hrznstudio.titanium.annotation.Save;
import com.hrznstudio.titanium.api.IFactory;
import com.hrznstudio.titanium.api.client.IScreenAddon;
import com.hrznstudio.titanium.block.tile.ActiveTile;
import com.hrznstudio.titanium.component.energy.EnergyStorageComponent;
import com.hrznstudio.titanium.component.inventory.SidedInventoryComponent;
import com.hrznstudio.titanium.component.progress.ProgressBarComponent;
import com.hrznstudio.titanium.container.addon.IContainerAddon;
import com.teamacronymcoders.quantumquarry.QuantumConfig;
import com.teamacronymcoders.quantumquarry.QuantumQuarry;
import com.teamacronymcoders.quantumquarry.datagen.QuantumTagDataProvider.ItemTags;
import com.teamacronymcoders.quantumquarry.recipe.MinerEntry;
import com.teamacronymcoders.quantumquarry.registry.QuantumQuarryRegistryHandler;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.ItemHandlerHelper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Set;

public class QuarryTile extends ActiveTile<QuarryTile> {


    private SidedInventoryComponent<QuarryTile> toolInventory;
    private SidedInventoryComponent<QuarryTile> storageInventory;
    private SidedInventoryComponent<QuarryTile> lensInventory;
    private SidedInventoryComponent<QuarryTile> energyInventory;
    private EnergyStorageComponent energyStorage;
    private ProgressBarComponent<QuarryTile> progressBar;

    private final LazyOptional<IEnergyStorage> energyCap = LazyOptional.of(() -> energyStorage);

    private List<MinerEntry> cachedEntries;

    @Save
    private boolean hold = false;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public QuarryTile() {
        super(QuantumQuarryRegistryHandler.quarryBlock);
        addInventory(toolInventory = (SidedInventoryComponent) new SidedInventoryComponent<>("tool_inventory", 7, -150, 3, 0)
            .setColor(DyeColor.BLUE)
            .setOnSlotChanged((stack, integer) -> markComponentForUpdate(true))
            .setRange(3, 1)
            .setInputFilter(this::canInsertTool));
        addInventory(lensInventory = (SidedInventoryComponent) new SidedInventoryComponent<>("lens_inventory", 151, -150, 1, 1)
            .setColor(DyeColor.PURPLE)
            .setOnSlotChanged((stack, integer) -> {
                markComponentForUpdate(true);
                getRecipesForCache(stack);
            })
            .setRange(1, 1)
            .setInputFilter((stack, integer) -> stack.getItem().isIn(ItemTags.LensTag)));
        addInventory(storageInventory = (SidedInventoryComponent) new SidedInventoryComponent<>("storage_inventory", 7, -125, 54, 2)
            .setColor(DyeColor.RED)
            .setOnSlotChanged((stack, integer) -> markComponentForUpdate(true))
            .setRange(9, 6)
            .setInputFilter((stack, integer) -> false));
        addInventory(energyInventory = (SidedInventoryComponent) new SidedInventoryComponent<>("energy_inventory", -99, 60, 1, 3)
            .setColor(DyeColor.ORANGE)
            .setOnSlotChanged((stack, integer) -> markComponentForUpdate(true))
            .setInputFilter((stack, integer) -> stack.getCapability(CapabilityEnergy.ENERGY).isPresent()));
        energyStorage = new EnergyStorageComponent(QuantumConfig.getMaxPowerStorage(), -100, 0);
    }

    @Override
    public void tick() {
        // Don't Remove super.tick();
        super.tick();
        handleEnergySlot();
        if (cachedEntries == null) {
            cachedEntries = getRecipesForCache(ItemStack.EMPTY);
        }
        ItemStack lens = getLens();
        MinerEntry entry = getRandomCachedEntry();
        if (entry != null) {
            ItemStack tool = QuarryHelper.getAppropriateTool(entry.getBlock().getDefaultState(), toolInventory);
            handleQuantumQuarry(entry, lens, tool);
        }
        if (hold) {
            handlePowerDrain(lens, ItemStack.EMPTY);
        }
    }

    @Nonnull
    @Override
    public QuarryTile getSelf() {
        return this;
    }

    private boolean canInsertTool(ItemStack stack, int slot) {
        Set<ToolType> toolTypes = stack.getToolTypes();
        switch (slot) {
            case 0: return toolTypes.contains(ToolType.AXE);
            case 1: return toolTypes.contains(ToolType.SHOVEL);
            case 2: return toolTypes.contains(ToolType.PICKAXE);
            default: return false;
        }
    }

    @Override
    public List<IFactory<? extends IScreenAddon>> getScreenAddons() {
        List<IFactory<? extends IScreenAddon>> addons = super.getScreenAddons();
        addons.addAll(energyStorage.getScreenAddons());
        return addons;
    }

    @Override
    public List<IFactory<? extends IContainerAddon>> getContainerAddons() {
        List<IFactory<? extends IContainerAddon>> addons = super.getContainerAddons();
        addons.addAll(energyStorage.getContainerAddons());
        return addons;
    }

    @Nonnull
    public <U> LazyOptional<U> getCapability(@Nonnull Capability<U> cap, @Nullable Direction side) {
        return cap == CapabilityEnergy.ENERGY ? this.energyCap.cast() : super.getCapability(cap, side);
    }

    public ItemStack getLens() {
        return lensInventory.getStackInSlot(0);
    }

    public int getCurrentEnergy() {
        return energyStorage.getEnergyStored();
    }

    public List<MinerEntry> getRecipesForCache(ItemStack lens) {
        return QuarryHelper.getMinerEntriesByLens(lens);
    }

    @Nullable
    public MinerEntry getRandomCachedEntry() {
        if (cachedEntries != null && !cachedEntries.isEmpty()) {
            return QuarryHelper.getMinerEntry(cachedEntries);
        }
        return null;
    }

    public void handleEnergySlot() {
        if (!energyInventory.getStackInSlot(0).isEmpty()) {
            ItemStack stack = energyInventory.getStackInSlot(0);
            stack.getCapability(CapabilityEnergy.ENERGY).ifPresent(iEnergyStorage -> {
                int charged = energyStorage.receiveEnergy(iEnergyStorage.getEnergyStored(), false);
                if(charged > 0) {
                    energyStorage.extractEnergy(charged, false);
                }
            });
        }
    }

    public void handleQuantumQuarry(MinerEntry entry, ItemStack lens, ItemStack tool) {
        if (!hold && QuarryHelper.canToolBreakBlock(entry.getBlock().getDefaultState(), tool) && world != null && !world.isRemote()) {
            for (int i = 0; i < Math.min(QuarryHelper.getAmountOfOperationsForPower(getCurrentEnergy(), lens, tool), 20); i++) {
                List<ItemStack> generated = QuarryHelper.getDrops(pos, (ServerWorld) world, entry.getBlock().getDefaultState(), lens, tool, null, null);
                for (ItemStack stack : generated) {
                    if (!ItemHandlerHelper.insertItemStacked(storageInventory, stack, false).isEmpty()) {
                        hold = true;
                        break;
                    }
                }
                if (hold) {
                    break;
                }
                if (QuantumConfig.getShouldToolsTakeDamage()) {
                    tool.attemptDamageItem(1, QuantumQuarry.RANDOM, null);
                }
                handlePowerDrain(lens, tool);
            }
        }
    }

    public void handlePowerDrain(ItemStack lens, ItemStack tool) {
        int drain = hold ? QuantumConfig.getMinimumPowerDrain() : QuarryHelper.getPowerPerOperationWithEfficiency(lens, tool);
        if (getCurrentEnergy() - drain > 0) {
            energyStorage.extractEnergy(drain, false);
        } else if (getCurrentEnergy() != 0) {
            energyStorage.setEnergyStored(0);
        }
    }
}
