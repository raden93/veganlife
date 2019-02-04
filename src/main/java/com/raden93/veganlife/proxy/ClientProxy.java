package com.raden93.veganlife.proxy;


import com.raden93.veganlife.init.VeganLifeColorHandlers;
import com.raden93.veganlife.init.VeganLifeModels;
import com.raden93.veganlife.integration.waila.Waila;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	public void preinit(FMLPreInitializationEvent event) {
		super.preinit(event);
		
		MinecraftForge.EVENT_BUS.register(VeganLifeModels.class);
		
		if(Loader.isModLoaded("waila")) {
			Waila.init();
		}
	}

	public void init(FMLInitializationEvent event) {
		super.init(event);
		
		VeganLifeColorHandlers.init();
	}

	public void postinit(FMLPostInitializationEvent event) {
		super.postinit(event);
		
		
	}
}
