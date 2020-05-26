package com.teamacronymcoders.quantumquarry.recipe;

import com.google.gson.JsonObject;
import com.teamacronymcoders.quantumquarry.json.JsonHelper;
import net.minecraft.block.BlockState;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.JsonUtils;

public class MinerEntry {

    private String modid;
    private double weight;
    private ResourceLocation id;
    private Ingredient lens;
    private BlockState state;
    private CompoundNBT data;

    public MinerEntry() {}

    public MinerEntry(String modid, double weight, Ingredient lens, BlockState state, CompoundNBT data) {
        this.modid = modid;
        this.lens = lens;
        this.state = state;
        this.data = data;
    }

    public MinerEntry(String modid, double weight, ResourceLocation id, Ingredient lens, BlockState state, CompoundNBT data) {
        this.modid = modid;
        this.id = id;
        this.lens = lens;
        this.state = state;
        this.data = data;
    }

    public void setModid(String modid) {
        this.modid = modid;
    }

    public String getModid() {
        return modid;
    }

    public void setId(ResourceLocation id) {
        this.id = id;
    }

    public ResourceLocation getId() {
        return id;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public MinerEntry setLens(Ingredient lens) {
        this.lens = lens;
        return this;
    }

    public Ingredient getLens() {
        return lens;
    }

    public MinerEntry setState(BlockState state) {
        this.state = state;
        return this;
    }

    public BlockState getState() {
        return state;
    }

    public MinerEntry setData(CompoundNBT data) {
        this.data = data;
        return this;
    }

    public CompoundNBT getData() {
        return data;
    }

    public JsonObject serialize() {
        JsonObject object = new JsonObject();
        object.addProperty("modid", modid);
        object.addProperty("id", id.toString());
        object.add("lens", lens.serialize());
        object.add("state", JsonHelper.serializeBlockState(state));
        if (data != null) {
            object.addProperty("data", data.toString());
        }
        return object;
    }

    public void deserialize(JsonObject object) {
        setModid(object.get("modid").getAsString());
        ResourceLocation id = new ResourceLocation(object.get("id").getAsString());
        Ingredient lens = Ingredient.deserialize(object.getAsJsonObject("lens"));
        BlockState state = JsonHelper.deserializeBlockState(object.getAsJsonObject("state"));
        setId(id);
        setLens(lens);
        setState(state);
        if (object.has("data")) {
            CompoundNBT data = JsonUtils.readNBT(object, "data");
            setData(data);
        }
    }
}
