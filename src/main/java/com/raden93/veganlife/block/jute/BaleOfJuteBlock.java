package com.raden93.veganlife.block.jute;

import com.raden93.veganlife.init.VeganLifeTabs;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;

public class BaleOfJuteBlock extends BlockRotatedPillar {
	
	 public static final PropertyInteger RETTING = PropertyInteger.create("retting", 0, 4);
	
	public BaleOfJuteBlock() {
		super(Material.GROUND);
		this.setDefaultState(this.blockState.getBaseState().withProperty(AXIS, EnumFacing.Axis.Y));
		this.setDefaultState(this.blockState.getBaseState().withProperty(RETTING, Integer.valueOf(0)));
		setCreativeTab(VeganLifeTabs.veganLifeTab);
	}
	
	@Override
	protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {AXIS, RETTING});
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		IBlockState axisState = super.getStateFromMeta(meta);
		EnumFacing.Axis axis = axisState.getValue(AXIS);
		int stage = meta & 3;
		return getDefaultState().withProperty(RETTING, stage).withProperty(AXIS, axis);
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		int stage = state.getValue(RETTING);
		return (super.getMetaFromState(state) & 12) + stage;
	}
}