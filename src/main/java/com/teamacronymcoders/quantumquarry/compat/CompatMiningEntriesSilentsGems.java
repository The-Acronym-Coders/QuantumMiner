package com.teamacronymcoders.quantumquarry.compat;

import com.teamacronymcoders.quantumquarry.QuantumQuarry;
import com.teamacronymcoders.quantumquarry.recipe.DatagenMinerEntry;
import com.teamacronymcoders.quantumquarry.recipe.MinerEntry;
import com.teamacronymcoders.quantumquarry.registry.QuantumQuarryRegistryHandler;
import com.wtbw.mods.core.block.WTBWCoreBlocks;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import net.silentchaos512.gems.lib.Gems;

import java.util.Locale;
import java.util.function.Consumer;

public class CompatMiningEntriesSilentsGems extends DefaultCompatMiningEntries {

    public CompatMiningEntriesSilentsGems(Consumer<DatagenMinerEntry> consumer) {
        super(consumer);
    }

    @Override
    public void addOres(Consumer<DatagenMinerEntry> consumer) {
        // Standard Set
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    5,
                    new ResourceLocation(QuantumQuarry.MODID, "silentgems_ruby_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.RED_LENS.get()),
                    Gems.RUBY.getOre()
                ),
                new ModLoadedCondition("silentgems")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    5,
                    new ResourceLocation(QuantumQuarry.MODID, "silentgems_garnet_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.ORANGE_LENS.get()),
                    Gems.GARNET.getOre()
                ),
                new ModLoadedCondition("silentgems")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    5,
                    new ResourceLocation(QuantumQuarry.MODID, "silentgems_topaz_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.ORANGE_LENS.get()),
                    Gems.RUBY.getOre()
                ),
                new ModLoadedCondition("silentgems")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    5,
                    new ResourceLocation(QuantumQuarry.MODID, "silentgems_amber_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.ORANGE_LENS.get()),
                    Gems.AMBER.getOre()
                ),
                new ModLoadedCondition("silentgems")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    5,
                    new ResourceLocation(QuantumQuarry.MODID, "silentgems_heliodor_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.YELLOW_LENS.get()),
                    Gems.HELIODOR.getOre()
                ),
                new ModLoadedCondition("silentgems")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    5,
                    new ResourceLocation(QuantumQuarry.MODID, "silentgems_peridot_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.GREEN_LENS.get()),
                    Gems.PERIDOT.getOre()
                ),
                new ModLoadedCondition("silentgems")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    5,
                    new ResourceLocation(QuantumQuarry.MODID, "silentgems_green_sapphire_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.GREEN_LENS.get()),
                    Gems.GREEN_SAPPHIRE.getOre()
                ),
                new ModLoadedCondition("silentgems")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    5,
                    new ResourceLocation(QuantumQuarry.MODID, "silentgems_phosphophyllite_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.CYAN_LENS.get()),
                    Gems.PHOSPHOPHYLLITE.getOre()
                ),
                new ModLoadedCondition("silentgems")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    5,
                    new ResourceLocation(QuantumQuarry.MODID, "silentgems_aquamarine_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.LIGHT_BLUE_LENS.get()),
                    Gems.AQUAMARINE.getOre()
                ),
                new ModLoadedCondition("silentgems")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    5,
                    new ResourceLocation(QuantumQuarry.MODID, "silentgems_sapphire_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.BLUE_LENS.get()),
                    Gems.SAPPHIRE.getOre()
                ),
                new ModLoadedCondition("silentgems")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    5,
                    new ResourceLocation(QuantumQuarry.MODID, "silentgems_tanzanite_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.PURPLE_LENS.get()),
                    Gems.TANZANITE.getOre()
                ),
                new ModLoadedCondition("silentgems")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    5,
                    new ResourceLocation(QuantumQuarry.MODID, "silentgems_amethyst_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.PURPLE_LENS.get()),
                    Gems.AMETHYST.getOre()
                ),
                new ModLoadedCondition("silentgems")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    5,
                    new ResourceLocation(QuantumQuarry.MODID, "silentgems_agate_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.MAGENTA_LENS.get()),
                    Gems.AGATE.getOre()
                ),
                new ModLoadedCondition("silentgems")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    5,
                    new ResourceLocation(QuantumQuarry.MODID, "silentgems_morganite_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.PINK_LENS.get()),
                    Gems.MORGANITE.getOre()
                ),
                new ModLoadedCondition("silentgems")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    5,
                    new ResourceLocation(QuantumQuarry.MODID, "silentgems_onyx_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.BLACK_LENS.get()),
                    Gems.ONYX.getOre()
                ),
                new ModLoadedCondition("silentgems")
            )
        );
        consumer.accept(
            new DatagenMinerEntry(
                new MinerEntry(
                    5,
                    new ResourceLocation(QuantumQuarry.MODID, "silentgems_opal_ore"),
                    Ingredient.fromItems(QuantumQuarryRegistryHandler.WHITE_LENS.get()),
                    Gems.OPAL.getOre()
                ),
                new ModLoadedCondition("silentgems")
            )
        );

    }
}
