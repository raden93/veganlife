package com.raden93.veganlife.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class VeganLifeRecipeEvents {
	
	@SubscribeEvent
	public void onItemCrafted(PlayerEvent.ItemCraftedEvent event)
	{
		this.stayInputForOutput(new ItemStack(Blocks.PISTON), new ItemStack(VeganLifeItems.vegetable_oil_item), event);
		this.stayInputForOutput(new ItemStack(Blocks.PISTON), new ItemStack(VeganLifeItems.potato_starch_item), event);
		this.deleteBucketWhenCraftingBucket(FluidUtil.getFilledBucket(new FluidStack(VeganLifeBlocks.wood_ash_lye_fluid, 1)), event);
	}
	
	private void stayInputForOutput(ItemStack input, ItemStack output, PlayerEvent.ItemCraftedEvent event) {
		if(event.crafting.getItem().equals(output.getItem())) {
			for(int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
				ItemStack stackInSlot = event.craftMatrix.getStackInSlot(i);
				if(stackInSlot.getItem() == input.getItem() ) {
					stackInSlot.grow(1);
				}
			}
		}
	}
	
	private void deleteBucketWhenCraftingBucket(ItemStack output, PlayerEvent.ItemCraftedEvent event) {
		if(event.crafting.getItem().equals(output.getItem())) {
			for(int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
				ItemStack stackInSlot = event.craftMatrix.getStackInSlot(i);
				if(stackInSlot.getItem() == Items.WATER_BUCKET ) {
					stackInSlot.setCount(0);
				}
			}
		}
	}
}
