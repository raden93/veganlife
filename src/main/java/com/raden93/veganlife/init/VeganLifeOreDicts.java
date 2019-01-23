package com.raden93.veganlife.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class VeganLifeOreDicts {
	
	public static void init() {
		OreDictionary.registerOre("leather", VeganLifeItems.burlap_item);
		OreDictionary.registerOre("sheetPlastic", VeganLifeItems.bioplastic_item);
		OreDictionary.registerOre("stickPlastic", VeganLifeItems.plastic_rod_item);
		
		OreDictionary.registerOre("slimeball", new ItemStack(VeganLifeItems.resin_item));
		
		OreDictionary.registerOre("reagentPoisonous", new ItemStack(Items.SPIDER_EYE));
		OreDictionary.registerOre("reagentPoisonous", new ItemStack(VeganLifeItems.dolls_eye_item));
		
	}
}
