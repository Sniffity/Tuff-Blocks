package com.github.sniffity;

import com.github.sniffity.server.registry.TuffBlocksRegistry;
import com.github.sniffity.server.registry.TuffItemGroupRegistry;
import com.github.sniffity.server.registry.TuffItemsRegistry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import  net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
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

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        TuffBlocksRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            event.getRegistry().register(new BlockItem(block, new Item.Properties().tab(TuffItemGroupRegistry.GROUP))
                    .setRegistryName(block.getRegistryName()));
        });
    }

}
