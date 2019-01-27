package com.raden93.veganlife.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class VeganLifeRecipes {
	
	public static void registerSmelting() {
		GameRegistry.addSmelting(VeganLifeItems.potato_starch_item, new ItemStack(VeganLifeItems.bioplastic_item, 2), 0.35f);
		GameRegistry.addSmelting(VeganLifeItems.resin_item, new ItemStack(VeganLifeItems.rosin_item, 1), 0.2f);
		GameRegistry.addSmelting(VeganLifeItems.vegetable_oil_item, new ItemStack(VeganLifeItems.vegetable_wax_item, 1), 0.2f);
	}

}
