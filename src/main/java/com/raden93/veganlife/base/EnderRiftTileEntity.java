package com.raden93.veganlife.base;

import net.minecraft.tileentity.TileEntityEndPortal;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EnderRiftTileEntity extends TileEntityEndPortal {
	
	@Override
	@SideOnly(Side.CLIENT)
    public boolean shouldRenderFace(EnumFacing p_184313_1_)
    {
        return p_184313_1_ == EnumFacing.UP || p_184313_1_ == EnumFacing.DOWN;
    }

}
