package com.github.sniffity;

import com.github.sniffity.server.registry.TuffBlocksRegistry;
import com.github.sniffity.server.registry.TuffItemGroupRegistry;
import com.github.sniffity.server.registry.TuffItemsRegistry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import  net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(TuffBlocks.MODID)
public class TuffBlocks {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "tuffblocks";

    public TuffBlocks() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        TuffBlocksRegistry.BLOCKS.register(modBus);
        TuffItemsRegistry.ITEMS.register(modBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
