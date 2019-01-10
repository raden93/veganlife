package com.raden93.veganlife;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class VeganLifeTab extends CreativeTabs {

	public VeganLifeTab() {
		super("veganlifetab");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Items.BEETROOT);
	}
}
