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
		
		// Mining drops
		register(VeganLifeItems.saltpeter_item);
		register(VeganLifeItems.sulfur_item);
		
		// Mob Items
		register(VeganLifeItems.dolls_eye_item);
		register(VeganLifeItems.fragment_of_suffering_item);
		register(VeganLifeItems.proof_of_suffering_item);
		register(VeganLifeItems.faux_feather_item);
		
		// Vegetable oil
		register(VeganLifeItems.sunflower_seeds_item);
		register(VeganLifeItems.vegetable_oil_item);
		register(VeganLifeItems.vegetable_wax_item);
		register(VeganLifeItems.vegetable_oil_ink_item, 0, "_black");
		register(VeganLifeItems.vegetable_oil_ink_item, 1, "_white");
		
		// Enderperl
		register(VeganLifeItems.soap_item);
		register(VeganLifeItems.soap_solution_item);
		register(VeganLifeItems.frozen_bubble_item);
	}
	
	private static void register(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	private static void register(Item item, int metadata, String variantName) {
		ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(item.getRegistryName() + variantName, "inventory"));
	}
	
	private static void registerColorizedItems(Item item, Block block) {
		for (EnumDyeColor color : EnumDyeColor.values()) {
			ModelLoader.setCustomModelResourceLocation(item, color.getMetadata(), new ModelResourceLocation(block.getRegistryName(), "color=" + color.getName()));
		}
	}
}
