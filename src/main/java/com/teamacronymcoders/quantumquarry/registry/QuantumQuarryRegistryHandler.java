package com.teamacronymcoders.quantumquarry.registry;

import com.hrznstudio.titanium.registry.BlockRegistryObjectGroup;
import com.teamacronymcoders.quantumquarry.QuantumQuarry;
import com.teamacronymcoders.quantumquarry.item.ColoredLensItem;
import com.teamacronymcoders.quantumquarry.quarry.QuarryBlock;
import com.teamacronymcoders.quantumquarry.quarry.QuarryTile;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

import java.util.function.Function;

@SuppressWarnings({"unchecked", "rawtypes"})
public class QuantumQuarryRegistryHandler {

    @ObjectHolder("quantumquarry:quarry")
    public static QuarryBlock quarryBlock;

    private static final DeferredRegister<Item> ITEM = new DeferredRegister<>(ForgeRegistries.ITEMS, "quantumquarry");

    // Lens Items
    public static final RegistryObject<ColoredLensItem> WHITE_LENS = ITEM.register("white_lens", () -> new ColoredLensItem(DyeColor.WHITE));
    public static final RegistryObject<ColoredLensItem> ORANGE_LENS = ITEM.register("orange_lens", () -> new ColoredLensItem(DyeColor.ORANGE));
    public static final RegistryObject<ColoredLensItem> MAGENTA_LENS = ITEM.register("magenta_lens", () -> new ColoredLensItem(DyeColor.MAGENTA));
    public static final RegistryObject<ColoredLensItem> LIGHT_BLUE_LENS = ITEM.register("light_blue_lens", () -> new ColoredLensItem(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<ColoredLensItem> YELLOW_LENS = ITEM.register("yellow_lens", () -> new ColoredLensItem(DyeColor.YELLOW));
    public static final RegistryObject<ColoredLensItem> LIME_LENS = ITEM.register("lime_lens", () -> new ColoredLensItem(DyeColor.LIME));
    public static final RegistryObject<ColoredLensItem> PINK_LENS = ITEM.register("pink_lens", () -> new ColoredLensItem(DyeColor.PINK));
    public static final RegistryObject<ColoredLensItem> GRAY_LENS = ITEM.register("gray_lens", () -> new ColoredLensItem(DyeColor.GRAY));
    public static final RegistryObject<ColoredLensItem> LIGHT_GRAY_LENS = ITEM.register("light_gray_lens", () -> new ColoredLensItem(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<ColoredLensItem> CYAN_LENS = ITEM.register("cyan_lens", () -> new ColoredLensItem(DyeColor.CYAN));
    public static final RegistryObject<ColoredLensItem> PURPLE_LENS = ITEM.register("purple_lens", () -> new ColoredLensItem(DyeColor.PURPLE));
    public static final RegistryObject<ColoredLensItem> BLUE_LENS = ITEM.register("blue_lens", () -> new ColoredLensItem(DyeColor.BLUE));
    public static final RegistryObject<ColoredLensItem> BROWN_LENS = ITEM.register("brown_lens", () -> new ColoredLensItem(DyeColor.BROWN));
    public static final RegistryObject<ColoredLensItem> GREEN_LENS = ITEM.register("green_lens", () -> new ColoredLensItem(DyeColor.GREEN));
    public static final RegistryObject<ColoredLensItem> RED_LENS = ITEM.register("red_lens", () -> new ColoredLensItem(DyeColor.RED));
    public static final RegistryObject<ColoredLensItem> BLACK_LENS = ITEM.register("black_lens", () -> new ColoredLensItem(DyeColor.BLACK));

    public static void register(IEventBus modBus) {
        ITEM.register(modBus);
    }

}
