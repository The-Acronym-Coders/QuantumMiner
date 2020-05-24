package com.teamacronymcoders.quantumquarry.datagen;

import com.teamacronymcoders.quantumquarry.compat.MiningEntryMinecraft;
import com.teamacronymcoders.quantumquarry.datagen.extendable.MinerEntryDataProvider;
import com.teamacronymcoders.quantumquarry.recipe.MinerEntry;
import net.minecraft.data.DataGenerator;

import java.util.function.Consumer;

public class QuantumMinerEntryDataProvider extends MinerEntryDataProvider{

    public QuantumMinerEntryDataProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void addMinerEntries(Consumer<MinerEntry> consumer) {
        MiningEntryMinecraft.addMinecraftOres(consumer);

    }
}
