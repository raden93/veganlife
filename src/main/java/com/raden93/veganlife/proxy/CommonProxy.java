package com.raden93.veganlife.proxy;

import com.raden93.veganlife.init.VeganLifeItems;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	
	public void preinit(FMLPreInitializationEvent event) {
		VeganLifeItems.init();
		
		MinecraftForge.EVENT_BUS.register(VeganLifeItems.class);
	}

	public void init(FMLInitializationEvent event) {
	
	}

	public void postinit(FMLPostInitializationEvent event) {
		
	}

}
