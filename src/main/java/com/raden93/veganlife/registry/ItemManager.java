package com.raden93.veganlife.registry;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import com.raden93.veganlife.items.JuteFibreItem;
import com.raden93.veganlife.items.JuteStackItem;
import com.raden93.veganlife.constants.RegistryNames;
import com.raden93.veganlife.constants.ModConstants;

public class ItemManager {
	
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<Item>(ForgeRegistries.ITEMS, ModConstants.MODID);

	public static final RegistryObject<Item> JUTE_STALK_ITEM = ITEMS.register(RegistryNames.JUTE_STALK_ITEM, () -> new JuteStackItem());
	public static final RegistryObject<Item> JUTE_FIBRE_ITEM = ITEMS.register(RegistryNames.JUTE_FIBRE_ITEM, () -> new JuteFibreItem());
	
	
	//BlockItems
	public static final RegistryObject<Item> JUTE_BLOCK_ITEM = ITEMS.register(RegistryNames.JUTE_BLOCK, () -> new BlockItem(BlockManager.JUTE_BLOCK.get(), (new Item.Properties())
			.group(ItemGroup.MATERIALS)));

}
