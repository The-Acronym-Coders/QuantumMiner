package com.teamacronymcoders.quantumquarry;

import com.hrznstudio.titanium.json.JsonLoader;
import com.hrznstudio.titanium.module.ModuleController;
import com.hrznstudio.titanium.recipe.generator.BlockItemModelGeneratorProvider;
import com.hrznstudio.titanium.tab.TitaniumTab;
import com.teamacronymcoders.quantumquarry.datagen.extendable.MinerEntryDataProvider;
import com.teamacronymcoders.quantumquarry.datagen.QuantumTagDataProvider;
import com.teamacronymcoders.quantumquarry.recipe.EntryHelper;
import com.teamacronymcoders.quantumquarry.json.MinerEntryJsonDirector;
import com.teamacronymcoders.quantumquarry.json.MinerEntryJsonProvider;
import com.teamacronymcoders.quantumquarry.registry.QuantumQuarryModules;
import com.teamacronymcoders.quantumquarry.registry.QuantumQuarryRegistryHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.event.server.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

@Mod("quantumquarry")
public class QuantumQuarry extends ModuleController {

    public static final String MODID = "quantumquarry";
    public static final Random RANDOM = new Random();
    public static final Logger LOGGER = LogManager.getLogger("Quantum Quarry");
    public static final TitaniumTab QMTAB = new TitaniumTab("Quantum Quarry", () -> ItemStack.EMPTY);

    public QuantumQuarry() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        QuantumQuarryRegistryHandler.register(eventBus);
        eventBus.addListener(QuantumQuarry::serverAboutToStart);
        ModLoadingContext.get().registerConfig(Type.COMMON, QuantumConfig.initialize(), MODID + "/general.toml");
    }

    @Override
    public void addDataProvider(GatherDataEvent event) {
        new MinerEntryDataProvider(event.getGenerator());
        new BlockItemModelGeneratorProvider(event.getGenerator(), MODID);
        new QuantumTagDataProvider.ItemTags(event.getGenerator());
    }

    @Override
    protected void initModules() {
        addModule(QuantumQuarryModules.core);
    }

    private static void serverAboutToStart(FMLServerAboutToStartEvent event) {
        event.getServer().getResourceManager().addReloadListener(new JsonLoader<>(MODID + "/entries", LOGGER, new MinerEntryJsonDirector(EntryHelper.getEntries()), new MinerEntryJsonProvider()));
    }

}
