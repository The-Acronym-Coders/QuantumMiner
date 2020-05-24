package com.teamacronymcoders.quantumquarry.datagen;

import com.mojang.datafixers.util.Pair;
import com.teamacronymcoders.quantumquarry.QuantumQuarry;
import com.teamacronymcoders.quantumquarry.registry.QuantumQuarryRegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Optional;
import java.util.stream.Collectors;

public class LootTableDataProvider extends BlockLootTables {

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getValues().stream()
            .filter(entity -> Optional.ofNullable(entity.getRegistryName())
                .filter(registryName -> registryName.getNamespace().equals(QuantumQuarry.MODID)).isPresent()
            ).collect(Collectors.toList());
    }

    @Override
    protected void addTables() {
        this.registerDropSelfLootTable(QuantumQuarryRegistryHandler.quarryBlock);
    }
}
