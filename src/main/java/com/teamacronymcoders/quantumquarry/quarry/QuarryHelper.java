package com.teamacronymcoders.quantumquarry.quarry;

import com.hrznstudio.titanium.component.inventory.InventoryComponent;
import com.hrznstudio.titanium.component.inventory.SidedInventoryComponent;
import com.teamacronymcoders.quantumquarry.QuantumConfig;
import com.teamacronymcoders.quantumquarry.QuantumQuarry;
import com.teamacronymcoders.quantumquarry.recipe.ItemStackKey;
import com.teamacronymcoders.quantumquarry.recipe.MinerEntry;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.loot.LootContext.Builder;
import net.minecraft.world.storage.loot.LootParameters;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class QuarryHelper {

    private static final List<MinerEntry> ENTRIES = new ArrayList<>();
    private static Map<ItemStackKey, List<MinerEntry>> cachedMaps = new HashMap<>();

    /**
     * @param powerIn Power Stored in the Quarry
     * @param lens Stored Lens
     * @param tool Stored Appropriate Tool for breaking the blockstate.
     * @return returns the amount of operations that can be completed with the current power amount.
     */
    public static int getAmountOfOperationsForPower(int powerIn, ItemStack lens, int totalEfficiencyFromTools) {
        int powerPerOperation = getPowerPerOperationWithEfficiency(lens, totalEfficiencyFromTools);
        return Math.round((float) powerIn / powerPerOperation);
    }

    /**
     * @param lens Stored Lens
     * @param totalEfficiencyFromTools Total Efficiency Level from All Tools
     * @return Returns the default cost minus the efficiency modifier
     */
    public static int getPowerPerOperationWithEfficiency(ItemStack lens, int totalEfficiencyFromTools) {
        int efficiency = EnchantmentHelper.getEnchantmentLevel(Enchantments.EFFICIENCY, lens) + totalEfficiencyFromTools;
        return Math.max(QuantumConfig.getBaseCost() - (QuantumConfig.getEfficiencyReduction() * efficiency), QuantumConfig.getMinimumPowerDrain());
    }

    public static boolean doesNotHaveClashingEnchantmentsTool(ItemStack stack, InventoryComponent component) {
        boolean hasFortuneInsert = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, stack) > 0;
        boolean hasSilkTouchInsert = EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, stack) > 0;
        if (hasFortuneInsert) {
            for (int i = 0; i < 2; i++) {
                boolean hasSilkTouch = EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, component.getStackInSlot(i)) > 0;
                if (hasSilkTouch) return false;
            }
        }
        if (hasSilkTouchInsert) {
            for (int i = 0; i < 2; i++) {
                boolean hasFortune = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, component.getStackInSlot(i)) > 0;
                if (hasFortune) return false;
            }
        }
        return true;
    }

    public static boolean doesNotHaveClashingEnchantments(ItemStack lens, ItemStack tool) {
        Map<Enchantment, Integer> enchantmentsLens = EnchantmentHelper.getEnchantments(lens);
        Map<Enchantment, Integer> enchantmentsTool = EnchantmentHelper.getEnchantments(tool);
        boolean canInsert = true;
        for (Enchantment enchantment : enchantmentsTool.keySet()) {
            for (Enchantment enchantment1 : enchantmentsLens.keySet()) {
                if (!enchantment.equals(enchantment1)) {
                    canInsert = enchantment.isCompatibleWith(enchantment1);
                }
            }
        }
        return canInsert;
    }

    /**
     * @param world Server World
     * @param state BlockState to generate drops for
     * @param lens Stored Lens
     * @param tool Stored Appropriate Tool for "breaking" the block
     * @param playerEntity Nullable Player
     * @return List of ItemStack Drops generated from LootTables
     */
    public static List<ItemStack> getDrops(@Nonnull BlockPos pos, @Nonnull ServerWorld world, @Nonnull BlockState state, @Nullable ItemStack lens, @Nonnull ItemStack tool, @Nullable PlayerEntity playerEntity) {
        Builder context = new Builder(world)
            .withParameter(LootParameters.BLOCK_STATE, state)
            .withParameter(LootParameters.TOOL, tool)
            .withParameter(LootParameters.POSITION, pos);
        if (lens != null) {
            context.withLuck(3.0F);
        }
        if (playerEntity != null) {
            context.withParameter(LootParameters.THIS_ENTITY, playerEntity);
        }
        return state.getDrops(context);
    }

    /**
     * @param state Blockstate being broken.
     * @param toolInventory Tool-Inventory
     * @return Returns the appropriate tool to use to break the tool.
     */
    public static ItemStack getAppropriateTool(BlockState state, SidedInventoryComponent<QuarryTile> toolInventory) {
        if (state.getHarvestTool() != null) {
            switch (state.getHarvestTool().getName()) {
                case "axe": return toolInventory.getStackInSlot(0);
                case "shovel": return toolInventory.getStackInSlot(1);
                case "pickaxe": return toolInventory.getStackInSlot(2);
            }
        }
        return toolInventory.getStackInSlot(2);
    }

    /**
     * @param state Blockstate being broken
     * @param tool Appropriate Tool for the Blockstate
     * @return Returns if the blockstate can be broken by the tool.
     */
    public static boolean canToolBreakBlock(BlockState state, ItemStack tool) {
        for (ToolType type : tool.getToolTypes()) {
            if (state.getHarvestLevel() < tool.getHarvestLevel(type, null, state)) {
                return true;
            }
        }
        return false;
    }

    public static List<MinerEntry> getMinerEntriesByLens(ItemStack lens) {
        ItemStackKey key = new ItemStackKey(lens);
        Predicate<MinerEntry> filter = (lens.isEmpty()) ? entry -> true : entry -> entry.getLens().test(lens);
        if (cachedMaps.containsKey(key)) {
            return cachedMaps.get(key);
        }
        List<MinerEntry> entries = getEntries().stream().filter(filter).collect(Collectors.toList());
        List<MinerEntry> collection = new ArrayList<>();
        for (MinerEntry entry : entries) {
            if (entry != null) {
                collection.add(entry);
            }
        }
        cachedMaps.put(key, collection);
        return collection;
    }

    public static List<MinerEntry> getEntries() {
        return ENTRIES;
    }

    @Nullable
    public static MinerEntry getMinerEntry(List<MinerEntry> entries) {
        int w = 0;
        if (QuantumConfig.getShouldAirExistInTheQuarryPool()) {
            w += QuantumConfig.getAirWeightedValue();
        }
        for (MinerEntry r : entries) {
            w += r.getWeight();
        }
        if(w <= 0) return null;
        int number = QuantumQuarry.RANDOM.nextInt(w) + 1;
        int currentWeight = 0;
        for (MinerEntry entry : entries) {
            currentWeight += entry.getWeight();
            if (currentWeight >= number) {
                return entry;
            }
        }
        return null;
    }
}
