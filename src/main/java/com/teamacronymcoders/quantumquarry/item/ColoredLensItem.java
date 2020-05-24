package com.teamacronymcoders.quantumquarry.item;

import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

public class ColoredLensItem extends LensItem {

    public ColoredLensItem(DyeColor color) {
        super(new Item.Properties().rarity(Rarity.RARE));
    }

}
