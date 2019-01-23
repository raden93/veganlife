package com.raden93.veganlife.item.oil;

import com.raden93.veganlife.init.VeganLifeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class VegetableOilInkItem extends Item {
	
	public VegetableOilInkItem() {
		this.setHasSubtypes(true);
		setCreativeTab(VeganLifeTabs.veganLifeTab);
	}
	
	@Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return stack.getMetadata() == 1 ? "item.vegetableoilink_white" : "item.vegetableoilink_black";
    }
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
    {
        if (this.isInCreativeTab(tab))
        {
            items.add(new ItemStack(this, 1, 0));
            items.add(new ItemStack(this, 1, 1));
        }
    }

}
