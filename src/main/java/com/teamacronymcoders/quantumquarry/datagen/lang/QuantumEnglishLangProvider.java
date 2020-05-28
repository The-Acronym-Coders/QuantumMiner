package com.teamacronymcoders.quantumquarry.datagen.lang;

import com.teamacronymcoders.quantumquarry.registry.QuantumQuarryRegistryHandler;
import net.minecraft.data.DataGenerator;

public class QuantumEnglishLangProvider extends QuantumBaseLangProvider {

    public QuantumEnglishLangProvider(DataGenerator gen) {
        super(gen, "en_us");
    }

    @Override
    protected void addTranslations() {
        addBlocks();
        addItems();
        addLocalization();
    }

    private void addBlocks() {
        add(QuantumQuarryRegistryHandler.quarryBlock, "Quantum Quarry");
    }

    private void addItems() {
        // Plastic Hammer
        add(QuantumQuarryRegistryHandler.PLASTIC_HAMMER.get(), "Plastic Hammer");

        // Player Card
        add(QuantumQuarryRegistryHandler.PLAYER_CARD.get(), "Player Card");

        // Lenses
        add(QuantumQuarryRegistryHandler.WHITE_LENS.get(), "White Focusing Lens");
        add(QuantumQuarryRegistryHandler.ORANGE_LENS.get(), "Orange Focusing Lens");
        add(QuantumQuarryRegistryHandler.MAGENTA_LENS.get(), "Magenta Focusing Lens");
        add(QuantumQuarryRegistryHandler.LIGHT_BLUE_LENS.get(), "Light-Blue Focusing Lens");
        add(QuantumQuarryRegistryHandler.YELLOW_LENS.get(), "Yellow Focusing Lens");
        add(QuantumQuarryRegistryHandler.LIME_LENS.get(), "Lime Focusing Lens");
        add(QuantumQuarryRegistryHandler.PINK_LENS.get(), "Pink Focusing Lens");
        add(QuantumQuarryRegistryHandler.GRAY_LENS.get(), "Gray Focusing Lens");
        add(QuantumQuarryRegistryHandler.LIGHT_GRAY_LENS.get(), "Light-Gray Focusing Lens");
        add(QuantumQuarryRegistryHandler.CYAN_LENS.get(), "Cyan Focusing Lens");
        add(QuantumQuarryRegistryHandler.PURPLE_LENS.get(), "Purple Focusing Lens");
        add(QuantumQuarryRegistryHandler.BLUE_LENS.get(), "Blue Focusing Lens");
        add(QuantumQuarryRegistryHandler.BROWN_LENS.get(), "Brown Focusing Lens");
        add(QuantumQuarryRegistryHandler.GREEN_LENS.get(), "Green Focusing Lens");
        add(QuantumQuarryRegistryHandler.RED_LENS.get(), "Red Focusing Lens");
        add(QuantumQuarryRegistryHandler.BLACK_LENS.get(), "Black Focusing Lens");
    }

    private void addLocalization() {
        add("itemGroup.quantum_quarry", "Quantum Quarry");
        add("tooltip.playercard.id", "Player with ID: %s");
        add("tooltip.titanium.facing_handler.tool_inventory", "Tools");
        add("tooltip.titanium.facing_handler.lens_inventory", "Lens");
        add("tooltip.titanium.facing_handler.storage_inventory", "Storage");
        add("tooltip.titanium.facing_handler.energy_inventory", "Power Slot");
        add("tooltip.titanium.facing_handler.card_inventory", "Player Card");
    }

}
