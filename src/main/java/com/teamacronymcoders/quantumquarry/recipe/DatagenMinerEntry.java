package com.teamacronymcoders.quantumquarry.recipe;

import net.minecraftforge.common.crafting.conditions.ICondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatagenMinerEntry {
    private final MinerEntry entry;
    private final List<ICondition> conditions;

    public DatagenMinerEntry(MinerEntry entry, ICondition... conditions) {
        this.entry = entry;
        this.conditions = new ArrayList<>();
        this.conditions.addAll(Arrays.asList(conditions));
    }

    public MinerEntry getEntry() {
        return entry;
    }

    public List<ICondition> getConditions() {
        return conditions;
    }
}
