package com.raden93.veganlife;

import static com.raden93.veganlife.VeganLifeConstants.MODID;
import static com.raden93.veganlife.VeganLifeConstants.NAME;
import static com.raden93.veganlife.VeganLifeConstants.VERSION;

import org.apache.logging.log4j.Logger;

import com.raden93.veganlife.proxy.CommonProxy;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MODID, name = NAME, version = VERSION)
public class VeganLifeMod
{
	@Instance
	private static VeganLifeMod instance;
	
	public static VeganLifeMod getInstance() {
		return instance;
	}
	

	// necessary for use buckets with custom fluids
	static {
    FluidRegistry.enableUniversalBucket();
    }

	
	@SidedProxy(serverSide = "com.raden93.veganlife.proxy.CommonProxy", clientSide = "com.raden93.veganlife.proxy.ClientProxy")
	private static CommonProxy proxy;
	public static Logger logger;
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		proxy.preinit(event);
		logger = event.getModLog();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}
	
	@EventHandler
	public void postinit(FMLPostInitializationEvent event) {
		proxy.postinit(event);
	}
}
