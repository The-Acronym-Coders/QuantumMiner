package com.teamacronymcoders.quantumquarry.datagen;

import com.teamacronymcoders.quantumquarry.compat.*;
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
        new CompatMiningEntriesMinecraft(consumer);
        new CompatMiningEntriesMekanism(consumer);
        new CompatMiningEntriesMysticalAgriculture(consumer);
        new CompatMiningEntriesPowah(consumer);
        new CompatMiningEntriesSilentsGems(consumer);
        new CompatMiningEntriesSilentsMechanisms(consumer);
        new CompatMiningEntriesWTBW(consumer);
    }

    @Override
    public String getName() {
        return "QQ: Miner Entries";
    }
}
