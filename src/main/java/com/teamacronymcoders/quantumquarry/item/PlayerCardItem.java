package com.teamacronymcoders.quantumquarry.item;

import com.teamacronymcoders.quantumquarry.QuantumQuarry;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class PlayerCardItem extends Item {

    private UUID uuid;

    public PlayerCardItem() {
        super(new Item.Properties().group(QuantumQuarry.QMTAB).rarity(Rarity.EPIC).maxStackSize(1));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (uuid != null && playerIn != null) {
            uuid = playerIn.getUniqueID();
            CompoundNBT tag = playerIn.getHeldItem(handIn).getTag();
            if (tag != null) {
                tag.putUniqueId("player", uuid);
            }
        }
        return ActionResult.resultPass(playerIn.getHeldItem(handIn));
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        if (uuid != null) {
            tooltip.add(new TranslationTextComponent("tooltip.playercard.id", uuid.toString()));
        }
    }

    public boolean hasPlayerID() {
        return uuid != null;
    }

    public PlayerEntity getPlayer(World world) {
        return world.getPlayerByUuid(uuid);
    }
}
