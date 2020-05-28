package com.teamacronymcoders.quantumquarry.item;

import com.teamacronymcoders.quantumquarry.QuantumQuarry;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

public class PlasticHammerItem extends Item {

    public PlasticHammerItem() {
        super(new Item.Properties().maxStackSize(1).rarity(Rarity.RARE).group(QuantumQuarry.QMTAB));
    }
}
