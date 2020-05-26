package com.teamacronymcoders.quantumquarry.json;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.hrznstudio.titanium.json.IJsonProvider;
import com.teamacronymcoders.quantumquarry.recipe.MinerEntry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;

public class MinerEntryJsonProvider implements IJsonProvider<MinerEntry> {

    @Override
    public MinerEntry provide(ResourceLocation resourceLocation, JsonObject jsonObject) throws JsonParseException {
        if (CraftingHelper.processConditions(jsonObject, "conditions")) {
            return JsonHelper.deserializeMinerEntry(resourceLocation, jsonObject);
        }
        return null;
    }
}
