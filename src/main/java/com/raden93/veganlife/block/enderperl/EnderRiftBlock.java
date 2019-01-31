package com.raden93.veganlife.block.enderperl;

import com.raden93.veganlife.base.EnderRiftMaterial;
import com.raden93.veganlife.util.BlockUtil;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEndPortal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EnderRiftBlock extends BlockEndPortal  {
	
	public static final int NAUSEA_LENGTH_IN_SECONDS = 5;
	public static final int TICKS_PER_SEC = 20;

	public EnderRiftBlock() {
		super(new EnderRiftMaterial());
		setTickRandomly(true);
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
	
	private void checkPortalIsStable(World worldIn, BlockPos pos) {
		if (!BlockUtil.isValidPortalLocation(worldIn, pos)) {
			worldIn.setBlockToAir(pos);
		}
	}

}
