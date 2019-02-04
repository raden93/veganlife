package com.raden93.veganlife.integration.waila;

import com.raden93.veganlife.block.jute.BaleOfJuteBlock;
import com.raden93.veganlife.block.jute.JuteCropBlock;

import mcp.mobius.waila.api.IWailaRegistrar;
import net.minecraftforge.fml.common.event.FMLInterModComms;

public class Waila
{
	public static void init() {
		FMLInterModComms.sendMessage("waila", "register",
				"com.raden93.veganlife.integration.waila.Waila.callbackRegister");
	}
	
	public static void callbackRegister(IWailaRegistrar register) {
		register.registerBodyProvider(new ProviderJutePlant(), JuteCropBlock.class);
		register.registerBodyProvider(new ProviderBaleOfJute(), BaleOfJuteBlock.class);
	}
}
