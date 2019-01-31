package com.raden93.veganlife.block.enderperl;

import java.util.Random;

import com.raden93.veganlife.base.EnderRiftMaterial;
import com.raden93.veganlife.init.VeganLifeBlocks;
import com.raden93.veganlife.util.BlockUtil;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEndPortal;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;

public class EnderRiftBlock extends BlockEndPortal {
	
	public static final int NAUSEA_LENGTH_IN_SECONDS = 5;
	public static final int TICKS_PER_SEC = 20;

	public EnderRiftBlock() {
		super(new EnderRiftMaterial());
		setTickRandomly(true);
		setHardness(-1.0F);
		setResistance(6000000.0F);
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
		checkPortalIsStable(worldIn, pos);
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity)
	{
		if (entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) entity;
			player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, TICKS_PER_SEC * NAUSEA_LENGTH_IN_SECONDS));
		}
	}
	
	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
		if(this.isReplaceable(world, pos.down()) 
				&& BlockUtil.isBlockGivenMaterial(world, pos.up(), Material.WATER))
		{
			BlockPos waterSource = BlockUtil.findWaterSource(world, pos.up());
			if(waterSource != null) {
				world.setBlockToAir(waterSource);
				if(!world.isDaytime()) {
					world.setBlockState(pos.down(), VeganLifeBlocks.raw_ender_block.getDefaultState().withProperty(BlockFluidBase.LEVEL, 7));
				}
				else {
					//TODO: Remove random Block when run on daytime
				}
			}
			
		}
	}
	
	private void checkPortalIsStable(World worldIn, BlockPos pos) {
		if (!BlockUtil.isValidPortalLocation(worldIn, pos)) {
			worldIn.setBlockToAir(pos);
		}
	}

}
