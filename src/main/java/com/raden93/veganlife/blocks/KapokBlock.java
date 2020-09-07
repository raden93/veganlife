package com.raden93.veganlife.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class KapokBlock extends Block {
	
	public KapokBlock(){
		super(getDefaultProperties());
	}
	
	private static Block.Properties getDefaultProperties() {
		return Block.Properties.create(
				Material.WOOL, 
				MaterialColor.WOOL
			)
			.hardnessAndResistance(0.8F)
			.sound(SoundType.CLOTH);
	}

}
