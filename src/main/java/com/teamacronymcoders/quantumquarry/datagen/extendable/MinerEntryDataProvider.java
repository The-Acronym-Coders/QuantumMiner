package com.teamacronymcoders.quantumquarry.datagen.extendable;

import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.teamacronymcoders.quantumquarry.QuantumQuarry;
import com.teamacronymcoders.quantumquarry.recipe.MinerEntry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;
import java.nio.file.Path;
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
        Consumer<MinerEntry> consumer = (entry) -> {
            if (!set.add(entry.getId())) {
                throw new IllegalStateException("Duplicate Miner Entry ID " + entry.getId());
            } else {
                Path path1 = pathIn.resolve("data/" + entry.getId().getNamespace() + "/miningentries/" + entry.getId().getPath() + ".json");
                try {
                    IDataProvider.save(GSON, cache, new MinerEntry(entry.getModid(), entry.getWeight(), entry.getId(), entry.getLens(), entry.getState(), entry.getData()).serialize(), path1);
                } catch (IOException ioException) {
                    QuantumQuarry.LOGGER.error("Couldn't save miner entry {}", path1, ioException);
                }
            }
        };
        addMinerEntries(consumer);
    }

    protected void addMinerEntries(Consumer<MinerEntry> consumer) {}

    @Override
    public String getName() {
        return "QQ: Miner Entries";
    }
}
