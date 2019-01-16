package com.raden93.veganlife.proxy;

import com.raden93.veganlife.init.VeganLifeBlocks;
import com.raden93.veganlife.init.VeganLifeItems;
import com.raden93.veganlife.init.VeganLifeOreDicts;
import com.raden93.veganlife.init.VeganLifeRecipes;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;

public class CommonProxy {
	
	public void preinit(FMLPreInitializationEvent event) {
		VeganLifeItems.init();
		VeganLifeBlocks.init();
		
		MinecraftForge.EVENT_BUS.register(VeganLifeItems.class);
		MinecraftForge.EVENT_BUS.register(VeganLifeBlocks.class);
		
		VeganLifeOreDicts.init();
		VeganLifeRecipes.registerSmelting();
	}

	public void init(FMLInitializationEvent event) {
	
	}

	public void postinit(FMLPostInitializationEvent event) {
		
	}

}
