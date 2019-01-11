package com.raden93.veganlife.block.jute;

import com.raden93.veganlife.init.VeganLifeTabs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BaleOfJuteBlock extends Block {

	public BaleOfJuteBlock() {
		super(Material.GROUND);
		setCreativeTab(VeganLifeTabs.veganLifeTab);
	}
}