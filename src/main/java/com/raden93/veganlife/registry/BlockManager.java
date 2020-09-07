package com.raden93.veganlife.registry;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import com.raden93.veganlife.blocks.JuteBlock;
import com.raden93.veganlife.blocks.KapokBlock;
import com.raden93.veganlife.constants.RegistryNames;
import com.raden93.veganlife.constants.ModConstants;

public class BlockManager {

	public static final Block KAPOK_BLOCK = new KapokBlock();
	
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ModConstants.MODID);
	public static final RegistryObject<Block> JUTE_BLOCK = BLOCKS.register(RegistryNames.JUTE_BLOCK, () -> new JuteBlock());

	
	/*
	 * @SubscribeEvent public static void registerItem(RegistryEvent.Register<Item>
	 * event) { event.getRegistry().register(new BlockItem(JUTE_BLOCK, (new
	 * Item.Properties()) .group(ItemGroup.MATERIALS))
	 * .setRegistryName(JUTE_BLOCK.getRegistryName()));
	 * 
	 * event.getRegistry().register(new BlockItem(KAPOK_BLOCK, (new
	 * Item.Properties()) .group(ItemGroup.MATERIALS))
	 * .setRegistryName(KAPOK_BLOCK.getRegistryName())); }
	 */
}


