package com.raden93.veganlife.block.enderperl;

import java.util.List;
import java.util.Random;

import com.raden93.veganlife.init.VeganLifeItems;
import com.raden93.veganlife.init.VeganLifeTabs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.BlockSnapshot;

public class FlyingEndBlock extends Block {
	
	public static final int MIN_MOVES_VALUE = 0;
	public static final int MAX_MOVES_VALUE = 7;
	public static final PropertyInteger MOVES = PropertyInteger.create("moves", MIN_MOVES_VALUE, MAX_MOVES_VALUE);

	public FlyingEndBlock() {
		super(Material.GROUND);
		setCreativeTab(VeganLifeTabs.veganLifeTab);
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] { MOVES });
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		int stage = meta & 7;
		return getDefaultState().withProperty(MOVES, stage);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int stage = state.getValue(MOVES);
		return stage;
	}
	
	
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
    }
	
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
    }
	
    /**
     * How many world ticks before ticking
     */
    public int tickRate(World worldIn)
    {
        return 10;
    }
    
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
    	int moves = state.getValue(MOVES);
		if (rand.nextFloat() < ((float)moves/20.0))
			return Items.SHULKER_SHELL;
		else
			return null;
	}
	
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if(worldIn.isAirBlock(pos.up())) {			
			if(pos.getY() < 240) {
				// Push player up, when he is on the block
				AxisAlignedBB box = new AxisAlignedBB(pos.getX()-1, pos.getY()-1, pos.getZ()-1, pos.getX()+1, pos.getY() + 2, pos.getZ()+1 );
				List<EntityPlayer> list = worldIn.getEntitiesWithinAABB(EntityPlayer.class, box);
				for(EntityPlayer player: list) {
					player.move(MoverType.PLAYER, 0, 1, 0);
				}
				
				// raise moved blocks count
				int moves = state.getValue(MOVES);
				if(moves < MAX_MOVES_VALUE) {
					this.setMoves(worldIn, pos, moves + 1);
				}
					
				// save block and restore on next positon up;
				BlockSnapshot snapshot = BlockSnapshot.getBlockSnapshot(worldIn, pos);
				snapshot.restoreToLocation(worldIn, pos.up(), true, true);
			}
			worldIn.setBlockToAir(pos); 
		}
	}
	
	private void setMoves(World world, BlockPos pos, int value) {
		IBlockState newState = world.getBlockState(pos).withProperty(MOVES, value);
		world.setBlockState(pos, newState);
	}
}
