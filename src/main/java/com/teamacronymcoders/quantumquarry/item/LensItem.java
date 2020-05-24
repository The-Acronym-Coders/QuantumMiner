package com.teamacronymcoders.quantumquarry.item;

import com.teamacronymcoders.quantumquarry.QuantumQuarry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class LensItem extends Item {

    public LensItem(Properties prop) {
        super(prop.group(QuantumQuarry.QMTAB).maxStackSize(1));
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment == Enchantments.EFFICIENCY || enchantment == Enchantments.FORTUNE;
    }
}
