package com.raden93.veganlife.block.enderperl;

import java.util.List;
import java.util.Random;

import com.raden93.veganlife.init.VeganLifeTabs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.BlockSnapshot;

public class FlyingEndBlock extends Block {

	public FlyingEndBlock() {
		super(Material.ROCK);
		setCreativeTab(VeganLifeTabs.veganLifeTab);
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
	
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if(worldIn.isAirBlock(pos.up())) {			
			if(pos.getY() < 240) {			
				AxisAlignedBB box = new AxisAlignedBB(pos.getX()-1, pos.getY()-1, pos.getZ()-1, pos.getX()+1, pos.getY() + 2, pos.getZ()+1 );
				List<EntityPlayer> list = worldIn.getEntitiesWithinAABB(EntityPlayer.class, box);
				for(EntityPlayer player: list) {
					player.move(MoverType.PLAYER, 0, 1, 0);
				}
								
				BlockSnapshot snapshot = BlockSnapshot.getBlockSnapshot(worldIn, pos);
				snapshot.restoreToLocation(worldIn, pos.up(), true, true);	
			}
			worldIn.setBlockToAir(pos); 
		}
	}
}
