package com.github.sniffity.server.registry;

import com.github.sniffity.TuffBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class TuffBlocksRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TuffBlocks.MODID);

    public static final RegistryObject<SlabBlock> TUFF_SLAB = register("tuff_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE)), new Item.Properties().tab(TuffItemGroupRegistry.GROUP));
    public static final RegistryObject<StairBlock> TUFF_STAIRS = register("tuff_stairs",
            () -> new StairBlock(Blocks.TUFF::defaultBlockState,  BlockBehaviour.Properties.copy(Blocks.STONE)), new Item.Properties().tab(TuffItemGroupRegistry.GROUP));
    public static final RegistryObject<WallBlock> TUFF_WALL = register("tuff_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)), new Item.Properties().tab(TuffItemGroupRegistry.GROUP));

    public static final RegistryObject<Block> POLISHED_TUFF = register("polished_tuff",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)), new Item.Properties().tab(TuffItemGroupRegistry.GROUP));
    public static final RegistryObject<SlabBlock> POLISHED_TUFF_SLAB = register("polished_tuff_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(TuffBlocksRegistry.POLISHED_TUFF.get())), new Item.Properties().tab(TuffItemGroupRegistry.GROUP));
    public static final RegistryObject<StairBlock> POLISHED_TUFF_STAIRS = register("polished_tuff_stairs",
            () -> new StairBlock(Blocks.TUFF::defaultBlockState,  BlockBehaviour.Properties.copy(TuffBlocksRegistry.POLISHED_TUFF.get())), new Item.Properties().tab(TuffItemGroupRegistry.GROUP));
    public static final RegistryObject<WallBlock> POLISHED_TUFF_WALL = register("polished_tuff_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(TuffBlocksRegistry.POLISHED_TUFF.get())), new Item.Properties().tab(TuffItemGroupRegistry.GROUP));


    public static final RegistryObject<Block> TUFF_BRICKS = register("tuff_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)), new Item.Properties().tab(TuffItemGroupRegistry.GROUP));
    public static final RegistryObject<SlabBlock> TUFF_BRICK_SLAB = register("tuff_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(TuffBlocksRegistry.TUFF_BRICKS.get())), new Item.Properties().tab(TuffItemGroupRegistry.GROUP));
    public static final RegistryObject<StairBlock> TUFF_BRICK_STAIRS = register("tuff_brick_stairs",
            () -> new StairBlock(Blocks.TUFF::defaultBlockState,  BlockBehaviour.Properties.copy(TuffBlocksRegistry.TUFF_BRICKS.get())), new Item.Properties().tab(TuffItemGroupRegistry.GROUP));
    public static final RegistryObject<WallBlock> TUFF_BRICK_WALL = register("tuff_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(TuffBlocksRegistry.TUFF_BRICKS.get())), new Item.Properties().tab(TuffItemGroupRegistry.GROUP));

    public static final RegistryObject<Block> TUFF_TILES = register("tuff_tiles",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)), new Item.Properties().tab(TuffItemGroupRegistry.GROUP));
    public static final RegistryObject<SlabBlock> TUFF_TILE_SLAB = register("tuff_tile_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(TuffBlocksRegistry.TUFF_TILES.get())), new Item.Properties().tab(TuffItemGroupRegistry.GROUP));
    public static final RegistryObject<StairBlock> TUFF_TILE_STAIRS = register("tuff_tile_stairs",
            () -> new StairBlock(Blocks.TUFF::defaultBlockState,  BlockBehaviour.Properties.copy(TuffBlocksRegistry.TUFF_TILES.get())), new Item.Properties().tab(TuffItemGroupRegistry.GROUP));
    public static final RegistryObject<WallBlock> TUFF_TILE_WALL = register("tuff_tile_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(TuffBlocksRegistry.TUFF_TILES.get())), new Item.Properties().tab(TuffItemGroupRegistry.GROUP));

    public static final RegistryObject<Block> CHISELED_TUFF = register("chiseled_tuff",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)), new Item.Properties().tab(TuffItemGroupRegistry.GROUP));

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> supplier, Item.Properties properties) {
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        TuffItemsRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
        return block;
    }
}
