package com.github.sniffity.server.registry;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

public class TuffItemGroupRegistry {
    public static final CreativeModeTab GROUP = new CreativeModeTab("group_tuffblocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Blocks.TUFF);
        }
    };
}