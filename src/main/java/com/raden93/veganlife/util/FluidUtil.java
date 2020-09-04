package com.raden93.veganlife.util;

import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.fluids.BlockFluidBase;

public class FluidUtil {

	public static int getFluidLevel(IBlockState state)
	{
		if (state.getBlock() instanceof BlockFluidBase)
			return state.getValue(BlockFluidBase.LEVEL);
		else if (state.getBlock() instanceof BlockLiquid)
			return state.getValue(BlockLiquid.LEVEL);
		else
			return 0;
	}
	
	public static int getStillFluidLevel(IBlockState state)
	{
		return state.getBlock() instanceof BlockFluidBase ? ((BlockFluidBase) state.getBlock()).getMaxRenderHeightMeta() : 0;
	}
}
