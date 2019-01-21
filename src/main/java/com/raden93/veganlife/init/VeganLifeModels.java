package com.raden93.veganlife.init;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class VeganLifeModels {
	@SubscribeEvent
	public static void register(ModelRegistryEvent event) {
		// Jute
		register(VeganLifeItems.jute_stalk_item);
		register(VeganLifeItems.jute_fibre_item);
		register(VeganLifeItems.jute_seeds_item);
		register(VeganLifeItems.burlap_item);
		register(Item.getItemFromBlock(VeganLifeBlocks.bale_of_jute_block));
		register(Item.getItemFromBlock(VeganLifeBlocks.jute_crop_block));
		
		// Bioplastic
		register(VeganLifeItems.potato_starch_item);
		register(VeganLifeItems.plastic_rod_item);
		register(VeganLifeItems.bioplastic_item);
		
		// Kapok Tuft
		register(VeganLifeItems.kapok_tuft_item);
		register(Item.getItemFromBlock(VeganLifeBlocks.kapok_block));
		registerColorizedItems(Item.getItemFromBlock(VeganLifeBlocks.kapok_block), VeganLifeBlocks.kapok_block);
		
		// Slimeballs
		register(VeganLifeItems.resin_item);
		register(VeganLifeItems.rosin_item);
	}
	
	private static void register(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	private static void registerColorizedItems(Item item, Block block) {
		for (EnumDyeColor color : EnumDyeColor.values()) {
			ModelLoader.setCustomModelResourceLocation(item, color.getMetadata(), new ModelResourceLocation(block.getRegistryName(), "color=" + color.getName()));
		}
	}
}
