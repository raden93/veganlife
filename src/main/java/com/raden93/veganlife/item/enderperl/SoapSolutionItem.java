package com.raden93.veganlife.item.enderperl;

import com.raden93.veganlife.init.VeganLifeTabs;

import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class SoapSolutionItem extends Item  {
	
	public SoapSolutionItem() {
		setCreativeTab(VeganLifeTabs.veganLifeTab);
		setContainerItem(Items.GLASS_BOTTLE);
	}

}
