package com.teamacronymcoders.quantumquarry.datagen.extendable;

import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.teamacronymcoders.quantumquarry.QuantumQuarry;
import com.teamacronymcoders.quantumquarry.json.JsonHelper;
import com.teamacronymcoders.quantumquarry.recipe.DatagenMinerEntry;
import com.teamacronymcoders.quantumquarry.recipe.MinerEntry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import org.apache.commons.lang3.tuple.Pair;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class MinerEntryDataProvider implements IDataProvider {

    private static final Gson GSON = (new GsonBuilder()).disableHtmlEscaping().setPrettyPrinting().create();
    private final DataGenerator generator;

    public MinerEntryDataProvider(DataGenerator generator) {
        this.generator = generator;
    }

    @Override
    public void act(DirectoryCache cache) {
        Path pathIn = this.generator.getOutputFolder();
        Set<ResourceLocation> set = Sets.newHashSet();
        Consumer<DatagenMinerEntry> consumer = (entry) -> {
            if (!set.add(entry.getEntry().getId())) {
                throw new IllegalStateException("Duplicate Miner Entry ID " + entry.getEntry().getId());
            } else {
                Path path1 = pathIn.resolve("data/" + entry.getEntry().getId().getNamespace() + "/entries/" + entry.getEntry().getId().getPath() + ".json");
                try {
                    IDataProvider.save(GSON, cache, JsonHelper.serializeMinerEntry(entry.getEntry(), entry.getConditions()), path1);
                } catch (IOException ioException) {
                    QuantumQuarry.LOGGER.error("Couldn't save miner entry {}", path1, ioException);
                }
            }
        };
        addMinerEntries(consumer);
    }

    protected void addMinerEntries(Consumer<DatagenMinerEntry> consumer) {}

    @Override
    public String getName() {
        return "Miner Entries";
    }
}
