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
                    Gems.RUBY.getBlock()
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
                    Gems.GARNET.getBlock()
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
                    Gems.RUBY.getBlock()
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
                    Gems.AMBER.getBlock()
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
                    Gems.HELIODOR.getBlock()
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
                    Gems.PERIDOT.getBlock()
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
                    Gems.GREEN_SAPPHIRE.getBlock()
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
                    Gems.PHOSPHOPHYLLITE.getBlock()
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
                    Gems.AQUAMARINE.getBlock()
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
                    Gems.SAPPHIRE.getBlock()
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
                    Gems.TANZANITE.getBlock()
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
                    Gems.AMETHYST.getBlock()
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
                    Gems.AGATE.getBlock()
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
                    Gems.MORGANITE.getBlock()
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
                    Gems.ONYX.getBlock()
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
                    Gems.OPAL.getBlock()
                ),
                new ModLoadedCondition("silentgems")
            )
        );

    }
}
