package com.raden93.veganlife.base;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialLogic;

public class EnderRiftMaterial extends MaterialLogic {
	public EnderRiftMaterial()
	{
		super(MapColor.AIR);
		this.setImmovableMobility();
	}

}
