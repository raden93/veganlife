package com.raden93.veganlife.init;

import java.util.Random;

import com.raden93.veganlife.VeganLifeMod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class VeganLifeDropChanger {
	
	@SubscribeEvent
	public void onHarvestBlock(HarvestDropsEvent event)
	{
		this.dropJuteFromFerns(event);
	}
	
	/**
	 * Fern now drops 1-3 Jute Stalks
	 * @param event
	 */
	private void dropJuteFromFerns(HarvestDropsEvent event) {
		IBlockState state = event.getState();
		Block block = state.getBlock();
		Random rnd = new Random();
		
		if(block == Blocks.DOUBLE_PLANT && state.getValue(BlockDoublePlant.VARIANT) == BlockDoublePlant.EnumPlantType.FERN) {
			event.getDrops().add(new ItemStack(VeganLifeItems.jute_stalk_item, rnd.nextInt(2)+1));
		}
	}
}
