package com.raden93.veganlife.init;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.raden93.veganlife.config.VeganConfig;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockStone;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class VeganLifeDropChanger {
	
	private HashMap<Item, ItemStack> newDropsPerBlock = new HashMap<Item, ItemStack>();
	private HashMap<ItemStack, Double > dropRatePerItem = new HashMap<ItemStack, Double>();
	private HashMap<ItemStack, Integer> dropsPerItem = new HashMap<ItemStack, Integer>();
	
	public static final double KAPOK_TUFT_DROP_RATE = VeganConfig.OTHER_CONSTANTS.DROPCHANCE_KAPOK_FROM_JUNGLE;
	public static final double RESIN_DROP_RATE = VeganConfig.OTHER_CONSTANTS.DROPCHANCE_RESIN_FROM_SPRUCE;
	public static final double SULFUR_DROP_RATE = VeganConfig.OTHER_CONSTANTS.DROPCHANCE_SULFUR_FROM_NEATHERRACK;
	public static final double SALTPETER_DROP_RATE = VeganConfig.OTHER_CONSTANTS.DROPCHANCE_SALTPETER_FROM_SANDSTONE;
	public static final double BONES_DROP_RATE = VeganConfig.OTHER_CONSTANTS.DROPCHANCE_BONE_FROM_STONE;
	public static final double FRAGMENT_OF_SUFFERING_DROP_RATE = VeganConfig.OTHER_CONSTANTS.DROPCHANCE_FRAGMENT_FROM_SOULSAND;
	public static final double FALSE_MOREL_DROP_RATE = VeganConfig.OTHER_CONSTANTS.DROPCHANCE_FALSE_MOREL_FROM_MYCELIUM;
	public static final double DOLLS_EYE_DROP_RATE = VeganConfig.OTHER_CONSTANTS.DROPCHANCE_DOLLS_EYE_FROM_GRAS;
	
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
	
	private void addNewDrops(ItemStack newDrop, ItemStack dropsFrom, double dropRate, int dropsRange) {
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
		this.dropsDollsEyeFromGras(event.getWorld(), event.getPos(), block, state, random, drops);
		this.addDropForItem(block, random, drops);
	}
	
	/**
	 * Fern now drops 1-3 Jute Stalks
	 */
	private void dropJuteFromFerns(Block block, IBlockState state, Random random, List<ItemStack> drops) {
		if(block == Blocks.DOUBLE_PLANT && state.getValue(BlockDoublePlant.VARIANT) == BlockDoublePlant.EnumPlantType.FERN) {
			// Random value 0 will produce an error.
			int randomValue = VeganConfig.JUTE_CONSTANTS.JUTE_STALK_RANDOM_DROPS > 0 ? 
					random.nextInt(VeganConfig.JUTE_CONSTANTS.JUTE_STALK_RANDOM_DROPS) : 0;
			drops.add(new ItemStack(VeganLifeItems.jute_stalk_item, randomValue + VeganConfig.JUTE_CONSTANTS.JUTE_STALK_BASE_DROPS));
		}
	}
	
	/**
	 * Jungle leaves drops kapok tuft now 
	 */
	private void dropKapokFromJungle(Block block, IBlockState state, Random random, List<ItemStack> drops) {
		if(block == Blocks.LEAVES && state.getValue(BlockOldLeaf.VARIANT) == BlockPlanks.EnumType.JUNGLE) {
			if(random.nextDouble() < KAPOK_TUFT_DROP_RATE) {
				drops.add(new ItemStack(VeganLifeItems.kapok_tuft_item, 1));
			}
		}
	}
	
	/**
	 * Spruce Wood drops Resin now
	 */
	private void dropsResinFromSpruceWood(Block block, IBlockState state, Random random, List<ItemStack> drops) {
		if(block == Blocks.LOG && state.getValue(BlockOldLog.VARIANT) == BlockPlanks.EnumType.SPRUCE) {
			if(random.nextDouble() < RESIN_DROP_RATE) {
				drops.add(new ItemStack(VeganLifeItems.resin_item));
			}
		}
	}
	
	
	/**
	 * Strone drops Bones now
	 */
	private void dropsBonesFromStone(Block block, IBlockState state, Random random, List<ItemStack> drops) {
		if(block == Blocks.STONE && state.getValue(BlockStone.VARIANT) == BlockStone.EnumType.STONE) {
			if(random.nextDouble() < BONES_DROP_RATE) {
				drops.add(new ItemStack(Items.BONE));
			}
		}
	}
	
	private void addDropForItem(Block block, Random random, List<ItemStack> drops) {
		ItemStack dropedItem = newDropsPerBlock.get(new ItemStack(block).getItem());
		if(dropedItem != null && random.nextDouble() < dropRatePerItem.get(dropedItem)) {
			dropedItem.setCount(random.nextInt(dropsPerItem.get(dropedItem)) + 1);
			drops.add(dropedItem);
		}
	}
	
	private void dropsDollsEyeFromGras(World world, BlockPos pos, Block block, IBlockState state, Random random, List<ItemStack> drops) {
		if(block.equals(Blocks.TALLGRASS) && state.getValue(BlockTallGrass.TYPE) == BlockTallGrass.EnumType.GRASS) {
			Biome biome = world.getBiome(pos);
			if(BiomeDictionary.hasType(biome, BiomeDictionary.Type.FOREST) 
					&& !BiomeDictionary.hasType(biome, BiomeDictionary.Type.CONIFEROUS)
					&& !BiomeDictionary.hasType(biome, BiomeDictionary.Type.JUNGLE)) {
				if(random.nextDouble() < DOLLS_EYE_DROP_RATE)
					drops.add(new ItemStack(VeganLifeItems.dolls_eye_item, 1));
			}
		}
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
