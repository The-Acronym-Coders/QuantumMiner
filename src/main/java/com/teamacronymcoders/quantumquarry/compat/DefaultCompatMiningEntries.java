package com.teamacronymcoders.quantumquarry.compat;

import com.teamacronymcoders.quantumquarry.recipe.DatagenMinerEntry;

import java.util.function.Consumer;

public abstract class DefaultCompatMiningEntries {

    public DefaultCompatMiningEntries(Consumer<DatagenMinerEntry> consumer) {
        addOres(consumer);
    }

    public abstract void addOres(Consumer<DatagenMinerEntry> consumer);
}
