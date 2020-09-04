package com.raden93.veganlife.block.jute;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeColorHelper;

public class JuteCropColorHandler implements IBlockColor, IItemColor {

	@Override
	public int colorMultiplier(IBlockState state, IBlockAccess worldIn, BlockPos pos, int tintIndex) {
		if (worldIn == null || pos == null)
			return ColorizerGrass.getGrassColor(0.5D, 1.0D);

			return BiomeColorHelper.getGrassColorAtPos(worldIn, pos);
	}

	@Override
	public int colorMultiplier(ItemStack stack, int tintIndex) {
		return ColorizerGrass.getGrassColor(0.5D, 1.0D);
	}
}
