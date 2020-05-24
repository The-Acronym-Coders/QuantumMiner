package com.teamacronymcoders.quantumquarry.datagen;

import com.teamacronymcoders.quantumquarry.QuantumQuarry;
import com.teamacronymcoders.quantumquarry.item.LensItem;
import com.teamacronymcoders.quantumquarry.registry.QuantumQuarryRegistryHandler;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags.Wrapper;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class QuantumTagDataProvider {

    public static class ItemTags extends ItemTagsProvider {
        public static final Tag<Item> LensTag = new Wrapper(new ResourceLocation(QuantumQuarry.MODID, "lens"));

        public ItemTags(DataGenerator generatorIn) {
            super(generatorIn);
        }

        @Override
        protected void registerTags() {
            super.registerTags();
            getBuilder(LensTag).add(
                QuantumQuarryRegistryHandler.WHITE_LENS.get(),
                QuantumQuarryRegistryHandler.ORANGE_LENS.get(),
                QuantumQuarryRegistryHandler.MAGENTA_LENS.get(),
                QuantumQuarryRegistryHandler.LIGHT_BLUE_LENS.get(),
                QuantumQuarryRegistryHandler.YELLOW_LENS.get(),
                QuantumQuarryRegistryHandler.LIME_LENS.get(),
                QuantumQuarryRegistryHandler.PINK_LENS.get(),
                QuantumQuarryRegistryHandler.GRAY_LENS.get(),
                QuantumQuarryRegistryHandler.LIGHT_GRAY_LENS.get(),
                QuantumQuarryRegistryHandler.CYAN_LENS.get(),
                QuantumQuarryRegistryHandler.PURPLE_LENS.get(),
                QuantumQuarryRegistryHandler.BLUE_LENS.get(),
                QuantumQuarryRegistryHandler.BROWN_LENS.get(),
                QuantumQuarryRegistryHandler.GREEN_LENS.get(),
                QuantumQuarryRegistryHandler.RED_LENS.get(),
                QuantumQuarryRegistryHandler.BLACK_LENS.get()
            );
        }
    }
}
