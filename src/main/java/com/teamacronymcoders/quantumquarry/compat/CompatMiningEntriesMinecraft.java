package com.teamacronymcoders.quantumquarry.compat;

import com.teamacronymcoders.quantumquarry.QuantumQuarry;
import com.teamacronymcoders.quantumquarry.recipe.DatagenMinerEntry;
import com.teamacronymcoders.quantumquarry.recipe.MinerEntry;
import com.teamacronymcoders.quantumquarry.registry.QuantumQuarryRegistryHandler;
import net.minecraft.block.Blocks;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;

import java.util.function.Consumer;

public class CompatMiningEntriesMinecraft extends DefaultCompatMiningEntries {

    public CompatMiningEntriesMinecraft(Consumer<DatagenMinerEntry> consumer) {
        super(consumer);
    }

    @Override
    public void addOres(Consumer<DatagenMinerEntry> consumer) {
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    30,
                    new ResourceLocation(QuantumQuarry.MODID, "minecraft_coal_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.BLACK_LENS.get()),
                    Blocks.COAL_ORE
                ),
                new ModLoadedCondition("minecraft")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    20,
                    new ResourceLocation(QuantumQuarry.MODID, "minecraft_iron_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.BROWN_LENS.get()),
                    Blocks.IRON_ORE
                ),
                new ModLoadedCondition("minecraft")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    13,
                    new ResourceLocation(QuantumQuarry.MODID, "minecraft_gold_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.YELLOW_LENS.get()),
                    Blocks.GOLD_ORE
                ),
                new ModLoadedCondition("miencraft")
            )

        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    15,
                    new ResourceLocation(QuantumQuarry.MODID, "minecraft_redstone_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.RED_LENS.get()),
                    Blocks.REDSTONE_ORE
                ),
                new ModLoadedCondition("minecraft")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    10,
                    new ResourceLocation(QuantumQuarry.MODID, "minecraft_lapis_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.BLUE_LENS.get()),
                    Blocks.LAPIS_ORE
                ),
                new ModLoadedCondition("minecraft")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    2,
                    new ResourceLocation(QuantumQuarry.MODID, "minecraft_diamond_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.CYAN_LENS.get()),
                    Blocks.DIAMOND_ORE
                ),
                new ModLoadedCondition("minecraft")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    10,
                    new ResourceLocation(QuantumQuarry.MODID, "minecraft_quartz_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.WHITE_LENS.get()),
                    Blocks.NETHER_QUARTZ_ORE
                ),
                new ModLoadedCondition("minecraft")
            )
        );
    }
}
