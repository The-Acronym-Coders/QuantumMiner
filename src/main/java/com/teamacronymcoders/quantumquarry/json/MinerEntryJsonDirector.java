package com.teamacronymcoders.quantumquarry.json;

import com.hrznstudio.titanium.json.jsondirector.IJsonDirector;
import com.teamacronymcoders.quantumquarry.QuantumQuarry;
import com.teamacronymcoders.quantumquarry.recipe.MinerEntry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.ModList;

import java.util.List;

public class MinerEntryJsonDirector implements IJsonDirector<MinerEntry> {

    private final List<MinerEntry> entries;

    public MinerEntryJsonDirector(List<MinerEntry> entries) {
        this.entries = entries;
    }

    @Override
    public void put(ResourceLocation resourceLocation, MinerEntry entry) {
        if (entry != null) {
            entries.add(entry);
        }
    }

    @Override
    public void clear() {
        entries.clear();
    }
}
