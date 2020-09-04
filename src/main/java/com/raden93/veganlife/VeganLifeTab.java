package com.raden93.veganlife;

import com.raden93.veganlife.init.VeganLifeBlocks;
import com.raden93.veganlife.init.VeganLifeItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;

public class VeganLifeTab extends CreativeTabs {

	public VeganLifeTab() {
		super("veganlifetab");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(VeganLifeItems.burlap_item);
	}
	
	@Override
	public void displayAllRelevantItems(NonNullList<ItemStack> p_78018_1_) {
		p_78018_1_.add(FluidUtil.getFilledBucket(new FluidStack(VeganLifeBlocks.wood_ash_lye_fluid, 1)));
		p_78018_1_.add(FluidUtil.getFilledBucket(new FluidStack(VeganLifeBlocks.raw_ender_fluid, 1)));
		super.displayAllRelevantItems(p_78018_1_);
	}
}
