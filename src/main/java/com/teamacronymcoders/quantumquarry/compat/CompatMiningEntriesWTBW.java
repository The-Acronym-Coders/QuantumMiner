package com.teamacronymcoders.quantumquarry.compat;

import com.teamacronymcoders.quantumquarry.QuantumQuarry;
import com.teamacronymcoders.quantumquarry.recipe.DatagenMinerEntry;
import com.teamacronymcoders.quantumquarry.recipe.MinerEntry;
import com.teamacronymcoders.quantumquarry.registry.QuantumQuarryRegistryHandler;
import com.wtbw.mods.core.block.WTBWCoreBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;

import java.util.function.Consumer;

public class CompatMiningEntriesWTBW extends DefaultCompatMiningEntries {

    public CompatMiningEntriesWTBW(Consumer<DatagenMinerEntry> consumer) {
        super(consumer);
    }

    @Override
    public void addOres(Consumer<DatagenMinerEntry> consumer) {
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    30,
                    new ResourceLocation(QuantumQuarry.MODID, "wtbwcore_copper_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.ORANGE_LENS.get()),
                    WTBWCoreBlocks.COPPER_ORE
                ),
                new ModLoadedCondition("wtbw_core")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    30,
                    new ResourceLocation(QuantumQuarry.MODID, "wtbwcore_cobalt_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.BLUE_LENS.get()),
                    WTBWCoreBlocks.COBALT_ORE
                ),
                new ModLoadedCondition("wtbw_core")
            )
        );
    }
}
