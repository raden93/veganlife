package com.raden93.veganlife.block.enderperl;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class WoodAshLyeBlock extends BlockFluidClassic {
	
	public static final DamageSource lyeDamage = new DamageSource("veganlife.lyeWater");
	public static Material lyeMaterial = Material.WATER;

	public WoodAshLyeBlock(Fluid fluid)
	{
		super(fluid, lyeMaterial);
	}

	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity collidedEntity)
	{
		if (collidedEntity instanceof EntityLivingBase)
		{
			collidedEntity.attackEntityFrom(lyeDamage, 0.25f);
		}
		super.onEntityCollidedWithBlock(world, pos, state, collidedEntity);
	}

}
