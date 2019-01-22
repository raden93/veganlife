package com.raden93.veganlife.item.jute;

import com.raden93.veganlife.init.VeganLifeBlocks;
import com.raden93.veganlife.init.VeganLifeTabs;

import net.minecraft.item.ItemSeeds;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;

public class JuteSeedsItem extends ItemSeeds {
	
	public JuteSeedsItem() {
		super(VeganLifeBlocks.jute_crop_block, null);
		setCreativeTab(VeganLifeTabs.veganLifeTab);
	}
	
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos)
	{
		return EnumPlantType.Plains;
	}
}
