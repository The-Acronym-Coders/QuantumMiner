package com.teamacronymcoders.quantumquarry;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

public class QuantumConfig {
    private static QuantumConfig instance;
    private final ForgeConfigSpec spec;

    private static ForgeConfigSpec.BooleanValue shouldToolsTakeDamage;
    private static ForgeConfigSpec.IntValue baseCost;
    private static ForgeConfigSpec.IntValue efficiencyReduction;
    private static ForgeConfigSpec.IntValue minimumPowerDrain;
    private static ForgeConfigSpec.IntValue maxPowerStorage;

    private static ForgeConfigSpec.BooleanValue shouldAirExistInTheQuarryPool;
    private static ForgeConfigSpec.IntValue airWeightedValue;

    private static ForgeConfigSpec.BooleanValue shouldDoDetailedJsonLogging;

    public QuantumConfig(ForgeConfigSpec.Builder builder) {
        builder.push("General");
        shouldToolsTakeDamage = builder.comment("Should tools take damage").define("shouldToolsTakeDamage", false);
        baseCost = builder.comment("Base Energy Cost per Operation").defineInRange("baseCost", 2000, 1, Integer.MAX_VALUE);
        efficiencyReduction = builder.comment("Amount of Power Reduced per Level of Efficiency").defineInRange("efficiencyReduction", 200, 1, Integer.MAX_VALUE);
        minimumPowerDrain = builder.comment("Minimum amount of power drained each operation").defineInRange("minimumPowerDrain", 200, 1, Integer.MAX_VALUE);
        maxPowerStorage = builder.comment("Maximum Capacity Power Storage of the Quarry").defineInRange("maxPowerStorage", 1600000, 1, Integer.MAX_VALUE);
        shouldDoDetailedJsonLogging = builder.comment("Should the mod print more detailed errors related to JSON loading?").define("shouldDoDetailedJsonLogging", false);
        shouldAirExistInTheQuarryPool = builder.comment("Should 'Air' exist as a valid entry in the quarry pool").define("shouldAirExistInTheQuarryPool", false);
        airWeightedValue = builder.comment("The Weighted Value for Air existing in the Quarry Pool [Requires 'shouldAirExistInTheQuarryPool' to be true]").defineInRange("airWeightedValue", 50, 0, Integer.MAX_VALUE);
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

    public static boolean getShouldAirExistInTheQuarryPool() {
        return shouldAirExistInTheQuarryPool.get();
    }

    public static int getAirWeightedValue() {
        return airWeightedValue.get();
    }

    public static boolean getShouldDoDetailedJsonLogging() {
        return shouldDoDetailedJsonLogging.get();
    }
}
