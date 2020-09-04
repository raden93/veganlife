package com.raden93.veganlife.block.enderperl;

import com.raden93.veganlife.base.CustomFluid;

import net.minecraft.util.ResourceLocation;

public class RawEnderFluid extends CustomFluid {

	public RawEnderFluid() {
		super("rawender", new ResourceLocation("veganlife:blocks/rawender_still"), new ResourceLocation("veganlife:blocks/rawender_flow"));
		setLuminosity(3);
		setViscosity(3000);
		setDensity(4000);
	}

}

//http://jabelarminecraft.blogspot.com/p/minecraft-modding-custom-fluids.html?m=1