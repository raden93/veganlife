package com.raden93.veganlife.block.jute;

import javax.annotation.Nonnull;

import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class JuteCropBlock extends BlockBush {
	
	public static final int NUM_AGE_STAGES = 11;
	private static final int NUM_BOTTOM_STAGES = 6;
	private static final int NUM_TOP_STAGES = 5;
	
	public static final PropertyInteger CROP_AGE = PropertyInteger.create("age", 0, NUM_AGE_STAGES);

	public JuteCropBlock() {
		super();
		this.setTickRandomly(true);
		this.setDefaultState(this.blockState.getBaseState().withProperty(CROP_AGE, Integer.valueOf(11)));
	}
	
	@Override
	@Nonnull
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, CROP_AGE);
	}
	
	@Override
	@Nonnull
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		float growthPercent = 1f;
		if (this.getCurrentAge(state) < NUM_AGE_STAGES)
		{
			int max = (this.isBiggerThanOneBlock(state) ? NUM_TOP_STAGES : NUM_BOTTOM_STAGES);		
			int blockStage = this.getCurrentAge(state) % NUM_AGE_STAGES;
			growthPercent = (float) blockStage / max;
		}
		return new AxisAlignedBB(0.15F, 0.0F, 0.15F, 0.85F, 0.25f + growthPercent * 0.75f, 0.85F);
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return state.getValue(CROP_AGE);
	}

	@Override
	@Nonnull
	public IBlockState getStateFromMeta(int meta)
	{
		return getDefaultState().withProperty(CROP_AGE, meta);
	}
	
	private int getCurrentAge(IBlockState state) {
		return state.getValue(CROP_AGE);
	}
	
	private boolean isBiggerThanOneBlock(IBlockState state) {
		return this.getCurrentAge(state) >= NUM_BOTTOM_STAGES;
	}
}
