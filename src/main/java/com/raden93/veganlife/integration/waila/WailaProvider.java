package com.raden93.veganlife.integration.waila;

import java.util.List;

import com.raden93.veganlife.block.jute.JuteCropBlock;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class WailaProvider implements IWailaDataProvider {
	
	@Override
	public List<String> getWailaHead(ItemStack itemStack, List<String> toolTip, IWailaDataAccessor accessor, IWailaConfigHandler config)
	{
		return toolTip;
	}
	
	@Override
	public List<String> getWailaTail(ItemStack itemStack, List<String> toolTip, IWailaDataAccessor accessor, IWailaConfigHandler config)
	{
		return toolTip;
	}
	
	@Override
	public abstract List<String> getWailaBody(ItemStack itemStack, List<String> toolTip, IWailaDataAccessor accessor, IWailaConfigHandler config);
	
	@Override
	public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, BlockPos pos)
	{
		return null;
	}
	
	@Override
	public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config)
	{
		return null;
	}

}
