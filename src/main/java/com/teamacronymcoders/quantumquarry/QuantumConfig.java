package com.teamacronymcoders.quantumquarry;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.Builder;

public class QuantumConfig {
    private static QuantumConfig instance;
    private final ForgeConfigSpec spec;

    private static ForgeConfigSpec.BooleanValue shouldToolsTakeDamage;
    private static ForgeConfigSpec.IntValue baseCost;
    private static ForgeConfigSpec.IntValue efficiencyReduction;
    private static ForgeConfigSpec.IntValue minimumPowerDrain;
    private static ForgeConfigSpec.IntValue maxPowerStorage;

    private static ForgeConfigSpec.BooleanValue shouldDoDetailedJsonLogging;

    public QuantumConfig(ForgeConfigSpec.Builder builder) {
        builder.push("General");
        shouldToolsTakeDamage = builder.comment("Should tools take damage").define("shouldToolsTakeDamage", false);
        baseCost = builder.comment("Base Operation Cost").defineInRange("baseCost", 2000, 1, Integer.MAX_VALUE);
        efficiencyReduction = builder.comment("Base Operation Cost").defineInRange("baseCost", 2000, 1, Integer.MAX_VALUE);
        minimumPowerDrain = builder.comment("Base Operation Cost").defineInRange("baseCost", 2000, 1, Integer.MAX_VALUE);
        maxPowerStorage = builder.comment("Base Operation Cost").defineInRange("baseCost", 50000, 1, Integer.MAX_VALUE);
        shouldDoDetailedJsonLogging = builder.comment("Should the mod print more detailed errors related to JSON loading?").define("shouldDoDetailedJsonLogging", false);
        this.spec = builder.build();
    }

    public static ForgeConfigSpec initialize() {
        QuantumConfig config = new QuantumConfig(new Builder());
        instance = config;
        return config.getSpec();
    }

    public static QuantumConfig getInstance() {
        return instance;
    }

    public ForgeConfigSpec getSpec() {
        return spec;
    }

    public static boolean getShouldToolsTakeDamage() {
        return shouldToolsTakeDamage.get();
    }

    public static int getBaseCost() {
        return baseCost.get();
    }

    public static int getEfficiencyReduction() {
        return efficiencyReduction.get();
    }

    public static int getMinimumPowerDrain() {
        return minimumPowerDrain.get();
    }

    public static int getMaxPowerStorage() {
        return maxPowerStorage.get();
    }

    public static boolean getShouldDoDetailedJsonLogging() {
        return shouldDoDetailedJsonLogging.get();
    }
}
