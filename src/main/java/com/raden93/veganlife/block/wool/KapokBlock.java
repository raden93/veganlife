package com.raden93.veganlife.block.wool;

import com.raden93.veganlife.init.VeganLifeTabs;

import net.minecraft.block.BlockColored;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class KapokBlock extends BlockColored {
	
	public KapokBlock(Material materialIn) {
		super(materialIn);
		setSoundType(SoundType.CLOTH);
		setHardness(0.8F);
		setCreativeTab(VeganLifeTabs.veganLifeTab);
	}

}
