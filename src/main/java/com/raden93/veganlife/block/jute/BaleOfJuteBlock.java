package com.raden93.veganlife.block.jute;

import java.util.Random;

import com.raden93.veganlife.VeganConfig;
import com.raden93.veganlife.init.VeganLifeItems;
import com.raden93.veganlife.init.VeganLifeTabs;
import com.raden93.veganlife.util.BlockUtil;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BaleOfJuteBlock extends BlockRotatedPillar {
	
	public static final int MAX_RETTING_STAGE = 3;
	public static final int MIN_RETTING_VALUE = 0;
	public static final PropertyInteger RETTING = PropertyInteger.create("retting", MIN_RETTING_VALUE, MAX_RETTING_STAGE);
	
	public BaleOfJuteBlock() {
		super(Material.GROUND);
		this.setTickRandomly(true);
		this.setDefaultState(this.blockState.getBaseState().withProperty(AXIS, EnumFacing.Axis.Y));
		this.setDefaultState(this.blockState.getBaseState().withProperty(RETTING, Integer.valueOf(0)));
		setCreativeTab(VeganLifeTabs.veganLifeTab);
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {AXIS, RETTING});
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		IBlockState axisState = super.getStateFromMeta(meta);
		EnumFacing.Axis axis = axisState.getValue(AXIS);
		int stage = meta & 3;
		return getDefaultState().withProperty(RETTING, stage).withProperty(AXIS, axis);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int stage = state.getValue(RETTING);
		return (super.getMetaFromState(state) & 12) + stage;
	}
	
	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
		super.updateTick(world, pos, state, random);
		int rettingValue = getRettedValue(world, pos);
		if (rettingValue < MAX_RETTING_STAGE && BlockUtil.isBlockInOrAdjacentMaterial(world, pos, Material.WATER)) {
			if(!this.isHardMode() || random.nextFloat() < 0.5) {
				int newValue = rettingValue + 1;
				if(newValue >= getMaxRettingValue()) {
					newValue = MAX_RETTING_STAGE;
				}
				IBlockState newState = world.getBlockState(pos).withProperty(RETTING, newValue);
				world.setBlockState(pos, newState);
			}
		}
	}
	
	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random)
	{
		if (state.getValue(RETTING) >= getMaxRettingValue() ) {
			// random.nextInt(0) will produce an error
			if(VeganConfig.constants.jute_fiber_random_drops == 0) {
				return VeganConfig.constants.jute_fiber_base_drops;
			}
			// return 8 - 15 drops in the default configuration. 
			return random.nextInt(VeganConfig.constants.jute_fiber_random_drops) 
					+ VeganConfig.constants.jute_fiber_base_drops;
		}
		return 1;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random random, int fortune){
		if (state.getValue(RETTING) >= getMaxRettingValue() )
			return VeganLifeItems.jute_fibre_item;
		else
			return super.getItemDropped(state, random, fortune);
	}
	
	public static float getRettingStatus(World world, BlockPos pos) {
		return ((float)getRettedValue(world, pos)) / getMaxRettingValue();
	}
	
	private static int getRettedValue(World world, BlockPos pos) {
		return world.getBlockState(pos).getValue(RETTING);
	}
	
	private static int getMaxRettingValue() {
		return VeganConfig.constants.jute_bale_retting_stages;
	}
	
	private static boolean isHardMode() {
		return VeganConfig.constants.jute_bale_retting_hardmode;
	}
}

