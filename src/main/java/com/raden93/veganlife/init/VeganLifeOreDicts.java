package com.raden93.veganlife.init;

import net.minecraftforge.oredict.OreDictionary;

public class VeganLifeOreDicts {
	
	public static void init() {
		OreDictionary.registerOre("leather", VeganLifeItems.burlap_item);
		OreDictionary.registerOre("sheetPlastic", VeganLifeItems.bioplastic_item);
		OreDictionary.registerOre("stickPlastic", VeganLifeItems.plastic_rod_item);
	}
}
