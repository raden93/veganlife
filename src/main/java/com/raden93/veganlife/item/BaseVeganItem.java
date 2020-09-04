package com.raden93.veganlife.item;

import com.raden93.veganlife.init.VeganLifeTabs;

import net.minecraft.item.Item;

public class BaseVeganItem extends Item {
	
	public BaseVeganItem() {
		this(64);
	}
	
	public BaseVeganItem(int stackSize) {
		setMaxStackSize(stackSize);
		setCreativeTab(VeganLifeTabs.veganLifeTab);
	}
}
