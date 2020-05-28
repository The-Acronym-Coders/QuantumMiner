package com.teamacronymcoders.quantumquarry.compat;

import com.teamacronymcoders.quantumquarry.QuantumQuarry;
import com.teamacronymcoders.quantumquarry.recipe.DatagenMinerEntry;
import com.teamacronymcoders.quantumquarry.recipe.MinerEntry;
import com.teamacronymcoders.quantumquarry.registry.QuantumQuarryRegistryHandler;
import mekanism.common.registries.MekanismBlocks;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;

import java.util.function.Consumer;

public class CompatMiningEntriesMekanism extends DefaultCompatMiningEntries {

    public CompatMiningEntriesMekanism(Consumer<DatagenMinerEntry> consumer) {
        super(consumer);
    }

    @Override
    public void addOres(Consumer<DatagenMinerEntry> consumer) {
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    30,
                    new ResourceLocation(QuantumQuarry.MODID, "mekanism_copper_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.ORANGE_LENS.get()),
                    MekanismBlocks.COPPER_ORE.getBlock()
                ),
                new ModLoadedCondition("mekanism")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    30,
                    new ResourceLocation(QuantumQuarry.MODID, "mekanism_tin_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.CYAN_LENS.get()),
                    MekanismBlocks.TIN_ORE.getBlock()
                ),
                new ModLoadedCondition("mekanism")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    20,
                    new ResourceLocation(QuantumQuarry.MODID, "mekanism_osmium_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.LIGHT_BLUE_LENS.get()),
                    MekanismBlocks.OSMIUM_ORE.getBlock()
                ),
                new ModLoadedCondition("mekanism")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    10,
                    new ResourceLocation(QuantumQuarry.MODID, "mekanism_salt_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.WHITE_LENS.get()),
                    MekanismBlocks.SALT_BLOCK.getBlock()
                ),
                new ModLoadedCondition("mekanism")
            )
        );
    }
}
