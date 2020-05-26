package com.teamacronymcoders.quantumquarry.json;

import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.teamacronymcoders.quantumquarry.QuantumQuarry;
import com.teamacronymcoders.quantumquarry.recipe.MinerEntry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.IProperty;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.common.util.JsonUtils;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JsonHelper {

    public static JsonObject serializeMinerEntry(MinerEntry entry, List<ICondition> conditions) {
        JsonObject object = new JsonObject();
        JsonArray array = new JsonArray();
        for (ICondition condition : conditions) {
            array.add(CraftingHelper.serialize(condition));
        }
        if (array.size() > 0) {
            object.add("conditions", array);
        }
        object.addProperty("weight", entry.getWeight());
        object.add("lens", entry.getLens().serialize());
        object.add("state", serializeBlockState(entry.getState()));
        if (entry.getData() != null) {
            object.addProperty("data", entry.getData().toString());
        }
        return object;
    }

    public static MinerEntry deserializeMinerEntry(ResourceLocation resourceLocation, MinerEntry entry, JsonObject object) {
        double weight = getDouble(object, "weight");
        Ingredient lens = Ingredient.deserialize(object.getAsJsonObject("lens"));
        BlockState state = JsonHelper.deserializeBlockState(object.getAsJsonObject("state"));
        entry.setWeight(weight);
        entry.setId(resourceLocation);
        entry.setLens(lens);
        entry.setState(state);
        if (object.has("data")) {
            CompoundNBT data = JsonUtils.readNBT(object, "data");
            entry.setData(data);
        }
        return entry;
    }

    public static MinerEntry deserializeMinerEntry(ResourceLocation resourceLocation, JsonObject object) {
        MinerEntry entry = new MinerEntry();
        return deserializeMinerEntry(resourceLocation, entry, object);
    }

    /**
     * Gets the float value of the given JsonElement.  Expects the second parameter to be the name of the element's field
     * if an error message needs to be thrown.
     */
    public static double getDouble(JsonElement json, String memberName) {
        if (json.isJsonPrimitive() && json.getAsJsonPrimitive().isNumber()) {
            return json.getAsDouble();
        } else {
            throw new JsonSyntaxException("Expected " + memberName + " to be a Float, was " + JSONUtils.toString(json));
        }
    }

    /**
     * Gets the float value of the field on the JsonObject with the given name.
     */
    public static double getDouble(JsonObject json, String memberName) {
        if (json.has(memberName)) {
            return getDouble(json.get(memberName), memberName);
        } else {
            throw new JsonSyntaxException("Missing " + memberName + ", expected to find a Float");
        }
    }

    /**
     * Gets the float value of the field on the JsonObject with the given name, or the given default value if the field
     * is missing.
     */
    public static double getDouble(JsonObject json, String memberName, double fallback) {
        return json.has(memberName) ? getDouble(json.get(memberName), memberName) : fallback;
    }

    /**
     * Credit for the following Methods goes to Darkhax and his library mod Bookshelf <3
     */
    private static <T extends IForgeRegistryEntry<T>> T getRegistryEntry(JsonObject json, String memberName, IForgeRegistry<T> registry) {
        if (json.has(memberName)) {
            return getRegistryEntry(json.get(memberName), memberName, registry);
        } else {
            throw new JsonSyntaxException("Missing required value " + memberName);
        }
    }

    private static <T extends IForgeRegistryEntry<T>> T getRegistryEntry(JsonElement json, String memberName, IForgeRegistry<T> registry) {
        if (json == null) {
            throw new JsonSyntaxException("The property " + memberName + " is missing.");
        }
        if (json.isJsonPrimitive()) {
            final String rawId = json.getAsString();
            final ResourceLocation registryId = ResourceLocation.tryCreate(rawId);
            if (registryId != null) {
                final T registryEntry = registry.getValue(registryId);
                if (registryEntry != null) {
                    return registryEntry;
                } else {
                    throw new JsonSyntaxException("No entry found for id " + rawId);
                }
            } else {
                throw new JsonSyntaxException("Registry id " + rawId + " for property " + memberName + " was not a valid format.");
            }
        } else {
            throw new JsonSyntaxException("Expected " + memberName + " to be a JSON primitive. was " + JSONUtils.toString(json));
        }
    }

    private static Block getBlock(JsonObject json, String memberName) {
        return getRegistryEntry(json.get(memberName), memberName, ForgeRegistries.BLOCKS);
    }

    public static JsonElement serializeBlockState(BlockState state) {
        final JsonObject object = new JsonObject();
        object.addProperty("block", state.getBlock().getRegistryName().toString());
        final JsonObject propertiesElement = new JsonObject();
        ImmutableMap<IProperty<?>, Comparable<?>> map = state.getValues();
        for (ImmutableMap.Entry<IProperty<?>, Comparable<?>> entry : map.entrySet()) {
            propertiesElement.addProperty(entry.getKey().getName(), entry.getValue().toString());
        }
        object.add("properties", propertiesElement);
        return object;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static BlockState deserializeBlockState(JsonObject json) {
        // Read the block from the forge registry.
        final Block block = getBlock(json, "block");
        // Start off with the default state.
        BlockState state = block.getDefaultState();
        // If the properties member exists, attempt to assign properties to the block state.
        if (json.has("properties")) {
            final JsonElement propertiesElement = json.get("properties");
            if (propertiesElement.isJsonObject()) {
                final JsonObject props = propertiesElement.getAsJsonObject();
                // Iterate each member of the properties object. Expecting a simple key to
                // primitive string structure.
                for (final Map.Entry<String, JsonElement> property : props.entrySet()) {
                    // Check the block for the property. Keys = property names.
                    final IProperty blockProperty = block.getStateContainer().getProperty(property.getKey());
                    if (blockProperty != null) {
                        if (property.getValue().isJsonPrimitive()) {
                            // Attempt to parse the value with the the property.
                            final String valueString = property.getValue().getAsString();
                            final Optional<Comparable> propValue = blockProperty.parseValue(valueString);
                            if (propValue.isPresent()) {
                                // Update the state with the new property.
                                try {
                                    state = state.with(blockProperty, propValue.get());
                                } catch (final Exception e) {
                                    QuantumQuarry.LOGGER.error("Failed to update state for block {}. The mod that adds this block has issues.", block.getRegistryName());
                                    QuantumQuarry.LOGGER.catching(e);
                                }
                            } else {
                                throw new JsonSyntaxException("The property " + property.getKey() + " with value " + valueString + " coul not be parsed!");
                            }
                        } else {
                            throw new JsonSyntaxException("Expected property value for " + property.getKey() + " to be primitive string. Got " + JSONUtils.toString(property.getValue()));
                        }
                    } else {
                        throw new JsonSyntaxException("The property " + property.getKey() + " is not valid for block " + block.getRegistryName());
                    }
                }
            } else {
                throw new JsonSyntaxException("Expected properties to be an object. Got " + JSONUtils.toString(propertiesElement));
            }
        }
        return state;
    }
}
