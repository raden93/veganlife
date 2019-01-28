package com.raden93.veganlife.block.enderperl;

import com.raden93.veganlife.init.VeganLifeTabs;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fluids.Fluid;

public class RawEnderBlock extends BlockFluidFinite {
	public static Material materialRawEnder = Material.WATER;

	public RawEnderBlock(Fluid fluid)
	{
		super(fluid, materialRawEnder);
		this.setDefaultState(blockState.getBaseState().withProperty(LEVEL, 0));
		setCreativeTab(VeganLifeTabs.veganLifeTab);
	}
}
