package com.raden93.veganlife.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class VeganLifeOreDicts {
	
	public static void init() {
		OreDictionary.registerOre("leather", VeganLifeItems.burlap_item);
		OreDictionary.registerOre("sheetPlastic", VeganLifeItems.bioplastic_item);
		OreDictionary.registerOre("stickPlastic", VeganLifeItems.plastic_rod_item);
		
		OreDictionary.registerOre("slimeball", new ItemStack(Items.SLIME_BALL));
		OreDictionary.registerOre("slimeball", new ItemStack(VeganLifeItems.resin_item));
		
		
		OreDictionary.registerOre("feather", VeganLifeItems.faux_feather_item);
	}
}
