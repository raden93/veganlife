package com.raden93.veganlife.util;

import java.util.ArrayList;

import com.raden93.veganlife.block.enderperl.EncrustedObsidianBlock;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
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
	
	public static BlockPos[] getAdjacentBlocksHorizontally(BlockPos blockPos) {
		return new BlockPos[]{
				blockPos.offset(EnumFacing.NORTH), blockPos.offset(EnumFacing.SOUTH),
				blockPos.offset(EnumFacing.EAST), blockPos.offset(EnumFacing.WEST)
			};
	}
	
	public static boolean isValidPortalLocation(World world, BlockPos blockPos)
	{
		for (BlockPos blockToCheck : getAdjacentBlocksHorizontally(blockPos))
		{
			if (!(world.getBlockState(blockToCheck).getBlock() instanceof EncrustedObsidianBlock))
				return false;
		}
		return true;
	}
	
	
	/**
	 * Compare material of blockPos and given material
	 */
	public static boolean isBlockGivenMaterial(World world, BlockPos blockPos, Material material) {
		return world.getBlockState(blockPos).getMaterial().equals(material);
	}
	
	public static BlockPos findWaterSource(World world, BlockPos pos) {
		if(!isBlockGivenMaterial(world, pos, Material.WATER)) {
			return null;
		}
		IBlockState state = world.getBlockState(pos);
		if(FluidUtil.getFluidLevel(state) == FluidUtil.getStillFluidLevel(state)) {
			return pos;
		}
		return findWaterSource(world, pos.up());
	}
	
	public static BlockPos[] findAllBlocksAdjust(World world,BlockPos startPos,int distance ) {
		ArrayList<BlockPos> list = new ArrayList<BlockPos>();
		for(int x = startPos.getX() - distance; x < startPos.getX() + distance; x++) {
			for(int y = startPos.getY() - distance; y < startPos.getY() + distance; y++) {
				for(int z = startPos.getZ() - distance; z < startPos.getZ() + distance; z++) {
					BlockPos currentPos = new BlockPos(x, y, z);
					if(!isBlockGivenMaterial(world, currentPos, Material.AIR)){
						list.add(currentPos);
					}
				}
			}
		}
		BlockPos[] results = new BlockPos[list.size()];
		return list.toArray(results);
	}

}
