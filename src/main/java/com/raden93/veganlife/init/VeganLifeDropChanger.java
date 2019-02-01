package com.raden93.veganlife.init;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockStone;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class VeganLifeDropChanger {
	
	private HashMap<Item, ItemStack> newDropsPerBlock = new HashMap<Item, ItemStack>();
	private HashMap<ItemStack, Float > dropRatePerItem = new HashMap<ItemStack, Float>();
	private HashMap<ItemStack, Integer> dropsPerItem = new HashMap<ItemStack, Integer>();
	
	public static final float KAPOK_TUFT_DROP_RATE = 0.07f;
	public static final float RESIN_DROP_RATE = 0.1f;
	public static final float SULFUR_DROP_RATE = 0.02f;
	public static final float SALTPETER_DROP_RATE = 0.02f;
	public static final float BONES_DROP_RATE = 0.01f;
	public static final float FRAGMENT_OF_SUFFERING_DROP_RATE = 0.05f;
	public static final float FALSE_MOREL_DROP_RATE = 0.15f;
	
	public VeganLifeDropChanger() {
		// Add drop Sulfur from Netherrack
		this.addNewDrops(new ItemStack(VeganLifeItems.sulfur_item), new ItemStack(Blocks.NETHERRACK),
				SULFUR_DROP_RATE, 1);
		
		// Add drop Saltpeter from Sandstone
		this.addNewDrops(new ItemStack(VeganLifeItems.saltpeter_item), new ItemStack(Blocks.SANDSTONE),
				SALTPETER_DROP_RATE, 1);
		
		// Add drop Fragment of Suffering from Soul Sand
		this.addNewDrops(new ItemStack(VeganLifeItems.fragment_of_suffering_item), new ItemStack(Blocks.SOUL_SAND),
				FRAGMENT_OF_SUFFERING_DROP_RATE, 2);		
		
		// Add drop False Morel from Mycelium
		this.addNewDrops(new ItemStack(VeganLifeItems.flase_morel_item), new ItemStack(Blocks.MYCELIUM),
				FALSE_MOREL_DROP_RATE, 1);
	}
	
	private void addNewDrops(ItemStack newDrop, ItemStack dropsFrom, float dropRate, int dropsRange) {
		this.newDropsPerBlock.put(dropsFrom.getItem(), newDrop);
		this.dropRatePerItem.put(newDrop, dropRate);
		this.dropsPerItem.put(newDrop, dropsRange);
	}
	
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
			this.dropsSunflowerSeedsFromSunflowsers(block, state, random, drops);
		}
		this.dropsResinFromSpruceWood(block, state, random, drops);
		this.dropsBonesFromStone(block, state, random, drops);
		this.addDropForItem(block, random, drops);
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
	
	
	/**
	 * Strone drops Bones now
	 */
	private void dropsBonesFromStone(Block block, IBlockState state, Random random, List<ItemStack> drops) {
		if(block == Blocks.STONE && state.getValue(BlockStone.VARIANT) == BlockStone.EnumType.STONE) {
			if(random.nextFloat() < BONES_DROP_RATE) {
				drops.add(new ItemStack(Items.BONE));
			}
		}
	}
	
	private void addDropForItem(Block block, Random random, List<ItemStack> drops) {
		ItemStack dropedItem = newDropsPerBlock.get(new ItemStack(block).getItem());
		if(dropedItem != null && random.nextFloat() < dropRatePerItem.get(dropedItem)) {
			dropedItem.setCount(random.nextInt(dropsPerItem.get(dropedItem)) + 1);
			drops.add(dropedItem);
		}
	}
	
	private void dropsDollsEyeFromGras(Block block, IBlockState state, Random random, List<ItemStack> drops) {
		
	}
	
	private void dropsSunflowerSeedsFromSunflowsers(Block block, IBlockState state, Random random, List<ItemStack> drops) {
		if(block == Blocks.DOUBLE_PLANT && state.getValue(BlockDoublePlant.VARIANT) == BlockDoublePlant.EnumPlantType.SUNFLOWER) {
			drops.add(new ItemStack(VeganLifeItems.sunflower_seeds_item, 1));
		}
	}
	
	private boolean userUseShears(HarvestDropsEvent event) { 
		return event.getHarvester() != null
				&& event.getHarvester().getHeldItemMainhand() != null
				&& event.getHarvester().getHeldItemMainhand().getItem() instanceof ItemShears;
	}
}
