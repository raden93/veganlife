package com.raden93.veganlife.item;

import com.raden93.veganlife.init.VeganLifeTabs;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSeeds;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;

public class SeedsVeganItem extends ItemSeeds {
	
	public SeedsVeganItem(Block crop) {
		super(crop, null);
		setCreativeTab(VeganLifeTabs.veganLifeTab);
	}
	
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos)
	{
		return EnumPlantType.Plains;
	}
}
