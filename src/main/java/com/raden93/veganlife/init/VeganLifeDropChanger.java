package com.raden93.veganlife.init;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class VeganLifeDropChanger {
	
	public static final float KAPOK_TUFT_DROP_RATE = 0.07f;
	public static final float RESIN_DROP_RATE = 0.1f;
	
	@SubscribeEvent
	public void onHarvestBlock(HarvestDropsEvent event)
	{
		IBlockState state = event.getState();
		Block block = state.getBlock();
		Random random = new Random();
		List<ItemStack> drops = event.getDrops();
		
		if(!this.userUseShears(event)) {
			this.dropJuteFromFerns(block, state, random, drops);
			this.dropKapokFromJungle(block, state, random, drops);
		}
		this.dropsResinFromSpruceWood(block, state, random, drops);
	}
	
	/**
	 * Fern now drops 1-3 Jute Stalks
	 */
	private void dropJuteFromFerns(Block block, IBlockState state, Random random, List<ItemStack> drops) {
		if(block == Blocks.DOUBLE_PLANT && state.getValue(BlockDoublePlant.VARIANT) == BlockDoublePlant.EnumPlantType.FERN) {
			drops.add(new ItemStack(VeganLifeItems.jute_stalk_item, random.nextInt(2)+1));
		}
	}
	
	/**
	 * Jungle leaves drops kapok tuft now 
	 */
	private void dropKapokFromJungle(Block block, IBlockState state, Random random, List<ItemStack> drops) {
		if(block == Blocks.LEAVES && state.getValue(BlockOldLeaf.VARIANT) == BlockPlanks.EnumType.JUNGLE) {
			if(random.nextFloat() < KAPOK_TUFT_DROP_RATE) {
				drops.add(new ItemStack(VeganLifeItems.kapok_tuft_item, 1));
			}
		}
	}
	
	/**
	 * Spruce Wood drops Resin now
	 */
	private void dropsResinFromSpruceWood(Block block, IBlockState state, Random random, List<ItemStack> drops) {
		if(block == Blocks.LOG && state.getValue(BlockOldLog.VARIANT) == BlockPlanks.EnumType.SPRUCE) {
			if(random.nextFloat() < RESIN_DROP_RATE) {
				drops.add(new ItemStack(VeganLifeItems.resin_item));
			}
		}
	}
	
	private boolean userUseShears(HarvestDropsEvent event) { 
		return event.getHarvester() != null
				&& event.getHarvester().getHeldItemMainhand() != null
				&& event.getHarvester().getHeldItemMainhand().getItem() instanceof ItemShears;
	}
}
