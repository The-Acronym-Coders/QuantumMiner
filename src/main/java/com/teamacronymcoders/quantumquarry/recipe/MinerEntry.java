package com.teamacronymcoders.quantumquarry.recipe;

import net.minecraft.block.Block;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

public class MinerEntry {

    private int weight;
    private ResourceLocation id;
    private Ingredient lens;
    private Block block;

    public MinerEntry() {}

    public MinerEntry(int weight, Ingredient lens, Block block) {
        this.weight = weight;
        this.lens = lens;
        this.block = block;
    }

    public MinerEntry(int weight, ResourceLocation id, Ingredient lens, Block block) {
        this.weight = weight;
        this.id = id;
        this.lens = lens;
        this.block = block;
    }

    public void setId(ResourceLocation id) {
        this.id = id;
    }

    public ResourceLocation getId() {
        return id;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public MinerEntry setLens(Ingredient lens) {
        this.lens = lens;
        return this;
    }

    public Ingredient getLens() {
        return lens;
    }

    public MinerEntry setBlock(Block block) {
        this.block = block;
        return this;
    }

    public Block getBlock() {
        return block;
    }

}
