package com.teamacronymcoders.quantumquarry.quarry;

import com.hrznstudio.titanium.component.inventory.SidedInventoryComponent;
import com.teamacronymcoders.quantumquarry.QuantumConfig;
import com.teamacronymcoders.quantumquarry.recipe.EntryHelper;
import com.teamacronymcoders.quantumquarry.recipe.MinerEntry;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.loot.LootContext.Builder;
import net.minecraft.world.storage.loot.LootParameters;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.Collectors;

public class QuarryHelper {

    /**
     * @param powerIn Power Stored in the Quarry
     * @param lens Stored Lens
     * @param tool Stored Appropriate Tool for breaking the blockstate.
     * @return returns the amount of operations that can be completed with the current power amount.
     */
    public static int getAmountOfOperationsForPower(int powerIn, ItemStack lens, ItemStack tool) {
        int powerPerOperation = getPowerPerOperationWithEfficiency(lens, tool);
        return doesNotHaveClashingEnchantments(lens, tool) ? Math.round((float) powerIn / powerPerOperation) : 0;
    }

    /**
     * @param lens Stored Lens
     * @param tool Stored Appropriate Tool
     * @return Returns the default cost minus the efficiency modifier
     */
    public static int getPowerPerOperationWithEfficiency(ItemStack lens, ItemStack tool) {
        int efficiency = EnchantmentHelper.getEnchantmentLevel(Enchantments.EFFICIENCY, lens) + EnchantmentHelper.getEnchantmentLevel(Enchantments.EFFICIENCY, tool);
        return Math.min(QuantumConfig.getBaseCost() - (QuantumConfig.getEfficiencyReduction() * efficiency), QuantumConfig.getMinimumPowerDrain());
    }

    private static boolean doesNotHaveClashingEnchantments(ItemStack lens, ItemStack tool) {
        boolean hasFortuneLens = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, lens) > 0;
        boolean hasSilkTouchLens = EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, lens) > 0;
        boolean hasFortuneTool = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, tool) > 0;
        boolean hasSilkTouchTool = EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, tool) > 0;
        return !(hasFortuneLens && hasSilkTouchTool) || !(hasSilkTouchLens && hasFortuneTool);
    }

    /**
     * @param world Server World
     * @param state BlockState to generate drops for
     * @param lens Stored Lens
     * @param tool Stored Appropriate Tool for "breaking" the block
     * @param playerEntity Nullable Player
     * @param compoundNBT Nullable NBT for Tile-Entity Ores
     * @return List of ItemStack Drops generated from LootTables
     */
    public static List<ItemStack> getDrops(@Nonnull ServerWorld world, @Nonnull BlockState state, @Nullable ItemStack lens, @Nonnull ItemStack tool, @Nullable PlayerEntity playerEntity, @Nullable CompoundNBT compoundNBT) {
        Builder context = new Builder(world)
            .withParameter(LootParameters.BLOCK_STATE, state)
            .withParameter(LootParameters.TOOL, tool);
        if (lens != null) {
            context.withLuck(3.0F);
        }
        if (playerEntity != null) {
            context.withParameter(LootParameters.THIS_ENTITY, playerEntity);
        }
        if (compoundNBT != null) {
            TileEntity tileEntity = createTileEntityWithData(world, state, compoundNBT);
            if (tileEntity != null) {
                context.withParameter(LootParameters.BLOCK_ENTITY, tileEntity);
                return state.getDrops(context);
            }
        }
        return state.getDrops(context);
    }

    private static TileEntity createTileEntityWithData(IBlockReader reader, BlockState state, CompoundNBT nbt) {
        TileEntity tileEntity = state.createTileEntity(reader);
        if (tileEntity != null) {
            tileEntity.read(nbt);
            return tileEntity;
        }
        return null;
    }

    /**
     * @param state Blockstate being broken.
     * @param toolInventory Tool-Inventory
     * @return Returns the appropriate tool to use to break the tool.
     */
    public static ItemStack getAppropriateTool(BlockState state, SidedInventoryComponent toolInventory) {
        switch (state.getHarvestTool().getName()) {
            case "axe": return toolInventory.getStackInSlot(0);
            case "shovel": return toolInventory.getStackInSlot(1);
            case "pickaxe": return toolInventory.getStackInSlot(2);
            default: return ItemStack.EMPTY;
        }
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
        if (lens.isEmpty()) {
            return EntryHelper.getEntries();
        }
        return EntryHelper.getEntries().stream()
            .filter(entry -> entry.getLens().test(lens))
            .collect(Collectors.toList());
    }

}
