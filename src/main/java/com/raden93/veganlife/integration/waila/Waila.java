package com.raden93.veganlife.integration.waila;

import net.minecraftforge.fml.common.event.FMLInterModComms;

public class Waila
{
	public static void init() {
		FMLInterModComms.sendMessage("waila", "register",
				"com.raden93.veganlife.integration.waila.ProviderJutePlant.callbackRegister");
	}
}
