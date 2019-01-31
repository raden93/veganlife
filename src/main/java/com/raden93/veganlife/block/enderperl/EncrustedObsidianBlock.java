package com.raden93.veganlife.block.enderperl;

import java.util.Random;

import com.raden93.veganlife.init.VeganLifeBlocks;
import com.raden93.veganlife.util.BlockUtil;

import net.minecraft.block.Block;
import net.minecraft.block.BlockObsidian;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EncrustedObsidianBlock extends BlockObsidian {

	public EncrustedObsidianBlock() {
		super();
		setSoundType(SoundType.STONE);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random random, int fortune)
	{
		return Item.getItemFromBlock(this);
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
		tryToPlacePortalAdjacentTo(worldIn, pos);
	}
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	{
		tryToPlacePortalAdjacentTo(world, pos);
	}
	
	private void tryToPlacePortalAdjacentTo(World worldIn, BlockPos pos) {
		for (BlockPos blockPosToCheck : BlockUtil.getAdjacentBlocksHorizontally(pos))
		{
			Block blockToCheck = worldIn.getBlockState(blockPosToCheck).getBlock();
			if (BlockUtil.isValidPortalLocation(worldIn, blockPosToCheck))
			{
				if(blockToCheck.isReplaceable(worldIn, blockPosToCheck)) {
					worldIn.setBlockState(blockPosToCheck, VeganLifeBlocks.ender_rift_block.getDefaultState());
				}
				
			}
		}
	}
}
