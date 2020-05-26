package com.teamacronymcoders.quantumquarry.misc;

import net.minecraft.item.ItemStack;

import java.util.Objects;

public class ItemStackKey {
    private final ItemStack itemStack;

    public ItemStackKey(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ItemStack getItemStack() {
        return this.itemStack;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.itemStack.getItem(), this.itemStack.getTag());
    }
}
