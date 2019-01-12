package com.raden93.veganlife.util;

import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockUtil {
	
	/**
	 * Compare the blocks north, south, east, west and up to the given Block, with the given Material. 
	 * If one of them is equal to the given material, return true. Otherwise return false
	 */
	public static boolean isBlockInOrAdjacentMaterial(World world, BlockPos blockPos, Material material) {
		for(BlockPos position: BlockUtil.getAdjacentBlocks(blockPos)) {
			if(BlockUtil.isBlockGivenMaterial(world, position, material)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Return all positions around the given Block
	 */
	public static BlockPos[] getAdjacentBlocks(BlockPos blockPos) {
		return new BlockPos[]{
				blockPos.offset(EnumFacing.NORTH), 
				blockPos.offset(EnumFacing.SOUTH),
				blockPos.offset(EnumFacing.EAST), 
				blockPos.offset(EnumFacing.WEST),
				blockPos.offset(EnumFacing.UP)
		};
	}
	
	/**
	 * Compare material of blockPos and given material
	 */
	private static boolean isBlockGivenMaterial(World world, BlockPos blockPos, Material material) {
		return world.getBlockState(blockPos).getMaterial().equals(material);
	}

}
