package com.raden93.veganlife.item;

import net.minecraft.item.ItemStack;

public class SoapVeganItem extends BaseVeganItem  {
	
	public SoapVeganItem() {
		super(1);
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
