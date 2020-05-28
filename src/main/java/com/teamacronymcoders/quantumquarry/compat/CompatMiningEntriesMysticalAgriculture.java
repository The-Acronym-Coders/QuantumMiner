package com.teamacronymcoders.quantumquarry.compat;

import com.blakebr0.mysticalagriculture.block.ModBlocks;
import com.teamacronymcoders.quantumquarry.QuantumQuarry;
import com.teamacronymcoders.quantumquarry.recipe.DatagenMinerEntry;
import com.teamacronymcoders.quantumquarry.recipe.MinerEntry;
import com.teamacronymcoders.quantumquarry.registry.QuantumQuarryRegistryHandler;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;

import java.util.function.Consumer;

public class CompatMiningEntriesMysticalAgriculture extends DefaultCompatMiningEntries {

    public CompatMiningEntriesMysticalAgriculture(Consumer<DatagenMinerEntry> consumer) {
        super(consumer);
    }

    @Override
    public void addOres(Consumer<DatagenMinerEntry> consumer) {
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    10,
                    new ResourceLocation(QuantumQuarry.MODID, "mysticalagriculture_inferium_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.ORANGE_LENS.get()),
                    ModBlocks.INFERIUM_ORE.get()
                ),
                new ModLoadedCondition("mysticalagriculture")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    5,
                    new ResourceLocation(QuantumQuarry.MODID, "mysticalagriculture_prosperity_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.ORANGE_LENS.get()),
                    ModBlocks.PROSPERITY_ORE.get()
                ),
                new ModLoadedCondition("mysticalagriculture")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    5,
                    new ResourceLocation(QuantumQuarry.MODID, "mysticalagriculture_soulium_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.BROWN_LENS.get()),
                    ModBlocks.SOULIUM_ORE.get()
                ),
                new ModLoadedCondition("mysticalagriculture")
            )
        );
    }
}
