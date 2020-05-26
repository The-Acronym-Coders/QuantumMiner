package com.teamacronymcoders.quantumquarry.recipe;

import net.minecraft.block.BlockState;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;

public class MinerEntry {

    private double weight;
    private ResourceLocation id;
    private Ingredient lens;
    private BlockState state;
    private CompoundNBT data;

    public MinerEntry() {}

    public MinerEntry(double weight, Ingredient lens, BlockState state, CompoundNBT data) {
        this.weight = weight;
        this.lens = lens;
        this.state = state;
        this.data = data;
    }

    public MinerEntry(double weight, ResourceLocation id, Ingredient lens, BlockState state, CompoundNBT data) {
        this.weight = weight;
        this.id = id;
        this.lens = lens;
        this.state = state;
        this.data = data;
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

}
