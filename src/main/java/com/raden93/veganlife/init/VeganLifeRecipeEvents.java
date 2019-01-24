package com.raden93.veganlife.init;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class VeganLifeRecipeEvents {
	
	@SubscribeEvent
	public void onItemCrafted(PlayerEvent.ItemCraftedEvent event)
	{
		
		if(event.crafting.getItem().equals(VeganLifeItems.vegetable_oil_item)) {
			System.out.println("crafting vegetableoil");
			return;
		}
	}

}
