package com.raden93.veganlife.item.enderperl;

import com.raden93.veganlife.init.VeganLifeTabs;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SoapItem extends Item  {
	
	public SoapItem() {
		setCreativeTab(VeganLifeTabs.veganLifeTab);
		setMaxStackSize(1);
		setMaxDamage(3);
		setNoRepair();
	}
	
	@Override
    public boolean hasContainerItem(ItemStack stack){
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
    	ItemStack newSoap = new ItemStack(this);
    	newSoap.setItemDamage(itemStack.getItemDamage() + 1);
        return newSoap;
    }


}
