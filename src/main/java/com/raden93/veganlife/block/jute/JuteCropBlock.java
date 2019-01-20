package com.raden93.veganlife.block.jute;

import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.raden93.veganlife.VeganLifeMod;
import com.raden93.veganlife.init.VeganLifeItems;

import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class JuteCropBlock extends BlockBush implements IGrowable {
	
	public static final int NUM_MAX_AGE = 11;
	private static final int NUM_MIN_AGES_FOR_TOP = 6;
	private static final int NUM_TOP_AGES = 5;
	public static final float GROWTH_CHANCE_PER_UPDATETICK = 0.10f;
	
	public static final PropertyInteger CROP_AGE = PropertyInteger.create("age", 0, NUM_MAX_AGE);

	public JuteCropBlock() {
		super();
		this.setTickRandomly(true);
		this.setDefaultState(this.blockState.getBaseState().withProperty(CROP_AGE, Integer.valueOf(0)));
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
		if (this.getCurrentAge(state) < NUM_MAX_AGE)
		{
			int max = (this.isBiggerThanOneBlock(state) ? NUM_TOP_AGES : NUM_MIN_AGES_FOR_TOP);		
			int blockStage = this.getCurrentAge(state) % NUM_MIN_AGES_FOR_TOP;
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

		if (this.canGrow(state) && random.nextFloat() < GROWTH_CHANCE_PER_UPDATETICK)
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
		if(this.canGrow(state)) {
			int growing_steps = random.nextInt(3) + 2;
			this.growCrop(world, pos, state, growing_steps);
		}
	}
	
	private void growCrop(World world, BlockPos pos, IBlockState state, int steps) {	
		int currentAge = this.getCurrentAge(state);
		int newAge = currentAge + steps;
		
		// growing finish completly
		if(currentAge >= NUM_MIN_AGES_FOR_TOP && newAge >= NUM_MAX_AGE) {
				// delete both crop blocks
				world.setBlockState(pos.down(), Blocks.AIR.getDefaultState(), 0);
				world.setBlockState(pos, Blocks.AIR.getDefaultState(), 0);
				// set fern block
				Blocks.DOUBLE_PLANT.placeAt(world, pos.down(), BlockDoublePlant.EnumPlantType.FERN, 3);
		}
		// bottom growing to top
		else if(currentAge < NUM_MIN_AGES_FOR_TOP && newAge >= NUM_MIN_AGES_FOR_TOP) {
			world.setBlockState(pos, state.withProperty(CROP_AGE, NUM_MAX_AGE));
			world.setBlockState(pos.up(), this.getDefaultState().withProperty(CROP_AGE, newAge));
		}
		// normal growing 
		else {
			world.setBlockState(pos, state.withProperty(CROP_AGE, newAge), 3);
			return;
		}
	}
	
	@Override
	public boolean canBlockStay(World world, BlockPos pos, IBlockState state)
	{
		int currentAge = this.getCurrentAge(state);
		if(currentAge >= NUM_MIN_AGES_FOR_TOP && currentAge < NUM_MAX_AGE)
			return world.getBlockState(pos.down()).getBlock() == this;
		if(currentAge == NUM_MAX_AGE) {
			return world.getBlockState(pos.up()).getBlock() == this;
		}
		return super.canBlockStay(world, pos, state);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return VeganLifeItems.jute_seeds_item;
	}
	
	@Override
	public int quantityDropped(IBlockState state, int fortune, @Nonnull Random random)
	{
		return this.getCurrentAge(state) >= NUM_MIN_AGES_FOR_TOP ? 0 : 1;
	}
	
	private int getCurrentAge(IBlockState state) {
		return state.getValue(CROP_AGE);
	}
	
	private boolean isBiggerThanOneBlock(IBlockState state) {
		return this.getCurrentAge(state) >= NUM_MAX_AGE;
	}
	
	private boolean canGrow(IBlockState state) { 
		return this.getCurrentAge(state) < NUM_MAX_AGE;
	}
}
