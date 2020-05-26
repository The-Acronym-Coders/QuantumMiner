package com.teamacronymcoders.quantumquarry.datagen;

import com.teamacronymcoders.quantumquarry.compat.MiningEntryMinecraft;
import com.teamacronymcoders.quantumquarry.datagen.extendable.MinerEntryDataProvider;
import com.teamacronymcoders.quantumquarry.recipe.DatagenMinerEntry;
import net.minecraft.data.DataGenerator;

import java.util.function.Consumer;

public class QuantumMinerEntryDataProvider extends MinerEntryDataProvider{

    public QuantumMinerEntryDataProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void addMinerEntries(Consumer<DatagenMinerEntry> consumer) {
        MiningEntryMinecraft.addMinecraftOres(consumer);
    }

    @Override
    public String getName() {
        return "QQ: Miner Entries";
    }
}
