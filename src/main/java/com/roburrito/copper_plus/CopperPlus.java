package com.roburrito.copper_plus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roburrito.copper_plus.items.CopperItems;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.VersionChecker;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CopperPlus.MODID)
public class CopperPlus {
    public static final String MODID = "copper_plus";
    public static final Logger LOG = LogManager.getLogger(MODID);
    
    public CopperPlus() {
        // initialize modules, done this way rather than with annotations to give us control over the order
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

    	bus.addListener(this::setup);
    	bus.addListener(this::clientSetup);

        CopperItems.ITEMS.register(bus);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOG.info("Copper Plus: Common Initialization Started");

        VersionChecker.startVersionCheck();

    }
    
    private void clientSetup(final FMLClientSetupEvent event) {
        LOG.info("Copper Plus: Client Initialization Started");
        
        // ClientSetup.setup();    	
    }
}
