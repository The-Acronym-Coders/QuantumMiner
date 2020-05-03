package com.teamacronymcoders.quantumminer;

import com.hrznstudio.titanium.module.ModuleController;
import com.teamacronymcoders.quantumminer.registry.QuantumMinerRegistryHandler;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("quantumminer")
public class QuantumMiner extends ModuleController {

    private static final Logger LOGGER = LogManager.getLogger("Quantum Miner");

    public QuantumMiner() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::setup);
        eventBus.addListener(this::doClientStuff);
        QuantumMinerRegistryHandler.register(eventBus);
    }

    @Override
    protected void initModules() {}

    private void setup(final FMLCommonSetupEvent event) {}

    private void doClientStuff(final FMLClientSetupEvent event) {}

}
