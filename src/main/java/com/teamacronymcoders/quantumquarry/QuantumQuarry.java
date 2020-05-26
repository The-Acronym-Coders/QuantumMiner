package com.teamacronymcoders.quantumquarry;

import com.hrznstudio.titanium.json.JsonLoader;
import com.hrznstudio.titanium.module.ModuleController;
import com.hrznstudio.titanium.recipe.generator.BlockItemModelGeneratorProvider;
import com.hrznstudio.titanium.tab.TitaniumTab;
import com.teamacronymcoders.quantumquarry.datagen.QuantumMinerEntryDataProvider;
import com.teamacronymcoders.quantumquarry.datagen.QuantumTagDataProvider;
import com.teamacronymcoders.quantumquarry.json.MinerEntryJsonDirector;
import com.teamacronymcoders.quantumquarry.json.MinerEntryJsonProvider;
import com.teamacronymcoders.quantumquarry.quarry.QuarryHelper;
import com.teamacronymcoders.quantumquarry.registry.QuantumQuarryModules;
import com.teamacronymcoders.quantumquarry.registry.QuantumQuarryRegistryHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
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
        MinecraftForge.EVENT_BUS.addListener(QuantumQuarry::serverAboutToStart);
        ModLoadingContext.get().registerConfig(Type.COMMON, QuantumConfig.initialize(), "quantumquarry.toml");
    }

    @Override
    public void addDataProvider(GatherDataEvent event) {
        super.addDataProvider(event);
        event.getGenerator().addProvider(new QuantumMinerEntryDataProvider(event.getGenerator()));
        event.getGenerator().addProvider(new BlockItemModelGeneratorProvider(event.getGenerator(), MODID));
        event.getGenerator().addProvider(new QuantumTagDataProvider.ItemTags(event.getGenerator()));
    }

    @Override
    protected void initModules() {
        addModule(QuantumQuarryModules.core);
    }

    private static void serverAboutToStart(FMLServerAboutToStartEvent event) {
        event.getServer().getResourceManager().addReloadListener(new JsonLoader<>("entries", LOGGER, new MinerEntryJsonDirector(QuarryHelper.getEntries()), new MinerEntryJsonProvider()));
    }

}
