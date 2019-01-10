package com.raden93.veganlife;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import com.raden93.veganlife.proxy.CommonProxy;

@Mod(modid = VeganLifeConstants.MODID, name = VeganLifeConstants.NAME, version = VeganLifeConstants.VERSION)
public class VeganLifeMod
{
	@Instance
	private static VeganLifeMod instance;
	
	public static VeganLifeMod getInstance() {
		return instance;
	}
	
	@SidedProxy(serverSide = "com.raden93.veganlife.proxy.CommonProxy", clientSide = "com.raden93.veganlife.proxy.ClientProxy")
	private static CommonProxy proxy;
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		proxy.preinit(event);
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
