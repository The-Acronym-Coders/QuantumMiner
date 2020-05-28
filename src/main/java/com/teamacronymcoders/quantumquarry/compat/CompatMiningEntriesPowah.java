package com.teamacronymcoders.quantumquarry.compat;

import com.teamacronymcoders.quantumquarry.QuantumQuarry;
import com.teamacronymcoders.quantumquarry.recipe.DatagenMinerEntry;
import com.teamacronymcoders.quantumquarry.recipe.MinerEntry;
import com.teamacronymcoders.quantumquarry.registry.QuantumQuarryRegistryHandler;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import owmii.powah.block.IBlocks;

import java.util.function.Consumer;

public class CompatMiningEntriesPowah extends DefaultCompatMiningEntries {

    public CompatMiningEntriesPowah(Consumer<DatagenMinerEntry> consumer) {
        super(consumer);
    }

    @Override
    public void addOres(Consumer<DatagenMinerEntry> consumer) {
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    30,
                    new ResourceLocation(QuantumQuarry.MODID, "powah_uranite_ore_poor"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.GREEN_LENS.get()),
                    IBlocks.URANINITE_ORE_POOR
                ),
                new ModLoadedCondition("powah")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    15,
                    new ResourceLocation(QuantumQuarry.MODID, "powah_uranite_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.GREEN_LENS.get()),
                    IBlocks.URANINITE_ORE
                ),
                new ModLoadedCondition("powah")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    5,
                    new ResourceLocation(QuantumQuarry.MODID, "powah_uranite_ore_dense"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.GREEN_LENS.get()),
                    IBlocks.URANINITE_ORE_DENSE
                ),
                new ModLoadedCondition("powah")
            )
        );
    }
}
