package com.raden93.veganlife.block.jute;

import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class JuteCropBlock extends BlockBush implements IGrowable {
	
	public static final int NUM_AGE_STAGES = 11;
	private static final int NUM_BOTTOM_STAGES = 6;
	private static final int NUM_TOP_STAGES = 5;
	public static final float GROWTH_CHANCE_PER_UPDATETICK = 0.10f;
	
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
	
	@Override
	public void updateTick(@Nullable World world, @Nullable BlockPos pos, @Nullable IBlockState state, @Nullable Random random)
	{
		super.updateTick(world, pos, state, random);

		if (this.getCurrentAge(state) < NUM_AGE_STAGES && random.nextFloat() < GROWTH_CHANCE_PER_UPDATETICK)
			this.growCrop(world, pos, state, 1);
	}
	
	@Override
	public boolean canGrow(@Nonnull World world, @Nonnull BlockPos pos, @Nonnull IBlockState state, boolean isClient)
	{
		return true;
	}

	@Override
	public boolean canUseBonemeal(@Nonnull World world, @Nonnull Random random, @Nonnull BlockPos pos, @Nonnull IBlockState state)
	{
		return true;
	}

	@Override
	public void grow(@Nonnull World world, @Nonnull Random random, @Nonnull BlockPos pos, @Nonnull IBlockState state)
	{
		int growing_steps = random.nextInt(3) + 2;
		this.growCrop(world, pos, state, growing_steps);
	}
	
	private void growCrop(World world, BlockPos pos, IBlockState state, int steps) {
		//
		if(this.isBiggerThanOneBlock(state)) {
			this.growCrop(world, pos.up(), world.getBlockState(pos.up()), steps);
			return;
		}
		int newAge = this.getCurrentAge(state) + steps;
		// complete grow now
		if(newAge >= NUM_AGE_STAGES) {
			// delete both crop blocks
			world.setBlockState(pos.down(), Blocks.AIR.getDefaultState(), 0);
			world.setBlockState(pos, Blocks.AIR.getDefaultState(), 0);
			// set fern block
			//TODO: Set Fern Block
			return;
		}
		// growing to first block limit
		if(newAge >= NUM_BOTTOM_STAGES) {
			if(world.isAirBlock(pos.up())) {
				// set bottom block to full size
				world.setBlockState(pos, state.withProperty(CROP_AGE, NUM_AGE_STAGES));
				// create new block on top with crop age of this block
				world.setBlockState(pos.up(), this.getDefaultState().withProperty(CROP_AGE, newAge));
			}
		}
		else {
			// normal growing 
			world.setBlockState(pos, state.withProperty(CROP_AGE, newAge), 3);
		}
	}
	
	private int getCurrentAge(IBlockState state) {
		return state.getValue(CROP_AGE);
	}
	
	private boolean isBiggerThanOneBlock(IBlockState state) {
		return this.getCurrentAge(state) >= NUM_BOTTOM_STAGES;
	}
}
