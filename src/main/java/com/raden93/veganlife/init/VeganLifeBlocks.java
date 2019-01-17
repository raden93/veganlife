package com.raden93.veganlife.init;

import com.raden93.veganlife.VeganLifeConstants;
import com.raden93.veganlife.block.jute.BaleOfJuteBlock;
import com.raden93.veganlife.block.jute.JuteCropBlock;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class VeganLifeBlocks {

	public static final BaleOfJuteBlock bale_of_jute_block = new BaleOfJuteBlock();
	public static final JuteCropBlock jute_crop_block = new JuteCropBlock();
	
	public static void init() {
		setName(bale_of_jute_block, "baleofjute");
		setName(jute_crop_block, "jutecrop");
	}
	
	private static void setName(Block block, String name) {
		block.setRegistryName(new ResourceLocation(VeganLifeConstants.MODID, name));
		block.setUnlocalizedName(name);
	}
	
	@SubscribeEvent
	public static void register(RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> registry = event.getRegistry();
		registry.register(bale_of_jute_block);
		registry.register(jute_crop_block);
	}
	
	@SubscribeEvent
	public static void registerItem(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();
		registry.register(new ItemBlock(bale_of_jute_block).setRegistryName(bale_of_jute_block.getRegistryName()));
		registry.register(new ItemBlock(jute_crop_block).setRegistryName(jute_crop_block.getRegistryName()));
	}
	
}
