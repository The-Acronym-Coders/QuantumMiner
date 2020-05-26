package com.teamacronymcoders.quantumquarry.json;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.hrznstudio.titanium.json.IJsonProvider;
import com.teamacronymcoders.quantumquarry.QuantumConfig;
import com.teamacronymcoders.quantumquarry.QuantumQuarry;
import com.teamacronymcoders.quantumquarry.recipe.MinerEntry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.ModList;

public class MinerEntryJsonProvider implements IJsonProvider<MinerEntry> {

    @Override
    public MinerEntry provide(ResourceLocation resourceLocation, JsonObject jsonObject) throws JsonParseException {
        MinerEntry entry = new MinerEntry();
        if (!jsonObject.has("modid")) {
            QuantumQuarry.LOGGER.error("Mining Entry is missing 'modid' field!");
        } else {
            String modid = jsonObject.get("modid").getAsString();
            if (!ModList.get().isLoaded(modid)) {
                if (QuantumConfig.getShouldDoDetailedJsonLogging()) {
                    QuantumQuarry.LOGGER.error("Couldn't load Mining Entry with ID: {}, Mod for ModID: {}, Was not loaded!", resourceLocation.toString(), modid);
                }
            }
        }
        if (jsonObject.has("id") && jsonObject.has("weight") && jsonObject.has("lens") && jsonObject.has("state")) {
            entry.deserialize(jsonObject);
            return entry;
        }
        QuantumQuarry.LOGGER.error("Mining Entry with ID: {}, Did not have one of the following fields: 'id', 'weight', 'lens' or 'state'", resourceLocation.toString());
        return null;
    }
}
