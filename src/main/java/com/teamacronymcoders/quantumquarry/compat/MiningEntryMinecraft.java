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

public class MiningEntryMinecraft {

    public static void addMinecraftOres(Consumer<DatagenMinerEntry> consumer) {
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    30D,
                    new ResourceLocation(QuantumQuarry.MODID, "coal_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.BLACK_LENS.get()),
                    Blocks.COAL_ORE.getDefaultState(),
                    null
                ),
                new ModLoadedCondition("minecraft")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    20D,
                    new ResourceLocation(QuantumQuarry.MODID, "iron_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.BROWN_LENS.get()),
                    Blocks.IRON_ORE.getDefaultState(),
                    null
                ),
                new ModLoadedCondition("minecraft")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    13D,
                    new ResourceLocation(QuantumQuarry.MODID, "gold_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.YELLOW_LENS.get()),
                    Blocks.GOLD_ORE.getDefaultState(),
                    null
                ),
                new ModLoadedCondition("miencraft")
            )

        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    15D,
                    new ResourceLocation(QuantumQuarry.MODID, "redstone_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.RED_LENS.get()),
                    Blocks.REDSTONE_ORE.getDefaultState(),
                    null
                ),
                new ModLoadedCondition("minecraft")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    10D,
                    new ResourceLocation(QuantumQuarry.MODID, "lapis_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.BLUE_LENS.get()),
                    Blocks.LAPIS_ORE.getDefaultState(),
                    null
                ),
                new ModLoadedCondition("minecraft")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    2D,
                    new ResourceLocation(QuantumQuarry.MODID, "diamond_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.CYAN_LENS.get()),
                    Blocks.DIAMOND_ORE.getDefaultState(),
                    null
                ),
                new ModLoadedCondition("minecraft")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    10D,
                    new ResourceLocation(QuantumQuarry.MODID, "quartz_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.WHITE_LENS.get()),
                    Blocks.NETHER_QUARTZ_ORE.getDefaultState(),
                    null
                ),
                new ModLoadedCondition("minecraft")
            )
        );
    }
}
