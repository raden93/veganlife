package com.raden93.veganlife.item.oil;

import com.raden93.veganlife.init.VeganLifeTabs;

import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class VegetableOilItem extends Item {
	
	public VegetableOilItem() {
		setCreativeTab(VeganLifeTabs.veganLifeTab);
		setContainerItem(Items.GLASS_BOTTLE);
	}

}
