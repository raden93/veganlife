package com.raden93.veganlife.block.jute;

import com.raden93.veganlife.init.VeganLifeTabs;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.util.EnumFacing;

public class BaleOfJuteBlock extends BlockRotatedPillar {
	public BaleOfJuteBlock() {
		super(Material.GROUND);
		this.setDefaultState(this.blockState.getBaseState().withProperty(AXIS, EnumFacing.Axis.Y));
		setCreativeTab(VeganLifeTabs.veganLifeTab);
	}
}