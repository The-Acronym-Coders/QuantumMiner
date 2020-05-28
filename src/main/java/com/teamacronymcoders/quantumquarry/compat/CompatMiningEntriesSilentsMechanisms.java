package com.teamacronymcoders.quantumquarry.compat;

import com.teamacronymcoders.quantumquarry.QuantumQuarry;
import com.teamacronymcoders.quantumquarry.recipe.DatagenMinerEntry;
import com.teamacronymcoders.quantumquarry.recipe.MinerEntry;
import com.teamacronymcoders.quantumquarry.registry.QuantumQuarryRegistryHandler;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import net.silentchaos512.mechanisms.init.Ores;

import java.util.function.Consumer;

public class CompatMiningEntriesSilentsMechanisms  extends DefaultCompatMiningEntries {

    public CompatMiningEntriesSilentsMechanisms(Consumer<DatagenMinerEntry> consumer) {
        super(consumer);
    }

    @Override
    public void addOres(Consumer<DatagenMinerEntry> consumer) {
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    30,
                    new ResourceLocation(QuantumQuarry.MODID, "silentmechanisms_copper_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.ORANGE_LENS.get()),
                    Ores.COPPER.getBlock()
                ),
                new ModLoadedCondition("silents_mechanisms")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    30,
                    new ResourceLocation(QuantumQuarry.MODID, "silentmechanisms_tin_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.LIGHT_BLUE_LENS.get()),
                    Ores.TIN.getBlock()
                ),
                new ModLoadedCondition("silents_mechanisms")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    30,
                    new ResourceLocation(QuantumQuarry.MODID, "silentmechanisms_silver_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.LIGHT_GRAY_LENS.get()),
                    Ores.SILVER.getBlock()
                ),
                new ModLoadedCondition("silents_mechanisms")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    30,
                    new ResourceLocation(QuantumQuarry.MODID, "silentmechanisms_lead_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.PURPLE_LENS.get()),
                    Ores.LEAD.getBlock()
                ),
                new ModLoadedCondition("silents_mechanisms")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    30,
                    new ResourceLocation(QuantumQuarry.MODID, "silentmechanisms_nickel_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.YELLOW_LENS.get()),
                    Ores.NICKEL.getBlock()
                ),
                new ModLoadedCondition("silents_mechanisms")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    30,
                    new ResourceLocation(QuantumQuarry.MODID, "silentmechanisms_platinum_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.CYAN_LENS.get()),
                    Ores.PLATINUM.getBlock()
                ),
                new ModLoadedCondition("silents_mechanisms")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    30,
                    new ResourceLocation(QuantumQuarry.MODID, "silentmechanisms_zinc_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.LIGHT_GRAY_LENS.get()),
                    Ores.ZINC.getBlock()
                ),
                new ModLoadedCondition("silents_mechanisms")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    30,
                    new ResourceLocation(QuantumQuarry.MODID, "silentmechanisms_bismuth_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.LIGHT_BLUE_LENS.get()),
                    Ores.BISMUTH.getBlock()
                ),
                new ModLoadedCondition("silents_mechanisms")
            )
        );

        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    30,
                    new ResourceLocation(QuantumQuarry.MODID, "silentmechanisms_bauxite_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.ORANGE_LENS.get()),
                    Ores.BAUXITE.getBlock()
                ),
                new ModLoadedCondition("silents_mechanisms")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    30,
                    new ResourceLocation(QuantumQuarry.MODID, "silentmechanisms_uranium_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.GREEN_LENS.get()),
                    Ores.URANIUM.getBlock()
                ),
                new ModLoadedCondition("silents_mechanisms")
            )
        );
    }
}
