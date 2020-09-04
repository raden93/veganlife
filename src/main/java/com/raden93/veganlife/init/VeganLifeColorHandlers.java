package com.raden93.veganlife.init;

import com.raden93.veganlife.block.jute.BaleOfJuteColorHandler;
import com.raden93.veganlife.block.jute.JuteCropColorHandler;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;

public class VeganLifeColorHandlers {
	
	public static void init() {
		BaleOfJuteColorHandler handler = new BaleOfJuteColorHandler();
		registerBlock(handler,handler, VeganLifeBlocks.bale_of_jute_block);
		JuteCropColorHandler juteCropHandler = new JuteCropColorHandler();
		registerBlock(juteCropHandler, juteCropHandler, VeganLifeBlocks.jute_crop_block);
	}
	
	private static void registerBlock(IBlockColor blockHandler, IItemColor colorHandler,  Block block) {
		Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(blockHandler, block);
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(colorHandler, block);
	}

}
