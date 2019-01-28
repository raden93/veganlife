package com.raden93.veganlife.init;

import com.raden93.veganlife.VeganLifeConstants;
import com.raden93.veganlife.block.enderperl.RawEnderBlock;
import com.raden93.veganlife.block.enderperl.RawEnderFluid;
import com.raden93.veganlife.block.jute.BaleOfJuteBlock;
import com.raden93.veganlife.block.jute.JuteCropBlock;
import com.raden93.veganlife.block.wool.KapokBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemCloth;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class VeganLifeBlocks {

	public static final BaleOfJuteBlock bale_of_jute_block = new BaleOfJuteBlock();
	public static final JuteCropBlock jute_crop_block = new JuteCropBlock();
	public static final KapokBlock kapok_block = new KapokBlock(Material.CLOTH);
	public static RawEnderBlock raw_ender_block;
	
	//Ender
	public static final RawEnderFluid raw_ender_fluid = new RawEnderFluid();
	
	public static void init() {
		FluidRegistry.registerFluid(raw_ender_fluid);
		
		raw_ender_block = new RawEnderBlock(raw_ender_fluid);
		raw_ender_fluid.setBlock(raw_ender_block);
		
		setName(bale_of_jute_block, "baleofjute");
		setName(jute_crop_block, "jutecrop");
		setName(kapok_block, "kapok");
		setName(raw_ender_block, "rawender");
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
		registry.register(kapok_block);
		registry.register(raw_ender_block);
	}
	
	@SubscribeEvent
	public static void registerItem(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();
		registry.register(new ItemBlock(bale_of_jute_block).setRegistryName(bale_of_jute_block.getRegistryName()));
		registry.register(new ItemBlock(jute_crop_block).setRegistryName(jute_crop_block.getRegistryName()));
		registry.register(new ItemCloth(kapok_block).setRegistryName(kapok_block.getRegistryName()));
		registry.register(new ItemBlock(raw_ender_block).setRegistryName(raw_ender_block.getRegistryName()));
	}
	
	
	
}
