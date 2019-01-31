package com.raden93.veganlife.init;

import com.raden93.veganlife.VeganLifeConstants;
import com.raden93.veganlife.block.enderperl.EncrustedObsidianBlock;
import com.raden93.veganlife.block.enderperl.EnderRiftBlock;
import com.raden93.veganlife.block.enderperl.RawEnderBlock;
import com.raden93.veganlife.block.enderperl.RawEnderFluid;
import com.raden93.veganlife.block.enderperl.WoodAshLyeBlock;
import com.raden93.veganlife.block.enderperl.WoodAshLyeFluid;
import com.raden93.veganlife.block.jute.BaleOfJuteBlock;
import com.raden93.veganlife.block.jute.JuteCropBlock;
import com.raden93.veganlife.block.wool.KapokBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemCloth;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class VeganLifeBlocks {

	public static final BaleOfJuteBlock bale_of_jute_block = new BaleOfJuteBlock();
	public static final JuteCropBlock jute_crop_block = new JuteCropBlock();
	public static final KapokBlock kapok_block = new KapokBlock(Material.CLOTH);
	
	//Ender
	public static final RawEnderFluid raw_ender_fluid = new RawEnderFluid();
	public static final WoodAshLyeFluid wood_ash_lye_fluid = new WoodAshLyeFluid();
	public static RawEnderBlock raw_ender_block;
	public static WoodAshLyeBlock wood_ash_lye_block;
	public static final EncrustedObsidianBlock encrusted_obsidian_block = new EncrustedObsidianBlock();
	public static final EnderRiftBlock ender_rift_block = new EnderRiftBlock();
	
	
	public static void init() {
		FluidRegistry.registerFluid(raw_ender_fluid);
		FluidRegistry.registerFluid(wood_ash_lye_fluid);
		
		raw_ender_block = new RawEnderBlock(raw_ender_fluid);
		raw_ender_fluid.setBlock(raw_ender_block);
		FluidRegistry.addBucketForFluid(raw_ender_fluid);
		
		wood_ash_lye_block = new WoodAshLyeBlock(wood_ash_lye_fluid);
		wood_ash_lye_fluid.setBlock(wood_ash_lye_block);
		FluidRegistry.addBucketForFluid(wood_ash_lye_fluid);
		
		setName(bale_of_jute_block, "baleofjute");
		setName(jute_crop_block, "jutecrop");
		setName(kapok_block, "kapok");
		setName(raw_ender_block, "rawender");
		setName(wood_ash_lye_block, "woodashlye");
		setName(encrusted_obsidian_block, "encurstedobsidian");
		setName(ender_rift_block, "enderrift");
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
		registry.register(wood_ash_lye_block);
		registry.register(encrusted_obsidian_block);
		registry.register(ender_rift_block);
	}
	
	@SubscribeEvent
	public static void registerItem(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();
		registry.register(new ItemBlock(bale_of_jute_block).setRegistryName(bale_of_jute_block.getRegistryName()));
		registry.register(new ItemBlock(jute_crop_block).setRegistryName(jute_crop_block.getRegistryName()));
		registry.register(new ItemCloth(kapok_block).setRegistryName(kapok_block.getRegistryName()));
		registry.register(new ItemBlock(raw_ender_block).setRegistryName(raw_ender_block.getRegistryName()));
		registry.register(new ItemBlock(wood_ash_lye_block).setRegistryName(wood_ash_lye_block.getRegistryName()));
		registry.register(new ItemBlock(encrusted_obsidian_block).setRegistryName(encrusted_obsidian_block.getRegistryName()));
		registry.register(new ItemBlock(ender_rift_block).setRegistryName(ender_rift_block.getRegistryName()));
	}
	
	
	
}
