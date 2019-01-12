package com.raden93.veganlife.block.jute;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BaleOfJuteColorHandler implements IBlockColor, IItemColor {
	
	private static final int baseColor = 0x67ce0c;
	private static final int rettedColor = 0xbfb57e;

	@Override
	public int colorMultiplier(IBlockState state, IBlockAccess worldIn, BlockPos pos, int tintIndex) {
		if(state.getValue(BaleOfJuteBlock.RETTING) >= BaleOfJuteBlock.MAX_RETTING_VALUE) {
			return rettedColor;
		}
		return baseColor;
	}

	@Override
	public int colorMultiplier(ItemStack stack, int tintIndex) {
		return baseColor;
	}
}
