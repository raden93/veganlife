package com.raden93.veganlife.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.Entity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class JuteBlock extends RotatedPillarBlock {
	
	public static final int MAX_RETTING_STAGE = 3;
	public static final int MIN_RETTING_VALUE = 0;
	public static final Property<Integer> RETTING = IntegerProperty.create("retting", MIN_RETTING_VALUE, MAX_RETTING_STAGE);
	
	public JuteBlock(){
		super(getDefaultProperties());
		this.setDefaultState(this.stateContainer.getBaseState().with(AXIS, Direction.Axis.Y));
		this.setDefaultState(this.stateContainer.getBaseState().with(RETTING, Integer.valueOf(0)));
	}
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
	      builder.add(AXIS);
	      builder.add(RETTING);
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
	      return this.getDefaultState().with(AXIS, context.getFace().getAxis()).with(RETTING, Integer.valueOf(0));
	}
	
	/**
	 * Block's chance to react to a living entity falling on it.
	 */
	public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
	   entityIn.onLivingFall(fallDistance, 0.2F);
	}
	
	private static Block.Properties getDefaultProperties() {
		return Block.Properties.create(
				Material.ORGANIC, 
				MaterialColor.GREEN
			)
			.hardnessAndResistance(0.5F)
			.sound(SoundType.PLANT)
			.tickRandomly();
	}
}
