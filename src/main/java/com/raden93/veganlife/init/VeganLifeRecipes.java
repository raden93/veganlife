package com.raden93.veganlife.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class VeganLifeRecipes {
	
	public static void registerSmelting() {
		GameRegistry.addSmelting(VeganLifeItems.potato_starch_item, new ItemStack(VeganLifeItems.bioplastic_item, 2), 0.35f);
	}

}
