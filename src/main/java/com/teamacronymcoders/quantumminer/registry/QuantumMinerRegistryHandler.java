package com.teamacronymcoders.quantumminer.registry;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Function;

public class QuantumMinerRegistryHandler {

    private static final DeferredRegister<Block> BLOCK_DEFERRED_REGISTER = new DeferredRegister<>(ForgeRegistries.BLOCKS, "quantumquarry");
    private static final DeferredRegister<TileEntityType<?>> TILE_DEFERRED_REGISTER = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, "quantumquarry");
    private static final DeferredRegister<Item> ITEM_DEFERRED_REGISTER = new DeferredRegister<>(ForgeRegistries.ITEMS, "quantumquarry");



    private static <B extends Block> Function<B, BlockItem> blockItemCreator() {
        return block -> new BlockItem(block, new Item.Properties());
    }

    public static void register(IEventBus modBus) {
        BLOCK_DEFERRED_REGISTER.register(modBus);
        TILE_DEFERRED_REGISTER.register(modBus);
        ITEM_DEFERRED_REGISTER.register(modBus);
    }

}
