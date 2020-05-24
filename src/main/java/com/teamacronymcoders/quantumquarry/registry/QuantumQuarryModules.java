package com.teamacronymcoders.quantumquarry.registry;

import com.hrznstudio.titanium.module.Feature;
import com.hrznstudio.titanium.module.Module;
import com.teamacronymcoders.quantumquarry.QuantumQuarry;
import com.teamacronymcoders.quantumquarry.quarry.QuarryBlock;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

public class QuantumQuarryModules {
    public static final Module.Builder core = Module.builder("core")
        .force()
        .description("core-content")
        .feature(
            Feature.builder("core")
            .force()
            .content(Block.class, new QuarryBlock().setRegistryName(new ResourceLocation(QuantumQuarry.MODID, "quarry")))
        );
}
