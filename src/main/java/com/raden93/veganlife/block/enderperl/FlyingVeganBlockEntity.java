package com.raden93.veganlife.block.enderperl;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FlyingVeganBlockEntity extends Entity {
	
	private IBlockState fallTile;
	protected static final DataParameter<BlockPos> ORIGIN = EntityDataManager.<BlockPos>createKey(EntityFallingBlock.class, DataSerializers.BLOCK_POS);

	public FlyingVeganBlockEntity(World worldIn, double x, double y, double z, IBlockState flyingBlockState) {
		super(worldIn);
		
		this.fallTile = flyingBlockState;
		this.setSize(0.98F, 0.98F);
        this.setPosition(x, y + (double)((1.0F - this.height) / 2.0F), z);
		this.setOrigin(new BlockPos(this));
	}
	
	public void setOrigin(BlockPos p_184530_1_)
    {
        this.dataManager.set(ORIGIN, p_184530_1_);
    }
	
	@Override
	public void onUpdate() {
		System.out.println("update");
		if (this.fallTile.getMaterial() == Material.AIR)
        {
            this.setDead();
        }
		else {
			double motionY = 0.03999999910593033D;
			this.move(MoverType.SELF, 0, motionY, 0);
		}
	}

	@Override
	protected void entityInit() {
		this.dataManager.register(ORIGIN, BlockPos.ORIGIN);	
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound) {
		Block block = this.fallTile != null ? this.fallTile.getBlock() : Blocks.AIR;
		ResourceLocation resourcelocation = Block.REGISTRY.getNameForObject(block);
        compound.setString("Block", resourcelocation == null ? "" : resourcelocation.toString());	
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void writeEntityToNBT(NBTTagCompound compound) {
		int i = compound.getByte("Data") & 255;
		
		if (compound.hasKey("Block", 8))
        {
            this.fallTile = Block.getBlockFromName(compound.getString("Block")).getStateFromMeta(i);
        }
		
	}

}
